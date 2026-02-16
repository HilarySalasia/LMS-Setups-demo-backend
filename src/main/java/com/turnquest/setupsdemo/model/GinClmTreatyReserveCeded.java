package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLM_TREATY_RESERVE_CEDED table.
 * Likely stores information about ceded treaty reserve amounts related to claims.
 */
@Entity
@Table(name = "GIN_CLM_TREATY_RESERVE_CEDED")
@Data
public class GinClmTreatyReserveCeded {

    /**
     * Primary key for the ceded treaty reserve record.
     */
    @Id
    @Column(name = "CTRC_CODE", nullable = false, precision = 22)
    private BigDecimal ctrcCode;

    /**
     * Reinsurance code.
     */
    @Column(name = "CTRC_REI_CODE", nullable = false, precision = 22)
    private BigDecimal ctrcReiCode;

    /**
     * Foreign Key from GIN_CLAIM_MASTER_BOOKINGS for claim number.
     */
    @Column(name = "CTRC_CMB_CLAIM_NO", nullable = false, length = 50)
    private String ctrcCmbClaimNo;

    /**
     * Treaty amount in policy currency.
     */
    @Column(name = "CTRC_TRT_AMT_PCUR", precision = 27, scale = 5)
    private BigDecimal ctrcTrtAmtPcur;

    /**
     * Treaty amount in treaty currency.
     */
    @Column(name = "CTRC_TRT_AMT_TCUR", precision = 27, scale = 5)
    private BigDecimal ctrcTrtAmtTcur;

    /**
     * Underwriting year.
     */
    @Column(name = "CTRC_UWYR", nullable = false, precision = 22)
    private BigDecimal ctrcUwyr;

    /**
     * Cession rate.
     */
    @Column(name = "CTRC_RATE", precision = 22, scale = 5)
    private BigDecimal ctrcRate;

    /**
     * Foreign Key from GIN_ACC_PERIODS for accounting period.
     */
    @Column(name = "CTRC_ACPR_CODE", precision = 22)
    private BigDecimal ctrcAcprCode;

    /**
     * Accounting period short description.
     */
    @Column(name = "CTRC_ACPR_SHT_DESC", length = 15)
    private String ctrcAcprShtDesc;

    /**
     * Policy batch number.
     */
    @Column(name = "CTRC_POL_BATCH_NO", precision = 22)
    private BigDecimal ctrcPolBatchNo;

    /**
     * Foreign key from GIN_SUB_CLASSES, representing the subclass code.
     */
    @Column(name = "CTRC_SCL_CODE", precision = 22)
    private BigDecimal ctrcSclCode;

    /**
     * Policy currency code.
     */
    @Column(name = "CTRC_POL_CUR_CODE", precision = 22)
    private BigDecimal ctrcPolCurCode;

    /**
     * Treaty currency code.
     */
    @Column(name = "CTRC_TRT_CUR_CODE", precision = 22)
    private BigDecimal ctrcTrtCurCode;

    /**
     * Policy currency symbol.
     */
    @Column(name = "CTRC_POL_CUR_SYMBOL", length = 15)
    private String ctrcPolCurSymbol;

    /**
     * Treaty currency symbol.
     */
    @Column(name = "CTRC_TRT_CUR_SYMBOL", length = 15)
    private String ctrcTrtCurSymbol;

    /**
     * Treaty reserve code.
     */
    @Column(name = "CTRC_TRS_CODE", nullable = false, precision = 22)
    private BigDecimal ctrcTrsCode;

    /**
     * Foreign key from GIN_CLAIM_REVISIONS, representing the claim revision code.
     */
    @Column(name = "CTRC_CLMREV_CODE", precision = 22)
    private BigDecimal ctrcClmrevCode;

    /**
     * Treaty reserve short description.
     */
    @Column(name = "CTRC_REI_TRS_SHT_DESC", length = 20)
    private String ctrcReiTrsShtDesc;

    /**
     * Transaction number.
     */
    @Column(name = "CTRC_GGT_TRANS_NO", nullable = false, precision = 22)
    private BigDecimal ctrcGgtTransNo;
}