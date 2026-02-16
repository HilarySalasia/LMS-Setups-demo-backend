package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;

/**
 * This table stores details of excess of loss (XOL) underwriting cessions.
 */
@Entity
@Table(name = "GIN_XOL_UW_CESSIONS")
@Data
public class GinXolUwCessions {
    /**
 * Primary key for the table
 */
@Id
@Column(name = "XOLUC_CODE", precision = 22)
private Long xolucCode; // Code for the XOL underwriting cession

/**
 * Insured property code
 */
@Column(name = "XOLUC_IPU_CODE", precision = 22)
private Long xolucIpuCode; // Insured property code

/**
 * Risk reinsurance transaction code
 */
@Column(name = "XOLUC_PRRD_CODE", precision = 22)
private Long xolucPrrdCode; // Risk reinsurance transaction code

/**
 * XAS code
 */
@Column(name = "XOLUC_XAS_CODE", precision = 22)
private Long xolucXasCode; // XAS code

/**
 * XOLVM code
 */
@Column(name = "XOLUC_XOLVM_CODE", precision = 22)
private Long xolucXolvmCode; // XOLVM code

/**
 * Company owned amount
 */
@Column(name = "XOLUC_COMP_OWN_AMNT", precision = 22, scale = 3)
private BigDecimal xolucCompOwnAmnt; // Company owned amount

/**
 * Premium rate
 */
@Column(name = "XOLUC_PREM_RATE", precision = 22, scale = 5)
private BigDecimal xolucPremRate; // Premium rate

/**
 * Premium amount
 */
@Column(name = "XOLUC_PREMIUM", precision = 22, scale = 5)
private BigDecimal xolucPremium; // Premium amount

/**
 * Cession percentage
 */
@Column(name = "XOLUC_CESSION_PCT", precision = 22, scale = 5)
private BigDecimal xolucCessionPct; // Cession percentage

/**
 * Profit commission discount
 */
@Column(name = "XOLUC_PROFT_COMM_DISC", precision = 22, scale = 5)
private BigDecimal xolucProftCommDisc; // Profit commission discount

/**
 * Policy batch number
 */
@Column(name = "XOLUC_POL_BATCH_NO", precision = 20)
private Long xolucPolBatchNo; // Policy batch number

/**
 * GIS transaction number
 */
@Column(name = "XOLUC_GGT_TRANS_NO", precision = 20)
private Long xolucGgtTransNo; // GIS transaction number

/**
 * XOLCG code
 */
@Column(name = "XOLUC_XOLCG_CODE", precision = 20)
private Long xolucXolcgCode; // XOLCG code

/**
 * XOLOR code
 */
@Column(name = "XOLUC_XOLOR_CODE", precision = 20)
private Long xolucXolorCode; // XOLOR code

/**
 * Profit commission rate
 */
@Column(name = "XOLUC_PROFT_COMM_RATE", precision = 20, scale = 5)
private BigDecimal xolucProftCommRate; // Profit commission rate

    /**
 * Ceded sum insured
 */
@Column(name = "XOLUC_CEDED_SI", precision = 20, scale = 5)
private BigDecimal xolucCededSi;

/**
 * Currency code
 */
@Column(name = "XOLUC_CUR_CODE", precision = 20)
private Long xolucCurCode;

/**
 * Excess sum insured
 */
@Column(name = "XOLUC_EXCESS_SI", precision = 20, scale = 5)
private BigDecimal xolucExcessSi;

/**
 * Actual treaty sum insured
 */
@Column(name = "XOLUC_ACTUAL_TREATY_SI", precision = 22, scale = 5)
private BigDecimal xolucActualTreatySi;

/**
 * Actual VLMP sum insured
 */
@Column(name = "XOLUC_ACTUAL_VMLP_SI", precision = 22, scale = 5)
private BigDecimal xolucActualVlmpSi;

/**
 * Company owned premium
 */
@Column(name = "XOLUC_COMP_OWN_PREM", precision = 22, scale = 5)
private BigDecimal xolucCompOwnPrem;

/**
 * Treaty premium
 */
@Column(name = "XOLUC_TREATY_PREM", precision = 22, scale = 5)
private BigDecimal xolucTreatyPrem;

/**
 * VLMP premium
 */
@Column(name = "XOLUC_VMLP_PREM", precision = 22, scale = 5)
private BigDecimal xolucVlmpPrem;

/**
 * Company owned commission
 */
@Column(name = "XOLUC_COMP_OWN_COMM", precision = 22, scale = 5)
private BigDecimal xolucCompOwnComm;

/**
 * Treaty commission
 */
@Column(name = "XOLUC_TREATY_COMM", precision = 22, scale = 5)
private BigDecimal xolucTreatyComm;

/**
 * VLMP commission
 */
@Column(name = "XOLUC_VMLP_COMM", precision = 22, scale = 5)
private BigDecimal xolucVlmpComm;

/**
 * But charge
 */
@Column(name = "XOLUC_BUTCHARGE", precision = 22, scale = 5)
private BigDecimal xolucButcharge;

/**
 * Total sum insured
 */
@Column(name = "XOLUC_TOTAL_SI", precision = 22, scale = 5)
private BigDecimal xolucTotalSi;

/**
 * Original net premium
 */
@Column(name = "XOLUC_ORIG_NET_PREM", precision = 22, scale = 5)
private BigDecimal xolucOrigNetPrem;

/**
 * Order percentage
 */
@Column(name = "XOLUC_ORDER_PCT", precision = 22, scale = 5)
private BigDecimal xolucOrderPct;

/**
 * Premium percentage
 */
@Column(name = "XOLUC_PREM_PCT", precision = 22, scale = 5)
private BigDecimal xolucPremPct;

/**
 * Reinsurance rate
 */
@Column(name = "XOLUC_RI_RATE", precision = 22, scale = 5)
private BigDecimal xolucRiRate;

/**
 * Profit commission percentage
 */
@Column(name = "XOLUC_PROFT_COMM_PCT", precision = 22, scale = 5)
private BigDecimal xolucProftCommPct;

/**
 * Full premium
 */
@Column(name = "XOLUC_FULL_PREM", precision = 22, scale = 5)
private BigDecimal xolucFullPrem;
}
