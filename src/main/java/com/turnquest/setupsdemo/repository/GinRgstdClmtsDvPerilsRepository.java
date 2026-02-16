package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinRgstdClmtsDvPerils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GinRgstdClmtsDvPerilsRepository extends JpaRepository<GinRgstdClmtsDvPerils, Long> {

    @Query("SELECT rgcdp FROM GinRgstdClmtsDvPerils rgcdp WHERE rgcdp.rgCdpClmpCode = :clmpCode")
    Optional<GinRgstdClmtsDvPerils> findByRgcdpClmpCode(@Param("clmpCode") Long clmpCode);

    // ... other methods ...
}