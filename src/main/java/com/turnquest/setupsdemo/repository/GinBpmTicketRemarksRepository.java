package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;

import com.turnquest.setupsdemo.model.GinBpmTicketRemarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinBpmTicketRemarks entities.
 */
@Repository
public interface GinBpmTicketRemarksRepository extends JpaRepository<GinBpmTicketRemarks, BigDecimal> {}
