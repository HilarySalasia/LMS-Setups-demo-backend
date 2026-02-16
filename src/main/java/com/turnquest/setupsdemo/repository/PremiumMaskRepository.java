package com.turnquest.setupsdemo.repository;


import com.turnquest.setupsdemo.dto.PremiumMaskCodeDescDTO;
import com.turnquest.setupsdemo.model.PremiumMask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for PremiumMask entity.
 */
@Repository
public interface PremiumMaskRepository extends JpaRepository<PremiumMask, BigDecimal> {

    /**
     * Custom query to find PremiumMasks by product code and class type.
     *
     * @param prodCode the product code to search for
     * @return a list of PremiumMasks
     */
    @Query("SELECT pm FROM PremiumMask pm WHERE pm.pmasProdCode = :prodCode AND pm.lmsClasses.claCode = " +
            "(SELECT c.claCode FROM LmsClasses c WHERE c.claType = :claType)")
    List<PremiumMask> findByProdCodeAndClassType(@Param("prodCode") BigDecimal prodCode, String claType);

    @Query("SELECT new com.turnquest.setupsdemo.dto.PremiumMaskCodeDescDTO(pm.pmasCode, pm.pmasDesc," +
            " pm.pmasProdCode) " +
            "FROM PremiumMask pm " +
            "WHERE pm.pmasProdCode = :prodCode AND pm.lmsClasses.claType = :claType")
    List<PremiumMaskCodeDescDTO> findPremiumMaskTreeDetails(BigDecimal prodCode, String claType);
}
