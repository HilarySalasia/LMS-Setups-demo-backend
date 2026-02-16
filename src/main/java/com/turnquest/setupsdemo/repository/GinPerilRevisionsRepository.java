package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;

import com.turnquest.setupsdemo.model.GinPerilRevisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinPerilRevisions entities.
 */
@Repository
public interface GinPerilRevisionsRepository extends JpaRepository<GinPerilRevisions, BigDecimal> {
    void deleteAllByPerrevGgtTransNo(BigDecimal ggtTransNo);
}