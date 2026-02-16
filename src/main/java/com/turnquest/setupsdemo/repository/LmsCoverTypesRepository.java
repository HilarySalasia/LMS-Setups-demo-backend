package com.turnquest.setupsdemo.repository;


import com.turnquest.setupsdemo.model.LmsCoverTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is a Spring Data JPA repository for LmsCoverTypes.
 * It provides methods to perform CRUD operations on the LmsCoverTypes entity.
 * It extends JpaRepository which provides JPA related methods that we can use with our entity.
 *
 * @Repository makes this class as a Bean in Spring Application Context.
 * It also indicates that this class is a Data Access Object (DAO).
 *
 * JpaRepository is a JPA specific extension of Repository which provides some additional methods, such as flushing the persistence context and deleting records in a batch.
 * It takes the domain class to manage as well as the id type of the domain class as type arguments.
 */
@Repository
public interface LmsCoverTypesRepository extends JpaRepository<LmsCoverTypes, Long> {

    /**
     * This method is used to find an LmsCoverTypes entity by its cvtCode attribute.
     * It returns an LmsCoverTypes entity.
     *
     * @param cvtCode the code of the cover type to find
     * @return the LmsCoverTypes entity
     */
    LmsCoverTypes findByCvtCode(Long cvtCode);

    /**
     * This method is used to find LmsCoverTypes entities by their cvtCode attribute.
     * It returns a list of LmsCoverTypes entities.
     *
     * @param tquoCode the code of the cover type to find
     * @return a list of LmsCoverTypes entities
     */
    @Query("SELECT c FROM LmsCoverTypes c WHERE c.cvtCode = :tquoCode")
    List<LmsCoverTypes> findCoverTypeByCode(Long tquoCode);

    /**
     * This method is used to count LmsCoverTypes entities by their cvtShtDesc attribute and where cvtCode is not a specific value.
     * It returns a Long representing the count.
     *
     * @param cvtShtDesc the short description of the cover type
     * @param cvtCode the code of the cover type to exclude
     * @return the count of LmsCoverTypes entities
     */
    Long countByCvtShtDescAndCvtCodeNot(String cvtShtDesc, Long cvtCode);

//    @Query("SELECT new com.example.dto.CoverTypeDTO(c.cvtCode, c.cvtShtDesc, c.cvtDesc, c.cvtRateProdSpecifc, " +
//            "c.cvtMainCover, c.cvtDurationType, c.cvtReadFrom, c.cvtRemarks, c.cvtMaxAge, c.cvtMultiplier, " +
//            "c.cvtMultDivFact, c.cvtRateType, c.cvtReportName, c.cvtRatesFreqOfPymt, c.cvtPayBen, c.cvtPayRate, " +
//            "c.cvtPayRateDivFact, c.cvtPayRateApplTo, ridertypedesc(c.cvtMainCover) as mainCoverDesc, c.cvtMinEmpPrd, " +
//            "c.cvtApplyWvrRates, c.cvtRisk, d.dtyDescription, c.cvtSaApplBasis, " +
//            "DECODE(c.cvtSaApplBasis, 'P', 'Per Policy', 'R', 'Per Life Assured') as cvtSaApplBasisDispl, " +
//            "c.cvtMaxAllowedPerDepType, c.cvtYrPremToPay, c.cvtCashbackAppPrd) " +
//            "FROM CoverType c " +
//            "JOIN Class cl ON c.cvtClaCode = cl.claCode " +
//            "LEFT JOIN DependentType d ON c.cvtRisk = d.dtyCode " +
//            "WHERE c.cvtCode = NVL(null, c.cvtCode) " +
//            "AND cl.claType = 'O' " +
//            "AND c.cvtCode NOT IN (SELECT pct.pctCvtCode FROM ProdCoverType pct WHERE pct.pctProdCode = :prodCode) " +
//            "ORDER BY c.cvtDesc")
    @Query("SELECT c " +
            "FROM LmsCoverTypes c " +
            "JOIN LmsClasses cl ON c.cvtClaCode = cl.claCode " +
            "LEFT JOIN LmsDependentType d ON c.cvtRisk = d.dtyCode " +
            "WHERE c.cvtCode = coalesce(null, c.cvtCode) " +
            "AND cl.claType = 'O' " +
            "AND c.cvtCode NOT IN (SELECT pct.lmsCoverTypes.cvtCode FROM LmsProdCoverTypes pct WHERE pct.pctProdCode = :prodCode) " +
            "ORDER BY c.cvtDesc")
    List<LmsCoverTypes> findCoverTypes(@Param("prodCode") Long prodCode);
}