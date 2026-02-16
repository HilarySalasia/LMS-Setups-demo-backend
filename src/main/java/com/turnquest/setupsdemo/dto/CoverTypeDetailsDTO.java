package com.turnquest.setupsdemo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CoverTypeDetailsDTO {

    private Long pctCode;
    private String cvtDesc;

    // Constructors, getters, and setters
    public CoverTypeDetailsDTO(Long pctCode, String cvtDesc) {
        this.pctCode = pctCode;
        this.cvtDesc = cvtDesc;
    }
}
