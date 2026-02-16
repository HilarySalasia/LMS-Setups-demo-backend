package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_PERIL_EXCESS_REVISIONS table.
 * Likely stores information about revisions made to peril excesses associated with claims.
 */
@Entity
@Table(name = "GIN_PERIL_EXCESS_REVISIONS")
@Data
public class GinPerilExcessRevisions {

    /**
     * Primary key for the peril excess revision record.
     */
    @Id
    @Column(name = "PEXR_CODE", nullable = false, precision = 22)
    private BigDecimal pexrCode;

    /**
     * Peril payment code.
     */
    @Column(name = "PEXR_PER_PT_CODE", nullable = false, precision = 22)
    private BigDecimal pexrPerPtCode;

    /**
     * Revision type.
     */
    @Column(name = "PEXR_TYPE", nullable = false, length = 3)
    private String pexrType;

    /**
     * Excess amount.
     */
    @Column(name = "PEXR_EXCESS_AMOUNT", nullable = false, precision = 22, scale = 5)
    private BigDecimal pexrExcessAmount;

    /**
     * Transaction number.
     */
    @Column(name = "PEXR_GGT_TRANS_NO", nullable = false, precision = 22)
    private BigDecimal pexrGgtTransNo;

    /**
     * Business transaction code.
     */
    @Column(name = "PEXR_BTR_TRANS_CODE", nullable = false, length = 10)
    private String pexrBtrTransCode;

    /**
     * Foreign key from GIN_PERIL_REVISIONS, representing the peril revision code.
     */
    @Column(name = "PEXR_PERREV_CODE", nullable = false, precision = 22)
    private BigDecimal pexrPerrevCode;

    /**
     * Claim peril code.
     */
    @Column(name = "PEXR_CLMP_CODE", precision = 22)
    private BigDecimal pexrClmpCode;

    /**
     * Claim excess amount.
     */
    @Column(name = "PEXR_CLAIM_EXCESS_AMT", precision = 22)
    private BigDecimal pexrClaimExcessAmt;
}
