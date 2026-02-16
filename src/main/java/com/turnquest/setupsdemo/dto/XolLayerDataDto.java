package com.turnquest.setupsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class XolLayerDataDto {
    private Long xolsCode;
    private Long xolCode;
    private Long xasCode;
    private String startLayer;
    private String maxLayer;
    private Long xolvmCode;
    private BigDecimal deductible;
    private BigDecimal maxClaimLimit;
    private BigDecimal currentRecvdAmt;
    private BigDecimal newRetention;
    private BigDecimal newRecvdAmt;
    private BigDecimal excessBalance;
}