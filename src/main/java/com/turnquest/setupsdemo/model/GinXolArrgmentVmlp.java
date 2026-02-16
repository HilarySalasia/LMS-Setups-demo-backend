package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_XOL_ARRGMENT_VMLP table.
 * Likely stores information about XOL arrangement valuation multipliers.
 */
@Entity
@Table(name = "GIN_XOL_ARRGMENT_VMLP")
@Data
public class GinXolArrgmentVmlp {

    /**
     * Primary key for the XOL arrangement valuation multiplier record.
     */
    @Id
    @Column(name = "XOLVM_CODE", precision = 22)
    private BigDecimal xolvmCode;

    /**
     * Foreign key from GIN_XOL_ARRANGEMENT_SETUPS, representing the XOL arrangement setup code.
     */
    @Column(name = "XOLVM_XAS_CODE", precision = 22)
    private BigDecimal xolvmXasCode;

    /**
     * Valuation multiplier name.
     */
    @Column(name = "XOLVM_VMLP_NAME", length = 15)
    private String xolvmVmlpName;

    /**
     * Capacity.
     */
    @Column(name = "XOLVM_CAPACITY", precision = 23, scale = 5)
    private BigDecimal xolvmCapacity;

    /**
     * Type (TE = Treaty, FA = Facultative).
     */
    @Column(name = "XOLVM_TYPE", length = 2, columnDefinition = "VARCHAR2(2) default 'TE'")
    private String xolvmType;

    /**
     * Treaty capacity.
     */
    @Column(name = "XOLVM_TREATY_CAPACITY", precision = 22, scale = 5)
    private BigDecimal xolvmTreatyCapacity;
}
