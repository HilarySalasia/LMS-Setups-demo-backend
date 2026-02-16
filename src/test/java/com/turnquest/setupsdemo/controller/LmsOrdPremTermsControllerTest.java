package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsOrdPremTerms;
import com.turnquest.setupsdemo.model.LmsProdCoverTypes;
import com.turnquest.setupsdemo.model.LmsProdOptions;
import com.turnquest.setupsdemo.model.PremiumMask;
import com.turnquest.setupsdemo.service.LmsOrdPremTermsService;
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

class LmsOrdPremTermsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LmsOrdPremTermsService lmsOrdPremTermsService;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private LmsOrdPremTermsController lmsOrdPremTermsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(lmsOrdPremTermsController).build();
    }

    @Test
    void testFindAll() throws Exception {
        LmsOrdPremTerms ordPremTerms = new LmsOrdPremTerms();
        ordPremTerms.setOptCode(1L);
        ordPremTerms.setOptTermFrom(5);

        when(lmsOrdPremTermsService.findAll()).thenReturn(Collections.singletonList(ordPremTerms));

        mockMvc.perform(get("/api/ord-prem-terms"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].optCode").value(1))
                .andExpect(jsonPath("$[0].optTermFrom").value(5));
    }

    @Test
    void testFindById() throws Exception {
        LmsOrdPremTerms ordPremTerms = new LmsOrdPremTerms();
        ordPremTerms.setOptCode(1L);
        ordPremTerms.setOptTermFrom(5);

        when(lmsOrdPremTermsService.findById(anyLong())).thenReturn(ordPremTerms);

        mockMvc.perform(get("/api/ord-prem-terms/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.optCode").value(1))
                .andExpect(jsonPath("$.optTermFrom").value(5));
    }

    @Test
    void testSave() throws Exception {
        LmsOrdPremTerms ordPremTerms = new LmsOrdPremTerms();
        ordPremTerms.setOptCode(1L);
        ordPremTerms.setOptTermFrom(5);

        when(lmsOrdPremTermsService.save(any(LmsOrdPremTerms.class))).thenReturn(ordPremTerms);

        mockMvc.perform(post("/api/ord-prem-terms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"optTermFrom\": 5}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.optCode").value(1))
                .andExpect(jsonPath("$.optTermFrom").value(5));
    }

    @Test
    void testDeleteById() throws Exception {
        mockMvc.perform(delete("/api/ord-prem-terms/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testInsertOrUpdateOrdPremTerms() throws Exception {
        LmsOrdPremTerms ordPremTerms = new LmsOrdPremTerms();
        ordPremTerms.setOptCode(1L);
        ordPremTerms.setOptTermFrom(5);
        ordPremTerms.setOptTermTo(10);
        ordPremTerms.setLmsProdCoverTypes(new LmsProdCoverTypes());
        ordPremTerms.getLmsProdCoverTypes().setPctCode(1L);
        ordPremTerms.setLmsProdOptions(new LmsProdOptions());
        ordPremTerms.getLmsProdOptions().setPopCode(1L);
        ordPremTerms.setLmsPremiumMasks(new PremiumMask());
        ordPremTerms.getLmsPremiumMasks().setPmasCode(BigDecimal.ONE);

        mockMvc.perform(post("/api/ord-prem-terms/insertOrUpdate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"optCode\": 1, \"optTermFrom\": 5, \"optTermTo\": 10, \"lmsProdCoverTypes\": {\"pctCode\": 1}, \"lmsProdOptions\": {\"popCode\": 1}, \"lmsPremiumMasks\": {\"pmasCode\": 1}}"))
                .andExpect(status().isOk());
    }
}
