package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.ClaimPerilRevisionDto;
import com.turnquest.setupsdemo.exception.ResourceNotFoundException;
import com.turnquest.setupsdemo.model.*;
import com.turnquest.setupsdemo.repository.*;
import com.turnquest.setupsdemo.service.CurrencyService;
import com.turnquest.setupsdemo.service.ExcessConditionService;
import com.turnquest.setupsdemo.service.GinClaimService;
import com.turnquest.setupsdemo.service.RevisionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RevisionServiceImpl implements RevisionService {


    private GinClaimMasterBookingsRepository claimMasterBookingRepository;
    private GinClaimPerilsRepository claimPerilRepository;
    private GinClaimPerilExcessesRepository claimPerilExcessRepository;
    private GinClaimTreatyCessionsRepository claimTreatyCessionRepository;
    private GinClaimReinPoolCessionsRepository claimReinPoolCessionRepository;
    private GinRiPoolSubclPerilsRepository riPoolSubclPerilRepository;
    private GinClaimCoinsurersRepository claimCoinsurerRepository;
    private GinClaimFacreCessionsRepository claimFacreCessionRepository;
    private GinClaimRevisionsRepository claimRevisionRepository;
    private GinClmCoinReservesRepository clmCoinReserveRepository;
    private GinClmTreatyReserveCededRepository clmTreatyReserveCededRepository;
    private GinClmFacreReserveCededRepository clmFacreReserveCededRepository;
    private GinClmRiPoolReserveCededRepository clmRiPoolReserveCededRepository;
    private GinPerilRevisionsRepository perilRevisionRepository;
    private GinBusinessTransactionsRepository businessTransactionRepository;
    private GinBpmTicketsRepository bpmTicketRepository;
    private Jbpm4HistTaskGisRepository jbpm4HistTaskGisRepository;
    private Jbpm4TaskGisRepository jbpm4TaskGisRepository;
//    private ClassTreatyRepository classTreatyRepository;
    private GinArrangementSetupsRepository arrangementSetupRepository;
    private GinTreatySetupsRepository treatySetupRepository;
//    private TreatyRepository treatyRepository;
    private GinClaimService claimService;
    private CurrencyService currencyService;
    private final GinClaimPerilExcessesRepository claimPerilExcessesRepository;
    private final GinClaimPerilsRepository claimPerilsRepository;
    private final GinRgstdClaimantsRepository claimantsRepository;
    private final ExcessConditionService excessConditionService;

    private final BigDecimal ROUNDING_SCALE = new BigDecimal("2");

    // Placeholder for external functions
    private BigDecimal getOsReserve(String claimNo) {
        // Implement logic to retrieve outstanding reserve for a claim
        return claimService.getOsReserve(claimNo, "Y"); // Replace with actual logic
    }

    private BigDecimal getCurrexchRate(BigDecimal curCode, BigDecimal rnd, BigDecimal bcurRnd) {
        // Implement logic to retrieve currency exchange rate
        return currencyService.getCurrencyExchangeRate(
                curCode.longValue(),
                rnd.intValue(),
                bcurRnd.intValue())
                .getVRate();
    }

    private BigDecimal get_total_os_per_insured(String claimNo, BigDecimal regCldCode) {
        // Implement logic to retrieve total outstanding reserve per insured
        return claimService.getTotalOsPerInsured(claimNo, regCldCode.longValue()); // Replace with actual logic
    }



    // Method to handle the conversion logic of process_revision procedure
    @Transactional
    public void processRevision(
            String claimNo,
            BigDecimal transNo,
            String tranType,
            Date transDate,
            BigDecimal revAmt,
            BigDecimal coinRevAmt,
            BigDecimal ipuCode,
            String user
    ) {
        Optional<GinClaimMasterBookings> claimMasterBooking = claimMasterBookingRepository.findById(claimNo);
        if (claimMasterBooking.isEmpty()) {
            throw new RuntimeException("Claim not found: " + claimNo);
        }

        GinClaimMasterBookings claimDetails = claimMasterBooking.get();

        // Calculate outstanding reserve
        BigDecimal ostReserve = getOsReserve(claimNo);

        // Calculate total reserve change
        BigDecimal revAmount = claimPerilRepository.findAllByClmpCmbClaimNo(claimNo).stream()
                .map(GinClaimPerils::getClmpChangeAmt)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal coinRevAmount = claimPerilRepository.findAllByClmpCmbClaimNo(claimNo).stream()
                .map(GinClaimPerils::getClmpTotalReserve)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Validate reserve change
        if (ostReserve.add(revAmount).compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Reserve change results in a negative outstanding reserve.");
        }

        // Handle coinsurance
        if ("Y".equals(claimDetails.getCmbCoinsurance()) && "F".equals(claimDetails.getCmbCoinPayType())) {
            clmCoinReserveRepository.deleteAllByCcorGgtTransNo(transNo);
            List<GinClaimCoinsurers> coinsurers = claimCoinsurerRepository.findAllByCmbClaimNo(claimNo);
            for (GinClaimCoinsurers coinsurer : coinsurers) {
                BigDecimal coinsurerAmt = calculateCoinsurerAmt(coinRevAmt, coinsurer.getPerct());
                BigDecimal coinsurerAmtBcur = calculateCoinsurerAmtBcur(
                        coinsurerAmt,
                        BigDecimal.valueOf(claimDetails.getCmbCurCode()),
                        claimDetails.getCmbCurSymbol());
                GinClmCoinReserves coinsurerReserve = new GinClmCoinReserves();
                coinsurerReserve.setCcorCmbClaimNo(claimNo);
                coinsurerReserve.setCcorAgntAgentCode(BigDecimal.valueOf(coinsurer.getAgntAgentCode()));
                coinsurerReserve.setCcorAgentShtDesc(coinsurer.getAgntShtDesc());
                coinsurerReserve.setCcorAmount(coinsurerAmt);
                coinsurerReserve.setCcorAmountBcur(coinsurerAmtBcur);
                coinsurerReserve.setCcorRate(coinsurer.getPerct());
                coinsurerReserve.setCcorGgtTransNo(transNo);
                clmCoinReserveRepository.save(coinsurerReserve);
            }
        }

        // Determine transaction code
        Optional<GinBusinessTransactions> businessTransaction = businessTransactionRepository.findByBtrTransCode(tranType);
        if (businessTransaction.isEmpty()) {
            throw new RuntimeException("Transaction type not found: " + tranType);
        }
        String tranCode = businessTransaction.get().getBtrDebitCode();

        // Update BPM tickets
        Optional<GinBpmTickets> bpmTicket = bpmTicketRepository.findByTcktClaimTransNo(transNo);
        if (bpmTicket.isPresent()) {
            BigDecimal tcktCode = bpmTicket.get().getTcktCode();
            jbpm4HistTaskGisRepository.updateOutcomeByDbid("completed", tcktCode);
            jbpm4TaskGisRepository.deleteByDbid(tcktCode);
            bpmTicketRepository.deleteByPolCode(tcktCode);
        }

        // Reopen claim if needed
        if ("S".equals(claimDetails.getCmbClaimStatus())) {
            reopenClaim(claimNo);
        }

        // Clear previous cessions
        clmTreatyReserveCededRepository.deleteAllByCtrcGgtTransNo(transNo);
        clmFacreReserveCededRepository.deleteAllByCfrcGgtTransNo(transNo);
        clmRiPoolReserveCededRepository.deleteAllByCrprcGgtTransNo(transNo);
        perilRevisionRepository.deleteAllByPerrevGgtTransNo(transNo);
        claimRevisionRepository.deleteAllByClmrevGgtTransNo(transNo.longValue());

        // Calculate retention before pool
        BigDecimal poolRate = calculatePoolRate(claimNo);
        BigDecimal retentionBeforePool = calculateRetentionBeforePool(revAmt, claimDetails.getCmbCompRetentionRate(), poolRate);

        // Create or update claim revision
        Optional<GinClaimRevisions> claimRevision = claimRevisionRepository.findByClmrevGgtTransNo(transNo.longValue());
        if (claimRevision.isEmpty()) {
            BigDecimal clmrevCode = createClaimRevision(claimNo, transNo, transDate, revAmt, coinRevAmt, claimDetails,
                    retentionBeforePool, tranCode);
            createPerilRevisions(claimNo, transNo, revAmt, coinRevAmt, clmrevCode, ipuCode, user, claimDetails);
            createCessions(claimNo, transNo, revAmt, coinRevAmt, clmrevCode, ipuCode, claimDetails);
        } else {
            updateClaimRevision(claimRevision.get(), transNo, transDate, revAmt, coinRevAmt, claimDetails,
                    retentionBeforePool, tranCode, tranType);
            updateCessions(claimNo, transNo, revAmt, coinRevAmt, BigDecimal.valueOf(claimRevision.get().getClmrevCode()),
                    ipuCode, claimDetails);
        }
    }

    public void computeRevisionExcess(String vClaimNo, Long vIpuCode, BigDecimal vExchangeRate) {
        // Fetch claim peril revisions
        List<ClaimPerilRevisionDto> claimPerilRevisions = claimMasterBookingRepository.findClaimPerilRevisionsByClaimNo(vClaimNo);

        for (ClaimPerilRevisionDto pr : claimPerilRevisions) {
            if ("N".equals(pr.getClmpOverride())) {
                BigDecimal vExcessAmnt = BigDecimal.ZERO;
                BigDecimal vPrlExcessAmnt = BigDecimal.ZERO;
                BigDecimal vTotExcessAmnt = BigDecimal.ZERO;

                // Fetch peril excesses
                List<GinClaimPerilExcesses> perExcesses = claimPerilExcessesRepository.findByCpeClmpCode(pr.getClmpCode());

                for (GinClaimPerilExcesses pex : perExcesses) {
                    String vExcessApplicable = excessConditionService.excessConditionTrue(
                            pex.getCpeSsexCode().longValue(), vClaimNo, "N");

                    if ("Y".equals(vExcessApplicable)) {
                        vExcessAmnt = excessConditionService.getExcessAmount(
                                pex.getCpeSsexCode().longValue(), pr.getCmbIpuValue(), pr.getClmpReserveAmt(), pr.getPlOrTl(), vIpuCode);
                    } else {
                        vExcessAmnt = BigDecimal.ZERO;
                    }

                    vPrlExcessAmnt = vPrlExcessAmnt.add(vExcessAmnt);

                    // Update cpe_excess_amt and cpe_claim_excess
                    claimPerilExcessesRepository.updateExcessAmount(pex.getCpeCode().longValue(), vExcessAmnt);
                }

                // Calculate total excess amount
                vTotExcessAmnt = vTotExcessAmnt.add(vPrlExcessAmnt).divide(vExchangeRate, 2, RoundingMode.HALF_UP);

                // Update clmp_excess_amt and clmp_novice_excess_amt
                claimPerilsRepository.updateClmpExcessAmtAndClmpNoviceExcessAmt(pr.getClmpCode(), vTotExcessAmnt, vTotExcessAmnt);
            }
        }
    }


    private BigDecimal calculateCoinsurerAmt(BigDecimal coinRevAmt, BigDecimal perct) {
        return coinRevAmt.multiply(perct).divide(BigDecimal.valueOf(100));
    }

    private BigDecimal calculateCoinsurerAmtBcur(BigDecimal coinsurerAmt, BigDecimal curCode, String curSymbol) {
        BigDecimal exchangeRate = getCurrexchRate(curCode, ROUNDING_SCALE, ROUNDING_SCALE);
        return coinsurerAmt.multiply(exchangeRate);
    }

    private BigDecimal calculatePoolRate(String claimNo) {
        return claimReinPoolCessionRepository.findByCrpcCmbClaimNo(claimNo).stream()
                .map(GinClaimReinPoolCessions::getCrpcRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateRetentionBeforePool(BigDecimal revAmt, BigDecimal compRetentionRate, BigDecimal poolRate) {
        return (compRetentionRate.add(poolRate)).multiply(revAmt).divide(new BigDecimal("100"));
    }

    private BigDecimal createClaimRevision(
            String claimNo,
            BigDecimal transNo,
            Date transDate,
            BigDecimal revAmt,
            BigDecimal coinRevAmt,
            GinClaimMasterBookings claimDetails,
            BigDecimal retentionBeforePool,
            String tranCode
    ) {
        GinClaimRevisions claimRevision = new GinClaimRevisions();
        claimRevision.setClmrevCmbClaimNo(claimNo);
        claimRevision.setClmrevGgtTransNo(transNo.longValue());
        claimRevision.setClmrevDate(transDate);
        claimRevision.setClmrevAmt(revAmt);
        claimRevision.setClmrevPolBatchNo(claimDetails.getCmbPolBatchNo());
        claimRevision.setClmrevGgtTranType(tranCode);
        claimRevision.setClmrevCompRetention(retentionBeforePool);
        claimRevision.setClmrevCoinAmt(coinRevAmt);
        claimRevision.setClmrevCurCode(claimDetails.getCmbCurCode());
        claimRevision.setClmrevCurRate(getCurrexchRate(BigDecimal.valueOf(claimDetails.getCmbCurCode()), ROUNDING_SCALE, ROUNDING_SCALE));
        claimRevision.setClmrevGgtBtrTransCode("LO");
        claimRevision = claimRevisionRepository.save(claimRevision);
        return BigDecimal.valueOf(claimRevision.getClmrevCode());
    }

    private void createPerilRevisions(
            String claimNo,
            BigDecimal transNo,
            BigDecimal revAmt,
            BigDecimal coinRevAmt,
            BigDecimal clmrevCode,
            BigDecimal ipuCode,
            String user,
            GinClaimMasterBookings claimDetails
    ) {
        List<GinClaimPerils> perils = claimPerilRepository.findAllByClmpCmbClaimNo(claimNo);
        for (GinClaimPerils peril : perils) {
            GinPerilRevisions perilRevision = new GinPerilRevisions();
            perilRevision.setPerrevCode(BigDecimal.valueOf(peril.getClmpPerPtCode()));
            perilRevision.setPerrevType(peril.getClmpType());
            perilRevision.setPerrevAmount(peril.getClmpChangeAmt());
            perilRevision.setPerrevGgtTransNo(transNo);
            perilRevision.setPerrevBtrTransCode("BTR_CODE"); // Replace with actual transaction code
            perilRevision.setPerrevClmrevCode(clmrevCode);
            perilRevision.setPerrevClmpCode(BigDecimal.valueOf(peril.getClmpCode()));
            perilRevision.setPerrevLiabAdmission(peril.getClmpLiabAdmission());
            perilRevision.setPerrevLiabDate(peril.getClmpLiabDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            perilRevision.setPerrevCoinAmnt(coinRevAmt);
            perilRevisionRepository.save(perilRevision);
        }
        // TODO migrate claim revision excess computation to this method
        computeRevisionExcess(claimNo, ipuCode.longValue(), getCurrexchRate(BigDecimal.valueOf(claimDetails.getCmbCurCode()),
                ROUNDING_SCALE, ROUNDING_SCALE)); // Assuming claimDetails is accessible here
    }

    private void createCessions(
            String claimNo,
            BigDecimal transNo,
            BigDecimal revAmt,
            BigDecimal coinRevAmt,
            BigDecimal clmrevCode,
            BigDecimal ipuCode,
            GinClaimMasterBookings claimDetails
    ) {
        createTreatyCessions(claimNo, transNo, revAmt, claimDetails, clmrevCode);
        createFacreCessions(claimNo, transNo, revAmt, claimDetails, clmrevCode);
        createPoolCessions(claimNo, transNo, revAmt, claimDetails, clmrevCode, ipuCode);
    }

    private void createTreatyCessions(
            String claimNo,
            BigDecimal transNo,
            BigDecimal revAmt,
            GinClaimMasterBookings claimDetails,
            BigDecimal clmrevCode
    ) {
        List<GinClaimTreatyCessions> treaties = claimTreatyCessionRepository.findAllByCtrtcCmbClaimNo(claimNo);
        for (GinClaimTreatyCessions treaty : treaties) {
            GinClmTreatyReserveCeded treatyCession = new GinClmTreatyReserveCeded();
            treatyCession.setCtrcReiCode(BigDecimal.valueOf(treaty.getCtrtcReiCode()));
            treatyCession.setCtrcCmbClaimNo(claimNo);
            treatyCession.setCtrcTrtAmtPcur(treaty.getCtrtcRate().multiply(revAmt).divide(BigDecimal.valueOf(100L)));
            treatyCession.setCtrcTrtAmtTcur(treatyCession.getCtrcTrtAmtPcur().divide(getCurrexchRate(BigDecimal.valueOf(claimDetails.getCmbCurCode()), ROUNDING_SCALE, ROUNDING_SCALE)));
            treatyCession.setCtrcUwyr(BigDecimal.valueOf(treaty.getCtrtcUwyr()));
            treatyCession.setCtrcRate(treaty.getCtrtcRate());
            treatyCession.setCtrcPolBatchNo(BigDecimal.valueOf(claimDetails.getCmbPolBatchNo()));
            treatyCession.setCtrcSclCode(BigDecimal.valueOf(claimDetails.getCmbSclCode()));
            treatyCession.setCtrcPolCurCode(BigDecimal.valueOf(claimDetails.getCmbCurCode()));
            treatyCession.setCtrcTrtCurCode(BigDecimal.valueOf(treaty.getCtrtcTrtCurCode()));
            treatyCession.setCtrcPolCurSymbol(claimDetails.getCmbCurSymbol());
            treatyCession.setCtrcTrtCurSymbol("CUR_SYMBOL"); // Replace with actual currency symbol
            treatyCession.setCtrcTrsCode(BigDecimal.valueOf(treaty.getCtrtcTrsCode()));
            treatyCession.setCtrcClmrevCode(clmrevCode);
            treatyCession.setCtrcReiTrsShtDesc(treaty.getCtrtcReiTrsShtDesc());
            treatyCession.setCtrcGgtTransNo(transNo);
            clmTreatyReserveCededRepository.save(treatyCession);
        }
    }

    private void createFacreCessions(
            String claimNo,
            BigDecimal transNo,
            BigDecimal revAmt,
            GinClaimMasterBookings claimDetails,
            BigDecimal clmrevCode
    ) {
        List<GinClaimFacreCessions> facreCessions = claimFacreCessionRepository.findAllByFccCmbClaimNo(claimNo);
        for (GinClaimFacreCessions facreCession : facreCessions) {
            GinClmFacreReserveCeded facreReserveCeded = new GinClmFacreReserveCeded();
            facreReserveCeded.setCfrcFcCode(BigDecimal.valueOf(facreCession.getFccCode()));
            facreReserveCeded.setCfrcCmbClaimNo(claimNo);
            facreReserveCeded.setCfrcAgntAgentCode(BigDecimal.valueOf(facreCession.getFccAgntAgentCode()));
            facreReserveCeded.setCfrcAgentShtDesc(facreCession.getFccAgentShtDesc());
            facreReserveCeded.setCfrcAmount(facreCession.getFccRate().multiply(revAmt).divide(BigDecimal.valueOf(100)));
            facreReserveCeded.setCfrcAmountBcur(facreReserveCeded.getCfrcAmount()
                    .divide(getCurrexchRate(BigDecimal.valueOf(claimDetails.getCmbCurCode()), ROUNDING_SCALE, ROUNDING_SCALE)));
            facreReserveCeded.setCfrcUwyr(BigDecimal.valueOf(facreCession.getFccUwyr()));
            facreReserveCeded.setCfrcRate(facreCession.getFccRate());
            facreReserveCeded.setCfrcPolBatchNo(BigDecimal.valueOf(claimDetails.getCmbPolBatchNo()));
            facreReserveCeded.setCfrcSclCode(BigDecimal.valueOf(claimDetails.getCmbSclCode()));
            facreReserveCeded.setCfrcPolCurCode(BigDecimal.valueOf(claimDetails.getCmbCurCode()));
            facreReserveCeded.setCfrcPolCurSymbol(claimDetails.getCmbCurSymbol());
            facreReserveCeded.setCfrcClmrevCode(clmrevCode);
            facreReserveCeded.setCfrcGgtTransNo(transNo);
            facreReserveCeded.setCfrcFacreType(facreCession.getFccFacreType());
            clmFacreReserveCededRepository.save(facreReserveCeded);
        }
    }

    private void createPoolCessions(
            String claimNo,
            BigDecimal transNo,
            BigDecimal revAmt,
            GinClaimMasterBookings claimDetails,
            BigDecimal clmrevCode,
            BigDecimal ipuCode
    ) {
        List<GinClaimReinPoolCessions> poolCessions = claimReinPoolCessionRepository.findByCrpcCmbClaimNo(claimNo);
        for (GinClaimReinPoolCessions poolCession : poolCessions) {
            // Retrieve pool rate for the specific peril and subclass
            Optional<GinRiPoolSubclPerils> poolPeril = riPoolSubclPerilRepository.findByRpscpSclCodeAndRpscpPerCode(
                    BigDecimal.valueOf(claimDetails.getCmbSclCode()),
                    BigDecimal.valueOf(poolCession.getCrpcSclCode())
            );
            if (poolPeril.isPresent()) {
                BigDecimal poolRate = BigDecimal.valueOf(poolPeril.get().getRpscpClaimsRate());
                BigDecimal poolAmt = calculatePoolAmt(revAmt, poolRate);
                BigDecimal poolAmtBcur = calculatePoolAmtBcur(
                        poolAmt,
                        BigDecimal.valueOf(claimDetails.getCmbCurCode()),
                        claimDetails.getCmbCurSymbol());

                GinClmRiPoolReserveCeded poolCessionRecord = new GinClmRiPoolReserveCeded();
                poolCessionRecord.setCrprcCmbClaimNo(claimNo);
                poolCessionRecord.setCrprcUwyr(BigDecimal.valueOf(poolCession.getCrpcUwyr()));
                poolCessionRecord.setCrprcRate(poolRate);
                poolCessionRecord.setCrprcPolBatchNo(BigDecimal.valueOf(claimDetails.getCmbPolBatchNo()));
                poolCessionRecord.setCrprcSclCode(BigDecimal.valueOf(claimDetails.getCmbSclCode()));
                poolCessionRecord.setCrprcIpuCode(ipuCode);
                poolCessionRecord.setCrprcClmrevCode(clmrevCode);
                poolCessionRecord.setCrprcGgtTransNo(transNo);
                poolCessionRecord.setCrprcCurCode(BigDecimal.valueOf(claimDetails.getCmbCurCode()));
                poolCessionRecord.setCrprcCurSymbol(claimDetails.getCmbCurSymbol());
                poolCessionRecord.setCrprcAmt(poolAmt);
                poolCessionRecord.setCrprcPrprdCode(BigDecimal.valueOf(poolCession.getCrpcPrprdCode()));
                poolCessionRecord.setCrprcCrpcCode(BigDecimal.valueOf(poolCession.getCrpcCode()));
                poolCessionRecord.setCrprcClmpCode(BigDecimal.valueOf(poolCession.getCrpcSclCode())); // Assuming scl_code is the clmp_code
                clmRiPoolReserveCededRepository.save(poolCessionRecord);
            }
        }
    }

    private BigDecimal calculatePoolAmt(BigDecimal revAmt, BigDecimal poolRate) {
        return poolRate.multiply(revAmt).divide(new BigDecimal(100L));
    }

    private BigDecimal calculatePoolAmtBcur(BigDecimal poolAmt, BigDecimal curCode, String curSymbol) {
        BigDecimal exchangeRate = getCurrexchRate(curCode, ROUNDING_SCALE, ROUNDING_SCALE);
        return poolAmt.multiply(exchangeRate);
    }

    private void updateClaimRevision(
            GinClaimRevisions claimRevision,
            BigDecimal transNo,
            Date transDate,
            BigDecimal revAmt,
            BigDecimal coinRevAmt,
            GinClaimMasterBookings claimDetails,
            BigDecimal retentionBeforePool,
            String tranCode,
            String tranType
    ) {
        claimRevision.setClmrevDate(transDate);
        claimRevision.setClmrevAmt(revAmt);
        claimRevision.setClmrevCompRetention(retentionBeforePool);
        claimRevision.setClmrevCoinAmt(coinRevAmt);
        claimRevision.setClmrevCurCode(claimDetails.getCmbCurCode());
        claimRevision.setClmrevCurRate(getCurrexchRate(BigDecimal.valueOf(claimDetails.getCmbCurCode()), ROUNDING_SCALE, ROUNDING_SCALE));
        claimRevision.setClmrevGgtTranType(tranCode);
        claimRevision.setClmrevGgtBtrTransCode(tranType); // Assuming tranType is accessible here
        claimRevisionRepository.save(claimRevision);
    }

    private void updateCessions(
            String claimNo,
            BigDecimal transNo,
            BigDecimal revAmt,
            BigDecimal coinRevAmt,
            BigDecimal clmrevCode,
            BigDecimal ipuCode,
            GinClaimMasterBookings claimDetails
    ) {
        updateTreatyCessions(claimNo, transNo, revAmt, claimDetails, clmrevCode); // Assuming claimDetails is accessible here
        updateFacreCessions(claimNo, transNo, revAmt, claimDetails, clmrevCode); // Assuming claimDetails is accessible here
        updatePoolCessions(claimNo, transNo, revAmt, claimDetails, clmrevCode, ipuCode); // Assuming claimDetails is accessible here
    }

    private void updateTreatyCessions(
            String claimNo,
            BigDecimal transNo,
            BigDecimal revAmt,
            GinClaimMasterBookings claimDetails,
            BigDecimal clmrevCode
    ) {
        List<GinClaimTreatyCessions> treaties = claimTreatyCessionRepository.findAllByCtrtcCmbClaimNo(claimNo);
        for (GinClaimTreatyCessions treaty : treaties) {
            Optional<GinClmTreatyReserveCeded> treatyCession = clmTreatyReserveCededRepository
                    .findByCtrcReiCodeAndCtrcCmbClaimNoAndCtrcGgtTransNo(BigDecimal.valueOf(treaty.getCtrtcReiCode()), claimNo, transNo);
            if (treatyCession.isPresent()) {
                treatyCession.get().setCtrcTrtAmtPcur(treaty.getCtrtcRate().multiply(revAmt)
                        .divide(new BigDecimal("100")));
                treatyCession.get().setCtrcTrtAmtTcur(treatyCession.get().getCtrcTrtAmtPcur()
                        .divide(getCurrexchRate(BigDecimal.valueOf(claimDetails.getCmbCurCode()), ROUNDING_SCALE, ROUNDING_SCALE)));
                treatyCession.get().setCtrcClmrevCode(clmrevCode);
                clmTreatyReserveCededRepository.save(treatyCession.get());
            }
        }
    }

    private void updateFacreCessions(
            String claimNo,
            BigDecimal transNo,
            BigDecimal revAmt,
            GinClaimMasterBookings claimDetails,
            BigDecimal clmrevCode
    ) {
        List<GinClaimFacreCessions> facreCessions = claimFacreCessionRepository.findAllByFccCmbClaimNo(claimNo);
        for (GinClaimFacreCessions facreCession : facreCessions) {
            Optional<GinClmFacreReserveCeded> facreReserveCeded = clmFacreReserveCededRepository
                    .findByCfrcFcCodeAndCfrcCmbClaimNoAndCfrcGgtTransNo(
                            BigDecimal.valueOf(facreCession.getFccFcCode()), claimNo, transNo);
            if (facreReserveCeded.isPresent()) {
                facreReserveCeded.get().setCfrcAmount(facreCession.getFccRate().multiply(revAmt)
                        .divide(new BigDecimal("100")));
                facreReserveCeded.get().setCfrcAmountBcur(facreReserveCeded.get().getCfrcAmount()
                        .divide(getCurrexchRate(BigDecimal.valueOf(claimDetails.getCmbCurCode()), ROUNDING_SCALE, ROUNDING_SCALE)));
                facreReserveCeded.get().setCfrcClmrevCode(clmrevCode);
                clmFacreReserveCededRepository.save(facreReserveCeded.get());
            }
        }
    }

    private void updatePoolCessions(
            String claimNo,
            BigDecimal transNo,
            BigDecimal revAmt,
            GinClaimMasterBookings claimDetails,
            BigDecimal clmrevCode,
            BigDecimal ipuCode
    ) {
        List<GinClaimReinPoolCessions> poolCessions = claimReinPoolCessionRepository.findByCrpcCmbClaimNo(claimNo);
        for (GinClaimReinPoolCessions poolCession : poolCessions) {
            // Retrieve pool rate for the specific peril and subclass
            Optional<GinRiPoolSubclPerils> poolPeril = riPoolSubclPerilRepository.findByRpscpSclCodeAndRpscpPerCode(
                    BigDecimal.valueOf(claimDetails.getCmbSclCode()),
                    BigDecimal.valueOf(poolCession.getCrpcSclCode())
            );
            if (poolPeril.isPresent()) {
                BigDecimal poolRate = BigDecimal.valueOf(poolPeril.get().getRpscpClaimsRate());
                Optional<GinClmRiPoolReserveCeded> poolCessionRecord = clmRiPoolReserveCededRepository
                        .findByCrprcCrpcCodeAndClaimNoAndCrprcGgtTransNo(
                        BigDecimal.valueOf(poolCession.getCrpcCode()), claimNo, transNo);
                if (poolCessionRecord.isPresent()) {
                    poolCessionRecord.get().setCrprcAmt(calculatePoolAmt(revAmt, poolRate));
                    poolCessionRecord.get().setCrprcAmt(calculatePoolAmt(revAmt, poolRate));
                    poolCessionRecord.get().setCrprcClmrevCode(clmrevCode);
                    clmRiPoolReserveCededRepository.save(poolCessionRecord.get());
                }
            }
        }
    }

    private void reopenClaim(String claimNo) {
        // Implement logic to reopen a claim
        List<GinRgstdClaimants> claimants = claimantsRepository.findByRegCmbClaimNo(claimNo);
        for (GinRgstdClaimants claimant : claimants) {
            claimant.setRegClaimStatus("1"); // Set claim status to 'R' (Reopened)
            claimantsRepository.save(claimant);
        }

        // Update claim master booking
        try {
            GinClaimMasterBookings claimBooking = claimMasterBookingRepository.findByCmbClaimNo(claimNo)
                    .orElseThrow(() -> new ResourceNotFoundException("Claim not found: " + claimNo));
            claimBooking.setCmbClaimStatus("R");
            claimBooking.setCmbCloseDate(null);
            claimBooking.setCmbStatusDate(new Date(System.currentTimeMillis()));
            claimBooking.setCmbClaimRemarks(null);
            claimMasterBookingRepository.save(claimBooking);
        } catch (Exception e) {
            throw new RuntimeException("Error changing the claim status", e);
        }
    }
}
