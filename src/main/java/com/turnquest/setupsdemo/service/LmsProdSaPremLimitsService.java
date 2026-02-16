package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.LmsProdSaPremLimits;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service interface for managing LMS Prod Sa Prem Limits.
 */
public interface LmsProdSaPremLimitsService {

    List<LmsProdSaPremLimits> findAll();

    LmsProdSaPremLimits findById(Long id);

    LmsProdSaPremLimits save(LmsProdSaPremLimits lmsProdSaPremLimits);

    void deleteById(Long id);

    void insertOrUpdateSaPremLimits(LmsProdSaPremLimits lmsProdSaPremLimits);

    List<LmsProdSaPremLimits> findLmsProdSaPremLimitsByPopCodeAndPctCode(Long popCode, Long pctCode);
}