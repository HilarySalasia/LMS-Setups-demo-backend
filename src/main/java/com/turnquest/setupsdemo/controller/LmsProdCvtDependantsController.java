package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.dto.DependantDisplayDTO;
import com.turnquest.setupsdemo.model.LmsProdCvtDependants;
import com.turnquest.setupsdemo.service.LmsProdCvtDependantsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dependants")
public class LmsProdCvtDependantsController {

    private final LmsProdCvtDependantsService service;

    public LmsProdCvtDependantsController(LmsProdCvtDependantsService service) {
        this.service = service;
    }

    @GetMapping
    public List<LmsProdCvtDependants> getAllDependants() {
        return service.getAllDependants();
    }

    @GetMapping("/{id}")
    public LmsProdCvtDependants getDependantById(@PathVariable Long id) {
        return service.getDependantById(id);
    }

    @PostMapping
    public LmsProdCvtDependants createDependant(@RequestBody LmsProdCvtDependants dependant) {
        return service.saveDependant(dependant);
    }

    @DeleteMapping("/{id}")
    public void deleteDependant(@PathVariable Long id) {
        service.deleteDependant(id);
    }

    @GetMapping("/display")
    public List<DependantDisplayDTO> findDependantDisplay(@RequestParam Long vPctCode, @RequestParam Long vPcdCode) {
        return service.findDependantDisplay(vPctCode, vPcdCode);
    }
}
