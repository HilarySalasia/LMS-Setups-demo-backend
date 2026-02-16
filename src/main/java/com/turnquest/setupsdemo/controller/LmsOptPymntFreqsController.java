package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsOptPymntFreqs;
import com.turnquest.setupsdemo.service.LmsOptPymntFreqsService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * REST controller for managing LMS Opt Pymnt Freqs.
 */
@RestController
@RequestMapping("/api/payment-frequencies")
public class LmsOptPymntFreqsController {

    private final LmsOptPymntFreqsService lmsOptPymntFreqsService;
    private final MessageSource messageSource;

    /**
     * Constructor for LmsOptPymntFreqsController.
     *
     * @param lmsOptPymntFreqsService the service for LMS Opt Pymnt Freqs.
     * @param messageSource           the message source for i18n.
     */
    public LmsOptPymntFreqsController(LmsOptPymntFreqsService lmsOptPymntFreqsService, MessageSource messageSource) {
        this.lmsOptPymntFreqsService = lmsOptPymntFreqsService;
        this.messageSource = messageSource;
    }

    /**
     * Get all payment frequencies.
     *
     * @return ResponseEntity with the list of all payment frequencies.
     */
    @GetMapping
    public ResponseEntity<List<LmsOptPymntFreqs>> findAll() {
        List<LmsOptPymntFreqs> paymentFrequencies = lmsOptPymntFreqsService.findAll();
        return ResponseEntity.ok(paymentFrequencies);
    }

    /**
     * Get payment frequency by id.
     *
     * @param id the id of the payment frequency.
     * @return ResponseEntity with the payment frequency with the given id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<LmsOptPymntFreqs> findById(@PathVariable Long id) {
        LmsOptPymntFreqs paymentFrequency = lmsOptPymntFreqsService.findById(id);
        return ResponseEntity.ok(paymentFrequency);
    }

    /**
     * Save a payment frequency.
     *
     * @param lmsOptPymntFreqs the payment frequency to save.
     * @return ResponseEntity with the saved payment frequency.
     */
    @PostMapping
    public ResponseEntity<LmsOptPymntFreqs> save(@RequestBody LmsOptPymntFreqs lmsOptPymntFreqs) {
        LmsOptPymntFreqs savedPaymentFrequency = lmsOptPymntFreqsService.save(lmsOptPymntFreqs);
        return ResponseEntity.ok(savedPaymentFrequency);
    }

    /**
     * Delete a payment frequency by id.
     *
     * @param id the id of the payment frequency to delete.
     * @return ResponseEntity with status 200 (OK).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        lmsOptPymntFreqsService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/insertOrUpdate")
    public ResponseEntity<Void> insertOrUpdatePaymentFrequency(@RequestBody LmsOptPymntFreqs request) {
        lmsOptPymntFreqsService.insertOrUpdatePaymentFrequency(request.getOpfCode(), request.getOpfPymntFeq(),
                request.getLmsProdOptions().getPopCode(), request.getOpfWef(), request.getOpfWet());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-pop-code/{popCode}")
    public List<LmsOptPymntFreqs> findLmsOptPymntFreqsByLmsProdOptions_PopCode(@PathVariable Long popCode) {
        return lmsOptPymntFreqsService.findLmsOptPymntFreqsByPopCode(popCode);
    }

    /**
     * Helper method to retrieve messages from the message source.
     *
     * @param code the message code.
     * @param args the message arguments.
     * @return the localized message.
     */
    private String getMessage(String code, Object[] args ) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }
}