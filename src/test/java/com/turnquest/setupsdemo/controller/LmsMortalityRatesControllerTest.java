package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsMortalityRates;
import com.turnquest.setupsdemo.service.LmsMortalityRatesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class LmsMortalityRatesControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LmsMortalityRatesService service;

    @InjectMocks
    private LmsMortalityRatesController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllRates() throws Exception {
        LmsMortalityRates rate1 = new LmsMortalityRates();
        LmsMortalityRates rate2 = new LmsMortalityRates();
        List<LmsMortalityRates> rates = Arrays.asList(rate1, rate2);

        given(service.findAll()).willReturn(rates);

        mockMvc.perform(get("/api/mortality-rates"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(rates.size()));
    }

    @Test
    void getRateById() throws Exception {
        LmsMortalityRates rate = new LmsMortalityRates();
        rate.setLmrCode(1L);

        given(service.findById(1L)).willReturn(rate);

        mockMvc.perform(get("/api/mortality-rates/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lmrCode").value(1L));
    }

    @Test
    void createRate() throws Exception {
        LmsMortalityRates rate = new LmsMortalityRates();
        rate.setLmrCode(1L);

        given(service.save(rate)).willReturn(rate);

        mockMvc.perform(post("/api/mortality-rates")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"lmrCode\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lmrCode").value(1L));
    }

    @Test
    void updateRate() throws Exception {
        LmsMortalityRates rate = new LmsMortalityRates();
        rate.setLmrCode(1L);

        given(service.save(rate)).willReturn(rate);

        mockMvc.perform(put("/api/mortality-rates/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"lmrCode\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lmrCode").value(1L));
    }

    @Test
    void deleteRate() throws Exception {
        mockMvc.perform(delete("/api/mortality-rates/1"))
                .andExpect(status().isOk());
    }
}