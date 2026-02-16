package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLAIM_RECOVER_PERILS table.
 * Stores the apportionments of any claim recovery/salvage to the various perils on a claim.
 */
@Entity
@Table(name = "GIN_CLAIM_RECOVER_PERILS")
@Data
public class GinClaimRecoverPerils {

    /**
     * Foreign key from GIN_CLAIM_RECOVERIES, representing the claim recovery code.
     */
    @Column(name = "CRPER_CLMR_CODE", nullable = false, precision = 22)
    private BigDecimal crperClmrCode;

    /**
     * Peril code.
     */
    @Column(name = "CRPER_PER_CODE", nullable = false, precision = 22)
    private BigDecimal crperPerCode;

    /**
     * Foreign key from GIN_RGSTD_CLAIMANTS, representing the registered claimant code.
     */
    @Column(name = "CRPER_REG_CLMT_CODE", nullable = false, precision = 22)
    private BigDecimal crperRegClmtCode;

    /**
     * Registered claimant type.
     */
    @Column(name = "CRPER_REG_CLMT_TYPE", nullable = false, length = 1)
    private String crperRegClmtType;

    /**
     * Apportioned amount.
     */
    @Column(name = "CRPER_AMT", nullable = false, precision = 23, scale = 5)
    private BigDecimal crperAmt;

    /**
     * Short description of the peril payment.
     */
    @Column(name = "CRPER_PER_PT_SHT_DESC", length = 20)
    private String crperPerPtShtDesc;

    /**
     * Peril type (P = Primary, S = Secondary).
     */
    @Column(name = "CRPER_TYPE", length = 3, columnDefinition = "VARCHAR2(3) default 'P'")
    private String crperType;

    /**
     * Peril description.
     */
    @Column(name = "CRPER_PER_DESC", length = 50)
    private String crperPerDesc;

    /**
     * Total apportioned amount.
     */
    @Column(name = "CRPER_TOTAL_AMOUNT", precision = 23, scale = 5)
    private BigDecimal crperTotalAmount;

    /**
     * Apportioned amount in base currency.
     */
    @Column(name = "CRPER_AMT_BCUR", precision = 22, scale = 5)
    private BigDecimal crperAmtBcur;

    /**
     * Total apportioned amount in base currency.
     */
    @Column(name = "CRPER_TOTAL_AMOUNT_BCUR", precision = 23, scale = 5)
    private BigDecimal crperTotalAmountBcur;

    /**
     * Foreign key from GIN_CLAIM_PERILS, representing the claim peril code.
     */
    @Column(name = "CRPER_CLMP_CODE", precision = 22)
    private BigDecimal crperClmpCode;

    /**
     * Primary key for the claim recover peril record.
     */
    @Id
    @Column(name = "CRPER_CODE", nullable = false, precision = 22)
    private BigDecimal crperCode;

    /**
     * VAT amount.
     */
    @Column(name = "CRPER_VAT_AMT", precision = 22, scale = 5)
    private BigDecimal crperVatAmt;
}