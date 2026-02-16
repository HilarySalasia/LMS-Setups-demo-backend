package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.ProdOptionCodeDescDTO;
import com.turnquest.setupsdemo.model.LmsProdOptions;
import com.turnquest.setupsdemo.repository.LmsProdOptionsRepository;
import com.turnquest.setupsdemo.service.LmsProdOptionsService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

/**
 * Implementation of the LmsProdOptionsService interface.
 */
@Service
public class LmsProdOptionsServiceImpl implements LmsProdOptionsService {

    private final LmsProdOptionsRepository lmsProdOptionsRepository;
    private final MessageSource messageSource;

    /**
     * Constructor for LmsProdOptionsServiceImpl.
     *
     * @param lmsProdOptionsRepository the repository for LMS product options.
     * @param messageSource the message source for i18n.
     */
    public LmsProdOptionsServiceImpl(LmsProdOptionsRepository lmsProdOptionsRepository, MessageSource messageSource) {
        this.lmsProdOptionsRepository = lmsProdOptionsRepository;
        this.messageSource = messageSource;
    }

    @Override
    public List<LmsProdOptions> findAll() {
        return lmsProdOptionsRepository.findAll();
    }

    @Override
    public LmsProdOptions findById(Long id) {
        return lmsProdOptionsRepository.findById(id).orElseThrow(() ->
                new RuntimeException(getMessage("error.productoption.notfound", new Object[]{id})));
    }

    @Override
    public LmsProdOptions save(LmsProdOptions lmsProdOptions) {
        try {
            return lmsProdOptionsRepository.save(lmsProdOptions);
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.productoption.save.failed", null), e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            lmsProdOptionsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(getMessage("error.productoption.delete.failed", new Object[]{id}), e);
        }
    }

    @Override
    public List<LmsProdOptions> findByProdCode(BigDecimal prodCode) {
        return lmsProdOptionsRepository.findByLmsProductProdCode(prodCode);
    }

    public LmsProdOptions findProdOptionById(Long popCode) {
        // Logic to find LmsProdOptions by ID
        return lmsProdOptionsRepository.findById(popCode).orElseThrow(() ->
                new RuntimeException(getMessage("error.prodoption.notfound", new Object[]{popCode})));
    }

    /**
     * Helper method to retrieve messages from the message source.
     *
     * @param code the message code.
     * @param args the message arguments.
     * @return the localized message.
     */
    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, Locale.getDefault());
    }

    @Override
    public List<LmsProdOptions> findByProdCodeAndPopCode(BigDecimal prodCode, BigDecimal popCode) {
        return lmsProdOptionsRepository.findByProdCodeAndPopCode(prodCode, popCode);
    }

    @Override
    public List<ProdOptionCodeDescDTO> findPopCodeAndPopDescByPopProdCode(BigDecimal prodCode) {
        return lmsProdOptionsRepository.findPopCodeAndPopDescByPopProdCode(prodCode);
    }
}
