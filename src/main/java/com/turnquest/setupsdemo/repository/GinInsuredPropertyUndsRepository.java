package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinInsuredPropertyUnds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GinInsuredPropertyUndsRepository extends JpaRepository<GinInsuredPropertyUnds, Long> {
    // Add custom query methods as needed

    Optional<GinInsuredPropertyUnds> getGinInsuredPropertyUndsByIpuCode(Long ipuCode);

    List<GinInsuredPropertyUnds> findAllByIpuRelrCode(Long ipuRelrCode);

    @Query("SELECT ipu FROM GinInsuredPropertyUnds ipu WHERE ipu.ipuCode = :ipuCode")
    Optional<GinInsuredPropertyUnds> findByIpuCode(@Param("ipuCode") Long ipuCode);
}