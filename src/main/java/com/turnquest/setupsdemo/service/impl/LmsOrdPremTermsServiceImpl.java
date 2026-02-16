package com.turnquest.setupsdemo.service.impl;


import com.turnquest.setupsdemo.model.LmsOrdPremTerms;
import com.turnquest.setupsdemo.repository.LmsOrdPremTermsRepository;
import com.turnquest.setupsdemo.service.LmsOrdPremTermsService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Implementation of the LmsOrdPremTermsService interface.
 */
@Service
public class LmsOrdPremTermsServiceImpl implements LmsOrdPremTermsService {

    private final LmsOrdPremTermsRepository lmsOrdPremTermsRepository;
    private final MessageSource messageSource;

    public LmsOrdPremTermsServiceImpl(LmsOrdPremTermsRepository lmsOrdPremTermsRepository, MessageSource messageSource) {
        this.lmsOrdPremTermsRepository = lmsOrdPremTermsRepository;
        this.messageSource = messageSource;
    }

    @Override
    public List<LmsOrdPremTerms> findAll() {
        return lmsOrdPremTermsRepository.findAll();
    }

    @Override
    public LmsOrdPremTerms findById(Long id) {
        return lmsOrdPremTermsRepository.findById(id).orElseThrow(() ->
                new RuntimeException(getMessage("error.ordpremterms.notfound", new Object[]{id})));
    }

    @Override
    public LmsOrdPremTerms save(LmsOrdPremTerms lmsOrdPremTerms) {
        try {
            return lmsOrdPremTermsRepository.save(lmsOrdPremTerms);
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.save.failed", null), e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            lmsOrdPremTermsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.ordpremterms.delete.failed", new Object[]{id}), e);
        }
    }

    @Override
    @Transactional
    public void insertOrUpdateOrdPremTerms(LmsOrdPremTerms lmsOrdPremTerms) {
        try {
            Optional<LmsOrdPremTerms> existingTerm = lmsOrdPremTermsRepository.findByOptTermFromAndOptTermToAndLmsProdCoverTypes_PctCodeAndLmsProdOptions_PopCodeAndLmsPremiumMasks_PmasCode(
                    lmsOrdPremTerms.getOptTermFrom(),
                    lmsOrdPremTerms.getOptTermTo(),
                    lmsOrdPremTerms.getLmsProdCoverTypes().getPctCode(),
                    lmsOrdPremTerms.getLmsProdOptions().getPopCode(),
                    lmsOrdPremTerms.getLmsPremiumMasks().getPmasCode().longValue()
            );

            if (existingTerm.isPresent()) {
                LmsOrdPremTerms existingPremTerm = existingTerm.get();
                lmsOrdPremTerms.setOptCode(existingPremTerm.getOptCode());
                lmsOrdPremTermsRepository.save(lmsOrdPremTerms);
            } else {
                lmsOrdPremTerms.setOptCode(null);  // Ensure new ID is generated
                lmsOrdPremTermsRepository.save(lmsOrdPremTerms);
            }
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.ordpremterms.operation.failed", null), e);
        }
    }

    @Override
    public List<LmsOrdPremTerms> findByPctCode(String pctCode) {
        return lmsOrdPremTermsRepository.findByPctCode(pctCode);
    }

    @Override
    public List<LmsOrdPremTerms> findByPopCode(BigDecimal popCode) {
        return lmsOrdPremTermsRepository.findByPopCode(popCode);
    }

    public List<LmsOrdPremTerms> findByPctCodeAndPopCode(BigDecimal pctCode, BigDecimal popCode) {
        return lmsOrdPremTermsRepository.findByPctCodeAndPopCode(pctCode, popCode);
    }


    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }
}
