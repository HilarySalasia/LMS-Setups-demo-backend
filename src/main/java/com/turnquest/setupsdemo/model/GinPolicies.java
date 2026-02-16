package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This table stores details of policies in the system.
 */
@Entity
@Table(name = "GIN_POLICIES")
@Data
public class GinPolicies {
    @Id
@Column(name = "POL_POLICY_NO", nullable = false, length = 100)
private String polPolicyNo; // POLICY NUMBER

/**
 * Endorsement number.
 */
@Column(name = "POL_REN_ENDOS_NO", nullable = false, length = 100)
private String polRenEndosNo; // ENDORSEMENT NUMBER

/**
 * Batch number (primary key).
 */
@Column(name = "POL_BATCH_NO", nullable = false, precision = 22)
private Long polBatchNo; // BATCH NUMBER (PRIMARY KEY)

/**
 * Agent reference number.
 */
@Column(name = "POL_AGNT_AGENT_CODE", nullable = false, precision = 22)
private Long polAgntAgentCode; // AGENT REFERENCE NUMBER

/**
 * Agent short description.
 */
@Column(name = "POL_AGNT_SHT_DESC", nullable = false, length = 100)
private String polAgntShtDesc; // AGENT SHORT DESCRIPTION

/**
 * Binder reference number.
 */
@Column(name = "POL_BIND_CODE", precision = 22)
private Long polBindCode; // BINDER REFERENCE NUMBER

/**
 * Policy effective date from.
 */
@Column(name = "POL_WEF_DT", nullable = false)
private Date polWefDt; // POLICY EFFECTIVE DATE  FROM

/**
 * Policy effective date to.
 */
@Column(name = "POL_WET_DT", nullable = false)
private Date polWetDt; // POLICY EFFECTIVE DATE  TO

/**
 * Underwriting year.
 */
@Column(name = "POL_UW_YEAR", precision = 22)
private Long polUwYear; // UNDERWRITING YEAR

/**
 * Total policy sum insured.
 */
@Column(name = "POL_TOTAL_SUM_INSURED", precision = 27, scale = 5)
private BigDecimal polTotalSumInsured; // TOTAL POLICY SUM INSURED

/**
 * Policy status.
 */
@Column(name = "POL_POLICY_STATUS", nullable = false, length = 20)
private String polPolicyStatus; // POLICY STATUS

/**
 * Commission amount.
 */
@Column(name = "POL_COMM_AMT", precision = 22, scale = 5)
private BigDecimal polCommAmt; // COMMISSION AMOUNT

/**
 * Commission rate.
 */
@Column(name = "POL_COMM_RATE", precision = 22, scale = 5)
private BigDecimal polCommRate; // COMMISSION RATE

/**
 * Policy inception date.
 */
@Column(name = "POL_INCEPTION_DT")
private Date polInceptionDt; // POLICY INCEPTION DATE

/**
 * Transaction type.
 */
@Column(name = "POL_TRAN_TYPE", length = 2)
private String polTranType; // TRANSACTION TYPE

/**
 * Foreign key from GIN\_ACC\_PERIODS for period.
 */
@Column(name = "POL_ACPR_CODE", precision = 22)
private Long polAcprCode; // Foreign Key from GIN_ACC_PERIODS for period

/**
 * Accounting period short description.
 */
@Column(name = "POL_ACPR_SHT_DESC", length = 100)
private String polAcprShtDesc; // Accounting period short description

/**
 * Proposal number.
 */
@Column(name = "POL_ALP_PROPOSAL_NO", length = 100)
private String polAlpProposalNo; // PROPOSAL  NUMBER

/**
 * Indicates if policy is reinsured or not.
 */
@Column(name = "POL_REINSURED", length = 1)
private String polReinsured; // IF POLICY IS REINSURED OR NOT

/**
 * Basic premium.
 */
@Column(name = "POL_BASIC_PREMIUM", precision = 27, scale = 5)
private BigDecimal polBasicPremium; // BASIC PREMIUM

/**
 * Net premium.
 */
@Column(name = "POL_NETT_PREMIUM", precision = 27, scale = 5)
private BigDecimal polNettPremium; // NET PREMIUM

/**
 * Currency code.
 */
@Column(name = "POL_CUR_CODE", nullable = false, precision = 22)
private Long polCurCode; // CURRENCE CODE

/**
 * User who prepared the transaction.
 */
@Column(name = "POL_PREPARED_BY", length = 100)
private String polPreparedBy; // USER WHO PREPARED THE TRANSACTION

/**
 * Date the transaction is prepared.
 */
@Column(name = "POL_PREPARED_DATE")
private Date polPreparedDate; // DATE THE TRANSACTION IS PREPARED

/**
 * User who authorized the transaction.
 */
@Column(name = "POL_CHECKED_BY", length = 100)
private String polCheckedBy; // USER WHO AUTHORIZED THE TRANSACTION

/**
 * Date of authorization.
 */
@Column(name = "POL_CHECK_DATE")
private Date polCheckDate; // DATE OF AUTHORIZATION

/**
 * Policy type ('F' facultative, 'N' normal policy).
 */
@Column(name = "POL_POLICY_TYPE", length = 1)
private String polPolicyType; // POLICY TYPE 'F' FACULTATIVE,'N' NORMAL POLICY

/**
 * Conversion rate.
 */
@Column(name = "POL_CONVERSION_RATE", precision = 22, scale = 5)
private BigDecimal polConversionRate; // Conversion Rate

/**
 * Client policy number.
 */
@Column(name = "POL_CLIENT_POLICY_NUMBER", length = 100)
private String polClientPolicyNumber; // CLIENT POLICY NUMBER

/**
 * Branch reference number.
 */
@Column(name = "POL_BRN_CODE", nullable = false, precision = 22)
private Long polBrnCode; // BRANCH REFERENCE NUMBER

/**
 * Business type.
 */
@Column(name = "POL_BUSINESS_TYPE", length = 100)
private String polBusinessType; // Business Type

/**
 * Currency rate.
 */
@Column(name = "POL_CUR_RATE", precision = 22, scale = 5)
private BigDecimal polCurRate; // CURRENCE RATE

/**
 * Currency type (fixed or variable).
 */
@Column(name = "POL_CURR_RATE_TYPE", length = 1)
private String polCurrRateType; // CURRENCY TYPE (FIXED OR VARIABLE)

