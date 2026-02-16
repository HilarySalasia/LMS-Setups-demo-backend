package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_PRODUCTS table.
 * Stores information about products offered by the system.
 */
@Entity
@Table(name = "GIN_PRODUCTS")
@Data
public class GinProducts {

    /**
     * Primary Key. Unique product code.
     */
    @Id
    @Column(name = "PRO_CODE", nullable = false, precision = 22)
    private BigDecimal proCode;

    /**
     * Short description of the product.
     */
    @Column(name = "PRO_SHT_DESC", nullable = false, length = 20)
    private String proShtDesc;

    /**
     * Description of the product.
     */
    @Column(name = "PRO_DESC", length = 80)
    private String proDesc;

    /**
     * Foreign key from GIN_PRODUCT_GROUPS, representing the product group code.
     */
    @Column(name = "PRO_PRG_CODE", nullable = false, precision = 22)
    private BigDecimal proPrgCode;

    /**
     * Date the product was effective.
     */
    @Column(name = "PRO_WEF")
    private LocalDate proWef;

    /**
     * Date the product was wet.
     */
    @Column(name = "PRO_WET")
    private LocalDate proWet;

    /**
     * Policy prefix for the product.
     */
    @Column(name = "PRO_POLICY_PREFIX", length = 8)
    private String proPolicyPrefix;

    /**
     * Claim prefix for the product.
     */
    @Column(name = "PRO_CLAIM_PREFIX", length = 8)
    private String proClaimPrefix;

    /**
     * Property screening code for the product.
     */
    @Column(name = "PRO_PROP_SCR_CODE", length = 5)
    private String proPropScrCode;

    /**
     * Underwriting screening code for the product.
     */
    @Column(name = "PRO_UNWR_SCR_CODE", length = 45)
    private String proUnwrScrCode;

    /**
     * Claim screening code for the product.
     */
    @Column(name = "PRO_CLM_SCR_CODE", length = 5)
    private String proClmScrCode;

    /**
     * Expiry period for the product.
     */
    @Column(name = "PRO_EXPIRY_PERIOD", length = 1)
    private String proExpiryPeriod;

    /**
     * Minimum number of sub-classes for the product.
     */
    @Column(name = "PRO_MINIMUM_SUB_CLASSES_NO", precision = 22)
    private BigDecimal proMinimumSubClassesNo;

    /**
     * Indicates whether the product allows multiple classes (Y/N).
     */
    @Column(name = "PRO_MULT_CLASS", length = 1)
    private String proMultClass;

    /**
     * Minimum premium for the product.
     */
    @Column(name = "PRO_MIN_PREM", precision = 25, scale = 5)
    private BigDecimal proMinPrem;

    /**
     * Indicates whether the product is renewable (Y/N).
     */
    @Column(name = "PRO_RENEWABLE", length = 1, columnDefinition = "VARCHAR2(1)  default 'Y'")
    private String proRenewable;

    /**
     * Indicates whether accommodation is allowed for the product (Y/N).
     */
    @Column(name = "PRO_ACCOMODATION", length = 1)
    private String proAccommodation;

