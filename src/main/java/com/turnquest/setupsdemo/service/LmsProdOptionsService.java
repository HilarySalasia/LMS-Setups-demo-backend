package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.dto.ProdOptionCodeDescDTO;
import com.turnquest.setupsdemo.model.LmsProdOptions;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service interface for managing LMS Product Options.
 */
public interface LmsProdOptionsService {

    /**
     * Get all product options.
     *
     * @return List of all product options.
     */
    List<LmsProdOptions> findAll();

    /**
     * Get product option by id.
     *
     * @param id the id of the product option.
     * @return the product option with the given id.
     */
    LmsProdOptions findById(Long id);

    /**
     * Save a product option.
     *
     * @param lmsProdOptions the product option to save.
     * @return the saved product option.
     */
    LmsProdOptions save(LmsProdOptions lmsProdOptions);

    /**
     * Delete a product option by id.
     *
     * @param id the id of the product option to delete.
     */
    void deleteById(Long id);

    List<LmsProdOptions> findByProdCode(BigDecimal prodCode);

    List<LmsProdOptions> findByProdCodeAndPopCode(BigDecimal prodCode, BigDecimal popCode);

    LmsProdOptions findProdOptionById(Long popCode);

    List<ProdOptionCodeDescDTO> findPopCodeAndPopDescByPopProdCode(BigDecimal prodCode);
}
