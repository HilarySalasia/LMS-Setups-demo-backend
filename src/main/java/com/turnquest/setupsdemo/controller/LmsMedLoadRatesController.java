package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsMedLoadRates;
import com.turnquest.setupsdemo.service.LmsMedLoadRatesService;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/med-load-rates")
public class LmsMedLoadRatesController {

    private final LmsMedLoadRatesService service;

    public LmsMedLoadRatesController(LmsMedLoadRatesService service) {
        this.service = service;
    }

    @GetMapping
    public List<LmsMedLoadRates> getAllRates() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public LmsMedLoadRates getRateById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public LmsMedLoadRates createRate(@RequestBody LmsMedLoadRates rates) {
        return service.save(rates);
    }

    @PutMapping("/{id}")
    public LmsMedLoadRates updateRate(@PathVariable Long id, @RequestBody LmsMedLoadRates rates) {
        rates.setMlrCode(id);
        return service.save(rates);
    }

    @DeleteMapping("/{id}")
    public void deleteRate(@PathVariable Long id) {
        service.deleteById(id);
    }
}
