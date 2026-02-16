package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;

import com.turnquest.setupsdemo.model.GinClaimRecoveries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinClaimRecoveries entities.
 */
@Repository
public interface GinClaimRecoveriesRepository extends JpaRepository<GinClaimRecoveries, BigDecimal> {}