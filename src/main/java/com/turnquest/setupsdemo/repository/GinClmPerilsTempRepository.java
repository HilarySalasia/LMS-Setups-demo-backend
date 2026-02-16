package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClmPerilsTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GinClmPerilsTempRepository extends JpaRepository<GinClmPerilsTemp, Long> {

    @Query("SELECT cpt FROM GinClmPerilsTemp cpt WHERE cpt.cptCode = :cptCode")
    Optional<GinClmPerilsTemp> findByCptCode(@Param("cptCode") Long cptCode);

    // ... other methods ...
}