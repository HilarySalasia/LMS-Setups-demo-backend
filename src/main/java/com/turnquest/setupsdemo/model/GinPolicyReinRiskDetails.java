package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This table stores details of reinsurance transactions related to specific risks,
 * including information about the policy, treaty, and reinsurance setup.
 */
@Entity
@Table(name = "GIN_POLICY_REIN_RISK_DETAILS")
@Data
public class GinPolicyReinRiskDetails {
    /**
 * Primary key for the table
 */
@Id
@Column(name = "PTOTR_CODE", nullable = false, precision = 22)
private Long ptotrCode;

/**
 * Risk currency code
 */
@Column(name = "PTOTR_RISK_CUR_CODE", precision = 22)
private Long ptotrRiskCurCode;

/**
 * Treaty currency code
 */
@Column(name = "PTOTR_TRT_CUR_CODE", precision = 22)
private Long ptotrTrtCurCode;

/**
 * Exchange rate
 */
@Column(name = "PTOTR_EXCH_RATE", precision = 22, scale = 5)
private BigDecimal ptotrExchRate;

/**
 * Risk sum insured in policy currency
 */
@Column(name = "PTOTR_RISK_SI_PCUR", precision = 22, scale = 5)
private BigDecimal ptotrRiskSiPcur;

/**
 * Risk sum insured in treaty currency
 */
@Column(name = "PTOTR_RISK_SI_TCUR", precision = 22, scale = 5)
private BigDecimal ptotrRiskSiTcur;

/**
 * Risk premium in policy currency
 */
@Column(name = "PTOTR_RISK_PREM_PCUR", precision = 22, scale = 5)
private BigDecimal ptotrRiskPrenPcur;

/**
 * Risk premium in treaty currency
 */
@Column(name = "PTOTR_RISK_PREM_TCUR", precision = 22, scale = 5)
private BigDecimal ptotrRiskPremTcur;

/**
 * Treaty sum insured in policy currency
 */
@Column(name = "PTOTR_TRT_SI_PCUR", precision = 22, scale = 5)
private BigDecimal ptotrTrtSiPcur;

/**
 * Treaty sum insured in treaty currency
 */
@Column(name = "PTOTR_TRT_SI_TCUR", precision = 22, scale = 5)
private BigDecimal ptotrTrtSiTcur;

/**
 * Treaty premium in policy currency
 */
@Column(name = "PTOTR_TRT_PREM_PCUR", precision = 22, scale = 5)
private BigDecimal ptotrTrtPrenPcur;

/**
 * Treaty premium in treaty currency
 */
@Column(name = "PTOTR_TRT_PREM_TCUR", precision = 22, scale = 5)
private BigDecimal ptotrTrtPremTcur;

/**
 * Treaty share
 */
@Column(name = "PTOTR_TRT_SHARE", precision = 22, scale = 5)
private BigDecimal ptotrTrtShare;

/**
 * Reinsurance code
 */
@Column(name = "PTOTR_REI_CODE", precision = 22)
private Long ptotrReiCode;

/**
 * Treaty code
 */
@Column(name = "PTOTR_TRT_CODE", precision = 22)
private Long ptotrTrtCode;

/**
 * Treaty short description
 */
@Column(name = "PTOTR_TRT_SHT_DESC", length = 15)
private String ptotrTrtShtDesc;

/**
 * Subclass code
 */
@Column(name = "PTOTR_CLT_SCL_CODE", precision = 22)
private Long ptotrCltSclCode;

/**
 * Rate
 */
@Column(name = "PTOTR_RATE", precision = 22, scale = 5)
private BigDecimal ptotrRate;

