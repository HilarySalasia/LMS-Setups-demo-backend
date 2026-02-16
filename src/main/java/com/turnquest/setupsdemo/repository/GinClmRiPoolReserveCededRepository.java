package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.turnquest.setupsdemo.model.GinClmRiPoolReserveCeded;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinClmRiPoolReserveCeded entities.
 */
@Repository
public interface GinClmRiPoolReserveCededRepository extends JpaRepository<GinClmRiPoolReserveCeded, BigDecimal> {
    void deleteAllByCrprcGgtTransNo(BigDecimal ggtTransNo);

    Optional<GinClmRiPoolReserveCeded> findByCrprcCrpcCodeAndClaimNoAndCrprcGgtTransNo(BigDecimal crpcCode, String claimNo, BigDecimal ggtTransNo);
}
}
