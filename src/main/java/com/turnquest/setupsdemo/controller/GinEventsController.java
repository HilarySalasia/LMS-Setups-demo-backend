// Controller
package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.GinEvents;
import com.turnquest.setupsdemo.service.GinEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ginEvents")
public class GinEventsController {

    @Autowired
    private GinEventsService ginEventsService;

    @GetMapping
    public List<GinEvents> getAllGinEvents() {
        return ginEventsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GinEvents> getGinEventsById(@PathVariable Long id) {
        Optional<GinEvents> ginEvents = ginEventsService.findById(id);
        return ginEvents.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public GinEvents createGinEvents(@RequestBody GinEvents ginEvents) {
        return ginEventsService.save(ginEvents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GinEvents> updateGinEvents(@PathVariable Long id, @RequestBody GinEvents ginEventsDetails) {
        Optional<GinEvents> ginEvents = ginEventsService.findById(id);
        if (ginEvents.isPresent()) {
            GinEvents updatedGinEvents = ginEvents.get();
            // Update fields here
            return ResponseEntity.ok(ginEventsService.save(updatedGinEvents));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGinEvents(@PathVariable Long id) {
        ginEventsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}