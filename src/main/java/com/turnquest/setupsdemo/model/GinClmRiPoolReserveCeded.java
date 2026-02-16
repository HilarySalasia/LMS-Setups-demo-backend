package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLM_RI_POOL_RESERVE_CEDED table.
 * Likely stores information about ceded reinsurance pool reserve amounts related to claims.
 */
@Entity
@Table(name = "GIN_CLM_RI_POOL_RESERVE_CEDED")
@Data
public class GinClmRiPoolReserveCeded {

    /**
     * Primary key for the ceded reinsurance pool reserve record.
     */
    @Id
    @Column(name = "CRPRC_CODE", nullable = false, precision = 22)
    private BigDecimal crprcCode;

    /**
     * Foreign Key from GIN_CLAIM_MASTER_BOOKINGS for claim number.
     */
    @Column(name = "CRPRC_CMB_CLAIM_NO", nullable = false, length = 25)
    private String crprcCmbClaimNo;

    /**
     * Underwriting year.
     */
    @Column(name = "CRPRC_UWYR", nullable = false, precision = 22)
    private BigDecimal crprcUwyr;

    /**
     * Cession rate.
     */
    @Column(name = "CRPRC_RATE", precision = 23, scale = 5)
    private BigDecimal crprcRate;

    /**
     * Policy batch number.
     */
    @Column(name = "CRPRC_POL_BATCH_NO", precision = 22)
    private BigDecimal crprcPolBatchNo;

    /**
     * Subclass code.
     */
    @Column(name = "CRPRC_SCL_CODE", precision = 22)
    private BigDecimal crprcSclCode;

    /**
     * IPU code.
     */
    @Column(name = "CRPRC_IPU_CODE", precision = 22)
    private BigDecimal crprcIpuCode;

    /**
     * Foreign key from GIN_CLAIM_REVISIONS, representing the claim revision code.
     */
    @Column(name = "CRPRC_CLMREV_CODE", nullable = false, precision = 22)
    private BigDecimal crprcClmrevCode;

    /**
     * Foreign key from GIN_GIS_TRANSACTIONS, representing the transaction number.
     */
    @Column(name = "CRPRC_GGT_TRANS_NO", nullable = false, precision = 22)
    private BigDecimal crprcGgtTransNo;

    /**
     * Currency code.
     */
    @Column(name = "CRPRC_CUR_CODE", precision = 22)
    private BigDecimal crprcCurCode;

    /**
     * Currency symbol.
     */
    @Column(name = "CRPRC_CUR_SYMBOL", length = 15)
    private String crprcCurSymbol;

    /**
     * Ceded amount.
     */
    @Column(name = "CRPRC_AMT", precision = 23, scale = 5)
    private BigDecimal crprcAmt;

    /**
     * Premium rate period code.
     */
    @Column(name = "CRPRC_PRPRD_CODE", precision = 22)
    private BigDecimal crprcPrprdCode;

    /**
     * Foreign key to the GIN_CLAIM_REIN_POOL_CESSIONS table, representing the reinsurance pool cession code.
     */
    @Column(name = "CRPRC_CRPC_CODE", precision = 22)
    private BigDecimal crprcCrpcCode;

    /**
     * Claim payment code.
     */
    @Column(name = "CRPRC_CLMP_CODE", precision = 22)
    private BigDecimal crprcClmpCode;
}