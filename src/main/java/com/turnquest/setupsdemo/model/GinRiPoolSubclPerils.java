package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * This table stores details of reinsurance pool subclasses and perils.
 */
@Entity
@Table(name = "GIN_RI_POOL_SUBCL_PERILS")
@Data
public class GinRiPoolSubclPerils {
    /**
 * Primary key for the table
 */
@Id
@Column(name = "RPSCP_CODE", nullable = false)
private Long rpscpCode;

/**
 * Foreign key referencing GIN\_SUB\_CLASSES.SCL\_CODE
 */
@Column(name = "RPSCP_SCL_CODE", nullable = false)
private Long rpscpSclCode;

/**
 * Special Pool Subclass Rate Code
 */
@Column(name = "RPSCP_SSPR_CODE", nullable = false)
private Long rpscpSsprCode;

/**
 * Peril Code
 */
@Column(name = "RPSCP_PER_CODE", nullable = false)
private Long rpscpPerCode;

/**
 * Foreign key referencing GIN\_POOL\_TREATY\_ARRANGEMENTS.PTA\_CODE
 */
@Column(name = "RPSCP_PTA_CODE", nullable = false, precision = 22)
private Long rpscpPtaCode;

/**
 * Claims Rate
 */
@Column(name = "RPSCP_CLAIMS_RATE", precision = 22)
private Long rpscpClaimsRate;

/**
 * Cover Type Code
 */
@Column(name = "RPSCP_COVT_CODE")
private Long rpscpCovtCode;
}
