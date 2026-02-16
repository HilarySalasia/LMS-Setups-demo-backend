package com.turnquest.setupsdemo.controller;


import com.turnquest.setupsdemo.dto.AgeTableDto;
import com.turnquest.setupsdemo.dto.OptionCoverTypeDto;
import com.turnquest.setupsdemo.model.LmsCoverTypes;
import com.turnquest.setupsdemo.service.CoverTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
/**
 * This class is a REST controller that handles HTTP requests related to cover types.
 * It uses the CoverTypeService to perform business logic and operations related to cover types.
 */
@RestController
@RequestMapping("/api/covertypes")
public class CoverTypeController {

    private final CoverTypeService coverTypeService;
    private final MessageSource messageSource;

    /**
     * Constructor for the CoverTypeController.
     * It initializes the CoverTypeService and MessageSource.
     *
     * @param coverTypeService the service to perform operations related to cover types
     * @param messageSource the source to get messages from
     */
    @Autowired
    public CoverTypeController(CoverTypeService coverTypeService,
                               MessageSource messageSource) {

        this.coverTypeService = coverTypeService;
        this.messageSource = messageSource;
    }

    /**
     * This method handles GET requests to retrieve a specific cover type by its ID.
     *
     * @param cvtCode the ID of the cover type to retrieve
     * @return a ResponseEntity containing the cover type if found, or an error message if not found
     */
    @GetMapping("/{cvtCode}")
    public ResponseEntity<?> getCoverType(@PathVariable Long cvtCode) {
        try {
            LmsCoverTypes coverType = coverTypeService.getCoverType(cvtCode);
            return ResponseEntity.ok(coverType);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * This method handles GET requests to retrieve all cover types.
     *
     * @return a ResponseEntity containing a list of all cover types, or an error message if an error occurs
     */
    @GetMapping
    public ResponseEntity<?> getAllCoverTypes() {
        try {
            List<LmsCoverTypes> coverTypes = coverTypeService.getAllCoverTypes();
            return ResponseEntity.ok(coverTypes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * This method handles DELETE requests to delete a specific cover type by its ID.
     *
     * @param cvtCode the ID of the cover type to delete
     * @return a ResponseEntity indicating the result of the operation
     */
    @DeleteMapping("/{cvtCode}")
    public ResponseEntity<?> deleteCoverType(@PathVariable Long cvtCode) {
        try {
            coverTypeService.deleteCoverType(cvtCode);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /**
     * This method handles POST requests to create or update a cover type.
     *
     * @param coverType the cover type to create or update
     * @param locale the locale to use for messages
     * @return a ResponseEntity indicating the result of the operation
     */
    @PostMapping
    public ResponseEntity<String> createOrUpdateCoverType(@RequestBody LmsCoverTypes coverType,
                                                          @RequestParam("locale") Locale locale) {
        coverTypeService.updateCoverTypes(coverType, locale);
            return ResponseEntity.ok().build();
    }

    @GetMapping("/coverTypes")
    public List<LmsCoverTypes> getCoverTypes(@RequestParam(value = "cvtCode", required = false) Long cvtCode,
                                             @RequestParam("prodCode") Long prodCode, Locale locale) {
        return coverTypeService.findCoverTypes(cvtCode, prodCode);
    }

    @GetMapping("/{popCode}/{opbCode}")
    public ResponseEntity<List<OptionCoverTypeDto>> getOptionCoverTypes(
            @PathVariable BigDecimal popCode,
            @PathVariable(required = false) BigDecimal opbCode) {
        List<OptionCoverTypeDto> result = coverTypeService.getOptionCoverTypes(popCode, opbCode);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/age-table/{latCode}")
    public ResponseEntity<List<AgeTableDto>> getAgeTable(@PathVariable String latCode) {
        List<AgeTableDto> ageTableDtos = coverTypeService.getAgeTable(latCode);
        return new ResponseEntity<>(ageTableDtos, HttpStatus.OK);
    }
}