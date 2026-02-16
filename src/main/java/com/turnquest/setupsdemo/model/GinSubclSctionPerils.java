package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_SUBCL_SCTION_PERILS table.
 * This table stores perils per subclass.
 */
@Entity
@Table(name = "GIN_SUBCL_SCTION_PERILS")
@Data
public class GinSubclSctionPerils {

    /**
     * Primary Key.
     */
    @Id
    @Column(name = "SSPR_CODE", nullable = false, precision = 22)
    private BigDecimal ssPrCode;

    /**
     * Foreign key from GIN_SUB_CLASSES.
     */
    @Column(name = "SSPR_SCL_CODE", precision = 22)
    private BigDecimal ssPrSclCode;

    /**
     * Foreign key from GIN_SECTIONS.
     */
    @Column(name = "SSPR_SECT_CODE", precision = 22)
    private BigDecimal ssPrSectCode;

    /**
     * Section short description.
     */
    @Column(name = "SSPR_SECT_SHT_DESC", length = 80)
    private String ssPrSectShtDesc;

    /**
     * Foreign key from GIN_PERILS.
     */
    @Column(name = "SSPR_PER_CODE", nullable = false, precision = 22)
    private BigDecimal ssPrPerCode;

    /**
     * Peril short description.
     */
    @Column(name = "SSPR_PER_SHT_DESC", length = 25)
    private String ssPrPerShtDesc;

    /**
     * Not used.
     */
    @Column(name = "SSPR_MANDATORY", length = 1)
    private String ssPrMandatory;

    /**
     * Only specified if SSPR_SI_OR_LIMIT IS PL. Max payable.
     */
    @Column(name = "SSPR_PERIL_LIMIT", precision = 22, scale = 5)
    private BigDecimal ssPrPerilLimit;

    /**
     * Peril pays Insured(SL)/Third Party(TP) or Both(BO).
     */
    @Column(name = "SSPR_PERIL_TYPE", nullable = false, length = 2)
    private String ssPrPerilType;

    /**
     * How the peril limit is determined - Sum Insured(SI)/Section Limit(SL)/Peril Limit(PL)/Unlimited(UN).
     */
    @Column(name = "SSPR_SI_OR_LIMIT", nullable = false, length = 3)
    private String ssPrSiOrLimit;

    /**
     * Foreign key from ?.
     */
    @Column(name = "SSPR_SEC_CODE", precision = 15)
    private BigDecimal ssPrSecCode;

    /**
     * SI Excess type (PCT[P] or AMT[A] or TABLE[T]). If SSPR_DEPEND_LOSS_TYPE is NO(N) then applies for all loss types else SSPR_DEPEND_LOSS_TYPE is YES(Y) then applies for Total loss.
     */
    @Column(name = "SSPR_EXCESS_TYPE", length = 1)
    private String ssPrExcessType;

    /**
     * SI Excess value depends on Excess type. If SSPR_DEPEND_LOSS_TYPE is NO(N) then applies for all loss types else SSPR_DEPEND_LOSS_TYPE is YES(Y) then applies for Total loss.
     */
    @Column(name = "SSPR_EXCESS", precision = 22, scale = 5)
    private BigDecimal ssPrExcess;

    /**
     * SI Excess Min value. If SSPR_DEPEND_LOSS_TYPE is NO(N) then applies for all loss types else SSPR_DEPEND_LOSS_TYPE is YES(Y) then applies for Total loss.
     */
    @Column(name = "SSPR_EXCESS_MIN", precision = 22, scale = 5)
    private BigDecimal ssPrExcessMin;

    /**
     * SI Excess Max value. If SSPR_DEPEND_LOSS_TYPE is NO(N) then applies for all loss types else SSPR_DEPEND_LOSS_TYPE is YES(Y) then applies for Total loss.
     */
    @Column(name = "SSPR_EXCESS_MAX", precision = 22, scale = 5)
    private BigDecimal ssPrExcessMax;

