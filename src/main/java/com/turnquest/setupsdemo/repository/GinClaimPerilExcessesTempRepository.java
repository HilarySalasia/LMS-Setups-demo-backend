package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClaimPerilExcessesTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GinClaimPerilExcessesTempRepository extends JpaRepository<GinClaimPerilExcessesTemp, Long> {

    @Query("SELECT cpet FROM GinClaimPerilExcessesTemp cpet WHERE cpet.cpetCptCode = :cptCode")
    List<GinClaimPerilExcessesTemp> findByCpetCptCode(@Param("cptCode") Long cptCode);

    // ... other methods ...
}
