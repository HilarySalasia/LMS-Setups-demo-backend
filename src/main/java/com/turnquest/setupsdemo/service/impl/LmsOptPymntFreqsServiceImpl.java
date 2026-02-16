package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.LmsOptPymntFreqs;
import com.turnquest.setupsdemo.repository.LmsOptPymntFreqsRepository;
import com.turnquest.setupsdemo.service.LmsOptPymntFreqsService;
import com.turnquest.setupsdemo.service.LmsProdOptionsService;
import jakarta.transaction.Transactional;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Implementation of the LmsOptPymntFreqsService interface.
 */
@Service
public class LmsOptPymntFreqsServiceImpl implements LmsOptPymntFreqsService {

    private final LmsOptPymntFreqsRepository lmsOptPymntFreqsRepository;
    private final LmsProdOptionsService lmsProdOptionsService;
    private final MessageSource messageSource;

    /**
     * Constructor for LmsOptPymntFreqsServiceImpl.
     *
     * @param lmsOptPymntFreqsRepository the repository for LMS Opt Pymnt Freqs.
     * @param messageSource              the message source for i18n.
     */
    public LmsOptPymntFreqsServiceImpl(
            LmsOptPymntFreqsRepository lmsOptPymntFreqsRepository,
            MessageSource messageSource,
            LmsProdOptionsService lmsProdOptionsService
    ) {
        this.lmsOptPymntFreqsRepository = lmsOptPymntFreqsRepository;
        this.lmsProdOptionsService = lmsProdOptionsService;
        this.messageSource = messageSource;
    }

    @Override
    public List<LmsOptPymntFreqs> findAll() {
        return lmsOptPymntFreqsRepository.findAll();
    }

    @Override
    public LmsOptPymntFreqs findById(Long id) {
        return lmsOptPymntFreqsRepository.findById(id).orElseThrow(() ->
                new RuntimeException(getMessage("error.paymentfrequency.notfound", new Object[]{id})));
    }

    @Override
    public LmsOptPymntFreqs save(LmsOptPymntFreqs lmsOptPymntFreqs) {
        try {
            return lmsOptPymntFreqsRepository.save(lmsOptPymntFreqs);
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.paymentfrequency.save.failed", null), e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            lmsOptPymntFreqsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.paymentfrequency.delete.failed", new Object[]{id}), e);
        }
    }

    @Override
    @Transactional
    public void insertOrUpdatePaymentFrequency(Long opfCode, String freqPymnt, Long popCode, Date wef, Date wet) {
        try {
            if (opfCode == null) {
                // Insert new payment frequency
                LmsOptPymntFreqs newFreq = new LmsOptPymntFreqs();
                newFreq.setOpfCode(generateOpfCode());
                newFreq.setOpfPymntFeq(freqPymnt);
                newFreq.setLmsProdOptions(lmsProdOptionsService.findProdOptionById(popCode));
                newFreq.setOpfWef(wef);
                newFreq.setOpfWet(wet);
                lmsOptPymntFreqsRepository.save(newFreq);
            } else {
                // Update existing payment frequency
                LmsOptPymntFreqs existingFreq = findById(opfCode);
                existingFreq.setOpfPymntFeq(freqPymnt);
                existingFreq.setOpfWef(wef);
                existingFreq.setOpfWet(wet);
                lmsOptPymntFreqsRepository.save(existingFreq);
            }

            // Check for existing records with the same payment frequency and dates
            checkForDuplicateFrequency(popCode, freqPymnt, wef, wet);

        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.paymentfrequency.operation.failed", null), e);
        }
    }

    private Long generateOpfCode() {
        // Custom logic to generate OPF_CODE as per TO_NUMBER(TO_CHAR(SYSDATE, 'RRRR')) || sequence
        return Long.parseLong(String.valueOf(System.currentTimeMillis()) + getNextOpfCodeSequence());
    }

    private Long getNextOpfCodeSequence() {
        // Logic to get the next value from the sequence (can be customized)
        return lmsOptPymntFreqsRepository.getNextOpfCodeSequence();
    }



    private void checkForDuplicateFrequency(Long popCode, String freqPymnt, Date wef, Date wet) {
        // Logic to check for existing records with the same payment frequency and dates
        long count = lmsOptPymntFreqsRepository.countByPopCodeAndFreqPymntAndWef(popCode, freqPymnt, wef, wet);
        if (count > 1) {
            throw new RuntimeException(getMessage("error.paymentfrequency.duplicate", new Object[]{wef}));
        }
    }

    @Override
    public List<LmsOptPymntFreqs> findLmsOptPymntFreqsByPopCode(Long popCode) {
        return lmsOptPymntFreqsRepository.findLmsOptPymntFreqsByLmsProdOptions_PopCode(popCode);
    }

    /**
     * Helper method to retrieve messages from the message source.
     *
     * @param code the message code.
     * @param args the message arguments.
     * @return the localized message.
     */
    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }
}
