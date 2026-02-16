package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLAIM_XOL_REVISIONS table.
 * Stores information about revisions made to XOL amounts related to claims.
 */
@Entity
@Table(name = "GIN_CLAIM_XOL_REVISIONS")
@Data
public class GinClaimXolRevisions {

    /**
     * Primary key for the XOL revision record.
     */
    @Id
    @Column(name = "CXR_CODE", nullable = false, precision = 22)
    private BigDecimal cxrCode;

    /**
     * Event code.
     */
    @Column(name = "CXR_EVE_CODE", nullable = false, precision = 22)
    private BigDecimal cxrEveCode;

    /**
     * Revision date.
     */
    @Column(name = "CXR_DATE", nullable = false)
    private LocalDate cxrDate;

    /**
     * Claim number.
     */
    @Column(name = "CXR_CLAIM_NO", nullable = false, length = 30)
    private String cxrClaimNo;

    /**
     * Transaction number.
     */
    @Column(name = "CXR_GGT_TRANS_NO", nullable = false, precision = 22)
    private BigDecimal cxrGgtTransNo;

    /**
     * XOL amount.
     */
    @Column(name = "CXR_AMOUNT", nullable = false, precision = 23, scale = 5)
    private BigDecimal cxrAmount;

    /**
     * Change amount.
     */
    @Column(name = "CXR_CHANGE_AMOUNT", precision = 23, scale = 5)
    private BigDecimal cxrChangeAmount;

    /**
     * Claim year.
     */
    @Column(name = "CXR_CLAIM_YEAR", nullable = false, precision = 22)
    private BigDecimal cxrClaimYear;

    /**
     * Gross company retention amount.
     */
    @Column(name = "CXR_GROSS_COMP_RET_AMOUNT", precision = 23, scale = 5)
    private BigDecimal cxrGrossCompRetAmount;

    /**
     * Indicates whether the XOL revision has been authorized (Y/N).
     */
    @Column(name = "CXR_AUTHORIZED", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String cxrAuthorized;

    /**
     * User who authorized the revision.
     */
    @Column(name = "CXR_AUTHORIZED_BY", length = 30)
    private String cxrAuthorizedBy;

    /**
     * Subclass code.
     */
    @Column(name = "CXR_SCL_CODE", nullable = false, precision = 22)
    private BigDecimal cxrSclCode;

    /**
     * Authorization date.
     */
    @Column(name = "CXR_AUTHORIZED_DATE")
    private LocalDate cxrAuthorizedDate;

    /**
     * Currency code.
     */
    @Column(name = "CXR_CUR_CODE", precision = 22)
    private BigDecimal cxrCurCode;

    /**
     * Indicates whether the XOL has been recomputed (Y/N).
     */
    @Column(name = "CXR_RECOMPUTED", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String cxrRecomputed;
}