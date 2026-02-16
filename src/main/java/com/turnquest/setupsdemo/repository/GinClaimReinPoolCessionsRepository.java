package com.turnquest.setupsdemo.repository;


import com.turnquest.setupsdemo.model.GinClaimReinPoolCessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
@Repository
public interface GinClaimReinPoolCessionsRepository extends JpaRepository<GinClaimReinPoolCessions, Long> {
    Long findMaxCrpcCode();
    Long findMaxCrprcCode();

    List<GinClaimReinPoolCessions> findByCrpcCmbClaimNo(String cmbClaimNo);
}
