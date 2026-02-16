package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

/**
 * This table stores the events that can occur.
 */
@Entity
@Table(name = "GIN_EVENTS")
@Data
public class GinEvents {
    /**
 * Primary key for the table.
 */
@Id
@Column(name = "EVE_CODE", nullable = false, precision = 22)
private Long eveCode;

/**
 * Short description of the event.
 */
@Column(name = "EVE_SHT_DESC", nullable = false, length = 30)
private String eveShtDesc;

/**
 * Date of the event.
 */
@Column(name = "EVE_DATE")
private Date eveDate;

/**
 * Description of the event.
 */
@Column(name = "EVE_DESC", length = 200)
private String eveDesc;

/**
 * Location of the event.
 */
@Column(name = "EVE_LOCATION", length = 30)
private String eveLocation;

/**
 * Cause of the event.
 */
@Column(name = "EVE_CAUSE", length = 50)
private String eveCause;

/**
 * Type of event.
 */
@Column(name = "EVE_TYPE", length = 1)
private String eveType;

/**
 * Effective From Date for the event.
 */
@Column(name = "EVE_WEF")
private Date eveWef;

/**
 * Effective To Date for the event.
 */
@Column(name = "EVE_WET")
private Date eveWet;

/**
 * Code referencing the XAS system.
 */
@Column(name = "EVE_XAS_CODE", precision = 22)
private Long eveXasCode;

/**
 * Code referencing the Reinsurance Relationship table.
 */
@Column(name = "EVE_RELR_CODE", precision = 22)
private Long eveRelrCode;
}