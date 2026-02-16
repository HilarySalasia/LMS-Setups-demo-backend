package com.turnquest.setupsdemo.controller;

import com.turnquest.setupsdemo.model.LmsDependentType;
import com.turnquest.setupsdemo.service.LmsDependentTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LmsDependentTypeController.class)
public class LmsDependentTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LmsDependentTypeService service;

    @Test
    public void testGetAllDependentTypes() throws Exception {
        Mockito.when(service.getAllDependentTypes()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/dependent-types"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetDependentTypeById() throws Exception {
        LmsDependentType dependentType = new LmsDependentType();
        dependentType.setDtyCode(BigDecimal.ONE);
        Mockito.when(service.getDependentTypeById(BigDecimal.ONE)).thenReturn(dependentType);

        mockMvc.perform(get("/api/dependent-types/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dtyCode").value(1));
    }

    @Test
    public void testCreateDependentType() throws Exception {
        LmsDependentType dependentType = new LmsDependentType();
        dependentType.setDtyCode(BigDecimal.ONE);
        Mockito.when(service.saveDependentType(Mockito.any())).thenReturn(dependentType);

        mockMvc.perform(post("/api/dependent-types")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"dtyCode\":1}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.dtyCode").value(1));
    }

    @Test
    public void testDeleteDependentType() throws Exception {
        Mockito.doNothing().when(service).deleteDependentType(BigDecimal.ONE);

        mockMvc.perform(delete("/api/dependent-types/1"))
                .andExpect(status().isOk());
    }
}