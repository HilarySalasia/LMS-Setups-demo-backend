package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.dto.ProductCodeDescDto;
import com.turnquest.setupsdemo.model.LmsProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LmsProductRepository extends JpaRepository<LmsProducts, Long> {

    @Query("SELECT NVL(prodInvestAllPrem, 'N') FROM LmsProducts WHERE prodCode = :prodCode")
    String findInvestAllPremByProdCode(Long prodCode);

    @Query("SELECT prodShtDesc FROM LmsProducts WHERE prodCode = :prodCode")
    String findProdShtDescByProdCode(Long prodCode);

    @Query("SELECT p FROM LmsProducts p WHERE p.lmsClasses.claType = :claType")
    List<LmsProducts> findProdDescByProclaType(@Param("claType") String claType);

    @Query("SELECT new com.turnquest.setupsdemo.dto.ProductCodeDescDto(p.prodCode, p.prodDesc) " +
            "FROM LmsProducts p WHERE p.lmsClasses.claType = :claType")
    List<ProductCodeDescDto> findProdCodeAndProdDescByLmsClasses_claType(@Param("claType") String claType);
}

