package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.turnquest.setupsdemo.model.GisValuationDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GisValuationDtls entities.
 */
@Repository
public interface GisValuationDtlsRepository extends JpaRepository<GisValuationDtls, BigDecimal> {

    @Query("SELECT vdt FROM GisValuationDtls vdt WHERE vdt.vdtIpuCode = :vdtIpuCode")
    Optional<GisValuationDtls> findByVdtIpuCode(@Param("vdtIpuCode") Long vdtIpuCode);
}