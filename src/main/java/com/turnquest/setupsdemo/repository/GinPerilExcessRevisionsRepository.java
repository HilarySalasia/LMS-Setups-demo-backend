package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;

import com.turnquest.setupsdemo.model.GinPerilExcessRevisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinPerilExcessRevisions entities.
 */
@Repository
public interface GinPerilExcessRevisionsRepository extends JpaRepository<GinPerilExcessRevisions, BigDecimal> {}
