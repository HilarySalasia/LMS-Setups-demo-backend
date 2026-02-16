package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.CoverTypeDetailsDTO;
import com.turnquest.setupsdemo.dto.OptionBenefitPopCodePopDescOpbCodeDto;
import com.turnquest.setupsdemo.exception.ResourceNotFoundException;
import com.turnquest.setupsdemo.model.OptBenefit;
import com.turnquest.setupsdemo.repository.OptBenefitRepository;
import com.turnquest.setupsdemo.service.OptBenefitService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * Service implementation for OptBenefit operations.
 */
@Service
public class OptBenefitServiceImpl implements OptBenefitService {
    private final OptBenefitRepository optBenefitRepository;
    private final MessageSource messageSource;

    public OptBenefitServiceImpl(OptBenefitRepository optBenefitRepository, MessageSource messageSource) {
        this.optBenefitRepository = optBenefitRepository;
        this.messageSource = messageSource;
    }

    @Override
    public OptBenefit createOptBenefit(OptBenefit optBenefit) {
        return optBenefitRepository.save(optBenefit);
    }

    @Override
    public OptBenefit updateOptBenefit(BigDecimal opbCode, OptBenefit optBenefitDetails) {
        OptBenefit optBenefit = optBenefitRepository.findById(opbCode)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("optBenefit.notFound", new Object[]{opbCode}, Locale.getDefault())));

        optBenefit.setProductOption(optBenefitDetails.getProductOption());
        optBenefit.setProdCoverType(optBenefitDetails.getProdCoverType());
        optBenefit.setOpbMandatory(optBenefitDetails.getOpbMandatory());
        optBenefit.setOpbMainSaPerc(optBenefitDetails.getOpbMainSaPerc());
        optBenefit.setOpbExcludeAtEscl(optBenefitDetails.getOpbExcludeAtEscl());
        optBenefit.setOpbSurrenderAllowed(optBenefitDetails.getOpbSurrenderAllowed());
        optBenefit.setOpbSurrenderValFormula(optBenefitDetails.getOpbSurrenderValFormula());
        optBenefit.setRateType(optBenefitDetails.getRateType());
        optBenefit.setOpbWithBonus(optBenefitDetails.getOpbWithBonus());

        return optBenefitRepository.save(optBenefit);
    }

    @Override
    public OptBenefit getOptBenefitById(BigDecimal opbCode) {
        return optBenefitRepository.findById(opbCode)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("optBenefit.notFound", new Object[]{opbCode}, Locale.getDefault())));
    }

    @Override
    public List<OptBenefit> getAllOptBenefits() {
        return optBenefitRepository.findAll();
    }

    @Override
    public void deleteOptBenefit(BigDecimal opbCode) {
        OptBenefit optBenefit = optBenefitRepository.findById(opbCode)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("optBenefit.notFound", new Object[]{opbCode}, Locale.getDefault())));
        optBenefitRepository.delete(optBenefit);
    }

    @Override
    public List<OptBenefit> findByOpbPopCode(BigDecimal popCode) {
        return optBenefitRepository.findByOpbPopCode(popCode);
    }

    @Override
    public List<OptionBenefitPopCodePopDescOpbCodeDto>
    findProdOptionDetailsByProdCode(BigDecimal prodCode) {
        return optBenefitRepository.findProdOptionDetailsByProdCode(prodCode);
    }

    @Override
    public List<CoverTypeDetailsDTO> findCoverTypesDetailsByPopCodeAndObpCode(BigDecimal popCode) {
        return optBenefitRepository.findCoverTypesDetailsByPopCodeAndObpCode(popCode);
    }
}
