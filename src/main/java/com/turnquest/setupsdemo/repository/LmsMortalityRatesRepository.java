package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.LmsMortalityRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsMortalityRatesRepository extends JpaRepository<LmsMortalityRates, Long> {
}
