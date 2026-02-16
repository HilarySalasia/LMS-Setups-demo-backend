package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.LmsProdCoverTypes;
import com.turnquest.setupsdemo.repository.LmsProdCoverTypesRepository;
import com.turnquest.setupsdemo.service.LmsProdCoverTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LmsProdCoverTypesServiceImpl implements LmsProdCoverTypesService {

    private final LmsProdCoverTypesRepository repository;

    @Autowired
    public LmsProdCoverTypesServiceImpl(LmsProdCoverTypesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LmsProdCoverTypes> findAll() {
        return repository.findAll();
    }

    @Override
    public LmsProdCoverTypes findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public LmsProdCoverTypes save(LmsProdCoverTypes coverType) {
        return repository.save(coverType);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}