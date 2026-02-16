package com.turnquest.setupsdemo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface CreateRiCessionsService {

    void createRiCessions(String vClaimNo, Long vIpuCode, String vIpuPropertyId, BigDecimal vClmUwYr,
                          BigDecimal vSclCode, BigDecimal vPolBatchNo, BigDecimal vCurCode, String vCurSymbol,
                          String vPolLoaded, LocalDate vLossDate, String vNoRi, BigDecimal vCvtCode);
}
