package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the TQC_TOWNS table.
 * Stores information about towns.
 */
@Entity
@Table(name = "TQC_TOWNS")
@Data
public class TqcTowns {

    /**
     * Primary key for the town record.
     */
    @Id
    @Column(name = "TWN_CODE", nullable = false, precision = 22)
    private BigDecimal twnCode;

    /**
     * Foreign key from TQC_COUNTRIES, representing the country code.
     */
    @Column(name = "TWN_COU_CODE", nullable = false, precision = 22)
    private BigDecimal twnCouCode;

    /**
     * Short description of the town.
     */
    @Column(name = "TWN_SHT_DESC", nullable = false, length = 15)
    private String twnShtDesc;

    /**
     * Town name.
     */
    @Column(name = "TWN_NAME", nullable = false, length = 50)
    private String twnName;

    /**
     * State code associated with the town.
     */
    @Column(name = "TWN_STS_CODE", precision = 22)
    private BigDecimal twnStsCode;

    /**
     * Date the town was created.
     */
    @Column(name = "TWN_CREATED_DATE")
    private LocalDate twnCreatedDate;

    /**
     * User who created the town.
     */
    @Column(name = "TWN_CREATED_BY", length = 50)
    private String twnCreatedBy;

    /**
     * Date and time the town was modified.
     */
    @Column(name = "TWN_MODIFIED_DATE")
    private LocalDateTime twnModifiedDate;

    /**
     * User who modified the town.
     */
    @Column(name = "TWN_MODIFIED_BY", length = 50)
    private String twnModifiedBy;
}