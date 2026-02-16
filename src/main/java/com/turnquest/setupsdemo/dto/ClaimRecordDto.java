package com.turnquest.setupsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ClaimRecordDto {
    private Long sclCode;
    private String claimNo;
    private Long cmbCurCode;
    private int uwYear;
    private Long cmbEveCode;
    private String cmbEveShtDesc;
    private BigDecimal incurred;
    private BigDecimal xchangerate;
}
