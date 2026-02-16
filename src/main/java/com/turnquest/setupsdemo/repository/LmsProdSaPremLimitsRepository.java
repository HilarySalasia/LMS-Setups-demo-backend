package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.dto.SaPremLimits;
import com.turnquest.setupsdemo.model.LmsProdSaPremLimits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface LmsProdSaPremLimitsRepository extends JpaRepository<LmsProdSaPremLimits, Long> {
    // Add custom queries if required
    @Query("SELECT pspl FROM LmsProdSaPremLimits pspl WHERE pspl.lmsProducts.prodCode = :prodCode")
    List<LmsProdSaPremLimits> findByPsplProdCode(Long prodCode);

    @Query("SELECT (pspl.psplMinPrem, pspl.psplMinContri, pspl.psplMaxPrem, " +
            "pspl.psplMaxContri, pspl.psplMinSa, pspl.psplMaxSa) " +
            "FROM LmsProdSaPremLimits pspl " +
            "WHERE pspl.psplPayFreq = :payFreq AND pspl.lmsProducts.prodCode = :prodCode " +
            "AND pspl.lmsProdOptions.popCode = :popCode")
    Optional<SaPremLimits> findSaPremLimits(Integer prodCode, Integer popCode, String payFreq);

    @Query("SELECT pspl FROM LmsProdSaPremLimits pspl" +
       " WHERE pspl.lmsProdOptions.popCode = :popCode AND pspl.lmsProdCoverTypes.pctCode = :pctCode")
List<LmsProdSaPremLimits> findLmsProdSaPremLimitsByPopCodeAndPctCode(Long popCode, Long pctCode);
}
