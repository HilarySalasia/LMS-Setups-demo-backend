package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.turnquest.setupsdemo.model.TqcCurrencyRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing TqcCurrencyRates entities.
 */
@Repository
public interface TqcCurrencyRatesRepository extends JpaRepository<TqcCurrencyRates, BigDecimal> {
    Optional<TqcCurrencyRates> findByCrtCurCodeAndCrtBaseCurCodeAndCrtWefAndCrtWet(
            Long crtCurCode,
            Long crtBaseCurCode,
            java.sql.Date crtWef,
            java.sql.Date crtWet
    );

    @Query("SELECT cr FROM TqcCurrencyRates cr WHERE cr.crtCurCode = :crtCurCode AND cr.crtBaseCurCode = :crtBaseCurCode " +
            "AND cr.crtWef <= :currentDate AND cr.crtWef + :extensionDays >= :currentDate ORDER BY cr.crtWef DESC")
    Optional<TqcCurrencyRates> findLatestRateWithinExtensionPeriod(
            @Param("crtCurCode") Long crtCurCode,
            @Param("crtBaseCurCode") Long crtBaseCurCode,
            @Param("currentDate") java.sql.Date currentDate,
            @Param("extensionDays") Long extensionDays
    );
}
