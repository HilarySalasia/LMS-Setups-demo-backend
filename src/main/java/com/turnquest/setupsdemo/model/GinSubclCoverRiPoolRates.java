package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This table stores details of reinsurance pool rates for specific subclasses and cover types.
 */
@Entity
@Table(name = "GIN_SUBCL_COVER_RI_POOL_RATES")
@Data
public class GinSubclCoverRiPoolRates {
    /**
 * Primary key for the table
 */
@Id
@Column(name = "SCRPR_CODE", nullable = false)
private Long scrprCode;

/**
 * Foreign key referencing GIN\_SUB\_CLASSES.SCL\_CODE
 */
@Column(name = "SCRPR_SCL_CODE", nullable = false)
private Long scrprSclCode;

/**
 * Foreign key referencing GIN\_SUBCLASS\_COVER\_TYPES.SCLCOVT\_CODE
 */
@Column(name = "SCRPR_SCLCOVT_CODE", nullable = false)
private Long scrprSclcovtCode;

/**
 * Reinsurance rate
 */
@Column(name = "SCRPR_REIN_RATE", precision = 23, scale = 5)
private BigDecimal scrprReinRate;

/**
 * Commission rate
 */
@Column(name = "SCRPR_COMM_RATE", precision = 23, scale = 5)
private BigDecimal scrprCommRate;

/**
 * Commission VAT rate
 */
@Column(name = "SCRPR_COMM_VAT_RATE", precision = 23, scale = 5)
private BigDecimal scrprCommVatRate;

/**
 * Effective from date
 */
@Column(name = "SCRPR_WEF")
private Date scrprWef;

/**
 * Effective to date
 */
@Column(name = "SCRPR_WET")
private Date scrprWet;

/**
 * Cover type code
 */
@Column(name = "SCRPR_COVT_CODE", nullable = false, precision = 22)
private Long scrprCovtCode;

/**
 * Foreign key referencing GIN\_POOL\_TREATY\_ARRANGEMENTS.PTA\_CODE
 */
@Column(name = "SCRPR_PTA_CODE", nullable = false, precision = 22)
private Long scrprPtaCode;

/**
 * RPS code
 */
@Column(name = "SCRPR_RPS_CODE", precision = 22)
private Long scrprRpsCode;

/**
 * Maximum limit
 */
@Column(name = "SCRPR_MAX_LIMIT", precision = 23, scale = 5)
private BigDecimal scrprMaxLimit;

/**
 * Division factor
 */
@Column(name = "SCRPR_DIVISION_FACTOR", precision = 22)
private Long scrprDivisionFactor;

/**
 * Rate type
 */
@Column(name = "SCRPR_RATE_TYPE", length = 1)
private String scrprRateType;

/**
 * Pool rate divisor
 */
@Column(name = "SCRPR_POOL_RATE_DIVISOR", precision = 22)
private Long scrprPoolRateDivisor;
}
