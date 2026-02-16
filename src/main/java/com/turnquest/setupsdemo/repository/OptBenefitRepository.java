package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.dto.CoverTypeDetailsDTO;
import com.turnquest.setupsdemo.dto.OptionBenefitPopCodePopDescOpbCodeDto;
import com.turnquest.setupsdemo.dto.ProdOptionCodeDescDTO;
import com.turnquest.setupsdemo.model.OptBenefit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for OptBenefit entity.
 */
@Repository
public interface OptBenefitRepository extends JpaRepository<OptBenefit, BigDecimal> {

    /**
     * Custom query to find OptBenefits by product option code.
     *
     * @param popCode the product option code to search for
     * @return a list of OptBenefits
     */
    @Query("SELECT ob FROM OptBenefit ob WHERE ob.productOption.popCode = :popCode")
    List<OptBenefit> findByOpbPopCode(BigDecimal popCode);

//    @Query("SELECT new com.turnquest.setupsdemo.dto.OptionBenefitPopCodePopDescOpbCodeDto(po.popCode, po.popDesc) " +
//       "FROM LmsProdOptions po " +
//            "WHERE po.popProdCode = :prodCode ")
    @Query("SELECT new com.turnquest.setupsdemo.dto.OptionBenefitPopCodePopDescOpbCodeDto(" +
            "pop.popCode, pop.popDesc) " +
            "FROM LmsProdOptions pop " +
            "LEFT JOIN RateType a ON pop.popPuSvtCode = a.svtCode " +
            "LEFT JOIN RateType b ON pop.popTmbnsSvtCode = b.svtCode " +
            "WHERE pop.popProdCode = COALESCE(:prodCode, pop.popProdCode) " +
            "AND pop.popCode = COALESCE(NULL, pop.popCode)")
List<OptionBenefitPopCodePopDescOpbCodeDto> findProdOptionDetailsByProdCode(BigDecimal prodCode);
//    @Query(value = "SELECT new com.turnquest.setupsdemo.dto.CoverTypeDetailsDTO(ob.prodCoverType.pctCode, " +
//            "ob.prodCoverType.lmsCoverTypes.cvtDesc) " +
//            "FROM OptBenefit ob " +
//            "WHERE ob.productOption.popCode = :popCode ")
    @Query("SELECT new com.turnquest.setupsdemo.dto.CoverTypeDetailsDTO(" +
            "ob.prodCoverType.pctCode, ct.cvtDesc) " +
            "FROM OptBenefit ob " +
            "JOIN LmsProdCoverTypes pc ON ob.prodCoverType.pctCode = pc.pctCode " +
            "JOIN LmsCoverTypes ct ON pc.lmsCoverTypes.cvtCode = ct.cvtCode " +
            "LEFT JOIN RateType sr ON ob.rateType.svtCode = sr.svtCode " +
            "WHERE ob.opbCode = COALESCE(NULL, ob.opbCode) " +
            "AND ob.productOption.popCode = :popCode")
List<CoverTypeDetailsDTO> findCoverTypesDetailsByPopCodeAndObpCode(BigDecimal popCode);
}