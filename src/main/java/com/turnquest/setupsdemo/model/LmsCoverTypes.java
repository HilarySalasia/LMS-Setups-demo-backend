package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * This class represents the LmsCoverTypes entity.
 * It maps to the lms_cover_types table in the database.
 */
@Data
@Entity
@Table(name = "lms_cover_types")
public class LmsCoverTypes {
    /**
     * The unique identifier for a cover type.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lms_cover_types_seq")
    @SequenceGenerator(name = "lms_cover_types_seq", sequenceName = "lms_cvt_code_seq", allocationSize = 1)
    @Column(name="CVT_CODE")
    private Long cvtCode;

    /**
     * The short description of a cover type.
     */
    private String cvtShtDesc= null;

    /**
     * The main cover of a cover type.
     */
    private String cvtMainCover= null;

    /**
     * The description of a cover type.
     */
    @Column(name = "CVT_DESC")
    private String cvtDesc= null;

    /**
     * The product specific rate of a cover type.
     */
    @Column(name = "CVT_RATE_PROD_SPECIFC")
    private String cvtRateProdSpecifc= null;

    /**
     * The duration type of a cover type.
     */
    @Column(name = "CVT_DURATION_TYPE")
    private String cvtDurationType= null;

    /**
     * The read from of a cover type.
     */
    @Column(name = "CVT_READ_FROM")
    private String cvtReadFrom= null;

    /**
     * The remarks of a cover type.
     */
    @Column(name = "CVT_REMARKS")
    private String cvtRemarks= null;

    /**
     * The maximum age of a cover type.
     */
    @Column(name = "CVT_MAX_AGE")
    private BigDecimal cvtMaxAge= null;

    /**
     * The multiplier of a cover type.
     */
    @Column(name = "CVT_MULTIPLIER")
    private BigDecimal cvtMultiplier= null;

    /**
     * The multiply divide factor of a cover type.
     */
    @Column(name = "CVT_MULT_DIV_FACT")
    private BigDecimal cvtMultDivFact= null;

    /**
     * The rate type of a cover type.
     */
    @Column(name = "CVT_RATE_TYPE")
    private String cvtRateType= null;

    /**
     * The report name of a cover type.
     */
    @Column(name = "CVT_REPORT_NAME")
    private String cvtReportName= null;

    /**
     * The pay benefit of a cover type.
     */
    @Column(name = "CVT_PAY_BEN")
    private String cvtPayBen= null;

    /**
     * The rates frequency of payment of a cover type.
     */
    @Column(name = "CVT_RATES_FREQ_OF_PYMT")
    private String cvtRatesFreqOfPymt= null;

    /**
     * The minimum employment period of a cover type.
     */
    @Column(name = "CVT_MIN_EMP_PRD")
    private BigDecimal cvtMinEmpPrd= null;

    /**
     * The class code of a cover type.
     */
    @Column(name = "CVT_CLA_CODE")
    private BigDecimal cvtClaCode= null;

    /**
     * The pay rate of a cover type.
     */
    @Column(name = "CVT_PAY_RATE")
    private BigDecimal cvtPayRate= null;

    /**
     * The pay rate divide factor of a cover type.
     */
    @Column(name = "CVT_PAY_RATE_DIV_FACT")
    private BigDecimal cvtPayRateDivFact= null;

    /**
     * The pay rate applies to of a cover type.
     */
    @Column(name = "CVT_PAY_RATE_APPL_TO")
    private String cvtPayRateApplTo= null;

    /**
     * The apply waiver rates of a cover type.
     */
    @Column(name = "CVT_APPLY_WVR_RATES")
    private String cvtApplyWvrRates= null;

    /**
     * The risk of a cover type.
     */
    @Column(name = "CVT_RISK")
    private BigDecimal cvtRisk= null;

    /**
     * The sum assured application basis of a cover type.
     */
    @Column(name = "CVT_SA_APPL_BASIS")
    private String cvtSaApplBasis= null;

    /**
     * The waiting period of a cover type.
     */
    @Column(name = "CVT_WAITING_PRD")
    private BigDecimal cvtWaitingPrd= null;

    /**
     * The maximum installment number of a cover type.
     */
    @Column(name = "CVT_MAX_INST_NO")
    private BigDecimal cvtMaxInstNo= null;

    /**
     * The maximum allowed per dependent type of a cover type.
     */
    @Column(name = "CVT_MAX_ALLOWED_PER_DEP_TYPE")
    private BigDecimal cvtMaxAllowedPerDepType= null;

    /**
     * The retirement age of a cover type.
     */
    @Column(name = "CVT_RETIRE_AGE")
    private BigDecimal cvtRetireAge= null;

    /**
     * The fixed sum assured amount of a cover type.
     */
    @Column(name = "CVT_FIXED_SA_AMT")
    private BigDecimal cvtFixedSaAmt= null;

    /**
     * The fixed sum assured of a cover type.
     */
    @Column(name = "CVT_FIXED_SA")
    private String cvtFixedSa= null;

    /**
     * The occupation benefit of a cover type.
     */
    @Column(name = "CVT_OCC_BEN")
    private String cvtOccBen= null;

    /**
     * The parent cover map of a cover type.
     */
    @Column(name = "CVT_PARENT_CVR_MAP")
    private String cvtParentCvrMap= null;

    /**
     * The parent cover risk of a cover type.
     */
    @Column(name = "CVT_PARENT_CVR_RISK")
    private BigDecimal cvtParentCvrRisk= null;

    /**
     * The notification period of a cover type.
     */
    @Column(name = "CVT_NOTIFICATION_PRD")
    private BigDecimal cvtNotificationPrd= null;

    /**
     * The year premium to pay of a cover type.
     */
    @Column(name = "CVT_YR_PREM_TO_PAY")
    private BigDecimal cvtYrPremToPay= null;

    /**
     * The cashback application period of a cover type.
     */
    @Column(name = "CVT_CASHBACK_APP_PRD")
    private BigDecimal cvtCashbackAppPrd= null;

    /**
     * The include reinsurance of a cover type.
     */
    @Column(name = "CVT_INCLUDE_RI")
    private String cvtIncludeRi= null;

//    @Column(name = "cvt_rate_type")
//    private String cvtRateType;

//    @ManyToOne
//    @JoinColumn(name = "tqcvtCvtCode", referencedColumnName = "CVT_CODE")
//    private LmsCoverTypes lmsCoverTypes;

//    @OneToMany(mappedBy = "lmsCoverTypes")
//    private List<LmsOrdPremRateTables> lmsOrdPremRateTablesList;

}
