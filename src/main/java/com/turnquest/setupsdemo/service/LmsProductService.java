package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.dto.ProductCodeDescDto;
import com.turnquest.setupsdemo.model.LmsProducts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface LmsProductService {

    /**
     * Get all products.
     *
     * @return List of all products.
     */
    List<LmsProducts> findAll();

    /**
     * Get product by id.
     *
     * @param id the id of the product.
     * @return the product with the given id.
     */
    LmsProducts findById(Long id);

    /**
     * Save a product.
     *
     * @param lmsProduct the product to save.
     * @return the saved product.
     */
    LmsProducts save(LmsProducts lmsProduct);

    /**
     * Delete a product by id.
     *
     * @param id the id of the product to delete.
     */
    void deleteById(Long id);

    List<LmsProducts> findProdDescByProclaType(String claType);

    List<ProductCodeDescDto> findProdCodeAndProdDescByLmsClasses_claType(String claType);



}
