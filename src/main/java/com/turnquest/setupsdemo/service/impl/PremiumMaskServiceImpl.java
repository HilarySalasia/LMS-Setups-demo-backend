package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.PremiumMaskCodeDescDTO;
import com.turnquest.setupsdemo.exception.ResourceNotFoundException;
import com.turnquest.setupsdemo.model.PremiumMask;
import com.turnquest.setupsdemo.repository.PremiumMaskRepository;
import com.turnquest.setupsdemo.service.PremiumMaskService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * Service implementation for PremiumMask operations.
 */
@Service
public class PremiumMaskServiceImpl implements PremiumMaskService {
    private final PremiumMaskRepository premiumMaskRepository;
    private final MessageSource messageSource;

    public PremiumMaskServiceImpl(PremiumMaskRepository premiumMaskRepository, MessageSource messageSource) {
        this.premiumMaskRepository = premiumMaskRepository;
        this.messageSource = messageSource;
    }

    @Override
    public PremiumMask createPremiumMask(PremiumMask premiumMask) {
        return premiumMaskRepository.save(premiumMask);
    }

    @Override
    public PremiumMask updatePremiumMask(BigDecimal pmasCode, PremiumMask premiumMaskDetails) {
        PremiumMask premiumMask = premiumMaskRepository.findById(pmasCode)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("premiumMask.notFound", new Object[]{pmasCode}, Locale.getDefault())));

        premiumMask.setPmasShtDesc(premiumMaskDetails.getPmasShtDesc());
        premiumMask.setPmasDesc(premiumMaskDetails.getPmasDesc());
        premiumMask.setPmasComment(premiumMaskDetails.getPmasComment());
        premiumMask.setPmasProdCode(premiumMaskDetails.getPmasProdCode());
        premiumMask.setLmsClasses(premiumMaskDetails.getLmsClasses());
        premiumMask.setPmasDefault(premiumMaskDetails.getPmasDefault());
        premiumMask.setPmasWithBonus(premiumMaskDetails.getPmasWithBonus());
        premiumMask.setPmasSmokerLoading(premiumMaskDetails.getPmasSmokerLoading());
        premiumMask.setPmasHivLoading(premiumMaskDetails.getPmasHivLoading());
        premiumMask.setPmasDependtAnb(premiumMaskDetails.getPmasDependtAnb());
        premiumMask.setPmasRateType(premiumMaskDetails.getPmasRateType());
        premiumMask.setPmasCurCode(premiumMaskDetails.getPmasCurCode());
        premiumMask.setPmasCurDesc(premiumMaskDetails.getPmasCurDesc());

        return premiumMaskRepository.save(premiumMask);
    }

    @Override
    public PremiumMask getPremiumMaskById(BigDecimal pmasCode) {
        return premiumMaskRepository.findById(pmasCode)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("premiumMask.notFound", new Object[]{pmasCode}, Locale.getDefault())));
    }

    @Override
    public List<PremiumMask> getAllPremiumMasks() {
        return premiumMaskRepository.findAll();
    }

    @Override
    public void deletePremiumMask(BigDecimal pmasCode) {
        PremiumMask premiumMask = premiumMaskRepository.findById(pmasCode)
                .orElseThrow(() -> new ResourceNotFoundException(
                        messageSource.getMessage("premiumMask.notFound", new Object[]{pmasCode}, Locale.getDefault())));
        premiumMaskRepository.delete(premiumMask);
    }

    @Override
    public List<PremiumMask> findByProdCodeAndClassType(BigDecimal prodCode, String claType) {
        return premiumMaskRepository.findByProdCodeAndClassType(prodCode, claType);
    }

    @Override
    public List<PremiumMaskCodeDescDTO> findPremiumMaskTreeDetails(BigDecimal prodCode,String claType) {
        return premiumMaskRepository.findPremiumMaskTreeDetails(prodCode, claType);
    }
}
