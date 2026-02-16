package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_PARAMETERS table.
 * This table stores parameters defined in the system, used to alter system functioning based on specific circumstances.
 */
@Entity
@Table(name = "GIN_PARAMETERS")
@Data
public class GinParameters {

    /**
     * Primary Key.
     */
    @Id
    @Column(name = "PARAM_CODE", nullable = false, precision = 22)
    private BigDecimal paramCode;

    /**
     * Parameter name.
     */
    @Column(name = "PARAM_NAME", nullable = false, length = 50)
    private String paramName;

    /**
     * Parameter value.
     */
    @Column(name = "PARAM_VALUE", nullable = false, length = 200)
    private String paramValue;

    /**
     * Parameter status.
     */
    @Column(name = "PARAM_STATUS", length = 15)
    private String paramStatus;

    /**
     * Parameter description.
     */
    @Column(name = "PARAM_DESC", length = 200)
    private String paramDesc;

    /**
     * Organization code associated with the parameter.
     */
    @Column(name = "PARAM_ORG_CODE", precision = 19)
    private BigDecimal paramOrgCode;

    /**
     * Parameter version.
     */
    @Column(name = "PARAM_VERSION", precision = 19)
    private BigDecimal paramVersion;
}
