package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.dto.ProdOptionCodeDescDTO;
import com.turnquest.setupsdemo.model.LmsProdOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LmsProdOptionsRepository extends JpaRepository<LmsProdOptions, Long> {
    // Add custom queries if required

    @Query("SELECT p FROM LmsProdOptions p WHERE p.popProdCode = :prodCode")
    List<LmsProdOptions> findByLmsProductProdCode(BigDecimal prodCode);

    /**
     * Custom query to find ProductOptions by product code and option code with joins.
     *
     * @param prodCode the product code to search for
     * @param popCode  the option code to search for
     * @return a list of ProductOptions
     */
    @Query("SELECT po FROM LmsProdOptions po " +
            "LEFT JOIN RateType a ON po.popPuSvtCode = a.svtCode " +
            "LEFT JOIN RateType b ON po.popTmbnsSvtCode = b.svtCode " +
            "WHERE po.popProdCode = COALESCE(:prodCode, po.popProdCode) " +
            "AND po.popCode = COALESCE(:popCode, po.popCode)")
    List<LmsProdOptions> findByProdCodeAndPopCode(@Param("prodCode") BigDecimal prodCode,
                                                 @Param("popCode") BigDecimal popCode);

    @Query("SELECT new com.turnquest.setupsdemo.dto.ProdOptionCodeDescDTO(po.popCode, po.popDesc) " +
            "FROM LmsProdOptions po WHERE po.popProdCode = :prodCode")
    List<ProdOptionCodeDescDTO> findPopCodeAndPopDescByPopProdCode(BigDecimal prodCode);
}
