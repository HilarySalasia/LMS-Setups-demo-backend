package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClaimXolRevisions;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface GinClaimXolRevisionsRepository extends JpaRepository<GinClaimXolRevisions, Long> {
    // ... other methods ...
    List<GinClaimXolRevisions> findByCxrClaimNoAndCxrAuthorized(String cxrClaimNo, String cxrAuthorized);

    @Modifying
    @Transactional
    @Query("UPDATE GinClaimXolRevisions cxr SET cxr.cxrAmount = :cxrAmount, " +
            "cxr.cxrGrossCompRetAmount = :cxrGrossCompRetAmount WHERE cxr.cxrCode = :cxrCode")
    void updateCxrAmountAndCxrGrossCompRetAmount(@Param("cxrCode") Long cxrCode,
                                                 @Param("cxrAmount") BigDecimal cxrAmount,
                                                 @Param("cxrGrossCompRetAmount") BigDecimal cxrGrossCompRetAmount);
}