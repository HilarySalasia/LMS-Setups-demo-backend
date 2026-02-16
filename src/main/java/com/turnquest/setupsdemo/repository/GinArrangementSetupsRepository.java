package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinArrangementSetups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GinArrangementSetupsRepository extends JpaRepository<GinArrangementSetups, Long> {
    List<GinArrangementSetups> findByAsTaCodeIn(List<Long> asTaCode);
}