package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "LMS_PROD_OPT_ANN_PAYOUT")
public class LmsProdOptAnnPayout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POPA_CODE", nullable = false)
    private Long popaCode;

    @ManyToOne
    @JoinColumn(name = "POPA_POP_CODE", nullable = false)
    private LmsProdOptions lmsProdOptions;

    @Column(name = "POPA_DAY_FROM", nullable = false)
    private Long popaDayFrom;

    @Column(name = "POPA_DAY_TO", nullable = false)
    private Long popaDayTo;

    @Column(name = "POPA_PAYMENT_DAY", nullable = false)
    private Long popaPaymentDay;

    @Column(name = "POPA_CUR_MONTH", length = 1, nullable = false)
    private String popaCurMonth = "C";
}