    @Column(name = "POL_SCL_CODE", precision = 22)
private Long polSclCode; // Foreign Key from GIN_SUB_CLASSES for sub-class

/**
 * Endorsement commission amount.
 */
@Column(name = "POL_COMM_ENDOS_DIFF_AMT", precision = 22, scale = 5)
private BigDecimal polCommEndosDiffAmt; // ENDORSEMENT COMMISSION

/**
 * Total future annual premium.
 */
@Column(name = "POL_TOTAL_FAP", precision = 25, scale = 5)
private BigDecimal polTotalFap; // TOTAL FUTURE ANNUL PREMIUM

/**
 * Total gross premium.
 */
@Column(name = "POL_TOTAL_GP", precision = 22, scale = 5)
private BigDecimal polTotalGp; // TOTAL GROSS PREMIUM

/**
 * Endorsement premium amount.
 */
@Column(name = "POL_TOT_ENDOS_DIFF_AMT", precision = 22, scale = 5)
private BigDecimal polTotEndosDiffAmt; // ENDORSEMENT PREMIUM

/**
 * Indicates if the policy is active or lapsed.
 */
@Column(name = "POL_CANCEL_LAPSE_ACTIVE", length = 1)
private String polCancelLapseActive; // Cancel Lapse Active

/**
 * Indicates if it is a coinsurance policy.
 */
@Column(name = "POL_COINSURANCE", nullable = false, length = 1)
private String polCoinsurance; // IF IT’S A COINSURANCE POLICY

/**
 * Indicates if the underwriter is the lead.
 */
@Column(name = "POL_COINSURE_LEADER", length = 1)
private String polCoinsureLeader; // IF THE UNDERWRITER IS LEAD OR NOT

/**
 * But charge premium.
 */
@Column(name = "POL_FP", precision = 22, scale = 5)
private BigDecimal polFp; // But Charge Premium

/**
 * Indicates if the policy premium is posted to FMS.
 */
@Column(name = "POL_POST_STATUS", length = 1)
private String polPostStatus; // IF THE POLICY PREMIUM IS POSTED TO FMS

/**
 * Debit/Credit note number.
 */
@Column(name = "POL_DRCR_NO", length = 100)
private String polDrcrNo; // DEBIT/CREDIT NOTE NUMBER

/**
 * Currency symbol.
 */
@Column(name = "POL_CUR_SYMBOL", nullable = false, length = 97)
private String polCurSymbol; // CURRENCE SYMBOL

/**
 * Indicates if the post is okay.
 */
@Column(name = "POL_POST_OK", length = 1)
private String polPostOk; // Post Ok

/**
 * Branch short description.
 */
@Column(name = "POL_BRN_SHT_DESC", nullable = false, length = 100)
private String polBrnShtDesc; // BRANCH ID

/**
 * Client reference number.
 */
@Column(name = "POL_PRP_CODE", nullable = false, precision = 22)
private Long polPrpCode; // CLIENT REFERENCE NUMBER

/**
 * Current status of the policy.
 */
@Column(name = "POL_CURRENT_STATUS", length = 10)
private String polCurrentStatus; // CURRENT STATUS

/**
 * Indicates if the policy is authorized.
 */
@Column(name = "POL_AUTHOSRISED", length = 10)
private String polAuthosrised; // IF THE POLICY IS AUTHORIZED OR NOT

/**
 * Date of cancellation.
 */
@Column(name = "POL_CANCEL_DT")
private Date polCancelDt; // DATE OF CANCELLATION

/**
 * Inception underwriting year.
 */
@Column(name = "POL_INCEPTION_UWYR", nullable = false, precision = 22)
private Long polInceptionUwyr; // INCEPTION UNDERWRITING YEAR

    /**
 * Product reference number.
 */
@Column(name = "POL_PRO_CODE", nullable = false, precision = 22)
private Long polProCode; // PRODUCT REFENCE NUMBER

/**
 * Btr code.
 */
@Column(name = "POL_BTR_CODE", precision = 22)
private Long polBtrCode; // Btr Code

/**
 * Transaction code reference to GIN\_BUSINESS\_TRANSACTIONS.
 */
@Column(name = "POL_BTR_TRANS_CODE", length = 50)
private String polBtrTransCode; // Transaction code reference to GIN_BUSINESS_TRANSACTIONS

/**
 * External client reference number.
 */
@Column(name = "POL_YOUR_REF", length = 50)
private String polYourRef; // EXTERNAL CLIENT REFERENCE NUMBER

/**
 * Holding company reference number.
 */
@Column(name = "POL_PROP_HOLDING_CO_PRP_CODE", precision = 22)
private Long polPropHoldingCoPrpCode; // HOLDING COMPANY REFERENCE NUMBER

/**
 * Interested parties.
 */
@Column(name = "POL_OTH_INT_PARTIES", length = 150)
private String polOthIntParties; // INTERESTED PARTIES

/**
 * Product short description.
 */
@Column(name = "POL_PRO_SHT_DESC", nullable = false, length = 100)
private String polProShtDesc; // PRODUCT SHORT DESCRIPTION

/**
 * Previous batch number.
 */
@Column(name = "POL_PREV_BATCH_NO", nullable = false, precision = 22)
private Long polPrevBatchNo; // PREVIOUS BATCH NUMBER

/**
 * Length of the underwriting year.
 */
@Column(name = "POL_UWYR_LENGTH", precision = 22)
private Long polUwyrLength; // LENGTH OF THE UNDERWRITING YEAR

/**
 * Indicates if it is a binder policy.
 */
@Column(name = "POL_BINDER_POLICY", length = 1)
private String polBinderPolicy; // BINDER POLICY OR NOT

/**
 * Binder product reference number.
 */
@Column(name = "POL_BIND_PRO_CODE", precision = 22)
private Long polBindProCode; // BINDER PRODUCT REFERENCE NUMBER

/**
 * Binder product short description.
 */
@Column(name = "POL_BIND_PRO_SHT_DESC", length = 30)
private String polBindProShtDesc; // BINDER PRODUCT SHORT DESCRIPTION

/**
 * Remarks.
 */
@Column(name = "POL_REMARKS", length = 4000)
private String polRemarks; // REMARKS

/**
 * Coinsurance percentage.
 */
@Column(name = "POL_COINSURE_PCT", precision = 22, scale = 5)
private BigDecimal polCoinsurePct; // COINSURANCE PERCENTAGE

/**
 * Indicates if the policy is renewed or not.
 */
@Column(name = "POL_RENEWED_REC", length = 1)
private String polRenewedRec; // IS THE POLICY RENEWED OR NOT

/**
 * Indicates if the policy is renewable or not.
 */
@Column(name = "POL_RENEWABLE", nullable = false, length = 1)
private String polRenewable; // IS POLICY RENEWABLE OR NOT

/**
 * Policy cover date to.
 */
@Column(name = "POL_POLICY_COVER_TO")
private Date polPolicyCoverTo; // POLICY COVER DATE TO

/**
 * Policy cover date from.
 */
@Column(name = "POL_POLICY_COVER_FROM")
private Date polPolicyCoverFrom; // POLICY COVER DATE FROM

/**
 * Endorsement sum insured.
 */
@Column(name = "POL_SI_DIFF", precision = 25, scale = 5)
private BigDecimal polSiDiff; // ENDORSEMENT SUM INSURED

/**
 * Policy withholding tax amount.
 */
@Column(name = "POL_WTHT", precision = 23, scale = 5)
private BigDecimal polWtht; // POLICY WITHOLDING TAX AMOUNT

/**
 * Policy premium tax.
 */
@Column(name = "POL_PREM_TAX", precision = 23, scale = 5)
private BigDecimal polPremTax; // POLICY PREMIUM TAX

/**
 * Policy marine certificate number.
 */
@Column(name = "POL_MAR_CERT_NO", length = 100)
private String polMarCertNo; // POLICY MARINE CERTIFICATE NUMBER

/**
 * Coinsurance share.
 */
@Column(name = "POL_COINSURANCE_SHARE", precision = 22, scale = 5)
private BigDecimal polCoinsuranceShare; // COINSURANCE SHARE

/**
 * Coinsurance total premium.
 */
@Column(name = "POL_COIN_TOT_PREM", precision = 25, scale = 5)
private BigDecimal polCoinTotPrem; // COINSURANCE TOTAL COINSURANCE PREMIUM

/**
 * Coinsurance endorsement premium.
 */
@Column(name = "POL_COIN_ENDOS_PREM", precision = 25, scale = 5)
private BigDecimal polCoinEndosPrem; // COINSURANCE ENDORSEMENT PREMIUM

/**
 * Total coinsurance sum insured.
 */
@Column(name = "POL_COIN_TOT_SI", precision = 25, scale = 5)
private BigDecimal polCoinTotSi; // TOTAL COINSURANCE SUM INSURED

/**
 * Renewal date.
 */
@Column(name = "POL_RENEWAL_DT")
private Date polRenewalDt; // RENEWAL DATE

/**
 * Previous endorsement premium.
 */
@Column(name = "POL_PREV_PREM", precision = 25, scale = 5)
private BigDecimal polPrevPrem; // PREVIOUS ENDORSEMENT PREMIUM

