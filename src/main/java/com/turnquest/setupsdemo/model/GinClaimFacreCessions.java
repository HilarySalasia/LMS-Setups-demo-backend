package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

/**
 * This table stores facre cessions per claim based on the facre cession details for the risk at underwriting.
 */
@Entity
@Table(name = "GIN_CLAIM_FACRE_CESSIONS")
@Data
public class GinClaimFacreCessions {
    /**
 * Foreign key referencing GIN\_CLAIM\_MASTER\_BOOKINGS.CMB\_CLAIM\_NO
 */
@Column(name = "FCC_CMB_CLAIM_NO", nullable = false, length = 25)
private String fccCmbClaimNo;

/**
 * Primary key for the table
 */
@Id
@Column(name = "FCC_CODE", nullable = false, precision = 22)
private Long fccCode;

/**
 * Agent code
 */
@Column(name = "FCC_AGNT_AGENT_CODE", nullable = false, precision = 22)
private Long fccAgntAgentCode;

/**
 * Insured property code
 */
@Column(name = "FCC_IPU_CODE", precision = 22)
private Long fccIpuCode;

/**
 * Agent short description
 */
@Column(name = "FCC_AGENT_SHT_DESC", nullable = false, length = 15)
private String fccAgentShtDesc;

/**
 * Facre rate
 */
@Column(name = "FCC_RATE", precision = 22, scale = 5)
private BigDecimal fccRate;

/**
 * Underwriting year
 */
@Column(name = "FCC_UWYR", precision = 22)
private Long fccUwyr;

/**
 * Facre amount
 */
@Column(name = "FCC_AMOUNT", precision = 22, scale = 5)
private BigDecimal fccAmount;

/**
 * Indicates if the rate is an amount or a percentage
 */
@Column(name = "FCC_RATE_AMT", length = 1)
private String fccRateAmt;

/**
 * Facre cession code
 */
@Column(name = "FCC_FC_CODE", precision = 22)
private Long fccFcCode;

/**
 * Indicates the facre type
 */
@Column(name = "FCC_FACRE_TYPE", length = 1)
private String fccFacreType;
}