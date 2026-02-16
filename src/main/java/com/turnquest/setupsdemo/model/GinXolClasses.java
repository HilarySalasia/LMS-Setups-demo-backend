package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_XOL_CLASSES table.
 * Likely stores information about XOL classes.
 */
@Entity
@Table(name = "GIN_XOL_CLASSES")
@Data
public class GinXolClasses {

    /**
     * Subclass code.
     */
    @Column(name = "XOLC_SCL_CODE", nullable = false, precision = 22)
    private BigDecimal xolcSclCode;

    /**
     * Foreign key from GIN_XOL_ARRANGEMENT_SETUPS, representing the XOL arrangement setup code.
     */
    @Column(name = "XOLC_XAS_CODE", nullable = false, precision = 22)
    private BigDecimal xolcXasCode;

    /**
     * Foreign key from GIN_XOL_TREATY_ARRANGEMENTS, representing the XOL treaty arrangement code.
     */
    @Column(name = "XOLC_XTA_CODE", nullable = false, precision = 22)
    private BigDecimal xolcXtaCode;

    /**
     * Minimum limit.
     */
    @Column(name = "XOLC_MIN_LIMIT", precision = 22, scale = 5)
    private BigDecimal xolcMinLimit;

    /**
     * Maximum limit.
     */
    @Column(name = "XOLC_MAX_LIMIT", precision = 22, scale = 5)
    private BigDecimal xolcMaxLimit;

    /**
     * Gross/net premium income.
     */
    @Column(name = "XOLC_GROSS_NET_PREM_INC", precision = 23, scale = 5)
    private BigDecimal xolcGrossNetPremInc;

    /**
     * Incurred loss.
     */
    @Column(name = "XOLC_INCURRED_LOSS", precision = 22)
    private BigDecimal xolcIncurredLoss;

    /**
     * Rate.
     */
    @Column(name = "XOLC_RATE", precision = 22)
    private BigDecimal xolcRate;

    /**
     * Adjustment rate.
     */
    @Column(name = "XOLC_ADJ_RATE", precision = 22)
    private BigDecimal xolcAdjRate;

    /**
     * Primary key for the XOL class record.
     */
    @Id
    @Column(name = "XOLC_CODE", nullable = false, precision = 22)
    private BigDecimal xolcCode;

    /**
     * Maximum layer.
     */
    @Column(name = "XOLC_MAX_LAYER", precision = 22)
    private BigDecimal xolcMaxLayer;

    /**
     * Foreign key from GIN_XOL_TREATY_SETUPS, representing the XOL treaty setup code.
     */
    @Column(name = "XOLC_XOLS_CODE", nullable = false, precision = 22)
    private BigDecimal xolcXolsCode;
}