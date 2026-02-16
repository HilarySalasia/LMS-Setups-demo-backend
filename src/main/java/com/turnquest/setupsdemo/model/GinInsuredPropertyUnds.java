package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This table is used to store the details of the insured property(Risk details)
 */
@Entity
@Table(name = "GIN_INSURED_PROPERTY_UNDS")
@Data
public class GinInsuredPropertyUnds {
    @Id
    @Column(name = "IPU_CODE", nullable = false, precision = 22)
    private Long ipuCode;

    /**
 * RISK SHORT DESCRIPTION
 */
@Column(name = "IPU_PROPERTY_ID", length = 60)
private String ipuPropertyId;

/**
 * QUANTITY
 */
@Column(name = "IPU_QTY", precision = 22)
private Long ipuQty;

/**
 * VALUE OF THE RISK
 */
@Column(name = "IPU_VALUE", precision = 22, scale = 5)
private BigDecimal ipuValue;

/**
 * RISK EFFECTIVE DATE FROM
 */
@Column(name = "IPU_WEF", nullable = false)
private Date ipuWef;

/**
 * RISK EFFECTIVE DATE TO
 */
@Column(name = "IPU_WET", nullable = false)
private Date ipuWet;

/**
 * POLICY NUMBER
 */
@Column(name = "IPU_POL_POLICY_NO", length = 30)
private String ipuPolPolicyNo;

/**
 * ENDORSEMENT NUMBER
 */
@Column(name = "IPU_POL_REN_ENDOS_NO", length = 50)
private String ipuPolRenEndosNo;

/**
 * POLICY REFERENCE NUMBER
 */
@Column(name = "IPU_POL_BATCH_NO", nullable = false, precision = 22)
private Long ipuPolBatchNo;

/**
 * RISK BASIC PREMIUM
 */
@Column(name = "IPU_BASIC_PREMIUM", precision = 27, scale = 5)
private BigDecimal ipuBasicPremium;

/**
 * RISK NET PREMIUM
 */
@Column(name = "IPU_NETT_PREMIUM", precision = 27, scale = 5)
private BigDecimal ipuNettPremium;

/**
 * COMPULSORY EXCESS AMOUNT
 */
@Column(name = "IPU_COMPULSORY_EXCESS", precision = 27, scale = 5)
private BigDecimal ipuCompulsoryExcess;

/**
 * Redundant
 */
@Column(name = "IPU_ADD_THEFT_EXCESS", precision = 22, scale = 5)
private BigDecimal ipuAddTheftExcess;

/**
 * Redundant
 */
@Column(name = "IPU_ADD_EXP_EXCESS", precision = 22, scale = 5)
private BigDecimal ipuAddExpExcess;

/**
 * Redundant
 */
@Column(name = "IPU_PRR_RATE", precision = 22, scale = 5)
private BigDecimal ipuPrrRate;

/**
 * COMPANY OWN RETENTION REINSURANCE AMOUNT
 */
@Column(name = "IPU_COMP_RETENTION", precision = 22, scale = 5)
private BigDecimal ipuCompRetention;

/**
 * ESTIMATED MAXIMUM LOSS AMOUNT
 */
@Column(name = "IPU_POL_EST_MAX_LOSS", precision = 22, scale = 5)
private BigDecimal ipuPolEstMaxLoss;

/**
 * EXCESS AMOUNT TO BE CEDED FACULTATIVELY AT REINSURANCE
 */
@Column(name = "IPU_AVAIL_FULC_BAL", precision = 27, scale = 5)
private BigDecimal ipuAvailFulcBal;

/**
 * RISK ENDORSEMENT PREMIUM
 */
@Column(name = "IPU_ENDOS_DIFF_AMT", precision = 27, scale = 5)
private BigDecimal ipuEndosDiffAmt;

/**
 * RISK PREMIUM EFFECTIVE DATE
 */
@Column(name = "IPU_PREM_WEF")
private Date ipuPremWef;

