package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.turnquest.setupsdemo.model.GinClmTreatyReserveCeded;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinClmTreatyReserveCeded entities.
 */
@Repository
public interface GinClmTreatyReserveCededRepository extends JpaRepository<GinClmTreatyReserveCeded, BigDecimal> {
    void deleteAllByCtrcGgtTransNo(BigDecimal ggtTransNo);

    Optional<GinClmTreatyReserveCeded> findByCtrcReiCodeAndCtrcCmbClaimNoAndCtrcGgtTransNo(BigDecimal reiCode, String claimNo, BigDecimal ggtTransNo);
}
}