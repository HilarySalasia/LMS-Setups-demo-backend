package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.ClaimRecordDto;
import com.turnquest.setupsdemo.dto.UnauthorizedTransactionDto;
import com.turnquest.setupsdemo.dto.XolLayerDataDto;
import com.turnquest.setupsdemo.model.GinClaimXolRevDetails;
import com.turnquest.setupsdemo.model.GinClaimXolRevisions;
import com.turnquest.setupsdemo.model.GinXolTreatySetups;
import com.turnquest.setupsdemo.repository.*;
import com.turnquest.setupsdemo.service.CurrencyService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class XolReserveServiceImpl {

    @PersistenceContext
    private EntityManager entityManager;

    private final GinClaimMasterBookingsRepository claimMasterBookingsRepository;
    private final GinClaimRevisionsRepository claimRevisionsRepository;
    private final GinClaimXolRevisionsRepository claimXolRevisionsRepository;
    private final GinClaimXolRevDetailsRepository claimXolRevDetailsRepository;
    private final GinXolTreatySetupsRepository xolTreatySetupsRepository;
    private final GinXolTreatiesRepository xolTreatiesRepository;
    private final GinXolArrangementSetupsRepository xolArrangementSetupsRepository;
    private final GinXolTreatyArrangementsRepository xolTreatyArrangementsRepository;
    private final GinXolClassesRepository xolClassesRepository;
    private final GinXolClmsVmlpCessionsRepository xolClmsVmlpCessionsRepository;
    private final GinXolArrgmentVmlpRepository xolArrgmentVmlpRepository;
    private final GinXolUwCessionsRepository xolUwCessionsRepository;
    private final GinParametersRepository ginParametersPkgService;
    private final CurrencyService currencyExchangeService;
    private static final Logger log = LoggerFactory.getLogger(XolReserveServiceImpl.class);
    @Transactional
    public void processXolReservesNew(String vClaimNo, Date vDate, String vUser, Long vTranNo) {
        String vTrtCurrParam = "Y";
        String vXolType = "W";
        Long vBaseCurCode = 37L; // Assuming the base currency code is 37
        String vEnableXolParam = "N";
        String vXtaVlmp = "N";

        // Retrieve ENABLE_XOL_FUNCTIONALITY parameter
        try {
            vEnableXolParam = ginParametersPkgService.findByParamName("ENABLE_XOL_FUNCTIONALITY").get().getParamDesc();
        } catch (Exception e) {
            vEnableXolParam = "N";
        }

        // Retrieve xta_vlmp
        try {
            vXtaVlmp = xolTreatySetupsRepository.findXtaVlmpByClaimNo(vClaimNo);
        } catch (Exception e) {
            vXtaVlmp = "N";
        }

        // Process if xta_vlmp is 'N'
        if ("N".equals(vXtaVlmp)) {
            // Retrieve claim records
            List<ClaimRecordDto> claimRecords = claimMasterBookingsRepository.findClaimRecordsByClaimNo(
                    vClaimNo, vEnableXolParam, vTrtCurrParam);

            for (ClaimRecordDto rec : claimRecords) {
                // Calculate total XOL own retention and recovered amount
                BigDecimal vTotXolOwnRet = BigDecimal.ZERO;
                BigDecimal vTotRecAmt = BigDecimal.ZERO;

                // Calculate total XOL own retention and recovered amount using claimXolRevisionsRepository
                List<GinClaimXolRevisions> xolRevisions = claimXolRevisionsRepository
                        .findByCxrClaimNoAndCxrAuthorized(rec.getClaimNo(), "Y");
                for (GinClaimXolRevisions xolRevision : xolRevisions) {
                    vTotXolOwnRet = vTotXolOwnRet.add(xolRevision.getCxrGrossCompRetAmount().multiply(rec.getXchangerate()));
                    vTotRecAmt = vTotRecAmt.add(xolRevision.getCxrAmount().multiply(rec.getXchangerate()));
                }

                // Retrieve and process event-level data
                BigDecimal vEvntIncurred = BigDecimal.ZERO;
                if (rec.getCmbEveCode() != -20010000L && rec.getCmbEveCode() != -200001L) {
                    vEvntIncurred = claimMasterBookingsRepository.findEventIncurred(rec.getCmbEveCode(), vTrtCurrParam);
                } else {
                    vEvntIncurred = rec.getIncurred();
                }

                // Calculate total own and XOL retention
                BigDecimal vTotOwnAndXol = vTotXolOwnRet.add(vTotRecAmt);

                // Process unauthorized transactions
                List<UnauthorizedTransactionDto> unauthTransactions = claimRevisionsRepository.findUnauthorizedTransactions(
                        rec.getClaimNo(),
                        vTranNo,
                        vTrtCurrParam
                );
                for (UnauthorizedTransactionDto urec : unauthTransactions) {
                    BigDecimal vTrnsRecovAmt = BigDecimal.ZERO;
                    BigDecimal vTrnsOwnNewRet = BigDecimal.ZERO;
                    BigDecimal vClmIncurred = BigDecimal.ZERO;
                    vEvntIncurred = BigDecimal.ZERO;
                    BigDecimal vIncurred = BigDecimal.ZERO;
                    BigDecimal vOwnNewRet = BigDecimal.ZERO;
                    BigDecimal vBalToCede = BigDecimal.ZERO;
                    BigDecimal vRecovAmt = BigDecimal.ZERO;

                    // Calculate total own and XOL retention
                    vClmIncurred = vClmIncurred.add(urec.getIncurred());

                    // Calculate event level incurred
                    vEvntIncurred = vEvntIncurred.add(urec.getIncurred());
                    vIncurred = vEvntIncurred;

                    // Create new XOL revision
                    Long vCxrCode = generateCxrCode();
                    GinClaimXolRevisions newXolRevision = new GinClaimXolRevisions();
                    newXolRevision.setCxrCode(BigDecimal.valueOf(vCxrCode));
                    newXolRevision.setCxrClaimNo(rec.getClaimNo());
                    newXolRevision.setCxrEveCode(BigDecimal.valueOf(rec.getCmbEveCode()));
                    newXolRevision.setCxrDate(vDate.toLocalDate());
                    newXolRevision.setCxrAmount(BigDecimal.ZERO); // Initialize to 0
                    newXolRevision.setCxrClaimYear(BigDecimal.valueOf(rec.getUwYear()));
                    newXolRevision.setCxrGrossCompRetAmount(vIncurred.divide(urec.getXchangerate(), 2, BigDecimal.ROUND_HALF_UP));
                    newXolRevision.setCxrSclCode(BigDecimal.valueOf(rec.getSclCode()));
                    newXolRevision.setCxrCurCode(BigDecimal.valueOf(rec.getCmbCurCode()));
                    newXolRevision.setCxrGgtTransNo(BigDecimal.valueOf(urec.getTransno()));
                    newXolRevision.setCxrAuthorized("Y");

                    claimXolRevisionsRepository.save(newXolRevision);

                    // Process treaty layers
                    List<GinXolTreatySetups> treatyLayers = xolTreatySetupsRepository.findAllByXasUwyrAndXolcSclCodeAndXolsCurCode(
                            rec.getUwYear(), rec.getSclCode(), rec.getCmbCurCode());

                    Map<Integer, XolLayerDataDto> vXolLayerTotalsData = new HashMap<Integer, XolLayerDataDto>();

                    for (GinXolTreatySetups curTrt : treatyLayers) {
                        // Apply exchange rate
                        BigDecimal vExhangeRate = BigDecimal.ONE;
                        if (curTrt.getXolsCurCode().equals(rec.getCmbCurCode())) {
                            vExhangeRate = currencyExchangeService.getCurrencyExchangeRate(rec.getCmbCurCode(), 2, 2).getVRate();
                        } else if (rec.getCmbCurCode().equals(vBaseCurCode) && !curTrt.getXolsCurCode().equals(vBaseCurCode)) {
                            vExhangeRate = currencyExchangeService.getCurrencyExchangeRate(curTrt.getXolsCurCode().longValue(), 2, 2).getVRate();
                        } else if (!rec.getCmbCurCode().equals(vBaseCurCode) && curTrt.getXolsCurCode().equals(vBaseCurCode)) {
                            vExhangeRate = currencyExchangeService.getCurrencyExchangeRate(rec.getCmbCurCode(), 2, 2).getVRate();
                            vExhangeRate = BigDecimal.ONE.divide(vExhangeRate, 2, BigDecimal.ROUND_HALF_UP);
                        }

                        BigDecimal vDeductible = curTrt.getXolsDeductibleLimit().multiply(vExhangeRate);
                        BigDecimal vXolLayerLimit = curTrt.getXolsMaxClaimLimit().multiply(vExhangeRate);

                        // Calculate own retention
                        if (rec.getCmbEveCode() != -20010000L && rec.getCmbEveCode() != -200001L) {
                            vOwnNewRet = calculateOwnRetention(
                                    vTotOwnAndXol,
                                    vIncurred,
                                    vDeductible,
                                    vTotXolOwnRet
                            );
                        } else {
                            if (vIncurred.compareTo(vDeductible) <= 0) {
                                vOwnNewRet = vIncurred.subtract(vTotXolOwnRet);
                                vRecovAmt = BigDecimal.ZERO.subtract(vXolLayerTotalsData.get(curTrt.getXolsLayer()).getCurrentRecvdAmt());
                            } else if (vIncurred.compareTo(vDeductible.add(vXolLayerLimit)) <= 0) {
                                vOwnNewRet = BigDecimal.ZERO;
                                vRecovAmt = vIncurred.subtract(vDeductible).subtract(vXolLayerTotalsData.get(curTrt.getXolsLayer()).getCurrentRecvdAmt());
                            } else {
                                vOwnNewRet = BigDecimal.ZERO;
                                vRecovAmt = BigDecimal.ZERO;
                            }
                            vBalToCede = vBalToCede.subtract(vRecovAmt).subtract(vOwnNewRet);
                        }

                        // Calculate vRecovAmt and vBalToCede
                        vBalToCede = vIncurred.subtract(vOwnNewRet).subtract(vTotOwnAndXol);
                        vXolLayerLimit = vXolLayerLimit.subtract(vXolLayerTotalsData.get(curTrt.getXolsLayer()).getCurrentRecvdAmt());

                        if (vBalToCede.compareTo(vXolLayerLimit) > 0) {
                            vRecovAmt = vXolLayerLimit;
                        } else {
                            vRecovAmt = vBalToCede;
                        }

                        // Update the balance to cede and recover amount
                        vBalToCede = vBalToCede.subtract(vRecovAmt);

                        // Update total XOL own retention and recovered amount
                        vTotXolOwnRet = vTotXolOwnRet.add(vOwnNewRet);
                        vTotRecAmt = vTotRecAmt.add(vRecovAmt);
                        vTotOwnAndXol = vTotXolOwnRet.add(vTotRecAmt);

                        // Create new XOL cession details if necessary
                        if (vRecovAmt.compareTo(BigDecimal.ZERO) != 0) {
                            // Generate cxrd_code
                            Long vCxrdCode = generateCxrdCode();

                            // Create new XOL cession details
                            GinClaimXolRevDetails newXolCession = new GinClaimXolRevDetails();
                            newXolCession.setCxrdCode(BigDecimal.valueOf(vCxrdCode));
                            newXolCession.setCxrdXolsCode(curTrt.getXolsCode());
                            newXolCession.setCxrdClmNo(rec.getClaimNo());
                            newXolCession.setCxrdAmount(BigDecimal.ZERO); // Initialize to 0
                            newXolCession.setCxrdSclCode(BigDecimal.valueOf(rec.getSclCode()));
                            newXolCession.setCxrdEveCode(BigDecimal.valueOf(rec.getCmbEveCode()));
                            newXolCession.setCxrdEveShtDesc(rec.getCmbEveShtDesc());
                            newXolCession.setCxrdAmtToCede(vRecovAmt.divide(urec.getXchangerate(), 2, BigDecimal.ROUND_HALF_UP));
                            newXolCession.setCxrdDate(vDate.toLocalDate());
                            newXolCession.setCxrdXasCode(curTrt.getXolsXasCode());
                            newXolCession.setCxrdXolCode(curTrt.getXolsXolCode());
                            newXolCession.setCxrdExcessAmt(vBalToCede.divide(urec.getXchangerate(), 2, BigDecimal.ROUND_HALF_UP));
                            newXolCession.setCxrdClmYear(BigDecimal.valueOf(rec.getUwYear()));
                            newXolCession.setCxrdPrevCode(BigDecimal.valueOf(vCxrCode));
                            newXolCession.setCxrdCompRetAmt(vOwnNewRet.divide(urec.getXchangerate(), 2, BigDecimal.ROUND_HALF_UP));
                            newXolCession.setCxrdCxrCode(BigDecimal.valueOf(vCxrCode));
                            newXolCession.setCxrdGgtTransNo(BigDecimal.valueOf(urec.getTransno()));
                            newXolCession.setCxrdAuthorized("Y");

                            claimXolRevDetailsRepository.save(newXolCession);

                            // Update XOL revision
                            claimXolRevisionsRepository.updateCxrAmountAndCxrGrossCompRetAmount(
                                    vCxrCode,
                                    vTrnsRecovAmt.divide(urec.getXchangerate(), 2, BigDecimal.ROUND_HALF_UP),
                                    vTrnsOwnNewRet.divide(urec.getXchangerate(), 2, BigDecimal.ROUND_HALF_UP)
                            );
                        }

                        // Update layer totals
                        vXolLayerTotalsData.get(curTrt.getXolsLayer()).setCurrentRecvdAmt(vXolLayerTotalsData.get(curTrt.getXolsLayer()).getCurrentRecvdAmt().add(vRecovAmt));
                        vXolLayerTotalsData.get(curTrt.getXolsLayer()).setNewRetention(vXolLayerTotalsData.get(curTrt.getXolsLayer()).getNewRetention().add(vOwnNewRet));
                        vXolLayerTotalsData.get(curTrt.getXolsLayer()).setNewRecvdAmt(vXolLayerTotalsData.get(curTrt.getXolsLayer()).getNewRecvdAmt().add(vRecovAmt));
                        vXolLayerTotalsData.get(curTrt.getXolsLayer()).setExcessBalance(vXolLayerTotalsData.get(curTrt.getXolsLayer()).getExcessBalance().add(vBalToCede));
                    }
                }

                // Process cessions
                processCessions(vXolLayerTotalsData, xolClmVlmpData);
            }
        } else {
            // ... VLMP-related logic ...
        }
    }

    @Transactional
    public void processCessions(XolLayerTotalsData vLayersData, XolClmVlmpData vVlmpData) {
        for (int vLayer = 1; vLayer <= vLayersData.size(); vLayer++) {
            BigDecimal vOwnNewRet = BigDecimal.ZERO;
            BigDecimal vXolLayerLimit = BigDecimal.ZERO;
            BigDecimal vBalToCede = vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede.subtract(
                    vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).totOwnAndXol);

            // Calculate XOL layer limit
            if ("Y".equals(vLayersData.get(vLayer).maxLayer)) {
                vXolLayerLimit = vLayersData.get(vLayer).maxClaimLimit.max(
                        vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).xolvcCededSi.subtract(
                                vLayersData.get(vLayer).deductible
                        )
                );
            } else {
                vXolLayerLimit = vLayersData.get(vLayer).maxClaimLimit;
            }

            log.debug("---------------------------------------------------");
            log.debug("deductible={}", vLayersData.get(vLayer).deductible);
            log.debug("v_xol_layer_limit={}", vLayersData.get(vLayer).maxClaimLimit);
            log.debug("XOLvC_CEDED_SI={}", vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).xolvcCededSi);

            // Process first layer
            if ("Y".equals(vLayersData.get(vLayer).startLayer)) {
                if (vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).totOwnAndXol
                        .compareTo(vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede) <= 0) {
                    vXolLayerLimit = vXolLayerLimit.subtract(vLayersData.get(vLayer).currentRecvdAmt);

                    if (vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).xolOwnRet.compareTo(vLayersData.get(vLayer).deductible) < 0) {
                        vOwnNewRet = vLayersData.get(vLayer).deductible.min(
                                vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede
                        ).subtract(vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).xolOwnRet);
                    }

                    log.debug("incurred={}", vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede);
                    log.debug("v_xol_layer_limit={}", vXolLayerLimit);
                    log.debug("v_own_new_ret={}", vOwnNewRet);
                    log.debug("v_tot_own_and_xol={}", vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).totOwnAndXol);
                    log.debug("1111v_bal_tocede={}", vBalToCede);

                    vBalToCede = vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede
                            .subtract(vOwnNewRet).subtract(
                                    vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).totOwnAndXol
                            );
                    log.debug("22222v_bal_tocede={}", vBalToCede);

                    if (vBalToCede.compareTo(vXolLayerLimit) > 0) {
                        vRecovAmt = vXolLayerLimit;
                    } else {
                        vRecovAmt = vBalToCede;
                    }

                    vBalToCede = vBalToCede.subtract(vRecovAmt);
                    log.debug("33333v_bal_tocede={}", vBalToCede);
                } else {
                    vBalToCede = vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede
                            .subtract(vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).totOwnAndXol);

                    log.debug("345v_deductible={}", vLayersData.get(vLayer).deductible);
                    log.debug("v_incurred={}", vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede);
                    log.debug("v_bal_tocede={}", vBalToCede);
                    log.debug("v_xol_layer_limit={}", vXolLayerLimit);

                    if (vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede.compareTo(vLayersData.get(vLayer).deductible) <= 0) {
                        vOwnNewRet = vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede.subtract(
                                vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).xolOwnRet
                        );
                        vRecovAmt = vLayersData.get(vLayer).currentRecvdAmt.negate();
                    } else if (vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede.compareTo(
                            vLayersData.get(vLayer).deductible.add(vXolLayerLimit)
                    ) <= 0) {
                        vOwnNewRet = BigDecimal.ZERO;
                        vRecovAmt = vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede
                                .subtract(vLayersData.get(vLayer).deductible).subtract(
                                        vLayersData.get(vLayer).currentRecvdAmt
                                );
                    } else {
                        vOwnNewRet = BigDecimal.ZERO;
                        vRecovAmt = BigDecimal.ZERO;
                    }

                    vBalToCede = vBalToCede.subtract(vRecovAmt).subtract(vOwnNewRet);
                    log.debug("444444v_bal_tocede={}", vBalToCede);
                }
            } else {
                // Process other layers
                if (vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).totOwnAndXol
                        .compareTo(vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede) <= 0) {
                    vBalToCede = vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede
                            .subtract(vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).totOwnAndXol);

                    log.debug("5555v_bal_tocede={}", vBalToCede);

                    vXolLayerLimit = vXolLayerLimit.subtract(vLayersData.get(vLayer).currentRecvdAmt);

                    if (vBalToCede.compareTo(vXolLayerLimit) > 0) {
                        vRecovAmt = vXolLayerLimit;
                    } else {
                        vRecovAmt = vBalToCede;
                    }

                    vBalToCede = vBalToCede.subtract(vRecovAmt);
                    log.debug("66666v_bal_tocede={}", vBalToCede);
                } else {
                    log.debug("v_deductible={}", vLayersData.get(vLayer).deductible);
                    log.debug("v_incurred={}", vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede);
                    log.debug("layer_totals={}", vLayersData.get(vLayer).currentRecvdAmt);
                    log.debug("xols_layer={}", vLayer);

                    if (vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede.compareTo(
                            vLayersData.get(vLayer).deductible
                    ) <= 0) {
                        vOwnNewRet = BigDecimal.ZERO;
                        vRecovAmt = vLayersData.get(vLayer).currentRecvdAmt.negate();
                    } else if (vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede.compareTo(
                            vLayersData.get(vLayer).deductible.add(vXolLayerLimit)
                    ) <= 0) {
                        vOwnNewRet = BigDecimal.ZERO;
                        vRecovAmt = vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede
                                .subtract(vLayersData.get(vLayer).deductible).subtract(
                                        vLayersData.get(vLayer).currentRecvdAmt
                                );
                    } else {
                        vOwnNewRet = BigDecimal.ZERO;
                        vRecovAmt = BigDecimal.ZERO;
                    }

                    vBalToCede = vBalToCede.subtract(vRecovAmt).subtract(vOwnNewRet);
                    log.debug("77777v_bal_tocede={}", vBalToCede);
                    log.debug("888888v_bal_tocede={}", vBalToCede);
                }
            }

            // Update data in vVlmpData
            vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).xolOwnRet =
                    vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).xolOwnRet.add(vOwnNewRet);
            vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).recoverdAmt =
                    vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).recoverdAmt.add(vRecovAmt);
            vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).totOwnAndXol =
                    vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).xolOwnRet.add(
                            vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).recoverdAmt
                    );

            log.debug("v_own_new_ret={}", vOwnNewRet);
            log.debug("v_tot_xol_own_ret={}", vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).xolOwnRet);
            log.debug("v_incurred={}", vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).gnetToCede);
            log.debug("v_trns_recov_amt={}", vTrnsRecovAmt);
            log.debug("v_xol_layer_limit={}", vXolLayerLimit);
            log.debug("v_bal_tocede={}", vBalToCede);

            // Update data in vLayersData
            if (vRecovAmt.compareTo(BigDecimal.ZERO) != 0) {
                vLayersData.get(vLayer).newRecvdAmt = vRecovAmt;
                vLayersData.get(vLayer).excessBalance = vBalToCede;
                vLayersData.get(vLayer).newRetention = vOwnNewRet;
                vLayersData.get(vLayer).currentRecvdAmt = vLayersData.get(vLayer).currentRecvdAmt.add(vRecovAmt);
                log.debug("Layer={} v_recov_amt={}", vLayer, vLayersData.get(vLayer).currentRecvdAmt);
            }

            // Update excess balance for the last layer
            if ("Y".equals(vLayersData.get(vLayer).maxLayer)) {
                vVlmpData.get(vLayersData.get(vLayer).getXolvmCode()).excessBal = vBalToCede;
            }
        }
    }

    // Helper methods for calculations and processing
    private BigDecimal calculateOwnRetention(BigDecimal vTotOwnAndXol, BigDecimal vIncurred, BigDecimal vDeductible, BigDecimal vTotXolOwnRet) {
        BigDecimal vOwnNewRet = BigDecimal.ZERO;
        if (vTotOwnAndXol.compareTo(vIncurred) <= 0) {
            if (vTotXolOwnRet.compareTo(vDeductible) < 0) {
                vOwnNewRet = vDeductible.min(vIncurred).subtract(vTotXolOwnRet);
            } else if (vTotXolOwnRet.compareTo(vDeductible) > 0) {
                vOwnNewRet = vDeductible.subtract(vTotXolOwnRet);
            }
        } else {
            if (vIncurred.compareTo(vDeductible) <= 0) {
                vOwnNewRet = vIncurred.subtract(vTotXolOwnRet);
            }
        }
        return vOwnNewRet;
    }

    private Long generateCxrCode() {
        // Implement logic to generate unique cxr_code
        return 1L; // Replace with actual logic
    }

    private Long generateCxrdCode() {
        // Implement logic to generate unique cxrd_code
        return 1L; // Replace with actual logic
    }

    // ... other helper methods for calculations and processing ...
}