    @Column(name = "IPU_EARTH_QUAKE_COVER", length = 1)
private String ipuEarthquakeCover; // Redundant

/**
 * Earthquake premium amount.
 */
@Column(name = "IPU_EARTH_QUAKE_PREM", precision = 22, scale = 5)
private BigDecimal ipuEarthquakePrem; // Redundant

/**
 * Location of the risk.
 */
@Column(name = "IPU_LOCATION", length = 500)
private String ipuLocation; // RISK LOCATION

/**
 * Risk training level.
 */
@Column(name = "IPU_ITL", precision = 22, scale = 5)
private BigDecimal ipuItl; // RISK TRAINING LEVEL

/**
 * Risk insured reference number.
 */
@Column(name = "IPU_POLIN_CODE", nullable = false, precision = 22)
private Long ipuPolinCode; // RISK INSURED REFERENCE NUMBER

@Column(name = "IPU_SEC_SECT_CODE", precision = 22)
private Long ipuSecSectCode; // Redundant

@Column(name = "IPU_SECT_SHT_DESC", length = 15)
private String ipuSectShtDesc; // Redundant

/**
 * Subclass reference.
 */
@Column(name = "IPU_SEC_SCL_CODE", nullable = false, precision = 22)
private Long ipuSecSclCode; // SUBCLASS REFERENCE

/**
 * Non-claim discount status.
 */
@Column(name = "IPU_NCD_STATUS", length = 15)
private String ipuNcdStatus; // NON CLAIM DISCOUNT STATUS

/**
 * Indicates if the certificate is issued or not.
 */
@Column(name = "IPU_CERT_ISSUED", length = 1)
private String ipuCertIssued; // CERTIFICATE ISSUED OR NOT

/**
 * Related risk for reinsurance.
 */
@Column(name = "IPU_RELATED_IPU_CODE", precision = 22)
private Long ipuRelatedIpuCode; // RELATED RISK FOR REINSURANCE

/**
 * Indicates if the premium is prorated or not.
 */
@Column(name = "IPU_PRORATA", length = 1)
private String ipuProrata; // PRORATE PREMIUM OR NOT

/**
 * Basic risk premium.
 */
@Column(name = "IPU_BP", precision = 22, scale = 5)
private BigDecimal ipuBp; // BASIC RISK PREMIUM

/**
 * Gross risk premium.
 */
@Column(name = "IPU_GP", precision = 22, scale = 5)
private BigDecimal ipuGp; // GROSS RISK PREMIUM

/**
 * But charge premium.
 */
@Column(name = "IPU_FP", precision = 22, scale = 5)
private BigDecimal ipuFp; // But Charge Premium

/**
 * Risk future annual premium.
 */
@Column(name = "IPU_FAP", precision = 25, scale = 5)
private BigDecimal ipuFap; // RISK FUTURE ANNUAL PREMIUM

/**
 * Previous risk reference.
 */
@Column(name = "IPU_PREV_IPU_CODE", precision = 22)
private Long ipuPrevIpuCode; // PREVIOUS RISK REFERENCE

/**
 * Indicates if the reinsurance is cumulative.
 */
@Column(name = "IPU_CUMMULATIVE_REINS", length = 1)
private String ipuCummulativeReins; // CUMMULATIVE REINSURANCE

/**
 * EML sum insured.
 */
@Column(name = "IPU_EML_SI", length = 1)
private String ipuEmlSi; // EML SUM INSURED

/**
 * Risk reinsurance level.
 */
@Column(name = "IPU_REINSURED", precision = 22)
private Long ipuReinsured; // RISK REINSURANCE LEVEL

@Column(name = "IPU_CT_CODE", precision = 22)
private Long ipuCtCode; // Redundant

    /**
 * Short description of the risk.
 */
@Column(name = "IPU_SHT_DESC", length = 15)
private String ipuShtDesc; // Redundant

/**
 * Quake or flood zone reference number.
 */
@Column(name = "IPU_QUZ_CODE", precision = 22)
private Long ipuQuzCode; // QUAKE OR FLOOD ZONE REFERENCE NUMBER

/**
 * Quake zone short description.
 */
@Column(name = "IPP_QUZ_SHT_DESC", length = 15)
private String ippQuzShtDesc; // Redundant

/**
 * Quake or flood zone ID.
 */
@Column(name = "IPU_QUZ_SHT_DESC", length = 15)
private String ipuQuzShtDesc; // QUAKE OR FLOOD ZONE ID

/**
 * Non-claim discount level.
 */
@Column(name = "IPU_NCL_LEVEL", precision = 22)
private Long ipuNclLevel; // For risk whose [IPU_NCD_STATUS] status is (Y)es, indicates the Non Claim Discount Level.

/**
 * Non-claim discount level.
 */
@Column(name = "IPU_NCD_LEVEL", precision = 22)
private Long ipuNcdLevel; // NON CLAIM DISCOUNT LEVEL

/**
 * Unique ID for the risk.
 */
@Column(name = "IPU_ID", nullable = false, precision = 22)
private Long ipuId; // UNIQUE ID FOR THE RISK

/**
 * Gross company retention.
 */
@Column(name = "IPU_GROSS_COMP_RETENTION", precision = 22, scale = 5)
private BigDecimal ipuGrossCompRetention; // GROSS COMPANY RETENTION

/**
 * Binder premium mask reference code.
 */
@Column(name = "IPU_BIND_CODE", precision = 22)
private Long ipuBindCode; // BINDER PREMIUM MASK REFERENCE CODE

/**
 * Commission amount.
 */
@Column(name = "IPU_COMMISSION", precision = 22, scale = 5)
private BigDecimal ipuCommission; // COMMISSION AMOUNT

/**
 * Endorsement commission amount.
 */
@Column(name = "IPU_COMM_ENDOS_DIFF_AMT", precision = 22, scale = 5)
private BigDecimal ipuCommEndosDiffAmt; // ENDORSEMENT COMMISSION AMOUNT

/**
 * Facre amount.
 */
@Column(name = "IPU_FACRE_AMOUNT", precision = 23, scale = 5)
private BigDecimal ipuFacreAmount; // FACRE AMOUNT

/**
 * Subclass product reference code.
 */
@Column(name = "IPU_CLP_CODE", precision = 22)
private Long ipuClpCode; // The assigned [GIN_PRODUCT_SUB_CLASSES.CLP_CODE] representing the sub class product for the risk.

/**
 * Excess rate.
 */
@Column(name = "IPU_EXCESS_RATE", precision = 22, scale = 5)
private BigDecimal ipuExcessRate; // Redundant

/**
 * Excess type.
 */
@Column(name = "IPU_EXCESS_TYPE", length = 1)
private String ipuExcessType; // Redundant

/**
 * Excess rate type.
 */
@Column(name = "IPU_EXCESS_RATE_TYPE", length = 10)
private String ipuExcessRateType; // Redundant

/**
 * Minimum excess amount.
 */
@Column(name = "IPU_EXCESS_MIN", precision = 22, scale = 5)
private BigDecimal ipuExcessMin; // Redundant

/**
 * Maximum excess amount.
 */
@Column(name = "IPU_EXCESS_MAX", precision = 22, scale = 5)
private BigDecimal ipuExcessMax; // Redundant

/**
 * Prerequisite risk reference number.
 */
@Column(name = "IPU_PREREQ_IPU_CODE", precision = 22)
private Long ipuPrereqIpuCode; // PREREQUISITE RISK REFERENCE NUMBER

/**
 * Escalation rate.
 */
@Column(name = "IPU_ESCALATION_RATE", precision = 22, scale = 5)
private BigDecimal ipuEscalationRate; // ESCALATION RATE

/**
 * Indicates if the risk is removed from the active risks.
 */
@Column(name = "IPU_ENDOS_REMOVE", length = 1)
private String ipuEndosRemove; // IS THE RISK REMOVE FROM THE ACTIVE RISKS

/**
 * Commission rate.
 */
@Column(name = "IPU_COMM_RATE", precision = 22, scale = 5)
private BigDecimal ipuCommRate; // COMMISSION RATE

/**
 * Previous policy batch number.
 */
@Column(name = "IPU_PREV_BATCH_NO", nullable = false, precision = 22)
private Long ipuPrevBatchNo; // PREVIOUS POLICY BATCH NUMBER

/**
 * Currency reference number.
 */
@Column(name = "IPU_CUR_CODE", nullable = false, precision = 22)
private Long ipuCurCode; // CURRENCE REFERENCE NUMBER

