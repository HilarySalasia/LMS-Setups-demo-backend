package com.turnquest.setupsdemo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdOptionCodeDescDTO {
    private Long popCode;
    private String popDesc;

    // Constructors, getters, and setters
    public ProdOptionCodeDescDTO(Long popCode, String popDesc) {
        this.popCode = popCode;
        this.popDesc = popDesc;
    }
}