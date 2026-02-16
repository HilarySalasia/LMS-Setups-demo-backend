package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.dto.ClaimPerilRevisionDto;
import com.turnquest.setupsdemo.dto.ClaimRecordDto;
import com.turnquest.setupsdemo.model.GinClaimMasterBookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GinClaimMasterBookingsRepository extends JpaRepository<GinClaimMasterBookings, String> {
    // Method for checking existing claims based on specific criteria
    @Query("SELECT c FROM GinClaimMasterBookings c " +
            "WHERE c.cmbIpuCode = :ipuCode " +
            "AND c.cmbLossDateTime = :lossDateTime " +
            "AND c.cmbPolBatchNo = :polBatchNo")
    List<GinClaimMasterBookings> findAllByIpuCodeAndLossDateTimeAndPolBatchNo(
            @Param("ipuCode") Long ipuCode,
            @Param("lossDateTime") LocalDate lossDateTime,
            @Param("polBatchNo") Long polBatchNo
    );

    @Query("SELECT c FROM GinClaimMasterBookings c " +
            "WHERE c.cmbIpuCode = :ipuCode " +
            "AND c.cmbLossDateTime = :lossDateTime ")
    List<GinClaimMasterBookings> findByCmbIpuCodeAndCmbLossDateTime(
            @Param("ipuCode") Long ipuCode,
            @Param("lossDateTime") LocalDate lossDateTime);

    boolean existsByClaimNo(String claimNo);

    boolean existsByIpuCodeAndLossDateTime(Long ipuCode, LocalDate lossDateTime);

    List<GinClaimMasterBookings> findByCmbIpuCode(Long cmbIpuCode);

    @Query("SELECT new com.turnquest.setupsdemo.dto.ClaimPerilRevisionDto(COALESCE(cmb.cmbOtherCoverDetails, 'PL'), " +
                    "       clmp.clmpReserveAmt, clmp.clmpCode, cmb.cmbIpuValue, " +
                    "       clmp.clmpGgtTransNo, clmp.clmpType, clmp.clmpPerPtCode, " +
                    "       clmp.clmpOverride )" +
                    "FROM GinClaimMasterBookings cmb " +
                    "JOIN GinClaimPerils clmp ON cmb.cmbClaimNo = clmp.clmpCmbClaimNo " +
                    "WHERE clmp.clmpCmbClaimNo = :claimNo")
    List<ClaimPerilRevisionDto> findClaimPerilRevisionsByClaimNo(@Param("claimNo") String claimNo);

    Optional<GinClaimMasterBookings> findByCmbClaimNo(String cmbClaimNo);

    @Query(nativeQuery = true,
            value = "SELECT cmb.cmb_scl_code scl_code, cmb.cmb_claim_no claim_no, cmb.cmb_cur_code, " +
                    "       TO_NUMBER(TO_CHAR(cmb.cmb_loss_date_time, 'RRRR')) uw_year, " +
                    "       cmb.cmb_eve_code, cmb.cmb_eve_sht_desc, " +
                    "       COALESCE(total_rev.incurred, 0) incurred, " +
                    "       COALESCE(total_rev.xchangerate, 1) xchangerate " +
                    "FROM gin_claim_master_bookings cmb " +
                    "LEFT JOIN (SELECT cmb_claim_no, SUM(clmrev_comp_retention * DECODE(:trtCurrParam, 'Y', 1, clmrev_cur_rate)) incurred, DECODE(:trtCurrParam, 'Y', 1, clmrev_cur_rate) xchangerate " +
                    "          FROM gin_claim_master_bookings cmb2 " +
                    "          JOIN gin_claim_revisions clmrev ON cmb2.cmb_claim_no = clmrev.clmrev_cmb_claim_no " +
                    "          WHERE clmrev.clmrev_authorised = 'Y' " +
                    "          GROUP BY cmb_claim_no, clmrev_cur_rate) total_rev ON cmb.cmb_claim_no = total_rev.cmb_claim_no " +
                    "WHERE cmb.cmb_claim_no = :claimNo AND :enableXol = 'Y'")
    List<ClaimRecordDto> findClaimRecordsByClaimNo(@Param("claimNo") String claimNo,
                                                   @Param("enableXol") String enableXol,
                                                   @Param("trtCurrParam") String trtCurrParam);

    @Query("SELECT SUM(COALESCE(clmrev.clmrevCompRetention, 0) * DECODE(:trtCurrParam, 'Y', 1, clmrev.clmrevCurRate)) " +
            "FROM GinClaimRevisions clmrev WHERE clmrev.clmrevCmbClaimNo = :cmbEveCode AND clmrev.clmrevAuthorised = 'Y'")
    BigDecimal findEventIncurred(@Param("cmbEveCode") Long cmbEveCode, @Param("trtCurrParam") String trtCurrParam);
}