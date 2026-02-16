package com.turnquest.setupsdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class LmsProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROD_CODE")
    private BigDecimal prodCode;

    @Column(name = "PROD_DESC")
    private String prodDesc;

    @Column(name = "PROD_SHT_DESC")
    private String prodShtDesc;

    @Column(name = "PROD_POL_CODE_FIX")
    private String prodPolCodeFix;

    @Column(name = "PROD_CLM_CODE_FIX")
    private String prodClmCodeFix;

    @Column(name = "PROD_LAPSE_PRD_DAYS")
    private BigDecimal prodLapsePrdDays;

    @Column(name = "PROD_REIN_MAX_PRD_DAYS")
    private BigDecimal prodReinMaxPrdDays;

    @Column(name = "PROD_MIN_AGE_LIMIT_YRS")
    private BigDecimal prodMinAgeLimitYrs;

    @Column(name = "PROD_MAX_AGE_LIMIT_YRS")
    private BigDecimal prodMaxAgeLimitYrs;

    @Column(name = "PROD_CANC_NOTICE_DAYS")
    private BigDecimal prodCancNoticeDays;

    @Column(name = "PROD_MIN_TERM_YRS")
    private BigDecimal prodMinTermYrs;

    @Column(name = "PROD_MAX_TERM_YRS")
    private BigDecimal prodMaxTermYrs;

    @Column(name = "PROD_MIN_SURRENDER_PRD_DAYS")
    private BigDecimal prodMinSurrenderPrdDays;

    @Column(name = "PROD_MIN_LOAN_PRD_DAYS")
    private BigDecimal prodMinLoanPrdDays;

    @Column(name = "PROD_LOANABLE")
    private String prodLoanable;

    @Column(name = "PROD_LOAN_LOOKUP")
    private String prodLoanLookup;

    @Column(name = "PROD_LOAN_MAX_PCT")
    private BigDecimal prodLoanMaxPct;

    @ManyToOne
    @JoinColumn(name = "PROD_CLA_CODE")
    private LmsClasses lmsClasses;

    @Column(name = "PROD_DEPENDT_COVERED")
    private String prodDependtCovered;

    @Column(name = "PROD_LOAN_PRODUCT")
    private String prodLoanProduct;

    @Column(name = "PROD_DEFAULT_DOB")
    private LocalDate prodDefaultDob;

    @Column(name = "PROD_POL_SEQ")
    private BigDecimal prodPolSeq;

    @Column(name = "PROD_CLM_SEQ")
    private BigDecimal prodClmSeq;

    @Column(name = "PROD_REFUND_ALLOWED")
    private String prodRefundAllowed;

    @Column(name = "PROD_MONTHLY_LAPSE_PRD")
    private BigDecimal prodMonthlyLapsePrd;

    @Column(name = "PROD_QUARTER_LAPSE_PRD")
    private BigDecimal prodQuarterLapsePrd;

    @Column(name = "PROD_SEMI_A_LAPSE_PRD")
    private BigDecimal prodSemiALapsePrd;

    @Column(name = "PROD_ANNUALLY_LAPSE_PRD")
    private BigDecimal prodAnnuallyLapsePrd;

    @Column(name = "PROD_REMARKS")
    private String prodRemarks;

    @Column(name = "PROD_YR_TO_MONTH_RATE")
    private BigDecimal prodYrToMonthRate;

    @Column(name = "PROD_YR_TO_QUATER_RATE")
    private BigDecimal prodYrToQuaterRate;

    @Column(name = "PROD_YR_TO_S_ANNL_RATE")
    private BigDecimal prodYrToSAnnlRate;

    @Column(name = "PROD_PRTL_MATURTY_PERCT")
    private String prodPrtlMaturtyPerct;

    @Column(name = "PROD_PARTL_MATURTY_APPLBLE")
    private String prodPartlMaturtyApplble;

    @Column(name = "PROD_P_MATURITY_LAST_NO_YRS")
    private BigDecimal prodPMaturityLastNoYrs;

    @Column(name = "PROD_LOANABLE_PERC")
    private BigDecimal prodLoanablePerc;

    @Column(name = "PROD_PROP_CODE_FIX")
    private String prodPropCodeFix;

    @Column(name = "PROD_PROP_SEQ")
    private BigDecimal prodPropSeq;

    @Column(name = "PROD_POLICY_WORD_DOC")
    private String prodPolicyWordDoc;

    @Column(name = "PROD_PERIOD_MULTIPLES")
    private BigDecimal prodPeriodMultiples;

    @Column(name = "PROD_PARTIAL_CANCEL_ALLOWED")
    private String prodPartialCancelAllowed;

    @Column(name = "PROD_SAVINGS_COVERED")
    private String prodSavingsCovered;

    @Column(name = "PROD_MIN_PAID_UP_PRD_DAYS")
    private BigDecimal prodMinPaidUpPrdDays;

    @Column(name = "PROD_MNTH_TO_QTR_FCTOR")
    private BigDecimal prodMnthToQtrFctor;

    @Column(name = "PROD_MNTH_TO_S_ANNL_FCTOR")
    private BigDecimal prodMnthToSAnnlFctor;

    @Column(name = "PROD_MNTH_TO_ANNL_FCTOR")
    private BigDecimal prodMnthToAnnlFctor;

    @Column(name = "PROD_APPLICABLE_LAPSE_TYPE")
    private String prodApplicableLapseType;

    @Column(name = "PROD_MINIMUM_FCL_MEMBERS")
    private BigDecimal prodMinimumFclMembers;

    @Column(name = "PROD_FCL_MAX_AMT")
    private BigDecimal prodFclMaxAmt;

    @Column(name = "PROD_FCL_FACTOR1")
    private BigDecimal prodFclFactor1;

    @Column(name = "PROD_FCL_FACTOR2")
    private BigDecimal prodFclFactor2;

    @Column(name = "PROD_EXPECTED_SCH_RECPT_DAY")
    private BigDecimal prodExpectedSchRecptDay;

    @Column(name = "PROD_RENEWAL_ALLOWED")
    private String prodRenewalAllowed;

    @Column(name = "PROD_QUO_COSTING_SCH_RPT")
    private String prodQuoCostingSchRpt;

    @Column(name = "PROD_QUO_SAVINGS_SCH_RPT")
    private String prodQuoSavingsSchRpt;

    @Column(name = "PROD_QUO_FE_SCH_RPT")
    private String prodQuoFeSchRpt;

    @Column(name = "PROD_UW_COSTING_SCH_RPT")
    private String prodUwCostingSchRpt;

    @Column(name = "PROD_UW_SAVING_SCH_RPT")
    private String prodUwSavingSchRpt;

    @Column(name = "PROD_UW_FE_SCH_RPT")
    private String prodUwFeSchRpt;

    @Column(name = "PROD_ADD_REF_PREM_PERC")
    private BigDecimal prodAddRefPremPerc;

    @Column(name = "PROD_SCH_ADJ_PERIOD")
    private BigDecimal prodSchAdjPeriod;

    @Column(name = "PROD_MAX_EXT_PERIOD")
    private BigDecimal prodMaxExtPeriod;

    @Column(name = "PROD_INITIAL_SCH_ENDRSE")
    private String prodInitialSchEndrse;

    @Column(name = "PROD_EXTENTION_ALLOWED")
    private String prodExtentionAllowed;

    @Column(name = "PROD_TYPE")
    private String prodType;

    @Column(name = "PROD_SURR_EFF_DATE")
    private String prodSurrEffDate;

    @Column(name = "PROD_SURR_ALLOWED")
    private String prodSurrAllowed;

    @Column(name = "PROD_CANCEL_TYPE")
    private String prodCancelType;

    @Column(name = "PROD_MIN_LOAN_AMT")
    private BigDecimal prodMinLoanAmt;

    @Column(name = "PROD_UW_REFUND_SCH_RPT")
    private String prodUwRefundSchRpt;

    @Column(name = "PROD_POL_COSTING_SCH_RPT")
    private String prodPolCostingSchRpt;

    @Column(name = "PROD_POL_SAVING_SCH_RPT")
    private String prodPolSavingSchRpt;

    @Column(name = "PROD_POL_FE_SCH_RPT")
    private String prodPolFeSchRpt;

    @Column(name = "PROD_FULL_MATRTY_AGE")
    private BigDecimal prodFullMatrtyAge;

    @Column(name = "PROD_MIN_MATRTY_TERM")
    private BigDecimal prodMinMatrtyTerm;

    @Column(name = "PROD_OS_LOAN_CALC")
    private String prodOsLoanCalc;

    @Column(name = "PROD_LOANS_ALLOWED")
    private BigDecimal prodLoansAllowed;

    @Column(name = "PROD_GRP_RATES_MIN")
    private BigDecimal prodGrpRatesMin;

    @Column(name = "PROD_ACCPT_LTR_RPT")
    private String prodAccptLtrRpt;

    @Column(name = "PROD_POSTPN_DECL_RPT")
    private String prodPostpnDeclRpt;

    @Column(name = "PROD_UW_ASSMT_RPT")
    private String prodUwAssmtRpt;

    @Column(name = "PROD_POL_SCH_RPT")
    private String prodPolSchRpt;

    @Column(name = "PROD_REIN_ADV_RPT")
    private String prodReinAdvRpt;

    @Column(name = "PROD_QUO_WRITEUP_RPT")
    private String prodQuoWriteupRpt;

    @Column(name = "PROD_QUO_RPT")
    private String prodQuoRpt;

    @Column(name = "PROD_PREM_TAX_RATE")
    private BigDecimal prodPremTaxRate;

    @Column(name = "PROD_REIN_PREM_TAX_RATE")
    private BigDecimal prodReinPremTaxRate;

    @Column(name = "PROD_OPEN_COVER")
    private String prodOpenCover;

    @Column(name = "PROD_AIR_COVERED")
    private String prodAirCovered;

    @Column(name = "PROD_HOSP_LIMIT")
    private BigDecimal prodHospLimit;

    @Column(name = "PROD_WKLY_INDMTY_LIMIT")
    private BigDecimal prodWklyIndmtyLimit;

    @Column(name = "PROD_MIN_SA")
    private BigDecimal prodMinSa;

    @Column(name = "PROD_MIN_PREM")
    private BigDecimal prodMinPrem;

    @Column(name = "PROD_ANNUAL_PREM")
    private BigDecimal prodAnnualPrem;

    @Column(name = "PROD_PREM_DISC")
    private BigDecimal prodPremDisc;

    @Column(name = "PROD_CLAIM_EXPIRY_PRD")
    private BigDecimal prodClaimExpiryPrd;

    @Column(name = "PROD_DEBIT_ACC_NO")
    private String prodDebitAccNo;

    @Column(name = "PROD_PAIDUP_VAL_FORMULA")
    private String prodPaidupValFormula;

    @Column(name = "PROD_SURRENDER_VAL_FORMULA")
    private String prodSurrenderValFormula;

    @Column(name = "PROD_REN_COSTING_SCH_RPT")
    private String prodRenCostingSchRpt;

    @Column(name = "PROD_REN_FE_SCH_RPT")
    private String prodRenFeSchRpt;

    @Column(name = "PROD_REN_SAVING_SCH_RPT")
    private String prodRenSavingSchRpt;

    @Column(name = "PROD_MAX_FUNERAL_COVER")
    private BigDecimal prodMaxFuneralCover;

    @Column(name = "PROD_QUO_AGGR_DTLS_RPT")
    private String prodQuoAggrDtlsRpt;

    @Column(name = "PROD_UNIT_RATE_APPLICABLE")
    private String prodUnitRateApplicable;

    @Column(name = "PROD_PROFIT_SHARE_RATE_PERC")
    private BigDecimal prodProfitShareRatePerc;

    @Column(name = "PROD_WEF")
    private LocalDate prodWef;

    @Column(name = "PROD_WET")
    private LocalDate prodWet;

    @Column(name = "PROD_GEN_POL_NO")
    private String prodGenPolNo;

    @Column(name = "PROD_RI_LEVEL")
    private String prodRiLevel;

    @Column(name = "PROD_REN_GRACE_PRD_DAYS")
    private BigDecimal prodRenGracePrdDays;

    @Column(name = "PROD_EMP_FUND_PAY_PRD")
    private BigDecimal prodEmpFundPayPrd;

    @Column(name = "PROD_LOANISSUEDT_DAYS")
    private BigDecimal prodLoanissuedtDays;

    @Column(name = "PROD_GL_CONTROL_CODE")
    private String prodGlControlCode;

    @Column(name = "PROD_MATURITY_OPTION")
    private String prodMaturityOption;

    @Column(name = "PROD_ANNUITY_ALLOWED")
    private String prodAnnuityAllowed;

    @Column(name = "PROD_REFUND_COMM")
    private String prodRefundComm;

    @Column(name = "PROD_RISK_CHARGE_APPLICABLE")
    private String prodRiskChargeApplicable;

    @Column(name = "PROD_INVEST_ALL_PREM")
    private String prodInvestAllPrem;

    @Column(name = "PROD_SA_FACTR_SETUP")
    private String prodSaFactrListup;

    @Column(name = "PROD_BASIC_CVR_EXEMPTED")
    private String prodBasicCvrExempted;

    @Column(name = "PROD_COVER_CEASE_AGE")
    private BigDecimal prodCoverCeaseAge;

    @Column(name = "PROD_SAVINGS_SCHEDULE_NO_RPT")
    private String prodSavingsScheduleNoRpt;

    @Column(name = "PROD_FE_SCHEDULE_NO_RPT")
    private String prodFeScheduleNoRpt;

    @Column(name = "PROD_COSTING_SCHEDULE_NO_RPT")
    private String prodCostingScheduleNoRpt;

    @Column(name = "PROD_F2_SVT_CODE")
    private BigDecimal prodF2SvtCode;

    @Column(name = "PROD_SVT_CODE")
    private BigDecimal prodSvtCode;

    @Column(name = "PROD_ESCALATION_ALLOWED")
    private String prodEscalationAllowed;

    @Column(name = "PROD_PROP_INITIALIZATION")
    private String prodPropInitialization;

    @Column(name = "PROD_XOL_SETUP")
    private String prodXolListup;

    @Column(name = "PROD_INIT_PRICE")
    private BigDecimal prodInitPrice;

    @Column(name = "PROD_INIT_DATE")
    private LocalDate prodInitDate;

    @Column(name = "PROD_PRTL_WITHDRWL_ALLOWED")
    private String prodPrtlWithdrwlAllowed;

    @Column(name = "PROD_SURR_VAL_SA")
    private String prodSurrValSa;

    @Column(name = "PROD_CLM_SA")
    private String prodClmSa;

    @Column(name = "PROD_ALLOW_COMMUTATION")
    private String prodAllowCommutation;

    @Column(name = "PROD_PAY_OS_MATURITIES")
    private String prodPayOsMaturities;

    @Column(name = "PROD_PYMT_REPORT")
    private String prodPymtReport;

    @Column(name = "PROD_LOAN_PYMT_RPT")
    private String prodLoanPymtRpt;

    @Column(name = "PROD_BONUS_MAX_OS_INST")
    private BigDecimal prodBonusMaxOsInst;

    @Column(name = "PROD_MIN_COOLINGOFF_PRD")
    private BigDecimal prodMinCoolingoffPrd;

    @Column(name = "PROD_CLM_ADVICE")
    private String prodClmAdvice;

    @Column(name = "PROD_FNL_DISCHARGE")
    private String prodFnlDischarge;

    @Column(name = "PROD_DEATH_CLM_ADVICE")
    private String prodDeathClmAdvice;

    @Column(name = "PROD_DEATH_CLM_PYMT_INPUT")
    private String prodDeathClmPymtInput;

    @Column(name = "PROD_CLM_FNL_DISCHARGE")
    private String prodClmFnlDischarge;

    @Column(name = "PROD_ESC_COMP_MODE")
    private String prodEscCompMode;

    @Column(name = "PROD_LAPSE_TYPE")
    private String prodLapseType;

    @Column(name = "PROD_INV_PERC")
    private BigDecimal prodInvPerc;

    @Column(name = "PROD_MIN_PRT_WTHDRW_PRD")
    private BigDecimal prodMinPrtWthdrwPrd;

    @Column(name = "PROD_PRT_WTHDRW_PECT")
    private BigDecimal prodPrtWthdrwPect;

    @Column(name = "PROD_PRT_WTHDRW_ONCE_AFTER")
    private BigDecimal prodPrtWthdrwOnceAfter;

    @Column(name = "PROD_MIN_PRT_WTHDRW_BAL")
    private BigDecimal prodMinPrtWthdrwBal;

    @Column(name = "PROD_LOAN_GRACE_PRD")
    private String prodLoanGracePrd;

    @Column(name = "PROD_LAS_SEX")
    private String prodLasSex;

    @Column(name = "PROD_USE_JOINT_ANB")
    private String prodUseJointAnb;

    @Column(name = "PROD_ALLOC_FREQ")
    private String prodAllocFreq;

    @Column(name = "PROD_CALC_TERM_FR_RTR_AGE")
    private String prodCalcTermFrRtrAge;

    @Column(name = "PROD_PAY_GRATUITY")
    private String prodPayGratuity;

    @Column(name = "PROD_COVER_LETTER")
    private String prodCoverLetter;

    @Column(name = "PROD_EXC_NOT_AGE")
    private BigDecimal prodExcNotAge;

    @Column(name = "PROD_EXC_NOT_SA")
    private BigDecimal prodExcNotSa;

    @Column(name = "PROD_MIN_EARNINGS_PRD")
    private BigDecimal prodMinEarningsPrd;

    @Column(name = "PROD_VAL_INTR_CALC_MODE")
    private String prodValIntrCalcMode;

    @Column(name = "PROD_EMV_CALCULATION_TYPE")
    private String prodEmvCalculationType;

    @Column(name = "PROD_ALLOW_UNIT_RATE")
    private String prodAllowUnitRate;

    @Column(name = "PROD_QUO_SEQ")
    private BigDecimal prodQuoSeq;

    @Column(name = "PROD_MIN_RTIR_AGE")
    private BigDecimal prodMinRtirAge;

    @Column(name = "PROD_MAX_RTIR_AGE")
    private BigDecimal prodMaxRtirAge;

    @Column(name = "PROD_RTIR_AGE_DIST")
    private String prodRtirAgeDist;

    @Column(name = "PROD_MANUAL_LC_FACTOR")
    private String prodManualLcFactor;

    @Column(name = "PROD_STATUS")
    private String prodStatus;

    @Column(name = "PROD_CERT_OF_COVER")
    private String prodCertOfCover;

    @Column(name = "PROD_PROPOSAL_PYMT_REPORT")
    private String prodProposalPymtReport;

    @Column(name = "PROD_REINS_FORMULAR")
    private String prodReinsFormular;

    @Column(name = "PROD_ANN_FORMULAR")
    private String prodAnnFormular;

    @Column(name = "PROD_AMORTZ_RPT")
    private String prodAmortzRpt;

    @Column(name = "PROD_POL_CANC_PYMNT_RPT")
    private String prodPolCancPymntRpt;

    @Column(name = "PROD_NFL_ALLOCATION")
    private String prodNflAllocation;

    @Column(name = "PROD_NFL_PRD")
    private BigDecimal prodNflPrd;

    @Column(name = "PROD_BONUS_FORMULAR")
    private String prodBonusFormular;

    @Column(name = "PROD_TBONUS_ALLOWED")
    private String prodTbonusAllowed;

    @Column(name = "PROD_RATE_GENDER")
    private String prodRateGender;

    @Column(name = "PROD_TBONUS_BASEDON")
    private String prodTbonusBasedon;

    @Column(name = "PROD_DTH_SA_FACTS")
    private String prodDthSaFacts;

    @Column(name = "PROD_CALC_INV_FROM_SA")
    private String prodCalcInvFromSa;

    @Column(name = "PROD_INV_YR_TO_MONTH_RATE")
    private BigDecimal prodInvYrToMonthRate;

    @Column(name = "PROD_INV_YR_TO_QUATER_RATE")
    private BigDecimal prodInvYrToQuaterRate;

    @Column(name = "PROD_INV_YR_TO_S_ANNL_RATE")
    private BigDecimal prodInvYrToSAnnlRate;

    @Column(name = "PROD_EARNING_PRD_TYPE")
    private String prodEarningPrdType;

    @Column(name = "PROD_FCL_CALC_TYPE")
    private String prodFclCalcType;

    @Column(name = "PROD_LC_PREM_FROM_INTR")
    private String prodLcPremFromIntr;

    @Column(name = "PROD_MIN_TAX_EMPT_AGE")
    private BigDecimal prodMinTaxEmptAge;

    @Column(name = "PROD_MIN_LUMPSUM_TAX_EMPT")
    private BigDecimal prodMinLumpsumTaxEmpt;

    @Column(name = "PROD_QUO_COIN_SCH_RPT")
    private String prodQuoCoinSchRpt;

    @Column(name = "PROD_QUO_COINF_SCH_RPT")
    private String prodQuoCoinfSchRpt;

    @Column(name = "PROD_NON_MEDICAL")
    private String prodNonMedical;

    @Column(name = "PROD_PENS_TYPE")
    private String prodPensType;

    @Column(name = "PROD_PENS_CONTRI_LIMIT")
    private BigDecimal prodPensContriLimit;

    @Column(name = "PROD_PENS_REGISTERED")
    private String prodPensRegistered;

    @Column(name = "PROD_LOAN_GUARD")
    private String prodLoanGuard;

    @Column(name = "PROD_DISP_INV_SA")
    private String prodDispInvSa;

    @Column(name = "PROD_MNTH_TO_WEEKLY_FCTOR")
    private BigDecimal prodMnthToWeeklyFctor;

    @Column(name = "PROD_MNTH_TO_DAILY_FCTOR")
    private BigDecimal prodMnthToDailyFctor;

    @Column(name = "PROD_YR_TO_WEEKLY_RATE")
    private BigDecimal prodYrToWeeklyRate;

    @Column(name = "PROD_YR_TO_DAILY_RATE")
    private BigDecimal prodYrToDailyRate;

    @Column(name = "PROD_MIN_DTH_BNFT_ALLOWED")
    private String prodMinDthBnftAllowed;

    @Column(name = "PROD_CLM_PYMNT_FORM")
    private String prodClmPymntForm;

    @Column(name = "PROD_DEATH_CLM_STMT")
    private String prodDeathClmStmt;

    @Column(name = "PROD_CLM_ACK_LETTER")
    private String prodClmAckLetter;

    @Column(name = "PROD_DEATH_ACK_NOTE")
    private String prodDeathAckNote;

    @Column(name = "PROD_CLM_BONUS_CALC_FORM")
    private String prodClmBonusCalcForm;

    @Column(name = "PROD_CLM_ANALYSIS_SHEET")
    private String prodClmAnalysisSheet;

    @Column(name = "PROD_CLM_DISCHARGE_LETTER")
    private String prodClmDischargeLetter;

    @Column(name = "PROD_SURR_PYMNT_FORM")
    private String prodSurrPymntForm;

    @Column(name = "PROD_SURR_BONUS_CALC_FORM")
    private String prodSurrBonusCalcForm;

    @Column(name = "PROD_SURR_NOTICE_LETTER")
    private String prodSurrNoticeLetter;

    @Column(name = "PROD_SURR_DISCHARGE_LETTER")
    private String prodSurrDischargeLetter;

    @Column(name = "PROD_SURR_QUOT_FORM")
    private String prodSurrQuotForm;

    @Column(name = "PROD_HISTORICAL_RPT")
    private String prodHistoricalRpt;

    @Column(name = "PROD_LEDGER_CARD")
    private String prodLedgerCard;

    @Column(name = "PROD_MUILTPLE_JASSRDS")
    private String prodMuiltpleJassrds;

    @Column(name = "PROD_JLIFE_RATE_FMLR")
    private String prodJlifeRateFmlr;

    @Column(name = "PROD_JLIFE_RATE_FACTR")
    private BigDecimal prodJlifeRateFactr;

    @Column(name = "PROD_VAL_RATES_PER_OPTN")
    private String prodValRatesPerOptn;

    @Column(name = "PROD_QUO_EXPIRY_PRD")
    private BigDecimal prodQuoExpiryPrd;

    @Column(name = "PROD_AUTO_GEN_PYRLL_NO")
    private String prodAutoGenPyrllNo;

    @Column(name = "PROD_CLM_REJECT_LETTER_RPT")
    private String prodClmRejectLetterRpt;

    @Column(name = "PROD_FMS_RECEIPTING")
    private String prodFmsReceipting;

    @Column(name = "PROD_STAMP_LOGO")
    private String prodStampLogo;

    @Column(name = "PROD_WTGPRD_PER_DEP_TYPE")
    private String prodWtgprdPerDepType;

    @Column(name = "PROD_AUTO_RENEWAL_DTH")
    private String prodAutoRenewalDth;

    @Column(name = "PROD_APPLY_CLM_DISCNT")
    private String prodApplyClmDiscnt;

    @Column(name = "PROD_FCL_SA_FORMULA")
    private String prodFclSaFormula;

    @Column(name = "PROD_CLM_RELEASE")
    private String prodClmRelease;

    @Column(name = "PROD_SA_MED_REF_LIMIT")
    private BigDecimal prodSaMedRefLimit;

    @Column(name = "PROD_APPL_MP_TO_RF")
    private String prodApplMpToRf;

    @Column(name = "PROD_YR_TO_ANNL_RATE")
    private BigDecimal prodYrToAnnlRate;

    @Column(name = "PROD_MNTH_TO_MNTHLY_FCTOR")
    private BigDecimal prodMnthToMnthlyFctor;

    @Column(name = "PROD_INV_RIDER_ALLOWED")
    private String prodInvRiderAllowed;

    @Column(name = "PROD_EXP_PERIOD")
    private BigDecimal prodExpPeriod;

    @Column(name = "PROD_EXP_TLR")
    private BigDecimal prodExpTlr;

    @Column(name = "PROD_CERT")
    private String prodCert;

    @Column(name = "PROD_CHECKOFF_PRTL_MAT_GPRD")
    private BigDecimal prodCheckoffPrtlMatGprd;

    @Column(name = "PROD_CASH_PRTL_MAT_GPRD")
    private BigDecimal prodCashPrtlMatGprd;

    @Column(name = "PROD_SCHEME_TYPE")
    private String prodSchemeType;

    @Column(name = "PROD_REG_NO")
    private String prodRegNo;

    @Column(name = "PROD_REG_DATE")
    private LocalDate prodRegDate;

    @Column(name = "PROD_RATE_TYPE")
    private String prodRateType;

    @Column(name = "PROD_MIN_CONTRIBUTION")
    private BigDecimal prodMinContribution;

    @Column(name = "PROD_MAX_PREMIUM_TERM")
    private BigDecimal prodMaxPremiumTerm;

    @Column(name = "PROD_MBR_WITHDRWL_STMT_RPT")
    private String prodMbrWithdrwlStmtRpt;

    @Column(name = "PROD_CONTRIBUTION_HAS_RISKPREM")
    private String prodContributionHasRiskprem;

    @Column(name = "PROD_POL_ALLOWED")
    private BigDecimal prodPolAllowed;

    @Column(name = "PROD_NTU_PERIOD")
    private BigDecimal prodNtuPeriod;

    @Column(name = "PROD_NTUC_PERIOD")
    private BigDecimal prodNtucPeriod;

    @Column(name = "PROD_CONTR_LIMIT")
    private BigDecimal prodContrLimit;

    @Column(name = "PROD_MIN_PAID_UP_AMT")
    private BigDecimal prodMinPaidUpAmt;

    @Column(name = "PROD_LIM_CAP_INJ")
    private String prodLimCapInj;

    @Column(name = "PROD_TOT_CAP_INJ")
    private BigDecimal prodTotCapInj;

    @Column(name = "PROD_MIN_CAP_INJ_AMT")
    private BigDecimal prodMinCapInjAmt;

    @Column(name = "PROD_MAX_CAP_INJ_AMT")
    private BigDecimal prodMaxCapInjAmt;

    @Column(name = "PROD_CAP_INJ_PRD")
    private String prodCapInjPrd;

    @Column(name = "PROD_CM_LAPSE_PRD")
    private BigDecimal prodCmLapsePrd;

    @Column(name = "PROD_NCM_LAPSE_PRD")
    private BigDecimal prodNcmLapsePrd;

    @Column(name = "PROD_ALLOW_CONTRIBUTION_REMOVE")
    private String prodAllowContributionRemove;

    @Column(name = "PROD_CONTRIBUTION_EXPIRYPERIOD")
    private BigDecimal prodContributionExpiryperiod;

    @Column(name = "PROD_STOP_ESCALLATION")
    private String prodStopEscallation;

    @Column(name = "PROD_WTG_PRD_ON_REINST")
    private BigDecimal prodWtgPrdOnReinst;

    @Column(name = "PROD_RE_WP_GRC_PRD")
    private BigDecimal prodReWpGrcPrd;

    @Column(name = "PROD_PREMIUM_HOLIDAY")
    private String prodPremiumHoliday;

    @Column(name = "PROD_PREMIUM_HOLIDAY_PERIOD")
    private BigDecimal prodPremiumHolidayPeriod;

    @Column(name = "PROD_NO_PREM_HOLDYS_ALLOWED")
    private BigDecimal prodNoPremHoldysAllowed;

    @Column(name = "PROD_LAPSE_WITH_FUND")
    private String prodLapseWithFund;

    @Column(name = "PROD_MED_GRACE_PERIOD")
    private BigDecimal prodMedGracePeriod;

    @Column(name = "PROD_IS_ACTIVE")
    private String prodIsActive;

    @Column(name = "PROD_QUO_AGGR_LETT")
    private String prodQuoAggrLett;

    @Column(name = "PROD_INV_RIDER_MAX_CONTRIB")
    private BigDecimal prodInvRiderMaxContrib;

    @Column(name = "PROD_EMPYR_FUND_WTHD_PCT")
    private BigDecimal prodEmpyrFundWthdPct;

    @Column(name = "PROD_PROP_RCPT_REFUND_RPT")
    private String prodPropRcptRefundRpt;

    @Column(name = "PROD_POL_RCPT_REFUND_RPT")
    private String prodPolRcptRefundRpt;

    @Column(name = "PROD_ADMIN_TYPE")
    private String prodAdminType;

    @Column(name = "PROD_LBL_CODE")
    private BigDecimal prodLblCode;

    @Column(name = "PROD_OVERRIDE_AGE")
    private String prodOverrideAge;

    @Column(name = "PROD_BUSINESS_LINE")
    private String prodBusinessLine;

    @Column(name = "PROD_ORG_CODE")
    private BigDecimal prodOrgCode;

    @Column(name = "PROD_UMBRELLA")
    private String prodUmbrella;

    @Column(name = "PROD_CATASTROPHE_LIMIT")
    private BigDecimal prodCatastropheLimit;

    @Column(name = "PROD_TERM_PRD_IN")
    private String prodTermPrdIn;

    @Column(name = "PROD_PAY_MULTIPLE_PAYEES")
    private String prodPayMultiplePayees;

    @Column(name = "PROD_FULL_MAT_FACTOR")
    private BigDecimal prodFullMatFactor;

    @Column(name = "PROD_UMBRELLA_TYPE")
    private String prodUmbrellaType;

    @Column(name = "PROD_MIN_EMPLYMNT_PRD_MNTHS")
    private BigDecimal prodMinEmplymntPrdMnths;

    @Column(name = "PROD_MAX_MASTER_POLICIES")
    private BigDecimal prodMaxMasterPolicies;

    @Column(name = "PROD_TYPE_DESC")
    private String prodTypeDesc;

    @Column(name = "PROD_AGN_NAME")
    private String prodAgnName;

    @Column(name = "PROD_PLAN_TYPE")
    private String prodPlanType;

    @Column(name = "PROD_AGN_CODE")
    private BigDecimal prodAgnCode;

    @Column(name = "PROD_FCL_WAIT_PRD")
    private BigDecimal prodFclWaitPrd;

    @Column(name = "PROD_ESCALATION_COMPULSORY")
    private String prodEscalationCompulsory;

    @Column(name = "PROD_ESCALATION_MIN_RATE")
    private BigDecimal prodEscalationMinRate;

    @Column(name = "PROD_ESCAL_RATE_DIV_FACTOR")
    private BigDecimal prodEscalRateDivFactor;

    @Column(name = "PROD_CATEGORY")
    private String prodCategory;

    @Column(name = "PROD_SCORE_ACCEPTED")
    private BigDecimal prodScoreAccepted;

    @Column(name = "PROD_SCORE_INCEPTED")
    private BigDecimal prodScoreIncepted;

    @Column(name = "PROD_FULL_MATURITY_FACTOR")
    private BigDecimal prodFullMaturityFactor;

    @Column(name = "PROD_INV_RIDER_TYPE")
    private String prodInvRiderType;

    @Column(name = "PROD_REIN_MAX_ENTRY_AGE")
    private BigDecimal prodReinMaxEntryAge;

    @Column(name = "PROD_ANN_EXTRA_PYMTS")
    private String prodAnnExtraPymts;

    @Column(name = "PROD_ANN_EXTRA_PYMTS_NO")
    private BigDecimal prodAnnExtraPymtsNo;

    @Column(name = "PROD_ANN_EXTRA_PYMTS_DAY")
    private BigDecimal prodAnnExtraPymtsDay;

    @Column(name = "PROD_REGULATED")
    private String prodRegulated;

    @Column(name = "PROD_ALLOW_DEP_PREM_INV")
    private String prodAllowDepPremInv;

    @Column(name = "PROD_CALC_FROM")
    private String prodCalcFrom;

    @Column(name = "PROD_PAY_MEDICAL")
    private String prodPayMedical;

    @Column(name = "PROD_CALC_FROM_PRECEDENCE")
    private String prodCalcFromPrecedence;

    @Column(name = "PROD_MAX_AGE")
    private BigDecimal prodMaxAge;

    @Column(name = "PROD_AAL_LIMIT")
    private BigDecimal prodAalLimit;

    @Column(name = "PROD_POL_CONDITIONS_RPT")
    private String prodPolConditionsRpt;

    @Column(name = "PROD_PRORATION_MODE")
    private String prodProrationMode;

    @Column(name = "PROD_IPOL_SEQ")
    private BigDecimal prodIpolSeq;

    @Column(name = "PROD_MIN_RCPT_REFUND_PRD")
    private BigDecimal prodMinRcptRefundPrd;

    @Column(name = "PROD_CLM_VALUE_FACTOR")
    private BigDecimal prodClmValueFactor;

    @Column(name = "PROD_CHANGE_MEM_AT_RENEWL")
    private String prodChangeMemAtRenewl;

    @Column(name = "PROD_FIXED_INT")
    private String prodFixedInt;

    @Column(name = "PROD_MIN_NO_OF_MEMBERS")
    private BigDecimal prodMinNoOfMembers;

    @Column(name = "PROD_PRD_BETWEEN_PW_LOAN")
    private BigDecimal prodPrdBetweenPwLoan;

    @Column(name = "PROD_BENEFICIARIES_ALLOWED")
    private String prodBeneficiariesAllowed;

    @Column(name = "PROD_PRD_BTN_PW_LOAN")
    private BigDecimal prodPrdBtnPwLoan;

    @Column(name = "PROD_RESTRICT_BEN_CHANGE")
    private String prodRestrictBenChange;

    @Column(name = "PROD_BEN_AGE_TO_GET_TERM")
    private String prodBenAgeToGetTerm;

    @Column(name = "PROD_MAX_BENEFICIARIES")
    private BigDecimal prodMaxBeneficiaries;

    @Column(name = "PROD_COMM_RATE_PERIOD_TYPE")
    private String prodCommRatePeriodType;

    @Column(name = "PROD_ESCALATION_YRS")
    private BigDecimal prodEscalationYrs;

    @Column(name = "PROD_ALLOW_FORECLOSURE")
    private String prodAllowForeclosure;

    @Column(name = "PROD_FORECLOSURE_NOTICE_PERC")
    private BigDecimal prodForeclosureNoticePerc;

    @Column(name = "PROD_FORECLOSURE_PERC")
    private BigDecimal prodForeclosurePerc;

    @Column(name = "PROD_ESC_SA_COMP_MODE")
    private String prodEscSaCompMode;

    @Column(name = "PROD_DEFAULT")
    private String prodDefault;

    @Column(name = "PROD_MAT_DISCHARGE_LETTER")
    private String prodMatDischargeLetter;

    @Column(name = "PROD_MAT_PU_DISCHARGE_LETTER")
    private String prodMatPuDischargeLetter;

    @Column(name = "PROD_MAT_PRTL_DISCHARGE_FORM")
    private String prodMatPrtlDischargeForm;

    @Column(name = "PROD_IFRS_NAME")
    private String prodIfrsName;

    @Column(name = "PROD_REGULATOR_TYPE_ID")
    private String prodRegulatorTypeId;

    @Column(name = "PROD_MAT_PYMNT_FORM")
    private String prodMatPymntForm;

    @Column(name = "PROD_MAT_PU_PYMNT_FORM")
    private String prodMatPuPymntForm;

    @Column(name = "PROD_MAT_PRTL_PYMNT_FORM")
    private String prodMatPrtlPymntForm;



    @OneToMany(mappedBy = "popProdCode", cascade = CascadeType.DETACH)
    @JsonManagedReference()
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<LmsProdOptions> lmsProdOptions;

    @OneToMany(mappedBy = "lmsProducts", cascade = CascadeType.DETACH)
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<LmsProdSaPremLimits> psplProdCodes;

    @OneToMany(mappedBy = "pctProdCode", cascade = CascadeType.DETACH)
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<LmsProdCoverTypes> pctProdCodes;


    @OneToMany(mappedBy = "lmsProducts", cascade = CascadeType.DETACH)
    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<LmsMedLoadRates> lmsMedLoadRates;
}
