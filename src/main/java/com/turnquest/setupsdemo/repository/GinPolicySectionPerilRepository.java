package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinPolicySectionPerils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GinPolicySectionPerilRepository extends JpaRepository<GinPolicySectionPerils, Long> {
    // ... custom query methods if needed
}