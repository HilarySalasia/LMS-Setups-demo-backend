package com.turnquest.setupsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class TreatyDetailsDTO {

    private Long ptotrCode;
    private Long ptotrRiskCurCode;
    private Long ptotrTrtCurCode;
    private Long ptotrReiCode;
    private Long ptotrTrtCode;
    private String ptotrTrtShtDesc;
    private Long ptotrCltSclCode;
    private BigDecimal ptotrCessionPct;
    private Long ptotrUwyr;
    private Long ptotrIpuCode;
    private Long ptotrPolBatchNo;
    private String ptotrRiskCurSymbol;
    private String ptotrTrtCurSymbol;
    private Long ptotrTaCode;
    private Long ptotrAsCode;
    private Long ptotrTrsCode;
    private String ptotrTrsShtDesc;
    private String taType;
    private Date ptotrDate;
    private Long taCode;
    private Long reiNextReiCode;
}
