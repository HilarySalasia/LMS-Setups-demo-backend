package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.turnquest.setupsdemo.model.TqcOrganizations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing TqcOrganizations entities.
 */
@Repository
public interface TqcOrganizationsRepository extends JpaRepository<TqcOrganizations, BigDecimal> {
    Optional<TqcOrganizations> findByOrgCodeAndSysShtDesc(Long orgCode, String sysShtDesc);
}