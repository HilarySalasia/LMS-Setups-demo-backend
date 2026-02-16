package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.PoolRecoveryPeril;
import com.turnquest.setupsdemo.dto.PoolRiskTreaties;
import com.turnquest.setupsdemo.dto.TreatyDetailsDTO;
import com.turnquest.setupsdemo.model.*;
import com.turnquest.setupsdemo.repository.*;
import com.turnquest.setupsdemo.service.CreateRiCessionsService;
import com.turnquest.setupsdemo.service.SqlSequence;
import lombok.AllArgsConstructor;
import org.hibernate.jdbc.TooManyRowsAffectedException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CreateRiCessionsServiceImpl implements CreateRiCessionsService {

    private GinPolicyRiskRiDtlsRepository ginPolicyRiskRiDtlsRepository;
    private GinPolicyReinRiskDetailsRepository ginPolicyReinRiskDetailsRepository;
    private GinFacreCessionsRepository ginFacreCessionsRepository;
    private GinTreatySetupsRepository ginTreatySetupsRepository;
    private GinClassTreatiesRepository ginClassTreatiesRepository;
    private GinArrangementSetupsRepository ginArrangementSetupsRepository;
    private GinTreatyArrangementsRepository ginTreatyArrangementsRepository;
    private GinClaimTreatyCessionsRepository ginClaimTreatyCessionsRepository;
    private GinClaimFacreCessionsRepository ginClaimFacreCessionsRepository;
    private GinPolReinPoolRiskDetailsRepository ginPolReinPoolRiskDetailsRepository;
    private GinRiPoolSubclPerilsRepository ginRiPoolSubclPerilsRepository;
    private GinSubclCoverRiPoolRatesRepository ginSubclCoverRiPoolRatesRepository;
    private GinXolUwCessionsRepository ginXolUwCessionsRepository;
    private GinClaimMasterBookingsRepository ginClaimMasterBookingsRepository;
    private GinClaimReinPoolCessionsRepository ginClaimReinPoolCessionsRepository;
    private GinXolClmsVmlpCessionsRepository ginXolClmsVmlpCessionsRepository;
    private SqlSequence sqlSequence;


    public void createRiCessions(String vClaimNo, Long vIpuCode, String vIpuPropertyId, BigDecimal vClmUwYr,
                                 BigDecimal vSclCode, BigDecimal vPolBatchNo, BigDecimal vCurCode, String vCurSymbol,
                                 String vPolLoaded, LocalDate vLossDate, String vNoRi, BigDecimal vCvtCode) {
        // Calculate the total rate for the risk
        BigDecimal totRate = BigDecimal.valueOf(calculateTotRate(vIpuCode));

        // Check if the policy is loaded or the total rate is 100%
        if (vPolLoaded.equals("N") || (vPolLoaded.equals("Y") && totRate.compareTo(BigDecimal.valueOf(100)) == 0)) {
            // Find the details of the primary risk reinsurance details
            Optional<GinPolicyRiskRiDtls> prrdDetails = findPrrdDetails(vIpuCode);
            if (prrdDetails.isEmpty()) {
                if (vNoRi.equals("Y")) {
                    return;
                } else {
                    throw new RuntimeException("Reinsurance details not found. Cannot continue booking claim without Reinsurance ...");
                }
            }
            Long prrdCode = prrdDetails.get().getPrrdCode();
            BigDecimal retRate = prrdDetails.get().getPrrdComRetentionRate();
            BigDecimal retAmt = prrdDetails.get().getPrrdCompRetention();
            BigDecimal grRet = prrdDetails.get().getPrrdGrossCompRetention();

            // Process Treaty Cessions
            processTreatyCessions(vClaimNo, vIpuCode, vLossDate, prrdCode);

            // Process Facre Cessions
            processFacreCessions(vClaimNo, vIpuCode, prrdCode);

            // Process Pool Cessions
            processPoolCessions(vClaimNo, vIpuCode, vCvtCode, vSclCode, vLossDate, prrdCode);

            // Process XOL Cessions
            processXolCessions(vClaimNo, vIpuCode, prrdCode);

            // Update claim master bookings with retention details
            updateClaimMasterBookings(vClaimNo, grRet, retAmt, retRate);

        } else {
            // No RI arrangement setup found for class - ' + vSclCode + ' year - ' + TO_CHAR(vLossDate, 'YYYY');
            Long count = getTreatyArrangementCount(
                    vSclCode.longValue(),
                    Date.from(vLossDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    vCurCode.longValue());
            if (count == 0) {
                throw new RuntimeException("No RI arrangement setup found for class - " + vSclCode + " year - " + vLossDate.format(DateTimeFormatter.ofPattern("yyyy")));
            } else if (count > 1) {
                throw new RuntimeException("More than one RI arrangement setup found for class - " + vSclCode + " year - " + vLossDate.format(DateTimeFormatter.ofPattern("yyyy")));
            }

            String taType = getTreatyType(
                    vSclCode.longValue(),
                    Date.from(vLossDate.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    vCurCode.longValue());
            if (taType.equals("X")) {
                updateClaimMasterBookings(vClaimNo, null, null, BigDecimal.valueOf(100));
            } else {
                // Process Pool Cessions
                processPoolCessions(vClaimNo, vIpuCode, vCvtCode, vSclCode, vLossDate, null);

                // Process Rein Pool Perils
                processReinPoolPerils(vClaimNo, vClmUwYr, vSclCode, vCurCode, vCurSymbol, vPolBatchNo, vCvtCode);
            }
        }
    }

    private Long calculateTotRate(Long vIpuCode) {
        return ginPolicyRiskRiDtlsRepository.findTotRateByIpuCode(vIpuCode);
    }

    private Optional<GinPolicyRiskRiDtls> findPrrdDetails(Long vIpuCode) {
        return ginPolicyRiskRiDtlsRepository.findFirstByPrrdIpuCodeOrderByPrrdIdxDesc(vIpuCode);
    }

    private void processTreatyCessions(String vClaimNo, Long vIpuCode, LocalDate vLossDate, Long prrdCode) {
        List<TreatyDetailsDTO> treatyDetails = ginPolicyReinRiskDetailsRepository
                .findTreatyDetails(
                        vIpuCode.longValue(),
                        prrdCode);

        treatyDetails.forEach(detail -> {
            BigDecimal reiCode = findReiCode(detail, vLossDate);
            Long asCode = findAsCode(detail, reiCode, vLossDate);
            BigDecimal rate = detail.getPtotrCessionPct();
            BigDecimal trtCurCode = BigDecimal.valueOf(detail.getPtotrTrtCurCode());
            String trtCurSymbol = detail.getPtotrTrtCurSymbol();

            // Insert treaty cession details into gin_claim_treaty_cessions
            GinClaimTreatyCessions cession = new GinClaimTreatyCessions();
            cession.setCtrtcCode(generateNextCtrtcCode().longValue());
            cession.setCtrtcReiCode(reiCode.longValue());
            cession.setCtrtcCmbClaimNo(vClaimNo);
            cession.setCtrtcUwyr(detail.getPtotrUwyr());
            cession.setCtrtcRate(rate);
            cession.setCtrtcPolBatchNo(detail.getPtotrPolBatchNo());
            cession.setCtrtcSclCode(detail.getPtotrCltSclCode());
            cession.setCtrtcPolCurCode(detail.getPtotrRiskCurCode());
            cession.setCtrtcTrtCurCode(trtCurCode.longValue());
            cession.setCtrtcPolCurSymbol(detail.getPtotrRiskCurSymbol());
            cession.setCtrtcTrtCurSymbol(trtCurSymbol);
            cession.setCtrtcTrsCode(detail.getPtotrTrsCode());
            cession.setCtrtcReiTrsShtDesc(detail.getPtotrTrsShtDesc());
            ginClaimTreatyCessionsRepository.save(cession);
        });
    }

    private BigDecimal findReiCode(TreatyDetailsDTO detail, LocalDate vLossDate) {
        if (detail.getTaType().equals("U") || (detail.getTaType().equals("C") &&
                detail.getPtotrDate().toInstant().atZone(ZoneId.systemDefault()).getYear() == vLossDate.getYear())) {
            return BigDecimal.valueOf(detail.getPtotrReiCode());
        } else {
            return findReiCodeForLossYear(detail, vLossDate);
        }
    }

    private BigDecimal findReiCodeForLossYear(TreatyDetailsDTO detail, LocalDate vLossDate) {
        return BigDecimal.valueOf(ginTreatySetupsRepository
                .findByReiTrsCodeAndReiAsCodeAndAsTaCodeAndAsUwyr(detail.getPtotrTrsCode(),
                        detail.getPtotrAsCode(), detail.getTaCode(), vLossDate.getYear())
                .orElseThrow(() -> new RuntimeException("Unable to retrieve this years treaty setup details for the treaty "
                        + detail.getPtotrTrsShtDesc() + ", risk " + detail.getPtotrIpuCode())).getReiAsCode());
    }

    private Long findAsCode(TreatyDetailsDTO detail, BigDecimal reiCode, LocalDate vLossDate) {
        if (reiCode.equals(detail.getPtotrReiCode())) {
            return detail.getPtotrAsCode();
        } else {
            return ginTreatySetupsRepository
                    .findByReiCodeAndReiAsCodeAndAsUwyr(reiCode.longValue(), detail.getPtotrAsCode(), vLossDate.getYear())
                    .orElseThrow(() -> new RuntimeException("Unable to retrieve this years treaty setup details for the treaty "
                            + detail.getPtotrTrsShtDesc() + ", risk " + detail.getPtotrIpuCode())).getReiAsCode();
        }
    }

    private void processFacreCessions(String vClaimNo, Long vIpuCode, Long prrdCode) {
        List<GinFacreCessions> facreDetails = ginFacreCessionsRepository
                .findByFcIpuCodeAndFcPrrdCodeAndFcTranTypeNot(vIpuCode, prrdCode, "CO");

        facreDetails.forEach(detail -> {
            // Insert Facre cession details into gin_claim_facre_cessions
            GinClaimFacreCessions cession = new GinClaimFacreCessions();
            cession.setFccCmbClaimNo(vClaimNo);
            cession.setFccCode(generateNextFccCode().longValue());
            cession.setFccAgntAgentCode(detail.getFcAgntAgentCode());
            cession.setFccIpuCode(detail.getFcIpuCode());
            cession.setFccAgentShtDesc(detail.getFcAgentShtDesc());
            cession.setFccRate(detail.getFcRate());
            cession.setFccUwyr(detail.getFcUwyr());
            cession.setFccRateAmt(detail.getFcAmtOrRate());
            cession.setFccFcCode(detail.getFcCode());
            cession.setFccFacreType(detail.getFcFacreType());
            ginClaimFacreCessionsRepository.save(cession);
        });
    }

    private void processPoolCessions(String vClaimNo, Long vIpuCode, BigDecimal vCvtCode, BigDecimal vSclCode,
                                     LocalDate vLossDate, Long prrdCode) {
        // Check if there are any records in gin_ri_pool_subcl_perils for the specified coverage and subclass
        long recoveryCnt = ginRiPoolSubclPerilsRepository.countByRpscpCovtCodeAndRpscpSclCode(vCvtCode, vSclCode);

        if (recoveryCnt == 0) {
            // If no records found, process pool cessions based on gin_pol_rein_pool_risk_details
            processPoolCessionsBasedOnPrprdDetails(vClaimNo, vIpuCode, vCvtCode.longValue(), vLossDate, prrdCode);
        } else {
            // If records found, process pool cessions based on gin_ri_pool_subcl_perils
            processPoolCessionsBasedOnRpscpDetails(
                    vIpuCode,
                    vCvtCode.longValue(),
                    vSclCode.longValue(),
                    vClaimNo);
        }
    }

//    private void processPoolCessionsBasedOnPrprdDetails(String vClaimNo, Long vIpuCode, BigDecimal vCvtCode,
//                                                        LocalDate vLossDate, Long prrdCode) {
//        List<GinPolReinPoolRiskDetails> poolDetails = ginPolReinPoolRiskDetailsRepository
//                .findByPrprdIpuCodeAndPrprdPrrdCodeAndPrprdCovtCode(
//                        vIpuCode,
//                        prrdCode,
//                        vCvtCode.longValue());
//
//        poolDetails.forEach(detail -> {
//            // Insert pool cession details into gin_claim_rein_pool_cessions
//            GinClaimReinPoolCessions cession = new GinClaimReinPoolCessions();
//            cession.setCrpcCode(generateNextCrpcCode().longValue());
//            cession.setCrpcCmbClaimNo(vClaimNo);
//            cession.setCrpcUwyr(detail.getPrprdUwyr());
//            cession.setCrpcRate(detail.getPrprdReinPoolRate());
//            cession.setCrpcPolBatchNo(detail.getPrprdPolBatchNo());
//            cession.setCrpcSclCode(detail.getPrprdSclCode());
//            cession.setCrpcPolCurCode(detail.getPrprdRiskCurCode());
//            cession.setCrpcPoolCurCode(detail.getPrprdRiskCurCode());
//            cession.setCrpcPolCurSymbol(detail.getCurSymbol());
//            cession.setCrpcPoolCurSymbol(detail.getCurSymbol());
//            cession.setCrpcPrprdCode(detail.getPrprdCode());
//            cession.setCrpcScrprCode(detail.getPrprdScrprCode());
//            ginClaimReinPoolCessionsRepository.save(cession);
//        });
//    }

    public void processPoolCessionsBasedOnPrprdDetails(String claimNo, Long ipuCode, Long cvtCode,
                                                       LocalDate lossDate, Long prrdCode) {
        BigDecimal totalPoolRate = BigDecimal.ZERO;

        // Fetch the pool risk treaties (equivalent to the cursor)
        List<PoolRiskTreaties> poolRiskTreaties = ginPolReinPoolRiskDetailsRepository.findPoolRiskTreaties(ipuCode, cvtCode, prrdCode);

        // Iterate over the results and process them
        for (PoolRiskTreaties poolRiskTreaty : poolRiskTreaties) {
            try {
                // Update total pool rate
                totalPoolRate = totalPoolRate.add(poolRiskTreaty.getPrprdReinPoolRate().setScale(4, BigDecimal.ROUND_HALF_UP));

                // Insert into gin_claim_rein_pool_cessions table
                GinClaimReinPoolCessions cession = new GinClaimReinPoolCessions();
                cession.setCrpcCode(generateCrpcCode()); // Implement generateCrpcCode() to match TO_NUMBER (TO_CHAR (SYSDATE, 'RRRR')) || gin_crpc_code_seq.NEXTVAL
                cession.setCrpcCmbClaimNo(claimNo);
                cession.setCrpcUwyr(poolRiskTreaty.getPrprdUwyr());
                cession.setCrpcRate(poolRiskTreaty.getPrprdReinPoolRate());
                cession.setCrpcPolBatchNo(poolRiskTreaty.getPrprdPolBatchNo());
                cession.setCrpcSclCode(poolRiskTreaty.getPrprdSclCode());
                cession.setCrpcPolCurCode(poolRiskTreaty.getPrprdRiskCurCode());
                cession.setCrpcPoolCurCode(poolRiskTreaty.getPrprdRiskCurCode());
                cession.setCrpcPolCurSymbol(poolRiskTreaty.getCurSymbol());
                cession.setCrpcPoolCurSymbol(poolRiskTreaty.getCurSymbol());
                cession.setCrpcPrprdCode(poolRiskTreaty.getPrprdCode());
                cession.setCrpcScrprCode(poolRiskTreaty.getPrprdScrprCode());

                ginClaimReinPoolCessionsRepository.save(cession);
            } catch (Exception e) {
                // Handle error similar to tqc_error_manager.raise_unanticipated
                throw new RuntimeException("Unable to insert claim pool cessions.", e);
            }
        }
    }
//    SELECT DISTINCT prprd_uwyr,
//    rpscp_claims_rate,
//    prprd_pol_batch_no,
//    prprd_scl_code,
//    prprd_risk_cur_code,
//    cur_symbol,
//    prprd_code,
//    prprd_scrpr_code
//    FROM gin_pol_rein_pool_risk_details, tqc_currencies, gin_ri_pool_subcl_perils
//    WHERE prprd_risk_cur_code = cur_code(+)
//    AND prprd_ipu_code = v_ipu_code
//    AND prprd_prrd_code = v_prrd_code
//    AND prprd_covt_code = v_cvt_code
//    AND prprd_scl_code = v_scl_code
//    AND prprd_scl_code = rpscp_scl_code
//    AND prprd_covt_code = rpscp_covt_code;
//    private void processPoolCessionsBasedOnRpscpDetails(String vClaimNo, Long vIpuCode, BigDecimal vCvtCode,
//                                                        BigDecimal vSclCode, LocalDate vLossDate, BigDecimal prrdCode) {
//        List<PoolRecoveryPeril> poolDetails = ginRiPoolSubclPerilsRepository
//                .findPoolRecoveryPerils(
//                        vCvtCode.longValue(),
//                        vSclCode.longValue(),
//                        Long.valueOf(vLossDate.getYear()));
//
//        poolDetails.forEach(detail -> {
//            // Insert pool cession details into gin_claim_rein_pool_cessions
//            GinClaimReinPoolCessions cession = new GinClaimReinPoolCessions();
//            cession.setCrpcCode(generateNextCrpcCode().longValue());
//            cession.setCrpcCmbClaimNo(vClaimNo);
//            cession.setCrpcUwyr(detail.getRpscpUwyr());
//            cession.setCrpcRate(BigDecimal.valueOf(detail.getRpscpClaimsRate()));
//            cession.setCrpcPolBatchNo(detail.getPrprdPolBatchNo());
//            cession.setCrpcSclCode(detail.getRpscpSclCode());
//            cession.setCrpcPolCurCode(detail.getPrprdRiskCurCode());
//            cession.setCrpcPoolCurCode(detail.getPrprdRiskCurCode());
//            cession.setCrpcPolCurSymbol(detail.getCurSymbol());
//            cession.setCrpcPoolCurSymbol(detail.getCurSymbol());
//            cession.setCrpcPrprdCode(detail.getPrprdCode());
//            cession.setCrpcScrprCode(detail.getPrprdScrprCode());
//            ginClaimReinPoolCessionsRepository.save(cession);
//        });
//    }

    public void processPoolCessionsBasedOnRpscpDetails(Long ipuCode, Long cvtCode, Long sclCode, String claimNo) {
        try {
            // Fetch the required records using JPA repository method instead of cursor
            List<PoolRecoveryPeril> poolRecoveryPerilsList = ginRiPoolSubclPerilsRepository.findPoolRecoveryPerils(ipuCode, cvtCode, sclCode);

            BigDecimal totPoolRate = BigDecimal.ZERO;

            for (PoolRecoveryPeril poolRecoveryPeril : poolRecoveryPerilsList) {
                // Calculate total pool rate
                totPoolRate = totPoolRate.add(
                        BigDecimal.valueOf(
                                Optional.ofNullable(poolRecoveryPeril.getRpscpClaimsRate()).orElse(0L))
                ).setScale(4, RoundingMode.HALF_UP);

                // Insert into gin_claim_rein_pool_cessions
                GinClaimReinPoolCessions cession = new GinClaimReinPoolCessions();
                cession.setCrpcCode(generateCrpcCode());
                cession.setCrpcCmbClaimNo(claimNo);
                cession.setCrpcUwyr(poolRecoveryPeril.getPrprdUwyr());
                cession.setCrpcRate(BigDecimal.valueOf(poolRecoveryPeril.getRpscpClaimsRate()));
                cession.setCrpcPolBatchNo(poolRecoveryPeril.getPrprdPolBatchNo());
                cession.setCrpcSclCode(poolRecoveryPeril.getPrprdSclCode());
                cession.setCrpcPolCurCode(poolRecoveryPeril.getPrprdRiskCurCode());
                cession.setCrpcPoolCurCode(poolRecoveryPeril.getPrprdRiskCurCode());
                cession.setCrpcPolCurSymbol(poolRecoveryPeril.getCurSymbol());
                cession.setCrpcPoolCurSymbol(poolRecoveryPeril.getCurSymbol());
                cession.setCrpcPrprdCode(poolRecoveryPeril.getPrprdCode());
                cession.setCrpcScrprCode(poolRecoveryPeril.getPrprdScrprCode());

                // Save the cession record
                ginClaimReinPoolCessionsRepository.save(cession);
            }
        } catch (Exception e) {
            // Custom error handling logic similar to tqc_error_manager.raise_unanticipated
            throw new RuntimeException("Unable to insert claim pool cessions", e);
        }
    }

    // Method to generate crpc_code based on sysdate and sequence
    private Long generateCrpcCode() {
        // Use your own logic for generating crpc_code here (e.g., using sysdate and sequence)
        String year = String.valueOf(LocalDate.now().getYear());
        Long sequenceValue = sqlSequence.getNextCrpcCodeSequenceValue();
        return Long.valueOf(year + sequenceValue);
    }

    private void processXolCessions(String vClaimNo, Long vIpuCode, Long prrdCode) {
        List<GinXolUwCessions> xolDetails = ginXolUwCessionsRepository
                .findByXolucIpuCodeAndXolucPrrdCode(vIpuCode, prrdCode);

        xolDetails.forEach(detail -> {
            // Insert XOL cession details into gin_xol_clms_vmlp_cessions
            GinXolClmsVmlpCessions cession = new GinXolClmsVmlpCessions();
            cession.setXolvcCode(generateNextXolvcCode().longValue());
            cession.setXolvcCmbClaimNo(vClaimNo);
            cession.setXolvcXolucCode(detail.getXolucCode());
            cession.setXolvcIpuCode(detail.getXolucIpuCode());
            cession.setXolvcPrrdCode(detail.getXolucPrrdCode());
            cession.setXolvcXasCode(detail.getXolucXasCode());
            cession.setXolvcXolvmCode(detail.getXolucXolvmCode());
            cession.setXolvcCessionPct(detail.getXolucCessionPct());
            cession.setXolvcCededSi(detail.getXolucCededSi());
            cession.setXolvcCurCode(BigDecimal.valueOf(detail.getXolucCurCode()));
            ginXolClmsVmlpCessionsRepository.save(cession);
        });
    }

    private void updateClaimMasterBookings(String vClaimNo, BigDecimal grRet, BigDecimal retAmt, BigDecimal retRate) {
        Optional<GinClaimMasterBookings> claim = ginClaimMasterBookingsRepository.findById(vClaimNo);
        if (claim.isPresent()) {
            GinClaimMasterBookings claimToUpdate = claim.get();
            claimToUpdate.setCmbGrossComRetention(grRet);
            claimToUpdate.setCmbCompNetRetention(retAmt);
            claimToUpdate.setCmbCompRetentionRate(retRate);
            ginClaimMasterBookingsRepository.save(claimToUpdate);
        }
    }

    public Long getTreatyArrangementCount(Long sclCode, Date lossDate, Long curCode) {
        return ginTreatySetupsRepository.getTreatyArrangementCount(sclCode, lossDate, curCode);
    }


//    private String getTreatyType(BigDecimal vSclCode, LocalDate vLossDate, BigDecimal vCurCode) {
//        return ginTreatyArrangementsRepository.findDistinctTaTypeByTaCodeInAndAsUwyrAndCltSclCodeAndReiCurCode(
//                        ginClassTreatiesRepository.findByCltAsCodeIn(
//                                ginArrangementSetupsRepository.findByAsTaCodeIn(
//                                        ginTreatySetupsRepository.findByReiAsCodeIn(
//                                                ginTreatySetupsRepository.findByReiTrsCodeIn(
//                                                        ginClassTreatiesRepository
//                                                                .findByCltSclCode(vSclCode.longValue())
//                                                ).orElse(List.of())
//                                        ).orElse(List.of())
//                                ).orElse(List.of())
//                        ).orElse(List.of()), vLossDate.getYear(), vSclCode, vCurCode)
//                .orElseThrow(() -> new RuntimeException("Error determining treaty type for sub class " + vSclCode + " U/W Yr : " + vLossDate.format(DateTimeFormatter.ofPattern("yyyy"))));
//    }

    public String getTreatyType(Long sclCode, Date lossDate, Long curCode) {
        try {
            String treatyType = ginTreatyArrangementsRepository.getDistinctTreatyType(sclCode, lossDate, curCode);

            if (treatyType == null) {
                throw new RuntimeException("No treaty type found for subclass " + sclCode +
                        " U/W Yr: " + toYearString(lossDate));
            }

            return treatyType;
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("No treaty type found for subclass " + sclCode +
                    " U/W Yr: " + toYearString(lossDate));
        } catch (TooManyRowsAffectedException e) {
            throw new RuntimeException("More than one arrangement found for subclass " + sclCode +
                    " U/W Yr: " + toYearString(lossDate));
        }
    }

    private String toYearString(Date date) {
        return new java.text.SimpleDateFormat("YYYY").format(date);
    }

    private void processReinPoolPerils(String vClaimNo, BigDecimal vClmUwYr, BigDecimal vSclCode, BigDecimal vCurCode,
                                       String vCurSymbol, BigDecimal vPolBatchNo, BigDecimal vCvtCode) {
        List<GinSubclCoverRiPoolRates> poolPerils = ginSubclCoverRiPoolRatesRepository
                .findByScrprCovtCodeAndScrprSclCode(vCvtCode, vSclCode);

        poolPerils.forEach(peril -> {
            // Insert pool cession details into gin_claim_rein_pool_cessions
            GinClaimReinPoolCessions cession = new GinClaimReinPoolCessions();
            cession.setCrpcCode(generateNextCrprcCode().longValue());
            cession.setCrpcCmbClaimNo(vClaimNo);
            cession.setCrpcUwyr(vClmUwYr.longValue());
            cession.setCrpcRate(peril.getScrprReinRate());
            cession.setCrpcPolBatchNo(vPolBatchNo.longValue());
            cession.setCrpcSclCode(vSclCode.longValue());
            cession.setCrpcPolCurCode(vCurCode.longValue());
            cession.setCrpcPoolCurCode(vCurCode.longValue());
            cession.setCrpcPolCurSymbol(vCurSymbol);
            cession.setCrpcPoolCurSymbol(vCurSymbol);
            cession.setCrpcPrprdCode(null);
            cession.setCrpcScrprCode(peril.getScrprCode());
            ginClaimReinPoolCessionsRepository.save(cession);
        });
    }

    private BigDecimal generateNextCtrtcCode() {
        return BigDecimal.valueOf(ginClaimTreatyCessionsRepository.findMaxCtrtcCode() + 1L);
    }

    private BigDecimal generateNextFccCode() {
        return BigDecimal.valueOf(ginClaimFacreCessionsRepository.findMaxFccCode() + 1);
    }

    private BigDecimal generateNextCrpcCode() {
        return BigDecimal.valueOf(ginClaimReinPoolCessionsRepository.findMaxCrpcCode() + 1);
    }

    private BigDecimal generateNextCrprcCode() {
        return BigDecimal.valueOf(ginClaimReinPoolCessionsRepository.findMaxCrprcCode() + 1);
    }

    private BigDecimal generateNextXolvcCode() {
        return BigDecimal.valueOf(ginXolClmsVmlpCessionsRepository.findMaxXolvcCode() + 1);
    }
}