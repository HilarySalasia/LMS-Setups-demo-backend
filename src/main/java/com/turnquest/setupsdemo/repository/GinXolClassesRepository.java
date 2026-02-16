package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinXolClasses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GinXolClassesRepository extends JpaRepository<GinXolClasses, Long> {
    // ... other methods ...
}