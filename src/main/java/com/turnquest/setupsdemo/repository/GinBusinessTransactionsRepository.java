package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinBusinessTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for managing GinBusinessTransactions entities.
 */
@Repository
public interface GinBusinessTransactionsRepository extends JpaRepository<GinBusinessTransactions, String> {
    Optional<GinBusinessTransactions> findByBtrTransCode(String transCode);
}
