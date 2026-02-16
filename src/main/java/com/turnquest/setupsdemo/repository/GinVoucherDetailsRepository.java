package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.turnquest.setupsdemo.model.GinVoucherDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinVoucherDetails entities.
 */
@Repository
public interface GinVoucherDetailsRepository extends JpaRepository<GinVoucherDetails, BigDecimal> {
    @Query("SELECT SUM(COALESCE(voud.voudAmt, 0)) FROM GinVoucherDetails voud " +
            "JOIN GinClmPaymentVouchers cpv ON voud.voudCpvVoucherNo = cpv.cpvVoucherNo " +
            "WHERE cpv.cpvCmbClaimNo = :claimNo AND voud.voudPerCode = :perCode")
    Optional<BigDecimal> findTotalPaymentsByClaimNoAndPerCode(
            @Param("claimNo") String claimNo,
            @Param("perCode") Long perCode
    );
}
