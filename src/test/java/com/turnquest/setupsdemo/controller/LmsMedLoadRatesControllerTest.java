package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsMedLoadRates;
import com.turnquest.setupsdemo.service.LmsMedLoadRatesService;
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

class LmsMedLoadRatesControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LmsMedLoadRatesService service;

    @InjectMocks
    private LmsMedLoadRatesController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllRates() throws Exception {
        LmsMedLoadRates rate1 = new LmsMedLoadRates();
        LmsMedLoadRates rate2 = new LmsMedLoadRates();
        List<LmsMedLoadRates> rates = Arrays.asList(rate1, rate2);

        given(service.findAll()).willReturn(rates);

        mockMvc.perform(get("/api/med-load-rates"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(rates.size()));
    }

    @Test
    void getRateById() throws Exception {
        LmsMedLoadRates rate = new LmsMedLoadRates();
        rate.setMlrCode(1L);

        given(service.findById(1L)).willReturn(rate);

        mockMvc.perform(get("/api/med-load-rates/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mlrCode").value(1L));
    }

    @Test
    void createRate() throws Exception {
        LmsMedLoadRates rate = new LmsMedLoadRates();
        rate.setMlrCode(1L);

        given(service.save(rate)).willReturn(rate);

        mockMvc.perform(post("/api/med-load-rates")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"mlrCode\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mlrCode").value(1L));
    }

    @Test
    void updateRate() throws Exception {
        LmsMedLoadRates rate = new LmsMedLoadRates();
        rate.setMlrCode(1L);

        given(service.save(rate)).willReturn(rate);

        mockMvc.perform(put("/api/med-load-rates/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"mlrCode\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mlrCode").value(1L));
    }

    @Test
    void deleteRate() throws Exception {
        mockMvc.perform(delete("/api/med-load-rates/1"))
                .andExpect(status().isOk());
    }
}