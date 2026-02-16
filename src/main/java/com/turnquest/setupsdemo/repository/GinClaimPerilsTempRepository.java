package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClmPerilsTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GinClaimPerilsTempRepository extends JpaRepository<GinClmPerilsTemp, Long> {
    // In your GinClaimPerilsTempRepository interface:

    @Query("SELECT c FROM GinClmPerilsTemp c WHERE c.cptGrpCode = :grpCode")
    List<GinClmPerilsTemp> findAllByCptGrpCode(@Param("grpCode") Long grpCode);
}