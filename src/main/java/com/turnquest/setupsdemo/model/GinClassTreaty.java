package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * This table stores information about retention limits per subclass for reinsurance treaties.
 */
@Entity
@Table(name = "GIN_CLASS_TREATIES")
@Data
public class GinClassTreaty {
   /**
 * Foreign Key referencing GIN\_TREATY\_ARRANGEMENTS
 */
@Column(name = "CLT_TA_CODE", nullable = false, precision = 22)
private Long cltTaCode;

/**
 * Treaty arrangement id
 */
@Column(name = "CLT_TA_SHT_DESC", nullable = false, length = 45)
private String cltTaShtDesc;

/**
 * Foreign Key Referencing GIN\_SUBCLASSES
 */
@Column(name = "CLT_SCL_CODE", nullable = false, precision = 22)
private Long cltSclCode;

/**
 * With effective from date
 */
@Column(name = "CLT_WEF", nullable = false)
private Date cltWef;

/**
 * With effective to date
 */
@Column(name = "CLT_WET")
private Date cltWet;

/**
 * Table primary Key
 */
@Id
@Column(name = "CLT_CODE", nullable = false, precision = 22)
private Long cltCode;

    /**
 * Foreign Key referencing GIN\_ARRANGEMENT\_SETUPS
 */
@Column(name = "CLT_AS_CODE", nullable = false, precision = 22)
private Long cltAsCode;

/**
 * Retention limit
 */
@Column(name = "CLT_RETENTION_LIMIT", precision = 23, scale = 5)
private BigDecimal cltRetentionLimit;

/**
 * Minimum Eml
 */
@Column(name = "CLT_MIN_EML", precision = 22, scale = 5)
private BigDecimal cltMinEml;

/**
 * Facre Obligatory Limit
 */
@Column(name = "CLT_FAC_OBLIG_LIMIT", precision = 22, scale = 5)
private BigDecimal cltFacObligLimit;

/**
 * Insured Limit
 */
@Column(name = "CLT_INSURED_LIMIT", precision = 22)
private Long cltInsuredLimit;

/**
 * Claim Limit
 */
@Column(name = "CLT_CLAIM_LIMIT", precision = 22)
private Long cltClaimLimit;

/**
 * FI Cede Rate
 */
@Column(name = "CTL_FI_CEDE_RATE", precision = 23, scale = 5)
private BigDecimal ctlFiCedeRate;

/**
 * Reinsurance Premium Tax Rate
 */
@Column(name = "CLT_RI_PREM_TAX_RATE", precision = 22, scale = 5)
private BigDecimal cltRiPremTaxRate;

/**
 * Reinsurance Premium Tax Division Factor
 */
@Column(name = "CLT_RI_PREM_TAX_DIV_FACT", precision = 22, scale = 5)
private BigDecimal cltRiPremTaxDivFact;

/**
 * Reinsurance Premium Tax Recovery Percentage
 */
@Column(name = "CLT_RI_PREM_TAX_RECVRY_PCT", precision = 22, scale = 5)
private BigDecimal cltRiPremTaxRecvryPct;
}