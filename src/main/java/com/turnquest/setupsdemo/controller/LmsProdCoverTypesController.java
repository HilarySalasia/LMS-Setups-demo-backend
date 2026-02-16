package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsProdCoverTypes;
import com.turnquest.setupsdemo.service.LmsProdCoverTypesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lmsprodcovertypes")
public class LmsProdCoverTypesController {
    private final LmsProdCoverTypesService lmsProdCoverTypesService;

    public LmsProdCoverTypesController(LmsProdCoverTypesService lmsProdCoverTypesService) {
        this.lmsProdCoverTypesService = lmsProdCoverTypesService;
    }

    @GetMapping
    public ResponseEntity<List<LmsProdCoverTypes>> getAllProdCoverTypes() {
        List<LmsProdCoverTypes> coverTypes = lmsProdCoverTypesService.findAll();
        return ResponseEntity.ok(coverTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LmsProdCoverTypes> getProdCoverTypeById(@PathVariable Long id) {
        LmsProdCoverTypes coverType = lmsProdCoverTypesService.findById(id);
        return ResponseEntity.ok(coverType);
    }

    @PostMapping
    public ResponseEntity<LmsProdCoverTypes> createProdCoverType(@RequestBody LmsProdCoverTypes coverType) {
        LmsProdCoverTypes savedCoverType = lmsProdCoverTypesService.save(coverType);
        return ResponseEntity.ok(savedCoverType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdCoverType(@PathVariable Long id) {
        lmsProdCoverTypesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}