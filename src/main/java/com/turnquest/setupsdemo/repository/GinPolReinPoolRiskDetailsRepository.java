package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.dto.PoolRiskTreaties;
import com.turnquest.setupsdemo.model.GinPolReinPoolRiskDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GinPolReinPoolRiskDetailsRepository extends JpaRepository<GinPolReinPoolRiskDetails, Long> {
    List<GinPolReinPoolRiskDetails> findByPrprdIpuCodeAndPrprdPrrdCodeAndPrprdCovtCode(
            Long prprdIpuCode,
            Long prprdPrrdCode,
            Long prprdCovtCode);

    @Query("SELECT new com.turnquest.setupsdemo.dto.PoolRiskTreaties(pr.prprdUwyr, pr.prprdReinPoolRate, pr.prprdPolBatchNo, " +
            "pr.prprdSclCode, pr.prprdRiskCurCode, tc.curSymbol, pr.prprdCode, pr.prprdScrprCode) " +
            "FROM GinPolReinPoolRiskDetails pr " +
            "LEFT JOIN Currency tc ON pr.prprdRiskCurCode = tc.curCode " +
            "WHERE pr.prprdIpuCode = :ipuCode AND pr.prprdCovtCode = :cvtCode AND pr.prprdPrrdCode = :prrdCode")
    List<PoolRiskTreaties> findPoolRiskTreaties(@Param("ipuCode") Long ipuCode,
                                                @Param("cvtCode") Long cvtCode,
                                                @Param("prrdCode") Long prrdCode);
}
