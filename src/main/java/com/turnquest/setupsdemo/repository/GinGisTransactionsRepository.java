package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinGisTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for GinGisTransactions entity.
 */
@Repository
public interface GinGisTransactionsRepository extends JpaRepository<GinGisTransactions, Long> {
}