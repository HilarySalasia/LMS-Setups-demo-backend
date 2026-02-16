package com.turnquest.setupsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ClaimPerilRevisionDto {
    private String plOrTl;
    private BigDecimal clmpReserveAmt;
    private Long clmpCode;
    private BigDecimal cmbIpuValue;
    private Long clmpGgtTransNo;
    private String clmpType;
    private Long clmpPerPtCode;
    private String clmpOverride;
}
