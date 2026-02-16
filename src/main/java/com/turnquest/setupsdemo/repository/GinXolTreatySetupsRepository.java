package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinXolTreatySetups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GinXolTreatySetupsRepository extends JpaRepository<GinXolTreatySetups, Long> {
    // ... other methods ...
    @Query(nativeQuery = true,
            value = "SELECT NVL(xta.xta_vlmp, 'N') xta_vlmp " +
                    "FROM gin_xol_treaty_setups xols " +
                    "JOIN gin_xol_treaties xol ON xols.xols_xol_code = xol.xol_code " +
                    "JOIN gin_xol_arrangement_setups xas ON xols.xols_xas_code = xas.xas_code " +
                    "JOIN gin_xol_treaty_arrangements xta ON xas.xas_xta_code = xta.xta_code " +
                    "JOIN gin_xol_classes xolc ON xta.xta_code = xolc.xolc_xta_code " +
                    "WHERE xolc.xolc_scl_code IN (SELECT CMB_SCL_CODE FROM GIN_CLAIM_MASTER_BOOKINGS WHERE CMB_CLAIM_NO = :claimNo) " +
                    "AND xol.xol_type = 'W' " +
                    "AND xolc.xolc_xas_code = xas.xas_code " +
                    "AND xolc.xolc_xta_code = xas.xas_xta_code " +
                    "AND xas.xas_code = xols.xols_xas_code " +
                    "AND xas.xas_xta_code = xta.xta_code " +
                    "FETCH FIRST ROW ONLY")
    String findXtaVlmpByClaimNo(@Param("claimNo") String claimNo);

    @Query("SELECT xols FROM GinXolTreatySetups xols " +
            "WHERE xols.xolsXasCode IN (SELECT xas.xasCode FROM GinXolArrangementSetups xas " +
            "WHERE xas.xasUwyr = :uwYear) AND xols.xolcSclCode = :sclCode AND xols.xolsCurCode = :curCode " +
            "ORDER BY xols.xolsLayer ASC")
    List<GinXolTreatySetups> findAllByXasUwyrAndXolcSclCodeAndXolsCurCode(@Param("uwYear") int uwYear,
                                                                          @Param("sclCode") Long sclCode,
                                                                          @Param("curCode") Long curCode);
}