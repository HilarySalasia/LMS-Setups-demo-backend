package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Entity representing the GIN_XOL_TREATIES table.
 * Likely stores information about XOL treaties.
 */
@Entity
@Table(name = "GIN_XOL_TREATIES")
@Data
public class GinXolTreaty {

    /**
     * Primary key for the XOL treaty record.
     */
    @Id
    @Column(name = "XOL_CODE", nullable = false, precision = 22)
    private BigDecimal xolCode;

    /**
     * Description of the XOL treaty.
     */
    @Column(name = "XOL_DESC", nullable = false, length = 50)
    private String xolDesc;

    /**
     * Type of XOL treaty.
     */
    @Column(name = "XOL_TYPE", nullable = false, length = 2)
    private String xolType;
}
