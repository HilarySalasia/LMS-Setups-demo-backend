package com.turnquest.setupsdemo.service;



import com.turnquest.setupsdemo.dto.PremiumMaskCodeDescDTO;
import com.turnquest.setupsdemo.model.PremiumMask;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service interface for PremiumMask operations.
 */
public interface PremiumMaskService {
    PremiumMask createPremiumMask(PremiumMask premiumMask);
    PremiumMask updatePremiumMask(BigDecimal pmasCode, PremiumMask premiumMaskDetails);
    PremiumMask getPremiumMaskById(BigDecimal pmasCode);
    List<PremiumMask> getAllPremiumMasks();
    void deletePremiumMask(BigDecimal pmasCode);
    List<PremiumMask> findByProdCodeAndClassType(BigDecimal prodCode, String claType);

    List<PremiumMaskCodeDescDTO> findPremiumMaskTreeDetails(BigDecimal prodCode, String claType);
}
