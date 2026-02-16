package com.turnquest.setupsdemo.service.impl;


import com.turnquest.setupsdemo.model.LmsProdOptAnnPayout;
import com.turnquest.setupsdemo.repository.LmsProdOptAnnPayoutRepository;
import com.turnquest.setupsdemo.service.LmsProdOptAnnPayoutService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

/**
 * Implementation of the LmsProdOptAnnPayoutService interface.
 */
@Service
public class LmsProdOptAnnPayoutServiceImpl implements LmsProdOptAnnPayoutService {

    private final LmsProdOptAnnPayoutRepository lmsProdOptAnnPayoutRepository;
    private final MessageSource messageSource;

    public LmsProdOptAnnPayoutServiceImpl(LmsProdOptAnnPayoutRepository lmsProdOptAnnPayoutRepository, MessageSource messageSource) {
        this.lmsProdOptAnnPayoutRepository = lmsProdOptAnnPayoutRepository;
        this.messageSource = messageSource;
    }

    @Override
    public List<LmsProdOptAnnPayout> findAll() {
        return lmsProdOptAnnPayoutRepository.findAll();
    }

    @Override
    public LmsProdOptAnnPayout findById(Long id) {
        return lmsProdOptAnnPayoutRepository.findById(id).orElseThrow(() ->
                new RuntimeException(getMessage("error.annpayout.notfound", new Object[]{id})));
    }

    @Override
    public LmsProdOptAnnPayout save(LmsProdOptAnnPayout lmsProdOptAnnPayout) {
        try {
            return lmsProdOptAnnPayoutRepository.save(lmsProdOptAnnPayout);
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.annpayout.save.failed", null), e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            lmsProdOptAnnPayoutRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.annpayout.delete.failed", new Object[]{id}), e);
        }
    }

    @Override
    @Transactional
    public void insertOrUpdateAnnPayout(LmsProdOptAnnPayout lmsProdOptAnnPayout) {
        try {
            if (lmsProdOptAnnPayout.getPopaCode() == null) {
                // Insert new Ann Payout
                lmsProdOptAnnPayoutRepository.save(lmsProdOptAnnPayout);
            } else {
                // Update existing Ann Payout
                LmsProdOptAnnPayout existingPayout = findById(lmsProdOptAnnPayout.getPopaCode());
                existingPayout.setLmsProdOptions(lmsProdOptAnnPayout.getLmsProdOptions());
                existingPayout.setPopaDayFrom(lmsProdOptAnnPayout.getPopaDayFrom());
                existingPayout.setPopaDayTo(lmsProdOptAnnPayout.getPopaDayTo());
                existingPayout.setPopaPaymentDay(lmsProdOptAnnPayout.getPopaPaymentDay());
                existingPayout.setPopaCurMonth(lmsProdOptAnnPayout.getPopaCurMonth());
                lmsProdOptAnnPayoutRepository.save(existingPayout);
            }
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.annpayout.operation.failed", null), e);
        }
    }


    @Override
    public List<LmsProdOptAnnPayout> findLmsProdOptAnnPayoutByLmsProdOptions_PopCode(Long popCode) {
        return lmsProdOptAnnPayoutRepository.findLmsProdOptAnnPayoutByLmsProdOptions_PopCode(popCode);
    }

    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }
}
