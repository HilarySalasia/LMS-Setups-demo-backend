package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.LmsProdOptions;
import com.turnquest.setupsdemo.model.LmsProdSaPremLimits;
import com.turnquest.setupsdemo.model.LmsProducts;
import com.turnquest.setupsdemo.repository.LmsProdOptionsRepository;
import com.turnquest.setupsdemo.repository.LmsProdSaPremLimitsRepository;
import com.turnquest.setupsdemo.repository.LmsProductRepository;
import com.turnquest.setupsdemo.service.LmsProdSaPremLimitsService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * Implementation of the LmsProdSaPremLimitsService interface.
 */
@Service
public class LmsProdSaPremLimitsServiceImpl implements LmsProdSaPremLimitsService {

    private final LmsProdSaPremLimitsRepository lmsProdSaPremLimitsRepository;
    private final LmsProductRepository lmsProductRepository;
    private final LmsProdOptionsRepository lmsProdOptionsRepository;
    private final MessageSource messageSource;

    public LmsProdSaPremLimitsServiceImpl(
            LmsProdSaPremLimitsRepository lmsProdSaPremLimitsRepository,
            MessageSource messageSource,
            LmsProductRepository lmsProductRepository,
            LmsProdOptionsRepository lmsProdOptionsRepository) {
        this.lmsProdSaPremLimitsRepository = lmsProdSaPremLimitsRepository;
        this.lmsProductRepository = lmsProductRepository;
        this.lmsProdOptionsRepository = lmsProdOptionsRepository;
        this.messageSource = messageSource;
    }

    @Override
    public List<LmsProdSaPremLimits> findAll() {
        return lmsProdSaPremLimitsRepository.findAll();
    }

    @Override
    public LmsProdSaPremLimits findById(Long id) {
        return lmsProdSaPremLimitsRepository.findById(id).orElseThrow(() ->
                new RuntimeException(getMessage("error.sapremlimit.notfound", new Object[]{id})));
    }

    @Override
    public LmsProdSaPremLimits save(LmsProdSaPremLimits lmsProdSaPremLimits) {
        try {
            return lmsProdSaPremLimitsRepository.save(lmsProdSaPremLimits);
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.sapremlimit.save.failed", null), e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            lmsProdSaPremLimitsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.sapremlimit.delete.failed", new Object[]{id}), e);
        }
    }

    @Override
    @Transactional
    public void insertOrUpdateSaPremLimits(LmsProdSaPremLimits lmsProdSaPremLimits) {
        try {
            if (lmsProdSaPremLimits.getPsplCode() == null) {
                // Insert new SA Prem Limits
                lmsProdSaPremLimits.setLmsProducts(findProdById(lmsProdSaPremLimits.getLmsProducts().getProdCode().longValue()));
                lmsProdSaPremLimits.setLmsProdOptions(findProdOptionById(lmsProdSaPremLimits.getLmsProdOptions().getPopCode()));
                lmsProdSaPremLimitsRepository.save(lmsProdSaPremLimits);
            } else {
                // Update existing SA Prem Limits
                LmsProdSaPremLimits existingLimit = findById(lmsProdSaPremLimits.getPsplCode());
                existingLimit.setPsplPayFreq(lmsProdSaPremLimits.getPsplPayFreq());
                existingLimit.setPsplMinPrem(lmsProdSaPremLimits.getPsplMinPrem());
                existingLimit.setPsplMaxPrem(lmsProdSaPremLimits.getPsplMaxPrem());
                existingLimit.setPsplMinSa(lmsProdSaPremLimits.getPsplMinSa());
                existingLimit.setPsplMaxSa(lmsProdSaPremLimits.getPsplMaxSa());
                existingLimit.setLmsProducts(findProdById(lmsProdSaPremLimits.getLmsProducts().getProdCode().longValue()));
                existingLimit.setPsplMinContri(lmsProdSaPremLimits.getPsplMinContri());
                existingLimit.setPsplMaxContri(lmsProdSaPremLimits.getPsplMaxContri());
                existingLimit.setPsplPaMinSa(lmsProdSaPremLimits.getPsplPaMinSa());
                existingLimit.setLmsProdOptions(findProdOptionById(lmsProdSaPremLimits.getLmsProdOptions().getPopCode()));
                existingLimit.setLmsProdCoverTypes(lmsProdSaPremLimits.getLmsProdCoverTypes());
                existingLimit.setPsplMinAge(lmsProdSaPremLimits.getPsplMinAge());
                existingLimit.setPsplMaxAge(lmsProdSaPremLimits.getPsplMaxAge());
                lmsProdSaPremLimitsRepository.save(existingLimit);
            }
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.sapremlimit.operation.failed", null), e);
        }
    }

    private LmsProducts findProdById(Long prodCode) {
        return lmsProductRepository.findById(prodCode).orElseThrow(() ->
                new RuntimeException(getMessage("error.product.notfound", new Object[]{prodCode})));
    }

    private LmsProdOptions findProdOptionById(Long popCode) {
        return lmsProdOptionsRepository.findById(popCode).orElseThrow(() ->
                new RuntimeException(getMessage("error.prodoption.notfound", new Object[]{popCode})));
    }

    @Override
    public List<LmsProdSaPremLimits> findLmsProdSaPremLimitsByPopCodeAndPctCode(Long popCode, Long pctCode) {
        return lmsProdSaPremLimitsRepository.findLmsProdSaPremLimitsByPopCodeAndPctCode(popCode, pctCode);
    }

    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }
}
