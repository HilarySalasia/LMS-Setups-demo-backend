package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinTreatyArrangements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface GinTreatyArrangementsRepository extends JpaRepository<GinTreatyArrangements, Long> {
    List<GinTreatyArrangements> findByTaCodeInAndAsUwyrAndCltSclCodeAndTaCurCode(
            List<BigDecimal> taCode,
            int asUwyr,
            BigDecimal cltSclCode,
            BigDecimal taCurCode);
    Optional<String> findDistinctTaTypeByTaCodeInAndAsUwyrAndCltSclCodeAndReiCurCode(
            List<BigDecimal> taCode,
            int asUwyr,
            BigDecimal cltSclCode,
            BigDecimal reiCurCode);

    @Query("SELECT DISTINCT ta.taType " +
            "FROM GinTreatyArrangements ta " +
            "JOIN GinArrangementSetups as_ ON ta.taCode = as_.asTaCode " +
            "JOIN GinClassTreaty clt ON as_.asCode = clt.cltAsCode " +
            "JOIN GinTreatySetups rei ON as_.asCode = rei.reiAsCode " +
            "WHERE clt.cltSclCode = :sclCode " +
            "AND as_.asUwyr = TO_NUMBER(TO_CHAR(:lossDate, 'YYYY')) " +
            "AND rei.reiCurCode = :curCode")
    String getDistinctTreatyType(@Param("sclCode") Long sclCode,
                                 @Param("lossDate") java.util.Date lossDate,
                                 @Param("curCode") Long curCode);
}