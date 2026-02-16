package com.turnquest.setupsdemo.service;

import java.math.BigDecimal;

public interface ExcessConditionService {

    BigDecimal getExcessAmount(Long vCexCode, BigDecimal vUwAmnt, BigDecimal vClmAmnt, String vPlOrTl, Long vIpuCode);

    String excessConditionTrue(Long vSsexCode, String vClaimNo, String vMotorProduct);
}
