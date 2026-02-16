package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Entity representing the LMS_PREMIUM_MASKS table.
 */
@Data
@Entity
@Table(name = "LMS_PREMIUM_MASKS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"PMAS_SHT_DESC", "PMAS_DESC", "PMAS_CLA_CODE"})
})
public class PremiumMask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PMAS_CODE")
    private BigDecimal pmasCode;

    @Column(name = "PMAS_SHT_DESC", nullable = false, length = 15)
    private String pmasShtDesc;

    @Column(name = "PMAS_DESC", nullable = false, length = 80)
    private String pmasDesc;

    @Column(name = "PMAS_COMMENT", length = 100)
    private String pmasComment;

    @Column(name = "PMAS_PROD_CODE", nullable = false)
    private BigDecimal pmasProdCode;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "PMAS_CLA_CODE", nullable = false)
    private LmsClasses lmsClasses;

    @Column(name = "PMAS_DEFAULT", length = 5)
    private String pmasDefault;

    @Column(name = "PMAS_WITH_BONUS", length = 1, columnDefinition = "CHAR(1) DEFAULT 'N'")
    private String pmasWithBonus = "N";

    @Column(name = "PMAS_SMOKER_LOADING", precision = 10, scale = 5, columnDefinition = "NUMBER(10, 5) DEFAULT 0")
    private BigDecimal pmasSmokerLoading = BigDecimal.ZERO;

    @Column(name = "PMAS_HIV_LOADING", precision = 10, scale = 5, columnDefinition = "NUMBER(10, 5) DEFAULT 0")
    private BigDecimal pmasHivLoading = BigDecimal.ZERO;

    @Column(name = "PMAS_DEPENDT_ANB", length = 5, columnDefinition = "CHAR(1) DEFAULT 'M'")
    private String pmasDependtAnb = "M";

    @Column(name = "PMAS_RATE_TYPE", length = 5)
    private String pmasRateType;

    @Column(name = "PMAS_CUR_CODE")
    private BigDecimal pmasCurCode;

    @Column(name = "PMAS_CUR_DESC", length = 25)
    private String pmasCurDesc;
}
