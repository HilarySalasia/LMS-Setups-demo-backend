package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.RateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Repository interface for RateType entity.
 */
@Repository
public interface RateTypeRepository extends JpaRepository<RateType, BigDecimal> {

    /**
     * Custom query to find RateType by code.
     *
     * @param svtCode the code to search for
     * @return an Optional of RateType
     */
    @Query("SELECT rt FROM RateType rt WHERE rt.svtCode = COALESCE(:svtCode, rt.svtCode)")
    Optional<RateType> findBySvtCode(@Param("svtCode") BigDecimal svtCode);
}
