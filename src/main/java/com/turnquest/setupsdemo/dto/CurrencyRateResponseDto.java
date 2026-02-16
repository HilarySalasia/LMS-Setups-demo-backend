package com.turnquest.setupsdemo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyRateResponseDto {
    private BigDecimal vRate;
    private Integer vRound;
    private Integer vBcurRound;
}