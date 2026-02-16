package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLAIM_PERIL_EXCESSES table.
 * Likely stores information about claim peril excesses, potentially used for calculating deductions or adjustments.
 */
@Entity
@Table(name = "GIN_CLAIM_PERIL_EXCESSES")
@Data
public class GinClaimPerilExcesses {

    /**
     * Primary key for the claim peril excess record.
     */
    @Id
    @Column(name = "CPE_CODE", nullable = false, precision = 22)
    private BigDecimal cpeCode;

    /**
     * Foreign key to the GIN_CLM_PAYMENT_VOUCHERS table, representing the claim payment code.
     */
    @Column(name = "CPE_CLMP_CODE", nullable = false, precision = 22)
    private BigDecimal cpeClmpCode;

    /**
     * Foreign key to the GIN_SUBCL_SCTION_PERILS table, representing the excess code.
     */
    @Column(name = "CPE_SSEX_CODE", precision = 22)
    private BigDecimal cpeSsexCode;

    /**
     * Excess type.
     */
    @Column(name = "CPE_EXCESS_TYPE", length = 100)
    private String cpeExcessType;

    /**
     * Excess limit.
     */
    @Column(name = "CPE_EXCESS_LIMIT", precision = 22)
    private BigDecimal cpeExcessLimit;

    /**
     * Excess rate.
     */
    @Column(name = "CPE_EXCESS_RATE", precision = 22)
    private BigDecimal cpeExcessRate;

    /**
     * Excess amount.
     */
    @Column(name = "CPE_EXCESS_AMT", precision = 22)
    private BigDecimal cpeExcessAmt;

    /**
     * Claim excess.
     */
    @Column(name = "CPE_CLAIM_EXCESS", precision = 22)
    private BigDecimal cpeClaimExcess;

    /**
     * Excess change amount.
     */
    @Column(name = "CPE_EXCESS_CHANGE_AMT", precision = 22)
    private BigDecimal cpeExcessChangeAmt;

    /**
     * Claim excess change amount.
     */
    @Column(name = "CPE_CLAIM_EXCESS_CHANGE_AMT", precision = 22)
    private BigDecimal cpeClaimExcessChangeAmt;
}