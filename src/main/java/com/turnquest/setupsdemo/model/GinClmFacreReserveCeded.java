package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLM_FACRE_RESERVE_CEDED table.
 * Likely stores information about ceded facultative reinsurance reserve amounts related to claims.
 */
@Entity
@Table(name = "GIN_CLM_FACRE_RESERVE_CEDED")
@Data
public class GinClmFacreReserveCeded {

    /**
     * Primary key for the ceded facultative reinsurance reserve record.
     */
    @Id
    @Column(name = "CFRC_CODE", nullable = false, precision = 22)
    private BigDecimal cfrcCode;

    /**
     * Facultative reinsurance code.
     */
    @Column(name = "CFRC_FC_CODE", precision = 22)
    private BigDecimal cfrcFcCode;

    /**
     * Foreign Key from GIN_CLAIM_MASTER_BOOKINGS for claim number.
     */
    @Column(name = "CFRC_CMB_CLAIM_NO", nullable = false, length = 25)
    private String cfrcCmbClaimNo;

    /**
     * Foreign Key from TQC_AGENCIES for agent code.
     */
    @Column(name = "CFRC_AGNT_AGENT_CODE", nullable = false, precision = 22)
    private BigDecimal cfrcAgntAgentCode;

    /**
     * Agent short description.
     */
    @Column(name = "CFRC_AGENT_SHT_DESC", nullable = false, length = 15)
    private String cfrcAgentShtDesc;

    /**
     * Facultative reinsurance reserve amount.
     */
    @Column(name = "CFRC_AMOUNT", precision = 27, scale = 5)
    private BigDecimal cfrcAmount;

    /**
     * Underwriting year.
     */
    @Column(name = "CFRC_UWYR", nullable = false, precision = 22)
    private BigDecimal cfrcUwyr;

    /**
     * Cession rate.
     */
    @Column(name = "CFRC_RATE", precision = 22, scale = 5)
    private BigDecimal cfrcRate;

    /**
     * Foreign Key from GIN_ACC_PERIODS for accounting period.
     */
    @Column(name = "CFRC_ACPR_CODE", precision = 22)
    private BigDecimal cfrcAcprCode;

    /**
     * Accounting period short description.
     */
    @Column(name = "CFRC_ACPR_SHT_DESC", length = 15)
    private String cfrcAcprShtDesc;

    /**
     * Policy batch number.
     */
    @Column(name = "CFRC_POL_BATCH_NO", precision = 22)
    private BigDecimal cfrcPolBatchNo;

    /**
     * Foreign key from GIN_SUB_CLASSES, representing the subclass code.
     */
    @Column(name = "CFRC_SCL_CODE", precision = 22)
    private BigDecimal cfrcSclCode;

    /**
     * Policy currency code.
     */
    @Column(name = "CFRC_POL_CUR_CODE", precision = 22)
    private BigDecimal cfrcPolCurCode;

    /**
     * Policy currency symbol.
     */
    @Column(name = "CFRC_POL_CUR_SYMBOL", length = 15)
    private String cfrcPolCurSymbol;

    /**
     * Foreign key from GIN_CLAIM_REVISIONS, representing the claim revision code.
     */
    @Column(name = "CFRC_CLMREV_CODE", precision = 22)
    private BigDecimal cfrcClmrevCode;

    /**
     * Transaction number.
     */
    @Column(name = "CFRC_GGT_TRANS_NO", nullable = false, precision = 22)
    private BigDecimal cfrcGgtTransNo;

    /**
     * Facultative reinsurance reserve amount in base currency.
     */
    @Column(name = "CFRC_AMOUNT_BCUR", precision = 27, scale = 5)
    private BigDecimal cfrcAmountBcur;

    /**
     * Facultative reinsurance type (N = Normal, P = Pool).
     */
    @Column(name = "CFRC_FACRE_TYPE", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String cfrcFacreType;
}