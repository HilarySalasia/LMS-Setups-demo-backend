package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;

/**
 * This table stores details of reinsurance pool cessions for claims.
 */
@Entity
@Table(name = "GIN_CLAIM_REIN_POOL_CESSIONS")
@Data
public class GinClaimReinPoolCessions {
    /**
 * Primary key for the table
 */
@Id
@Column(name = "CRPC_CODE", nullable = false, precision = 22)
private Long crpcCode;

/**
 * Claim number
 */
@Column(name = "CRPC_CMB_CLAIM_NO", nullable = false, length = 25)
private String crpcCmbClaimNo;

/**
 * Underwriting year
 */
@Column(name = "CRPC_UWYR", nullable = false, precision = 22)
private Long crpcUwyr;

/**
 * Rate for the reinsurance pool cession
 */
@Column(name = "CRPC_RATE", precision = 22, scale = 5)
private BigDecimal crpcRate;

/**
 * Policy batch number
 */
@Column(name = "CRPC_POL_BATCH_NO", precision = 22)
private Long crpcPolBatchNo;

/**
 * Subclass code
 */
@Column(name = "CRPC_SCL_CODE", precision = 22)
private Long crpcSclCode;

/**
 * Policy currency code
 */
@Column(name = "CRPC_POL_CUR_CODE", precision = 22)
private Long crpcPolCurCode;

/**
 * Reinsurance pool currency code
 */
@Column(name = "CRPC_POOL_CUR_CODE", precision = 22)
private Long crpcPoolCurCode;

/**
 * Policy currency symbol
 */
@Column(name = "CRPC_POL_CUR_SYMBOL", length = 15)
private String crpcPolCurSymbol;

/**
 * Reinsurance pool currency symbol
 */
@Column(name = "CRPC_POOL_CUR_SYMBOL", length = 15)
private String crpcPoolCurSymbol;

/**
 * Pool risk details code
 */
@Column(name = "CRPC_PRPRD_CODE", precision = 22)
private Long crpcPrprdCode;

/**
 * Subclass cover reinsurance pool rates code
 */
@Column(name = "CRPC_SCRPR_CODE", precision = 22)
private Long crpcScrprCode;

/**
 * Insured property code
 */
@Column(name = "CRPC_IPU_CODE", precision = 22)
private Long crpcIpuCode;
}