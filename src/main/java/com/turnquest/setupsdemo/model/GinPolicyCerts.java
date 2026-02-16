package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This table stores information about policy certificates.
 */
@Entity
@Table(name = "GIN_POLICY_CERTS")
@Data
public class GinPolicyCerts {
/**
 * Date the certificate was issued.
 */
@Column(name = "POLC_ISSUE_DT", nullable = false)
private Date polcIssueDt;

/**
 * Policy Number.
 */
@Column(name = "POLC_POL_POLICY_NO", nullable = false, length = 30)
private String polcPolPolicyNo;

/**
 * Endorsement Number.
 */
@Column(name = "POLC_POL_REN_ENDOS_NO", nullable = false, length = 30)
private String polcPolRenEndosNo;

/**
 * Policy Batch Number.
 */
@Column(name = "POLC_POL_BATCH_NO", nullable = false, precision = 22)
private Long polcPolBatchNo;

/**
 * Certificate Number.
 */
@Column(name = "POLC_CER_CERT_NO", precision = 22)
private Long polcCerCertNo;

/**
 * Certificate Type Code.
 */
@Column(name = "POLC_CT_CODE", precision = 22)
private Long polcCtCode;

/**
 * Agent Code.
 */
@Column(name = "POLC_AGNT_AGENT_CODE", nullable = false, precision = 22)
private Long polcAgntAgentCode;

/**
 * Agent Short Description.
 */
@Column(name = "POLC_AGNT_SHT_DESC", nullable = false, length = 200)
private String polcAgntShtDesc;

/**
 * Property ID.
 */
@Column(name = "POLC_PROPERTY_ID", length = 60)
private String polcPropertyId;

/**
 * Insured Property Code.
 */
@Column(name = "POLC_IPU_CODE", nullable = false, precision = 22)
private Long polcIpuCode;

/**
 * Status of the certificate.
 */
@Column(name = "POLC_STATUS", length = 1)
private String polcStatus;

/**
 * Date the certificate was printed.
 */
@Column(name = "POLC_PRINT_DT")
private Date polcPrintDt;

/**
 * Reason for cancellation.
 */
@Column(name = "POLC_REASON_CANCELLED", length = 200)
private String polcReasonCancelled;

/**
 * Date the certificate was canceled.
 */
@Column(name = "POLC_CANCEL_DT")
private Date polcCancelDt;

/**
 * Effective From Date.
 */
@Column(name = "POLC_WEF", nullable = false)
private Date polcWef;

/**
 * Effective To Date.
 */
@Column(name = "POLC_WET", nullable = false)
private Date polcWet;

/**
 * Sub-class Code.
 */
@Column(name = "POLC_SCL_CODE", precision = 22)
private Long polcSclCode;

/**
 * Lot ID.
 */
@Column(name = "POLC_LOT_ID", length = 20)
private String polcLotId;

/**
 * Prefix.
 */
@Column(name = "POLC_PREFIX", length = 15)
private String polcPrefix;

/**
 * Postfix.
 */
@Column(name = "POCL_POSTFIX", length = 15)
private String poclPostfix;

/**
 * Certificate Year.
 */
@Column(name = "POLC_CERT_YEAR", precision = 22)
private Long polcCertYear;

/**
 * Primary key for the table.
 */
@Id
@Column(name = "POLC_CODE", nullable = false, precision = 22)
private Long polcCode;

    /**
 * Client Policy Number.
 */
@Column(name = "POLC_CLIENT_POLICY_NO", nullable = false, length = 50)
private String polcClientPolicyNo;

/**
 * Certificate Type Short Description.
 */
@Column(name = "POLC_CT_SHT_DESC", length = 15)
private String polcCtShtDesc;

/**
 * Print Status.
 */
@Column(name = "POLC_PRINT_STATUS", length = 1)
private String polcPrintStatus;

/**
 * Check Certificate.
 */
@Column(name = "POLC_CHECK_CERT", length = 1)
private String polcCheckCert;

/**
 * Check Cancel.
 */
@Column(name = "POLC_CHECK_CANCEL", precision = 22)
private Long polcCheckCancel;

/**
 * Insured Property ID.
 */
@Column(name = "POLC_IPU_ID", nullable = false, precision = 22)
private Long polcIpuId;

/**
 * Client Code.
 */
@Column(name = "POLC_PRP_CODE", precision = 22)
private Long polcPrpCode;

/**
 * Cover Type Short Description.
 */
@Column(name = "POCL_COVT_SHT_DESC", length = 15)
private String poclCovtShtDesc;

/**
 * Agent Certificate Code.
 */
@Column(name = "POCL_AGC_CODE", precision = 15)
private Long poclAgcCode;

/**
 * Branch Code.
 */
@Column(name = "POLC_BRN_CODE", nullable = false, precision = 22)
private Long polcBrnCode;

/**
 * Indicates if the certificate is signed.
 */
@Column(name = "POLC_SIGNED", length = 3)
private String polcSigned;

/**
 * User who signed the certificate.
 */
@Column(name = "POLC_SIGNED_BY", length = 25)
private String polcSignedBy;

/**
 * Date the certificate was signed.
 */
@Column(name = "POLC_SIGNED_DATE")
private Date polcSignedDate;

/**
 * Date the certificate was returned.
 */
@Column(name = "POLC_RETURN_DATE")
private Date polcReturnDate;

/**
 * User who prepared the certificate return.
 */
@Column(name = "POLC_RETURN_PREP_BY", length = 30)
private String polcReturnPrepBy;

/**
 * Remarks related to the certificate return.
 */
@Column(name = "POLC_RETURN_REMARKS", length = 100)
private String polcReturnRemarks;

/**
 * Indicates if the certificate was returned.
 */
@Column(name = "POLC_RETURNED", length = 3)
private String polcReturned;

/**
 * Tonnage provision for motor commercial vehicles.
 */
@Column(name = "POLC_TONNAGE", precision = 8)
private Long polcTonnage;

/**
 * Passenger number for PSV vehicles.
 */
@Column(name = "POLC_PASSENGER_NO", precision = 8)
private Long polcPassengerNo;

/**
 * User who allocated the certificate.
 */
@Column(name = "POLC_ALLOC_BY", length = 30)
private String polcAllocBy;

/**
 * Agent Certificate Code.
 */
@Column(name = "POLC_AGC_CODE", precision = 22)
private Long polcAgcCode;

   /**
 * Indicates if the certificate type should be shown.
 */
@Column(name = "POLC_SHOW_CT", length = 1)
private String polcShowCt;

/**
 * Indicates if the certificate is related to CONOIL.
 */
@Column(name = "POLC_CONOIL", length = 1)
private String polcConoil;

/**
 * User who canceled the certificate.
 */
@Column(name = "POLC_CANCELLED_BY", length = 50)
private String polcCancelledBy;

/**
 * Indicates if the certificate was loaded.
 */
@Column(name = "POLC_LOADED", length = 1)
private String polcLoaded;

/**
 * Endorsement Difference Amount.
 */
@Column(name = "POLC_ENDOS_DIFF_AMT", precision = 27, scale = 5)
private BigDecimal polcEndosDiffAmt;
}