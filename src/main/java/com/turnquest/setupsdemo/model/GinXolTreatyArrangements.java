package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Entity representing the GIN_XOL_TREATY_ARRANGEMENTS table.
 * Likely stores information about XOL treaty arrangements.
 */
@Entity
@Table(name = "GIN_XOL_TREATY_ARRANGEMENTS")
@Data
public class GinXolTreatyArrangements {

    /**
     * Primary key for the XOL treaty arrangement record.
     */
    @Id
    @Column(name = "XTA_CODE", nullable = false, precision = 22)
    private BigDecimal xtaCode;

    /**
     * Short description of the arrangement.
     */
    @Column(name = "XTA_SHT_DESC", nullable = false, length = 45)
    private String xtaShtDesc;

    /**
     * Description of the arrangement.
     */
    @Column(name = "XTA_DESC", nullable = false, length = 45)
    private String xtaDesc;

    /**
     * Type of arrangement.
     */
    @Column(name = "XTA_TYPE", nullable = false, length = 2)
    private String xtaType;

    /**
     * Indicates whether the arrangement is a valuation multiplier (Y/N).
     */
    @Column(name = "XTA_VLMP", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String xtaVlmp;
}