    /**
 * REINSURANCE REFERENCE NUMBER
 */
@Column(name = "IPU_RELR_CODE", precision = 22)
private Long ipuRelrCode;

/**
 * REINSURANCE ID
 */
@Column(name = "IPU_RELR_SHT_DESC", length = 200)
private String ipuRelrShtDesc;

/**
 * REINSURANCE AMOUNT
 */
@Column(name = "IPU_REINSURE_AMT", precision = 23, scale = 5)
private BigDecimal ipuReinsureAmt;

/**
 * CLIENT REFERENCE NUMBER
 */
@Column(name = "IPU_PRP_CODE", nullable = false, precision = 22)
private Long ipuPrpCode;

/**
 * REINSURANCE MAXIMUM EXPOSURE
 */
@Column(name = "IPU_MAX_EXPOSURE", precision = 27, scale = 5)
private BigDecimal ipuMaxExposure;

/**
 * COMPANY RETENTION RATE
 */
@Column(name = "IPU_COM_RETENTION_RATE", precision = 30, scale = 5)
private BigDecimal ipuComRetentionRate;

/**
 * EFFECTIVE DATE FROM
 */
@Column(name = "IPU_EFF_WEF")
private Date ipuEffWef;

/**
 * EFFECTIVE DATE TO
 */
@Column(name = "IPU_EFF_WET")
private Date ipuEffWet;

/**
 * RETROACTIVE COVER (YES OR NO)
 */
@Column(name = "IPU_RETRO_COVER", length = 1)
private String ipuRetroCover;

/**
 * RETROACTIVE COVER DATE
 */
@Column(name = "IPU_RETRO_WEF")
private Date ipuRetroWef;

/**
 * COVER REFERENCE NUMBER
 */
@Column(name = "IPU_COVT_CODE", precision = 22)
private Long ipuCovtCode;

/**
 * COVER ID
 */
@Column(name = "IPU_COVT_SHT_DESC", length = 50)
private String ipuCovtShtDesc;

/**
 * RISK ENDORSEMENT SUM INSURED
 */
@Column(name = "IPU_SI_DIFF", precision = 25, scale = 5)
private BigDecimal ipuSiDiff;

/**
 * TERRITORY REFERENCE NUMBER
 */
@Column(name = "IPU_TERR_CODE", precision = 22)
private Long ipuTerrCode;

/**
 * TERRITORY ID
 */
@Column(name = "IPU_TERR_DESC", length = 200)
private String ipuTerrDesc;

/**
 * COMMENTS
 */
@Column(name = "IPU_COMMENTS", length = 500)
private String ipuComments;

/**
 * Redundant
 */
@Column(name = "IPU_FROM_TIME", length = 5)
private String ipuFromTime;

/**
 * MARINE CERTIFICATE
 */
@Column(name = "IPU_MAR_CERT_NO", length = 25)
private String ipuMarCertNo;

/**
 * ENDORSEMENT PREMIUM
 */
@Column(name = "IPU_TOT_ENDOS_PREM_DIF", precision = 25, scale = 5)
private BigDecimal ipuTotEndosPremDif;

/**
 * TOTAL GROSS PREMIUM
 */
@Column(name = "IPU_TOT_GP", precision = 25, scale = 5)
private BigDecimal ipuTotGp;

/**
 * TOTAL VALUE OF THE RISK
 */
@Column(name = "IPU_TOT_VALUE", precision = 25, scale = 5)
private BigDecimal ipuTotValue;

/**
 * COVER DAYS
 */
@Column(name = "IPU_COVER_DAYS", precision = 22)
private Long ipuCoverDays;

/**
 * GROUP COMPANY NET RETENTION
 */
@Column(name = "IPU_GRP_COMP_NET_RET", precision = 22, scale = 5)
private BigDecimal ipuGrpCompNetRet;

/**
 * GROUPED RISK SI PERCENTAGE
 */
@Column(name = "IPU_GRP_SI_RISK_PCT", precision = 22, scale = 5)
private BigDecimal ipuGrpSiRiskPct;

/**
 * GROUPED RISK TOP LOCATION
 */
@Column(name = "IPU_GRP_TOP_LOC", precision = 22, scale = 5)
private BigDecimal ipuGrpTopLoc;

/**
 * GROUPED RISK COMPANY RETENTION GROSS
 */
@Column(name = "IPU_GRP_COMP_GROSS_RET", precision = 30, scale = 5)
private BigDecimal ipuGrpCompGrossRet;

/**
 * PREVIOUS PREMIUM
 */
@Column(name = "IPU_PREV_PREM", precision = 25, scale = 5)
private BigDecimal ipuPrevPrem;

/**
 * REINSURANCE RECORD REFERENCE NUMBER
 */
@Column(name = "IPU_CURRENT_PRRD_CODE", precision = 22)
private Long ipuCurrentPrrdCode;

/**
 * FACLTATIVE AGENT COMMISSION RATE
 */
@Column(name = "IPU_RI_AGNT_COM_RATE", precision = 22, scale = 5)
private BigDecimal ipuRiAgntComRate;

/**
 * FACULTATIVE AGENT COMMISSION
 */
@Column(name = "IPU_RI_AGNT_COMM_AMT", precision = 30, scale = 5)
private BigDecimal ipuRiAgntCommAmt;

/**
 * TOTAL FUTURE ANNUAL PREMIUM
 */
@Column(name = "IPU_TOT_FAP", precision = 25, scale = 2)
private BigDecimal ipuTotFap;

/**
 * MAXIMUM DECLARATION REFUND PERCENTAGE
 */
@Column(name = "IPU_MAX_DC_REFUND_PCT", precision = 22, scale = 5)
private BigDecimal ipuMaxDcRefundPct;

/**
 * EXTRA PREMIUM
 */
@Column(name = "IPU_EXTRA_PREMIUM", precision = 30, scale = 5)
private BigDecimal ipuExtraPremium;

/**
 * RISK STATUS
 */
@Column(name = "IPU_STATUS", nullable = false, length = 3)
private String ipuStatus;

/**
 * RISK UNDERWRITING YEAR
 */
@Column(name = "IPU_UW_YR", nullable = false, precision = 4)
private Long ipuUwYr;

/**
 * Endose FAP Or BC
 */
@Column(name = "IPU_ENDOSE_FAP_OR_BC", length = 5)
private String ipuEndoseFapOrBc;

/**
 * TOTAL FIRST LOSS
 */
@Column(name = "IPU_TOT_FIRST_LOSS", precision = 38)
private Long ipuTotFirstLoss;

/**
 * ACCUMULATION LIMIT
 */
@Column(name = "IPU_ACCUMULATION_LIMIT", length = 100)
private String ipuAccumulationLimit;

