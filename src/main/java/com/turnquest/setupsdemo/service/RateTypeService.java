package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.RateType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for RateType operations.
 */
public interface RateTypeService {
    RateType createRateType(RateType rateType);
    RateType updateRateType(BigDecimal svtCode, RateType rateTypeDetails);
    RateType getRateTypeById(BigDecimal svtCode);
    List<RateType> getAllRateTypes();
    void deleteRateType(BigDecimal svtCode);

    Optional<RateType> findBySvtCode(BigDecimal svtCode);

}
