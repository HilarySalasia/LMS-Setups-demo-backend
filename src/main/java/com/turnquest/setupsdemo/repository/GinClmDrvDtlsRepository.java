package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.turnquest.setupsdemo.model.GinClmDrvDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinClmDrvDtls entities.
 */
@Repository
public interface GinClmDrvDtlsRepository extends JpaRepository<GinClmDrvDtls, BigDecimal> {
    @Query("SELECT cdr FROM GinClmDrvDtls cdr WHERE cdr.cdrCmbClaimNo = :cdrCmbClaimNo")
    Optional<GinClmDrvDtls> findByCdrCmbClaimNo(@Param("cdrCmbClaimNo") String cdrCmbClaimNo);

}