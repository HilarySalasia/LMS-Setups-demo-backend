package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.PremiumMask;
import com.turnquest.setupsdemo.service.PremiumMaskService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * REST controller for managing PremiumMask entities.
 */
@RestController
@RequestMapping("/api/premiumMasks")
public class PremiumMaskController {
    private final PremiumMaskService premiumMaskService;
    private final MessageSource messageSource;

    public PremiumMaskController(PremiumMaskService premiumMaskService, MessageSource messageSource) {
        this.premiumMaskService = premiumMaskService;
        this.messageSource = messageSource;
    }

    @PostMapping
    public ResponseEntity<PremiumMask> createPremiumMask(@RequestBody PremiumMask premiumMask) {
        return ResponseEntity.ok(premiumMaskService.createPremiumMask(premiumMask));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PremiumMask> updatePremiumMask(@PathVariable BigDecimal id, @RequestBody PremiumMask premiumMaskDetails) {
        return ResponseEntity.ok(premiumMaskService.updatePremiumMask(id, premiumMaskDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PremiumMask> getPremiumMaskById(@PathVariable BigDecimal id) {
        return ResponseEntity.ok(premiumMaskService.getPremiumMaskById(id));
    }

    @GetMapping
    public ResponseEntity<List<PremiumMask>> getAllPremiumMasks() {
        return ResponseEntity.ok(premiumMaskService.getAllPremiumMasks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePremiumMask(@PathVariable BigDecimal id, Locale locale) {
        premiumMaskService.deletePremiumMask(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/byProdCode/{prodCode}")
    public ResponseEntity<List<PremiumMask>> findByProdCodeAndClassType(@PathVariable BigDecimal prodCode,
                                                                        @PathVariable String claType) {
        return ResponseEntity.ok(premiumMaskService.findByProdCodeAndClassType(prodCode, claType));
    }
}
