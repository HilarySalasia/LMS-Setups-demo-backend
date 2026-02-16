package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

/**
 * This table is used to store details of all transactions done in the system.
 */
@Entity
@Table(name = "GIN_GIS_TRANSACTIONS")
@Data
public class GinGisTransactions {
   /**
 * Unique transaction number
 */
@Id
@Column(name = "GGT_TRANS_NO", nullable = false, precision = 22)
private Long ggtTransNo;

/**
 * Document reference for the transaction
 */
@Column(name = "GGT_DOC_REF", length = 30)
private String ggtDocRef;

/**
 * Policy number associated with the transaction
 */
@Column(name = "GGT_POL_POLICY_NO", length = 50)
private String ggtPolPolicyNo;

/**
 * Claim number associated with the transaction
 */
@Column(name = "GGT_CMB_CLAIM_NO", length = 30)
private String ggtCmbClaimNo;

/**
 * Product code associated with the transaction
 */
@Column(name = "GGT_PRO_CODE", precision = 22)
private Long ggtProCode;

/**
 * Policy batch number associated with the transaction
 */
@Column(name = "GGT_POL_BATCH_NO", precision = 22)
private Long ggtPolBatchNo;

/**
 * Short description of the product
 */
@Column(name = "GGT_PRO_SHT_DESC", length = 15)
private String ggtProShtDesc;

/**
 * Transaction code used in the system
 */
@Column(name = "GGT_BTR_TRANS_CODE", length = 10)
private String ggtBtrTransCode;

/**
 * User who performed the transaction
 */
@Column(name = "GGT_DONE_BY", length = 30)
private String ggtDoneBy;

/**
 * Date the transaction was performed
 */
@Column(name = "GGT_DONE_DATE")
private Date ggtDoneDate;

/**
 * Client policy number associated with the transaction
 */
@Column(name = "GGT_CLIENT_POLICY_NUMBER", length = 50)
private String ggtClientPolicyNumber;

/**
 * Indicates if the transaction is related to underwriting or claims
 */
@Column(name = "GGT_UW_CLM_TRAN", nullable = false, length = 1)
private String ggtUwClmTran;

/**
 * Date of the transaction
 */
@Column(name = "GGT_TRANS_DATE", nullable = false)
private Date ggtTransDate;

/**
 * Indicates if the transaction is authorized
 */
@Column(name = "GGT_TRANS_AUTHORISED", length = 1)
private String ggtTransAuthorised;

/**
 * User who authorized the transaction
 */
@Column(name = "GGT_TRANS_AUTHORISED_BY", length = 50)
private String ggtTransAuthorisedBy;

    /**
 * Date of authorization
 */
@Column(name = "GGT_TRANS_AUTHORISE_DATE")
private Date ggtTransAuthoriseDate;

/**
 * Previous transaction number (if any)
 */
@Column(name = "GGT_OLD_TRAN_NO", precision = 22)
private Long ggtOldTranNo;

/**
 * Effective date of the transaction
 */
@Column(name = "GGT_EFFECTIVE_DATE")
private Date ggtEffectiveDate;

/**
 * Risk group code associated with the transaction
 */
@Column(name = "GGT_RISK_GRP_CODE", precision = 22)
private Long ggtRiskGrpCode;

/**
 * Status of the transaction (e.g., 'O' for open)
 */
@Column(name = "GGT_SCH_STATUS", length = 2)
private String ggtSchStatus;

/**
 * User who authorized the transaction status
 */
@Column(name = "GGT_SCH_AUTH_BY", length = 30)
private String ggtSchAuthBy;

/**
 * Date the transaction status was updated
 */
@Column(name = "GGT_SCH_STATUS_DT")
private Date ggtSchStatusDt;

/**
 * Indicates if the EDP (electronic data processing) has checked the transaction
 */
@Column(name = "GGT_EDP_CHECKED", length = 1)
private String ggtEdpChecked;

/**
 * User who checked the transaction
 */
@Column(name = "GGT_EDP_CHECKED_BY", length = 30)
private String ggtEdpCheckedBy;

/**
 * Date the transaction was checked
 */
@Column(name = "GGT_EDP_CHECK_DT")
private Date ggtEdpCheckDt;

/**
 * Reference to the transaction in other systems
 */
@Column(name = "GGT_OTHER_SYS_REF", length = 30)
private String ggtOtherSysRef;

/**
 * Code for the risk category
 */
@Column(name = "GGT_RCC_CODE", precision = 15)
private Long ggtRccCode;

/**
 * Code for the mail type
 */
@Column(name = "GGT_MAIL_CODE", precision = 15)
private Long ggtMailCode;

/**
 * Batch number associated with the transaction
 */
@Column(name = "GGT_EDP_BATCH_NO", length = 6)
private String ggtEdpBatchNo;

/**
 * Status of the transaction
 */
@Column(name = "GGT_STATUS", length = 25)
private String ggtStatus;

/**
 * Code for the income source
 */
@Column(name = "GGT_INCS_CODE", precision = 15)
private Long ggtIncsCode;

/**
 * Code for the XAS (an internal system)
 */
@Column(name = "GGT_XAS_CODE", precision = 22)
private Long ggtXasCode;

/**
 * User who canceled the policy
 */
@Column(name = "GGT_POL_CANC_BY", length = 25)
private String ggtPolCancBy;

/**
 * Reference number for the risk
 */
@Column(name = "GGT_RRC_RCT_NO", length = 23)
private String ggtRrcRctNo;

/**
 * Reference number for the claim
 */
@Column(name = "GGT_CLM_REF_NO", length = 30)
private String ggtClmRefNo;

/**
 * Reason for reinsurance edit
 */
@Column(name = "GGT_REIN_EDT_REASON", length = 100)
private String ggtReinEdtReason;
}