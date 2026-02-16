package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.ProductCodeDescDto;
import com.turnquest.setupsdemo.model.LmsProdOptions;
import com.turnquest.setupsdemo.model.LmsProducts;
import com.turnquest.setupsdemo.repository.LmsProdOptionsRepository;
import com.turnquest.setupsdemo.repository.LmsProductRepository;
import com.turnquest.setupsdemo.service.LmsProductService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class LmsProductServiceImpl implements LmsProductService {

    /**
     * The repository for LmsProducts.
     */
    private final LmsProductRepository lmsProductRepository;
    private final MessageSource messageSource;

    private final LmsProdOptionsRepository lmsProdOptionsRepository;

    /**
     * Constructor for LmsProductServiceImpl.
     *
     * @param lmsProductRepository the repository for LMS products.
     * @param messageSource the message source for i18n.
     */
    public LmsProductServiceImpl(
            LmsProductRepository lmsProductRepository,
             MessageSource messageSource,
            LmsProdOptionsRepository lmsProdOptionsRepository
    ) {
        this.lmsProductRepository = lmsProductRepository;
        this.messageSource = messageSource;
        this.lmsProdOptionsRepository = lmsProdOptionsRepository;
    }



    /**
     * Fetches all LmsProducts from the database.
     *
     * @return a list of all LmsProducts
     */
    @Override
    public List<LmsProducts> findAll() {
        return lmsProductRepository.findAll();
    }

    /**
     * Fetches a LmsProduct by its id from the database.
     *
     * @param id the id of the LmsProduct to fetch
     * @return the LmsProduct with the given id
     * @throws RuntimeException if no LmsProduct with the given id is found
     */
    @Override
    public LmsProducts findById(Long id) {
        return lmsProductRepository.findById(id).orElseThrow(() ->
                new RuntimeException(getMessage("error.product.notfound", null)));
    }

    /**
     * Saves a LmsProduct to the database.
     *
     * @param lmsProduct the LmsProduct to save
     * @return the saved LmsProduct
     */
    @Override
    public LmsProducts save(LmsProducts lmsProduct) {
        return lmsProductRepository.save(lmsProduct);
    }

    /**
     * Deletes a LmsProduct by its id from the database.
     *
     * @param id the id of the LmsProduct to delete
     */
    @Override
    public void deleteById(Long id) {
        lmsProductRepository.deleteById(id);
    }

    /**
     * Fetches all LmsProducts with a given proclaCode from the database.
     *
     * @param proclaCode the proclaCode of the LmsProducts to fetch
     * @return a list of LmsProducts with the given proclaCode
     */
    @Override
    public List<LmsProducts> findProdDescByProclaType(String claType) {
        return lmsProductRepository.findProdDescByProclaType(claType);
    }

    @Override
    public List<ProductCodeDescDto> findProdCodeAndProdDescByLmsClasses_claType(String claType) {
        return lmsProductRepository.findProdCodeAndProdDescByLmsClasses_claType(claType);
    }

    /**
     * Helper method to retrieve messages from the message source.
     *
     * @param code the message code.
     * @param args the message arguments.
     * @return the localized message.
     */
    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }

    /**
     * This method retrieves a hierarchical representation of product options for a given product code.
     * It fetches all product options associated with the provided product code, creates a root node for each product,
     * and then adds each product option as a child node to the corresponding product root node.
     *
     * @param proclaCode The product code for which to retrieve the product options hierarchy.
     * @return A list of maps, where each map represents a product root node with its associated child nodes.
     *         Each map contains the following keys:
     *         - "name": The name of the product or product option.
     *         - "level": The level of the node in the hierarchy (0 for product root nodes, 1 for product option child nodes).
     *         - "expandable": A boolean value indicating whether the node can be expanded to reveal its child nodes.
     *         - "children": A list of maps representing the child nodes of the current node (only present for product root nodes).
     */

}
