package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.dto.CoverTypeDetailsDTO;
import com.turnquest.setupsdemo.dto.OptionBenefitPopCodePopDescOpbCodeDto;
import com.turnquest.setupsdemo.model.OptBenefit;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service interface for OptBenefit operations.
 */
public interface OptBenefitService {
    OptBenefit createOptBenefit(OptBenefit optBenefit);
    OptBenefit updateOptBenefit(BigDecimal opbCode, OptBenefit optBenefitDetails);
    OptBenefit getOptBenefitById(BigDecimal opbCode);
    List<OptBenefit> getAllOptBenefits();
    void deleteOptBenefit(BigDecimal opbCode);
    List<OptBenefit> findByOpbPopCode(BigDecimal popCode);

    List<OptionBenefitPopCodePopDescOpbCodeDto>
    findProdOptionDetailsByProdCode(BigDecimal prodCode);

    List<CoverTypeDetailsDTO> findCoverTypesDetailsByPopCodeAndObpCode(BigDecimal popCode);
}
