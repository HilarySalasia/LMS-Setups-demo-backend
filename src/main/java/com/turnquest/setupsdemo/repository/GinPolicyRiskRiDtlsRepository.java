package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinPolicyRiskRiDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface GinPolicyRiskRiDtlsRepository extends JpaRepository<GinPolicyRiskRiDtls, Long> {
    Optional<GinPolicyRiskRiDtls> findFirstByPrrdIpuCodeOrderByPrrdIdxDesc(Long prrdIpuCode);
    Long findTotRateByIpuCode(Long ipuCode);
}