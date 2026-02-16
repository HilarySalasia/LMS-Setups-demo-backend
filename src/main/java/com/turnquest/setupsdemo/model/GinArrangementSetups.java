package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This table stores details of annual reinsurance arrangements or agreements.
 */
@Entity
@Table(name = "GIN_ARRANGEMENT_SETUPS")
@Data
public class GinArrangementSetups {
    /**
 * Table primary Key
 */
@Id
@Column(name = "AS_CODE", nullable = false, precision = 22)
private Long asCode;

/**
 * Treaty Retention limit
 */
@Column(name = "AS_RETENTION_LIMIT", precision = 22, scale = 5)
private BigDecimal asRetentionLimit;

/**
 * Treaty Underwriting year
 */
@Column(name = "AS_UWYR", precision = 22)
private Long asUwyr;

/**
 * Foreign Key referencing GIN\_TREATY\_ARRANGEMENTS
 */
@Column(name = "AS_TA_CODE", nullable = false, precision = 22)
private Long asTaCode;

/**
 * Status, 'A', -authorized, 'N' -Not authorized
 */
@Column(name = "AS_STATUS", length = 1)
private String asStatus;

/**
 * Status checked by
 */
@Column(name = "AS_STATUA_BY", length = 30)
private String asStatuaBy;

/**
 * Status update date
 */
@Column(name = "AS_STATUS_DATE")
private Date asStatusDate;

/**
 * Audit trail of who did the record
 */
@Column(name = "AS_DONE_BY", length = 30)
private String asDoneBy;

/**
 * Date when the record was done
 */
@Column(name = "AS_DATE_DONE")
private Date asDateDone;

/**
 * Facre obligatory limit
 */
@Column(name = "AS_FAC_OBLIG_LIMIT", precision = 22)
private Long asFacObligLimit;

/**
 * Reference Key to TQC\_AGENCIES
 */
@Column(name = "AS_AGN_CODE", precision = 22)
private Long asAgnCode;
}