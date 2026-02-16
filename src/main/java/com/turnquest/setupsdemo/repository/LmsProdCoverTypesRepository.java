package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.LmsProdCoverTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsProdCoverTypesRepository extends JpaRepository<LmsProdCoverTypes, Long> {
    // Add custom queries if required
}
