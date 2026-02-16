package com.turnquest.setupsdemo.controller;

// Controller
import com.turnquest.setupsdemo.model.GinPolicies;
import com.turnquest.setupsdemo.service.GinPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policies")
public class GinPolicyController {

    @Autowired
    private GinPolicyService policyService;

    @GetMapping
    public List<GinPolicies> getAllPolicies() {
        return policyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GinPolicies> getPolicyById(@PathVariable Long id) {
        Optional<GinPolicies> policy = policyService.findById(id);
        return policy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public GinPolicies createPolicy(@RequestBody GinPolicies policy) {
        return policyService.save(policy);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GinPolicies> updatePolicy(@PathVariable Long id, @RequestBody GinPolicies policyDetails) {
        Optional<GinPolicies> policy = policyService.findById(id);
        if (policy.isPresent()) {
            GinPolicies updatedPolicy = policy.get();
            // Update fields here
            return ResponseEntity.ok(policyService.save(updatedPolicy));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePolicy(@PathVariable Long id) {
        policyService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
