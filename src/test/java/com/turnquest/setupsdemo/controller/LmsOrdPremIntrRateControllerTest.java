package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsOrdPremIntrRate;
import com.turnquest.setupsdemo.service.LmsOrdPremIntrRateService;
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

class LmsOrdPremIntrRateControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LmsOrdPremIntrRateService service;

    @InjectMocks
    private LmsOrdPremIntrRateController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void getAllRates() throws Exception {
        LmsOrdPremIntrRate rate1 = new LmsOrdPremIntrRate();
        LmsOrdPremIntrRate rate2 = new LmsOrdPremIntrRate();
        List<LmsOrdPremIntrRate> rates = Arrays.asList(rate1, rate2);

        given(service.findAll()).willReturn(rates);

        mockMvc.perform(get("/api/rates"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(rates.size()));
    }

    @Test
    void getRateById() throws Exception {
        LmsOrdPremIntrRate rate = new LmsOrdPremIntrRate();
        rate.setOpirCode(1L);

        given(service.findById(1L)).willReturn(rate);

        mockMvc.perform(get("/api/rates/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.opirCode").value(1L));
    }

    @Test
    void createRate() throws Exception {
        LmsOrdPremIntrRate rate = new LmsOrdPremIntrRate();
        rate.setOpirCode(1L);

        given(service.save(rate)).willReturn(rate);

        mockMvc.perform(post("/api/rates")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"opirCode\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.opirCode").value(1L));
    }

    @Test
    void updateRate() throws Exception {
        LmsOrdPremIntrRate rate = new LmsOrdPremIntrRate();
        rate.setOpirCode(1L);

        given(service.save(rate)).willReturn(rate);

        mockMvc.perform(put("/api/rates/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"opirCode\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.opirCode").value(1L));
    }

    @Test
    void deleteRate() throws Exception {
        mockMvc.perform(delete("/api/rates/1"))
                .andExpect(status().isOk());
    }
}