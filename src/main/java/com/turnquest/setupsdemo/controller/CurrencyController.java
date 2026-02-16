package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.Currency;
import com.turnquest.setupsdemo.service.CurrencyService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Locale;

/**
 * REST controller for managing Currency entities.
 */
@RestController
@RequestMapping("/api/currencies")
public class CurrencyController {
    private final CurrencyService currencyService;
    private final MessageSource messageSource;

    public CurrencyController(CurrencyService currencyService, MessageSource messageSource) {
        this.currencyService = currencyService;
        this.messageSource = messageSource;
    }

    /**
     * GET /api/currencies : Get all currencies ordered by description.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of currencies in the body
     */
    @GetMapping("/{locale}")
    public ResponseEntity<List<Currency>> getAllCurrencies(@PathVariable  Locale locale) {
        List<com.turnquest.setupsdemo.model.Currency> currencies = currencyService.findAllOrderedByDescription();
        if (currencies.isEmpty()) {
            String message = messageSource.getMessage("currency.noDataFound", null, locale);
            return ResponseEntity.noContent().header("Message", message).build();
        }
        return ResponseEntity.ok(currencies);
    }
}
