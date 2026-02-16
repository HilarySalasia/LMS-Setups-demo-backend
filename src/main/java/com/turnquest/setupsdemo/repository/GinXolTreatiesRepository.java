package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinXolTreaty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GinXolTreatiesRepository extends JpaRepository<GinXolTreaty, Long> {
    // ... other methods ...
}