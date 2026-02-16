package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.LmsOrdPremIntrRate;
import com.turnquest.setupsdemo.repository.LmsOrdPremIntrRateRepository;
import com.turnquest.setupsdemo.service.LmsOrdPremIntrRateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LmsOrdPremIntrRateServiceImpl implements LmsOrdPremIntrRateService {

    private final LmsOrdPremIntrRateRepository repository;

    public LmsOrdPremIntrRateServiceImpl(LmsOrdPremIntrRateRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LmsOrdPremIntrRate> findAll() {
        return repository.findAll();
    }

    @Override
    public LmsOrdPremIntrRate findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public LmsOrdPremIntrRate save(LmsOrdPremIntrRate rate) {
        return repository.save(rate);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
