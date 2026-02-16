package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLAIM_RECOVERIES table.
 * Likely stores information about claim recoveries, potentially related to salvage, reinsurance, or other adjustments.
 */
@Entity
@Table(name = "GIN_CLAIM_RECOVERIES")
@Data
public class GinClaimRecoveries {

    /**
     * Primary key for the claim recovery record.
     */
    @Id
    @Column(name = "CLMR_CODE", nullable = false, precision = 22)
    private BigDecimal clmrCode;

    /**
     * Recovery type.
     */
    @Column(name = "CLMR_REC_TYPE", nullable = false, length = 1)
    private String clmrRecType;

    /**
     * Recovery amount.
     */
    @Column(name = "CLMR_AMOUNT", precision = 22, scale = 5)
    private BigDecimal clmrAmount;

    /**
     * Recovery date.
     */
    @Column(name = "CLMR_DATE", nullable = false)
    private LocalDate clmrDate;

    /**
     * Foreign Key from GIN_ACC_PERIODS for accounting period.
     */
    @Column(name = "CLMR_ACPR_CODE", precision = 22)
    private BigDecimal clmrAcprCode;

    /**
     * Accounting period short description.
     */
    @Column(name = "CLMR_ACPR_SHT_DESC", length = 15)
    private String clmrAcprShtDesc;

    /**
     * Foreign Key from GIN_CLAIM_MASTER_BOOKINGS for claim number.
     */
    @Column(name = "CLMR_CMB_CLAIM_NO", nullable = false, length = 25)
    private String clmrCmbClaimNo;

    /**
     * Transaction number.
     */
    @Column(name = "CLMR_GGT_TRANS_NO", nullable = false, precision = 22)
    private BigDecimal clmrGgtTransNo;

    /**
     * Transaction type.
     */
    @Column(name = "CLMR_TRAN_TYPE", nullable = false, length = 4)
    private String clmrTranType;

    /**
     * Change amount.
     */
    @Column(name = "CLMR_CHANGE_AMT", precision = 22, scale = 5)
    private BigDecimal clmrChangeAmt;

    /**
     * Indicates whether the recovery is authorized (Y/N).
     */
    @Column(name = "CLMR_AUTHORISED", length = 1)
    private String clmrAuthorised;

    /**
     * Date of authorization.
     */
    @Column(name = "CLMR_DATE_AUTHORISED")
    private LocalDate clmrDateAuthorised;

    /**
     * User who authorized the recovery.
     */
    @Column(name = "CLMR_AUTHORISED_BY", length = 30)
    private String clmrAuthorisedBy;

    /**
     * Recovery description.
     */
    @Column(name = "CLMR_RECOVERY_DESC", length = 60)
    private String clmrRecoveryDesc;

    /**
     * Salvage buyer.
     */
    @Column(name = "CLMR_SALVAGE_BUYER", length = 40)
    private String clmrSalvageBuyer;

    /**
     * Company retention amount.
     */
    @Column(name = "CLMR_COMP_RETENTION", precision = 22, scale = 5)
    private BigDecimal clmrCompRetention;

    /**
     * Mandatory amount.
     */
    @Column(name = "CLMR_MAN_AMOUNT", precision = 22, scale = 5)
    private BigDecimal clmrManAmount;

    /**
     * Quota share amount.
     */
    @Column(name = "CLMR_QUOTA_AMOUNT", precision = 22, scale = 5)
    private BigDecimal clmrQuotaAmount;

    /**
     * First setup premium amount.
     */
    @Column(name = "CLMR_FSTSUP_AMOUNT", precision = 22, scale = 5)
    private BigDecimal clmrFstSupAmount;

    /**
     * Second setup premium amount.
     */
    @Column(name = "CLMR_SECSUP_AMOUNT", precision = 22, scale = 5)
    private BigDecimal clmrSecSupAmount;

    /**
     * Facultative reinsurance amount.
     */
    @Column(name = "CLMR_FACRE_AMOUNT", precision = 22, scale = 5)
    private BigDecimal clmrFacreAmount;

    /**
     * Total recovery amount.
     */
    @Column(name = "CLMR_TOTAL_AMOUNT", precision = 22, scale = 5)
    private BigDecimal clmrTotalAmount;

    /**
     * Total change amount.
     */
    @Column(name = "CLMR_TOTAL_CHANGE", precision = 22, scale = 5)
    private BigDecimal clmrTotalChange;

