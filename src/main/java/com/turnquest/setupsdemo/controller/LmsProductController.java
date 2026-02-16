package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsProducts;
import com.turnquest.setupsdemo.service.LmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * REST controller for managing LMS Products.
 */
@RestController
@RequestMapping("/api/products")
public class LmsProductController {

    private final LmsProductService lmsProductService;
    private final MessageSource messageSource;

    /**
     * Constructor for LmsProductController.
     *
     * @param lmsProductService the service for LMS products.
     * @param messageSource     the message source for i18n.
     */
    public LmsProductController(LmsProductService lmsProductService, MessageSource messageSource) {
        this.lmsProductService = lmsProductService;
        this.messageSource = messageSource;
    }

    /**
     * Get all products.
     *
     * @return ResponseEntity with the list of all products.
     */
    @GetMapping
    public ResponseEntity<List<LmsProducts>> findAll() {
        List<LmsProducts> products = lmsProductService.findAll();
        return ResponseEntity.ok(products);
    }

    /**
     * Get product by id.
     *
     * @param id the id of the product.
     * @return ResponseEntity with the product with the given id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<LmsProducts> findById(@PathVariable Long id) {
        LmsProducts product = lmsProductService.findById(id);
        return ResponseEntity.ok(product);
    }

    /**
     * Save a product.
     *
     * @param lmsProduct the product to save.
     * @return ResponseEntity with the saved product.
     */
    @PostMapping
    public ResponseEntity<LmsProducts> save(@RequestBody LmsProducts lmsProduct) {
        LmsProducts savedProduct = lmsProductService.save(lmsProduct);
        return ResponseEntity.ok(savedProduct);
    }

    /**
     * Delete a product by id.
     *
     * @param id the id of the product to delete.
     * @return ResponseEntity with status 200 (OK).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        lmsProductService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Get products by procla code.
     *
     * @param claType the procla code of the products.
     * @return ResponseEntity with the list of products matching the procla code.
     */
    @GetMapping("/claType/{claType}")
    public ResponseEntity<List<LmsProducts>> findProdDescByProclaCode(@PathVariable String claType) {
        List<LmsProducts> products = lmsProductService.findProdDescByProclaType(claType);
        return ResponseEntity.ok(products);
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
}
