package com.turnquest.setupsdemo.service.impl;


import com.turnquest.setupsdemo.exception.ResourceNotFoundException;
import com.turnquest.setupsdemo.model.RateType;
import com.turnquest.setupsdemo.repository.RateTypeRepository;
import com.turnquest.setupsdemo.service.RateTypeService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Service implementation for RateType operations.
 */
@Service
public class RateTypeServiceImpl implements RateTypeService {
    private final RateTypeRepository rateTypeRepository;
    private final MessageSource messageSource;

    public RateTypeServiceImpl(RateTypeRepository rateTypeRepository, MessageSource messageSource) {
        this.rateTypeRepository = rateTypeRepository;
        this.messageSource = messageSource;
    }

    @Override
    public RateType createRateType(RateType rateType) {
        return rateTypeRepository.save(rateType);
    }

    @Override
    public RateType updateRateType(BigDecimal svtCode, RateType rateTypeDetails) {
        RateType rateType = rateTypeRepository.findById(svtCode)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("rateType.notFound", new Object[]{svtCode}, Locale.getDefault())));

        rateType.setSvtDesc(rateTypeDetails.getSvtDesc());
        rateType.setSvtAnbType(rateTypeDetails.getSvtAnbType());
        rateType.setSvtCurrentTemType(rateTypeDetails.getSvtCurrentTemType());
        rateType.setSvtPaidMatryRateFactr(rateTypeDetails.getSvtPaidMatryRateFactr());
        rateType.setSvtRateInYearsOrMonths(rateTypeDetails.getSvtRateInYearsOrMonths());
        rateType.setSvtClaCode(rateTypeDetails.getSvtClaCode());

        return rateTypeRepository.save(rateType);
    }

    @Override
    public RateType getRateTypeById(BigDecimal svtCode) {
        return rateTypeRepository.findById(svtCode)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("rateType.notFound", new Object[]{svtCode}, Locale.getDefault())));
    }

    @Override
    public List<RateType> getAllRateTypes() {
        return rateTypeRepository.findAll();
    }

    @Override
    public void deleteRateType(BigDecimal svtCode) {
        RateType rateType = rateTypeRepository.findById(svtCode)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("rateType.notFound", new Object[]{svtCode}, Locale.getDefault())));
        rateTypeRepository.delete(rateType);
    }

    @Override
    public Optional<RateType> findBySvtCode(BigDecimal svtCode) {
        return rateTypeRepository.findBySvtCode(svtCode);
    }
}
