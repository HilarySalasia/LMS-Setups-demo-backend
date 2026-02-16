package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_PERIL_REVISIONS table.
 * Likely stores information about revisions made to perils associated with claims.
 */
@Entity
@Table(name = "GIN_PERIL_REVISIONS")
@Data
public class GinPerilRevisions {

    /**
     * Primary key for the peril revision record.
     */
    @Id
    @Column(name = "PERREV_CODE", nullable = false, precision = 22)
    private BigDecimal perrevCode;

    /**
     * Peril code.
     */
    @Column(name = "PERREV_PER_CODE", nullable = false, precision = 22)
    private BigDecimal perrevPerCode;

    /**
     * Revision type.
     */
    @Column(name = "PERREV_TYPE", nullable = false, length = 3)
    private String perrevType;

    /**
     * Revision amount.
     */
    @Column(name = "PERREV_AMOUNT", nullable = false, precision = 22, scale = 5)
    private BigDecimal perrevAmount;

    /**
     * Transaction number.
     */
    @Column(name = "PERREV_GGT_TRANS_NO", nullable = false, precision = 22)
    private BigDecimal perrevGgtTransNo;

    /**
     * Business transaction code.
     */
    @Column(name = "PERREV_BTR_TRANS_CODE", nullable = false, length = 10)
    private String perrevBtrTransCode;

    /**
     * Foreign key from GIN_CLAIM_REVISIONS, representing the claim revision code.
     */
    @Column(name = "PERREV_CLMREV_CODE", nullable = false, precision = 22)
    private BigDecimal perrevClmrevCode;

    /**
     * Coinsurance amount.
     */
    @Column(name = "PERREV_COIN_AMNT", precision = 22, scale = 5)
    private BigDecimal perrevCoinAmnt;

    /**
     * Foreign key from GIN_CLAIM_PERILS, representing the claim peril code.
     */
    @Column(name = "PERREV_CLMP_CODE", precision = 22)
    private BigDecimal perrevClmpCode;

    /**
     * Liability admission.
     */
    @Column(name = "PERREV_LIAB_ADMISSION", length = 1)
    private String perrevLiabAdmission;

    /**
     * Liability date.
     */
    @Column(name = "PERREV_LIAB_DATE")
    private LocalDate perrevLiabDate;
}