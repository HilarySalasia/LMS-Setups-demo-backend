package com.turnquest.setupsdemo.dto;

import java.math.BigDecimal;
import java.sql.Date;
import lombok.Data;

@Data
public class PerilDtoII {
    private Long spPerCode;
    private String spPerShtDesc;
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
    private Long ssprmCode;
    private Long mainPerilCode;
    private BigDecimal uwrate;
    private Long clmpRegClmtCode;
    private String clmpClaimant;
    private Long clmpApcoCode;
    private Long clmpRegCldCode;
    private BigDecimal clmpNoviceExcessAmt;
    private String clmpLiabAdmission;
    private Date clmpLiabDate;
    private Long cptCode; // Added this based on your previous response

    // ... other properties if needed ...
}
