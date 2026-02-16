package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;

/**
 * This table stores claim treaty cessions based on the treaty apportionment of the risk at underwriting.
 * The system uses this information to apportion claim transaction amounts to the corresponding treaties.
 */
@Entity
@Table(name = "GIN_CLAIM_TREATY_CESSIONS")
@Data
public class GinClaimTreatyCessions {
    /**
 * Primary key for the table
 */
@Id
@Column(name = "CTRTC_CODE", nullable = false, precision = 22)
private Long ctrtcCode;

/**
 * Foreign key referencing GIN\_TREATY\_SETUPS.REI\_CODE
 */
@Column(name = "CTRTC_REI_CODE", nullable = false, precision = 22)
private Long ctrtcReiCode;

/**
 * Foreign key referencing GIN\_CLAIM\_MASTER\_BOOKINGS.CMB\_CLAIM\_NO
 */
@Column(name = "CTRTC_CMB_CLAIM_NO", nullable = false, length = 50)
private String ctrtcCmbClaimNo;

/**
 * Underwriting year
 */
@Column(name = "CTRTC_UWYR", nullable = false, precision = 22)
private Long ctrtcUwyr;

/**
 * Rate for the treaty cession
 */
@Column(name = "CTRTC_RATE", precision = 22, scale = 5)
private BigDecimal ctrtcRate;

/**
 * Policy batch number
 */
@Column(name = "CTRTC_POL_BATCH_NO", precision = 22)
private Long ctrtcPolBatchNo;

/**
 * Foreign key referencing GIN\_SUB\_CLASSES.SCL\_CODE
 */
@Column(name = "CTRTC_SCL_CODE", precision = 22)
private Long ctrtcSclCode;

/**
 * Policy currency code
 */
@Column(name = "CTRTC_POL_CUR_CODE", precision = 22)
private Long ctrtcPolCurCode;

/**
 * Treaty currency code
 */
@Column(name = "CTRTC_TRT_CUR_CODE", precision = 22)
private Long ctrtcTrtCurCode;

/**
 * Policy currency symbol
 */
@Column(name = "CTRTC_POL_CUR_SYMBOL", length = 15)
private String ctrtcPolCurSymbol;

/**
 * Treaty currency symbol
 */
@Column(name = "CTRTC_TRT_CUR_SYMBOL", length = 15)
private String ctrtcTrtCurSymbol;

/**
 * Treaty code
 */
@Column(name = "CTRTC_TRS_CODE", nullable = false, precision = 22)
private Long ctrtcTrsCode;

/**
 * Treaty short description
 */
@Column(name = "CTRTC_REI_TRS_SHT_DESC", length = 20)
private String ctrtcReiTrsShtDesc;
}