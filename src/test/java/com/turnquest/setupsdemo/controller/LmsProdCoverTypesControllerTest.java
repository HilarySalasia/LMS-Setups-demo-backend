package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsProdCoverTypes;
import com.turnquest.setupsdemo.service.LmsProdCoverTypesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class LmsProdCoverTypesControllerTest {

    @Mock
    private LmsProdCoverTypesService lmsProdCoverTypesService;

    @InjectMocks
    private LmsProdCoverTypesController lmsProdCoverTypesController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(lmsProdCoverTypesController).build();
    }

    @Test
    void getAllProdCoverTypes() throws Exception {
        List<LmsProdCoverTypes> coverTypes = Arrays.asList(new LmsProdCoverTypes(), new LmsProdCoverTypes());
        when(lmsProdCoverTypesService.findAll()).thenReturn(coverTypes);

        mockMvc.perform(get("/api/lmsprodcovertypes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

        verify(lmsProdCoverTypesService, times(1)).findAll();
    }

    @Test
    void getProdCoverTypeById() throws Exception {
        LmsProdCoverTypes coverType = new LmsProdCoverTypes();
        when(lmsProdCoverTypesService.findById(1L)).thenReturn(coverType);

        mockMvc.perform(get("/api/lmsprodcovertypes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pctCode").value(coverType.getPctCode()));

        verify(lmsProdCoverTypesService, times(1)).findById(1L);
    }

    @Test
    void createProdCoverType() throws Exception {
        LmsProdCoverTypes coverType = new LmsProdCoverTypes();
        coverType.setPctCode(1L);
        when(lmsProdCoverTypesService.save(any(LmsProdCoverTypes.class))).thenReturn(coverType);

        mockMvc.perform(post("/api/lmsprodcovertypes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"pctCode\":\"1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pctCode").value(1L));

        verify(lmsProdCoverTypesService, times(1)).save(any(LmsProdCoverTypes.class));
    }

    @Test
    void deleteProdCoverType() throws Exception {
        doNothing().when(lmsProdCoverTypesService).deleteById(1L);

        mockMvc.perform(delete("/api/lmsprodcovertypes/1"))
                .andExpect(status().isNoContent());

        verify(lmsProdCoverTypesService, times(1)).deleteById(1L);
    }
}