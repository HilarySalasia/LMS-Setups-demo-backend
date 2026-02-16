// Controller
package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.GinClaimMasterBookings;
import com.turnquest.setupsdemo.service.GinClaimMasterBookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ginClaimMasterBookings")
public class GinClaimMasterBookingsController {

    @Autowired
    private GinClaimMasterBookingsService ginClaimMasterBookingsService;

    @GetMapping
    public List<GinClaimMasterBookings> getAllGinClaimMasterBookings() {
        return ginClaimMasterBookingsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GinClaimMasterBookings> getGinClaimMasterBookingsById(@PathVariable String id) {
        Optional<GinClaimMasterBookings> ginClaimMasterBookings = ginClaimMasterBookingsService.findById(id);
        return ginClaimMasterBookings.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public GinClaimMasterBookings createGinClaimMasterBookings(@RequestBody GinClaimMasterBookings ginClaimMasterBookings) {
        return ginClaimMasterBookingsService.save(ginClaimMasterBookings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GinClaimMasterBookings> updateGinClaimMasterBookings(@PathVariable String id, @RequestBody GinClaimMasterBookings ginClaimMasterBookingsDetails) {
        Optional<GinClaimMasterBookings> ginClaimMasterBookings = ginClaimMasterBookingsService.findById(id);
        if (ginClaimMasterBookings.isPresent()) {
            GinClaimMasterBookings updatedGinClaimMasterBookings = ginClaimMasterBookings.get();
            // Update fields here
            return ResponseEntity.ok(ginClaimMasterBookingsService.save(updatedGinClaimMasterBookings));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGinClaimMasterBookings(@PathVariable String id) {
        ginClaimMasterBookingsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}