    /**
 * Quotation reference number.
 */
@Column(name = "POL_QUOT_NO", length = 50)
private String polQuotNo; // QUOTATION REFERENCE NUMBER

/**
 * Indicates if the policy is ready for reinsurance.
 */
@Column(name = "POL_RI_READY", length = 1)
private String polRiReady; // IF THE POLICY IS READY FOR REINSURANCE

/**
 * Facultative agent commission amount.
 */
@Column(name = "POL_RI_AGENT_COMM_AMT", precision = 25, scale = 5)
private BigDecimal polRiAgentCommAmt; // FACULTATIVE AGENT COMMISSION AMOUNT

/**
 * Additional endorsement specifications.
 */
@Column(name = "POL_ADD_ENDRSE_SPECS", length = 4000)
private String polAddEndrseSpecs; // Additional Endorsement Specifications

/**
 * Facultative agent commission rate.
 */
@Column(name = "POL_RI_AGENT_COMM_RATE", precision = 22, scale = 5)
private BigDecimal polRiAgentCommRate; // FACULTATIVE AGENT COMMISSION RATE

/**
 * Facultative agent short description.
 */
@Column(name = "POL_RI_AGNT_SHT_DESC", length = 100)
private String polRiAgntShtDesc; // FACULTATIVE AGENT SHORT DESCRIPTION

/**
 * Facultative agent reference number.
 */
@Column(name = "POL_RI_AGNT_AGENT_CODE", precision = 22)
private Long polRiAgntAgentCode; // FACULTATIVE AGENT REFERENCE NUMBER

/**
 * Total training level.
 */
@Column(name = "POL_TOT_TL", precision = 22, scale = 5)
private BigDecimal polTotTl; // TOTAL TRAINING LEVEL

/**
 * Endorsement training level.
 */
@Column(name = "POL_TL", precision = 25, scale = 5)
private BigDecimal polTl; // ENDORSEMENT TRAINING LEVEL

/**
 * Product minimum premium.
 */
@Column(name = "POL_MIN_PREM", precision = 25, scale = 5)
private BigDecimal polMinPrem; // PRODUCT MINIMUM PREMIUM

/**
 * Endorsement minimum premium.
 */
@Column(name = "POL_END_MIN_PREM", precision = 25, scale = 5)
private BigDecimal polEndMinPrem; // endorsement minimum premium

/**
 * Coinsurance fee.
 */
@Column(name = "POL_COIN_FEE", precision = 22, scale = 5)
private BigDecimal polCoinFee; // COINSURANCE FEE

/**
 * Coinsurance fee amount.
 */
@Column(name = "POL_COIN_FEE_AMT", precision = 30, scale = 5)
private BigDecimal polCoinFeeAmt; // COINSURANCE FEE AMOUNT

/**
 * Coinsurance policy number.
 */
@Column(name = "POL_COIN_POLICY_NO", length = 100)
private String polCoinPolicyNo; // COINSURANCE POLICY NUMBER

/**
 * Marine certificate number level (policy or risk).
 */
@Column(name = "POL_MARINE_CERT_LEVEL", length = 1)
private String polMarineCertLevel; // MARINE CERTIFICATE NUMBER LEVEL(POLICY OR RISK)

/**
 * Transaction effective date to.
 */
@Column(name = "POL_TRANS_EFF_WET", nullable = false)
private Date polTransEffWet; // TRANSACTION EFFECTIVE DATE TO

/**
 * Annual training level.
 */
@Column(name = "POL_ANNUAL_TL", precision = 22, scale = 5)
private BigDecimal polAnnualTl; // ANNUAL TRAINING LEVEL

/**
 * Stamp duty.
 */
@Column(name = "POL_DUTIES", precision = 25, scale = 5)
private BigDecimal polDuties; // STAMP DUTY

/**
 * Extras amount.
 */
@Column(name = "POL_EXTRAS", precision = 25, scale = 5)
private BigDecimal polExtras; // EXTRAS AMOUNT

/**
 * Loaded transaction.
 */
@Column(name = "POL_LOADED", length = 1)
private String polLoaded; // LOADED TRANSACTION

/**
 * Old policy number for loaded policy.
 */
@Column(name = "POL_OLD_POLICY_NO", length = 100)
private String polOldPolicyNo; // OLD POLICY NUMBER FOR LOADED POLICY

/**
 * Indicates if commission is allowed on the policy.
 */
@Column(name = "POL_COMMISSION_ALLOWED", nullable = false, length = 1)
private String polCommissionAllowed; // IF COMMISSION IS ALLOWED ON THE POLICY

/**
 * Indicates if it is a past period transaction.
 */
@Column(name = "POL_PAST_PERIOD_ENDOS", length = 2)
private String polPastPeriodEndos; // PAST PERIOD TRANSACTION OR NOT

/**
 * Declaration endorsement type (declaration or penalty).
 */
@Column(name = "POL_DECLARATION_TYPE", length = 1)
private String polDeclarationType; // DECLARATION ENDORSEMENT TYPE(DECLARATION OR PENALTY)

/**
 * Withholding tax rate.
 */
@Column(name = "POL_WTHT_RATE", precision = 20, scale = 5)
private BigDecimal polWthtRate; // WITHHOLDING TAX RATE

/**
 * Coinsurance fee type.
 */
@Column(name = "POL_COIN_FEE_TYPE", length = 100)
private String polCoinFeeType; // COINSURANCE FEE TYPE

/**
 * Total policy holder fund amount.
 */
@Column(name = "POL_TOT_PHFUND", precision = 22, scale = 5)
private BigDecimal polTotPhfund; // TOTAL POLICY HOLDER FUND AMOUNT

/**
 * Policy holder fund amount.
 */
@Column(name = "POL_PHFUND", precision = 22, scale = 5)
private BigDecimal polPhfund; // POLICY HOLDER FUND AMOUNT

/**
 * Underwriting period.
 */
@Column(name = "POL_UW_PERIOD", precision = 12)
private Long polUwPeriod; // UNDERWRITING PERIOD

/**
 * Foreign key referencing the Policy Interest Parties table.
 */
@Column(name = "POL_PIP_CODE", precision = 15)
private Long polPipCode; // Foreign key referencing the Policy Interest Parties table

