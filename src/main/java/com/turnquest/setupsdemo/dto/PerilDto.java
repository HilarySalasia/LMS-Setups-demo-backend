package com.turnquest.setupsdemo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PerilDto {
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
    private Long mainPeril;
    private BigDecimal uwrate;
}