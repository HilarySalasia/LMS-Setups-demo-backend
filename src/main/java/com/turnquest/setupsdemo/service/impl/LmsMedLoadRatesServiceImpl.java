package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.LmsMedLoadRates;
import com.turnquest.setupsdemo.repository.LmsMedLoadRatesRepository;
import com.turnquest.setupsdemo.service.LmsMedLoadRatesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LmsMedLoadRatesServiceImpl implements LmsMedLoadRatesService {

    private final LmsMedLoadRatesRepository repository;

    public LmsMedLoadRatesServiceImpl(LmsMedLoadRatesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LmsMedLoadRates> findAll() {
        return repository.findAll();
    }

    @Override
    public LmsMedLoadRates findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public LmsMedLoadRates save(LmsMedLoadRates rates) {
        return repository.save(rates);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
