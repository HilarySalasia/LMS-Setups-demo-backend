package com.turnquest.setupsdemo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

@Data
public class SclPerilsRecDto {

    private Long spPerCode;
    private Long mainperilcode;
    private String spPerShtDesc;
    private String mainperil;
    private String perDesc;
    private String spPerilType;
    private BigDecimal spPerilLimit;
    private String spSiOrLimit;
    private BigDecimal excess;
    private String excessType;
    private String perilLvl;
    private Long perilCode;
    private BigDecimal perAmount;
    private String siOrLimit;
    private String ssPrExpireOnClaim;
    private BigDecimal clmpPenaltyAmt;
    private BigDecimal ssPrSalvagePct;
    private BigDecimal ssPrDepreciationPct;
    private BigDecimal clmpTotalReserve;
    private BigDecimal clmpOrigReserveAmt;
    private BigDecimal clmpClaimAmt;
    private BigDecimal clmpAdjAmt;
    private String perPaymentType;
    private BigDecimal clmpCode;
    private BigDecimal sectCode;
    private String sectShtDesc;
    private String sectDesc;
    private Long ssprmCode;
    private BigDecimal multiplier;
    private String clmpClaimant;
    private BigDecimal clmpRegClmtCode;
    private BigDecimal clmpApcoCode;
    private BigDecimal clmpRegCldCode;
    private String cldName;
    private String reinstateApp;
    private BigDecimal clmpNoviceExcessAmt;
    private String clmpLiabAdmission;
    private LocalDate clmpLiabDate;
    private BigDecimal perilUwRate;
    private String ssPrSiOrLimit;
    private BigDecimal cptCode;
}
