package com.turnquest.setupsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class GetPerilLimitsRequest {
    private BigDecimal vPerilCode;
    private String vPerilType;
    private BigDecimal vSi;
    private BigDecimal vCovtCode;
    private BigDecimal vIpuCode;
    private BigDecimal vDepRate;
}