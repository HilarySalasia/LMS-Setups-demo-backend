package com.turnquest.setupsdemo.service;

import java.math.BigDecimal;
import java.util.Date;

public interface RevisionService {

    void processRevision(
            String claimNo,
            BigDecimal transNo,
            String tranType,
            Date transDate,
            BigDecimal revAmt,
            BigDecimal coinRevAmt,
            BigDecimal ipuCode,
            String user
    );

    void computeRevisionExcess(String vClaimNo, Long vIpuCode, BigDecimal vExchangeRate);
}
