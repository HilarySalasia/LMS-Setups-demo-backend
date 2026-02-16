package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClaimTreatyCessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GinClaimTreatyCessionsRepository extends JpaRepository<GinClaimTreatyCessions, BigDecimal> {
    Long findMaxCtrtcCode();

    List<GinClaimTreatyCessions> findAllByCtrtcCmbClaimNo(String claimNo);
}