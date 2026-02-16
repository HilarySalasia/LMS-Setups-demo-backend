package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This table stores the claim perils.
 */
@Entity
@Table(name = "GIN_CLAIM_PERILS")
@Data
public class GinClaimPerils {
    /**
 * Primary key for the table
 */
@Id
@Column(name = "CLMP_CODE", nullable = false, precision = 22)
private Long clmpCode;

/**
 * Foreign key referencing the claim master booking
 */
@Column(name = "CLMP_CMB_CLAIM_NO", nullable = false, length = 40)
private String clmpCmbClaimNo;

/**
 * Foreign key referencing the peril type
 */
@Column(name = "CLMP_PER_PT_CODE", nullable = false, precision = 22)
private Long clmpPerPtCode;

/**
 * Short description of the peril type
 */
@Column(name = "CLMP_PER_PT_SHT_DESC", nullable = false, length = 50)
private String clmpPerPtShtDesc;

/**
 * Type of claim peril
 */
@Column(name = "CLMP_TYPE", nullable = false, length = 3)
private String clmpType;

/**
 * Limit amount of the claim peril
 */
@Column(name = "CLMP_LIMIT_AMT", precision = 23, scale = 5)
private BigDecimal clmpLimitAmt;

/**
 * Excess amount of the claim peril
 */
@Column(name = "CLMP_EXCESS_AMT", precision = 23, scale = 5)
private BigDecimal clmpExcessAmt;

/**
 * Reserve amount of the claim peril
 */
@Column(name = "CLMP_RESERVE_AMT", precision = 23, scale = 5)
private BigDecimal clmpReserveAmt;

/**
 * Remarks associated with the claim peril
 */
@Column(name = "CLMP_REMARKS", length = 200)
private String clmpRemarks;

/**
 * User who created the claim peril
 */
@Column(name = "CLMP_BY", nullable = false, length = 30)
private String clmpBy;

/**
 * Transaction number associated with the claim peril
 */
@Column(name = "CLMP_GGT_TRANS_NO", precision = 22)
private Long clmpGgtTransNo;

/**
 * Type of transaction associated with the claim peril
 */
@Column(name = "CLMP_TRAN_TYPE", length = 4)
private String clmpTranType;

/**
 * Change amount of the claim peril
 */
@Column(name = "CLMP_CHANGE_AMT", precision = 23, scale = 5)
private BigDecimal clmpChangeAmt;

/**
 * Indicates if the claim peril is authorized
 */
@Column(name = "CLMP_AUTHORISED", length = 1)
private String clmpAuthorised;

/**
 * Date of authorization
 */
@Column(name = "CLMP_DATE_AUTHORISED")
private Date clmpDateAuthorised;

/**
 * User who authorized the claim peril
 */
@Column(name = "CLMP_AUTHORISED_BY", length = 30)
private String clmpAuthorisedBy;

/**
 * Description of the claim peril
 */
@Column(name = "CLMP_PER_DESC", length = 150)
private String clmpPerDesc;

/**
 * Total reserve amount
 */
@Column(name = "CLMP_TOTAL_RESERVE", precision = 23, scale = 5)
private BigDecimal clmpTotalReserve;

/**
 * Total change amount
 */
@Column(name = "CLMP_TOTAL_CHANGE", precision = 23, scale = 5)
private BigDecimal clmpTotalChange;

/**
 * Level of the claim peril
 */
@Column(name = "CLMP_PERIL_LVL", length = 1)
private String clmpPerilLvl;

/**
 * Code for the claim peril
 */
@Column(name = "CLMP_PERIL_CODE", precision = 22)
private Long clmpPerilCode;

