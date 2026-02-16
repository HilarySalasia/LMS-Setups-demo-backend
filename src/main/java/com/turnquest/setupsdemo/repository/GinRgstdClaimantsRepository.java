package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinRgstdClaimants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface GinRgstdClaimantsRepository extends JpaRepository<GinRgstdClaimants, Long> {

    Optional<GinRgstdClaimants> findByRegCmbClaimNoAndRegCldCode(String regCmbClaimNo, BigDecimal regCldCode);

    Optional<GinRgstdClaimants> findByRegCmbClaimNoAndRegThirdPartyAndRegCldCode(
            String regCmbClaimNo,
            String regThirdParty,
            BigDecimal regCldCode);

    List<GinRgstdClaimants> findByRegCmbClaimNo(String regCmbClaimNo);

}
