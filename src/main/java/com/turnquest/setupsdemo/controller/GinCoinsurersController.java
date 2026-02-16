package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.GinCoinsurers;
import com.turnquest.setupsdemo.model.compositeKeys.GinCoinsurersId;
import com.turnquest.setupsdemo.service.GinCoinsurersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gin-coinsurers")
public class GinCoinsurersController {

    @Autowired
    private GinCoinsurersService ginCoinsurersService;

    // Get all
    @GetMapping
    public ResponseEntity<List<GinCoinsurers>> getAllCoinsurers() {
        List<GinCoinsurers> coinsurers = ginCoinsurersService.findAll();
        return new ResponseEntity<>(coinsurers, HttpStatus.OK);
    }

    // Get by ID
    @GetMapping("/{coinAgntAgentCode}/{coinPolBatchNo}")
    public ResponseEntity<GinCoinsurers> getCoinsurerById(@PathVariable Long coinAgntAgentCode,
                                                          @PathVariable Long coinPolBatchNo) {
        GinCoinsurersId id = new GinCoinsurersId(coinAgntAgentCode, coinPolBatchNo);
        Optional<GinCoinsurers> ginCoinsurers = ginCoinsurersService.findById(id);
        return ginCoinsurers.map(coinsurer -> new ResponseEntity<>(coinsurer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create
    @PostMapping
    public ResponseEntity<GinCoinsurers> createCoinsurer(@RequestBody GinCoinsurers ginCoinsurers) {
        GinCoinsurers savedCoinsurer = ginCoinsurersService.save(ginCoinsurers);
        return new ResponseEntity<>(savedCoinsurer, HttpStatus.CREATED);
    }

    // Update
    @PutMapping("/{coinAgntAgentCode}/{coinPolBatchNo}")
    public ResponseEntity<GinCoinsurers> updateCoinsurer(@PathVariable Long coinAgntAgentCode,
                                                         @PathVariable Long coinPolBatchNo,
                                                         @RequestBody GinCoinsurers ginCoinsurers) {
        GinCoinsurersId id = new GinCoinsurersId(coinAgntAgentCode, coinPolBatchNo);
        ginCoinsurers.setId(id);
        GinCoinsurers updatedCoinsurer = ginCoinsurersService.update(ginCoinsurers);
        return new ResponseEntity<>(updatedCoinsurer, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{coinAgntAgentCode}/{coinPolBatchNo}")
    public ResponseEntity<Void> deleteCoinsurer(@PathVariable Long coinAgntAgentCode,
                                                @PathVariable Long coinPolBatchNo) {
        GinCoinsurersId id = new GinCoinsurersId(coinAgntAgentCode, coinPolBatchNo);
        ginCoinsurersService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
