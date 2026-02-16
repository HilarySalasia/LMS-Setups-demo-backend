package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.LmsOrdPremTerms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface LmsOrdPremTermsRepository extends JpaRepository<LmsOrdPremTerms, Long> {
    Optional<LmsOrdPremTerms> findByOptTermFromAndOptTermToAndLmsProdCoverTypes_PctCodeAndLmsProdOptions_PopCodeAndLmsPremiumMasks_PmasCode(
            Integer optTermFrom, Integer optTermTo, Long optPctCode, Long optPopCode, Long optPmasCode);

    @Query("SELECT l FROM LmsOrdPremTerms l WHERE l.lmsProdCoverTypes.pctCode = :pctCode")
    List<LmsOrdPremTerms> findByPctCode(String pctCode);

    @Query("SELECT l FROM LmsOrdPremTerms l WHERE l.lmsProdOptions.popCode = :popCode")
    List<LmsOrdPremTerms> findByPopCode(BigDecimal popCode);

    @Query("SELECT l FROM LmsOrdPremTerms l WHERE l.lmsProdCoverTypes.pctCode = :pctCode AND " +
            "l.lmsProdOptions.popCode = :popCode")
    List<LmsOrdPremTerms> findByPctCodeAndPopCode(BigDecimal pctCode, BigDecimal popCode);
}

