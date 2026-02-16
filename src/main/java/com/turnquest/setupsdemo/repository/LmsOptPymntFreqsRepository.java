package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.LmsOptPymntFreqs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LmsOptPymntFreqsRepository extends JpaRepository<LmsOptPymntFreqs, Long> {
    @Query("SELECT nextval('opf_code_seq')")
    Long getNextOpfCodeSequence();

    @Query("SELECT COUNT(opf) FROM LmsOptPymntFreqs opf WHERE opf.lmsProdOptions.popCode = :popCode " +
       "AND opf.opfPymntFeq = :freqPymnt AND :wef BETWEEN opf.opfWef AND COALESCE(:wet, current_date )")
    long countByPopCodeAndFreqPymntAndWef(Long popCode, String freqPymnt, Date wef, Date wet);

    List<LmsOptPymntFreqs> findLmsOptPymntFreqsByLmsProdOptions_PopCode(Long popCode);
}
