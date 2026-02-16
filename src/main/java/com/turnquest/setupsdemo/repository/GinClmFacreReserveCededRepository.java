package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.turnquest.setupsdemo.model.GinClmFacreReserveCeded;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinClmFacreReserveCeded entities.
 */
@Repository
public interface GinClmFacreReserveCededRepository extends JpaRepository<GinClmFacreReserveCeded, BigDecimal> {
    void deleteAllByCfrcGgtTransNo(BigDecimal ggtTransNo);

    Optional<GinClmFacreReserveCeded> findByCfrcFcCodeAndCfrcCmbClaimNoAndCfrcGgtTransNo(BigDecimal fcCode, String claimNo, BigDecimal ggtTransNo);
}
}
