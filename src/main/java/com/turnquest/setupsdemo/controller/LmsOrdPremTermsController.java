package com.turnquest.setupsdemo.controller;


import com.turnquest.setupsdemo.model.LmsOrdPremTerms;
import com.turnquest.setupsdemo.service.LmsOrdPremTermsService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * REST controller for managing LMS Ord Prem Terms.
 */
@RestController
@RequestMapping("/api/ord-prem-terms")
public class LmsOrdPremTermsController {

    private final LmsOrdPremTermsService lmsOrdPremTermsService;
    private final MessageSource messageSource;

    public LmsOrdPremTermsController(LmsOrdPremTermsService lmsOrdPremTermsService, MessageSource messageSource) {
        this.lmsOrdPremTermsService = lmsOrdPremTermsService;
        this.messageSource = messageSource;
    }

    @GetMapping
    public ResponseEntity<List<LmsOrdPremTerms>> findAll() {
        List<LmsOrdPremTerms> ordPremTerms = lmsOrdPremTermsService.findAll();
        return ResponseEntity.ok(ordPremTerms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LmsOrdPremTerms> findById(@PathVariable Long id) {
        LmsOrdPremTerms ordPremTerms = lmsOrdPremTermsService.findById(id);
        return ResponseEntity.ok(ordPremTerms);
    }

    @PostMapping
    public ResponseEntity<LmsOrdPremTerms> save(@RequestBody LmsOrdPremTerms lmsOrdPremTerms) {
        LmsOrdPremTerms savedOrdPremTerms = lmsOrdPremTermsService.save(lmsOrdPremTerms);
        return ResponseEntity.ok(savedOrdPremTerms);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        lmsOrdPremTermsService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Insert or update an Ord Prem Terms.
     *
     * @param lmsOrdPremTerms the Ord Prem Terms entity to insert or update.
     * @return ResponseEntity with status 200 (OK).
     */
    @PostMapping("/insertOrUpdate")
    public ResponseEntity<Void> insertOrUpdateOrdPremTerms(@RequestBody LmsOrdPremTerms lmsOrdPremTerms) {
        lmsOrdPremTermsService.insertOrUpdateOrdPremTerms(lmsOrdPremTerms);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/ordPremTerms/byPctCode")
    public ResponseEntity<List<LmsOrdPremTerms>> getOrdPremTermsByPctCode(@RequestParam String pctCode) {
        List<LmsOrdPremTerms> ordPremTerms = lmsOrdPremTermsService.findByPctCode(pctCode);
        return ResponseEntity.ok(ordPremTerms);
    }

    @GetMapping("/ordPremTerms/byPopCode")
    public ResponseEntity<List<LmsOrdPremTerms>> getOrdPremTermsByPopCode(@RequestParam BigDecimal popCode) {
        List<LmsOrdPremTerms> ordPremTerms = lmsOrdPremTermsService.findByPopCode(popCode);
        return ResponseEntity.ok(ordPremTerms);
    }

    @GetMapping("/{pctCode}/{popCode}")
    public ResponseEntity<List<LmsOrdPremTerms>> findByPctCodeAndPopCode(@PathVariable BigDecimal pctCode,
                                                                         @PathVariable BigDecimal popCode) {
        List<LmsOrdPremTerms> terms = lmsOrdPremTermsService.findByPctCodeAndPopCode(pctCode, popCode);
        return ResponseEntity.ok(terms);
    }

    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }
}
