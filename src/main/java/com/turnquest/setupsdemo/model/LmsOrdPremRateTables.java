package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "LMS_ORD_PREM_RATE_TABLES")
public class LmsOrdPremRateTables {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_ORD_PREM_RATE_TABLES_SEQ")
    @SequenceGenerator(name = "LMS_ORD_PREM_RATE_TABLES_SEQ", sequenceName = "LMS_ORDRT_CODE_SEQ", allocationSize = 1)
    @Column(name = "ORDT_CODE")
    private Long ordtCode;

    @Column(name = "ORDT_PCT_CODE")
    private BigDecimal ordtPctCode;

    @Column(name = "ORDT_RATE")
    private BigDecimal ordtRate;

    @Column(name = "ORDT_WEF")
    private Date ordtWef;

    @Column(name = "ORDT_WET")
    private Date ordtWet;

    @Column(name = "ORDT_CLA_CODE")
    private Long ordtClaCode;

    @Column(name = "ORDT_PMAS_CODE")
    private BigDecimal ordtPmasCode;

    @Column(name = "ORDT_ANB_FROM")
    private BigDecimal ordtAnbFrom;

    @Column(name = "ORDT_ANB_TO")
    private BigDecimal ordtAnbTo;

    @Column(name = "ORDT_DIVISION_FACTOR")
    private BigDecimal ordtDivisionFactor;

    @Column(name = "ORDT_RATE_TYPE")
    private String ordtRateType;

    @Column(name = "ORDT_MONTH_RATE")
    private BigDecimal ordtMonthRate;

    @Column(name = "ORDT_MONTH_DIV_FACT")
    private BigDecimal ordtMonthDivFact;

    @Column(name = "ORDT_CVT_CODE")
    private Long ordtCvtCode;

    @Column(name = "ORDT_CVT_SHT_DESC")
    private String ordtCvtShtDesc;

    @Column(name = "ORDT_QUARTER_RATE")
    private BigDecimal ordtQuarterRate;

    @Column(name = "ORDT_SEMI_ANNL_RATE")
    private BigDecimal ordtSemiAnnlRate;

    @Column(name = "ORDT_POP_CODE")
    private BigDecimal ordtPopCode;

    @Column(name = "ORDT_ANNUAL_RATE")
    private BigDecimal ordtAnnualRate;

    @Column(name = "ORDT_OPT_CODE")
    private BigDecimal ordOptCode;

    @Column(name = "ORDT_TERM")
    private Integer ordtTerm;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ORDT_OPIR_CODE" )
    private LmsOrdPremIntrRate lmsOrdPremIntrRate;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ORDT_LMR_CODE")
    private LmsMortalityRates lmsMortalityRates;

    @Column(name = "ORDT_SINGLE_RATE")
    private BigDecimal ordtSingleRate;

    @Column(name = "ORDT_SINGLE_DIV_FACT")
    private BigDecimal ordtSingleDivFact;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ORDT_MLR_CODE")
    private LmsMedLoadRates lmsMedLoadRates;

    @Column(name = "ORDT_GENDER")
    private String ordtGender;

    @Column(name = "ORDT_WKLY_RATE")
    private BigDecimal ordtWklyRate;

    @Column(name = "ORDT_DLY_RATE")
    private BigDecimal ordtDlyRate;

    @Column(name = "ORDT_DEPENDANT_NO")
    private Integer ordtDependantNo;

    @Column(name = "ORDT_AMT_FROM")
    private BigDecimal ordtAmtFrom;

    @Column(name = "ORDT_AMT_TO")
    private BigDecimal ordtAmtTo;

    @Column(name = "ORDT_SA")
    private BigDecimal ordtSa;

    @Column(name = "ORDT_RATE_DESC")
    private String ordtRateDesc;

    @Column(name = "ORDT_QX")
    private BigDecimal ordtQx;

    @Column(name = "ORDT_TRIANNUAL_RATE")
    private BigDecimal ordtTriannualRate;

    @Column(name = "ORDT_EXPENSE_PREMIUM")
    private BigDecimal ordtExpensePremium;

    @Column(name = "ORDT_MEDICAL")
    private String ordtMedical;
}
