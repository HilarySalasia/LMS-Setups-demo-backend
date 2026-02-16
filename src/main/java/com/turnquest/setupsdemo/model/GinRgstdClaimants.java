package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_RGSTD_CLAIMANTS table.
 * Likely stores information about registered claimants and their claim details.
 */
@Entity
@Table(name = "GIN_RGSTD_CLAIMANTS")
@Data
public class GinRgstdClaimants {

    /**
     * Date the claimant was registered.
     */
    @Column(name = "REG_CLMNT_DATE")
    private LocalDate regClmntDate;

    /**
     * Amount associated with the claimant registration.
     */
    @Column(name = "REG_CLMNT_AMOUNT", precision = 22)
    private BigDecimal regClmntAmount;

    /**
     * Foreign key from GIN_CLAIM_MASTER_BOOKINGS, representing the claim number.
     */
    @Column(name = "REG_CMB_CLAIM_NO", nullable = false, length = 40)
    private String regCmbClaimNo;

    /**
     * Claimant code.
     */
    @Column(name = "REG_CLD_CODE", nullable = false, precision = 22)
    private BigDecimal regCldCode;

    /**
     * Primary key for the claimant registration.
     */
    @Id
    @Column(name = "REG_CLMT_CODE", nullable = false, precision = 22)
    private BigDecimal regClmtCode;

    /**
     * Admissible amount for the claim.
     */
    @Column(name = "REG_ADMISSIBLE_AMT", precision = 22, scale = 5)
    private BigDecimal regAdmissibleAmt;

    /**
     * Status of the claim.
     */
    @Column(name = "REG_CLAIM_STATUS", length = 1)
    private String regClaimStatus;

    /**
     * Indicates whether the claim is for a third party (Y/N).
     */
    @Column(name = "REG_THIRD_PARTY", nullable = false, length = 1)
    private String regThirdParty;

    /**
     * Balance associated with the claim.
     */
    @Column(name = "REG_BALANCE", precision = 22, scale = 5)
    private BigDecimal regBalance;

    /**
     * Reference number associated with the claim.
     */
    @Column(name = "REG_REF_NO", length = 30)
    private String regRefNo;

    /**
     * Case number associated with the claim.
     */
    @Column(name = "REG_CASE_NO", length = 30)
    private String regCaseNo;

    /**
     * Reason for the claim.
     */
    @Column(name = "REG_CLAIM_REASON", length = 150)
    private String regClaimReason;

    /**
     * Division status related to the claim.
     */
    @Column(name = "REG_DIV_STATUS", length = 200)
    private String regDivStatus;

    /**
     * Division number associated with the claim.
     */
    @Column(name = "REG_DIV_NO", length = 200)
    private String regDivNo;

    /**
     * Communication code associated with the claim.
     */
    @Column(name = "REG_COMM_CODE", length = 50)
    private String regCommCode;

    /**
     * Payment mode associated with the claim.
     */
    @Column(name = "REG_PAYMENT_MODE", length = 50)
    private String regPaymentMode;

    /**
     * Date liability was admitted.
     */
    @Column(name = "REG_ADMIT_LIAB_DATE")
    private LocalDate regAdmitLiabDate;

    /**
     * Indicates whether liability has been admitted (Y/N).
     */
    @Column(name = "REG_ADMIT_LIABILITY", length = 1)
    private String regAdmitLiability;

    /**
     * Indicates whether liability admission was conditional (Y/N).
     */
    @Column(name = "REG_LIABILITY_ADMIT_CONDTIONAL", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String regLiabilityAdmitCondtional;
}