   /**
 * Enforce service fee computation on coinsurance.
 */
@Column(name = "POL_FORCE_SF_COMPUTE", length = 30)
private String polForceSfCompute; // ENFORCE SERVICE FEE COMPUTATION ON COINSURANCE

/**
 * Introducer reference.
 */
@Column(name = "POL_INTRO_CODE", precision = 10)
private Long polIntroCode; // INTRODUCER REFERENCE

/**
 * Grouping or batching of all policies brought in by this introducer per period.
 */
@Column(name = "POL_INTRO_BATCH_ID", precision = 15)
private Long polIntroBatchId; // GROUPING;BATCHING OF ALL POLICIES BROUGHT IN BY THIS INTRODUCER PER PERIOD

/**
 * Specifies endorsement count or number that is client specific.
 */
@Column(name = "POL_CLIENT_END_VERSION", precision = 22)
private Long polClientEndVersion; // SPECIFIES ENDORSEMENT COUNT OR NUMBER THAT IS CLIENT SPECIFIC

/**
 * Fixed exchange rate or not.
 */
@Column(name = "POL_EXCH_RATE_FIXED", nullable = false, length = 30)
private String polExchRateFixed; // FIXED EXCHANGE RATE OR NOT

/**
 * Factor.
 */
@Column(name = "POL_FACTOR", precision = 22)
private Long polFactor; // Factor

/**
 * Foreign key referencing the Sales Points table.
 */
@Column(name = "POL_GSP_CODE", precision = 22)
private Long polGspCode; // Foreign key referencing the Sales Points table

/**
 * Web quotation code.
 */
@Column(name = "POL_WEB_QUOT_CODE", precision = 22)
private Long polWebQuotCode; // Web Quotation Code

/**
 * Paid up date.
 */
@Column(name = "POL_PAID_UP_DATE")
private Date polPaidUpDate; // Paid Up Date

/**
 * Outstanding premium balance amount.
 */
@Column(name = "POL_OS_PREM_BAL_AMT", precision = 23, scale = 5)
private BigDecimal polOsPremBalAmt; // Outstanding Premium Balance Amount

/**
 * Maturity date.
 */
@Column(name = "POL_MATURITY_DATE")
private Date polMaturityDate; // Maturity Date

/**
 * Paid installment number.
 */
@Column(name = "POL_PAID_INSTLMT_NO", precision = 10)
private Long polPaidInstlmtNo; // Paid Installment Number

/**
 * Policy frequency of payment.
 */
@Column(name = "POL_FREQ_OF_PAYMENT", nullable = false, length = 30)
private String polFreqOfPayment; // policy frequency of payment

/**
 * Installment amount.
 */
@Column(name = "POL_INSTLMT_AMT", precision = 23, scale = 5)
private BigDecimal polInstlmtAmt; // Installment Amount

/**
 * Outstanding installment number.
 */
@Column(name = "POL_OS_INSTLMT_NO", precision = 10)
private Long polOsInstlmtNo; // Outstanding Installment Number

/**
 * Installment premium.
 */
@Column(name = "POL_INSTLMT_PREM", precision = 23, scale = 5)
private BigDecimal polInstlmtPrem; // Installment Premium

/**
 * Paid to date.
 */
@Column(name = "POL_PAID_TO_DATE")
private Date polPaidToDate; // Paid To Date

/**
 * Payment method.
 */
@Column(name = "POL_PAY_METHOD", length = 30)
private String polPayMethod; // Payment Method

/**
 * Total number of installments.
 */
@Column(name = "POL_TOT_INSTLMT", precision = 10)
private Long polTotInstlmt; // Total Number of Installments

/**
 * Last premium due date.
 */
@Column(name = "POL_LAST_PREM_DUE_DATE")
private Date polLastPremDueDate; // Last Premium Due Date

/**
 * Installment day.
 */
@Column(name = "POL_INSTLMT_DAY", precision = 10)
private Long polInstlmtDay; // Installment Day

