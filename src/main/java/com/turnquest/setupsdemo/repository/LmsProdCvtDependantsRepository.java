package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.dto.DependantDisplayDTO;
import com.turnquest.setupsdemo.model.LmsProdCvtDependants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LmsProdCvtDependantsRepository extends JpaRepository<LmsProdCvtDependants, Long> {

    @Query("SELECT new com.turnquest.setupsdemo.dto.DependantDisplayDTO(" +
            "d.pcdCode, dt.dtyDescription, d.pcdProdCode, d.lmsProdCoverTypes.pctCode, d.lmsDependentTypes.dtyCode, d.pcdDtyShtDesc, " +
            "d.pcdMaxNoAllowed, d.pcdMinAge, d.pcdMaxAge, d.pcdMaxSumAssured, d.lmsCoverTypes.cvtCode, d.pcdCvtShtDesc, " +
            "d.pcdMinSumAssrd, d.pcdFreqOfPay, ct.cvtDesc, d.pcdMandatory, pct.pctMandatory) " +
            "FROM LmsProdCvtDependants d " +
            "JOIN LmsDependentType dt ON d.lmsDependentTypes.dtyCode = dt.dtyCode " +
            "JOIN LmsCoverTypes ct ON d.lmsCoverTypes.cvtCode = ct.cvtCode " +
            "JOIN LmsProdCoverTypes pct ON d.lmsProdCoverTypes.pctCode = pct.pctCode " +
            "WHERE d.lmsProdCoverTypes.pctCode = :vPctCode " +
            "AND d.pcdCode = COALESCE(:vPcdCode, d.pcdCode)")
    List<DependantDisplayDTO> findDependantDisplay(@Param("vPctCode") Long vPctCode, @Param("vPcdCode") Long vPcdCode);
}
