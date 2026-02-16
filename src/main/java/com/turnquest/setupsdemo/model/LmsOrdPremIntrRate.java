package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "LMS_ORD_PREM_INTR_RATE")
public class LmsOrdPremIntrRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPIR_CODE", nullable = false)
    private Long opirCode;

    @Column(name = "OPIR_RATE_FROM", precision = 23, scale = 5)
    private BigDecimal opirRateFrom;

    @Column(name = "OPIR_RATE_TO", precision = 23, scale = 5)
    private BigDecimal opirRateTo;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "OPIR_PCT_CODE", referencedColumnName = "PCT_CODE")
    private LmsProdCoverTypes opirPctCode;
}
