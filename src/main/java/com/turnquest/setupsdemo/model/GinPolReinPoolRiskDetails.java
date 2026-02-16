package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This table stores details of reinsurance pool risks.
 */
@Entity
@Table(name = "GIN_POL_REIN_POOL_RISK_DETAILS")
@Data
public class GinPolReinPoolRiskDetails {
    /**
 * Primary key for the table
 */
@Id
@Column(name = "PRPRD_CODE", nullable = false)
private Long prprdCode;

/**
 * Risk premium amount
 */
@Column(name = "PRPRD_RISK_PREM_AMT", precision = 23, scale = 5)
private BigDecimal prprdRiskPremAmt;

/**
 * Risk owner retention amount
 */
@Column(name = "PRPRD_RISK_OWN_RET_AMT", precision = 23, scale = 5)
private BigDecimal prprdRiskOwnRetAmt;

/**
 * Risk currency code
 */
@Column(name = "PRPRD_RISK_CUR_CODE", precision = 22)
private Long prprdRiskCurCode;

/**
 * Risk exchange rate
 */
@Column(name = "PRPRD_RISK_EXCH_RATE", precision = 23, scale = 5)
private BigDecimal prprdRiskExchRate;

/**
 * Foreign Key referencing GIN\_SUBCL\_COVER\_RI\_POOL\_RATES.SCRPR\_CODE
 */
@Column(name = "PRPRD_SCRPR_CODE", nullable = false)
private Long prprdScrprCode;

/**
 * Reinsurance pool rate
 */
@Column(name = "PRPRD_REIN_POOL_RATE", precision = 23, scale = 5)
private BigDecimal prprdReinPoolRate;

/**
 * Insured property code
 */
@Column(name = "PRPRD_IPU_CODE", nullable = false)
private Long prprdIpuCode;

/**
 * Subclass code
 */
@Column(name = "PRPRD_SCL_CODE", nullable = false)
private Long prprdSclCode;

/**
 * Cover type code
 */
@Column(name = "PRPRD_COVT_CODE", nullable = false)
private Long prprdCovtCode;

/**
 * Policy batch number
 */
@Column(name = "PRPRD_POL_BATCH_NO", nullable = false)
private Long prprdPolBatchNo;

/**
 * Reinsurance pool amount
 */
@Column(name = "PRPRD_REIN_POOL_AMT", precision = 23, scale = 5)
private BigDecimal prprdReinPoolAmt;

/**
 * Reinsurance pool commission rate
 */
@Column(name = "PRPRD_REIN_POOL_COMM_RATE", precision = 23, scale = 5)
private BigDecimal prprdReinPoolCommRate;

/**
 * Reinsurance pool VAT rate
 */
@Column(name = "PRPRD_REIN_POOL_VAT_RATE", precision = 23, scale = 5)
private BigDecimal prprdReinPoolVatRate;

/**
 * Reinsurance pool commission amount
 */
@Column(name = "PRPRD_REIN_POOL_COMM_AMT", precision = 23, scale = 5)
private BigDecimal prprdReinPoolCommAmt;

/**
 * Reinsurance pool VAT amount
 */
@Column(name = "PRPRD_REIN_POOL_VAT_AMT", precision = 23, scale = 5)
private BigDecimal prprdReinPoolVatAmt;

/**
 * Previous pool risk details code
 */
@Column(name = "PRPRD_PREV_PRPRD_CODE")
private Long prprdPrevPrprdCode;

/**
 * Foreign Key referencing GIN\_GIS\_TRANSACTIONS.GGT\_TRANS\_NO
 */
@Column(name = "PRPRD_GGT_TRAN_NO", nullable = false)
private Long prprdGgtTranNo;

/**
 * Property ID
 */
@Column(name = "PRPRD_PROPERTY_ID", length = 30)
private String prprdPropertyId;

    /**
 * Underwriting year
 */
@Column(name = "PRPRD_UWYR", precision = 22)
private Long prprdUwyr;

/**
 * Policy endorsement number
 */
@Column(name = "PRPRD_POL_REN_ENDOS_NO", length = 50)
private String prprdPolRenEndosNo;

/**
 * Date
 */
@Column(name = "PRPRD_DATE", nullable = false)
private Date prprdDate;

/**
 * Risk treaty owner retention amount
 */
@Column(name = "PRPRD_RISK_TRT_OWN_RET_AMT", precision = 23, scale = 5)
private BigDecimal prprdRiskTrtOwnRetAmt;

/**
 * PTA code
 */
@Column(name = "PRPRD_PTA_CODE", precision = 22)
private Long prprdPtaCode;

/**
 * Indicates if the record is authorized
 */
@Column(name = "PRPRD_AUTHORIZED", length = 1)
private String prprdAuthorized;

/**
 * User who authorized the record
 */
@Column(name = "PRPRD_AUTHORIZED_BY", length = 30)
private String prprdAuthorizedBy;

/**
 * Date of authorization
 */
@Column(name = "PRPRD_AUTH_DATE")
private Date prprdAuthDate;

/**
 * Outstanding claim amount
 */
@Column(name = "PRPRD_OS_CLAIM_AMT", precision = 23, scale = 5)
private BigDecimal prprdOsClaimAmt;

/**
 * Paid claim amount
 */
@Column(name = "PRPRD_PAID_CLAIM_AMT", precision = 23, scale = 5)
private BigDecimal prprdPaidClaimAmt;

/**
 * Pool net amount
 */
@Column(name = "PRPRD_POOL_NET_AMT", precision = 23, scale = 5)
private BigDecimal prprdPoolNetAmt;

/**
 * Refund premium
 */
@Column(name = "PRPRD_REFUND_PREM", precision = 22, scale = 5)
private BigDecimal prprdRefundPrem;

/**
 * Refund commission
 */
@Column(name = "PRPRD_REFUND_COMM", precision = 22, scale = 5)
private BigDecimal prprdRefundComm;

/**
 * Risk reinsurance transaction code
 */
@Column(name = "PRPRD_PRRD_CODE", nullable = false)
private Long prprdPrrdCode;

/**
 * Pool Sum Insured
 */
@Column(name = "PRPRD_POOL_SI", precision = 23, scale = 5)
private BigDecimal prprdPoolSi;

/**
 * Previous pool amount
 */
@Column(name = "PRPRD_PREV_POOL_AMT", precision = 22, scale = 5)
private BigDecimal prprdPrevPoolAmt;

/**
 * Previous pool commission rate
 */
@Column(name = "PRPRD_PREV_POOL_COMM_RATE", precision = 22, scale = 5)
private BigDecimal prprdPrevPoolCommRate;

/**
 * Previous pool rate
 */
@Column(name = "PRPRD_PREV_POOL_RATE", precision = 22, scale = 5)
private BigDecimal prprdPrevPoolRate;

/**
 * Gross company retention
 */
@Column(name = "PRPRD_GROSS_COMP_RETENTION", precision = 22, scale = 5)
private BigDecimal prprdGrossCompRetention;
}