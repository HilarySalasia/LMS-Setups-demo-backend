package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_VOUCHER_DETAILS table.
 * Stores details of payments associated with vouchers.
 */
@Entity
@Table(name = "GIN_VOUCHER_DETAILS")
@Data
public class GinVoucherDetails {

    /**
     * Foreign key from GIN_CLM_PAYMENT_VOUCHERS, representing the voucher number.
     */
    @Column(name = "VOUD_CPV_VOUCHER_NO", nullable = false, precision = 22)
    private BigDecimal voudCpvVoucherNo;

    /**
     * Peril code.
     */
    @Column(name = "VOUD_PER_CODE", nullable = false, precision = 22)
    private BigDecimal voudPerCode;

    /**
     * Foreign key from GIN_RGSTD_CLAIMANTS, representing the registered claimant code.
     */
    @Column(name = "VOUD_REG_CLMT_CODE", precision = 22)
    private BigDecimal voudRegClmtCode;

    /**
     * Payment amount.
     */
    @Column(name = "VOUD_AMT", nullable = false, precision = 23, scale = 5)
    private BigDecimal voudAmt;

    /**
     * Short description of the peril payment.
     */
    @Column(name = "VOUD_PER_PT_SHT_DESC", length = 20)
    private String voudPerPtShtDesc;

    /**
     * Peril type (P = Primary, S = Secondary).
     */
    @Column(name = "VOUD_TYPE", length = 3, columnDefinition = "VARCHAR2(3) default 'P'")
    private String voudType;

    /**
     * Peril description.
     */
    @Column(name = "VOUD_PER_DESC", length = 60)
    private String voudPerDesc;

    /**
     * Claimant type.
     */
    @Column(name = "VOUD_CLAIMANT_TYPE", length = 1)
    private String voudClaimantType;

    /**
     * Claimant code.
     */
    @Column(name = "VOUD_REG_CLD_CODE", precision = 22)
    private BigDecimal voudRegCldCode;

    /**
     * Coinsurance total amount.
     */
    @Column(name = "VOUD_COIN_TOT_AMT", precision = 23, scale = 5)
    private BigDecimal voudCoinTotAmt;

    /**
     * Payment amount in base currency.
     */
    @Column(name = "VOUD_AMT_BCUR", precision = 23, scale = 5)
    private BigDecimal voudAmtBcur;

    /**
     * Coinsurance total amount in base currency.
     */
    @Column(name = "VOUD_COIN_TOT_AMT_BCUR", precision = 23, scale = 5)
    private BigDecimal voudCoinTotAmtBcur;

    /**
     * Reinsurance amount.
     */
    @Column(name = "VOUD_REIN_AMT", precision = 23, scale = 5)
    private BigDecimal voudReinAmt;

    /**
     * Indicates whether excess is allowed.
     */
    @Column(name = "VOUD_EXCESS_ALLOWED", length = 1)
    private String voudExcessAllowed;

    /**
     * Excess amount.
     */
    @Column(name = "VOUD_EXCESS_AMT", precision = 23, scale = 5)
    private BigDecimal voudExcessAmt;

    /**
     * Excess amount in base currency.
     */
    @Column(name = "VOUD_EXCESS_AMT_BCUR", precision = 23, scale = 5)
    private BigDecimal voudExcessAmtBcur;

    /**
     * Reinsurance amount in base currency.
     */
    @Column(name = "VOUD_REIN_AMT_BCUR", precision = 23, scale = 5)
    private BigDecimal voudReinAmtBcur;

    /**
     * Salvage amount.
     */
    @Column(name = "VOUD_SALV_AMT", precision = 23, scale = 5)
    private BigDecimal voudSalvAmt;

    /**
     * Salvage amount in base currency.
     */
    @Column(name = "VOUD_SALV_AMT_BCUR", precision = 23, scale = 5)
    private BigDecimal voudSalvAmtBcur;

    /**
     * Foreign key from GIN_CLAIM_PERILS, representing the claim peril code.
     */
    @Column(name = "VOUD_CLMP_CODE", nullable = false, precision = 22)
    private BigDecimal voudClmpCode;

    /**
     * Primary key for the voucher detail record.
     */
    @Id
    @Column(name = "VOUD_CODE", nullable = false, precision = 22)
    private BigDecimal voudCode;

    /**
     * Novice excess amount.
     */
    @Column(name = "VOUD_NOVICE_EXCESS_AMT", precision = 23, scale = 5)
    private BigDecimal voudNoviceExcessAmt;
}