    /**
     * Recovery amount in base currency.
     */
    @Column(name = "CLMR_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal clmrAmountBcur;

    /**
     * Company retention amount in base currency.
     */
    @Column(name = "CLMR_COMP_RETENTION_BCUR", precision = 22, scale = 5)
    private BigDecimal clmrCompRetentionBcur;

    /**
     * Mandatory amount in base currency.
     */
    @Column(name = "CLMR_MAN_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal clmrManAmountBcur;

    /**
     * Quota share amount in base currency.
     */
    @Column(name = "CLMR_QUOTA_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal clmrQuotaAmountBcur;

    /**
     * First setup premium amount in base currency.
     */
    @Column(name = "CLMR_FSTSUP_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal clmrFstSupAmountBcur;

    /**
     * Second setup premium amount in base currency.
     */
    @Column(name = "CLMR_SECSUP_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal clmrSecSupAmountBcur;

    /**
     * Facultative reinsurance amount in base currency.
     */
    @Column(name = "CLMR_FACRE_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal clmrFacreAmountBcur;

    /**
     * Total recovery amount in base currency.
     */
    @Column(name = "CLMR_TOTAL_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal clmrTotalAmountBcur;

    /**
     * Reserve amount.
     */
    @Column(name = "CLMR_RESERVE", precision = 20, scale = 5)
    private BigDecimal clmrReserve;

    /**
     * Reserve amount in base currency.
     */
    @Column(name = "CLMR_RESERVE_BCUR", precision = 20, scale = 5)
    private BigDecimal clmrReserveBcur;

    /**
     * Currency exchange rate.
     */
    @Column(name = "CLMR_CUR_RATE", precision = 10, scale = 5)
    private BigDecimal clmrCurRate;

    /**
     * Foreign Key of TQC_CURRENCIES that show the currency code.
     */
    @Column(name = "CLMR_CUR_CODE", nullable = false, precision = 22)
    private BigDecimal clmrCurCode;

    /**
     * Currency symbol.
     */
    @Column(name = "CLMR_CUR_SYMBOL", length = 25)
    private String clmrCurSymbol;

    /**
     * Business transaction code.
     */
    @Column(name = "CLMR_BTR_TRANS_CODE", nullable = false, length = 10)
    private String clmrBtrTransCode;

    /**
     * Engine number.
     */
    @Column(name = "CLMR_ENGINE_NO", length = 20)
    private String clmrEngineNo;

    /**
     * Chassis number.
     */
    @Column(name = "CLMR_CHASSIS_NO", length = 20)
    private String clmrChassisNo;

    /**
     * Log book number.
     */
    @Column(name = "CLMR_LOG_BOOK_NO", length = 20)
    private String clmrLogBookNo;

    /**
     * Access estimated value.
     */
    @Column(name = "CLMR_ACCESS_EST_VALUE", precision = 22, scale = 5)
    private BigDecimal clmrAccessEstValue;

    /**
     * Location.
     */
    @Column(name = "CLMR_LOCATION", length = 200)
    private String clmrLocation;

    /**
     * Business transaction code.
     */
    @Column(name = "CLMR_GGT_BTR_TRANS_CODE", length = 20)
    private String clmrGgtBtrTransCode;

    /**
     * RRC code.
     */
    @Column(name = "CLMR_RRC_CODE", precision = 22)
    private BigDecimal clmrRrcCode;

    /**
     * RRC receipt number.
     */
    @Column(name = "CLMR_RRC_RCT_NO", length = 15)
    private String clmrRrcRctNo;

    /**
     * Reinsurance pool amount.
     */
    @Column(name = "CLMR_POOL_AMOUNT", precision = 22)
    private BigDecimal clmrPoolAmount;

    /**
     * Facultative reinsurance amount.
     */
    @Column(name = "CLMR_FACRE_OB_AMOUNT", precision = 22)
    private BigDecimal clmrFacreObAmount;

    /**
     * Company retention rate.
     */
    @Column(name = "CLMR_COMP_RETENTION_RATE", precision = 22, scale = 5)
    private BigDecimal clmrCompRetentionRate;

    /**
     * Foreign key from GIN_RGSTD_CLAIMANTS, representing the registered claimant code.
     */
    @Column(name = "CLMR_REG_CLMT_CODE", precision = 22)
    private BigDecimal clmrRegClmtCode;

    /**
     * Facultative reinsurance amount in base currency.
     */
    @Column(name = "CLMR_FACRE_OB_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal clmrFacreObAmountBcur;

    /**
     * Reinsurance pool amount in base currency.
     */
    @Column(name = "CLMR_POOL_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal clmrPoolAmountBcur;

    /**
     * VAT amount.
     */
    @Column(name = "CLMR_VAT_AMT", precision = 22, scale = 5)
    private BigDecimal clmrVatAmt;

    /**
     * XOL amount.
     */
    @Column(name = "CLMR_XOL_AMOUNT", precision = 23, scale = 5)
    private BigDecimal clmrXolAmount;
}