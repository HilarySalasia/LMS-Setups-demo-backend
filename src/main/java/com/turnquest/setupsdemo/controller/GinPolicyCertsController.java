// Controller
package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.GinPolicyCerts;
import com.turnquest.setupsdemo.service.GinPolicyCertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ginPolicyCerts")
public class GinPolicyCertsController {

    @Autowired
    private GinPolicyCertsService ginPolicyCertsService;

    @GetMapping
    public List<GinPolicyCerts> getAllGinPolicyCerts() {
        return ginPolicyCertsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GinPolicyCerts> getGinPolicyCertsById(@PathVariable Long id) {
        Optional<GinPolicyCerts> ginPolicyCerts = ginPolicyCertsService.findById(id);
        return ginPolicyCerts.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public GinPolicyCerts createGinPolicyCerts(@RequestBody GinPolicyCerts ginPolicyCerts) {
        return ginPolicyCertsService.save(ginPolicyCerts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GinPolicyCerts> updateGinPolicyCerts(@PathVariable Long id, @RequestBody GinPolicyCerts ginPolicyCertsDetails) {
        Optional<GinPolicyCerts> ginPolicyCerts = ginPolicyCertsService.findById(id);
        if (ginPolicyCerts.isPresent()) {
            GinPolicyCerts updatedGinPolicyCerts = ginPolicyCerts.get();
            // Update fields here
            return ResponseEntity.ok(ginPolicyCertsService.save(updatedGinPolicyCerts));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGinPolicyCerts(@PathVariable Long id) {
        ginPolicyCertsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}