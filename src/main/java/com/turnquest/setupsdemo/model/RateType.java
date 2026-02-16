package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Entity representing the LMS_SV_RATE_TYPES table.
 */
@Data
@Entity
@Table(name = "LMS_SV_RATE_TYPES", uniqueConstraints = {
        @UniqueConstraint(columnNames = "SVT_DESC")
})
public class RateType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SVT_CODE")
    private BigDecimal svtCode;

    @Column(name = "SVT_DESC", nullable = false, length = 30)
    private String svtDesc;

    @Column(name = "SVT_ANB_TYPE", length = 1)
    private String svtAnbType;

    @Column(name = "SVT_CURRENT_TEM_TYPE", length = 1)
    private String svtCurrentTemType;

    @Column(name = "SVT_PAID_MATRTY_RATE_FACTR", precision = 10, scale = 5)
    private BigDecimal svtPaidMatryRateFactr;

    @Column(name = "SVT_RATE_IN_YEARS_OR_MONTHS", length = 1, columnDefinition = "CHAR(1) DEFAULT 'Y'")
    private String svtRateInYearsOrMonths = "Y";

    @Column(name = "SVT_CLA_CODE")
    private BigDecimal svtClaCode;
}