    /**
 * Checkoff Agent Short Description.
 */
@Column(name = "POL_CHECKOFF_AGNT_SHT_DESC", length = 30)
private String polCheckoffAgntShtDesc; // Checkoff Agent Short Description

/**
 * Checkoff Agent Code.
 */
@Column(name = "POL_CHECKOFF_AGNT_CODE", precision = 22)
private Long polCheckoffAgntCode; // Checkoff Agent Code

/**
 * Frequency Factor.
 */
@Column(name = "POL_FREQ_FACTOR", precision = 4)
private BigDecimal polFreqFactor; // Frequency Factor

/**
 * Old Agent for Loaded Transactions.
 */
@Column(name = "POL_OLD_AGENT", length = 50)
private String polOldAgent; // OLD AGENT FOR LOADE TRANSACTIONS

/**
 * Payment Facility Agent Code.
 */
@Column(name = "POL_PYMT_FACI_AGNT_CODE", precision = 22)
private Long polPymtFaciAgntCode; // Payment Facility Agent Code

/**
 * Enforce Service Fee Parameter.
 */
@Column(name = "POL_ENFORCE_SF_PARAM", length = 20)
private String polEnforceSfParam; // Enforce Service Fee Parameter

/**
 * Previous Agent Code.
 */
@Column(name = "POL_PREV_AGNT_AGENT_CODE", precision = 22)
private Long polPrevAgntAgentCode; // Previous Agent Code

/**
 * Screen Code.
 */
@Column(name = "POL_SCREEN_CODE", length = 30)
private String polScreenCode; // Screen Code

/**
 * Old Policy Number.
 */
@Column(name = "POL_OLD_POLICY_NUMBER", length = 50)
private String polOldPolicyNumber; // Old Policy Number

/**
 * Policy Type.
 */
@Column(name = "POL_TYPE", length = 1)
private String polType; // Policy Type

/**
 * Coinsurance Combined Flag.
 */
@Column(name = "POL_COIN_LEADER_COMBINED", length = 1)
private String polCoinLeaderCombined; // COINSURANCE COMBINED FLAG

/**
 * Division Code.
 */
@Column(name = "POL_DIV_CODE", precision = 22)
private Long polDivCode; // Division Code

/**
 * EDP Batch Number.
 */
@Column(name = "POL_EDP_BATCH", length = 6)
private String polEdpBatch; // EDP Batch Number

/**
 * Endorsement Status.
 */
@Column(name = "POL_ENDOS_STATUS", length = 50)
private String polEndosStatus; // Endorsement Status

/**
 * Premium Financier Details.
 */
@Column(name = "POL_PREM_FINANCIER", length = 50)
private String polPremFinancier; // Premium Financier Details

/**
 * Pip Pf Code.
 */
@Column(name = "POL_PIP_PF_CODE", precision = 15)
private Long polPipPfCode; // Pip Pf Code

/**
 * Err Rn Transfer.
 */
@Column(name = "POL_ERR_RN_TRANSFER", length = 2)
private String polErrRnTransfer; // Err Rn Transfer

/**
 * Pop Pip Code.
 */
@Column(name = "POP_PIP_CODE", precision = 20)
private Long popPipCode; // Pop Pip Code

/**
 * Pol Loaded Today.
 */
@Column(name = "POL_LOADED_TODAY", length = 2)
private String polLoadedToday; // Pol Loaded Today

/**
 * Pbqt Code.
 */
@Column(name = "POL_PBQT_CODE", precision = 15)
private Long polPbqtCode; // Pbqt Code

/**
 * Payment Mode Reference.
 */
@Column(name = "POL_PMOD_CODE", precision = 15)
private Long polPmodCode; // Payment Mode Reference

/**
 * Renewal Status.
 */
@Column(name = "POL_RENEWAL_STATUS", length = 2)
private String polRenewalStatus; // Renewal Status

/**
 * Annual Policy Holder Fund.
 */
@Column(name = "POL_ANNUAL_PHFUND", precision = 22, scale = 5)
private BigDecimal polAnnualPhfund; // ANNUAL POLICY HOLDER FUND

/**
 * Cover Note Number.
 */
@Column(name = "POL_COVT_NO", length = 50)
private String polCovtNo; // Cover Note Number

/**
 * Coinsurance Gross Premium.
 */
@Column(name = "POL_COIN_GROSS", length = 1)
private String polCoinGross; // COINSURANCE GROSS PREMIUM

/**
 * Policy Summary Remarks.
 */
@Column(name = "POL_SUMMARY_REMARKS", length = 4000)
private String polSummaryRemarks; // POLICY SUMMARY REMARKS

/**
 * Bdiv Code.
 */
@Column(name = "POL_BDIV_CODE", precision = 22)
private Long polBdivCode; // Bdiv Code

/**
 * Sub Agent Code.
 */
@Column(name = "POL_SUB_AGN_CODE", precision = 22)
private Long polSubAgnCode; // Sub Agent Code

/**
 * Sub Agent Short Description.
 */
@Column(name = "POL_SUB_AGN_SHT_DESC", length = 50)
private String polSubAgnShtDesc; // Sub Agent Short Description

/**
 * Sub Agent Commission Amount.
 */
@Column(name = "POL_SUB_AGN_COMM_AMT", precision = 23, scale = 5)
private BigDecimal polSubAgnCommAmt; // Sub Agent Commission Amount

/**
 * Long Term Agreement (LTA) Commission Amount.
 */
@Column(name = "POL_LTA_COMM_AMT", precision = 23, scale = 5)
private BigDecimal polLtaCommAmt; // Long Term Agreement (LTA) Commission Amount

