package com.turnquest.setupsdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PoolRecoveryPeril {

    private Long prprdUwyr;           // Underwriting year
    private Long rpscpClaimsRate; // Claims rate
    private Long prprdPolBatchNo;   // Policy batch number
    private Long prprdSclCode;        // Subclass code
    private Long prprdRiskCurCode;    // Risk currency code
    private String curSymbol;         // Currency symbol
    private Long prprdCode;           // Pool risk product code
    private Long prprdScrprCode;      // Subclass risk code

//     Constructor to initialize all fields
}
