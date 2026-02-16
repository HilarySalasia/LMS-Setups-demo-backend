package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;
import java.util.Optional;

import com.turnquest.setupsdemo.model.GinProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing GinProducts entities.
 */
@Repository
public interface GinProductRepository extends JpaRepository<GinProducts, BigDecimal> {

    /**
     * Find a GinProducts entity by its short description.
     *
     * @param proShtDesc The short description of the product.
     * @return An Optional containing the GinProducts entity if found, or an empty Optional if not found.
     */
    Optional<GinProducts> findByProShtDesc(String proShtDesc);
}