package com.turnquest.setupsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PerilLimitResponse {
    private BigDecimal pLimit;
    private BigDecimal eLimit;
    private BigDecimal depRate;
    private BigDecimal multplier;
}