    /**
 * LTA Commission Endorsement Amount.
 */
@Column(name = "POL_LTA_COMM_ENDOS_AMT", precision = 23, scale = 5)
private BigDecimal polLtaCommEndosAmt; // LTA Commission Endorsement Amount

/**
 * Allowed Commission Amount.
 */
@Column(name = "POL_ALLOWED_COMM_AMT", precision = 23, scale = 5)
private BigDecimal polAllowedCommAmt; // Allowed Commission Amount

/**
 * Indicates if an Admin Fee is Applicable.
 */
@Column(name = "POL_ADM_FEE_APPLICABLE", length = 1)
private String polAdmFeeApplicable; // Indicates if an Admin Fee is Applicable

/**
 * Aga Code.
 */
@Column(name = "POL_AGA_CODE", precision = 22)
private Long polAgaCode; // Aga Code

/**
 * Clna Code.
 */
@Column(name = "POL_CLNA_CODE", precision = 22)
private Long polClnaCode; // Clna Code

/**
 * Coin Fee Transaction.
 */
@Column(name = "POL_COIN_FEE_TRANS", length = 1)
private String polCoinFeeTrans; // Coin Fee Transaction

/**
 * Admin Fee Discount Amount.
 */
@Column(name = "POL_ADMIN_FEE_DISC_AMT", precision = 23, scale = 5)
private BigDecimal polAdminFeeDiscAmt; // Admin Fee Discount Amount

/**
 * Sub Aga Code.
 */
@Column(name = "POL_SUB_AGA_CODE", precision = 22)
private Long polSubAgaCode; // Sub Aga Code

/**
 * LTA Commission Discount Amount.
 */
@Column(name = "POL_LTA_COMM_DISC_AMT", precision = 23, scale = 5)
private BigDecimal polLtaCommDiscAmt; // LTA Commission Discount Amount

/**
 * Medical Policy Type.
 */
@Column(name = "POL_MED_POLICY_TYPE", length = 2)
private String polMedPolicyType; // Medical Policy Type

/**
 * Admin Fee Discount Rate.
 */
@Column(name = "POL_ADMIN_FEE_DISC_RATE", precision = 22)
private Long polAdminFeeDiscRate; // Admin Fee Discount Rate

/**
 * Dispatch Date.
 */
@Column(name = "POL_DISPATCH_DT")
private Date polDispatchDt; // Dispatch Date

/**
 * Fee Admissible.
 */
@Column(name = "POL_FEE_ADMISSIBLE", precision = 22)
private Long polFeeAdmissible; // Fee Admissible

/**
 * Marketer Reference Number to Agencies Table.
 */
@Column(name = "POL_MKTR_AGN_CODE", precision = 22)
private Long polMktrAgnCode; // Marketer Reference Number to Agencies Table

/**
 * Marketer Commission.
 */
@Column(name = "POL_MKTR_COM_AMT", precision = 23, scale = 5)
private BigDecimal polMktrComAmt; // Marketer Commission

/**
 * Commission Discount Amount.
 */
@Column(name = "POL_COMM_DISC_AMT", precision = 22)
private Long polCommDiscAmt; // Commission Discount Amount

/**
 * Endorsement VAT Amount.
 */
@Column(name = "POL_VAT_AMT", precision = 23, scale = 5)
private BigDecimal polVatAmt; // Endorsement VAT Amount

/**
 * VAT Rate.
 */
@Column(name = "POL_VAT_RATE", precision = 23, scale = 5)
private BigDecimal polVatRate; // VAT Rate

/**
 * Commission Coinsurance Discount Amount.
 */
@Column(name = "POL_COMM_COIN_DISC_AMT", precision = 23, scale = 5)
private BigDecimal polCommCoinDiscAmt; // Commission Coinsurance Discount Amount

/**
 * Date Time.
 */
@Column(name = "POL_DATE_TIME")
private Date polDateTime; // Date Time

/**
 * Indicates if Endorsement Commission is Allowed.
 */
@Column(name = "POL_ENDORSE_COMM_ALLOWED", length = 1)
private String polEndorseCommAllowed; // Indicates if Endorsement Commission is Allowed

/**
 * Date Reinsurance was checked.
 */
@Column(name = "POL_REIN_CHECKED_DT")
private Date polReinCheckedDt; // Date Reinsurance was checked

/**
 * User who checked Reinsurance.
 */
@Column(name = "POL_REIN_CHECKED_BY", length = 50)
private String polReinCheckedBy; // User who checked Reinsurance

/**
 * Travel Destination Country Code.
 */
@Column(name = "POL_TRV_DST_COU_CODE", precision = 22)
private Long polTrvDstCouCode; // Travel Destination Country Code

/**
 * Coinsurance Debit/Credit Note Number.
 */
@Column(name = "POL_COIN_DRCR_NO", length = 50)
private String polCoinDrcrNo; // Coinsurance Debit/Credit Note Number

/**
 * Indicates if Premium was Computed.
 */
@Column(name = "POL_PREM_COMPUTED", length = 1)
private String polPremComputed; // Indicates if Premium was Computed

/**
 * Indicates if Taxes were applied.
 */
@Column(name = "POL_POP_TAXES", length = 1)
private String polPopTaxes; // Indicates if Taxes were applied

/**
 * Business Growth Type 'N' - New business, 'O' - Organic Growth, 'R' - Renewal.
 */
@Column(name = "POL_BUSSINESS_GROWTH_TYPE", length = 2)
private String polBussinessGrowthType; // Business Growth Type 'N' - New business, 'O' - Organic Growth, 'R' - Renewal

/**
 * Sub Agent.
 */
@Column(name = "POL_SUBAGENT", length = 1)
private String polSubagent; // Sub Agent

/**
 * Number of Installments.
 */
@Column(name = "POL_IPF_NOF_INSTALS", precision = 8)
private Long polIpfNofInstals; // Number of Installments

/**
 * Co-agent.
 */
@Column(name = "POL_COAGENT", length = 1)
private String polCoagent; // Co-agent

/**
 * Main Percentage of Co-agent.
 */
@Column(name = "POL_COAGENT_MAIN_PCT", precision = 15, scale = 4)
private BigDecimal polCoagentMainPct; // Main Percentage of Co-agent

/**
 * Indicates if Agent is Discounted.
 */
@Column(name = "POL_AGN_DISCOUNTED", length = 1)
private String polAgnDiscounted; // Indicates if Agent is Discounted

/**
 * Agent Discount Type.
 */
@Column(name = "POL_AGN_DISC_TYPE", length = 1)
private String polAgnDiscType; // Agent Discount Type

/**
 * Agent Discount Amount.
 */
@Column(name = "POL_AGN_DISCOUNT", precision = 22, scale = 5)
private BigDecimal polAgnDiscount; // Agent Discount Amount

/**
 * Endorsement Discount.
 */
@Column(name = "POL_ENDOS_DISCOUNT", precision = 22, scale = 5)
private BigDecimal polEndosDiscount; // Endorsement Discount

/**
 * Travel Loaded.
 */
@Column(name = "POL_TRV_LOADED", length = 2)
private String polTrvLoaded; // Travel Loaded

/**
 * Travel Date Issued.
 */
@Column(name = "POL_TRV_DT_ISSUED")
private Date polTrvDtIssued; // Travel Date Issued

/**
 * Tcb Code.
 */
@Column(name = "POL_TCB_CODE", precision = 22)
private Long polTcbCode; // Tcb Code

/**
 * Client Reference.
 */
@Column(name = "POL_CLNT_REF", length = 50)
private String polClntRef; // Client Reference

/**
 * Policy cancelled by either Client (C) or Insured (I).
 */
@Column(name = "POL_CANCELLED_BY", length = 1)
private String polCancelledBy; // Policy cancelled by either Client (C) or Insured (I)

/**
 * User who dispatched the policy.
 */
@Column(name = "POL_DISPATCH_BY", length = 50)
private String polDispatchBy; // User who dispatched the policy

/**
 * Rescue Charge.
 */
@Column(name = "POL_RESCUE_CHARGE", precision = 23, scale = 5)
private BigDecimal polRescueCharge; // Rescue Charge

/**
 * Installment Payment Facility (IPF) Down Payment Type.
 */
@Column(name = "POL_IPF_DOWN_PYMT_TYPE", length = 50)
private String polIpfDownPymtType; // Installment Payment Facility (IPF) Down Payment Type

/**
 * IPF Down Payment Amount.
 */
@Column(name = "POL_IPF_DOWN_PYMT_AMT", precision = 23, scale = 5)
private BigDecimal polIpfDownPymtAmt; // IPF Down Payment Amount

/**
 * IPF Interest Rate.
 */
@Column(name = "POL_IPF_INTEREST_RATE", precision = 23, scale = 5)
private BigDecimal polIpfInterestRate; // IPF Interest Rate

/**
 * Indicates if the policy is from an external system.
 */
@Column(name = "POL_OUTSIDE_SYSTEM", length = 1)
private String polOutsideSystem; // Indicates if the policy is from an external system

/**
 * Indicates if the policy is an Open Cover.
 */
@Column(name = "POL_OPEN_COVER", nullable = false, length = 1)
private String polOpenCover; // Indicates if the policy is an Open Cover

/**
 * Endorsement Status.
 */
@Column(name = "POL_ENDORS_STATUS", length = 50)
private String polEndorsStatus; // Endorsement Status

