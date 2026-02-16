package com.turnquest.setupsdemo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCodeDescDto {
    private BigDecimal prodCode;
    private String prodDesc;


    public ProductCodeDescDto(BigDecimal prodCode, String prodDesc) {
        this.prodCode = prodCode;
        this.prodDesc = prodDesc;
    }
}
