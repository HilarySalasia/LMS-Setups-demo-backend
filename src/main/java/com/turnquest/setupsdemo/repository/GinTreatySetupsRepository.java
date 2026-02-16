package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinTreatySetups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface GinTreatySetupsRepository extends JpaRepository<GinTreatySetups, Long> {
    Optional<GinTreatySetups> findByReiTrsCodeAndReiAsCodeAndAsTaCodeAndAsUwyr(
            Long reiTrsCode,
            Long reiAsCode,
            Long asTaCode,
            int asUwyr);
    Optional<GinTreatySetups> findByReiCodeAndReiAsCodeAndAsUwyr(
            Long reiCode,
            Long reiAsCode,
            int asUwyr);

    List<Long> findByReiTrsCodeIn(List<Long> reiTrsCode);

    @Query("SELECT COUNT(DISTINCT ta.taCode) " +
            "FROM GinTreatyArrangements ta " +
            "JOIN GinArrangementSetups as_ ON ta.taCode = as_.asTaCode " +
            "JOIN GinClassTreaty clt ON as_.asCode = clt.cltAsCode " +
            "WHERE clt.cltSclCode = :sclCode " +
            "AND as_.asUwyr = TO_NUMBER(TO_CHAR(:lossDate, 'YYYY')) " +
            "AND ta.taCurCode = :curCode")
    Long getTreatyArrangementCount(@Param("sclCode") Long sclCode,
                                  @Param("lossDate") java.util.Date lossDate,
                                  @Param("curCode") Long curCode);

    List<Long> findByReiAsCodeIn(List<Long> reiAsCode);
}