    /**
 * Cover Note Number.
 */
@Column(name = "POL_COVER_NOTE_NO", length = 50)
private String polCoverNoteNo; // Cover Note Number

/**
 * User who created the cover note.
 */
@Column(name = "POL_COVER_NOTE_BY", length = 50)
private String polCoverNoteBy; // User who created the cover note

/**
 * Date the cover note was created.
 */
@Column(name = "POL_COVER_NOTE_DATE")
private Date polCoverNoteDate; // Date the cover note was created

/**
 * Cover Note Effective From Date.
 */
@Column(name = "POL_COVER_NOTE_WEF")
private Date polCoverNoteWef; // Cover Note Effective From Date

/**
 * Cover Note Effective To Date.
 */
@Column(name = "POL_COVER_NOTE_WET")
private Date polCoverNoteWet; // Cover Note Effective To Date

/**
 * Indicates if the policy is an open policy.
 */
@Column(name = "POL_OPEN_POLICY", length = 1)
private String polOpenPolicy; // Indicates if the policy is an open policy

/**
 * Indicates if the policy is a COMESA Endorsement.
 */
@Column(name = "POL_ENDORSE_COMESA", length = 1)
private String polEndorseComesa; // Indicates if the policy is a COMESA Endorsement

/**
 * Next Installment Premium.
 */
@Column(name = "POL_NEXT_INST_PREM", precision = 22, scale = 5)
private BigDecimal polNextInstPrem; // Next Installment Premium

/**
 * Coinsurance Policy Holder Fund.
 */
@Column(name = "POL_CO_PHFUND", precision = 22, scale = 5)
private BigDecimal polCoPhfund; // Coinsurance Policy Holder Fund

/**
 * Load.
 */
@Column(name = "LOAD", length = 50)
private String load; // Load

/**
 * Indicates if the policy is a debit policy.
 */
@Column(name = "POL_POLICY_DEBIT", length = 1)
private String polPolicyDebit; // Indicates if the policy is a debit policy

/**
 * Indicates if the policy is a scheme policy.
 */
@Column(name = "POL_SCHEME_POLICY", length = 1)
private String polSchemePolicy; // Indicates if the policy is a scheme policy

/**
 * Lapse Reason.
 */
@Column(name = "POL_LAPSE_REASON", length = 200)
private String polLapseReason; // Lapse Reason

/**
 * Cover Note Remarks.
 */
@Column(name = "POL_COVER_NOTE_REMARKS", length = 300)
private String polCoverNoteRemarks; // Cover Note Remarks

/**
 * Indicates if the policy is a joint policy.
 */
@Column(name = "POL_JOINT", length = 1)
private String polJoint; // Indicates if the policy is a joint policy

/**
 * Joint Policy Holder Code.
 */
@Column(name = "POL_JOINT_PRP_CODE", precision = 22)
private Long polJointPrpCode; // Joint Policy Holder Code

/**
 * Product Interface Type (default is ACCRUAL).
 */
@Column(name = "POL_PRO_INTERFACE_TYPE", length = 10)
private String polProInterfaceType; // Product Interface Type (default is ACCRUAL)

/**
 * Unlapse Reason.
 */
@Column(name = "POL_UNLAPSE_REASON", length = 1000)
private String polUnlapseReason; // Unlapse Reason

/**
 * Health Tax.
 */
@Column(name = "POL_HEALTH_TAX", length = 50)
private String polHealthTax; // Health Tax

/**
 * Road Safety Tax.
 */
@Column(name = "POL_ROAD_SAFETY_TAX", length = 50)
private String polRoadSafetyTax; // Road Safety Tax

/**
 * Web Policy.
 */
@Column(name = "POL_WEB_POLICY", length = 50)
private String polWebPolicy; // Web Policy

/**
 * Motor Tax.
 */
@Column(name = "POL_MOTOR_TAX", precision = 23, scale = 5)
private BigDecimal polMotorTax; // Motor Tax

/**
 * Certification Charge.
 */
@Column(name = "POL_CERTCHG", precision = 23, scale = 5)
private BigDecimal polCertchg; // Certification Charge

/**
 * Client VAT Amount.
 */
@Column(name = "POL_CLIENT_VAT_AMT", precision = 23, scale = 5)
private BigDecimal polClientVatAmt; // Client VAT Amount

/**
 * Motor Levy.
 */
@Column(name = "POL_MOTOR_LEVY", precision = 23, scale = 5)
private BigDecimal polMotorLevy; // Motor Levy

/**
 * Date of Confirmation.
 */
@Column(name = "POL_CONFIRMED_DATE")
private Date polConfirmedDate; // Date of Confirmation

/**
 * User who confirmed the policy.
 */
@Column(name = "POL_CONFIRMED_BY", length = 50)
private String polConfirmedBy; // User who confirmed the policy

/**
 * Date the Credit Note was Notified.
 */
@Column(name = "POL_CR_DATE_NOTIFIED")
private Date polCrDateNotified; // Date the Credit Note was Notified

/**
 * Credit Note Number.
 */
@Column(name = "POL_CR_NOTE_NUMBER", length = 400)
private String polCrNoteNumber; // Credit Note Number

/**
 * Remarks Code.
 */
@Column(name = "POL_REMARKS_CODE", precision = 22)
private Long polRemarksCode; // Remarks Code

/**
 * End Code Remarks.
 */
@Column(name = "POL_END_CODE_REMARKS", precision = 30)
private Long polEndCodeRemarks; // End Code Remarks

/**
 * Regional Endorsements.
 */
@Column(name = "POL_REGIONAL_ENDORS", length = 50)
private String polRegionalEndors; // Regional Endorsements

/**
 * Policy Fee.
 */
@Column(name = "POL_POLICY_FEE", precision = 25, scale = 5)
private BigDecimal polPolicyFee; // Policy Fee

/**
 * Rentrack Status.
 */
@Column(name = "POL_RENTRACK_STATUS", length = 1)
private String polRentrackStatus; // Rentrack Status

/**
 * Rentrack User.
 */
@Column(name = "POL_RENTRACK_USER", length = 50)
private String polRentrackUser; // Rentrack User

/**
 * Cashback Rate.
 */
@Column(name = "POL_CASHBACK_RATE", precision = 22, scale = 5)
private BigDecimal polCashbackRate; // Cashback Rate

/**
 * Cashback Level.
 */
@Column(name = "POL_CASHBACK_LEVEL", precision = 22)
private Long polCashbackLevel; // Cashback Level

/**
 * Indicates if Admin Fee is Allowed.
 */
@Column(name = "POL_ADMIN_FEE_ALLOWED", nullable = false, length = 1)
private String polAdminFeeAllowed; // Indicates if Admin Fee is Allowed

/**
 * LTA Withholding Tax.
 */
@Column(name = "POL_LTA_WTHT", precision = 23, scale = 5)
private BigDecimal polLtaWtht; // LTA Withholding Tax

/**
 * Cleaned.
 */
@Column(name = "CLEANED", length = 1)
private String cleaned; // Cleaned

/**
 * Indicates if Cashback is Applicable.
 */
@Column(name = "POL_CASHBACK_APPL", nullable = false, length = 1)
private String polCashbackAppl; // Indicates if Cashback is Applicable

/**
 * Indicates if the policy is Underwriting Only.
 */
@Column(name = "POL_UW_ONLY", length = 1)
private String polUwOnly; // Indicates if the policy is Underwriting Only

/**
 * Other Commission Charges.
 */
@Column(name = "POL_OTHER_COM_CHARGES", precision = 23, scale = 5)
private BigDecimal polOtherComCharges; // Other Commission Charges

/**
 * Debiting Type.
 */
@Column(name = "POL_DEBITING_TYPE", length = 5)
private String polDebitingType; // Debiting Type

/**
 * Debt Owner.
 */
@Column(name = "POL_DEBT_OWNER", length = 50)
private String polDebtOwner; // Debt Owner

/**
 * Credit Limit.
 */
@Column(name = "POL_CREDIT_LIMIT", precision = 22)
private Long polCreditLimit; // Credit Limit

/**
 * Payment Installment Percentages.
 */
@Column(name = "POL_PYMT_INSTALL_PCTS", length = 50)
private String polPymtInstallPcts; // Payment Installment Percentages