    /**
 * IF THE SYSTEM COMPUTES MAXIMUM EXPOSURE OR IS DETERMINED BY THE USER
 */
@Column(name = "IPU_COMPUTE_MAX_EXPOSURE", length = 1)
private String ipuComputeMaxExposure;

/**
 * TRANSACTION EFFECTIVE TO DATE
 */
@Column(name = "IPU_TRANS_EFF_WET", nullable = false)
private Date ipuTransEffWet;

/**
 * PREMIUM TAX
 */
@Column(name = "IPU_PREM_TAX", precision = 25, scale = 5)
private BigDecimal ipuPremTax;

/**
 * Comment entered by the underwriter to explain any rate changes from what is defined in setup premiums
 */
@Column(name = "IPU_RATE_CHANGE_COMMENT", length = 200)
private String ipuRateChangeComment;

/**
 * TRANSACTION COUNT
 */
@Column(name = "IPU_TRANS_COUNT", nullable = false, precision = 5)
private Long ipuTransCount;

/**
 * PAID PREMIUM
 */
@Column(name = "IPU_PAID_PREMIUM", precision = 30, scale = 5)
private BigDecimal ipuPaidPremium;

/**
 * PAID TRAINING LEVY
 */
@Column(name = "IPU_PAID_TL", precision = 25, scale = 5)
private BigDecimal ipuPaidTl;

/**
 * INCEPTION UNDERWRITING YEAR
 */
@Column(name = "IPU_INCEPTION_UWYR", nullable = false, precision = 4)
private Long ipuInceptionUwyr;

/**
 * COMMENTS ON PREMIUM
 */
@Column(name = "IPU_PREM_COMMENT", length = 1)
private String ipuPremComment;

/**
 * COINSURANCE TRAINING LEVY
 */
@Column(name = "IPU_COIN_TL", precision = 25, scale = 5)
private BigDecimal ipuCoinTl;

/**
 * PAID DECLARATION PREMIUM
 */
@Column(name = "IPU_DC_PAID_PREMIUM", precision = 25, scale = 5)
private BigDecimal ipuDcPaidPremium;

/**
 * Store the Additional/Refund premium charged at Declaration
 */
@Column(name = "IPU_DC_AP", precision = 27, scale = 5)
private BigDecimal ipuDcAp;

/**
 * RISK DESCRIPTION
 */
@Column(name = "IPU_ITEM_DETAILS", length = 1000)
private String ipuItemDetails;

/**
 * EML REISURANCE BASE
 */
@Column(name = "IPU_EML_BASED_ON", nullable = false, length = 3)
private String ipuEmlBasedOn;

/**
 * AGGREGATE LIMITS
 */
@Column(name = "IPU_AGGREGATE_LIMITS", length = 1000)
private String ipuAggregateLimits;

/**
 * The ID of the Reinsurance Category the risk belongs to for reinsurance purposes as store in \[GIN\_RISK\_CATEGORIES\]
 */
@Column(name = "IPU_RC_CODE", precision = 22)
private Long ipuRcCode;

/**
 * The Risk Cateory short name corresponding to the ID defined in \[IPU\_RC\_CODE\]
 */
@Column(name = "IPU_RC_SHT_DESC", length = 100)
private String ipuRcShtDesc;

/**
 * Indicates if the cover allows free cover limit
 */
@Column(name = "IPU_FREE_LIMIT", length = 1)
private String ipuFreeLimit;

/**
 * SURVEY DATE
 */
@Column(name = "IPU_SURVEY_DATE")
private Date ipuSurveyDate;

/**
 * RISK DECLARED OR NOT
 */
@Column(name = "IPU_DECLARED", length = 1)
private String ipuDeclared;

/**
 * PREVIOUD FUTURE ANNUAL PREMIUM
 */
@Column(name = "IPU_PREV_FAP", precision = 22, scale = 5)
private BigDecimal ipuPrevFap;

/**
 * TOTAL PREVIOUD FUTURE ANNUAL PREMIUM
 */
@Column(name = "IPU_PREV_TOT_FAP", precision = 22, scale = 5)
private BigDecimal ipuPrevTotFap;

/**
 * MINIMUM PREMIUM USED
 */
@Column(name = "IPU_MIN_PREMIUM_USED", nullable = false, length = 1)
private String ipuMinPremiumUsed;

/**
 * CANCELLATION DAY
 */
@Column(name = "IPU_CANCELLATION_DAYS", precision = 5)
private Long ipuCancellationDays;

/**
 * ALLOWED COMMISSION RATE
 */
@Column(name = "IPU_ALLOWED_COMM_RATE", precision = 22, scale = 5)
private BigDecimal ipuAllowedCommRate;

/**
 * ALLOWED COMMISSION
 */
@Column(name = "IPU_ALLOWED_COMM_AMT", precision = 22, scale = 5)
private BigDecimal ipuAllowedCommAmt;

/**
 * DECLARATION PENALTY PERCENTAGE
 */
@Column(name = "IPU_DC_PENALTY_PCT", precision = 10, scale = 5)
private BigDecimal ipuDcPenaltyPct;

/**
 * Reinsure Diff Amt
 */
@Column(name = "IPU_REINSURE_DIFF_AMT", precision = 22, scale = 5)
private BigDecimal ipuReinsureDiffAmt;

/**
 * PREVIOUD REINSURANCE AMOUNT
 */
@Column(name = "IPU_PREV_REINSURE_AMT", precision = 22, scale = 5)
private BigDecimal ipuPrevReinsureAmt;

/**
 * POLICY HOLDER FUND
 */
@Column(name = "IPU_PHFUND", precision = 22, scale = 5)
private BigDecimal ipuPhfund;

/**
 * COINSURANCE POLICY HOLDER FUND
 */
@Column(name = "IPU_COIN_PHFUND", precision = 22, scale = 5)
private BigDecimal ipuCoinPhfund;

/**
 * ENFORCE COVER TYPE MINIMUM PREM
 */
@Column(name = "IPU_ENFORCE_CVT_MIN_PREM", length = 1)
private String ipuEnforceCvtMinPrem;

/**
 * Instal Prem
 */
@Column(name = "IPU_INSTAL_PREM", precision = 23, scale = 5)
private BigDecimal ipuInstalPrem;

/**
 * PREVIOUS REISURANCE SUM INSURED
 */
@Column(name = "IPU_PREV_RI_SI", precision = 22, scale = 5)
private BigDecimal ipuPrevRiSi;

/**
 * POLICY STATUS
 */
@Column(name = "IPU_POLICY_STATUS", length = 2)
private String ipuPolicyStatus;

/**
 * FLOOD OR QUAKE PREMIUM
 */
@Column(name = "IPU_EARTHQKE_PREM_DIFF", precision = 22, scale = 5)
private BigDecimal ipuEarthqkePremDiff;

/**
 * OVERRIDE REISURANCE RETENTION
 */
@Column(name = "IPU_OVERRIDE_RI_RETENTION", precision = 20, scale = 5)
private BigDecimal ipuOverrideRiRetention;

/**
 * INTERESTED PARTIES
 */
@Column(name = "IPU_RISK_OTH_INT_PARTIES", length = 100)
private String ipuRiskOthIntParties;

/**
 * PRORATA PREMIUM
 */
@Column(name = "IPU_PRORATA_SECT_PREM", precision = 20, scale = 5)
private BigDecimal ipuProrataSectPrem;

/**
 * NON PRORATA PREMIUM
 */
@Column(name = "IPU_NONPRORATA_SECT_PREM", precision = 20, scale = 5)
private BigDecimal ipuNonprorataSectPrem;

/**
 * PREVIUOS PRORATA PREMIUM
 */
@Column(name = "IPU_PREV_PRORATA_SECT_PREM", precision = 20, scale = 5)
private BigDecimal ipuPrevProrataSectPrem;

/**
 * PREVIOUS NON PRORATA PREMIUM
 */
@Column(name = "IPU_PREV_NONPRORATA_SECT_PREM", precision = 20, scale = 5)
private BigDecimal ipuPrevNonprorataSectPrem;

/**
 * TOTAL PRORATA PREMIUM
 */
@Column(name = "IPU_TOT_PRORATA_SECT_PREM", precision = 20, scale = 5)
private BigDecimal ipuTotProrataSectPrem;

/**
 * TOTAL NON PRORATA PREMIUM
 */
@Column(name = "IPU_TOT_NONPRORATA_SECT_PREM", precision = 20, scale = 5)
private BigDecimal ipuTotNonprorataSectPrem;

/**
 * TOTAL PREVIOUS PRORATA PREMIUM
 */
@Column(name = "IPU_PREV_TOT_PRORATA_S_PREM", precision = 20, scale = 5)
private BigDecimal ipuPrevTotProrataSPrem;

/**
 * TOTAL PREVIOUS NONPRORATA PREMIUM
 */
@Column(name = "IPU_PREV_TOT_NONPRORATA_S_PREM", precision = 20, scale = 5)
private BigDecimal ipuPrevTotNonprorataSPrem;

/**
 * Sub Agn Comm Rate
 */
@Column(name = "IPU_SUB_AGN_COMM_RATE", precision = 23, scale = 5)
private BigDecimal ipuSubAgnCommRate;

/**
 * Sub Agn Comm Amt
 */
@Column(name = "IPU_SUB_AGN_COMM_AMT", precision = 23, scale = 5)
private BigDecimal ipuSubAgnCommAmt;

/**
 * Lta Endos Com Amt
 */
@Column(name = "IPU_LTA_ENDOS_COM_AMT", precision = 23, scale = 5)
private BigDecimal ipuLtaEndosComAmt;

