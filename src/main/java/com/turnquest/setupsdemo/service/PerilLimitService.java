package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.dto.PerilLimitResponse;

import java.math.BigDecimal;

public interface PerilLimitService {
    PerilLimitResponse getPerilLimits(
            Long perilCode, String perilType, BigDecimal si, Long covtCode, Long ipuCode
    );
}
