package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Entity representing the GIN\_XOL\_CLMS\_VMLP\_CESSIONS table.
 */
@Entity
@Table(name = "GIN_XOL_CLMS_VMLP_CESSIONS")
@Data
public class GinXolClmsVmlpCessions {

    /**
     * Primary key for the table
     */
    @Id
    @Column(name = "XOLVC_CODE", precision = 22)
    private Long xolvcCode;

    /**
     * Combined claim number
     */
    @Column(name = "XOLVC_CMB_CLAIM_NO", length = 40)
    private String xolvcCmbClaimNo;

    /**
     * Foreign key referencing GIN\_XOL\_UW\_CESSIONS.XOLUC\_CODE
     */
    @Column(name = "XOLVC_XOLUC_CODE", precision = 22)
    private Long xolvcXolucCode;

    /**
     * Insured property code
     */
    @Column(name = "XOLVC_IPU_CODE", precision = 22)
    private Long xolvcIpuCode;

    /**
     * Risk reinsurance transaction code
     */
    @Column(name = "XOLVC_PRRD_CODE", precision = 22)
    private Long xolvcPrrdCode;

    /**
     * XAS code
     */
    @Column(name = "XOLVC_XAS_CODE", precision = 22)
    private Long xolvcXasCode;

    /**
     * XOLVM code
     */
    @Column(name = "XOLVC_XOLVM_CODE", precision = 22)
    private Long xolvcXolvmCode;

    /**
     * Cession percentage
     */
    @Column(name = "XOLVC_CESSION_PCT", precision = 22, scale = 5)
    private BigDecimal xolvcCessionPct;

    /**
     * Ceded sum insured
     */
    @Column(name = "XOLVC_CEDED_SI", precision = 20, scale = 5)
    private BigDecimal xolvcCededSi;

    /**
     * Currency code
     */
    @Column(name = "XOLVC_CUR_CODE", precision = 20, scale = 5)
    private BigDecimal xolvcCurCode;


}