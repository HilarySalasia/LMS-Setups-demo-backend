package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClaimPerilExcesses;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GinClaimPerilExcessesRepository extends JpaRepository<GinClaimPerilExcesses, BigDecimal> {
    @Query("SELECT cpe FROM GinClaimPerilExcesses cpe WHERE cpe.cpeClmpCode = :cpeClmpCode")
    List<GinClaimPerilExcesses> findByCpeClmpCode(@Param("cpeClmpCode") Long cpeClmpCode);

    @Modifying
    @Transactional
    @Query("UPDATE GinClaimPerilExcesses cpe SET cpe.cpeExcessAmt = :excessAmt, cpe.cpeClaimExcess = :excessAmt WHERE cpe.cpeCode = :cpeCode")
    void updateExcessAmount(@Param("cpeCode") Long cpeCode, @Param("excessAmt") BigDecimal excessAmt);
}