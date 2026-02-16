package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIS_VALUATION_DTLS table.
 * Likely stores details about valuations performed within the GIS system.
 */
@Entity
@Table(name = "GIS_VALUATION_DTLS")
@Data
public class GisValuationDtls {

    /**
     * Primary key for the valuation details record.
     */
    @Id
    @Column(name = "VDT_CODE", nullable = false, precision = 22, scale = 5)
    private BigDecimal vdtCode;

    /**
     * Valuation code.
     */
    @Column(name = "VDT_VLT_CODE", precision = 22, scale = 5)
    private BigDecimal vdtVltCode;

    /**
     * Policy batch number.
     */
    @Column(name = "VDT_POL_BATCH_NO", precision = 22, scale = 5)
    private BigDecimal vdtPolBatchNo;

    /**
     * IPU code.
     */
    @Column(name = "VDT_IPU_CODE", precision = 22, scale = 5)
    private BigDecimal vdtIpuCode;

    /**
     * Risk ID.
     */
    @Column(name = "VDT_RISK_ID", length = 50)
    private String vdtRiskId;

    /**
     * Risk description.
     */
    @Column(name = "VDT_RISK_DESC", length = 50)
    private String vdtRiskDesc;

    /**
     * Initial sum insured.
     */
    @Column(name = "VDT_INITIAL_SI", precision = 22, scale = 5)
    private BigDecimal vdtInitialSi;

    /**
     * Indicates whether the valuation has been received.
     */
    @Column(name = "VLT_RECEIVED", length = 1)
    private String vltReceived;

    /**
     * Valued sum insured.
     */
    @Column(name = "VDT_VALUATED_SI", precision = 22, scale = 5)
    private BigDecimal vdtValuatedSi;

    /**
     * Date the valuation was received.
     */
    @Column(name = "VDT_RECEIVE_DT")
    private LocalDate vdtReceiveDt;

    /**
     * Property code.
     */
    @Column(name = "VDT_PRP_CODE", precision = 22, scale = 5)
    private BigDecimal vdtPrpCode;

    /**
     * Indicates whether the valuation has been received.
     */
    @Column(name = "VDT_RECEIVED", length = 1)
    private String vdtReceived;

    /**
     * Assessment date.
     */
    @Column(name = "VDT_ASSMENT_DT")
    private LocalDate vdtAssmentDt;

    /**
     * Action to be taken.
     */
    @Column(name = "VDT_ACTION_TODO", length = 100)
    private String vdtActionTodo;

    /**
     * Remarks related to the valuation.
     */
    @Column(name = "VDT_REMARKS", length = 2000)
    private String vdtRemarks;

    /**
     * Document name.
     */
    @Column(name = "VDT_DOC_NAME", length = 50)
    private String vdtDocName;

    /**
     * Document path.
     */
    @Column(name = "VDT_DOC_PATH", length = 100)
    private String vdtDocPath;

    /**
     * Indicates whether a document is attached (Y/N).
     */
    @Column(name = "VDT_DOC_ATTACHED", length = 1)
    private String vdtDocAttached;

    /**
     * Underwriting year for the risk.
     */
    @Column(name = "VDT_RISK_UW_YR", precision = 22)
    private BigDecimal vdtRiskUwYr;

    /**
     * IPU ID.
     */
    @Column(name = "VDT_IPU_ID", precision = 22)
    private BigDecimal vdtIpuId;

    /**
     * Valuation status.
     */
    @Column(name = "VDT_VAL_STATUS", length = 1, columnDefinition = "VARCHAR2(1) default 'Y'")
    private String vdtValStatus;

    /**
     * Valuation number.
     */
    @Column(name = "VDT_VALUATION_NO", length = 30)
    private String vdtValuationNo;

    /**
     * Previous valued sum insured.
     */
    @Column(name = "VDT_PREV_VAL_SI", precision = 22)
    private BigDecimal vdtPrevValSi;

    /**
     * Reason for cancellation.
     */
    @Column(name = "VDT_VAL_REASON_CANCELLED", length = 200)
    private String vdtValReasonCancelled;

    /**
     * Survey date.
     */
    @Column(name = "VDT_SURV_DT")
    private LocalDate vdtSurvDt;

    /**
     * Memo.
     */
    @Column(name = "VDT_MEMO", length = 2000)
    private String vdtMemo;

    /**
     * QR code.
     */
    @Column(name = "VDT_QR_CODE", precision = 22)
    private BigDecimal vdtQrCode;

    /**
     * Quotation code.
     */
    @Column(name = "VDT_QUOT_CODE", precision = 22)
    private BigDecimal vdtQuotCode;

    /**
     * Modification level.
     */
    @Column(name = "VDT_MOD_LEVEL", length = 1)
    private String vdtModLevel;

    /**
     * Expected completion date.
     */
    @Column(name = "VDT_EXP_COMP_DATE")
    private LocalDate vdtExpCompDate;

    /**
     * Indicates whether risk improvement is required (Y/N).
     */
    @Column(name = "VDT_RISK_IMPROVEMENT_REQUIRED", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String vdtRiskImprovementRequired;

    /**
     * Amount.
     */
    @Column(name = "VDT_AMOUNT", precision = 22, scale = 5)
    private BigDecimal vdtAmount;

    /**
     * Rate.
     */
    @Column(name = "VDT_RATE", precision = 22, scale = 5)
    private BigDecimal vdtRate;

    /**
     * Initial premium.
     */
    @Column(name = "VDT_INITIAL_PREM", precision = 22, scale = 5)
    private BigDecimal vdtInitialPrem;

    /**
     * Co-valuation fee.
     */
    @Column(name = "VDT_COVALUATION_FEE", precision = 22)
    private BigDecimal vdtCovaluationFee;

    /**
     * Landing status.
     */
    @Column(name = "VDT_LANDING_STATUS", length = 30)
    private String vdtLandingStatus;

    /**
     * Shipping status.
     */
    @Column(name = "VDT_SHIPPING_STATUS", length = 30)
    private String vdtShippingStatus;

    /**
     * Shipping percentage.
     */
    @Column(name = "VDT_SHIPPING_PERC", precision = 22)
    private BigDecimal vdtShippingPerc;

    /**
     * Payment of own share.
     */
    @Column(name = "VDT_PAY_OWN_SHARE", length = 5)
    private String vdtPayOwnShare;

    /**
     * Own share amount.
     */
    @Column(name = "VDT_OWN_SHARE", precision = 22, scale = 5)
    private BigDecimal vdtOwnShare;

    /**
     * Amount or percentage.
     */
    @Column(name = "VDT_AMT_OR_PERC", length = 1)
    private String vdtAmtOrPerc;

    /**
     * Co-valuation rate.
     */
    @Column(name = "VDT_COVALUATION_RATE", precision = 23, scale = 5)
    private BigDecimal vdtCovaluationRate;
}
