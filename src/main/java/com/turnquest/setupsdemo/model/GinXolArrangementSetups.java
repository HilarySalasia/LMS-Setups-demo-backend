package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_XOL_ARRANGEMENT_SETUPS table.
 * Likely stores information about XOL arrangement setups.
 */
@Entity
@Table(name = "GIN_XOL_ARRANGEMENT_SETUPS")
@Data
public class GinXolArrangementSetups {

    /**
     * Primary key for the XOL arrangement setup record.
     */
    @Id
    @Column(name = "XAS_CODE", nullable = false, precision = 22)
    private BigDecimal xasCode;

    /**
     * Retention limit.
     */
    @Column(name = "XAS_RETENTION_LIMIT", precision = 22, scale = 5)
    private BigDecimal xasRetentionLimit;

    /**
     * Underwriting year.
     */
    @Column(name = "XAS_UWYR", precision = 22)
    private BigDecimal xasUwyr;

    /**
     * Foreign key from GIN_XOL_TREATY_SETUPS, representing the XOL treaty setup code.
     */
    @Column(name = "XAS_XTA_CODE", nullable = false, precision = 22)
    private BigDecimal xasXtaCode;

    /**
     * Indicates whether the XOL arrangement setup has been authorized (Y/N).
     */
    @Column(name = "XAS_AUTHORIZED", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String xasAuthorized;

    /**
     * User who authorized the setup.
     */
    @Column(name = "XAS_AUTHORIZED_BY", length = 30)
    private String xasAuthorizedBy;

    /**
     * User who prepared the setup.
     */
    @Column(name = "XAS_PREPARED_BY", length = 30)
    private String xasPreparedBy;

    /**
     * Date the setup was prepared.
     */
    @Column(name = "XAS_PREPARED_DATE")
    private LocalDate xasPreparedDate;

    /**
     * Date the setup was authorized.
     */
    @Column(name = "XAS_AUTHORIZED_DATE")
    private LocalDate xasAuthorizedDate;

    /**
     * Currency symbol.
     */
    @Column(name = "XAS_CUR_SYMBOL", length = 20)
    private String xasCurSymbol;

    /**
     * Currency code.
     */
    @Column(name = "XAS_CUR_CODE", precision = 22)
    private BigDecimal xasCurCode;
}
