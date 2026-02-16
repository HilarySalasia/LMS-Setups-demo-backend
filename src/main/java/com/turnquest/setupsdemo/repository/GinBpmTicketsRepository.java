package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.turnquest.setupsdemo.model.GinBpmTickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinBpmTickets entities.
 */
@Repository
public interface GinBpmTicketsRepository extends JpaRepository<GinBpmTickets, BigDecimal> {
    Optional<GinBpmTickets> findByTcktClaimTransNo(BigDecimal claimTransNo);

    void deleteByPolCode(BigDecimal polCode);
}
