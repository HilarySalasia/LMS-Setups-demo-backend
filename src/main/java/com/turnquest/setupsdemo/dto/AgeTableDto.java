package com.turnquest.setupsdemo.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AgeTableDto {
    private BigDecimal latCode;
    private BigDecimal latAgeFrom;
    private BigDecimal latAgeTo;
}
