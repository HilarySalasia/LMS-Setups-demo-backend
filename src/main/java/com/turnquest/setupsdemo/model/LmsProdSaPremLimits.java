package com.turnquest.setupsdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "LMS_PROD_SA_PREM_LIMITS")
public class LmsProdSaPremLimits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PSPL_CODE", nullable = false)
    private Long psplCode;

    @Column(name = "PSPL_PAY_FREQ", nullable = false, length = 3)
    private String psplPayFreq;

    @Column(name = "PSPL_MIN_PREM", nullable = false)
    private BigDecimal psplMinPrem;

    @Column(name = "PSPL_MAX_PREM", nullable = false)
    private BigDecimal psplMaxPrem;

    @Column(name = "PSPL_MIN_SA", nullable = false)
    private BigDecimal psplMinSa;

    @Column(name = "PSPL_MAX_SA", nullable = false)
    private BigDecimal psplMaxSa;

    @ManyToOne
    @JoinColumn(name = "PSPL_PROD_CODE", nullable = false)
    @JsonBackReference
    private LmsProducts lmsProducts;

    @Column(name = "PSPL_MIN_CONTRI", nullable = false)
    private BigDecimal psplMinContri;

    @Column(name = "PSPL_MAX_CONTRI", nullable = false)
    private BigDecimal psplMaxContri;

    @Column(name = "PSPL_PA_MIN_SA")
    private BigDecimal psplPaMinSa;

    @ManyToOne
    @JoinColumn(name = "PSPL_POP_CODE")
    private LmsProdOptions lmsProdOptions;

    @ManyToOne
    @JoinColumn(name = "PSPL_PCT_CODE")
    private LmsProdCoverTypes lmsProdCoverTypes;

    @Column(name = "PSPL_MIN_AGE")
    private Integer psplMinAge;

    @Column(name = "PSPL_MAX_AGE")
    private Integer psplMaxAge;
}

