package com.turnquest.setupsdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Entity representing the LMS_OPT_BENEFITS table.
 */
@Data
@Entity
@Table(name = "LMS_OPT_BENEFITS")
public class OptBenefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPB_CODE", nullable = false)
    private BigDecimal opbCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPB_POP_CODE", nullable = false, foreignKey = @ForeignKey(name = "LMS_OPB_POP_FK"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private LmsProdOptions productOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPB_PCT_CODE", nullable = false, foreignKey = @ForeignKey(name = "LMS_OPB_PCT_FK"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private LmsProdCoverTypes prodCoverType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPB_SVT_CODE", nullable = false)
    private RateType rateType;

    @Column(name = "OPB_MANDATORY", nullable = false, length = 1, columnDefinition = "VARCHAR2(1) DEFAULT 'N'")
    private String opbMandatory = "N";

    @Column(name = "OPB_MAIN_SA_PERC", precision = 8, scale = 5)
    private BigDecimal opbMainSaPerc;

    @Column(name = "OPB_EXCLUDE_AT_ESCL", length = 1, columnDefinition = "VARCHAR2(1) DEFAULT 'N'")
    private String opbExcludeAtEscl = "N";

    @Column(name = "OPB_SURRENDER_ALLOWED", length = 1, columnDefinition = "VARCHAR2(1) DEFAULT 'N'")
    private String opbSurrenderAllowed = "N";

    @Column(name = "OPB_SURRENDER_VAL_FORMULA", length = 5)
    private String opbSurrenderValFormula;



    @Column(name = "OPB_WITH_BONUS", length = 1, columnDefinition = "VARCHAR2(1) DEFAULT 'N'")
    private String opbWithBonus = "N";
}
