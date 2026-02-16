package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.OptBenefit;
import com.turnquest.setupsdemo.service.OptBenefitService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * REST controller for managing OptBenefit entities.
 */
@RestController
@RequestMapping("/api/optBenefits")
public class OptBenefitController {
    private final OptBenefitService optBenefitService;
    private final MessageSource messageSource;

    public OptBenefitController(OptBenefitService optBenefitService, MessageSource messageSource) {
        this.optBenefitService = optBenefitService;
        this.messageSource = messageSource;
    }

    @PostMapping
    public ResponseEntity<OptBenefit> createOptBenefit(@RequestBody OptBenefit optBenefit) {
        return ResponseEntity.ok(optBenefitService.createOptBenefit(optBenefit));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OptBenefit> updateOptBenefit(@PathVariable BigDecimal id, @RequestBody OptBenefit optBenefitDetails) {
        return ResponseEntity.ok(optBenefitService.updateOptBenefit(id, optBenefitDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OptBenefit> getOptBenefitById(@PathVariable BigDecimal id) {
        return ResponseEntity.ok(optBenefitService.getOptBenefitById(id));
    }

    @GetMapping
    public ResponseEntity<List<OptBenefit>> getAllOptBenefits() {
        return ResponseEntity.ok(optBenefitService.getAllOptBenefits());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOptBenefit(@PathVariable BigDecimal id, Locale locale) {
        optBenefitService.deleteOptBenefit(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byPopCode/{popCode}")
    public ResponseEntity<List<OptBenefit>> findByOpbPopCode(@PathVariable BigDecimal popCode) {
        return ResponseEntity.ok(optBenefitService.findByOpbPopCode(popCode));
    }
}
