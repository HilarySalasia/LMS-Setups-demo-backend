package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.LmsMedLoadRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsMedLoadRatesRepository extends JpaRepository<LmsMedLoadRates, Long> {
}
