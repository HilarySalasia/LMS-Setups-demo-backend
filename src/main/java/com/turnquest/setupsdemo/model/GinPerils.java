package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_PERILS table.
 * Stores information about all perils in the system.
 */
@Entity
@Table(name = "GIN_PERILS")
@Data
public class GinPerils {

    /**
     * Primary key for the peril.
     */
    @Id
    @Column(name = "PER_CODE", nullable = false, precision = 22)
    private BigDecimal perCode;

    /**
     * Short description of the peril.
     */
    @Column(name = "PER_SHT_DESC", nullable = false, length = 150)
    private String perShtDesc;

    /**
     * Description of the peril.
     */
    @Column(name = "PER_DESC", nullable = false, length = 150)
    private String perDesc;

    /**
     * Full description of the peril.
     */
    @Column(name = "PER_FULL_DESC", length = 500)
    private String perFullDesc;

    /**
     * Payment type for the peril.
     */
    @Column(name = "PER_PAYMENT_TYPE", nullable = false, length = 20, columnDefinition = "VARCHAR2(20) default 'B'")
    private String perPaymentType;

    /**
     * Date the peril was wet.
     */
    @Column(name = "PER_WET")
    private LocalDate perWet;

    /**
     * Date the peril was effective.
     */
    @Column(name = "PER_WEF", nullable = false)
    private LocalDate perWef;

    /**
     * Type of peril.
     */
    @Column(name = "PER_PERIL_TYPE", length = 20)
    private String perPerilType;

    /**
     * Type of the peril.
     */
    @Column(name = "PER_TYPE", nullable = false, length = 20, columnDefinition = "VARCHAR2(20) default 'P'")
    private String perType;

    /**
     * Liability type for the peril.
     */
    @Column(name = "PER_LIABILITY_TYPE", length = 1)
    private Character perLiabilityType;

    /**
     * Organization code associated with the peril.
     */
    @Column(name = "PER_ORGANIZATION_CODE", precision = 19, scale = 2)
    private BigDecimal perOrganizationCode;
}