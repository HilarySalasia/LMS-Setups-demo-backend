package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.LmsMortalityRates;
import com.turnquest.setupsdemo.repository.LmsMortalityRatesRepository;
import com.turnquest.setupsdemo.service.LmsMortalityRatesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LmsMortalityRatesServiceImpl implements LmsMortalityRatesService {

    private final LmsMortalityRatesRepository repository;

    public LmsMortalityRatesServiceImpl(LmsMortalityRatesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LmsMortalityRates> findAll() {
        return repository.findAll();
    }

    @Override
    public LmsMortalityRates findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public LmsMortalityRates save(LmsMortalityRates rates) {
        return repository.save(rates);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
