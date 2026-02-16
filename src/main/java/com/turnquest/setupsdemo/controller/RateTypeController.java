package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.RateType;
import com.turnquest.setupsdemo.service.RateTypeService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * REST controller for managing RateType entities.
 */
@RestController
@RequestMapping("/api/rateTypes")
public class RateTypeController {
    private final RateTypeService rateTypeService;
    private final MessageSource messageSource;

    public RateTypeController(RateTypeService rateTypeService, MessageSource messageSource) {
        this.rateTypeService = rateTypeService;
        this.messageSource = messageSource;
    }

    @PostMapping
    public ResponseEntity<RateType> createRateType(@RequestBody RateType rateType) {
        return ResponseEntity.ok(rateTypeService.createRateType(rateType));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RateType> updateRateType(@PathVariable BigDecimal id, @RequestBody RateType rateTypeDetails) {
        return ResponseEntity.ok(rateTypeService.updateRateType(id, rateTypeDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RateType> getRateTypeById(@PathVariable BigDecimal id) {
        return ResponseEntity.ok(rateTypeService.getRateTypeById(id));
    }

    @GetMapping
    public ResponseEntity<List<RateType>> getAllRateTypes() {
        return ResponseEntity.ok(rateTypeService.getAllRateTypes());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRateType(@PathVariable BigDecimal id, Locale locale) {
        rateTypeService.deleteRateType(id);
        return ResponseEntity.ok().build();
    }
}
