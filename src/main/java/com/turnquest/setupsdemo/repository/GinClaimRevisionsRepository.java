package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.dto.UnauthorizedTransactionDto;
import com.turnquest.setupsdemo.model.GinClaimRevisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for GinClaimRevisions entity.
 */
@Repository
public interface GinClaimRevisionsRepository extends JpaRepository<GinClaimRevisions, Long> {

    @Query("SELECT SUM(COALESCE(clmrev.clmrevAmt, 0)) FROM GinClaimRevisions clmrev " +
            "WHERE clmrev.clmrevCmbClaimNo = :claimNo AND COALESCE(clmrev.clmrevAuthorised, 'N') = 'Y'")
    Optional<BigDecimal> findTotalAuthorizedReserveByClaimNo(@Param("claimNo") String claimNo);

    @Query("SELECT SUM(COALESCE(clmrev.clmrevAmt, 0)) FROM GinClaimRevisions clmrev " +
            "WHERE clmrev.clmrevCmbClaimNo = :claimNo")
    Optional<BigDecimal> findTotalReserveByClaimNo(@Param("claimNo") String claimNo);

    void deleteAllByClmrevGgtTransNo(Long ggtTransNo);

    Optional<GinClaimRevisions> findByClmrevGgtTransNo(Long ggtTransNo);

    @Query("SELECT new com.turnquest.setupsdemo.dto.UnauthorizedTransactionDto(clmrev.clmrevGgtTransNo, " +
            "clmrev.clmrevCompRetention * DECODE(:trtCurrParam, 'Y', 1, clmrev.clmrevCurRate), " +
            "DECODE(:trtCurrParam, 'Y', 1, clmrev.clmrevCurRate)) FROM GinClaimRevisions clmrev WHERE " +
            "clmrev.clmrevCmbClaimNo = :claimNo AND clmrev.clmrevAuthorised <> 'Y' ORDER BY " +
            "CASE WHEN clmrev.clmrevGgtTransNo = :transNo THEN 1 ELSE 2 END, clmrev.clmrevGgtTransNo")
    List<UnauthorizedTransactionDto> findUnauthorizedTransactions(@Param("claimNo") String claimNo,
                                                                  @Param("transNo") Long transNo,
                                                                  @Param("trtCurrParam") String trtCurrParam);
}