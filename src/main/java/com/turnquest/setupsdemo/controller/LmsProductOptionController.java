package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsProdOptions;
import com.turnquest.setupsdemo.service.LmsProdOptionsService;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * REST controller for managing ProductOption entities.
 */
@RestController
@RequestMapping("/api/productOptions")
public class LmsProductOptionController {
    private final LmsProdOptionsService productOptionService;
    private final MessageSource messageSource;

    public LmsProductOptionController(LmsProdOptionsService productOptionService, MessageSource messageSource) {
        this.productOptionService = productOptionService;
        this.messageSource = messageSource;
    }

    /**
 * This method is used to fetch all product options.
 * It sends a GET request to "/api/prodoptions".
 *
 * @return a ResponseEntity containing a list of all product options.
 */
@GetMapping
public ResponseEntity<List<LmsProdOptions>> findAll() {
    return ResponseEntity.ok(productOptionService.findAll());
}

    /**
     * This method is used to fetch a product option by its id.
     * It sends a GET request to "/api/prodoptions/{id}".
     *
     * @param id the id of the product option to fetch.
     * @return a ResponseEntity containing the product option with the given id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<LmsProdOptions> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productOptionService.findById(id));
    }

    /**
     * This method is used to save a product option.
     * It sends a POST request to "/api/prodoptions".
     *
     * @param lmsProdOptions the product option to save.
     * @return a ResponseEntity containing the saved product option.
     */
    @PostMapping
    public ResponseEntity<LmsProdOptions> save(@RequestBody LmsProdOptions lmsProdOptions) {
        return ResponseEntity.ok(productOptionService.save(lmsProdOptions));
    }

    /**
     * This method is used to delete a product option by its id.
     * It sends a DELETE request to "/api/prodoptions/{id}".
     *
     * @param id the id of the product option to delete.
     * @return a ResponseEntity with status 200 (OK).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productOptionService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * This method is used to fetch product options by product code.
     * It sends a GET request to "/api/prodoptions/prodcode/{prodCode}".
     *
     * @param prodCode the product code of the product options to fetch.
     * @return a ResponseEntity containing a list of product options with the given product code.
     */
    @GetMapping("/prodcode/{prodCode}")
    public ResponseEntity<List<LmsProdOptions>> findByProdCode(@PathVariable BigDecimal prodCode) {
        return ResponseEntity.ok(productOptionService.findByProdCode(prodCode));
    }

    /**
     * GET /api/productOptions : Get product options by product code and option code.
     *
     * @param prodCode the product code
     * @param popCode  the option code
     * @param locale   the locale
     * @return the ResponseEntity with status 200 (OK) and the list of product options in the body
     */
    @GetMapping("/byProdCodeAndPopCode/{locale}")
    public ResponseEntity<List<LmsProdOptions>> getProductOptions(@RequestParam(required = false) BigDecimal prodCode,
                                                                  @RequestParam(required = false) BigDecimal popCode,
                                                                  @PathVariable Locale locale) {
        List<LmsProdOptions> productOptions = productOptionService.findByProdCodeAndPopCode(prodCode, popCode);
        if (productOptions.isEmpty()) {
            String message = messageSource.getMessage("productOption.noDataFound", null, locale);
            return ResponseEntity.noContent().header("Message", message).build();
        }
        return ResponseEntity.ok(productOptions);
    }
}
