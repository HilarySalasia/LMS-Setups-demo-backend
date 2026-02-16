package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.LmsOrdPremRateTables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LmsOrdPremRateTablesRepository extends JpaRepository<LmsOrdPremRateTables, Long> {

    List<LmsOrdPremRateTables> findByOrdOptCode(BigDecimal ordOptCode);

    @Query("SELECT o FROM LmsOrdPremRateTables o WHERE o.ordtPmasCode = :pmasCode " +
            "AND o.ordtPopCode = :popCode AND o.ordtPctCode = :pctCode " +
            "AND o.ordOptCode = :optCode AND " +
            "COALESCE(o.lmsOrdPremIntrRate.opirCode, -1L) = COALESCE(:opirCode, COALESCE(o.lmsOrdPremIntrRate.opirCode, -1L)) " +
            "AND o.ordtGender = COALESCE(:gender, 'B') AND o.ordtClaCode IN " +
            "(SELECT c.claCode FROM LmsClasses c WHERE c.claType = 'O')")
    List<LmsOrdPremRateTables> findOrdPremRateTables( BigDecimal pmasCode,
                                                  BigDecimal popCode,
                                                  BigDecimal pctCode,
                                                  BigDecimal optCode,
                                                  Long opirCode,
                                                  String gender);
}
