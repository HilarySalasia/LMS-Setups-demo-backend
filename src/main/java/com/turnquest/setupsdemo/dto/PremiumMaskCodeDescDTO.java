package com.turnquest.setupsdemo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.function.BiFunction;

@Data
public class PremiumMaskCodeDescDTO {
    private BigDecimal pmasCode;
    private String pmasDesc;
    private BigDecimal pmasProdCode;

    // Constructors, getters, and setters
    public PremiumMaskCodeDescDTO(BigDecimal pmasCode, String pmasDesc, BigDecimal pmasProdCode) {
        this.pmasCode = pmasCode;
        this.pmasDesc = pmasDesc;
        this.pmasProdCode = pmasProdCode;
    }
}