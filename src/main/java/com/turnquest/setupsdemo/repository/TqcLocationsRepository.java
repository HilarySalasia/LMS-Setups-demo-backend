package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.TqcLocations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for managing TqcLocations entities.
 */
@Repository
public interface TqcLocationsRepository extends JpaRepository<TqcLocations, String> {
    Optional<TqcLocations> findByLocName(String locName);
}