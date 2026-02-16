package com.turnquest.setupsdemo.model;

import com.turnquest.setupsdemo.model.compositeKeys.LmsClmCvtProvisionsId;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

/**
 * Entity representing the LMS_CLM_CVT_PROVISIONS table.
 * This table stores claim cover provisions.
 */
@Entity
@Table(name = "LMS_CLM_CVT_PROVISIONS")
@Data
@IdClass(LmsClmCvtProvisionsId.class) // Using a composite key class
public class LmsClmCvtProvisions {

    /**
     * Composite primary key part 1: PCCP_CODE
     */
    @Id
    @Column(name = "PCCP_CODE", nullable = false)
    private BigDecimal pccpCode;

    /**
     * Composite primary key part 2: PCCP_CLM_NO
     */
    @Id
    @Column(name = "PCCP_CLM_NO", nullable = false, length = 100)
    private String pccpClmNo;

    @Column(name = "PCCP_POL_CODE", nullable = false)
    private BigDecimal pccpPolCode;

    @Column(name = "PCCP_POL_POLICY_NO", length = 100)
    private String pccpPolPolicyNo;

    @Column(name = "PCCP_PCVT_CODE", nullable = false)
    private BigDecimal pccpPcvtCode;

    /**
     * Foreign key reference to LMS_PROVISIONS
     */
    @ManyToOne
    @JoinColumn(name = "PCCP_PROV_CODE", referencedColumnName = "PROV_CODE", nullable = false)
    private LmsProvisions lmsProvisions;

    @Column(name = "PCCP_PROV_SHT_DESC", nullable = false, length = 15)
    private String pccpProvShtDesc;

    @Lob
    @Column(name = "PCCP_DESC")
    private String pccpDesc;
}
