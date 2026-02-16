package com.turnquest.setupsdemo.model;

import lombok.Data;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity representing the GIN_POL_RISK_SECTION_PERILS table.
 * Stores information about perils associated with specific sections, subclasses, and policies.
 */
@Entity
@Table(name = "GIN_POL_RISK_SECTION_PERILS")
@Data
public class GinPolRiskSectionPerils {

    /**
     * Primary key for the peril record.
     */
    @Id
    @Column(name = "PRSPR_CODE", nullable = false, precision = 22)
    private BigDecimal prsprCode;

    /**
     * Foreign key from GIN_POLICIES, representing the policy batch number.
     */
    @Column(name = "PRSPR_POL_BATCH_NO", nullable = false, precision = 22)
    private BigDecimal prsprPolBatchNo;

    /**
     * Foreign key from GIN_INSURED_PROEPRTY_UNDS, representing the IPU code.
     */
    @Column(name = "PRSPR_IPU_CODE", nullable = false, precision = 22)
    private BigDecimal prsprIpuCode;

    /**
     * Foreign key from GIN_SUB_CLASSES, representing the subclass code.
     */
    @Column(name = "PRSPR_SCL_CODE", nullable = false, precision = 22)
    private BigDecimal prsprSclCode;

    /**
     * Foreign key from GIN_SECTIONS, representing the section code.
     */
    @Column(name = "PRSPR_SECT_CODE", nullable = false, precision = 22)
    private BigDecimal prsprSectCode;

    /**
     * Short description of the section.
     */
    @Column(name = "PRSPR_SECT_SHT_DESC", length = 15)
    private String prsprSectShtDesc;

    /**
     * Foreign key from GIN_PERILS, representing the peril code.
     */
    @Column(name = "PRSPR_PER_CODE", nullable = false, precision = 22)
    private BigDecimal prsprPerCode;

    /**
     * Short description of the peril.
     */
    @Column(name = "PRSPR_PER_SHT_DESC", length = 15)
    private String prsprPerShtDesc;

    /**
     * Indicates whether the peril is mandatory (Y/N).
     */
    @Column(name = "PRSPR_MANDATORY", length = 1)
    private String prsprMandatory;

    /**
     * Peril limit.
     */
    @Column(name = "PRSPR_PERIL_LIMIT", precision = 22, scale = 5)
    private BigDecimal prsprPerilLimit;

    /**
     * Peril payment type (SL = Sum Insured, TP = Third Party, BO = Both).
     */
    @Column(name = "PRSPR_PERIL_TYPE", nullable = false, length = 2)
    private String prsprPerilType;

    /**
     * Determines how the peril limit is calculated (SI = Sum Insured, SL = Section Limit, PL = Peril Limit, UN = Unlimited).
     */
    @Column(name = "PRSPR_SI_OR_LIMIT", length = 2)
    private String prsprSiOrLimit;

    /**
     * Section code.
     */
    @Column(name = "PRSPR_SEC_CODE", nullable = false, precision = 22)
    private BigDecimal prsprSecCode;

    /**
     * Excess type (P = Percentage, A = Amount, T = Table).
     */
    @Column(name = "PRSPR_EXCESS_TYPE", nullable = false, length = 1)
    private String prsprExcessType;

    /**
     * Excess value.
     */
    @Column(name = "PRSPR_EXCESS", precision = 22, scale = 5)
    private BigDecimal prsprExcess;

    /**
     * Minimum excess value.
     */
    @Column(name = "PRSPR_EXCESS_MIN", precision = 22, scale = 5)
    private BigDecimal prsprExcessMin;

    /**
     * Maximum excess value.
     */
    @Column(name = "PRSPR_EXCESS_MAX", precision = 22, scale = 5)
    private BigDecimal prsprExcessMax;

