package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLAIM_XOL_REV_DETAILS table.
 * Likely stores details about XOL revisions related to claims.
 */
@Entity
@Table(name = "GIN_CLAIM_XOL_REV_DETAILS")
@Data
public class GinClaimXolRevDetails {

    /**
     * Primary key for the XOL revision detail record.
     */
    @Id
    @Column(name = "CXRD_CODE", nullable = false, precision = 22)
    private BigDecimal cxrdCode;

    /**
     * XOLS code.
     */
    @Column(name = "CXRD_XOLS_CODE", precision = 22)
    private BigDecimal cxrdXolsCode;

    /**
     * Claim number.
     */
    @Column(name = "CXRD_CLM_NO", nullable = false, length = 50)
    private String cxrdClmNo;

    /**
     * Amount.
     */
    @Column(name = "CXRD_AMOUNT", precision = 23, scale = 5)
    private BigDecimal cxrdAmount;

    /**
     * Subclass code.
     */
    @Column(name = "CXRD_SCL_CODE", precision = 22)
    private BigDecimal cxrdSclCode;

    /**
     * Event code.
     */
    @Column(name = "CXRD_EVE_CODE", precision = 22)
    private BigDecimal cxrdEveCode;

    /**
     * Event short description.
     */
    @Column(name = "CXRD_EVE_SHT_DESC", length = 50)
    private String cxrdEveShtDesc;

    /**
     * Amount to be ceded.
     */
    @Column(name = "CXRD_AMT_TO_CEDE", precision = 23, scale = 5)
    private BigDecimal cxrdAmtToCede;

    /**
     * Date.
     */
    @Column(name = "CXRD_DATE")
    private LocalDate cxrdDate;

    /**
     * XAS code.
     */
    @Column(name = "CXRD_XAS_CODE", precision = 22)
    private BigDecimal cxrdXasCode;

    /**
     * XOL code.
     */
    @Column(name = "CXRD_XOL_CODE", precision = 22)
    private BigDecimal cxrdXolCode;

    /**
     * Excess amount.
     */
    @Column(name = "CXRD_EXCESS_AMT", precision = 23, scale = 5)
    private BigDecimal cxrdExcessAmt;

    /**
     * Authorized.
     */
    @Column(name = "CXRD_AUTHORIZED", length = 2)
    private String cxrdAuthorized;

    /**
     * Authorization date.
     */
    @Column(name = "CXRD_DATE_AUTH")
    private LocalDate cxrdDateAuth;

    /**
     * Claim year.
     */
    @Column(name = "CXRD_CLM_YEAR", precision = 22)
    private BigDecimal cxrdClmYear;

    /**
     * Previous code.
     */
    @Column(name = "CXRD_PREV_CODE", precision = 22)
    private BigDecimal cxrdPrevCode;

    /**
     * Status.
     */
    @Column(name = "CXRD_STATUS", length = 3)
    private String cxrdStatus;

    /**
     * Company retention amount.
     */
    @Column(name = "CXRD_COMP_RET_AMT", precision = 23, scale = 5)
    private BigDecimal cxrdCompRetAmt;

    /**
     * Foreign key to the GIN_CLAIM_XOL_REVISIONS table, representing the XOL revision code.
     */
    @Column(name = "CXRD_CXR_CODE", precision = 22)
    private BigDecimal cxrdCxrCode;

    /**
     * Transaction number.
     */
    @Column(name = "CXRD_GGT_TRANS_NO", precision = 22)
    private BigDecimal cxrdGgtTransNo;
}