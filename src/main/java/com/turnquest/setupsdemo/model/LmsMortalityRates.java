package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "LMS_MORTALITY_RATES")
public class LmsMortalityRates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LMR_CODE", nullable = false)
    private Long lmrCode;

    @Column(name = "LMR_TERM_FROM", precision = 10)
    private BigDecimal lmrTermFrom;

    @Column(name = "LMR_TERM_TO", precision = 10)
    private BigDecimal lmrTermTo;

    @Column(name = "LMR_PROD_CODE", precision = 25)
    private BigDecimal lmrProdCode;

    @Column(name = "LMR_RANGE_FROM", precision = 10)
    private BigDecimal lmrRangeFrom;

    @Column(name = "LMR_RANGE_TO", precision = 10)
    private BigDecimal lmrRangeTo;

    @Column(name = "LMR_LOAD_BY_RANGE", length = 1)
    private String lmrLoadByRange;
}
