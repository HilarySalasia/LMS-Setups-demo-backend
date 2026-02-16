package com.turnquest.setupsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class UnauthorizedTransactionDto {
    private Long transno;
    private BigDecimal incurred;
    private BigDecimal xchangerate;
}
