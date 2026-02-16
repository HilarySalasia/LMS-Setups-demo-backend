package com.turnquest.setupsdemo.controller;


import com.turnquest.setupsdemo.model.LmsProducts;
import com.turnquest.setupsdemo.service.LmsProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class LmsProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LmsProductService lmsProductService;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private LmsProductController lmsProductController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(lmsProductController).build();
    }

    @Test
    void testFindAll() throws Exception {
        LmsProducts product = new LmsProducts();
        product.setProdCode(BigDecimal.valueOf(1));
        product.setProdDesc("Product 1");

        when(lmsProductService.findAll()).thenReturn(Collections.singletonList(product));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].prodCode").value(1))
                .andExpect(jsonPath("$[0].prodDesc").value("Product 1"));
    }

    @Test
    void testFindById() throws Exception {
        LmsProducts product = new LmsProducts();
        product.setProdCode(BigDecimal.valueOf(1));
        product.setProdDesc("Product 1");

        when(lmsProductService.findById(anyLong())).thenReturn(product);

        mockMvc.perform(get("/api/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.prodCode").value(1))
                .andExpect(jsonPath("$.prodDesc").value("Product 1"));
    }

    @Test
    void testSave() throws Exception {
        LmsProducts product = new LmsProducts();
        product.setProdCode(BigDecimal.valueOf(1));
        product.setProdDesc("Product 1");

        when(lmsProductService.save(any(LmsProducts.class))).thenReturn(product);

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"prodDesc\": \"Product 1\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.prodCode").value(1))
                .andExpect(jsonPath("$.prodDesc").value("Product 1"));
    }

    @Test
    void testDeleteById() throws Exception {
        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testFindProdDescByProclaCode() throws Exception {
        LmsProducts product = new LmsProducts();
        product.setProdCode(BigDecimal.valueOf(1));
        product.setProdDesc("Product 1");

        when(lmsProductService.findProdDescByProclaType(any(String.class))).thenReturn(Collections.singletonList(product));

        mockMvc.perform(get("/api/products/claType/O"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].prodCode").value(1))
                .andExpect(jsonPath("$[0].prodDesc").value("Product 1"));
    }
}
