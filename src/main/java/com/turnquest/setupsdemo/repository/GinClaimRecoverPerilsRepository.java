package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.turnquest.setupsdemo.model.GinClaimRecoverPerils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinClaimRecoverPerils entities.
 */
@Repository
public interface GinClaimRecoverPerilsRepository extends JpaRepository<GinClaimRecoverPerils, BigDecimal> {
    @Query("SELECT SUM(COALESCE(crper.crperAmt, 0)) FROM GinClaimRecoverPerils crper " +
            "JOIN GinClaimRecoveries clmr ON crper.crperClmrCode = clmr.clmrCode " +
            "WHERE clmr.clmrCmbClaimNo = :claimNo AND crper.crperPerCode = :perCode AND clmr.clmrRecType != 'S'")
    Optional<BigDecimal> findTotalRecoveriesByClaimNoAndPerCode(
            @Param("claimNo") String claimNo,
            @Param("perCode") Long perCode
    );

    @Query("SELECT SUM(COALESCE(crper.crperAmt, 0)) FROM GinClaimRecoverPerils crper " +
            "JOIN GinClaimRecoveries clmr ON crper.crperClmrCode = clmr.clmrCode " +
            "WHERE clmr.clmrCmbClaimNo = :claimNo AND crper.crperPerCode = :perCode AND clmr.clmrRecType = 'S'")
    Optional<BigDecimal> findTotalSalvagesByClaimNoAndPerCode(
            @Param("claimNo") String claimNo,
            @Param("perCode") Long perCode
    );
}