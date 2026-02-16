package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_SUBCL_SCTION_EXCESS table.
 * Likely stores information about excesses applied to perils within specific sections and subclasses.
 */
@Entity
@Table(name = "GIN_SUBCL_SCTION_EXCESS")
@Data
public class GinSubclSctionExcess {

    /**
     * Primary key for the excess record.
     */
    @Id
    @Column(name = "SSEX_CODE", nullable = false, precision = 22)
    private BigDecimal ssexCode;

    /**
     * Description of the excess.
     */
    @Column(name = "SSEX_DESC", nullable = false, length = 50)
    private String ssexDesc;

    /**
     * Foreign key from GIN_SUB_CLASSES, representing the subclass code.
     */
    @Column(name = "SSEX_SCL_CODE", nullable = false, precision = 22)
    private BigDecimal ssexSclCode;

    /**
     * Foreign key from GIN_SECTIONS, representing the section code.
     */
    @Column(name = "SSEX_SECT_CODE", nullable = false, precision = 22)
    private BigDecimal ssexSectCode;

    /**
     * Foreign key from GIN_BINDERS, representing the binder code.
     */
    @Column(name = "SSEX_BIND_CODE", nullable = false, precision = 22)
    private BigDecimal ssexBindCode;

    /**
     * Binder type.
     */
    @Column(name = "SSEX_BIND_TYPE", length = 1)
    private String ssexBindType;

    /**
     * Short description of the section.
     */
    @Column(name = "SSEX_SECT_SHT_DESC", length = 60)
    private String ssexSectShtDesc;

    /**
     * Indicates whether the excess depends on the type of loss (Y/N).
     */
    @Column(name = "SSEX_DEPEND_LOSS_TYPE", nullable = false, length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String ssexDependLossType;

    /**
     * Total loss excess rate type.
     */
    @Column(name = "SSEX_TL_EXCESS_RATE_TYPE", length = 1)
    private String ssexTlExcessRateType;

    /**
     * Total loss excess rate.
     */
    @Column(name = "SSEX_TL_EXCESS_RATE", precision = 22, scale = 5)
    private BigDecimal ssexTlExcessRate;

    /**
     * Minimum total loss excess.
     */
    @Column(name = "SSEX_TL_EXCESS_MIN", precision = 22, scale = 5)
    private BigDecimal ssexTlExcessMin;

    /**
     * Maximum total loss excess.
     */
    @Column(name = "SSEX_TL_EXCESS_MAX", precision = 22, scale = 5)
    private BigDecimal ssexTlExcessMax;

    /**
     * Total loss claim excess rate type.
     */
    @Column(name = "SSEX_TL_CLAIM_EX_RATE_TYPE", length = 1, columnDefinition = "VARCHAR2(1) default 'P'")
    private String ssexTlClaimExRateType;

    /**
     * Total loss claim excess rate.
     */
    @Column(name = "SSEX_TL_CLAIM_EX_RATE", precision = 23, scale = 5)
    private BigDecimal ssexTlClaimExRate;

    /**
     * Minimum total loss claim excess.
     */
    @Column(name = "SSEX_TL_CLAIM_EX_MIN", precision = 23, scale = 5)
    private BigDecimal ssexTlClaimExMin;

    /**
     * Maximum total loss claim excess.
     */
    @Column(name = "SSEX_TL_CLAIM_EX_MAX", precision = 23, scale = 5)
    private BigDecimal ssexTlClaimExMax;

    /**
     * Partial loss excess rate type.
     */
    @Column(name = "SSEX_PL_EXCESS_RATE_TYPE", length = 1)
    private String ssexPlExcessRateType;

    /**
     * Partial loss excess rate.
     */
    @Column(name = "SSEX_PL_EXCESS_RATE", precision = 22, scale = 5)
    private BigDecimal ssexPlExcessRate;

    /**
     * Minimum partial loss excess.
     */
    @Column(name = "SSEX_PL_EXCESS_MIN", precision = 22, scale = 5)
    private BigDecimal ssexPlExcessMin;

    /**
     * Maximum partial loss excess.
     */
    @Column(name = "SSEX_PL_EXCESS_MAX", precision = 22, scale = 5)
    private BigDecimal ssexPlExcessMax;

    /**
     * Partial loss claim excess rate type.
     */
    @Column(name = "SSEX_PL_CLAIM_EX_RATE_TYPE", length = 1, columnDefinition = "VARCHAR2(1) default 'P'")
    private String ssexPlClaimExRateType;

    /**
     * Partial loss claim excess rate.
     */
    @Column(name = "SSEX_PL_CLAIM_EX_RATE", precision = 23, scale = 5)
    private BigDecimal ssexPlClaimExRate;

    /**
     * Minimum partial loss claim excess.
     */
    @Column(name = "SSEX_PL_CLAIM_EX_MIN", precision = 23, scale = 5)
    private BigDecimal ssexPlClaimExMin;

    /**
     * Maximum partial loss claim excess.
     */
    @Column(name = "SSEX_PL_CLAIM_EX_MAX", precision = 23, scale = 5)
    private BigDecimal ssexPlClaimExMax;

    /**
     * Conditions related to the excess.
     */
    @Column(name = "SSEX_CONDITIONS", length = 500)
    private String ssexConditions;

    /**
     * Excess computation type (SI = Sum Insured, SL = Section Limit).
     */
    @Column(name = "SSEX_COMPUTATION_TYPE", length = 2, columnDefinition = "VARCHAR2(2) default 'SI'")
    private String ssexComputationType;

    /**
     * Effective date for the excess.
     */
    @Column(name = "SSEX_WEF")
    private LocalDate ssexWef;

    /**
     * Wet date for the excess.
     */
    @Column(name = "SSEX_WET")
    private LocalDate ssexWet;
}