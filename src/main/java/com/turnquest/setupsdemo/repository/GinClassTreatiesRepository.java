package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClassTreaty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GinClassTreatiesRepository extends JpaRepository<GinClassTreaty, Long> {
    List<GinClassTreaty> findByCltAsCodeIn(List<Long> cltAsCode);
    List<GinClassTreaty> findByCltSclCode(Long cltSclCode);
}
