package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsMortalityRates;
import com.turnquest.setupsdemo.service.LmsMortalityRatesService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/mortality-rates")
public class LmsMortalityRatesController {

    private final LmsMortalityRatesService service;

    public LmsMortalityRatesController(LmsMortalityRatesService service) {
        this.service = service;
    }

    @GetMapping
    public List<LmsMortalityRates> getAllRates() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public LmsMortalityRates getRateById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public LmsMortalityRates createRate(@RequestBody LmsMortalityRates rates) {
        return service.save(rates);
    }

    @PutMapping("/{id}")
    public LmsMortalityRates updateRate(@PathVariable Long id, @RequestBody LmsMortalityRates rates) {
        rates.setLmrCode(id);
        return service.save(rates);
    }

    @DeleteMapping("/{id}")
    public void deleteRate(@PathVariable Long id) {
        service.deleteById(id);
    }
}
