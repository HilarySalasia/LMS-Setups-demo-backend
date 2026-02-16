package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClaimPerils;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for {@link GinClaimPerils} entities.
 */
@Repository
public interface GinClaimPerilsRepository extends JpaRepository<GinClaimPerils, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE GinClaimPerils clmp SET clmp.clmpReserveAmt = :reserveAmt, clmp.clmpTotalReserve = :totalReserve, " +
            "clmp.clmpSsprmCode = :ssprmCode WHERE clmp.clmpCode = :clmpCode")
    void updateClaimPeril(@Param("clmpCode") Long clmpCode,
                          @Param("reserveAmt") BigDecimal reserveAmt,
                          @Param("totalReserve") BigDecimal totalReserve,
                          @Param("ssprmCode") Long ssprmCode);

    // ... other methods ...
    @Query("SELECT clmp FROM GinClaimPerils clmp WHERE clmp.clmpCmbClaimNo = :clmpCmbClaimNo AND " +
            "clmp.clmpPerPtCode = :clmpPerPtCode AND clmp.clmpRegClmtCode = :clmpRegClmtCode")
    Optional<GinClaimPerils> findByClmpCmbClaimNoAndClmpPerPtCodeAndClmpRegClmtCode(
            @Param("clmpCmbClaimNo") String clmpCmbClaimNo,
            @Param("clmpPerPtCode") Long clmpPerPtCode,
            @Param("clmpRegClmtCode") Long clmpRegClmtCode);

    @Query("SELECT clmp FROM GinClaimPerils clmp WHERE clmp.clmpCmbClaimNo = :clmpCmbClaimNo " +
            "AND clmp.clmpRegCldCode = :clmpRegCldCode")
    List<GinClaimPerils> findByClmpCmbClaimNoAndClmpRegCldCode(
            @Param("clmpCmbClaimNo") String clmpCmbClaimNo,
            @Param("clmpRegCldCode") Long clmpRegCldCode);
    @Query("SELECT SUM(COALESCE(clmp.clmpTotalReserve, clmp.clmpReserveAmt)) FROM GinClaimPerils clmp " +
            "WHERE clmp.clmpCmbClaimNo = :claimNo AND clmp.clmpPerPtCode = :perCode AND clmp.clmpRegCldCode = :insuredCode")
    Optional<BigDecimal> findTotalReserveByClaimNoAndPerCodeAndInsuredCode(
            @Param("claimNo") String claimNo,
            @Param("perCode") Long perCode,
            @Param("insuredCode") Long insuredCode
    );

    List<GinClaimPerils> findAllByClmpCmbClaimNo(String claimNo);

    @Modifying
    @Transactional
    @Query("UPDATE GinClaimPerils clmp SET clmp.clmpExcessAmt = :clmpExcessAmt, " +
            "clmp.clmpNoviceExcessAmt = :clmpNoviceExcessAmt WHERE clmp.clmpCode = :clmpCode")
    void updateClmpExcessAmtAndClmpNoviceExcessAmt(@Param("clmpCode") Long clmpCode,
                                                   @Param("clmpExcessAmt") BigDecimal clmpExcessAmt,
                                                   @Param("clmpNoviceExcessAmt") BigDecimal clmpNoviceExcessAmt);
}