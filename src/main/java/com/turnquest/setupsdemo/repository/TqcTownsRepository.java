package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;

import com.turnquest.setupsdemo.model.TqcTowns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing TqcTowns entities.
 */
@Repository
public interface TqcTownsRepository extends JpaRepository<TqcTowns, BigDecimal> {}
