package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.turnquest.setupsdemo.model.GinClassExcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinClassExcess entities.
 */
@Repository
public interface GinClassExcessRepository extends JpaRepository<GinClassExcess, BigDecimal> {
    Optional<GinClassExcess> findById(Long cexCode);
}
