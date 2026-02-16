package com.turnquest.setupsdemo.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.turnquest.setupsdemo.model.LmsProdOptions;
import com.turnquest.setupsdemo.model.LmsProducts;
import com.turnquest.setupsdemo.repository.LmsProductRepository;
import com.turnquest.setupsdemo.service.LmsProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.MessageSource;

import java.math.BigDecimal;
import java.util.*;

public class LmsProductServiceImplTest {

    @Mock
    private LmsProductRepository lmsProductRepository;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private LmsProductServiceImpl lmsProductService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        List<LmsProducts> products = Arrays.asList(new LmsProducts(), new LmsProducts());
        when(lmsProductRepository.findAll()).thenReturn(products);

        List<LmsProducts> result = lmsProductService.findAll();

        assertEquals(products.size(), result.size());
        verify(lmsProductRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        Long id = 1L;
        LmsProducts product = new LmsProducts();
        when(lmsProductRepository.findById(id)).thenReturn(Optional.of(product));

        LmsProducts result = lmsProductService.findById(id);

        assertNotNull(result);
        assertEquals(product, result);
        verify(lmsProductRepository, times(1)).findById(id);
    }

    @Test
    void testFindById_NotFound() {
        Long id = 1L;
        when(lmsProductRepository.findById(id)).thenReturn(Optional.empty());
        when(messageSource.getMessage(eq("error.product.notfound"), any(), any())).thenReturn("Product not found");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            lmsProductService.findById(id);
        });

        assertEquals("Product not found", exception.getMessage());
        verify(lmsProductRepository, times(1)).findById(id);
    }

    @Test
    void testSave() {
        LmsProducts product = new LmsProducts();
        when(lmsProductRepository.save(product)).thenReturn(product);

        LmsProducts result = lmsProductService.save(product);

        assertNotNull(result);
        assertEquals(product, result);
        verify(lmsProductRepository, times(1)).save(product);
    }

    @Test
    void testDeleteById() {
        Long id = 1L;
        doNothing().when(lmsProductRepository).deleteById(id);

        lmsProductService.deleteById(id);

        verify(lmsProductRepository, times(1)).deleteById(id);
    }

    @Test
    void testFindProdDescByProclaCode() {
        String proclaType = "O";
        List<LmsProducts> products = Arrays.asList(new LmsProducts(), new LmsProducts());
        when(lmsProductRepository.findProdDescByProclaType(proclaType)).thenReturn(products);

        List<LmsProducts> result = lmsProductService.findProdDescByProclaType(proclaType);

        assertEquals(products.size(), result.size());
        verify(lmsProductRepository, times(1)).findProdDescByProclaType(proclaType);
    }
}
