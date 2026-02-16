package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;

import com.turnquest.setupsdemo.model.GinSubclSctionExcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinSubclSctionExcess entities.
 */
@Repository
public interface GinSubclSctionExcessRepository extends JpaRepository<GinSubclSctionExcess, BigDecimal> {}