package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This table stores details of revisions done for claims.
 */
@Entity
@Table(name = "GIN_CLAIM_REVISIONS")
@Data
public class GinClaimRevisions {
   /**
 * Primary Key. Unique revision code for each claim
 */
@Id
@Column(name = "CLMREV_CODE", nullable = false, precision = 22)
private Long clmrevCode;

/**
 * Revision date
 */
@Column(name = "CLMREV_DATE", nullable = false)
private Date clmrevDate;

/**
 * Foreign key from GIN_GIS_TRANSACTION. Used to store unique transaction number
 */
@Column(name = "CLMREV_GGT_TRANS_NO", nullable = false, precision = 22)
private Long clmrevGgtTransNo;

/**
 * Foreign Key from GIN_CLAIM_MASTER_BOOKINGS for claim number
 */
@Column(name = "CLMREV_CMB_CLAIM_NO", nullable = false, length = 40)
private String clmrevCmbClaimNo;

/**
 * Claim revision amount
 */
@Column(name = "CLMREV_AMT", nullable = false, precision = 23, scale = 5)
private BigDecimal clmrevAmt;

/**
 * Foreign Key from GIN_POLICIES for batch number
 */
@Column(name = "CLMREV_POL_BATCH_NO", nullable = false, precision = 22)
private Long clmrevPolBatchNo;

/**
 * Revision remarks
 */
@Column(name = "CLMREV_REMARKS", length = 100)
private String clmrevRemarks;

/**
 * Transaction type
 */
@Column(name = "CLMREV_GGT_TRAN_TYPE", nullable = false, length = 4)
private String clmrevGgtTranType;

/**
 * Foreign Key from GIN_ACCOUNTING_PERIODS for period
 */
@Column(name = "CLMREV_ACPR_CODE", precision = 22)
private Long clmrevAcprCode;

/**
 * Accounting period short description
 */
@Column(name = "CLMREV_ACPR_SHT_DESC", length = 20)
private String clmrevAcprShtDesc;

/**
 * Revision retention amount
 */
@Column(name = "CLMREV_COMP_RETENTION", precision = 22, scale = 5)
private BigDecimal clmrevCompRetention;

/**
 * Revision mandatory amount
 */
@Column(name = "CLMREV_MAN_AMOUNT", precision = 22, scale = 5)
private BigDecimal clmrevManAmount;

/**
 * Revision quota share amount
 */
@Column(name = "CLMREV_QUOTA_AMOUNT", precision = 22, scale = 5)
private BigDecimal clmrevQuotaAmount;

/**
 * Revision first setup premium premium premium
 */
@Column(name = "CLMREV_FSTSUP_AMOUNT", precision = 22, scale = 5)
private BigDecimal clmrevFstSupAmount;

/**
 * Revision second setup premium premium premium
 */
@Column(name = "CLMREV_SECSUP_AMOUNT", precision = 22, scale = 5)
private BigDecimal clmrevSecSupAmount;

/**
 * Revision Facultative reinsuarance amount
 */
@Column(name = "CLMREV_FACRE_AMOUNT", precision = 22, scale = 5)
private BigDecimal clmrevFacreAmount;

    /**
 * Revision coinsurance amount
 */
@Column(name = "CLMREV_COIN_AMT", precision = 30, scale = 5)
private BigDecimal clmrevCoinAmt;

/**
 * Base currency amount
 */
@Column(name = "CLMREV_AMT_BCUR", precision = 23, scale = 5)
private BigDecimal clmrevAmtBcur;

/**
 * Base currency mandatory amount
 */
@Column(name = "CLMREV_MAN_AMOUNT_BCUR", precision = 22, scale = 5)
private BigDecimal clmrevManAmountBcur;

/**
 * Base currency quota share amount
 */
@Column(name = "CLMREV_QUOTA_AMOUNT_BCUR", precision = 22, scale = 5)
private BigDecimal clmrevQuotaAmountBcur;

/**
 * Base currency first setup premium premium premium amount
 */
@Column(name = "CLMREV_FSTSUP_AMOUNT_BCUR", precision = 22, scale = 5)
private BigDecimal clmrevFstSupAmountBcur;

/**
 * Base currency second setup premium premium premium amount
 */
@Column(name = "CLMREV_SECSUP_AMOUNT_BCUR", precision = 22, scale = 5)
private BigDecimal clmrevSecSupAmountBcur;

/**
 * Base currency facultative reinsurance amount
 */
@Column(name = "CLMREV_FACRE_AMOUNT_BCUR", precision = 22, scale = 5)
private BigDecimal clmrevFacreAmountBcur;

/**
 * Base currency coinsurance amount
 */
@Column(name = "CLMREV_COIN_AMT_BCUR", precision = 30, scale = 5)
private BigDecimal clmrevCoinAmtBcur;

/**
 * Revision reserve amount
 */
@Column(name = "CLMREV_RESERVE", precision = 20, scale = 5)
private BigDecimal clmrevReserve;

/**
 * Base currency reserve amount
 */
@Column(name = "CLMREV_RESERVE_BCUR", precision = 20, scale = 5)
private BigDecimal clmrevReserveBcur;

/**
 * Its a flag indicating whether the revision is already authorised (Y)es or Not (N)
 */
@Column(name = "CLMREV_AUTHORISED", length = 1)
private String clmrevAuthorised;

/**
 * Date of the authorisation of the revision
 */
@Column(name = "CLMREV_DATE_AUTHORISED")
private Date clmrevDateAuthorised;

/**
 * User who authorised the revision
 */
@Column(name = "CLMREV_AUTHORISED_BY", length = 20)
private String clmrevAuthorisedBy;

/**
 * Foreign Key of TQC\_CURRENCIES that show the currency code
 */
@Column(name = "CLMREV_CUR_CODE", nullable = false, precision = 15)
private Long clmrevCurCode;

/**
 * Currency symbol
 */
@Column(name = "CLMREV_CUR_SYMBOL", length = 25)
private String clmrevCurSymbol;

/**
 * Currency exchange rate of the currency used
 */
@Column(name = "CLMREV_CUR_RATE", precision = 15, scale = 5)
private BigDecimal clmrevCurRate;

/**
 * Hfms Status
 */
@Column(name = "HFMS_STATUS", precision = 22)
private Long hfmsStatus;

/**
 * Hfms Upd Dt
 */
@Column(name = "HFMS_UPD_DT")
private Date hfmsUpdDt;

/**
 * Hfms Gau Id
 */
@Column(name = "HFMS_GAU_ID", precision = 22)
private Long hfmsGauId;

/**
 * Indicates if the transaction is related to Book of Business (BOC)
 */
@Column(name = "CLMREV_BOC_TRANS", nullable = false, length = 1)
private String clmrevBocTrans;

/**
 * Gross Revision amount
 */
@Column(name = "CLMREV_GROSS_AMT", precision = 23, scale = 2)
private BigDecimal clmrevGrossAmt;

/**
 * Gross coinsurance revision amount
 */
@Column(name = "CLMREV_GROSS_COIN_AMT", precision = 23, scale = 2)
private BigDecimal clmrevGrossCoinAmt;

/**
 * Revision reference number
 */
@Column(name = "CLMREV_CLM_REF_NO", length = 30)
private String clmrevClmRefNo;