    /**
     * Indicates whether the product allows open cover (Y/N).
     */
    @Column(name = "PRO_OPEN_COVER", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proOpenCover;

    /**
     * Short description of the prerequisite product.
     */
    @Column(name = "PRO_PREREQ_PRO_SHT_DESC", length = 15)
    private String proPrereqProShtDesc;

    /**
     * Path to the policy word document.
     */
    @Column(name = "PRO_POLICY_WORD_DOC", length = 100)
    private String proPolicyWordDoc;

    /**
     * Short name of the product.
     */
    @Column(name = "PRO_SHT_NAME", length = 45)
    private String proShtName;

    /**
     * Minimum premium for endorsements.
     */
    @Column(name = "PRO_ENDOS_MIN_PREM", precision = 30, scale = 5)
    private BigDecimal proEndosMinPrem;

    /**
     * Indicates whether to show sum insured (Y/N).
     */
    @Column(name = "PRO_SHOW_SI", length = 1, columnDefinition = "VARCHAR2(1)  default 'Y'")
    private String proShowSi;

    /**
     * Indicates whether to show facultative amount (Y/N).
     */
    @Column(name = "PRO_SHOW_FAP", length = 1, columnDefinition = "VARCHAR2(1)  default 'Y'")
    private String proShowFap;

    /**
     * Number of pages for the policy code.
     */
    @Column(name = "PRO_POLICY_CODE_PAGES", precision = 22)
    private BigDecimal proPolicyCodePages;

    /**
     * Number of pages for the policy document.
     */
    @Column(name = "PRO_POLICY_DOC_PAGES", precision = 22)
    private BigDecimal proPolicyDocPages;

    /**
     * Indicates whether the policy number can be edited (Y/N).
     */
    @Column(name = "PRO_EDIT_POL_NO", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proEditPolNo;

    /**
     * Incentive multiplier for the product.
     */
    @Column(name = "PRO_INCENTIVE_MULTI", precision = 15, scale = 5)
    private BigDecimal proIncentiveMulti;

    /**
     * Shed check for the product.
     */
    @Column(name = "PRO_SHED_CHK", length = 2)
    private String proShedChk;

    /**
     * New product code.
     */
    @Column(name = "PRO_NEW_PRO_CODE", precision = 22)
    private BigDecimal proNewProCode;

    /**
     * Interface type for the product.
     */
    @Column(name = "PRO_INTERFACE_TYPE", length = 10, columnDefinition = "VARCHAR2(10) default 'ACCRUAL'")
    private String proInterfaceType;

    /**
     * Policy accumulation limit.
     */
    @Column(name = "PRO_POLICY_ACCUM_LIMIT", precision = 14, scale = 2)
    private BigDecimal proPolicyAccumLimit;

    /**
     * Insured accumulation limit.
     */
    @Column(name = "PRO_INSURED_ACCUM_LIMIT", precision = 14, scale = 2)
    private BigDecimal proInsuredAccumLimit;

    /**
     * Total company accumulation limit.
     */
    @Column(name = "PRO_TOT_COMPANY_ACCUM_LIMIT", precision = 25, scale = 5)
    private BigDecimal proTotCompanyAccumLimit;

    /**
     * Indicates whether spares are enabled for the product (Y/N).
     */
    @Column(name = "PRO_SPARES_ENABLE", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proSparesEnable;

    /**
     * Web details for the product.
     */
    @Column(name = "PRO_WEB_DETAILS", length = 500)
    private String proWebDetails;

    /**
     * Indicates whether the product is shown on the web (Y/N).
     */
    @Column(name = "PRO_WEB_SHOW", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proWebShow;

    /**
     * Indicates whether the product includes earthquake cover (Y/N).
     */
    @Column(name = "PRO_EARTHQUAKE", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proEarthquake;

    /**
     * Program code.
     */
    @Column(name = "PRO_PRGS_CODE", precision = 22)
    private BigDecimal proPrgsCode;

    /**
     * Motor verification.
     */
    @Column(name = "PRO_MOTO_VERFY", length = 1)
    private String proMotoVerfy;

    /**
     * Indicates whether the product allows same-day renewal (Y/N).
     */
    @Column(name = "PRO_SAME_DAY_RENEWAL", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proSameDayRenewal;

    /**
     * Indicates whether installment payments are allowed (Y/N).
     */
    @Column(name = "PRO_INSTALLMENT_ALLOWED", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proInstallmentAllowed;

    /**
     * Indicates whether the product allows automatic posting of reinsurance (Y/N).
     */
    @Column(name = "PRO_AUTOPOST_REIN", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proAutopostRein;

    /**
     * Indicates whether the product allows authorization without clauses (Y/N).
     */
    @Column(name = "PRO_AUTH_WOUT_CLAUSES", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proAuthWoutClauses;

    /**
     * Indicates whether the product is a marine product (Y/N).
     */
    @Column(name = "PRO_MARINE", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proMarine;

    /**
     * Industry code for the product.
     */
    @Column(name = "PRO_INDSTR_CODE", length = 30)
    private String proIndstrCode;

    /**
     * Indicates whether the product uses a superintendent panel (Y/N).
     */
    @Column(name = "PRO_SUPRNDT_PANEL", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proSuprndtPanel;

    /**
     * Maximum number of extensions allowed for the product.
     */
    @Column(name = "PRO_MAX_EXTENSIONS", precision = 22)
    private BigDecimal proMaxExtensions;

    /**
     * Indicates whether the product is the default product (Y/N).
     */
    @Column(name = "PRO_DEFAULT", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proDefault;

    /**
     * Order for the product.
     */
    @Column(name = "PRO_ORDER", precision = 22)
    private BigDecimal proOrder;

    /**
     * Indicates whether the product allows a general cover note (Y/N).
     */
    @Column(name = "PRO_GEN_COVER_NOTE", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proGenCoverNote;

    /**
     * Indicates whether the product allows open policies (Y/N).
     */
    @Column(name = "PRO_OPEN_POLICY_ALLOWED", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proOpenPolicyAllowed;

    /**
     * Schedule order for the product.
     */
    @Column(name = "PRO_SCHEDULE_ORDER", precision = 22)
    private BigDecimal proScheduleOrder;

    /**
     * Indicates whether a PIN is required for the product (Y/N).
     */
    @Column(name = "PRO_PIN_REQUIRED", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proPinRequired;

    /**
     * Extension mapping code for the product.
     */
    @Column(name = "PRO_EXT_MAP_CODE", length = 10)
    private String proExtMapCode;

    /**
     * Indicates whether the product allows more than annual cover (Y/N).
     */
    @Column(name = "PRO_MORE_THAN_ANNUAL_COVER", length = 1)
    private String proMoreThanAnnualCover;

    /**
     * Type of product.
     */
    @Column(name = "PRO_TYPE", length = 15)
    private String proType;

    /**
     * Stop.
     */
    @Column(name = "PRO_STP", length = 1)
    private String proStp;

    /**
     * Renewal change.
     */
    @Column(name = "PRO_DP_REN_CHANGE", length = 1)
    private String proDpRenChange;

    /**
     * Indicates whether cashback is applicable to the product (Y/N).
     */
    @Column(name = "PRO_CASHBACK_APPL", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proCashbackAppl;

    /**
     * Indicates whether credit is allowed for the product (Y/N).
     */
    @Column(name = "PRO_CREDIT_ALLOWED", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proCreditAllowed;

    /**
     * Debit type for the product.
     */
    @Column(name = "PRO_DEBIT_TYPE", length = 5, columnDefinition = "VARCHAR2(5)  default 'FF'")
    private String proDebitType;

    /**
     * Installment period for the product.
     */
    @Column(name = "PRO_INSTALLMENT_PERIOD", length = 2, columnDefinition = "VARCHAR2(2)  default 'A'")
    private String proInstallmentPeriod;

    /**
     * Maximum number of installments allowed.
     */
    @Column(name = "PRO_MAX_INSTALLMENTS", precision = 22)
    private BigDecimal proMaxInstallments;

    /**
     * Installment percentages for payments.
     */
    @Column(name = "PRO_PYMT_INSTALL_PCTS", length = 20)
    private String proPymtInstallPcts;

    /**
     * Certificate period for the product.
     */
    @Column(name = "PRO_CERT_PERIOD", length = 1, columnDefinition = "VARCHAR2(1)  default 'M'")
    private String proCertPeriod;

    /**
     * Business customer type.
     */
    @Column(name = "PRO_BUS_CUST_TYPE", length = 50)
    private String proBusCustType;

    /**
     * How to compute the service fee for the product (G = General).
     */
    @Column(name = "PRO_COMPUTE_SERVICE_FEE", length = 1, columnDefinition = "VARCHAR2(1)  default 'G'")
    private String proComputeServiceFee;

    /**
     * Product code.
     */
    @Column(name = "PROD_WPRODC_CODE", precision = 22)
    private BigDecimal prodWprodcCode;

    /**
     * Commission rate for the product.
     */
    @Column(name = "PRO_COMMISSION_RATE", precision = 22)
    private BigDecimal proCommissionRate;

    /**
     * Indicates whether to post transaction to regulator (Y/N).
     */
    @Column(name = "PRO_POST_TXN_TO_REGULATOR", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proPostTxnToRegulator;

    /**
     * Regulator schedule code.
     */
    @Column(name = "PRO_REGULATOR_SCH_CODE", length = 50)
    private String proRegulatorSchCode;

    /**
     * Certificate code.
     */
    @Column(name = "PRO_CERTIFICATE_CODE", precision = 22)
    private BigDecimal proCertificateCode;

    /**
     * Loss ratio tolerance.
     */
    @Column(name = "PRO_LOSS_RATIO_TOL", precision = 22)
    private BigDecimal proLossRatioTol;

    /**
     * Loss ratio threshold.
     */
    @Column(name = "PRO_LOSS_RATIO_THRESHOLD", precision = 22, scale = 5)
    private BigDecimal proLossRatioThreshold;

    /**
     * Indicates whether the product has a declaration (Y/N).
     */
    @Column(name = "PRO_DECLARATION", length = 1, columnDefinition = "VARCHAR2(1)  default 'N'")
    private String proDeclaration;

    /**
     * Renewal basis.
     */
    @Column(name = "PRO_RENEW_BASED_ON_SETUP", length = 2)
    private String proRenewBasedOnSetup;

    /**
     * Risk uniqueness.
     */
    @Column(name = "PRO_RISK_UNIQUE", length = 255)
    private String proRiskUnique;

    /**
     * Remit insurance full.
     */
    @Column(name = "PRO_REMITE_INS_FULL", length = 255)
    private String proRemiteInsFull;

    /**
     * Escalation reduction.
     */
    @Column(name = "PRO_ESCALATION_REDUCTION", length = 255)
    private String proEscalationReduction;

    /**
     * Web enabled.
     */
    @Column(name = "PRO_WEB_ENABLED", length = 255)
    private String proWebEnabled;

    /**
     * Insurance type.
     */
    @Column(name = "PRO_INS_TYPE", length = 255)
    private String proInsType;

    /**
     * Assignment allowed.
     */
    @Column(name = "PRO_ASSIGNMENT_ALLOWED", length = 1)
    private Character proAssignmentAllowed;

    /**
     * Loan applicable.
     */
    @Column(name = "PRO_LOAN_APPLICABLE", length = 1)
    private Character proLoanApplicable;

    /**
     * Maximum age.
     */
    @Column(name = "PRO_MAX_AGE", precision = 19, scale = 2)
    private BigDecimal proMaxAge;

    /**
     * Maximum term.
     */
    @Column(name = "PRO_MAX_TERM", precision = 19, scale = 2)
    private BigDecimal proMaxTerm;

    /**
     * Minimum age.
     */
    @Column(name = "PRO_MIN_AGE", precision = 19, scale = 2)
    private BigDecimal proMinAge;

    /**
     * Minimum term.
     */
    @Column(name = "PRO_MIN_TERM", precision = 19, scale = 2)
    private BigDecimal proMinTerm;

    /**
     * Organization code.
     */
    @Column(name = "PRO_ORGANIZATION_CODE", precision = 19, scale = 2)
    private BigDecimal proOrganizationCode;

    /**
     * Prorata type.
     */
    @Column(name = "PRO_PRORATA_TYPE", length = 255)
    private String proProrataType;

    /**
     * Term distribution.
     */
    @Column(name = "PRO_TERM_DISTRIBUTION", length = 255)
    private String proTermDistribution;

    /**
     * Number of years.
     */
    @Column(name = "PRO_YEARS", precision = 22)
    private BigDecimal proYears;
}
