package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_RGSTD_CLMTS_DV table.
 * Likely stores information about division details for registered claimants.
 */
@Entity
@Table(name = "GIN_RGSTD_CLMTS_DV")
@Data
public class GinRgstdClmtsDv {

    /**
     * Primary key for the registered claimant division record.
     */
    @Id
    @Column(name = "RGCLD_CODE", nullable = false, precision = 22)
    private BigDecimal rgCldCode;

    /**
     * Division number for the claimant.
     */
    @Column(name = "RGCLD_DIV_NO", length = 20)
    private String rgCldDivNo;

    /**
     * Division status.
     */
    @Column(name = "RGCLD_DIV_STATUS", precision = 22)
    private BigDecimal rgCldDivStatus;

    /**
     * Foreign key from GIN_RGSTD_CLAIMANTS, representing the claimant code.
     */
    @Column(name = "RCLD_CLMT_CODE", precision = 22)
    private BigDecimal rCldClmtCode;

    /**
     * Foreign key from GIN_DV_TRANSACTION_TYPES, representing the transaction type code.
     */
    @Column(name = "RGCLD_DTT_CODE", precision = 22)
    private BigDecimal rgCldDttCode;

    /**
     * Invoice number associated with the division.
     */
    @Column(name = "RGCLD_INV_NO", length = 30)
    private String rgCldInvNo;

    /**
     * Date the division record was received.
     */
    @Column(name = "RGCLD_REC_DT")
    private LocalDate rgCldRecDt;

    /**
     * Date associated with the division.
     */
    @Column(name = "RGCLD_DATE")
    private LocalDate rgCldDate;
}
