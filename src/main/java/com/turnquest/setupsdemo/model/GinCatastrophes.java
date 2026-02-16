package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

/**
 * Stores the catastrophes that can occur; Applicable when making a claims.
 */
@Entity
@Table(name = "GIN_CATASTROPHES")
@Data
public class GinCatastrophes {
    /**
 * Primary key for the table.
 */
@Id
@Column(name = "CAT_CODE", nullable = false, precision = 22)
private Long catCode; // Primary key for the table

/**
 * Short description of the catastrophe.
 */
@Column(name = "CAT_SHT_DESC", nullable = false, length = 15)
private String catShtDesc; // Short description of the catastrophe

/**
 * Description of the catastrophe.
 */
@Column(name = "CAT_DESC", nullable = false, length = 60)
private String catDesc; // Description of the catastrophe

/**
 * Cause of the catastrophe.
 */
@Column(name = "CAT_CAUSE", length = 100)
private String catCause; // Cause of the catastrophe

/**
 * Date of the catastrophe.
 */
@Column(name = "CAT_DATE")
private Date catDate; // Date of the catastrophe

/**
 * Location of the catastrophe.
 */
@Column(name = "CAT_LOCATION", length = 30)
private String catLocation; // Location of the catastrophe
}