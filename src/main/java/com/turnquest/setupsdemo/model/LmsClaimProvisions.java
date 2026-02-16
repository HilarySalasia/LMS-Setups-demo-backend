package com.turnquest.setupsdemo.model;
import com.turnquest.setupsdemo.model.compositeKeys.LmsClaimProvisionsId;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

/**
 * Represents the LMS_CLAIM_PROVISIONS entity in the LMS system.
 */
@Entity
@Table(name = "LMS_CLAIM_PROVISIONS")
@Data
public class LmsClaimProvisions {

    @EmbeddedId
    private LmsClaimProvisionsId id;

    @Column(name = "PCLP_POL_POLICY_NO")
    private String pclpPolPolicyNo;

    @ManyToOne
    @JoinColumn(name = "PCLP_PPROV_PROV_CODE", referencedColumnName = "PROV_CODE")
    private LmsProvisions lmsProvisions;  // Assuming LMS_PROVISIONS is another entity

    @Column(name = "PCLP_PPROV_PROV_SHT_DESC", nullable = false)
    private String pclpPprovProvShtDesc;

    @Lob
    @Column(name = "PCLP_DESC", nullable = false)
    private String pclpDesc;
}
