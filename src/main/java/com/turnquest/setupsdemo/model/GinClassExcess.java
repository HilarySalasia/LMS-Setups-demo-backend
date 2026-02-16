package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLASS_EXCESS table.
 * Likely stores information about excesses applied to classes.
 */
@Entity
@Table(name = "GIN_CLASS_EXCESS")
@Data
public class GinClassExcess {

    /**
     * Primary key for the class excess record.
     */
    @Id
    @Column(name = "CEX_CODE", nullable = false, precision = 22)
    private BigDecimal cexCode;

    /**
     * Description of the excess.
     */
    @Column(name = "CEX_DESC", nullable = false, length = 50)
    private String cexDesc;

    /**
     * Foreign key from GIN_CLASSES, representing the class code.
     */
    @Column(name = "CEX_CLA_CODE", nullable = false, precision = 22)
    private BigDecimal cexClaCode;

    /**
     * Indicates whether the excess depends on the type of loss (Y/N).
     */
    @Column(name = "CEX_DEPEND_LOSS_TYPE", nullable = false, length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String cexDependLossType;

    /**
     * Total loss excess rate type.
     */
    @Column(name = "CEX_TL_EXCESS_RATE_TYPE", length = 1)
    private String cexTlExcessRateType;

    /**
     * Total loss excess rate.
     */
    @Column(name = "CEX_TL_EXCESS_RATE", precision = 22, scale = 5)
    private BigDecimal cexTlExcessRate;

    /**
     * Minimum total loss excess.
     */
    @Column(name = "CEX_TL_EXCESS_MIN", precision = 22, scale = 5)
    private BigDecimal cexTlExcessMin;

    /**
     * Maximum total loss excess.
     */
    @Column(name = "CEX_TL_EXCESS_MAX", precision = 22, scale = 5)
    private BigDecimal cexTlExcessMax;

    /**
     * Total loss claim excess rate type.
     */
    @Column(name = "CEX_TL_CLAIM_EX_RATE_TYPE", length = 1, columnDefinition = "VARCHAR2(1) default 'P'")
    private String cexTlClaimExRateType;

    /**
     * Total loss claim excess rate.
     */
    @Column(name = "CEX_TL_CLAIM_EX_RATE", precision = 23, scale = 5)
    private BigDecimal cexTlClaimExRate;

    /**
     * Minimum total loss claim excess.
     */
    @Column(name = "CEX_TL_CLAIM_EX_MIN", precision = 23, scale = 5)
    private BigDecimal cexTlClaimExMin;

    /**
     * Maximum total loss claim excess.
     */
    @Column(name = "CEX_TL_CLAIM_EX_MAX", precision = 23, scale = 5)
    private BigDecimal cexTlClaimExMax;

    /**
     * Partial loss excess rate type.
     */
    @Column(name = "CEX_PL_EXCESS_RATE_TYPE", length = 1)
    private String cexPlExcessRateType;

    /**
     * Partial loss excess rate.
     */
    @Column(name = "CEX_PL_EXCESS_RATE", precision = 22, scale = 5)
    private BigDecimal cexPlExcessRate;

    /**
     * Minimum partial loss excess.
     */
    @Column(name = "CEX_PL_EXCESS_MIN", precision = 22, scale = 5)
    private BigDecimal cexPlExcessMin;

    /**
     * Maximum partial loss excess.
     */
    @Column(name = "CEX_PL_EXCESS_MAX", precision = 22, scale = 5)
    private BigDecimal cexPlExcessMax;

    /**
     * Partial loss claim excess rate type.
     */
    @Column(name = "CEX_PL_CLAIM_EX_RATE_TYPE", length = 1, columnDefinition = "VARCHAR2(1) default 'P'")
    private String cexPlClaimExRateType;

    /**
     * Partial loss claim excess rate.
     */
    @Column(name = "CEX_PL_CLAIM_EX_RATE", precision = 23, scale = 5)
    private BigDecimal cexPlClaimExRate;

    /**
     * Minimum partial loss claim excess.
     */
    @Column(name = "CEX_PL_CLAIM_EX_MIN", precision = 23, scale = 5)
    private BigDecimal cexPlClaimExMin;

    /**
     * Maximum partial loss claim excess.
     */
    @Column(name = "CEX_PL_CLAIM_EX_MAX", precision = 23, scale = 5)
    private BigDecimal cexPlClaimExMax;

    /**
     * Conditions related to the excess.
     */
    @Column(name = "CEX_CONDITIONS", length = 500)
    private String cexConditions;

    /**
     * Excess computation type (SI = Sum Insured, SL = Section Limit).
     */
    @Column(name = "CEX_COMPUTATION_TYPE", length = 2, columnDefinition = "VARCHAR2(2) default 'SI'")
    private String cexComputationType;

    /**
     * Effective date for the excess.
     */
    @Column(name = "CEX_WEF")
    private LocalDate cexWef;

    /**
     * Wet date for the excess.
     */
    @Column(name = "CEX_WET")
    private LocalDate cexWet;

    /**
     * Version.
     */
    @Column(name = "CEX_VERSION", precision = 22)
    private BigDecimal cexVersion;
}