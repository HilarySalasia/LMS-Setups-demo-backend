package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;

/**
 * This table stores details of insured limits per section, including premium rate,
 * computed premium amount, and other related information.
 */
@Entity
@Table(name = "GIN_POLICY_INSURED_LIMITS")
@Data
public class GinPolicyInsuredLimits {
    /**
 * Table primary key
 */
@Id
@Column(name = "PIL_CODE", nullable = false, precision = 22)
private Long pilCode;

/**
 * Foreign Key reference to table GIN\_INSURED\_PROPERTY\_UNDS
 */
@Column(name = "PIL_IPU_CODE", nullable = false, precision = 22)
private Long pilIpuCode;

/**
 * Foreign Key Referencing table GIN\_SECTIONS
 */
@Column(name = "PIL_SECT_CODE", nullable = false, precision = 22)
private Long pilSectCode;

/**
 * Section ID
 */
@Column(name = "PIL_SECT_SHT_DESC", nullable = false, length = 50)
private String pilSectShtDesc;

/**
 * Row number used in ordering premium items during premium computation
 */
@Column(name = "PIL_ROW_NUM", nullable = false, precision = 22)
private Long pilRowNum;

/**
 * Calculation grouping field used to facilitate premium computation, especially when applying discounts and loadings
 */
@Column(name = "PIL_CALC_GROUP", nullable = false, precision = 22)
private Long pilCalcGroup;

/**
 * Premium item limit amount (SI)
 */
@Column(name = "PIL_LIMIT_AMT", precision = 25, scale = 5)
private BigDecimal pilLimitAmt;

/**
 * Premium rate
 */
@Column(name = "PIL_PREM_RATE", precision = 30, scale = 10)
private BigDecimal pilPremRate;

/**
 * Computed premium amount
 */
@Column(name = "PIL_PREM_AMT", precision = 25, scale = 5)
private BigDecimal pilPremAmt;

/**
 * Rate type applied
 */
@Column(name = "PIL_RATE_TYPE", length = 3)
private String pilRateType;

/**
 * Rate description
 */
@Column(name = "PIL_RATE_DESC", length = 20)
private String pilRateDesc;

/**
 * ES-extension si, EL-extension limit, SS - section si, SL Section limit, DS - discount, LO - Loading, EC - escalation
 */
@Column(name = "PIL_SECT_TYPE", length = 2)
private String pilSectType;

/**
 * Section excess details
 */
@Column(name = "PIL_SECT_EXCESS_DETAIL", length = 255)
private String pilSectExcessDetail;

/**
 * Original premium rate from the setup, if the premium rate used in the computation was changed
 */
@Column(name = "PIL_ORIGINAL_PREM_RATE", precision = 22, scale = 5)
private BigDecimal pilOriginalPremRate;

/**
 * Reasons for changing premium rate at computation
 */
@Column(name = "PIL_RATE_CHANGE_REMARKS", length = 50)
private String pilRateChangeRemarks;

/**
 * Audit trail of who changed the premium rate
 */
@Column(name = "PIL_CHANGE_DONE_BY", length = 20)
private String pilChangeDoneBy;

/**
 * Minimum premium amount for the premium item
 */
@Column(name = "PIL_MIN_PREMIUM", precision = 23, scale = 5)
private BigDecimal pilMinPremium;

/**
 * General comments for the premium item
 */
@Column(name = "PIL_COMMENT", length = 2000)
private String pilComment;

/**
 * Multiplier rate applied
 */
@Column(name = "PIL_MULTIPLIER_RATE", precision = 22, scale = 5)
private BigDecimal pilMultiplierRate;

/**
 * Multiplier rate division factor applied
 */
@Column(name = "PIL_MULTIPLIER_DIV_FACTOR", precision = 22, scale = 5)
private BigDecimal pilMultiplierDivFactor;

/**
 * Computed annual premium amount
 */
@Column(name = "PIL_ANNUAL_PREMIUM", precision = 25, scale = 5)
private BigDecimal pilAnnualPremium;

/**
 * Rate division Factor
 */
@Column(name = "PIL_RATE_DIV_FACT", precision = 22, scale = 5)
private BigDecimal pilRateDivFact;

/**
 * Premium item description
 */
@Column(name = "PIL_DESC", length = 60)
private String pilDesc;

/**
 * Used limit
 */
@Column(name = "PIL_USED_LIMIT", precision = 30, scale = 5)
private BigDecimal pilUsedLimit;

/**
 * Indicated if the premium item will be used in the premium computation
 */
@Column(name = "PIL_COMPUTE", length = 1)
private String pilCompute;

/**
 * Indemnity period
 */
@Column(name = "PIL_INDEM_PRD", precision = 22, scale = 5)
private BigDecimal pilIndemPrd;

/**
 * Indemnity period type
 */
@Column(name = "PIL_PRD_TYPE", length = 1)
private String pilPrdType;

