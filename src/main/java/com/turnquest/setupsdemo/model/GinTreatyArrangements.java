package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * This table stores details of reinsurance treaty arrangements.
 */
@Entity
@Table(name = "GIN_TREATY_ARRANGEMENTS")
@Data
public class GinTreatyArrangements {
    /**
 * Table Primary Key
 */
@Id
@Column(name = "TA_CODE", nullable = false, precision = 22)
private Long taCode;

/**
 * Unique Id
 */
@Column(name = "TA_SHT_DESC", nullable = false, length = 45)
private String taShtDesc;

/**
 * Description
 */
@Column(name = "TA_DESC", nullable = false, length = 45)
private String taDesc;

/**
 * Treaty Arrangement type
 */
@Column(name = "TA_TYPE", nullable = false, length = 2)
private String taType;

/**
 * Currency code referencing TQC\_CURRENCIES
 */
@Column(name = "TA_CUR_CODE", precision = 22)
private Long taCurCode;

/**
 * Currency symbol
 */
@Column(name = "TA_CUR_SYMBOL", length = 15)
private String taCurSymbol;
}