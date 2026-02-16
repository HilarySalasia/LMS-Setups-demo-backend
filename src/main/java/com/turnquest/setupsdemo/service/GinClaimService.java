package com.turnquest.setupsdemo.service;

import java.math.BigDecimal;

public interface GinClaimService {
    BigDecimal getOsReserve(String vClaimNo, String vAuth);

    BigDecimal getTotalOsPerInsured(String vClaimNo, Long vCldCode);
}