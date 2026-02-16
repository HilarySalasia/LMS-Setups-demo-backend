package com.turnquest.setupsdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "LMS_MED_LOAD_RATES", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"MLR_TERM_TO", "MLR_TERM_FROM"})
})
public class LmsMedLoadRates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MLR_CODE", nullable = false)
    private Long mlrCode;

    @Column(name = "MLR_TERM_FROM", precision = 10, nullable = false)
    private BigDecimal mlrTermFrom;

    @Column(name = "MLR_TERM_TO", precision = 10, nullable = false)
    private BigDecimal mlrTermTo;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "MLR_PROD_CODE", referencedColumnName = "PROD_CODE")
    @JsonBackReference
    private LmsProducts lmsProducts;

    @Column(name = "MLR_POP_CODE", precision = 10)
    private BigDecimal mlrPopCode;
}