    /**
 * Indemnity first period
 */
@Column(name = "PIL_INDEM_FSTPRD", precision = 22, scale = 5)
private BigDecimal pilIndemFstprd;

/**
 * Indemnity first period percentage
 */
@Column(name = "PIL_INDEM_FSTPRD_PCT", precision = 22, scale = 5)
private BigDecimal pilIndemFstprdPct;

/**
 * Indemnity Remaining period percentage
 */
@Column(name = "PIL_INDEM_REMPRD_PCT", precision = 22, scale = 5)
private BigDecimal pilIndemRemprdPct;

/**
 * Apply dual basis or not
 */
@Column(name = "PIL_DUAL_BASIS", length = 5)
private String pilDualBasis;

/**
 * Premium accumulation used in reinsurance
 */
@Column(name = "PIL_PREM_ACCUMULATION", precision = 30, scale = 5)
private BigDecimal pilPremAccumulation;

/**
 * Prorata premium
 */
@Column(name = "PIL_PREM_PRORATA", precision = 30, scale = 5)
private BigDecimal pilPremProrata;

/**
 * Previous endorsement premium
 */
@Column(name = "PIL_PREV_PREM", precision = 30, scale = 5)
private BigDecimal pilPrevPrem;

/**
 * Indicates if its a declaration section
 */
@Column(name = "PIL_DECLARATION_SECTION", length = 1)
private String pilDeclarationSection;

/**
 * Previous endorsement section limit
 */
@Column(name = "PIL_PREV_LIMIT", precision = 25, scale = 5)
private BigDecimal pilPrevLimit;

/**
 * Actual premium
 */
@Column(name = "PIL_ACTUAL_PREM", precision = 25, scale = 5)
private BigDecimal pilActualPrem;

/**
 * Previous endorsement prorata premium
 */
@Column(name = "PIL_PREV_PREM_PRORATA", precision = 25, scale = 5)
private BigDecimal pilPrevPremProrata;

/**
 * Annual actual premium
 */
@Column(name = "PIL_ANNUAL_ACTUAL_PREM", precision = 25, scale = 5)
private BigDecimal pilAnnualActualPrem;

/**
 * EML percentage
 */
@Column(name = "PIL_EML_PCT", precision = 22)
private Long pilEmlPct;

    /**
 * Top Location rate
 */
@Column(name = "PIL_TOP_LOC_RATE", precision = 25)
private Long pilTopLocRate;

/**
 * Top location Division factor
 */
@Column(name = "PIL_TOP_LOC_DIV_FACT", precision = 22)
private Long pilTopLocDivFact;

/**
 * Free limit premium amount
 */
@Column(name = "PIL_FREE_LIMIT_AMT", precision = 22, scale = 5)
private BigDecimal pilFreeLimitAmt;

/**
 * Limit period
 */
@Column(name = "PIL_LIMIT_PRD", precision = 22)
private Long pilLimitPrd;

/**
 * Actual premium rate
 */
@Column(name = "PIL_ACTUAL_RATE_PREM", precision = 20, scale = 5)
private BigDecimal pilActualRatePrem;

/**
 * Previous endorsement premium rate
 */
@Column(name = "PIL_PREV_ENDR_PREM_RATE", precision = 20, scale = 5)
private BigDecimal pilPrevEndrPremRate;

/**
 * Previous endorsement rate division factor
 */
@Column(name = "PIL_PREV_ENDR_RATE_DIV_FACT", precision = 20, scale = 5)
private BigDecimal pilPrevEndrRateDivFact;

/**
 * Previous endorsement multiplier rate
 */
@Column(name = "PIL_PREV_ENDR_MULT_RATE", precision = 20, scale = 5)
private BigDecimal pilPrevEndrMultRate;

/**
 * Previous endorsement multiplier division factor
 */
@Column(name = "PIL_PREV_ENDR_MULT_DIV_FACT", precision = 20, scale = 5)
private BigDecimal pilPrevEndrMultDivFact;

/**
 * Indicate if the section has expired on the endorsement or not
 */
@Column(name = "PIL_EXPIRED", length = 1)
private String pilExpired;

/**
 * Free limit SI limit
 */
@Column(name = "PIL_FREE_LIMIT", precision = 22, scale = 5)
private BigDecimal pilFreeLimit;

/**
 * Indicates if its On prorata basis or full basis
 */
@Column(name = "PIL_PRORATA_FULL", length = 1)
private String pilProrataFull;

/**
 * Used for loading and discount where a rate is applied on the SI to determine the discount or loading on the transaction
 */
@Column(name = "PIL_SI_LIMIT_TYPE", length = 1)
private String pilSiLimitType;

/**
 * Used for loading and discount where a rate is applied on the SI to determine the discount or loading on the transaction - rate applied
 */
@Column(name = "PIL_SI_RATE", precision = 23, scale = 5)
private BigDecimal pilSiRate;

/**
 * Cover type field used for medical section
 */
@Column(name = "PIL_COVER_TYPE", length = 1)
private String pilCoverType;

/**
 * PRR Maximum Rate
 */
@Column(name = "PIL_PRR_MAX_RATE", precision = 22, scale = 2)
private BigDecimal pilPrrMaxRate;

/**
 * PRR Minimum Rate
 */
@Column(name = "PIL_PRR_MIN_RATE", precision = 22, scale = 2)
private BigDecimal pilPrrMinRate;

/**
 * Indicates if it is a First Loss cover
 */
@Column(name = "PIL_FIRSTLOSS", length = 1)
private String pilFirstloss;

/**
 * Indicates if First Loss amount is in percentage or amount
 */
@Column(name = "PIL_FIRSTLOSS_AMT_PCNT", length = 1)
private String pilFirstlossAmtPcnt;

/**
 * First Loss Value
 */
@Column(name = "PIL_FIRSTLOSS_VALUE")
private Long pilFirstlossValue;

/**
 * Indicates if the section is editable
 */
@Column(name = "PIL_IS_EDITABLE", precision = 10)
private Long pilIsEditable;

/**
 * Limit Multiplier Amount
 */
@Column(name = "PIL_LIMIT_MULTI_AMOUNT", precision = 22)
private Long pilLimitMultiAmount;

/**
 * Limit Multiplier Rate
 */
@Column(name = "PIL_LIMIT_MULTI_RATE", precision = 22)
private Long pilLimitMultiRate;

/**
 * Loading Rate
 */
@Column(name = "PIL_LOADING_RATE", precision = 22)
private Long pilLoadingRate;
}