    /**
 * Lta Commission
 */
@Column(name = "IPU_LTA_COMMISSION", precision = 23, scale = 5)
private BigDecimal ipuLtaCommission;

/**
 * Lta Comm Rate
 */
@Column(name = "IPU_LTA_COMM_RATE", precision = 23, scale = 5)
private BigDecimal ipuLtaCommRate;

/**
 * Admin Fee Disc Amt
 */
@Column(name = "IPU_ADMIN_FEE_DISC_AMT", precision = 23, scale = 5)
private BigDecimal ipuAdminFeeDiscAmt;

/**
 * Admin Fee Disc Rate
 */
@Column(name = "IPU_ADMIN_FEE_DISC_RATE", precision = 23, scale = 5)
private BigDecimal ipuAdminFeeDiscRate;

/**
 * Lta Comm Disc Rate
 */
@Column(name = "IPU_LTA_COMM_DISC_RATE", precision = 23, scale = 5)
private BigDecimal ipuLtaCommDiscRate;

/**
 * Lta Comm Disc Amt
 */
@Column(name = "IPU_LTA_COMM_DISC_AMT", precision = 23, scale = 5)
private BigDecimal ipuLtaCommDiscAmt;

/**
 * Tot Families
 */
@Column(name = "IPU_TOT_FAMILIES", precision = 8)
private Long ipuTotFamilies;

/**
 * Tot Individuals
 */
@Column(name = "IPU_TOT_INDIVIDUALS", precision = 8)
private Long ipuTotIndividuals;

/**
 * Tot Females
 */
@Column(name = "IPU_TOT_FEMALES", precision = 8)
private Long ipuTotFemales;

/**
 * Tot Males
 */
@Column(name = "IPU_TOT_MALES", precision = 8)
private Long ipuTotMales;

/**
 * Conveyance Type
 */
@Column(name = "IPU_CONVEYANCE_TYPE", length = 50)
private String ipuConveyanceType;

/**
 * Stamp Duty
 */
@Column(name = "IPU_STAMP_DUTY", precision = 22, scale = 5)
private BigDecimal ipuStampDuty;

/**
 * MARKETER COMMISSION
 */
@Column(name = "IPU_MKTR_COM_AMT", precision = 23, scale = 5)
private BigDecimal ipuMktrComAmt;

/**
 * MARKETER COMMISSION RATE
 */
@Column(name = "IPU_MKTR_COM_RATE", precision = 10, scale = 5)
private BigDecimal ipuMktrComRate;

/**
 * VAT AMOUNT
 */
@Column(name = "IPU_VAT_AMT", precision = 27, scale = 5)
private BigDecimal ipuVatAmt;

/**
 * VAT RATE
 */
@Column(name = "IPU_VAT_RATE", precision = 23, scale = 5)
private BigDecimal ipuVatRate;

/**
 * Comm Disc Type
 */
@Column(name = "IPU_COMM_DISC_TYPE", length = 5)
private String ipuCommDiscType;

/**
 * Comm Disc Rate
 */
@Column(name = "IPU_COMM_DISC_RATE", precision = 23, scale = 5)
private BigDecimal ipuCommDiscRate;

/**
 * Comm Disc Amt
 */
@Column(name = "IPU_COMM_DISC_AMT", precision = 22, scale = 2)
private BigDecimal ipuCommDiscAmt;

/**
 * PREVIOUS RISK STATUS
 */
@Column(name = "IPU_PREV_STATUS", length = 5)
private String ipuPrevStatus;

/**
 * Rs Code
 */
@Column(name = "IPU_RS_CODE", precision = 22)
private Long ipuRsCode;

/**
 * Rescue Mem
 */
@Column(name = "IPU_RESCUE_MEM", length = 2)
private String ipuRescueMem;

/**
 * Ped Code
 */
@Column(name = "IPU_PED_CODE", precision = 22)
private Long ipuPedCode;

/**
 * Cover Suspended
 */
@Column(name = "IPU_COVER_SUSPENDED", length = 1)
private String ipuCoverSuspended;

/**
 * Suspend Wef
 */
@Column(name = "IPU_SUSPEND_WEF")
private Date ipuSuspendWef;

/**
 * Suspend Wet
 */
@Column(name = "IPU_SUSPEND_WET")
private Date ipuSuspendWet;

/**
 * Ncd Cert No
 */
@Column(name = "IPU_NCD_CERT_NO", length = 30)
private String ipuNcdCertNo;

/**
 * Pymt Install Pcts
 */
@Column(name = "IPU_PYMT_INSTALL_PCTS", length = 35)
private String ipuPymtInstallPcts;

/**
 * Susp Reinstmt Type
 */
@Column(name = "IPU_SUSP_REINSTMT_TYPE", length = 10)
private String ipuSuspReinstmtType;

/**
 * Install Period
 */
@Column(name = "IPU_INSTALL_PERIOD", precision = 22)
private Long ipuInstallPeriod;

/**
 * Rescue Charge
 */
@Column(name = "IPU_RESCUE_CHARGE", precision = 23, scale = 5)
private BigDecimal ipuRescueCharge;

/**
 * Previous Insurer
 */
@Column(name = "IPU_PREVIOUS_INSURER", length = 200)
private String ipuPreviousInsurer;

/**
 * Next Inst Prem
 */
@Column(name = "IPU_NEXT_INST_PREM", precision = 22, scale = 5)
private BigDecimal ipuNextInstPrem;

/**
 * Wtht
 */
@Column(name = "IPU_WTHT", precision = 23, scale = 4)
private BigDecimal ipuWtht;

/**
 * Drcr No
 */
@Column(name = "IPU_DRCR_NO", length = 20)
private String ipuDrcrNo;

/**
 * Post Retro Wet
 */
@Column(name = "IPU_POST_RETRO_WET")
private Date ipuPostRetroWet;

/**
 * Post Retro Cover
 */
@Column(name = "IPU_POST_RETRO_COVER", length = 1)
private String ipuPostRetroCover;

/**
 * Co Phfund
 */
@Column(name = "IPU_CO_PHFUND", precision = 23, scale = 5)
private BigDecimal ipuCoPhfund;

/**
 * Cover Note Remarks
 */
@Column(name = "IPU_COVER_NOTE_REMARKS", length = 4000)
private String ipuCoverNoteRemarks;

/**
 * Cover Note Wet
 */
@Column(name = "IPU_COVER_NOTE_WET")
private Date ipuCoverNoteWet;

/**
 * Cover Note Wef
 */
@Column(name = "IPU_COVER_NOTE_WEF")
private Date ipuCoverNoteWef;

/**
 * Cover Note Date
 */
@Column(name = "IPU_COVER_NOTE_DATE")
private Date ipuCoverNoteDate;

/**
 * Cover Note By
 */
@Column(name = "IPU_COVER_NOTE_BY", length = 30)
private String ipuCoverNoteBy;

/**
 * Cover Note No
 */
@Column(name = "IPU_COVER_NOTE_NO", length = 30)
private String ipuCoverNoteNo;

/**
 * Health Tax
 */
@Column(name = "IPU_HEALTH_TAX", precision = 23, scale = 4)
private BigDecimal ipuHealthTax;

/**
 * Motor Tax
 */
@Column(name = "IPU_MOTOR_TAX", precision = 23, scale = 5)
private BigDecimal ipuMotorTax;

