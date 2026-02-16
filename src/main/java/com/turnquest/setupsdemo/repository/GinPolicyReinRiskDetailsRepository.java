package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.dto.TreatyDetailsDTO;
import com.turnquest.setupsdemo.model.GinPolicyReinRiskDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface GinPolicyReinRiskDetailsRepository extends JpaRepository<GinPolicyReinRiskDetails, Long> {
    List<GinPolicyReinRiskDetails> findByPtotrIpuCodeAndPtotrPrrdCodeAndPtotrTranTypeNotAndPtotrCessionPctNotNull(
            Long ptotrIpuCode,
            Long ptotrPrrdCode,
            String ptotrTranType);

    @Query("SELECT new com.turnquest.setupsdemo.dto.TreatyDetailsDTO(ptotr.ptotrCode, ptotr.ptotrRiskCurCode, ptotr.ptotrTrtCurCode, " +
            "ptotr.ptotrReiCode, ptotr.ptotrTrtCode, ptotr.ptotrTrtShtDesc, ptotr.ptotrCltSclCode, " +
            "ptotr.ptotrCessionPct, ptotr.ptotrUwyr, ptotr.ptotrIpuCode, ptotr.ptotrPolBatchNo, ptotr.ptotrRiskCurSymbol, " +
            "ptotr.ptotrTrtCurSymbol, ptotr.ptotrTaCode, ptotr.ptotrAsCode, ptotr.ptotrTrsCode, ptotr.ptotrTrsShtDesc, " +
            "ta.taType, ptotr.ptotrDate, ta.taCode, rei.reiNextReiCode) " +
            "FROM GinPolicyReinRiskDetails ptotr " +
            "JOIN GinTreatyArrangements ta ON ptotr.ptotrTaCode = ta.taCode " +
            "JOIN GinTreatySetups rei ON ptotr.ptotrReiCode = rei.reiCode " +
            "WHERE ptotr.ptotrIpuCode = :ipuCode " +
            "AND ptotr.ptotrTranType != 'CO' " +
            "AND NVL(ptotr.ptotrCessionPct, 0) != 0 " +
            "AND ptotr.ptotrPrrdCode = :prrdCode")
    List<TreatyDetailsDTO> findTreatyDetails(@Param("ipuCode") Long ipuCode,
                                             @Param("prrdCode") Long prrdCode);
}
