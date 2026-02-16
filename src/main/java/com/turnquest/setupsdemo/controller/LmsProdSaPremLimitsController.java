package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsProdSaPremLimits;
import com.turnquest.setupsdemo.service.LmsProdSaPremLimitsService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * REST controller for managing LMS Prod Sa Prem Limits.
 */
@RestController
@RequestMapping("/api/sa-prem-limits")
public class LmsProdSaPremLimitsController {

    private final LmsProdSaPremLimitsService lmsProdSaPremLimitsService;
    private final MessageSource messageSource;

    public LmsProdSaPremLimitsController(LmsProdSaPremLimitsService lmsProdSaPremLimitsService, MessageSource messageSource) {
        this.lmsProdSaPremLimitsService = lmsProdSaPremLimitsService;
        this.messageSource = messageSource;
    }

    @GetMapping
    public ResponseEntity<List<LmsProdSaPremLimits>> findAll() {
        List<LmsProdSaPremLimits> saPremLimits = lmsProdSaPremLimitsService.findAll();
        return ResponseEntity.ok(saPremLimits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LmsProdSaPremLimits> findById(@PathVariable Long id) {
        LmsProdSaPremLimits saPremLimit = lmsProdSaPremLimitsService.findById(id);
        return ResponseEntity.ok(saPremLimit);
    }

    @PostMapping
    public ResponseEntity<LmsProdSaPremLimits> save(@RequestBody LmsProdSaPremLimits lmsProdSaPremLimits) {
        LmsProdSaPremLimits savedSaPremLimit = lmsProdSaPremLimitsService.save(lmsProdSaPremLimits);
        return ResponseEntity.ok(savedSaPremLimit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        lmsProdSaPremLimitsService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Insert or update a SA Prem Limit.
     *
     * @param lmsProdSaPremLimits the SA Prem Limit entity to insert or update.
     * @return ResponseEntity with status 200 (OK).
     */
    @PostMapping("/insertOrUpdate")
    public ResponseEntity<Void> insertOrUpdateSaPremLimits(@RequestBody LmsProdSaPremLimits lmsProdSaPremLimits) {
        lmsProdSaPremLimitsService.insertOrUpdateSaPremLimits(lmsProdSaPremLimits);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByPopCodeAndPctCode")
    public List<LmsProdSaPremLimits> findLmsProdSaPremLimitsByPopCodeAndPctCode(@RequestParam Long popCode,
                                                                                @RequestParam Long pctCode) {
        return lmsProdSaPremLimitsService.findLmsProdSaPremLimitsByPopCodeAndPctCode(popCode, pctCode);
    }

    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }
}
