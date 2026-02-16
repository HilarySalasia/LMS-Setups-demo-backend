package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Entity representing the TQC_LOCATIONS table.
 * This entity is likely related to storing locations within the system.
 */
@Entity
@Table(name = "TQC_LOCATIONS")
@Data
public class TqcLocations {

    /**
     * Location code.
     */
    @Id
    @Column(name = "LOC_CODE")
    private String locCode;

    /**
     * Town code.
     */
    @Column(name = "LOC_TWN_CODE")
    private BigDecimal locTwnCode;

    /**
     * Short description of the location.
     */
    @Column(name = "LOC_SHT_DESC")
    private String locShtDesc;

    /**
     * Location name.
     */
    @Column(name = "LOC_NAME")
    private String locName;

    /**
     * Landmark associated with the location.
     */
    @Column(name = "LOC_LANDMARK")
    private String locLandmark;
}