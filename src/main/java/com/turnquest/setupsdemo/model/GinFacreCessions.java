package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This table stores details of facre cessions (facultative reinsurance transactions).
 */
@Entity
@Table(name = "GIN_FACRE_CESSIONS")
@Data
public class GinFacreCessions {
    /**
 * Represents the GIN_FACRE_CESSIONS table which stores details of facultative reinsurance transactions.
 */
@Id
@Column(name = "FC_CODE", nullable = false, precision = 22)
private Long fcCode; // Table Primary Key

/**
 * Foreign Reference to TQC_AGENCIES.AGN_CODE
 */
@Column(name = "FC_AGNT_AGENT_CODE", nullable = false, precision = 22)
private Long fcAgntAgentCode;

/**
 * Facre amount
 */
@Column(name = "FC_AMOUNT", precision = 23, scale = 5)
private BigDecimal fcAmount;

/**
 * With effective date from
 */
@Column(name = "FC_WEF")
private Date fcWef;

/**
 * Foreign Key Referencing GIN_INSURED_PROPERTY_UNDS.IPU_CODE
 */
@Column(name = "FC_IPU_CODE", nullable = false, precision = 22)
private Long fcIpuCode;

/**
 * Agent unique Id
 */
@Column(name = "FC_AGENT_SHT_DESC", nullable = false, length = 30)
private String fcAgentShtDesc;

/**
 * Facre rate
 */
@Column(name = "FC_RATE", precision = 22, scale = 5)
private BigDecimal fcRate;

/**
 * Commission Rate
 */
@Column(name = "FC_COMM_RATE", precision = 22, scale = 5)
private BigDecimal fcCommRate;

/**
 * Commission amount
 */
@Column(name = "FC_COMM_AMT", precision = 22, scale = 5)
private BigDecimal fcCommAmt;

/**
 * Prepared by
 */
@Column(name = "FC_DON_BY", length = 30)
private String fcDonBy;

/**
 * Debit Credit note Number
 */
@Column(name = "FC_DC_NO", length = 15)
private String fcDcNo;

/**
 * Facre premium
 */
@Column(name = "FC_PREM_AMT", precision = 23, scale = 5)
private BigDecimal fcPremAmt;

/**
 * Foreign Key Referencing GIN_POLICIES.POL_BATCH_NO
 */
@Column(name = "FC_POL_BATCH_NO", nullable = false, precision = 22)
private Long fcPolBatchNo;

/**
 * Underwriting year
 */
@Column(name = "FC_UWYR", nullable = false, precision = 22)
private Long fcUwyr;

/**
 * Foreign Key Referencing GIN_GIS_TRANSACTIONS.GGT_TRAN_NO
 */
@Column(name = "FC_GGT_TRAN_NO", precision = 22)
private Long fcGgtTranNo;

/**
 * Transaction Type
 */
@Column(name = "FC_TRAN_TYPE", length = 15)
private String fcTranType;

/**
 * Sub class code foreign Key to GIN_SUBCLASSES
 */
@Column(name = "FC_SCL_CODE", precision = 22)
private Long fcSclCode;

    /**
 * Indicates if the rate is an amount or a percentage
 */
@Column(name = "FC_AMT_OR_RATE", length = 1)
private String fcAmtOrRate;

/**
 * Foreign Key referencing GIN_POLICY_RISK_RI_DTLS
 */
@Column(name = "FC_PRRD_CODE", nullable = false, precision = 22)
private Long fcPrrdCode;

/**
 * Audit trail for the user who authorized facre transaction
 */
@Column(name = "FC_AUTH_DT")
private Date fcAuthDt;

/**
 * Previous facre rate
 */
@Column(name = "FC_PREV_RATE", precision = 10, scale = 5)
private BigDecimal fcPrevRate;

/**
 * Facre refund premium
 */
@Column(name = "FC_REFUND_PREM", precision = 22, scale = 5)
private BigDecimal fcRefundPrem;

/**
 * Refund facre commission
 */
@Column(name = "FC_REFUND_COMM", precision = 22, scale = 5)
private BigDecimal fcRefundComm;

/**
 * Previous facre premium amount
 */
@Column(name = "FC_PREV_AMOUNT", precision = 22, scale = 5)
private BigDecimal fcPrevAmount;

/**
 * With effective to date
 */
@Column(name = "FC_WET")
private Date fcWet;

/**
 * Previous facre commission rate
 */
@Column(name = "FC_PREV_COMM_RATE", precision = 15, scale = 5)
private BigDecimal fcPrevCommRate;

/**
 * Previous facre reference key
 */
@Column(name = "FC_PREV_FC_CODE", precision = 22)
private Long fcPrevFcCode;

/**
 * Previous facre is
 */
@Column(name = "FC_PREV_SI", precision = 22, scale = 5)
private BigDecimal fcPrevSi;

/**
 * Earthquake Premium
 */
@Column(name = "FC_EARTHQKE_PREM", precision = 20, scale = 5)
private BigDecimal fcEarthqkePrem;

/**
 * Earthquake Commission Rate
 */
@Column(name = "FC_EARTHQKE_COMM_RATE", precision = 10, scale = 5)
private BigDecimal fcEarthqkeCommRate;

/**
 * Earthquake Commission
 */
@Column(name = "FC_EARTHQKE_COMM", precision = 20, scale = 5)
private BigDecimal fcEarthqkeComm;

/**
 * Net less Earthquake Commission
 */
@Column(name = "FC_NET_LESS_EQ_COMM", precision = 20, scale = 5)
private BigDecimal fcNetLessEqComm;

/**
 * Net less Earthquake Premium
 */
@Column(name = "FC_NET_LESS_EQ_PREM", precision = 20, scale = 5)
private BigDecimal fcNetLessEqPrem;

