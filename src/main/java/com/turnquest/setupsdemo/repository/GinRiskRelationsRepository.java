package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinRiskRelations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GinRiskRelationsRepository extends JpaRepository<GinRiskRelations, Long> {
}