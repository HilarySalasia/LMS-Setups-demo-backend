package com.turnquest.setupsdemo.controller;


import com.turnquest.setupsdemo.model.LmsProdOptAnnPayout;
import com.turnquest.setupsdemo.model.LmsProdOptions;
import com.turnquest.setupsdemo.service.LmsProdOptAnnPayoutService;
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
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class LmsProdOptAnnPayoutControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LmsProdOptAnnPayoutService lmsProdOptAnnPayoutService;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private LmsProdOptAnnPayoutController lmsProdOptAnnPayoutController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(lmsProdOptAnnPayoutController).build();
    }

    @Test
    void testFindAll() throws Exception {
        LmsProdOptAnnPayout annPayout = new LmsProdOptAnnPayout();
        annPayout.setPopaCode(1L);
        annPayout.setPopaDayFrom(1L);

        when(lmsProdOptAnnPayoutService.findAll()).thenReturn(Collections.singletonList(annPayout));

        mockMvc.perform(get("/api/ann-payout"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].popaCode").value(1))
                .andExpect(jsonPath("$[0].popaDayFrom").value(1));
    }

    @Test
    void testFindById() throws Exception {
        LmsProdOptAnnPayout annPayout = new LmsProdOptAnnPayout();
        annPayout.setPopaCode(1L);
        annPayout.setPopaDayFrom(1L);

        when(lmsProdOptAnnPayoutService.findById(anyLong())).thenReturn(annPayout);

        mockMvc.perform(get("/api/ann-payout/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.popaCode").value(1))
                .andExpect(jsonPath("$.popaDayFrom").value(1));
    }

    @Test
    void testSave() throws Exception {
        LmsProdOptAnnPayout annPayout = new LmsProdOptAnnPayout();
        annPayout.setPopaCode(1L);
        annPayout.setPopaDayFrom(1L);

        when(lmsProdOptAnnPayoutService.save(any(LmsProdOptAnnPayout.class))).thenReturn(annPayout);

        mockMvc.perform(post("/api/ann-payout")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"popaDayFrom\": 1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.popaCode").value(1))
                .andExpect(jsonPath("$.popaDayFrom").value(1));
    }

    @Test
    void testDeleteById() throws Exception {
        mockMvc.perform(delete("/api/ann-payout/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testInsertOrUpdateAnnPayout() throws Exception {
        LmsProdOptAnnPayout annPayout = new LmsProdOptAnnPayout();
        annPayout.setPopaCode(1L);
        annPayout.setPopaDayFrom(1L);
        annPayout.setPopaDayTo(15L);
        annPayout.setPopaPaymentDay(20L);
        annPayout.setPopaCurMonth("C");
        annPayout.setLmsProdOptions(new LmsProdOptions());
        annPayout.getLmsProdOptions().setPopCode(1L);

        mockMvc.perform(post("/api/ann-payout/insertOrUpdate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"popaCode\": 1, \"popaDayFrom\": 1, \"popaDayTo\": 15, \"popaPaymentDay\": 20, \"popaCurMonth\": \"C\", \"lmsProdOptions\": {\"popCode\": 1}}"))
                .andExpect(status().isOk());
    }
}
