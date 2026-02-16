package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsOrdPremRateTables;
import com.turnquest.setupsdemo.service.LmsOrdPremRateTablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/ord-prem-rate-tables")
public class LmsOrdPremRateTablesController {

    private final LmsOrdPremRateTablesService service;

    @Autowired
    public LmsOrdPremRateTablesController(LmsOrdPremRateTablesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LmsOrdPremRateTables>> getAllRateTables() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LmsOrdPremRateTables> getRateTableById(@PathVariable Long id) {
        LmsOrdPremRateTables rateTable = service.findById(id);
        return rateTable != null ? new ResponseEntity<>(rateTable, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<LmsOrdPremRateTables> createRateTable(@RequestBody LmsOrdPremRateTables rateTable) {
        return new ResponseEntity<>(service.save(rateTable), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LmsOrdPremRateTables> updateRateTable(@PathVariable Long id, @RequestBody LmsOrdPremRateTables rateTable) {
        rateTable.setOrdtCode(id);
        return new ResponseEntity<>(service.save(rateTable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRateTable(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/insert-update/{id}")
    public ResponseEntity<LmsOrdPremRateTables> customUpdateRateTable(@PathVariable Long id, @RequestBody LmsOrdPremRateTables rateTable, @RequestParam String errorMessage) {
        rateTable.setOrdtCode(id);
        try {
            return new ResponseEntity<>(service.updateOrdPremRateTable(rateTable, errorMessage), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/ordOptCode/{ordOptCode}")
    public ResponseEntity<List<LmsOrdPremRateTables>> findByOrdOptCode(@PathVariable BigDecimal ordOptCode) {
        List<LmsOrdPremRateTables> rateTables = service.findByOrdOptCode(ordOptCode);
        return ResponseEntity.ok(rateTables);
    }

    @GetMapping("/order-premium-rate-tables")
    public ResponseEntity<List<LmsOrdPremRateTables>> getOrdPremRateTables(@RequestParam BigDecimal pmasCode,
                                                                       @RequestParam BigDecimal popCode,
                                                                       @RequestParam BigDecimal pctCode,
                                                                       @RequestParam BigDecimal optCode,
                                                                       @RequestParam(required = false) Long opirCode,
                                                                       @RequestParam(required = false, defaultValue = "B") String gender) {
        List<LmsOrdPremRateTables> ordPremRateTables = service.getOrdPremRateTables(pmasCode, popCode, pctCode,
                optCode, opirCode, gender);
        return ResponseEntity.ok(ordPremRateTables);
    }
}