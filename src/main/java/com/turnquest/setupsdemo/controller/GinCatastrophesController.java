// Controller
package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.GinCatastrophes;
import com.turnquest.setupsdemo.service.GinCatastrophesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ginCatastrophes")
public class GinCatastrophesController {

    @Autowired
    private GinCatastrophesService ginCatastrophesService;

    @GetMapping
    public List<GinCatastrophes> getAllGinCatastrophes() {
        return ginCatastrophesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GinCatastrophes> getGinCatastrophesById(@PathVariable Long id) {
        Optional<GinCatastrophes> ginCatastrophes = ginCatastrophesService.findById(id);
        return ginCatastrophes.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public GinCatastrophes createGinCatastrophes(@RequestBody GinCatastrophes ginCatastrophes) {
        return ginCatastrophesService.save(ginCatastrophes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GinCatastrophes> updateGinCatastrophes(@PathVariable Long id, @RequestBody GinCatastrophes ginCatastrophesDetails) {
        Optional<GinCatastrophes> ginCatastrophes = ginCatastrophesService.findById(id);
        if (ginCatastrophes.isPresent()) {
            GinCatastrophes updatedGinCatastrophes = ginCatastrophes.get();
            // Update fields here
            return ResponseEntity.ok(ginCatastrophesService.save(updatedGinCatastrophes));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGinCatastrophes(@PathVariable Long id) {
        ginCatastrophesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}