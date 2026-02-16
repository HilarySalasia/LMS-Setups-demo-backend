package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinRgstdClmtsDv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GinRgstdClmtsDvRepository extends JpaRepository<GinRgstdClmtsDv, Long> {

    @Query("SELECT rgcd FROM GinRgstdClmtsDv rgcd WHERE rgcd.rgCldCode = :rgcldCode")
    Optional<GinRgstdClmtsDv> findById(@Param("rgcldCode") Long rgcldCode);

    // ... other methods ...
}