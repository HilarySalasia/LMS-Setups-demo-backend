package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * This table stores temporary data related to claim peril excesses.
 */
@Entity
@Table(name = "GIN_CLAIM_PERIL_EXCESSES_TEMP")
@Data
public class GinClaimPerilExcessesTemp {
    /**
 * Primary key for the table
 */
@Id
@Column(name = "CPET_CODE", nullable = false, precision = 22)
private Long cpetCode;

/**
 * Foreign key referencing the claim peril type
 */
@Column(name = "CPET_CPT_CODE", nullable = false, precision = 22)
private Long cpetCptCode;

/**
 * Foreign key referencing the sub-section code
 */
@Column(name = "CPET_SSEX_CODE", precision = 22)
private Long cpetSsexCode;

/**
 * Description of the excess type
 */
@Column(name = "CPET_EXCESS_TYPE", length = 100)
private String cpetExcessType;

/**
 * The limit of the excess
 */
@Column(name = "CPET_EXCESS_LIMIT", precision = 22)
private Long cpetExcessLimit;

/**
 * The rate of the excess
 */
@Column(name = "CPET_EXCESS_RATE", precision = 22)
private Long cpetExcessRate;
}