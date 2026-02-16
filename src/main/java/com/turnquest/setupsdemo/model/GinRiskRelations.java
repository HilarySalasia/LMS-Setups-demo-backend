package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * This table stores information about reinsurance relationships.
 */
@Entity
@Table(name = "GIN_RISK_RELATIONS")
@Data
public class GinRiskRelations {
    /**
     * Primary key for the table.
     */
    @Id
    @Column(name = "RELR_CODE", nullable = false, precision = 22)
    private Long relrCode;

    /**
     * Short description of the reinsurance relationship.
     */
    @Column(name = "RELR_SHT_DESC", nullable = false, length = 15)
    private String relrShtDesc;

    /**
     * Description of the reinsurance relationship.
     */
    @Column(name = "RELR_DESC", nullable = false, length = 60)
    private String relrDesc;

    /**
     * Code referencing the Treaty Agreement table.
     */
    @Column(name = "RELR_TA_CODE", nullable = false, precision = 22)
    private Long relrTaCode;

    /**
     * Short description of the Treaty Agreement.
     */
    @Column(name = "RELR_TA_SHT_DESC", nullable = false, length = 30)
    private String relrTaShtDesc;
}