    /**
 * Indicates if reinsurance pool is applicable
 */
@Column(name = "CLMREV_REIN_POOL_APPL", length = 1)
private String clmrevReinPoolAppl;

/**
 * Reinsurance pool rate
 */
@Column(name = "CLMREV_REIN_POOL_RATE", precision = 23, scale = 2)
private BigDecimal clmrevReinPoolRate;

/**
 * Reinsurance pool amount
 */
@Column(name = "CLMREV_REIN_POOL_AMT", precision = 23, scale = 2)
private BigDecimal clmrevReinPoolAmt;

/**
 * Reinsurance pool amount in base currency
 */
@Column(name = "CLMREV_REIN_POOL_BAMT", precision = 23, scale = 2)
private BigDecimal clmrevReinPoolBamt;

/**
 * Company retention gross reinsurance pool
 */
@Column(name = "CLMREV_RPOOL_COMP_RETEN", precision = 23, scale = 2)
private BigDecimal clmrevRpoolCompReten;

/**
 * Transaction code reference to GIN\_BUSINESS\_TRANSACTIONS
 */
@Column(name = "CLMREV_GGT_BTR_TRANS_CODE", length = 20)
private String clmrevGgtBtrTransCode;

/**
 * Facre obligatory revision amount
 */
@Column(name = "CLMREV_FACRE_OB_AMOUNT", precision = 23, scale = 5)
private BigDecimal clmrevFacreObAmount;

/**
 * Facre obligatory revision amount in base currency
 */
@Column(name = "CLMREV_FACRE_OB_AMOUNT_BCUR", precision = 23, scale = 5)
private BigDecimal clmrevFacreObAmountBcur;

/**
 * Company retention rate
 */
@Column(name = "CLMREV_COMP_RETENTION_RATE", precision = 23, scale = 5)
private BigDecimal clmrevCompRetentionRate;

/**
 * Excess of Loss (XOL) revision amount
 */
@Column(name = "CLMREV_XOL_AMOUNT", precision = 23, scale = 5)
private BigDecimal clmrevXolAmount;

/**
 * Excess of Loss (XOL) revision amount in base currency
 */
@Column(name = "CLMREV_XOL_AMOUNT_BCUR", precision = 23, scale = 5)
private BigDecimal clmrevXolAmountBcur;

/**
 * CF (an internal code)
 */
@Column(name = "CLMREV_CF", precision = 23, scale = 5)
private BigDecimal clmrevCf;

/**
 * Indicates if the XOL (Excess of Loss) is cleaned
 */
@Column(name = "XOL_CLEANED", nullable = false, length = 1)
private String xolCleaned;

/**
 * User who checked the revision
 */
@Column(name = "CLMREV_CHECKED_BY", length = 50)
private String clmrevCheckedBy;

/**
 * Date the revision was checked
 */
@Column(name = "CLMREV_CHECKED_DATE")
private Date clmrevCheckedDate;

/**
 * User who created the revision
 */
@Column(name = "CLMREV_DONE_BY", length = 50)
private String clmrevDoneBy;

/**
 * Date the revision was created
 */
@Column(name = "CLMREV_DONE_DATE")
private Date clmrevDoneDate;
}