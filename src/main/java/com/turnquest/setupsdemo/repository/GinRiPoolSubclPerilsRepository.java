package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.dto.PoolRecoveryPeril;
import com.turnquest.setupsdemo.model.GinRiPoolSubclPerils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface GinRiPoolSubclPerilsRepository extends JpaRepository<GinRiPoolSubclPerils, Long> {
    long countByRpscpCovtCodeAndRpscpSclCode(BigDecimal rpscpCovtCode, BigDecimal rpscpSclCode);
    List<GinRiPoolSubclPerils> findByRpscpCovtCodeAndRpscpSclCodeAndRpscpUwyr(
            BigDecimal rpscpCovtCode,
            BigDecimal rpscpSclCode,
            BigDecimal rpscpUwyr);

    @Query("SELECT new com.turnquest.setupsdemo.dto.PoolRecoveryPeril(" +
            "gprrd.prprdUwyr, " +
            "grsp.rpscpClaimsRate, " +
            "gprrd.prprdPolBatchNo," +
            "gprrd.prprdSclCode, " +
            "gprrd.prprdRiskCurCode, " +
            "tc.curSymbol, " +
            "gprrd.prprdCode, " +
            "gprrd.prprdScrprCode) " +
                "FROM GinPolReinPoolRiskDetails gprrd " +
                "JOIN Currency tc ON gprrd.prprdRiskCurCode = tc.curCode " +
                "JOIN GinRiPoolSubclPerils grsp ON gprrd.prprdSclCode = grsp.rpscpSclCode " +
                "WHERE gprrd.prprdIpuCode = :ipuCode " +
                "AND gprrd.prprdCovtCode = :cvtCode " +
                "AND gprrd.prprdSclCode = :sclCode")
        List<PoolRecoveryPeril> findPoolRecoveryPerils(@Param("ipuCode") Long ipuCode,
                                                       @Param("cvtCode") Long cvtCode,
                                                       @Param("sclCode") Long sclCode);

    Optional<GinRiPoolSubclPerils> findByRpscpSclCodeAndRpscpPerCode(BigDecimal sclCode, BigDecimal perCode);
}
}