package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.dto.AgeTableDto;
import com.turnquest.setupsdemo.dto.OptionCoverTypeDto;
import com.turnquest.setupsdemo.model.LmsCoverTypes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * This is an interface for the CoverTypeService.
 * It provides methods to perform CRUD operations on the LmsCoverTypes entity.
 */
public interface CoverTypeService {


    /**
     * This method is used to retrieve an LmsCoverTypes entity by its cvtCode attribute.
     * It returns an LmsCoverTypes entity.
     *
     * @param cvtCode the code of the cover type to find
     * @return the LmsCoverTypes entity
     * @throws Exception if the LmsCoverTypes entity with the specified cvtCode is not found
     */
    LmsCoverTypes getCoverType(Long cvtCode) throws Exception;

    /**
     * This method is used to retrieve all LmsCoverTypes entities.
     * It returns a list of LmsCoverTypes entities.
     *
     * @return a list of LmsCoverTypes entities
     * @throws Exception if there is an issue retrieving the LmsCoverTypes entities
     */
    List<LmsCoverTypes> getAllCoverTypes() throws Exception;

    /**
     * This method is used to delete an LmsCoverTypes entity by its cvtCode attribute.
     *
     * @param cvtCode the code of the cover type to delete
     * @throws Exception if the LmsCoverTypes entity with the specified cvtCode is not found
     */
    void deleteCoverType(Long cvtCode) throws Exception;

    /**
     * This method is used to update an LmsCoverTypes entity.
     * It takes an LmsCoverTypes entity and a Locale as parameters.
     *
     * @param coverType the LmsCoverTypes entity to update
     * @param locale the locale to use for message resolution
     */
    void updateCoverTypes(LmsCoverTypes coverType, Locale locale);

    List<LmsCoverTypes> findCoverTypes(Long cvtCode, Long prodCode);

    List<OptionCoverTypeDto> getOptionCoverTypes(BigDecimal popCode, BigDecimal opbCode);

    List<AgeTableDto> getAgeTable(String latCode);
}


