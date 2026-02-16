package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.LmsOrdPremIntrRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LmsOrdPremIntrRateRepository extends JpaRepository<LmsOrdPremIntrRate, Long> {
}
