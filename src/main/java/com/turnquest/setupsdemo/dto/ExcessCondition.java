package com.turnquest.setupsdemo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExcessCondition {
    private String condName;
    private String condOptr;
    private BigDecimal condValue1;
    private BigDecimal condValue2;

}