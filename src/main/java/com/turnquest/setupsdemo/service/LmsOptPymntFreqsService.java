package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.LmsOptPymntFreqs;

import java.util.Date;
import java.util.List;

/**
 * Service interface for managing LMS Opt Pymnt Freqs.
 */
public interface LmsOptPymntFreqsService {

    /**
     * Get all payment frequencies.
     *
     * @return List of all payment frequencies.
     */
    List<LmsOptPymntFreqs> findAll();

    /**
     * Get payment frequency by id.
     *
     * @param id the id of the payment frequency.
     * @return the payment frequency with the given id.
     */
    LmsOptPymntFreqs findById(Long id);

    /**
     * Save a payment frequency.
     *
     * @param lmsOptPymntFreqs the payment frequency to save.
     * @return the saved payment frequency.
     */
    LmsOptPymntFreqs save(LmsOptPymntFreqs lmsOptPymntFreqs);

    /**
     * Delete a payment frequency by id.
     *
     * @param id the id of the payment frequency to delete.
     */
    void deleteById(Long id);

    void insertOrUpdatePaymentFrequency(Long opfCode, String freqPymnt, Long popCode, Date wef, Date wet);

    List<LmsOptPymntFreqs> findLmsOptPymntFreqsByPopCode(Long popCode);
}
