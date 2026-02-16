package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "LMS_PROD_OPTIONS")
public class LmsProdOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lmsPopCodeSeq")
    @SequenceGenerator(name = "lmsPopCodeSeq", sequenceName = "LMS_POP_CODE_SEQ", allocationSize = 1)
    @Column(name = "POP_CODE", nullable = false)
    private Long popCode;

    @Column(name = "POP_SHT_DESC", length = 20)
    private String popShtDesc;

    @Column(name = "POP_DESC", length = 50)
    private String popDesc;


    @Column(name = "POP_PROD_CODE", nullable = false)
    private BigDecimal popProdCode;

    @Column(name = "POP_REMARKS", length = 2000)
    private String popRemarks;

    @Column(name = "POP_PRTL_MATURITY_PERCT", length = 50)
    private String popPrtlMaturityPerct;

    @Column(name = "POP_P_MATURITY_LAST_NO_YRS")
    private BigDecimal popPMaturityLastNoYrs;

    @Column(name = "POP_CLM_INSTALMENTS", precision = 10, scale = 5)
    private BigDecimal popClmInstalments;

    @Column(name = "POP_TOT_PRTL_MATRTY")
    private BigDecimal popTotPrtlMatrty;

    @Column(name = "POP_SVT_CODE")
    private BigDecimal popSvtCode;

    @Column(name = "POP_F2_SVT_CODE")
    private BigDecimal popF2SvtCode;

    @Column(name = "POP_SURRENDER_VAL_FORMULA", length = 5)
    private String popSurrenderValFormula;

    @Column(name = "POP_PAIDUP_VAL_FORMULA", length = 5)
    private String popPaidupValFormula;

    @Column(name = "POP_LEVEL", nullable = false)
    private BigDecimal popLevel;

    @Column(name = "POP_MATURITY_PYMT_YRS", length = 30)
    private String popMaturityPymtYrs;

    @Column(name = "POP_PYMT_FREQ_YRS")
    private BigDecimal popPymtFreqYrs;

    @Column(name = "POP_INV_PREM_PERC", precision = 23, scale = 5)
    private BigDecimal popInvPremPerc;

    @Column(name = "POP_MAT_PYMT_TYPE", length = 5)
    private String popMatPymtType;

    @Column(name = "POP_USE_PRDS_ASDIV_FACT", length = 5)
    private String popUsePrdsAsdivFact;

    @Column(name = "POP_MIN_TERM_YRS")
    private BigDecimal popMinTermYrs;

    @Column(name = "POP_MAX_TERM_YRS")
    private BigDecimal popMaxTermYrs;

    @Column(name = "POP_TERM_DIST", length = 1)
    private String popTermDist;

    @Column(name = "POP_USE_LIFECVR_FACTR", length = 5)
    private String popUseLifecvrFactr;

    @Column(name = "POP_PU_SVT_CODE")
    private BigDecimal popPuSvtCode;

    @Column(name = "POP_TMBNS_SVT_CODE", precision = 23, scale = 5)
    private BigDecimal popTmbnsSvtCode;

    @Column(name = "POP_ESCL_TYPE", length = 5)
    private String popEsclType;

    @Column(name = "POP_MIN_RETIRE_AGE")
    private BigDecimal popMinRetireAge;

    @Column(name = "POP_MAX_RETIRE_AGE")
    private BigDecimal popMaxRetireAge;

    @Column(name = "POP_BONUS_FORMULAR", length = 5)
    private String popBonusFormular;

    @Column(name = "POP_MAX_PREM_PAY_TERM")
    private BigDecimal popMaxPremPayTerm;

    @Column(name = "POP_MIN_PREM_PAY_TERM")
    private BigDecimal popMinPremPayTerm;

    @Column(name = "POP_CHECK_ASSUERED_AGE", length = 5)
    private String popCheckAssueredAge;

    @Column(name = "POP_INV_MIN_AMT", precision = 25, scale = 5)
    private BigDecimal popInvMinAmt;

    @Column(name = "POP_INV_MAX_AMT", precision = 25, scale = 5)
    private BigDecimal popInvMaxAmt;

    @Column(name = "POP_MIN_INV_TERM")
    private BigDecimal popMinInvTerm;

    @Column(name = "POP_MAX_INV_TERM")
    private BigDecimal popMaxInvTerm;

    @Column(name = "POP_DFLT_PMAS_CODE")
    private BigDecimal popDfltPmasCode;

    @Column(name = "POP_CUR_CODE")
    private BigDecimal popCurCode;

    @Column(name = "POP_INVEST_CONTRI_SRC", length = 5)
    private String popInvestContriSrc;

    @Column(name = "POP_INV_RIDER_MANDATORY", length = 1)
    private String popInvRiderMandatory;

    @Column(name = "POP_WITH_BONUS", length = 1)
    private String popWithBonus;

    @Column(name = "POP_TERM_PRD_IN", length = 5)
    private String popTermPrdIn;
}
