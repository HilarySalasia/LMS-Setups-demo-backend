package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This table stores information about reinsurance treaty setups.
 */
@Entity
@Table(name = "GIN_TREATY_SETUPS")
@Data
public class GinTreatySetups {
    /**
 * Table Primary Key
 */
@Id
@Column(name = "REI_CODE", nullable = false, precision = 22)
private Long reiCode;

/**
 * Treaty code
 */
@Column(name = "REI_TRT_CODE", nullable = false, precision = 22)
private Long reiTrtCode;

/**
 * Treaty id
 */
@Column(name = "REI_TRT_SHT_DESC", nullable = false, length = 15)
private String reiTrtShtDesc;

/**
 * Underwriting year
 */
@Column(name = "REI_UW_YEAR", precision = 22)
private Long reiUwYear;

/**
 * Commission rate
 */
@Column(name = "REI_COMM_RATE", precision = 22, scale = 5)
private BigDecimal reiCommRate;

/**
 * Treaty limit
 */
@Column(name = "REI_LIMIT", precision = 27, scale = 5)
private BigDecimal reiLimit;

/**
 * Ceeding rate
 */
@Column(name = "REI_CEDE_RATE", precision = 22, scale = 5)
private BigDecimal reiCedeRate;

/**
 * Rate type
 */
@Column(name = "REI_RATE_TYPE", nullable = false, length = 1)
private String reiRateType;

/**
 * Earthquake Limit
 */
@Column(name = "REI_QUAKE_LIMIT", precision = 27, scale = 5)
private BigDecimal reiQuakeLimit;

/**
 * Profit commission rate
 */
@Column(name = "REI_PROFIT_COMM", precision = 22, scale = 5)
private BigDecimal reiProfitComm;

/**
 * Portfolio premium
 */
@Column(name = "REI_PREM_PORTFOLIO", precision = 27, scale = 5)
private BigDecimal reiPremPortfolio;

/**
 * Portfolio loss
 */
@Column(name = "REI_LOSS_PORTFOLIO", precision = 27, scale = 5)
private BigDecimal reiLossPortfolio;

/**
 * Cash loss
 */
@Column(name = "REI_CASH_LOSS", precision = 27, scale = 5)
private BigDecimal reiCashLoss;

/**
 * With effective from date
 */
@Column(name = "REI_WEF_DT")
private Date reiWefDt;

/**
 * With effect to date
 */
@Column(name = "REI_WET_DT")
private Date reiWetDt;

/**
 * Retained premium
 */
@Column(name = "REI_RETAINED_PREM", precision = 22, scale = 5)
private BigDecimal reiRetainedPrem;

/**
 * Premium Reserve Interest
 */
@Column(name = "REI_PREM_RESV_INT", precision = 22, scale = 5)
private BigDecimal reiPremResvInt;

/**
 * Management fee
 */
@Column(name = "REI_MGT_FEE", precision = 22, scale = 5)
private BigDecimal reiMgtFee;

/**
 * Currency code
 */
@Column(name = "REI_CUR_CODE", nullable = false, precision = 22)
private Long reiCurCode;

/**
 * Currency symbol
 */
@Column(name = "REI_CUR_SYMBOL", length = 15)
private String reiCurSymbol;

   /**
 * Security Values
 */
@Column(name = "REI_SECURITY_VALUES", length = 300)
private String reiSecurityValues;

/**
 * Warranty
 */
@Column(name = "REI_WARRANTY", length = 300)
private String reiWarranty;

/**
 * Information
 */
@Column(name = "REI_INFORMATION", length = 255)
private String reiInformation;

/**
 * Exclusions
 */
@Column(name = "REI_EXCLUSIONS", length = 255)
private String reiExclusions;

/**
 * Wording
 */
@Column(name = "REI_WORDING", length = 300)
private String reiWording;

/**
 * General Conditions
 */
@Column(name = "REI_GEN_CONDITIONS", length = 300)
private String reiGenConditions;

/**
 * Accounts
 */
@Column(name = "REI_ACCOUNTS", length = 15)
private String reiAccounts;

/**
 * Foreign key referencing GIN\_ARRANGEMENT\_SETUPS
 */
@Column(name = "REI_AS_CODE", nullable = false, precision = 22)
private Long reiAsCode;

/**
 * Foreign key referencing GIN\_TREATY\_ARRANGEMENTS
 */
@Column(name = "REI_TA_CODE", nullable = false, precision = 22)
private Long reiTaCode;

/**
 * Foreign key referencing GIN\_TREATIES
 */
@Column(name = "REI_TRS_CODE", nullable = false, precision = 22)
private Long reiTrsCode;

/**
 * Treaty id
 */
@Column(name = "REI_TRS_SHT_DESC", length = 15)
private String reiTrsShtDesc;

/**
 * Starting sum insured
 */
@Column(name = "REI_SI_START_FROM", precision = 25, scale = 5)
private BigDecimal reiSiStartFrom;

/**
 * Minimum EML
 */
@Column(name = "REI_MINIMUM_EML", precision = 22, scale = 5)
private BigDecimal reiMinimumEml;

/**
 * Period Losses Carried Forward
 */
@Column(name = "REI_PRD_LOSSES_CARRIED_FRD", precision = 22)
private Long reiPrdLossesCarriedFrd;

/**
 * Reinsurance Premium Tax Rate
 */
@Column(name = "REI_RI_PREM_TAX_RATE", precision = 25, scale = 5)
private BigDecimal reiRiPremTaxRate;

/**
 * Reinsurance Premium Tax Division Factor
 */
@Column(name = "REI_RI_PREM_TAX_DIV_FACT", precision = 22)
private Long reiRiPremTaxDivFact;

/**
 * Account Number
 */
@Column(name = "REI_ACC_NO", length = 20)
private String reiAccNo;

/**
 * Next Reinsurance Code
 */
@Column(name = "REI_NEXT_REI_CODE", precision = 22)
private Long reiNextReiCode;

/**
 * Earthquake Commission Rate
 */
@Column(name = "REI_EARTHQKE_COMM_RATE", precision = 10, scale = 5)
private BigDecimal reiEarthqkeCommRate;

/**
 * Tax Interest
 */
@Column(name = "REI_TAX_INTEREST", precision = 10, scale = 5)
private BigDecimal reiTaxInterest;

    /**
 * Local/Foreign Indicator
 */
@Column(name = "REI_LOCAL_FORGN", length = 1)
private String reiLocalForgn;

/**
 * FI Cede Rate
 */
@Column(name = "REI_FI_CEDE_RATE", precision = 23, scale = 5)
private BigDecimal reiFiCedeRate;

/**
 * Currency Rate
 */
@Column(name = "REI_CUR_RATE", precision = 23, scale = 4)
private BigDecimal reiCurRate;

/**
 * Loss Carry Forward to Extinction
 */
@Column(name = "REI_LOSSCFTOEXCTINCT", length = 1)
private String reiLosscftoexctinct;

/**
 * Previous Year Loss Balance Forward
 */
@Column(name = "REI_PREVYRLOSSBF_BAL", precision = 22, scale = 5)
private BigDecimal reiPrevyrlossbfBal;

/**
 * Loss Ratio Limit
 */
@Column(name = "REI_LOSS_RATIO_LIMIT", precision = 22, scale = 5)
private BigDecimal reiLossRatioLimit;
}