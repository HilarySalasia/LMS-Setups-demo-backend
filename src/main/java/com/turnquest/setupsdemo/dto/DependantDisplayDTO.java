package com.turnquest.setupsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class DependantDisplayDTO {
    private Long pcdCode;
    private String dependantDisplay;
    private Long pcdProdCode;
    private Long pctCode;
    private BigDecimal dtyCode;
    private String pcdDtyShtDesc;
    private BigDecimal pcdMaxNoAllowed;
    private BigDecimal pcdMinAge;
    private BigDecimal pcdMaxAge;
    private BigDecimal pcdMaxSumAssured;
    private Long cvtCode;
    private String pcdCvtShtDesc;
    private BigDecimal pcdMinSumAssrd;
    private String pcdFreqOfPay;
    private String cvtDesc;
    private String depMandatory;
    private String coverMandatory;

    // Getters and Setters
}
//Cannot resolve constructor 'com.turnquest.setupsdemo.dto.DependantDisplayDTO(
//java.lang.Long,
//java.lang.String,
//java.lang.Long,
//java.lang.Long,
//java.math.BigDecimal,
//java.lang.String,
//java.math.BigDecimal,
//java.math.BigDecimal,
//java.math.BigDecimal,
//java.math.BigDecimal,
//java.lang.Long,
//java.lang.String,
//java.math.BigDecimal,
//java.lang.String,
//java.lang.String,
//java.lang.String,
//java.lang.String)