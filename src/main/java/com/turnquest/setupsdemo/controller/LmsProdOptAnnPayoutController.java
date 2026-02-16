package com.turnquest.setupsdemo.controller;


import com.turnquest.setupsdemo.model.LmsProdOptAnnPayout;
import com.turnquest.setupsdemo.service.LmsProdOptAnnPayoutService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

/**
 * REST controller for managing LMS Prod Opt Ann Payout.
 */
@RestController
@RequestMapping("/api/ann-payout")
public class LmsProdOptAnnPayoutController {

    private final LmsProdOptAnnPayoutService lmsProdOptAnnPayoutService;
    private final MessageSource messageSource;

    public LmsProdOptAnnPayoutController(LmsProdOptAnnPayoutService lmsProdOptAnnPayoutService, MessageSource messageSource) {
        this.lmsProdOptAnnPayoutService = lmsProdOptAnnPayoutService;
        this.messageSource = messageSource;
    }

    @GetMapping
    public ResponseEntity<List<LmsProdOptAnnPayout>> findAll() {
        List<LmsProdOptAnnPayout> annPayouts = lmsProdOptAnnPayoutService.findAll();
        return ResponseEntity.ok(annPayouts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LmsProdOptAnnPayout> findById(@PathVariable Long id) {
        LmsProdOptAnnPayout annPayout = lmsProdOptAnnPayoutService.findById(id);
        return ResponseEntity.ok(annPayout);
    }

    @PostMapping
    public ResponseEntity<LmsProdOptAnnPayout> save(@RequestBody LmsProdOptAnnPayout lmsProdOptAnnPayout) {
        LmsProdOptAnnPayout savedAnnPayout = lmsProdOptAnnPayoutService.save(lmsProdOptAnnPayout);
        return ResponseEntity.ok(savedAnnPayout);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        lmsProdOptAnnPayoutService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Insert or update an Ann Payout.
     *
     * @param lmsProdOptAnnPayout the Ann Payout entity to insert or update.
     * @return ResponseEntity with status 200 (OK).
     */
    @PostMapping("/insertOrUpdate")
    public ResponseEntity<Void> insertOrUpdateAnnPayout(@RequestBody LmsProdOptAnnPayout lmsProdOptAnnPayout) {
        lmsProdOptAnnPayoutService.insertOrUpdateAnnPayout(lmsProdOptAnnPayout);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-pop-code/{popCode}")
    public List<LmsProdOptAnnPayout> findLmsProdOptAnnPayoutByLmsProdOptions_PopCode(@PathVariable Long popCode) {
        return lmsProdOptAnnPayoutService.findLmsProdOptAnnPayoutByLmsProdOptions_PopCode(popCode);
    }

    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }
}
