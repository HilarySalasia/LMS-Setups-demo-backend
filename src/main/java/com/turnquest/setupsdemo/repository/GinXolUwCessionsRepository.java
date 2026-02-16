package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinXolUwCessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GinXolUwCessionsRepository extends JpaRepository<GinXolUwCessions, Long> {
    List<GinXolUwCessions> findByXolucIpuCodeAndXolucPrrdCode(
            Long xolucIpuCode,
            Long xolucPrrdCode);
}
