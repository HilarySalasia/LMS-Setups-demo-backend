package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsCoverTypes;
import com.turnquest.setupsdemo.service.CoverTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This class is responsible for testing the CoverTypeController class.
 * It uses Mockito to mock the dependencies and JUnit for the testing framework.
 */
public class CoverTypeControllerTest {

    @InjectMocks
    private CoverTypeController coverTypeController;

    @Mock
    private CoverTypeService coverTypeService;

    @Mock
    private MessageSource messageSource;

    /**
     * This method is executed before each test.
     * It initializes the mocks.
     */
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * This method tests the getCoverType method of the CoverTypeController class.
     * It asserts that the response status is 200 and the body is the expected cover type.
     * @throws Exception if any error occurs during the test
     */
    @Test
    public void testGetCoverType() throws Exception {
        LmsCoverTypes coverType = new LmsCoverTypes();
        when(coverTypeService.getCoverType(anyLong())).thenReturn(coverType);

        ResponseEntity<?> response = coverTypeController.getCoverType(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(coverType, response.getBody());
    }

    /**
     * This method tests the getAllCoverTypes method of the CoverTypeController class.
     * It asserts that the response status is 200 and the body is the expected list of cover types.
     * @throws Exception if any error occurs during the test
     */
    @Test
    public void testGetAllCoverTypes() throws Exception {
        List<LmsCoverTypes> coverTypes = Arrays.asList(new LmsCoverTypes(), new LmsCoverTypes());
        when(coverTypeService.getAllCoverTypes()).thenReturn(coverTypes);

        ResponseEntity<?> response = coverTypeController.getAllCoverTypes();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(coverTypes, response.getBody());
    }

    /**
     * This method tests the deleteCoverType method of the CoverTypeController class.
     * It asserts that the response status is 200.
     * @throws Exception if any error occurs during the test
     */
    @Test
    public void testDeleteCoverType() throws Exception {
        doNothing().when(coverTypeService).deleteCoverType(anyLong());

        ResponseEntity<?> response = coverTypeController.deleteCoverType(1L);

        assertEquals(200, response.getStatusCodeValue());
    }

    /**
     * This method tests the createOrUpdateCoverType method of the CoverTypeController class.
     * It asserts that the response status is 200 and the body is "Success".
     */
    @Test
    public void testCreateOrUpdateCoverType() {
        LmsCoverTypes coverType = new LmsCoverTypes();
        doNothing().when(coverTypeService).updateCoverTypes(any(LmsCoverTypes.class), any(Locale.class));
        when(messageSource.getMessage(anyString(), any(), any(Locale.class))).thenReturn("Success");

        ResponseEntity<String> response = coverTypeController.createOrUpdateCoverType(coverType, Locale.US);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Success", response.getBody());
    }
}