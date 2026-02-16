package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.AgeTableDto;
import com.turnquest.setupsdemo.dto.OptionCoverTypeDto;
import com.turnquest.setupsdemo.model.LmsClasses;
import com.turnquest.setupsdemo.model.LmsCoverTypes;
import com.turnquest.setupsdemo.repository.LmsClassesRepository;
import com.turnquest.setupsdemo.repository.LmsCoverTypesRepository;
import com.turnquest.setupsdemo.service.CoverTypeService;
import jakarta.transaction.Transactional;
import org.springframework.context.MessageSource;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Types;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementation of the CoverTypeService interface.
 * Handles the creation and updating of cover types with appropriate validation and error handling.
 */
@Service
public class CoverTypeServiceImpl implements CoverTypeService {

    private final LmsCoverTypesRepository coverTypesRepository;
    private final LmsClassesRepository classesRepository;
    private final MessageSource messageSource;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall jdbcCall;
    private final DataSource dataSource;

    /**
     * Constructs a new CoverTypeServiceImpl with the specified repositories and message source.
     *
     * @param coverTypesRepository the repository for cover types
     * @param classesRepository the repository for classes
     * @param messageSource the message source for internationalization
     * @param jdbcTemplate the JdbcTemplate for database operations
     * @param dataSource the DataSource for database connections
     */
    public CoverTypeServiceImpl(LmsCoverTypesRepository coverTypesRepository,
                                LmsClassesRepository classesRepository,
                                MessageSource messageSource,
                                JdbcTemplate jdbcTemplate,
                                DataSource dataSource) {
        this.coverTypesRepository = coverTypesRepository;
        this.classesRepository = classesRepository;
        this.messageSource = messageSource;
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    /**
     * Creates or updates a cover type based on the provided entity.
     *
     * @param coverType the cover type entity to create or update
     * @param locale the locale for internationalization
     */
    @Override
    @Transactional
    public void updateCoverTypes(LmsCoverTypes coverType, Locale locale) {
        Long count = coverTypesRepository.countByCvtShtDescAndCvtCodeNot(coverType.getCvtShtDesc(), coverType.getCvtCode());
        if (count > 0) {
            throw new RuntimeException(messageSource.getMessage("error.cover_id_exists", , locale));
        }

        if (coverType.getCvtCode() == null) {
            createCoverType(coverType, locale);
        } else {
            updateCoverType(coverType);
        }
    }

    /**
     * Retrieves a cover type by its code.
     *
     * @param cvtCode the code of the cover type
     * @return the cover type entity
     * @throws Exception if the cover type is not found
     */
    @Override
    public LmsCoverTypes getCoverType(Long cvtCode) throws Exception {
        Optional<LmsCoverTypes> coverTypeOpt = coverTypesRepository.findById(cvtCode);
        if (coverTypeOpt.isPresent()) {
            return coverTypeOpt.get();
        } else {
            String errorMessage = messageSource.getMessage("error.cover.type.not.found", null, Locale.getDefault());
            throw new Exception(errorMessage);
        }
    }

    /**
     * Creates a new cover type.
     *
     * @param coverType the cover type entity to create
     * @param locale the locale for internationalization
     */
    private void createCoverType(LmsCoverTypes coverType, Locale locale) {
        try {
            LmsClasses clazz = classesRepository.findByClaShtDesc("GRP")
                    .orElseThrow(() -> new RuntimeException(messageSource.getMessage("error.class_not_found",
                            null, Locale.getDefault())));

            LmsCoverTypes newCoverType = new LmsCoverTypes();
            newCoverType.setCvtShtDesc(coverType.getCvtShtDesc());
            newCoverType.setCvtDesc(coverType.getCvtDesc());
            newCoverType.setCvtMainCover(coverType.getCvtMainCover());
            newCoverType.setCvtDurationType(coverType.getCvtDurationType());
            newCoverType.setCvtMaxAge(coverType.getCvtMaxAge());
            newCoverType.setCvtMultiplier(coverType.getCvtMultiplier());
            newCoverType.setCvtMultDivFact(coverType.getCvtMultDivFact());
            newCoverType.setCvtReadFrom(coverType.getCvtReadFrom());
            newCoverType.setCvtRateType(coverType.getCvtRateType());
            newCoverType.setCvtReportName(coverType.getCvtReportName());
            newCoverType.setCvtRemarks(coverType.getCvtRemarks());
            newCoverType.setCvtRatesFreqOfPymt(coverType.getCvtRatesFreqOfPymt());
            newCoverType.setCvtPayBen(coverType.getCvtPayBen());
            newCoverType.setCvtClaCode(clazz.getClaCode());
            newCoverType.setCvtMaxInstNo(coverType.getCvtMaxInstNo());
            newCoverType.setCvtWaitingPrd(coverType.getCvtWaitingPrd());
            newCoverType.setCvtRetireAge(coverType.getCvtRetireAge());
            newCoverType.setCvtFixedSa(coverType.getCvtFixedSa());
            newCoverType.setCvtFixedSaAmt(coverType.getCvtFixedSaAmt());
            newCoverType.setCvtOccBen(coverType.getCvtOccBen());
            newCoverType.setCvtPayRate(coverType.getCvtPayRate());
            newCoverType.setCvtPayRateDivFact(coverType.getCvtPayRateDivFact());
            newCoverType.setCvtPayRateApplTo(coverType.getCvtPayRateApplTo());
            newCoverType.setCvtMinEmpPrd(coverType.getCvtMinEmpPrd());

            newCoverType.setCvtCode(generateCoverTypeCode().longValue());
            coverTypesRepository.save(newCoverType);
        } catch (Exception e) {
            throw new RuntimeException(messageSource.getMessage("error.creating_cover_type", null, locale), e);
        }
    }

    /**
     * Updates an existing cover type.
     *
     * @param coverType the cover type entity to update
     */
    private void updateCoverType(LmsCoverTypes coverType) {
        try {
            coverTypesRepository.save(coverType);
        } catch (Exception e) {
            throw new RuntimeException(messageSource.getMessage("error.updating_cover_type", null, Locale.getDefault()), e);
        }
    }

    /**
     * Generates a unique code for a cover type.
     *
     * @return the generated cover type code
     */
    private BigInteger generateCoverTypeCode() {
        String yearPart = String.valueOf(java.time.Year.now().getValue());
        String sequencePart = String.valueOf((System.currentTimeMillis() / 1000) + (long) (Math.random() * 10000));
        return new BigInteger(yearPart + sequencePart);
    }

    /**
     * Retrieves all cover types.
     *
     * @return a list of all cover types
     * @throws Exception if an error occurs while retrieving cover types
     */
    @Override
    public List<LmsCoverTypes> getAllCoverTypes() throws Exception {
        return coverTypesRepository.findAll();
    }

    /**
     * Deletes a cover type by its code.
     *
     * @param cvtCode the code of the cover type to delete
     * @throws Exception if the cover type is not found
     */
    @Override
    public void deleteCoverType(Long cvtCode) throws Exception {
        Optional<LmsCoverTypes> coverTypeOpt = coverTypesRepository.findById(cvtCode);
        if (coverTypeOpt.isPresent()) {
            coverTypesRepository.deleteById(cvtCode);
        } else {
            String errorMessage = messageSource.getMessage("error.cover.type.not.found", null, Locale.getDefault());
            throw new Exception(errorMessage);
        }
    }

    /**
     * Finds cover types by product code.
     *
     * @param cvtCode the cover type code
     * @param prodCode the product code
     * @return a list of cover types
     */
    @Override
    public List<LmsCoverTypes> findCoverTypes(Long cvtCode, Long prodCode) {
        return coverTypesRepository.findCoverTypes(prodCode);
    }

    /**
     * Retrieves option cover types based on pop code and opb code.
     *
     * @param popCode the pop code
     * @param opbCode the opb code
     * @return a list of option cover type DTOs
     */
    @Override
    public List<OptionCoverTypeDto> getOptionCoverTypes(BigDecimal popCode, BigDecimal opbCode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(this.dataSource)
                .withCatalogName("LMS_WEB_CURSOR_SETUP")
                .withProcedureName("OPTIONCOVERTYPES")
                .declareParameters(
                        new SqlOutParameter("v_optioncovertypes_ref", Types.REF_CURSOR),
                        new SqlParameter("v_pop_code", Types.VARCHAR),
                        new SqlParameter("v_opb_code", Types.VARCHAR)
                );
        Map<String, Object> result = jdbcCall.execute(popCode, null);
        List<OptionCoverTypeDto> optionCoverTypes = (List<OptionCoverTypeDto>) result.get("v_optioncovertypes_ref");
        return optionCoverTypes;
    }

    @Override
    public List<AgeTableDto> getAgeTable(String latCode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(this.dataSource)
                .withCatalogName("LMS_WEB_CURSOR_SETUP")
                .withProcedureName("AGE_TABLE")
                .declareParameters(
                        new SqlOutParameter("v_age_table_ref", Types.REF_CURSOR),
                        new SqlParameter("v_lat_code", Types.VARCHAR)
                );

        Map<String, Object> result = jdbcCall.execute(latCode);
        List<Map<String, Object>> resultSet = (List<Map<String, Object>>) result.get("v_age_table_ref");

        return resultSet.stream().map(this::mapRowToDto).collect(Collectors.toList());
    }

    private AgeTableDto mapRowToDto(Map<String, Object> row) {
        AgeTableDto dto = new AgeTableDto();
        dto.setLatCode((BigDecimal) row.get("LAT_CODE"));
        dto.setLatAgeFrom((BigDecimal) row.get("LAT_AGE_FROM"));
        dto.setLatAgeTo((BigDecimal) row.get("LAT_AGE_TO"));
        return dto;
    }
}