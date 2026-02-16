package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinXolClmsVmlpCessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GinXolClmsVmlpCessionsRepository extends JpaRepository<GinXolClmsVmlpCessions, Long> {
    Long findMaxXolvcCode();
}