    /**
 * Indicates if the claim peril expires on claim
 */
@Column(name = "CLMP_EXPIRE_ON_CLAIM", length = 1)
private String clmpExpireOnClaim;

/**
 * Penalty amount of the claim peril
 */
@Column(name = "CLMP_PENALTY_AMT", precision = 23, scale = 2)
private BigDecimal clmpPenaltyAmt;

/**
 * Multi rate associated with the claim peril
 */
@Column(name = "CLMP_MULTI_RATE", precision = 23, scale = 5)
private BigDecimal clmpMultiRate;

/**
 * Deprprd rate associated with the claim peril
 */
@Column(name = "CLMP_DEPRPRD_RATE", precision = 23, scale = 5)
private BigDecimal clmpDeprprdRate;

/**
 * Indicates if the penalty applies to the claim peril
 */
@Column(name = "CLMP_PENALTY_APPL", length = 1)
private String clmpPenaltyAppl;

/**
 * Original reserve amount of the claim peril
 */
@Column(name = "CLMP_ORIG_RESERVE_AMT", precision = 22, scale = 5)
private BigDecimal clmpOrigReserveAmt;

/**
 * Adjusted amount of the claim peril
 */
@Column(name = "CLMP_ADJ_AMT", precision = 23, scale = 5)
private BigDecimal clmpAdjAmt;

/**
 * Claim amount of the claim peril
 */
@Column(name = "CLMP_CLAIM_AMT", precision = 23, scale = 5)
private BigDecimal clmpClaimAmt;

/**
 * Depreciation amount of the claim peril
 */
@Column(name = "CLMP_DEPR_AMT", precision = 23, scale = 5)
private BigDecimal clmpDeprAmt;

/**
 * Indicates if the claim peril is overridden
 */
@Column(name = "CLMP_OVERRIDE", nullable = false, length = 1)
private String clmpOverride;

/**
 * Code referencing the special premium
 */
@Column(name = "CLMP_SSPRM_CODE", precision = 22)
private Long clmpSsprmCode;

/**
 * Indicates if the claim peril is claimant-related
 */
@Column(name = "CLMP_CLAIMANT", length = 1)
private String clmpClaimant;

/**
 * Foreign key referencing the registered claimant
 */
@Column(name = "CLMP_REG_CLMT_CODE", precision = 22)
private Long clmpRegClmtCode;

/**
 * Foreign key referencing the appointed correspondent
 */
@Column(name = "CLMP_APCO_CODE", precision = 22)
private Long clmpApcoCode;

/**
 * Code referencing the registered client
 */
@Column(name = "CLMP_REG_CLD_CODE", precision = 22)
private Long clmpRegCldCode;

/**
 * Transmittall number associated with the claim peril
 */
@Column(name = "CLMP_TRANSMITTAL_NO", length = 20)
private String clmpTransmittallNo;

/**
 * Novice excess amount of the claim peril
 */
@Column(name = "CLMP_NOVICE_EXCESS_AMT", precision = 23, scale = 5)
private BigDecimal clmpNoviceExcessAmt;

/**
 * Indicates if liability is admitted for the claim peril
 */
@Column(name = "CLMP_LIAB_ADMISSION", nullable = false, length = 1)
private String clmpLiabAdmission;

/**
 * Date of liability admission
 */
@Column(name = "CLMP_LIAB_DATE")
private Date clmpLiabDate;

/**
 * Code for the main peril associated with the claim peril
 */
@Column(name = "CLMP_MAIN_PER_CODE", precision = 10)
private Long clmpMainPerCode;

/**
 * Rate associated with the claim peril
 */
@Column(name = "CLMP_PER_RATE", precision = 22)
private BigDecimal clmpPerRate;

/**
 * Description of the main peril associated with the claim peril
 */
@Column(name = "CLMP_MAIN_PER_DESC", length = 200)
private String clmpMainPerDesc;

/**
 * Short description of the main peril associated with the claim peril
 */
@Column(name = "CLMP_MAIN_PER_SHT_DESC", length = 100)
private String clmpMainPerShtDesc;

/**
 * Date the claim peril is closed
 */
@Column(name = "CLMP_CLOSE_DATE")
private Date clmpCloseDate;

/**
 * Status date of the claim peril
 */
@Column(name = "CLMP_STATUS_DATE")
private Date clmpStatusDate;

/**
 * Claim status associated with the claim peril
 */
@Column(name = "CLMP_CLAIM_STATUS", length = 1)
private String clmpClaimStatus;

/**
 * Indicates if liability is conditional for the claim peril
 */
@Column(name = "CLMP_LIAB_CONDITIONAL", nullable = false, length = 1)
private String clmpLiabConditional;

/**
 * Remarks associated with the claim peril
 */
@Column(name = "CLMP_RMKS", length = 200)
private String clmpRmks;

/**
 * Coinsurance commission rate associated with the claim peril
 */
@Column(name = "COIN_COMM_RATE", precision = 22, scale = 5)
private BigDecimal coinCommRate;

/**
 * Betterment rate associated with the claim peril
 */
@Column(name = "CLMP_BETTERMENT_RATE", length = 50)
private String clmpBettermentRate;

/**
 * Other charges associated with the claim peril
 */
@Column(name = "CLMP_OTHER_CHARGES", length = 50)
private String clmpOtherCharges;
}
