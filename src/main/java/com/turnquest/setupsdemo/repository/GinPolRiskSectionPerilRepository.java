package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinPolRiskSectionPerils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface GinPolRiskSectionPerilRepository extends JpaRepository<GinPolRiskSectionPerils, Long> {
    List<GinPolRiskSectionPerils> findByPrsprIpuCode(BigDecimal prsprIpuCode);
}