    /**
     * Cover on Peril section expires upon claiming on this peril.
     */
    @Column(name = "SSPR_EXPIRE_ON_CLAIM", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String ssPrExpireOnClaim;

    /**
     * Binder type.
     */
    @Column(name = "SSPR_BIND_TYPE", length = 1)
    private String ssPrBindType;

    /**
     * Foreign key from GIN_BINDERS.
     */
    @Column(name = "SSPR_BIND_CODE", precision = 22)
    private BigDecimal ssPrBindCode;

    /**
     * Peril description.
     */
    @Column(name = "SSPR_DESC", length = 50)
    private String ssPrDesc;

    /**
     * Claim Excess value depends on Claim Excess type. If SSPR_DEPEND_LOSS_TYPE is NO(N) then applies for all loss types else loss type is YES(Y) then applies for Total loss.
     */
    @Column(name = "SSPR_CLAIM_LIMIT", precision = 23, scale = 5)
    private BigDecimal ssPrClaimLimit;

    /**
     * Person Max payable limit.
     */
    @Column(name = "SSPR_PERSON_LIMIT", precision = 23, scale = 5)
    private BigDecimal ssPrPersonLimit;

    /**
     * Redudant.
     */
    @Column(name = "SSPR_DEPRECIATION_PCT", precision = 23)
    private BigDecimal ssPrDepreciationPct;

    /**
     * Limit multiplier.
     */
    @Column(name = "SSPR_SALVAGE_PCT", precision = 22, scale = 5)
    private BigDecimal ssPrSalvagePct;

    /**
     * Redudant.
     */
    @Column(name = "SSPR_TOTALED_PRL", length = 10)
    private String ssPrTotaledPrl;

    /**
     * Claim Excess type (PCT[P] or AMT[A] or TABLE[T]). If SSPR_DEPEND_LOSS_TYPE is NO(N) then applies for all loss types else SSPR_DEPEND_LOSS_TYPE is YES(Y) then applies for Total loss.
     */
    @Column(name = "SSPR_CLAIM_EXCESS_TYPE", nullable = false, length = 1, columnDefinition = "VARCHAR2(1) default 'P'")
    private String ssPrClaimExcessType;

    /**
     * SI Excess type (PCT[P] or AMT[A] or TABLE[T]). Where loss type is YES(Y). Partial loss.
     */
    @Column(name = "SSPR_TL_EXCESS_TYPE", length = 1)
    private String ssPrTlExcessType;

    /**
     * SI Excess value depends on TL_EXCESS_TYPE. Only applicable for SSPR_DEPEND_LOSS_TYPE is YES(Y) and applies for Partial loss.
     */
    @Column(name = "SSPR_TL_EXCESS", precision = 23, scale = 5)
    private BigDecimal ssPrTlExcess;

    /**
     * SI Excess Min value. Only applicable if SSPR_DEPEND_LOSS_TYPE is YES(Y) and applies for Partial loss.
     */
    @Column(name = "SSPR_TL_EXCESS_MIN", precision = 23, scale = 5)
    private BigDecimal ssPrTlExcessMin;

    /**
     * SI Excess Max value. Only applicable if SSPR_DEPEND_LOSS_TYPE is YES(Y) and applies for Partial loss.
     */
    @Column(name = "SSPR_TL_EXCESS_MAX", precision = 23, scale = 5)
    private BigDecimal ssPrTlExcessMax;

    /**
     * Claim Excess type (PCT[P] or AMT[A] or TABLE[T]). Only applicable where SSPR_DEPEND_LOSS_TYPE is YES(Y) and applies for Partial loss.
     */
    @Column(name = "SSPR_PL_EXCESS_TYPE", length = 1)
    private String ssPrPlExcessType;

    /**
     * Claim Excess value depends on SSPR_PL_EXCESS_TYPE. Only applicable where SSPR_DEPEND_LOSS_TYPE is YES(Y) and applies for Partial loss.
     */
    @Column(name = "SSPR_PL_EXCESS", precision = 23, scale = 5)
    private BigDecimal ssPrPlExcess;

    /**
     * Claim Excess Min value. Only applicable where SSPR_DEPEND_LOSS_TYPE is YES(Y) and applies for Partial loss.
     */
    @Column(name = "SSPR_PL_EXCESS_MIN", precision = 23, scale = 5)
    private BigDecimal ssPrPlExcessMin;

    /**
     * Claim Excess Max value. Only applicable where SSPR_DEPEND_LOSS_TYPE is YES(Y) and applies for Partial loss.
     */
    @Column(name = "SSPR_PL_EXCESS_MAX", precision = 23, scale = 5)
    private BigDecimal ssPrPlExcessMax;

    /**
     * Claim Excess Min value. If SSPR_DEPEND_LOSS_TYPE is NO(N) then applies for all loss types else SSPR_DEPEND_LOSS_TYPE is YES(Y) then applies for Total loss.
     */
    @Column(name = "SSPR_CLAIM_EXCESS_MIN", precision = 23, scale = 5)
    private BigDecimal ssPrClaimExcessMin;

    /**
     * Claim Excess Max value. If SSPR_DEPEND_LOSS_TYPE is NO(N) then applies for all loss types else SSPR_DEPEND_LOSS_TYPE is YES(Y) then applies for Total loss.
     */
    @Column(name = "SSPR_CLAIM_EXCESS_MAX", precision = 23, scale = 5)
    private BigDecimal ssPrClaimExcessMax;

    /**
     * Excess depends on type of loss (YES [Y] or NO [N]).
     */
    @Column(name = "SSPR_DEPEND_LOSS_TYPE", nullable = false, length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String ssPrDependLossType;

    /**
     * Benefit % per period setup ie [PRD:%] =[6:100][5:50].
     */
    @Column(name = "SSPR_TTD_BEN_PCTS", length = 50)
    private String ssPrTtdBenPcts;

    /**
     * The maximum period that can be claimed on peril.
     */
    @Column(name = "SSPR_MAX_CLAIM_PRD", precision = 23)
    private BigDecimal ssPrMaxClaimPrd;

    /**
     * The maximum claim type period (D[DAYS],W[WEEKS],M[MONTHS]).
     */
    @Column(name = "SSPR_MAX_CLM_TYPE", length = 1)
    private String ssPrMaxClmType;

    /**
     * Foreign key from ?.
     */
    @Column(name = "SSPR_CLA_CODE", nullable = false, precision = 22)
    private BigDecimal ssPrClaCode;

    /**
     * ?.
     */
    @Column(name = "SSPR_PER_TYPE", length = 1, columnDefinition = "VARCHAR2(1) default 'P'")
    private String ssPrPerType;

    /**
     * ?.
     */
    @Column(name = "SSPR_SSPR_CODE", precision = 20)
    private BigDecimal ssPrSsPrCode;

    /**
     * ?.
     */
    @Column(name = "SSPR_EXCESS_SECT_CODE")
    private BigDecimal ssPrExcessSectCode;

    /**
     * ?.
     */
    @Column(name = "SSPR_PERIL_LIMIT_SCOPE", length = 1, columnDefinition = "VARCHAR2(1) default 'C'")
    private String ssPrPerilLimitScope;

    /**
     * ?.
     */
    @Column(name = "SSPR_SUBCL_PERIL_SHT_DESC", length = 130)
    private String ssPrSubclPerilShtDesc;
}
