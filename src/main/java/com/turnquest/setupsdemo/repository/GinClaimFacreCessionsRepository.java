package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClaimFacreCessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GinClaimFacreCessionsRepository extends JpaRepository<GinClaimFacreCessions, BigDecimal> {
    Long findMaxFccCode();

    List<GinClaimFacreCessions> findAllByFccCmbClaimNo(String claimNo);
}