    /**
 * Treaty commission in policy currency
 */
@Column(name = "PTOTR_TRT_COMM_PCUR", precision = 22, scale = 5)
private BigDecimal ptotrTrtCommPcur;

/**
 * Treaty commission in treaty currency
 */
@Column(name = "PTOTR_TRT_COMM_TCUR", precision = 22, scale = 5)
private BigDecimal ptotrTrtCommTcur;

/**
 * Cession percentage
 */
@Column(name = "PTOTR_CESSION_PCT", precision = 22, scale = 5)
private BigDecimal ptotrCessionPct;

/**
 * Property ID
 */
@Column(name = "PTOTR_PROPERTY_ID", length = 200)
private String ptotrPropertyId;

/**
 * Underwriting year
 */
@Column(name = "PTOTR_UWYR", precision = 22)
private Long ptotrUwyr;

/**
 * Insured property code
 */
@Column(name = "PTOTR_IPU_CODE", precision = 22)
private Long ptotrIpuCode;

/**
 * Policy batch number
 */
@Column(name = "PTOTR_POL_BATCH_NO", precision = 22)
private Long ptotrPolBatchNo;

/**
 * Policy number
 */
@Column(name = "PTOTR_POL_POLICY_NO", length = 50)
private String ptotrPolPolicyNo;

/**
 * Policy endorsement number
 */
@Column(name = "PTOTR_POL_REN_ENDOS_NO", length = 50)
private String ptotrPolRenEndosNo;

/**
 * Accounting period short description
 */
@Column(name = "PTOTR_ACPR_SHT_DESC", length = 15)
private String ptotrAcprShtDesc;

/**
 * Accounting period code
 */
@Column(name = "PTOTR_ACPR_CODE", precision = 22)
private Long ptotrAcprCode;

/**
 * Risk currency symbol
 */
@Column(name = "PTOTR_RISK_CUR_SYMBOL", length = 15)
private String ptotrRiskCurSymbol;

/**
 * Treaty currency symbol
 */
@Column(name = "PTOTR_TRT_CUR_SYMBOL", length = 15)
private String ptotrTrtCurSymbol;

/**
 * Premium tax in policy currency
 */
@Column(name = "PTOTR_PREM_TAX_PCUR", precision = 22, scale = 5)
private BigDecimal ptotrPremTaxPcur;

/**
 * Premium tax in treaty currency
 */
@Column(name = "PTOTR_PREM_TAX_TCUR", precision = 22, scale = 5)
private BigDecimal ptotrPremTaxTcur;

/**
 * Commission tax in policy currency
 */
@Column(name = "PTOTR_COMM_TAX_PCUR", precision = 22, scale = 5)
private BigDecimal ptotrCommTaxPcur;

/**
 * Commission tax in treaty currency
 */
@Column(name = "PTOTR_COMM_TAX_TCUR", precision = 22, scale = 5)
private BigDecimal ptotrCommTaxTcur;

/**
 * Treaty arrangement code
 */
@Column(name = "PTOTR_TA_CODE", nullable = false, precision = 22)
private Long ptotrTaCode;

/**
 * Arrangement setup code
 */
@Column(name = "PTOTR_AS_CODE", nullable = false, precision = 22)
private Long ptotrAsCode;

/**
 * Section code
 */
@Column(name = "PTOTR_SECT_CODE", precision = 22)
private Long ptotrSectCode;

/**
 * Treaty code
 */
@Column(name = "PTOTR_TRS_CODE", precision = 22)
private Long ptotrTrsCode;

/**
 * Treaty short description
 */
@Column(name = "PTOTR_TRS_SHT_DESC", length = 15)
private String ptotrTrsShtDesc;

