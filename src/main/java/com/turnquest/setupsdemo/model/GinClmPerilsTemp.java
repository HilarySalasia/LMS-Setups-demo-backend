package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLM_PERILS_TEMP table.
 * This table likely stores temporary data related to claim perils.
 */
@Entity
@Table(name = "GIN_CLM_PERILS_TEMP")
@Data
public class GinClmPerilsTemp {

    /**
     * Primary key for the temporary claim peril record.
     */
    @Id
    @Column(name = "CPT_CODE", nullable = false, precision = 22)
    private BigDecimal cptCode;

    /**
     * Peril code associated with the claim.
     */
    @Column(name = "CPT_PERIL_CODE", nullable = false, precision = 22)
    private BigDecimal cptPerilCode;

    /**
     * Peril amount for the claim.
     */
    @Column(name = "CPT_PERIL_AMT", nullable = false, precision = 23, scale = 5)
    private BigDecimal cptPerilAmt;

    /**
     * Group code associated with the claim.
     */
    @Column(name = "CPT_GRP_CODE", nullable = false, precision = 22)
    private BigDecimal cptGrpCode;

    /**
     * Claim payment code.
     */
    @Column(name = "CPT_CLMP_CODE", precision = 22)
    private BigDecimal cptClmpCode;

    /**
     * Peril level for the claim.
     */
    @Column(name = "CPT_PERIL_LEVEL", length = 1)
    private String cptPerilLevel;

    /**
     * Description of the peril.
     */
    @Column(name = "CPT_PERIL", length = 100)
    private String cptPeril;

    /**
     * Estimated peril amount.
     */
    @Column(name = "CPT_PERIL_ESTMATE", precision = 23, scale = 5)
    private BigDecimal cptPerilEstmate;

    /**
     * Indicates whether the peril is for a third party (T) or for the insured (S).
     */
    @Column(name = "CPT_THIRD_PARTY", length = 1)
    private String cptThirdParty;

    /**
     * Claimant code associated with the claim. Foreign key from GIN_CLAIMANTS.
     */
    @Column(name = "CPT_CLD_CODE", precision = 22)
    private BigDecimal cptCldCode;

    /**
     * Division number associated with the claim.
     */
    @Column(name = "CPT_DIV_NO", length = 20)
    private String cptDivNo;

    /**
     * Excess amount for the peril.
     */
    @Column(name = "CPT_EXCESS_AMT", precision = 23, scale = 5)
    private BigDecimal cptExcessAmt;

    /**
     * Indicates whether excess is allowed for the peril.
     */
    @Column(name = "CPT_EXCESS_ALLOWED", length = 1)
    private String cptExcessAllowed;

    /**
     * Reinsurance amount for the peril.
     */
    @Column(name = "CPT_REIN_AMT", precision = 23, scale = 5)
    private BigDecimal cptReinAmt;

    /**
     * Salvage amount for the peril.
     */
    @Column(name = "CPT_SALVAGE_AMT", precision = 23, scale = 5)
    private BigDecimal cptSalvageAmt;

    /**
     * Communication mode related to the peril.
     */
    @Column(name = "CPT_COMMUNICATION_MODE", length = 50)
    private String cptCommunicationMode;

    /**
     * Payment mode associated with the peril.
     */
    @Column(name = "CPT_PAYMENT_MODE", length = 50)
    private String cptPaymentMode;

    /**
     * Property code related to the peril.
     */
    @Column(name = "CPT_PRP_CODE", precision = 23, scale = 5)
    private BigDecimal cptPrpCode;

    /**
     * Main peril code associated with the claim.
     */
    @Column(name = "CPT_MAIN_PERIL_CODE", precision = 20)
    private BigDecimal cptMainPerilCode;

    /**
     * Peril rate.
     */
    @Column(name = "CPT_PERIL_RATE", precision = 22)
    private BigDecimal cptPerilRate;

    /**
     * Indicates whether liability admission has been given for the peril (N = No, Y = Yes).
     */
    @Column(name = "CPT_LIABILITY_ADDMISSION", nullable = false, length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String cptLiabilityAddmission;

    /**
     * Date of liability admission.
     */
    @Column(name = "CPT_LIAB_ADDM_DATE")
    private LocalDate cptLiabAddmDate;

    /**
     * Condition related to the liability.
     */
    @Column(name = "CPT_LIAB_CONDITION", length = 1)
    private String cptLiabCondition;

    /**
     * Indicates whether the peril has been recovered (N = No, Y = Yes).
     */
    @Column(name = "CPT_RECOVERED", length = 1)
    private String cptRecovered;

    /**
     * Date of peril recovery.
     */
    @Column(name = "CPT_RECOVER_DATE")
    private LocalDate cptRecoverDate;

    /**
     * Condition associated with the peril.
     */
    @Column(name = "CPT_CONDITION", length = 1)
    private String cptCondition;

    /**
     * Remarks related to the peril.
     */
    @Column(name = "CPT_PERIL_REMARKS", length = 200)
    private String cptPerilRemarks;

    /**
     * User who entered the data.
     */
    @Column(name = "CPT_USER", length = 50)
    private String cptUser;
}
