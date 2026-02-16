package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClaimCoinsurers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GinClaimCoinsurersRepository extends JpaRepository<GinClaimCoinsurers, Long> {
    List<GinClaimCoinsurers> findAllByCmbClaimNo(String claimNo);
}