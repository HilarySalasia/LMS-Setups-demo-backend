package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "LMS_PROD_CVT_DEPENDANTS")
public class LmsProdCvtDependants {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LMS_PROD_CVT_DEPENDANTS_SEQ")
    @SequenceGenerator(name = "LMS_PROD_CVT_DEPENDANTS_SEQ", sequenceName = "LMS_PCD_CODE_SEQ", allocationSize = 1)
    @Column(name = "PCD_CODE")
    private Long pcdCode;

    @Column(name = "PCD_MAX_NO_ALLOWED", nullable = false)
    private BigDecimal pcdMaxNoAllowed;

    @Column(name = "PCD_MAX_SUM_ASSURED", nullable = false)
    private BigDecimal pcdMaxSumAssured;

    @Column(name = "PCD_MIN_AGE", nullable = false)
    private BigDecimal pcdMinAge;

    @Column(name = "PCD_MAX_AGE", nullable = false)
    private BigDecimal pcdMaxAge;

    @Column(name = "PCD_PROD_CODE", nullable = false)
    private Long pcdProdCode;

    @ManyToOne
    @JoinColumn(name = "PCD_PCT_CODE", referencedColumnName = "PCT_CODE", nullable = false)
    private LmsProdCoverTypes lmsProdCoverTypes;

    @ManyToOne
    @JoinColumn(name = "PCD_DTY_CODE", referencedColumnName = "DTY_CODE", nullable = false)
    private LmsDependentType lmsDependentTypes;

    @Column(name = "PCD_DTY_SHT_DESC")
    private String pcdDtyShtDesc;

    @ManyToOne
    @JoinColumn(name = "PCD_CVT_CODE", referencedColumnName = "CVT_CODE", nullable = false)
    private LmsCoverTypes lmsCoverTypes;

    @Column(name = "PCD_CVT_SHT_DESC")
    private String pcdCvtShtDesc;

    @Column(name = "PCD_MIN_SUM_ASSRD")
    private BigDecimal pcdMinSumAssrd;

    @Column(name = "PCD_FREQ_OF_PAY")
    private String pcdFreqOfPay;

    @Column(name = "PCD_DEFAULT")
    private String pcdDefault;

    @Column(name = "PCD_MIN_LOAN_REPAY_PRD")
    private Long pcdMinLoanRepayPrd;

    @Column(name = "PCD_MAX_LOAN_REPAY_PRD")
    private Long pcdMaxLoanRepayPrd;

    @Column(name = "PCD_MANDATORY")
    private String pcdMandatory;
}
