package com.turnquest.setupsdemo.repository;

import java.math.BigDecimal;

import com.turnquest.setupsdemo.model.TqcParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository for managing TqcParameters entities.
 */
@Repository
public interface TqcParametersRepository extends JpaRepository<TqcParameters, BigDecimal> {
    @Query("SELECT p.paramValue FROM TqcParameters p WHERE p.paramCode = :parCode")
    String findParamValueByParamName(String parCode);
}
