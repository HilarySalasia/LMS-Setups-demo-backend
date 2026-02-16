package com.turnquest.setupsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionCoverTypeDto {
    private String opbCode;
    private String opbPopCode;
    private String opbPctCode;
    private String opbMandatory;
    private String benId;
    private String benDesc;
    private String pctDepenadntRate;
    private String opbMainSaPerc;
    private String opbExcludeAtEscl;
    private String opbSurrenderAllowed;
    private String opbSurrenderValFormula;
    private String opbSvtCode;
    private String svtDesc;
    private String opbWithBonus;
}