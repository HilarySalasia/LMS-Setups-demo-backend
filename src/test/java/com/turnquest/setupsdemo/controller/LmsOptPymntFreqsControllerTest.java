package com.turnquest.setupsdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnquest.setupsdemo.model.LmsOptPymntFreqs;
import com.turnquest.setupsdemo.model.LmsProdOptions;
import com.turnquest.setupsdemo.service.LmsOptPymntFreqsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class LmsOptPymntFreqsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LmsOptPymntFreqsService lmsOptPymntFreqsService;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private LmsOptPymntFreqsController lmsOptPymntFreqsController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(lmsOptPymntFreqsController).build();
    }

    @Test
    void testFindAll() throws Exception {
        LmsOptPymntFreqs pymntFreq = new LmsOptPymntFreqs();
        pymntFreq.setOpfCode(1L);
        pymntFreq.setOpfPymntFeq("Monthly");

        when(lmsOptPymntFreqsService.findAll()).thenReturn(Collections.singletonList(pymntFreq));

        mockMvc.perform(get("/api/payment-frequencies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].opfCode").value(1))
                .andExpect(jsonPath("$[0].opfPymntFeq").value("Monthly"));
    }

    @Test
    void testFindById() throws Exception {
        LmsOptPymntFreqs pymntFreq = new LmsOptPymntFreqs();
        pymntFreq.setOpfCode(1L);
        pymntFreq.setOpfPymntFeq("Monthly");

        when(lmsOptPymntFreqsService.findById(anyLong())).thenReturn(pymntFreq);

        mockMvc.perform(get("/api/payment-frequencies/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.opfCode").value(1))
                .andExpect(jsonPath("$.opfPymntFeq").value("Monthly"));
    }

    @Test
    void testSave() throws Exception {
        LmsOptPymntFreqs pymntFreq = new LmsOptPymntFreqs();
        pymntFreq.setOpfCode(1L);
        pymntFreq.setOpfPymntFeq("Monthly");

        when(lmsOptPymntFreqsService.save(any(LmsOptPymntFreqs.class))).thenReturn(pymntFreq);

        mockMvc.perform(post("/api/payment-frequencies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"opfPymntFeq\": \"Monthly\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.opfCode").value(1))
                .andExpect(jsonPath("$.opfPymntFeq").value("Monthly"));
    }

    @Test
    void testDeleteById() throws Exception {
        mockMvc.perform(delete("/api/payment-frequencies/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testInsertOrUpdatePaymentFrequency() throws Exception {
        LmsOptPymntFreqs request = new LmsOptPymntFreqs();
        request.setOpfCode(1L);
        request.setOpfPymntFeq("Monthly");
        LmsProdOptions prodOptions = new LmsProdOptions();
        prodOptions.setPopCode(1L);
        request.setLmsProdOptions(prodOptions);
        request.setOpfWef(new Date());
        request.setOpfWet(new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(request);

        mockMvc.perform(post("/api/payment-frequencies/insertOrUpdate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andExpect(status().isOk());

        verify(lmsOptPymntFreqsService).insertOrUpdatePaymentFrequency(any(Long.class), any(String.class),
                any(Long.class), any(Date.class), any(Date.class));
    }
}