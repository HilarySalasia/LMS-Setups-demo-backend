package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

/**
 * This table stores details of policies related to specific business units.
 */
@Entity
@Table(name = "GIN_POLICY_SBU_DTLS")
@Data
public class GinPolicySbuDtls {
    /**
     * Primary key for the table.
     */
    @Id
    @Column(name = "PDL_CODE", nullable = false, precision = 22)
    private Long pdlCode;

    /**
     * Foreign key referencing the policy batch number.
     */
    @Column(name = "PDL_POL_BATCH_NO", nullable = false, precision = 22)
    private Long pdlPolBatchNo;

    /**
     * Unit code associated with the policy.
     */
    @Column(name = "PDL_UNIT_CODE", precision = 22)
    private Long pdlUnitCode;

    /**
     * Location code associated with the policy.
     */
    @Column(name = "PDL_LOCATION_CODE", precision = 22)
    private Long pdlLocationCode;

    /**
     * Date Policy Was Prepared.
     */
    @Column(name = "PDL_PREPARED_DATE")
    private Date pdlPreparedDate;

    /**
     * User who prepared the policy details.
     */
    @Column(name = "PDL_PREPARED_BY", length = 50)
    private String pdlPreparedBy;
}