package com.turnquest.setupsdemo.model;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "LMS_ORD_PREM_TERMS")
public class LmsOrdPremTerms {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lmsOptCodeSeq")
    @SequenceGenerator(name = "lmsOptCodeSeq", sequenceName = "LMS_OPT_CODE_SEQ", allocationSize = 1)
    @Column(name = "OPT_CODE", nullable = false)
    private Long optCode;

    @Column(name = "OPT_TERM_FROM")
    private Integer optTermFrom;

    @Column(name = "OPT_TERM_TO")
    private Integer optTermTo;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "OPT_PCT_CODE", nullable = false)
    private LmsProdCoverTypes lmsProdCoverTypes;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "OPT_POP_CODE", nullable = false)
    private LmsProdOptions lmsProdOptions;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "OPT_PMAS_CODE")
    private PremiumMask lmsPremiumMasks;
}

