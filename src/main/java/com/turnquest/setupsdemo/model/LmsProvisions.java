package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Represents the LMS_PROVISIONS entity in the LMS system.
 * <p>
 * This entity stores the provisions used in claims.
 * </p>
 *
 * <p>
 * Table Description: STORES PROVISIONS
 * </p>
 */
@Entity
@Table(name = "LMS_PROVISIONS")
@Data
public class LmsProvisions {

    /**
     * Unique provision code.
     * <p>
     * Column Description: UNIQUE CODE
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROV_CODE", nullable = false)
    private BigDecimal provCode;

    /**
     * Short description of the provision.
     * <p>
     * Column Description: SHORT DESCRIPTION
     * </p>
     */
    @Column(name = "PROV_SHT_DESC", nullable = false, length = 15)
    private String provShtDesc;

    /**
     * Full provision description.
     * <p>
     * Column Description: PROVISION DESCRIPTION
     * </p>
     */
    @Column(name = "PROV_DESC", nullable = false, length = 4000)
    private String provDesc;

    /**
     * Provision type, either PRODUCT or COVER TYPE.
     * <p>
     * Column Description: TYPE ( PRODUCT OR COVER TYPE)
     * </p>
     */
    @Column(name = "PROV_TYPE", nullable = false, length = 30)
    private String provType;

    /**
     * Clause type for the provision. Possible values:
     * <ul>
     *     <li>H - HIV</li>
     *     <li>N - NORMAL</li>
     *     <li>C - CRITICAL ILLNESS</li>
     * </ul>
     * <p>
     * Column Description: PROVISION CLAUSE( H- HIV, N- NORMAL,C-CRITICAL ILLNESS)
     * </p>
     */
    @Column(name = "PROV_HIV_CLAUSE", nullable = false, length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String provHivClause = "N";

    /**
     * Reference to LMS_CLASSES table (optional).
     * <p>
     * Column Description: Foreign key to LMS_CLASSES.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "PROV_CLA_CODE", referencedColumnName = "CLA_CODE")
    private LmsClasses lmsClasses;

    /**
     * Hospitalization or treatment type.
     * <ul>
     *     <li>I - Inpatient</li>
     *     <li>O - Outpatient</li>
     *     <li>B - Both</li>
     * </ul>
     * <p>
     * Column Description: Hospitalization/Treatment type: I - Inpatient, O - Outpatient, B - Both
     * </p>
     */
    @Column(name = "PROV_TREATMENT_TYPE", length = 5)
    private String provTreatmentType;

    /**
     * Start date for the provision.
     */
    @Column(name = "PROV_WEF")
    @Temporal(TemporalType.DATE)
    private Date provWef;

    /**
     * End date for the provision.
     */
    @Column(name = "PROV_WET")
    @Temporal(TemporalType.DATE)
    private Date provWet;

    /**
     * Indicates if premium refund is applicable. Default is 'N'.
     */
    @Column(name = "PROV_REFUND_PREM", length = 5, columnDefinition = "VARCHAR2(5) default 'N'")
    private String provRefundPrem = "N";
}