    /**
 * Promise Date.
 */
@Column(name = "POL_PROMISE_DATE")
private Date polPromiseDate; // Promise Date

/**
 * Renewal Endorsement Number.
 */
@Column(name = "POL_RNW_ENDS_NO", length = 26)
private String polRnwEndsNo; // Renewal Endorsement Number

/**
 * Org Code.
 */
@Column(name = "POL_ORG_CODE", precision = 22)
private Long polOrgCode; // Org Code

/**
 * Source of Direct Business.
 */
@Column(name = "POL_SRC_DIRECT_BUSINESS", precision = 22)
private Long polSrcDirectBusiness; // Source of Direct Business

/**
 * Other Client Deductibles.
 */
@Column(name = "POL_OTHER_CLIENT_DEDUCTIBLES", precision = 22)
private Long polOtherClientDeductibles; // Other Client Deductibles

/**
 * Coinsurance Other Client Charges.
 */
@Column(name = "POL_COIN_OTHER_CLIENT_CHARGES", precision = 22)
private Long polCoinOtherClientCharges; // Coinsurance Other Client Charges

/**
 * Loaded External Reference Number.
 */
@Column(name = "POL_LOADED_EXT_REFNO", length = 100)
private String polLoadedExtRefno; // Loaded External Reference Number

/**
 * Poll Code.
 */
@Column(name = "POL_POLL_CODE", precision = 22)
private Long polPollCode; // Poll Code

/**
 * Introducer Commission Amount.
 */
@Column(name = "POL_INTR_COM_AMT", precision = 22)
private Long polIntrComAmt; // Introducer Commission Amount

/**
 * Indicates if Coinsurance Facultative Cession is Applicable.
 */
@Column(name = "POL_COIN_FAC_CESSION", nullable = false, length = 1)
private String polCoinFacCession; // Indicates if Coinsurance Facultative Cession is Applicable

/**
 * Coinsurance Facultative Percentage.
 */
@Column(name = "POL_COIN_FAC_PC", precision = 22)
private Long polCoinFacPc; // Coinsurance Facultative Percentage

/**
 * Commission Levy Rate.
 */
@Column(name = "POL_COMM_LEVY_RATE", precision = 22)
private Long polCommLevyRate; // Commission Levy Rate

/**
 * Commission Levy Amount.
 */
@Column(name = "POL_COMM_LEVY_AMT", precision = 22)
private Long polCommLevyAmt; // Commission Levy Amount

/**
 * Policy Document Path.
 */
@Column(name = "POL_POLICY_DOC", length = 200)
private String polPolicyDoc; // Policy Document Path

/**
 * Declaration Bottom Limit.
 */
@Column(name = "POL_DECL_BOTTOM_LIMIT", precision = 22, scale = 5)
private BigDecimal polDeclBottomLimit; // Declaration Bottom Limit

/**
 * Invoice Number.
 */
@Column(name = "POL_INVOICE_NO", length = 100)
private String polInvoiceNo; // Invoice Number

/**
 * Computation Type Code.
 */
@Column(name = "COMPUTATION_TYPE_CODE", precision = 10)
private Long computationTypeCode; // Computation Type Code

/**
 * Coinsurance Code.
 */
@Column(name = "POL_COIN_CODE", length = 255)
private String polCoinCode; // Coinsurance Code

/**
 * Pre-authorization Number.
 */
@Column(name = "POL_PREAUTH_NO", length = 30)
private String polPreauthNo; // Pre-authorization Number

/**
 * Indicates if Coinsurance is Internal.
 */
@Column(name = "POL_COIN_INTERNAL", length = 1)
private String polCoinInternal; // Indicates if Coinsurance is Internal

/**
 * Internal Percentage.
 */
@Column(name = "POL_INTERNAL_PERCT", precision = 22)
private Long polInternalPerct; // Internal Percentage

/**
 * Risk Duplicate Flag.
 */
@Column(name = "POL_RISK_DUPLICATE", length = 10)
private String polRiskDuplicate; // Risk Duplicate Flag

/**
 * Total Coinsurance Commission.
 */
@Column(name = "POL_COIN_TOT_COMMISSION", precision = 22, scale = 5)
private BigDecimal polCoinTotCommission; // Total Coinsurance Commission

/**
 * Total Coinsurance Withholding Tax.
 */
@Column(name = "POL_COIN_TOT_WHTX", precision = 22, scale = 5)
private BigDecimal polCoinTotWhtx; // Total Coinsurance Withholding Tax

/**
 * Total Coinsurance VAT.
 */
@Column(name = "POL_COIN_TOT_VAT", precision = 22, scale = 5)
private BigDecimal polCoinTotVat; // Total Coinsurance VAT

/**
 * Receive Premium On.
 */
@Column(name = "POL_RCV_PRM_ON", length = 5)
private String polRcvPrmOn; // Receive Premium On

/**
 * Lapse Date.
 */
@Column(name = "POL_LAPSE_DATE")
private Date polLapseDate; // Lapse Date

/**
 * Credit Note Details.
 */
@Column(name = "POL_CRDR_DETAILS", length = 4000)
private String polCrdrDetails; // Credit Note Details

/**
 * Installment Date.
 */
@Column(name = "POL_INSTALLMENT_DATE")
private Date polInstallmentDate; // Installment Date
}