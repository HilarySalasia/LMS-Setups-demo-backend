package com.turnquest.setupsdemo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ReinsuranceCessionData {
    private Long cessionId;
    private String cessionType;
    private BigDecimal cessionAmount;
    private LocalDate cessionDate;
    private String reinsurerCode;
    private String reinsurerName;
    // Add other relevant fields as needed

    // Getters and Setters
}

//Additional Fields:
//
//You can add more fields to this DTO as needed, based on your specific reinsurance requirements. For example, you might need to include:
//
//cedingCompanyCode: Code for the company ceding the risk.
//
//        cedingCompanyName: Name of the company ceding the risk.
//
//        policyNumber: Policy number associated with the reinsurance cession.
//
//        riskCode: Code identifying the specific risk covered by the reinsurance cession.
//
//perilCode: Code identifying the peril covered by the reinsurance cession.
//
//        premiumAmount: Premium amount associated with the reinsurance cession.
//
//        retentionAmount: Retention amount for the ceding company.
//
//        sharePercentage: Share percentage of the risk ceded to the reinsurer.
//
//        cededAmount: Amount ceded to the reinsurer.
//
//        cededPremium: Premium ceded to the reinsurer.
//
//        cededRetention: Retention amount ceded to the reinsurer.
