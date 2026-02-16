package com.turnquest.setupsdemo.service;


import com.turnquest.setupsdemo.model.LmsOrdPremTerms;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service interface for managing LMS Ord Prem Terms.
 */
public interface LmsOrdPremTermsService {

    List<LmsOrdPremTerms> findAll();

    LmsOrdPremTerms findById(Long id);

    LmsOrdPremTerms save(LmsOrdPremTerms lmsOrdPremTerms);

    void deleteById(Long id);

    void insertOrUpdateOrdPremTerms(LmsOrdPremTerms lmsOrdPremTerms);

    @Query("SELECT l FROM LmsOrdPremTerms l WHERE l.lmsProdCoverTypes.pctCode = :pctCode")
    List<LmsOrdPremTerms> findByPctCode(@Param("pctCode") String pctCode);

    List<LmsOrdPremTerms> findByPopCode(BigDecimal popCode);

    List<LmsOrdPremTerms> findByPctCodeAndPopCode(BigDecimal pctCode, BigDecimal popCode);
}
