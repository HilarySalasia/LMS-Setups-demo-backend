package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsProdCoverTypes;
import com.turnquest.setupsdemo.model.LmsProdOptions;
import com.turnquest.setupsdemo.model.LmsProdSaPremLimits;
import com.turnquest.setupsdemo.model.LmsProducts;
import com.turnquest.setupsdemo.service.LmsProdSaPremLimitsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class LmsProdSaPremLimitsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LmsProdSaPremLimitsService lmsProdSaPremLimitsService;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private LmsProdSaPremLimitsController lmsProdSaPremLimitsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(lmsProdSaPremLimitsController).build();
    }

    @Test
    void testFindAll() throws Exception {
        LmsProdSaPremLimits saPremLimit = new LmsProdSaPremLimits();
        saPremLimit.setPsplCode(1L);
        saPremLimit.setPsplPayFreq("M");

        when(lmsProdSaPremLimitsService.findAll()).thenReturn(Collections.singletonList(saPremLimit));

        mockMvc.perform(get("/api/sa-prem-limits"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].psplCode").value(1))
                .andExpect(jsonPath("$[0].psplPayFreq").value("M"));
    }

    @Test
    void testFindById() throws Exception {
        LmsProdSaPremLimits saPremLimit = new LmsProdSaPremLimits();
        saPremLimit.setPsplCode(1L);
        saPremLimit.setPsplPayFreq("M");

        when(lmsProdSaPremLimitsService.findById(anyLong())).thenReturn(saPremLimit);

        mockMvc.perform(get("/api/sa-prem-limits/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.psplCode").value(1))
                .andExpect(jsonPath("$.psplPayFreq").value("M"));
    }

    @Test
    void testSave() throws Exception {
        LmsProdSaPremLimits saPremLimit = new LmsProdSaPremLimits();
        saPremLimit.setPsplCode(1L);
        saPremLimit.setPsplPayFreq("M");

        when(lmsProdSaPremLimitsService.save(any(LmsProdSaPremLimits.class))).thenReturn(saPremLimit);

        mockMvc.perform(post("/api/sa-prem-limits")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"psplPayFreq\": \"M\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.psplCode").value(1))
                .andExpect(jsonPath("$.psplPayFreq").value("M"));
    }

    @Test
    void testDeleteById() throws Exception {
        mockMvc.perform(delete("/api/sa-prem-limits/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testInsertOrUpdateSaPremLimits() throws Exception {
        LmsProdSaPremLimits saPremLimit = new LmsProdSaPremLimits();
        saPremLimit.setPsplCode(1L);
        saPremLimit.setPsplPayFreq("M");
        saPremLimit.setPsplMinPrem(BigDecimal.valueOf(100));
        saPremLimit.setPsplMaxPrem(BigDecimal.valueOf(1000));
        saPremLimit.setPsplMinSa(BigDecimal.valueOf(50000));
        saPremLimit.setPsplMaxSa(BigDecimal.valueOf(1000000));
        saPremLimit.setLmsProducts(new LmsProducts());
        saPremLimit.getLmsProducts().setProdCode(BigDecimal.valueOf(1L));
        saPremLimit.setPsplMinContri(BigDecimal.valueOf(50));
        saPremLimit.setPsplMaxContri(BigDecimal.valueOf(500));
        saPremLimit.setPsplPaMinSa(BigDecimal.valueOf(1000));
        saPremLimit.setLmsProdOptions(new LmsProdOptions());
        saPremLimit.getLmsProdOptions().setPopCode(1L);
        saPremLimit.setLmsProdCoverTypes(new LmsProdCoverTypes());
        saPremLimit.setPsplMinAge(18);
        saPremLimit.setPsplMaxAge(60);

        mockMvc.perform(post("/api/sa-prem-limits/insertOrUpdate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"psplCode\": 1, \"psplPayFreq\": \"M\", \"psplMinPrem\": 100, \"psplMaxPrem\": 1000, \"psplMinSa\": 50000, \"psplMaxSa\": 1000000, \"lmsProducts\": {\"prodCode\": 1}, \"psplMinContri\": 50, \"psplMaxContri\": 500, \"psplPaMinSa\": 1000, \"lmsProdOptions\": {\"popCode\": 1}, \"psplPctCode\": 1, \"psplMinAge\": 18, \"psplMaxAge\": 60}"))
                .andExpect(status().isOk());
    }
}