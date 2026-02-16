package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsDependentType;
import com.turnquest.setupsdemo.service.LmsDependentTypeService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/dependent-types")
public class LmsDependentTypeController {

    private final LmsDependentTypeService service;

    public LmsDependentTypeController(LmsDependentTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<LmsDependentType> getAllDependentTypes() {
        return service.getAllDependentTypes();
    }

    @GetMapping("/{id}")
    public LmsDependentType getDependentTypeById(@PathVariable BigDecimal id) {
        return service.getDependentTypeById(id);
    }

    @PostMapping
    public LmsDependentType createDependentType(@RequestBody LmsDependentType dependentType) {
        return service.saveDependentType(dependentType);
    }

    @DeleteMapping("/{id}")
    public void deleteDependentType(@PathVariable BigDecimal id) {
        service.deleteDependentType(id);
    }
}