package com.turnquest.setupsdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "LMS_PROD_COVER_TYPES")
public class LmsProdCoverTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PCT_CODE", nullable = false)
    private Long pctCode;

    @Column(name = "PCT_PROD_CODE", nullable = false)
    private Long pctProdCode;

    @Column(name = "PCT_FORMULAR", length = 20)
    private String pctFormular;

    @Column(name = "PCT_CVT_SHT_DESC", length = 30)
    private String pctCvtShtDesc;

    @Column(name = "PCT_REFUND_FORMULAR", length = 20)
    private String pctRefundFormular;

    @Column(name = "PCT_MAX_ASSUREDS", precision = 5)
    private BigDecimal pctMaxAssureds;

    @Column(name = "PCT_MAX_CLM_AMT", precision = 23, scale = 5)
    private BigDecimal pctMaxClmAmt;

    @Column(name = "PCT_MAX_SA", precision = 23, scale = 5)
    private BigDecimal pctMaxSa;

    @Column(name = "PCT_MAX_AGE", precision = 5)
    private BigDecimal pctMaxAge;

    @Column(name = "PCT_INBUILT", length = 3)
    private String pctInbuilt;

    @Column(name = "PCT_RATE_DEPEND_ON_CLASS", length = 2)
    private String pctRateDependOnClass;

    @Column(name = "PCT_MAIN_SA_PERC", precision = 10, scale = 5)
    private BigDecimal pctMainSaPerc;

    @Column(name = "PCT_GRP_OR_SINGLE_RATES", length = 1)
    private String pctGrpOrSingleRates;

    @Column(name = "PCT_MANDATORY", length = 1)
    private String pctMandatory;

    @Column(name = "PCT_ACCELERATOR", length = 5)
    private String pctAccelerator;

    @Column(name = "PCT_RISK")
    private BigDecimal pctRisk;

    @Column(name = "PCT_WAIV_PREM_LIMIT", precision = 15)
    private BigDecimal pctWaivPremLimit;

    @Column(name = "PCT_RATE_GENDER", length = 2)
    private String pctRateGender;

    @Column(name = "PCT_SA_DEPEND_ON_LIMIT", length = 1)
    private String pctSaDependOnLimit;

    @Column(name = "PCT_DEPENADNT_RATE", length = 5)
    private String pctDepenadntRate;

    @Column(name = "PCT_RETENTN_FRM_MAINCV_RETENTN", length = 1)
    private String pctRetentnFrmMaincvRetentn;

    @Column(name = "PCT_THIRTEEN_MONTH", length = 3)
    private String pctThirteenMonth;

    @Column(name = "PCT_APPLY_AGE_LOADING", length = 1)
    private String pctApplyAgeLoading;

    @Column(name = "PCVT_LOAD_AGE_FACT")
    private BigDecimal pcvtLoadAgeFact;

    @Column(name = "PCT_EM")
    private BigDecimal pctEm;

    @Column(name = "PCT_PROFIT_MARGIN")
    private BigDecimal pctProfitMargin;

    @Column(name = "PCT_MNGT_EXPENSES")
    private BigDecimal pctMngtExpenses;

    @Column(name = "PCT_PHCF")
    private BigDecimal pctPhcf;

    @Column(name = "PCT_ADR_RATE")
    private BigDecimal pctAdrRate;

    @Column(name = "PCT_ADR_RATE_DIV_FACT")
    private BigDecimal pctAdrRateDivFact;

    @Column(name = "PCT_MED_COST")
    private BigDecimal pctMedCost;

    @Column(name = "PCT_STAMP_DUTY")
    private BigDecimal pctStampDuty;

    @Column(name = "PCT_COMM_RATE")
    private BigDecimal pctCommRate;

    @Column(name = "PAY_PREM_RETURN_ON_LAPSE", length = 5)
    private String payPremReturnOnLapse;

    @Column(name = "PCT_PMAS_CODE", precision = 25, scale = 5)
    private BigDecimal pctPmasCode;

    @Column(name = "PCT_PAY_PREM_RETURN_ON_LAPSE", length = 5)
    private String pctPayPremReturnOnLapse;

    @Column(name = "PCT_PERC_CHNG_ALLWD", length = 5)
    private String pctPercChngAllwd;

    @Column(name = "PCT_INTERPOL_FORMULAR", length = 25)
    private String pctInterpolFormular;

    @Column(name = "PCT_INTERPOL_ALLOWDROP", length = 25)
    private String pctInterpolAllowdrop;

    @Column(name = "PCT_FACTOR", precision = 23, scale = 3)
    private BigDecimal pctFactor;

    @Column(name = "PCT_FACTOR_DIVISOR", precision = 23, scale = 3)
    private BigDecimal pctFactorDivisor;

    @Column(name = "PCT_LOAD_FACTOR", precision = 23, scale = 5)
    private BigDecimal pctLoadFactor;

    @Column(name = "PCT_LOAD_FACTOR_DIV", precision = 8, scale = 5)
    private BigDecimal pctLoadFactorDiv;

    @Column(name = "PCT_INCLUDE_IN_WOP_COMP", length = 1)
    private String pctIncludeInWopComp;

    @Column(name = "PCT_COMBINED_COVER_TYPE", length = 25)
    private String pctCombinedCoverType;

    @Column(name = "PCT_USE_LIMITS_AT_OPTION", length = 1)
    private String pctUseLimitsAtOption;

    @Column(name = "PCT_INPUT_SA", length = 1)
    private String pctInputSa;

    @Column(name = "PCT_COMPUTE_LC_ON_TOT_CONTR", length = 1)
    private String pctComputeLcOnTotContr;

    @Column(name = "PCT_APPLICABLE_GENDER", length = 1)
    private String pctApplicableGender;

    @Column(name = "PCT_COMPUTE_SA_ON_TOT_CONTR", length = 1)
    private String pctComputeSaOnTotContr;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "PCT_CVT_CODE", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private LmsCoverTypes lmsCoverTypes;

    @OneToMany(mappedBy = "opirPctCode", cascade = CascadeType.DETACH)
    private List<LmsOrdPremIntrRate> interestRates;
}
