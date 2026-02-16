package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClmCoinReserves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface GinClmCoinReservesRepository extends JpaRepository<GinClmCoinReserves, BigDecimal> {

    void deleteAllByCcorGgtTransNo(BigDecimal ggtTransNo);
}