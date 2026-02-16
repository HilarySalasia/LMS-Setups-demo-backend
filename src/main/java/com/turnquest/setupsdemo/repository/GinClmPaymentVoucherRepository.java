package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClmPaymentVouchers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface GinClmPaymentVoucherRepository extends JpaRepository<GinClmPaymentVouchers, Long> {
    List<GinClmPaymentVouchers> findByCpvCmbClaimNo(String cpvCmbClaimNo);

    @Query("SELECT SUM(COALESCE(cpv.cpvAmount, 0)) FROM GinClmPaymentVouchers cpv WHERE cpv.cpvCmbClaimNo = :claimNo AND COALESCE(cpv.cpvAuthorised, 'N') IN ('Y', 'P')")
    Optional<BigDecimal> findTotalAuthorizedPaymentsByClaimNo(@Param("claimNo") String claimNo);

    @Query("SELECT SUM(COALESCE(cpv.cpvAmount, 0)) FROM GinClmPaymentVouchers cpv WHERE cpv.cpvCmbClaimNo = :claimNo")
    Optional<BigDecimal> findTotalPaymentsByClaimNo(@Param("claimNo") String claimNo);
}

