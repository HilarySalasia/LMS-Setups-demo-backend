package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;

import com.turnquest.setupsdemo.model.Jbpm4HistTaskGis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing Jbpm4HistTaskGis entities.
 */
@Repository
public interface Jbpm4HistTaskGisRepository extends JpaRepository<Jbpm4HistTaskGis, BigDecimal> {
    @Modifying
    @Query("UPDATE Jbpm4HistTaskGis h SET h.outcome = ?1 WHERE h.dbid = ?2")
    void updateOutcomeByDbid(String outcome, BigDecimal dbid);
}