    /**
 * Indicates if the offerslip has been accepted or not
 */
@Column(name = "FC_ACCEPTED", length = 1)
private String fcAccepted;

/**
 * Indicates the facre type
 */
@Column(name = "FC_FACRE_TYPE", length = 1)
private String fcFacreType;

/**
 * Date the offerslip was accepted
 */
@Column(name = "FC_ACCEPTED_DATE")
private Date fcAcceptedDate;

/**
 * Premium Difference Amount
 */
@Column(name = "FC_PREM_DIFF_AMT", precision = 23, scale = 5)
private BigDecimal fcPremDiffAmt;

/**
 * Remarks
 */
@Column(name = "FC_REMARK", length = 100)
private String fcRemark;

/**
 * Management Type
 */
@Column(name = "FC_MNGMNT_TYPE", length = 50)
private String fcMngmntType;

/**
 * Management Value
 */
@Column(name = "FC_MNGMNT_VALUE", precision = 30, scale = 5)
private BigDecimal fcMngmntValue;

/**
 * Reinsurance Tax Type
 */
@Column(name = "FC_REIN_TAX_TYPE", length = 50)
private String fcReinTaxType;

/**
 * Reinsurance Tax Value
 */
@Column(name = "FC_REIN_TAX_VALUE", precision = 30, scale = 5)
private BigDecimal fcReinTaxValue;

/**
 * Reinsurance Tax Amount
 */
@Column(name = "FC_REIN_TAX_AMT", precision = 23, scale = 5)
private BigDecimal fcReinTaxAmt;

/**
 * Management Amount
 */
@Column(name = "FC_MNGMNT_AMT", precision = 23, scale = 5)
private BigDecimal fcMngmntAmt;

/**
 * VAT Rate
 */
@Column(name = "FC_VAT_RATE", precision = 23, scale = 5)
private BigDecimal fcVatRate;

/**
 * VAT Amount
 */
@Column(name = "FC_VAT_AMT", precision = 23, scale = 5)
private BigDecimal fcVatAmt;

/**
 * Override Value
 */
@Column(name = "FC_OVERRIDE_VALUE", precision = 23, scale = 5)
private BigDecimal fcOverrideValue;

/**
 * Override Type
 */
@Column(name = "FC_OVERRIDE_TYPE", length = 20)
private String fcOverrideType;

/**
 * Override Premium
 */
@Column(name = "FC_OVERRIDE_PREM", precision = 23, scale = 5)
private BigDecimal fcOverridePrem;

/**
 * Override Premium Amount
 */
@Column(name = "FC_OVERRIDE_PREM_AMT", precision = 23, scale = 5)
private BigDecimal fcOverridePremAmt;

/**
 * Withholding Tax Amount
 */
@Column(name = "FC_WHTX_AMT", precision = 23, scale = 4)
private BigDecimal fcWhtxAmt;

/**
 * Withholding Tax Rate
 */
@Column(name = "FC_WHTX_RATE", precision = 23, scale = 4)
private BigDecimal fcWhtxRate;

/**
 * Intermediary Code
 */
@Column(name = "FC_INTERMEDIARY_CODE", precision = 22)
private Long fcIntermediaryCode;

/**
 * PFCS Code
 */
@Column(name = "FC_PFCS_CODE", precision = 22)
private Long fcPfcsCode;
}