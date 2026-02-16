package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsOrdPremIntrRate;
import com.turnquest.setupsdemo.service.LmsOrdPremIntrRateService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/rates")
public class LmsOrdPremIntrRateController {

    private final LmsOrdPremIntrRateService service;

    public LmsOrdPremIntrRateController(LmsOrdPremIntrRateService service) {
        this.service = service;
    }

    @GetMapping
    public List<LmsOrdPremIntrRate> getAllRates() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public LmsOrdPremIntrRate getRateById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public LmsOrdPremIntrRate createRate(@RequestBody LmsOrdPremIntrRate rate) {
        return service.save(rate);
    }

    @PutMapping("/{id}")
    public LmsOrdPremIntrRate updateRate(@PathVariable Long id, @RequestBody LmsOrdPremIntrRate rate) {
        rate.setOpirCode(id);
        return service.save(rate);
    }

    @DeleteMapping("/{id}")
    public void deleteRate(@PathVariable Long id) {
        service.deleteById(id);
    }
}
