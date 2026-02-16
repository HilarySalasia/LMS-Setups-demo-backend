package com.turnquest.setupsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
//@AllArgsConstructor
public class PerilLimit {
    private Long sectCode;
    private BigDecimal perilLimit;
    private String type;
    private String siOrLimit;
    private String excessType;
    private BigDecimal excess;
    private BigDecimal excessMin;
    private BigDecimal excessMax;
    private BigDecimal personLimit;
    private BigDecimal claimLimit;
    private BigDecimal depRate;
    private BigDecimal multplier;
    private Long excessPerilSectCode;
}