    /**
 * CertchG
 */
@Column(name = "IPU_CERTCHG", precision = 23, scale = 5)
private BigDecimal ipuCertchg;

/**
 * Road Safety Tax
 */
@Column(name = "IPU_ROAD_SAFETY_TAX", precision = 23, scale = 5)
private BigDecimal ipuRoadSafetyTax;

/**
 * Client Vat Amt
 */
@Column(name = "IPU_CLIENT_VAT_AMT", precision = 23, scale = 5)
private BigDecimal ipuClientVatAmt;

/**
 * Motor Levy
 */
@Column(name = "IPU_MOTOR_LEVY", precision = 23, scale = 5)
private BigDecimal ipuMotorLevy;

/**
 * Overrideoverride Ret Type
 */
@Column(name = "IPU_OVERRIDERIDE_RET_TYPE", length = 15)
private String ipuOverrideoverrideRetType;

/**
 * Db Code
 */
@Column(name = "IPU_DB_CODE", precision = 22, scale = 5)
private BigDecimal ipuDbCode;

/**
 * Rare Model
 */
@Column(name = "IPU_RARE_MODEL", precision = 22)
private Long ipuRareModel;

/**
 * Cashback Appl
 */
@Column(name = "IPU_CASHBACK_APPL", nullable = false, length = 1)
private String ipuCashbackAppl;

/**
 * Cashback Level
 */
@Column(name = "IPU_CASHBACK_LEVEL", precision = 10)
private Long ipuCashbackLevel;

/**
 * Vehicle Model
 */
@Column(name = "IPU_VEHICLE_MODEL", length = 100)
private String ipuVehicleModel;

/**
 * Vehicle Make
 */
@Column(name = "IPU_VEHICLE_MAKE", length = 100)
private String ipuVehicleMake;

/**
 * Vehicle Model Code
 */
@Column(name = "IPU_VEHICLE_MODEL_CODE", precision = 10)
private Long ipuVehicleModelCode;

/**
 * Vehicle Make Code
 */
@Column(name = "IPU_VEHICLE_MAKE_CODE", precision = 10)
private Long ipuVehicleMakeCode;

/**
 * Loc Town
 */
@Column(name = "IPU_LOC_TOWN", length = 100)
private String ipuLocTown;

/**
 * Prop Address
 */
@Column(name = "IPU_PROP_ADDRESS", length = 200)
private String ipuPropAddress;

/**
 * Other Com Charges
 */
@Column(name = "IPU_OTHER_COM_CHARGES", precision = 23, scale = 2)
private BigDecimal ipuOtherComCharges;

/**
 * Risk Note
 */
@Column(name = "IPU_RISK_NOTE", length = 200)
private String ipuRiskNote;

/**
 * Model Yr
 */
@Column(name = "IPU_MODEL_YR", precision = 22)
private Long ipuModelYr;

/**
 * Insured Driver
 */
@Column(name = "IPU_INSURED_DRIVER", length = 2)
private String ipuInsuredDriver;

/**
 * Cert No
 */
@Column(name = "IPU_CERT_NO", length = 20)
private String ipuCertNo;

/**
 * Validate Ucr
 */
@Column(name = "IPU_VALIDATE_UCR", length = 1)
private String ipuValidateUcr;

/**
 * Ucr Code
 */
@Column(name = "IPU_UCR_CODE", length = 50)
private String ipuUcrCode;

/**
 * Pip Code
 */
@Column(name = "IPU_PIP_CODE", precision = 22)
private Long ipuPipCode;

/**
 * Pip Pf Code
 */
@Column(name = "IPU_PIP_PF_CODE", precision = 22)
private Long ipuPipPfCode;

/**
 * Survey Agnt Code
 */
@Column(name = "IPU_SURVEY_AGNT_CODE", precision = 22)
private Long ipuSurveyAgntCode;

/**
 * Quza Code
 */
@Column(name = "IPU_QUZA_CODE", precision = 22)
private Long ipuQuzaCode;

/**
 * Survey
 */
@Column(name = "IPU_SURVEY", length = 1)
private String ipuSurvey;

/**
 * Maintenance Period Type
 */
@Column(name = "IPU_MAINTENANCE_PERIOD_TYPE", length = 2)
private String ipuMaintenancePeriodType;

/**
 * Maintenance Period
 */
@Column(name = "IPU_MAINTENANCE_PERIOD", precision = 22)
private Long ipuMaintenancePeriod;

/**
 * Other Client Deductibles
 */
@Column(name = "IPU_OTHER_CLIENT_DEDUCTIBLES", precision = 22)
private Long ipuOtherClientDeductibles;

/**
 * Coin Other Client Charges
 */
@Column(name = "IPU_COIN_OTHER_CLIENT_CHARGES", precision = 22)
private Long ipuCoinOtherClientCharges;

/**
 * Marine Type
 */
@Column(name = "IPU_MARINE_TYPE", length = 2)
private String ipuMarineType;

/**
 * Eml Value
 */
@Column(name = "IPU_EML_VALUE", precision = 22)
private Long ipuEmlValue;

/**
 * Comm Levy Amt
 */
@Column(name = "IPU_COMM_LEVY_AMT", precision = 22)
private Long ipuCommLevyAmt;

/**
 * Comm Levy Rate
 */
@Column(name = "IPU_COMM_LEVY_RATE", precision = 22)
private Long ipuCommLevyRate;

/**
 * Tracker Installed
 */
@Column(name = "IPU_TRACKER_INSTALLED", length = 1)
private String ipuTrackerInstalled;

/**
 * Vessel Type
 */
@Column(name = "IPU_VESSEL_TYPE", length = 100)
private String ipuVesselType;

/**
 * Wet Time
 */
@Column(name = "IPU_WET_TIME", length = 10)
private String ipuWetTime;

/**
 * Item Desc
 */
@Column(name = "IPU_ITEM_DESC", nullable = false, length = 4000)
private String ipuItemDesc;

/**
 * Override Amt Rate
 */
@Column(name = "IPU_OVERRIDE_AMT_RATE", length = 1)
private String ipuOverrideAmtRate;

/**
 * Coin Tot Endos Diff Amt
 */
@Column(name = "IPU_COIN_TOT_ENDOS_DIFF_AMT", precision = 22, scale = 5)
private BigDecimal ipuCoinTotEndosDiffAmt;

/**
 * Coin Tot Comm Amt
 */
@Column(name = "IPU_COIN_TOT_COMM_AMT", precision = 22, scale = 5)
private BigDecimal ipuCoinTotCommAmt;

/**
 * Coin Tot Whtx
 */
@Column(name = "IPU_COIN_TOT_WHTX", precision = 22, scale = 5)
private BigDecimal ipuCoinTotWhtx;

/**
 * Coin Tot Vat
 */
@Column(name = "IPU_COIN_TOT_VAT", precision = 22, scale = 5)
private BigDecimal ipuCoinTotVat;

/**
 * Part Shipment
 */
@Column(name = "IPU_PART_SHIPMENT", length = 5)
private String ipuPartShipment;

/**
 * Is New Risk
 */
@Column(name = "IPU_IS_NEW_RISK", length = 5)
private String ipuIsNewRisk;
}