    /**
     * Indicates whether the cover expires upon claiming on this peril (Y/N).
     */
    @Column(name = "PRSPR_EXPIRE_ON_CLAIM", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String prsprExpireOnClaim;

    /**
     * Foreign key from GIN_BINDERS, representing the binder code.
     */
    @Column(name = "PRSPR_BIND_CODE", precision = 22)
    private BigDecimal prsprBindCode;

    /**
     * Person limit.
     */
    @Column(name = "PRSPR_PERSON_LIMIT", precision = 22, scale = 5)
    private BigDecimal prsprPersonLimit;

    /**
     * Claim limit.
     */
    @Column(name = "PRSPR_CLAIM_LIMIT", precision = 22, scale = 5)
    private BigDecimal prsprClaimLimit;

    /**
     * Peril description.
     */
    @Column(name = "PRSPR_DESC", length = 250)
    private String prsprDesc;

    /**
     * Binder type.
     */
    @Column(name = "PRSPR_BIND_TYPE", length = 1)
    private String prsprBindType;

    /**
     * Foreign key from GIN_SUBCL_SCTION_PERILS, representing the subclass section peril code.
     */
    @Column(name = "PRSPR_SSPR_CODE", precision = 22)
    private BigDecimal prsprSsprCode;

    /**
     * Depreciation percentage.
     */
    @Column(name = "PRSPR_DEPRECIATION_PCT", precision = 23, scale = 5)
    private BigDecimal prsprDepreciationPct;

    /**
     * Salvage percentage.
     */
    @Column(name = "PRSPR_SALVAGE_PCT", precision = 23, scale = 5)
    private BigDecimal prsprSalvagePct;

    /**
     * Claim excess type (P = Percentage, A = Amount, T = Table).
     */
    @Column(name = "PRSPR_CLAIM_EXCESS_TYPE", length = 1, columnDefinition = "VARCHAR2(1) default 'P'")
    private String prsprClaimExcessType;

    /**
     * Total loss excess type (P = Percentage, A = Amount, T = Table).
     */
    @Column(name = "PRSPR_TL_EXCESS_TYPE", length = 1)
    private String prsprTlExcessType;

    /**
     * Total loss excess value.
     */
    @Column(name = "PRSPR_TL_EXCESS", precision = 23, scale = 5)
    private BigDecimal prsprTlExcess;

    /**
     * Minimum total loss excess value.
     */
    @Column(name = "PRSPR_TL_EXCESS_MIN", precision = 23, scale = 5)
    private BigDecimal prsprTlExcessMin;

    /**
     * Maximum total loss excess value.
     */
    @Column(name = "PRSPR_TL_EXCESS_MAX", precision = 23, scale = 5)
    private BigDecimal prsprTlExcessMax;

    /**
     * Partial loss excess type (P = Percentage, A = Amount, T = Table).
     */
    @Column(name = "PRSPR_PL_EXCESS_TYPE", length = 1)
    private String prsprPlExcessType;

    /**
     * Partial loss excess value.
     */
    @Column(name = "PRSPR_PL_EXCESS", precision = 23, scale = 5)
    private BigDecimal prsprPlExcess;

    /**
     * Minimum partial loss excess value.
     */
    @Column(name = "PRSPR_PL_EXCESS_MIN", precision = 23, scale = 5)
    private BigDecimal prsprPlExcessMin;

    /**
     * Maximum partial loss excess value.
     */
    @Column(name = "PRSPR_PL_EXCESS_MAX", precision = 23, scale = 5)
    private BigDecimal prsprPlExcessMax;

    /**
     * Minimum claim excess value.
     */
    @Column(name = "PRSPR_CLAIM_EXCESS_MIN", precision = 23, scale = 5)
    private BigDecimal prsprClaimExcessMin;

    /**
     * Maximum claim excess value.
     */
    @Column(name = "PRSPR_CLAIM_EXCESS_MAX", precision = 23, scale = 5)
    private BigDecimal prsprClaimExcessMax;

    /**
     * Indicates whether the excess depends on the type of loss (Y/N).
     */
    @Column(name = "PRSPR_DEPEND_LOSS_TYPE", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String prsprDependLossType;

    /**
     * Benefit percentages per period setup (e.g., [PRD:%] =[6:100][5:50]).
     */
    @Column(name = "PRSPR_TTD_BEN_PCTS", length = 50)
    private String prsprTtdBenPcts;

    /**
     * Foreign key from GIN_SUBCL_SCTION_PERILS_MAP, representing the subclass section peril map code.
     */
    @Column(name = "PRSPR_SSPRM_CODE", precision = 22)
    private BigDecimal prsprSsprmCode;

    /**
     * Premium rate.
     */
    @Column(name = "PRSPR_PREM_RATE", precision = 23, scale = 4)
    private BigDecimal prsprPremRate;

    /**
     * Premium amount.
     */
    @Column(name = "PRSPR_PREMIUM_AMT", precision = 23, scale = 4)
    private BigDecimal prsprPremiumAmt;

    /**
     * PIL code.
     */
    @Column(name = "PRSPR_PIL_CODE", precision = 22)
    private BigDecimal prsprPilCode;

    /**
     * Annual premium.
     */
    @Column(name = "PRSPR_ANNUAL_PREMIUM", precision = 23, scale = 4)
    private BigDecimal prsprAnnualPremium;

    /**
     * Premium prorata.
     */
    @Column(name = "PRSPR_PREM_PRORATA", precision = 23, scale = 4)
    private BigDecimal prsprPremProrata;

    /**
     * Actual rate premium.
     */
    @Column(name = "PRSPR_ACTUAL_RATE_PREM", precision = 23, scale = 4)
    private BigDecimal prsprActualRatePrem;

    /**
     * Rate division factor.
     */
    @Column(name = "PRSPR_RATE_DIV_FACT", precision = 23, scale = 4)
    private BigDecimal prsprRateDivFact;

    /**
     * Free limit amount.
     */
    @Column(name = "PRSPR_FREE_LIMIT_AMT", precision = 23, scale = 4)
    private BigDecimal prsprFreeLimitAmt;

    /**
     * Prorata full.
     */
    @Column(name = "PRSPR_PRORATA_FULL", length = 1)
    private String prsprProrataFull;

    /**
     * Minimum premium.
     */
    @Column(name = "PRSPR_MIN_PREMIUM", precision = 23, scale = 4)
    private BigDecimal prsprMinPremium;

    /**
     * Multiplier rate.
     */
    @Column(name = "PRSPR_MULTIPLIER_RATE", precision = 23, scale = 4)
    private BigDecimal prsprMultiplierRate;

    /**
     * Multiplier division factor.
     */
    @Column(name = "PRSPR_MULTIPLIER_DIV_FACTOR", precision = 23, scale = 4)
    private BigDecimal prsprMultiplierDivFactor;

    /**
     * Computation type.
     */
    @Column(name = "PRSPR_COMPUTATION_TYPE", length = 10)
    private String prsprComputationType;

    /**
     * Claim excess.
     */
    @Column(name = "PRSPR_CLAIM_EXCESS", precision = 22)
    private BigDecimal prsprClaimExcess;
}