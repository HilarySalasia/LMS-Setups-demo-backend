package com.turnquest.setupsdemo.model;

import com.turnquest.setupsdemo.model.compositeKeys.GinCoinsurersId;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

/**
 * Stores details of coinsurers, insurance companies that agree to insure a risk jointly.
 */
@Entity
@Table(name = "GIN_COINSURERS")
@Data
public class GinCoinsurers {

    @EmbeddedId
    private GinCoinsurersId id; // Composite key consisting of Agent Code and Policy Batch Number

    @Column(name = "COIN_AGNT_SHT_DESC", nullable = false, length = 15)
    private String coinAgntShtDesc; // Agent Short Description

    @Column(name = "COIN_GL_CODE", length = 20)
    private String coinGlCode; // GL Code

    @Column(name = "COIN_LEAD", length = 1)
    private String coinLead; // Lead Flag

    @Column(name = "COIN_PERCT", precision = 22, scale = 5)
    private BigDecimal coinPerct; // Percentage

    @Column(name = "COIN_PREM", precision = 22, scale = 5)
    private BigDecimal coinPrem; // Premium

    @Column(name = "COIN_ALP_PROPOSAL_NO", length = 8)
    private String coinAlpProposalNo; // Proposal Number

    @Column(name = "COIN_POL_POLICY_NO", length = 50)
    private String coinPolPolicyNo; // Policy Number

    @Column(name = "COIN_POL_REN_ENDOS_NO", length = 50)
    private String coinPolRenEndosNo; // Endorsement Number

    @Column(name = "COIN_FEE_RATE", precision = 25, scale = 5)
    private BigDecimal coinFeeRate; // Fee Rate

    @Column(name = "COIN_FEE_AMT", precision = 25, scale = 5)
    private BigDecimal coinFeeAmt; // Fee Amount

    @Column(name = "COIN_PREM_TAX", precision = 30, scale = 5)
    private BigDecimal coinPremTax; // Premium Tax

    @Column(name = "COIN_DUTIES", precision = 30, scale = 5)
    private BigDecimal coinDuties; // Duties

    @Column(name = "COIN_SI", precision = 30, scale = 5)
    private BigDecimal coinSi; // Sum Insured

    @Column(name = "COIN_ANNUAL_PREM", precision = 22, scale = 5)
    private BigDecimal coinAnnualPrem; // Annual Premium

    @Column(name = "COIN_FEE_TYPE", length = 3)
    private String coinFeeType; // Fee Type

    @Column(name = "COIN_FORCE_SF_COMPUTE", length = 1)
    private String coinForceSfCompute; // Enforces if coinsurance fee is to be computed

    @Column(name = "COIN_COINSURERS_POLNO", length = 50)
    private String coinCoinsurersPolno; // Coinsurance Policy Number

    @Column(name = "COIN_COMMISSION", precision = 22, scale = 5)
    private BigDecimal coinCommission; // Commission

    @Column(name = "COIN_WHTX", precision = 22, scale = 5)
    private BigDecimal coinWhtx; // Withholding Tax

    @Column(name = "COIN_DR_CR_NO", length = 20)
    private String coinDrCrNo; // Debit/Credit Note Number

    @Column(name = "COIN_AGA_CODE", precision = 22)
    private Long coinAgaCode; // Agent Code

    @Column(name = "COIN_AGA_SHT_DESC", length = 15)
    private String coinAgaShtDesc; // Agent Short Description

    @Column(name = "COIN_COM_DISC_AMT", precision = 25, scale = 5)
    private BigDecimal coinComDiscAmt; // Commission Discount Amount

    @Column(name = "COIN_VAT_AMT", precision = 23, scale = 5)
    private BigDecimal coinVatAmt; // VAT Amount

    @Column(name = "COIN_OPTIONAL_COMM", length = 1)
    private String coinOptionalComm; // Optional Commission

    @Column(name = "COIN_COMM_RATE", precision = 22, scale = 5)
    private BigDecimal coinCommRate; // Commission Rate

    @Column(name = "COIN_OTHER_CLIENT_DEDUCTIBLES", precision = 22)
    private Long coinOtherClientDeductibles; // Other Client Deductibles

    @Column(name = "COIN_PREMIUM_TAX", precision = 22)
    private Long coinPremiumTax; // Premium Tax

    @Column(name = "COIN_COMM_TYPE", length = 1)
    private String coinCommType; // Commission Type

    @Column(name = "COIN_FAC_CESSION", length = 1)
    private String coinFacCession; // Facultative Cession

    @Column(name = "COIN_FAC_PC", precision = 22)
    private Long coinFacPc; // Facultative Percentage

    @Column(name = "COIN_OTHER_COM_CHARGES", precision = 22, scale = 5)
    private BigDecimal coinOtherComCharges; // Other Commission Charges

    @Column(name = "COIN_MKTR_COM_AMT", precision = 22, scale = 5)
    private BigDecimal coinMktrComAmt; // Marketer Commission Amount

    @Column(name = "COIN_COMM_LEVY_AMT", precision = 22)
    private Long coinCommLevyAmt; // Commission Levy Amount

    @Column(name = "COIN_APPOINTED_BY_INSURER", length = 1)
    private String coinAppointedByInsurer; // Appointed by Insurer

    @Column(name = "COIN_POLNO_EXIST", length = 1)
    private String coinPolnoExist; // Policy Number Exists

    @Column(name = "COIN_POLICY_NO", length = 50)
    private String coinPolicyNo; // Policy Number

    @Column(name = "COIN_EXCISE_DUTY", length = 100)
    private String coinExciseDuty; // Excise Duty
}
