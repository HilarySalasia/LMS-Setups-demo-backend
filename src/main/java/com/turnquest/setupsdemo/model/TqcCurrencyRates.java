package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the TQC_CURRENCY_RATES table.
 * Stores currency exchange rates.
 */
@Entity
@Table(name = "TQC_CURRENCY_RATES")
@Data
public class TqcCurrencyRates {

    /**
     * Primary key for the currency rate record.
     */
    @Id
    @Column(name = "CRT_CODE", nullable = false, precision = 22)
    private BigDecimal crtCode;

    /**
     * Currency code.
     */
    @Column(name = "CRT_CUR_CODE", nullable = false, precision = 22)
    private BigDecimal crtCurCode;

    /**
     * Exchange rate.
     */
    @Column(name = "CRT_RATE", nullable = false, precision = 22, scale = 5)
    private BigDecimal crtRate;

    /**
     * Rate date.
     */
    @Column(name = "CRT_DATE", nullable = false)
    private LocalDate crtDate;

    /**
     * Base currency code.
     */
    @Column(name = "CRT_BASE_CUR_CODE", precision = 22)
    private BigDecimal crtBaseCurCode;

    /**
     * Date the rate was effective.
     */
    @Column(name = "CRT_WEF")
    private LocalDate crtWef;

    /**
     * Date the rate was wet.
     */
    @Column(name = "CRT_WET")
    private LocalDate crtWet;

    /**
     * User who created the record.
     */
    @Column(name = "CRT_CREATED_BY", length = 50)
    private String crtCreatedBy;

    /**
     * User who updated the record.
     */
    @Column(name = "CRT_UPDATED_BY", length = 50)
    private String crtUpdatedBy;

    /**
     * Date the record was created.
     */
    @Column(name = "CRT_CREATED_DATE")
    private LocalDate crtCreatedDate;

    /**
     * Date the record was updated.
     */
    @Column(name = "CRT_UPDATED_DATE")
    private LocalDate crtUpdatedDate;

    /**
     * Staging currency rate code.
     */
    @Column(name = "CRT_STGCR_CODE", precision = 22)
    private BigDecimal crtStgcrCode;
}