package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.AgeTableDto;
import com.turnquest.setupsdemo.model.LmsClasses;
import com.turnquest.setupsdemo.model.LmsCoverTypes;
import com.turnquest.setupsdemo.repository.LmsClassesRepository;
import com.turnquest.setupsdemo.repository.LmsCoverTypesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CoverTypeServiceImplTest {

    @InjectMocks
    private CoverTypeServiceImpl coverTypeService;

    @Mock
    private LmsCoverTypesRepository coverTypesRepository;

    @Mock
    private LmsClassesRepository classesRepository;

    @Mock
    private MessageSource messageSource;

    @Mock
    private SimpleJdbcCall simpleJdbcCall;

    @Mock
    private DataSource dataSource;

    @BeforeEach
    public void init() throws SQLException {
        MockitoAnnotations.openMocks(this);

        Connection connection = mock(Connection.class);
        when(dataSource.getConnection()).thenReturn(connection);
    }

    @Test
    public void testUpdateCoverTypes() {
        LmsCoverTypes coverType = new LmsCoverTypes();
        coverType.setCvtCode(1L);
        coverType.setCvtShtDesc("Test Cover Type");

        when(coverTypesRepository.countByCvtShtDescAndCvtCodeNot(coverType.getCvtShtDesc(), coverType.getCvtCode())).thenReturn(0L);
        when(coverTypesRepository.save(any(LmsCoverTypes.class))).thenReturn(coverType);

        coverTypeService.updateCoverTypes(coverType, Locale.US);

        verify(coverTypesRepository, times(1)).countByCvtShtDescAndCvtCodeNot(coverType.getCvtShtDesc(), coverType.getCvtCode());
        verify(coverTypesRepository, times(1)).save(any(LmsCoverTypes.class));
    }

    @Test
    public void testGetCoverType() throws Exception {
        LmsCoverTypes coverType = new LmsCoverTypes();
        coverType.setCvtCode(1L);

        when(coverTypesRepository.findById(anyLong())).thenReturn(Optional.of(coverType));

        LmsCoverTypes result = coverTypeService.getCoverType(1L);

        assertEquals(coverType, result);
        verify(coverTypesRepository, times(1)).findById(anyLong());
    }

    @Test
    public void testGetAllCoverTypes() throws Exception {
        LmsCoverTypes coverType1 = new LmsCoverTypes();
        coverType1.setCvtCode(1L);

        LmsCoverTypes coverType2 = new LmsCoverTypes();
        coverType2.setCvtCode(2L);

        when(coverTypesRepository.findAll()).thenReturn(Arrays.asList(coverType1, coverType2));

        assertEquals(2, coverTypeService.getAllCoverTypes().size());
        verify(coverTypesRepository, times(1)).findAll();
    }

    @Test
    public void testDeleteCoverType() throws Exception {
        LmsCoverTypes coverType = new LmsCoverTypes();
        coverType.setCvtCode(1L);

        when(coverTypesRepository.findById(anyLong())).thenReturn(Optional.of(coverType));
        doNothing().when(coverTypesRepository).deleteById(anyLong());

        coverTypeService.deleteCoverType(1L);

        verify(coverTypesRepository, times(1)).findById(anyLong());
        verify(coverTypesRepository, times(1)).deleteById(anyLong());
    }

    @Test
    public void testGetAgeTable() {
        // Mock SimpleJdbcCall's execute method to return the expected result
        when(simpleJdbcCall.withCatalogName("LMS_WEB_CURSOR_SETUP")).thenReturn(simpleJdbcCall);
        when(simpleJdbcCall.withProcedureName("AGE_TABLE")).thenReturn(simpleJdbcCall);
        when(simpleJdbcCall.declareParameters(any(SqlOutParameter.class), any(SqlParameter.class))).thenReturn(simpleJdbcCall);
        when(simpleJdbcCall.execute(anyString())).thenReturn(mockResult());

        List<AgeTableDto> ageTableDtos = coverTypeService.getAgeTable("200000");

        assertEquals(1, ageTableDtos.size());
        AgeTableDto dto = ageTableDtos.get(0);
        assertEquals(200000, dto.getLatCode());
        assertEquals(20, dto.getLatAgeFrom());
        assertEquals(30, dto.getLatAgeTo());
    }

    private Map<String, Object> mockResult() {
        return Map.of(
                "v_age_table_ref", List.of(
                        Map.of(
                                "LAT_CODE", 200000,
                                "LAT_AGE_FROM", 20,
                                "LAT_AGE_TO", 30
                        )
                )
        );
    }
}