    /**
 * Rate type
 */
@Column(name = "PTOTR_RATE_TYPE", length = 1)
private String ptotrRateType;

/**
 * Remarks
 */
@Column(name = "PTOTR_REMARKS", length = 200)
private String ptotrRemarks;

/**
 * GIS transaction number
 */
@Column(name = "PTOTR_GGT_TRAN_NO", precision = 22)
private Long ptotrGgtTranNo;

/**
 * Transaction type
 */
@Column(name = "PTOTR_TRAN_TYPE", length = 15)
private String ptotrTranType;

/**
 * Date
 */
@Column(name = "PTOTR_DATE")
private Date ptotrDate;

/**
 * Reinsurance premium tax in policy currency
 */
@Column(name = "PTOTR_RPREM_TAX_PCUR", precision = 22, scale = 5)
private BigDecimal ptotrRpremTaxPcur;

/**
 * Actual sum insured share
 */
@Column(name = "PTOTR_ACTUAL_SI_SHARE", precision = 22, scale = 5)
private BigDecimal ptotrActualSiShare;

/**
 * Reinsurance transaction code
 */
@Column(name = "PTOTR_PRRD_CODE", precision = 22)
private Long ptotrPrrdCode;

/**
 * Previous cession rate
 */
@Column(name = "PTOTR_PREV_CESSION_RATE", precision = 22, scale = 5)
private BigDecimal ptotrPrevCessionRate;

/**
 * Current indicator
 */
@Column(name = "PTOTR_CURRENT", length = 2)
private String ptotrCurrent;

/**
 * Refund premium
 */
@Column(name = "PTOTR_REFUND_PREM", precision = 25, scale = 5)
private BigDecimal ptotrRefundPrem;

/**
 * Refund commission
 */
@Column(name = "PTOTR_REFUND_COM", precision = 30, scale = 5)
private BigDecimal ptotrRefundCom;

/**
 * Commission rate
 */
@Column(name = "PTOTR_COMM_RATE", precision = 22, scale = 5)
private BigDecimal ptotrCommRate;

/**
 * Date of authorization
 */
@Column(name = "PTOTR_AUTH_DT")
private Date ptotrAuthDt;

/**
 * Reinsurance premium tax in treaty currency
 */
@Column(name = "PTOTR_RPREM_TAX_TCUR", precision = 30, scale = 5)
private BigDecimal ptotrRpremTaxTcur;

/**
 * Refunded premium tax in treaty currency
 */
@Column(name = "PTOTR_REFND_PREM_TAX_TCUR", precision = 30, scale = 5)
private BigDecimal ptotrRefndPremTaxTcur;

/**
 * Refunded reinsurance premium tax in treaty currency
 */
@Column(name = "PTOTR_REFND_RPREM_TAX_TCUR", precision = 30, scale = 5)
private BigDecimal ptotrRefndRpremTaxTcur;

/**
 * Allowed rate
 */
@Column(name = "PTOTR_ALLOWED_RATE", precision = 22, scale = 5)
private BigDecimal ptotrAllowedRate;

/**
 * Previous ceded sum insured
 */
@Column(name = "PTOTR_PREV_CESSION_SI", precision = 22, scale = 5)
private BigDecimal ptotrPrevCessionSi;

/**
 * Earthquake premium
 */
@Column(name = "PTOTR_EARTHQKE_PREM", precision = 20, scale = 5)
private BigDecimal ptotrEarthqkePrem;

/**
 * Earthquake commission rate
 */
@Column(name = "PTOTR_EARTHQKE_COMM_RATE", precision = 10, scale = 5)
private BigDecimal ptotrEarthqkeCommRate;

/**
 * Earthquake commission
 */
@Column(name = "PTOTR_EARTHQKE_COMM", precision = 20, scale = 5)
private BigDecimal ptotrEarthqkeComm;

/**
 * Net commission less earthquake commission
 */
@Column(name = "PTOTR_NET_LESS_EQ_COMM", precision = 20, scale = 5)
private BigDecimal ptotrNetLessEqComm;

/**
 * Net premium less earthquake premium
 */
@Column(name = "PTOTR_NET_LESS_EQ_PREM", precision = 20, scale = 5)
private BigDecimal ptotrNetLessEqPrem;

/**
 * Previous treaty premium in policy currency
 */
@Column(name = "PTOTR_TRT_PREV_PREM_PCUR", precision = 22, scale = 5)
private BigDecimal ptotrTrtPrevPrenPcur;

/**
 * Previous treaty premium in treaty currency
 */
@Column(name = "PTOTR_TRT_PREV_PREM_TCUR", precision = 22, scale = 5)
private BigDecimal ptotrTrtPrevPremTcur;

/**
 * Previous treaty commission in policy currency
 */
@Column(name = "PTOTR_TRT_PREV_COMM_PCUR", precision = 22, scale = 5)
private BigDecimal ptotrTrtPrevCommPcur;

/**
 * Previous treaty commission in treaty currency
 */
@Column(name = "PTOTR_TRT_PREV_COMM_TCUR", precision = 22, scale = 5)
private BigDecimal ptotrTrtPrevCommTcur;

/**
 * Class treaty code
 */
@Column(name = "PTOTR_CTL_CODE", precision = 22)
private Long ptotrCtlCode;

/**
 * Refunded reinsurance premium tax
 */
@Column(name = "PTOTR_REFUND_RPREM_TAX", precision = 22, scale = 5)
private BigDecimal ptotrRefundRpremTax;

/**
 * Refunded premium tax
 */
@Column(name = "PTOTR_REFUND_PREM_TAX", precision = 22, scale = 5)
private BigDecimal ptotrRefundPremTax;

/**
 * Treaty premium tax in treaty currency
 */
@Column(name = "PTOTR_TRT_PREM_TAX_TCUR", precision = 22, scale = 5)
private BigDecimal ptotrTrtPremTaxTcur;

/**
 * Treaty premium tax in policy currency
 */
@Column(name = "PTOTR_TRT_PREM_TAX_PCUR", precision = 22, scale = 5)
private BigDecimal ptotrTrtPremTaxPcur;

/**
 * Previous treaty sum insured in policy currency
 */
@Column(name = "PTOTR_TRT_PREV_SI_PCUR", precision = 23, scale = 4)
private BigDecimal ptotrTrtPrevSiPcur;

/**
 * Previous code
 */
@Column(name = "PTOTR_PREV_CODE", precision = 22)
private Long ptotrPrevCode;

/**
 * Cession Number
 */
@Column(name = "PTOTR_CESSION_NUMBER", length = 100)
private String ptotrCessionNumber;
}
