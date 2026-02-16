package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinFacreCessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GinFacreCessionsRepository extends JpaRepository<GinFacreCessions, Long> {
    List<GinFacreCessions> findByFcIpuCodeAndFcPrrdCodeAndFcTranTypeNot(
            Long fcIpuCode,
            Long fcPrrdCode,
            String fcTranType);
}