package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinSubclSctionPerils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GinSubclSctionPerilRepository extends JpaRepository<GinSubclSctionPerils, Long> {
    // ... custom query methods if needed
}
