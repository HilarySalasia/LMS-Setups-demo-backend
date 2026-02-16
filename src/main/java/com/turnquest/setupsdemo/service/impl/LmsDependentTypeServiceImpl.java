package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.LmsDependentType;
import com.turnquest.setupsdemo.repository.LmsDependentTypeRepository;
import com.turnquest.setupsdemo.service.LmsDependentTypeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LmsDependentTypeServiceImpl implements LmsDependentTypeService {

    private final LmsDependentTypeRepository repository;

    public LmsDependentTypeServiceImpl(LmsDependentTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LmsDependentType> getAllDependentTypes() {
        return repository.findAll();
    }

    @Override
    public LmsDependentType getDependentTypeById(BigDecimal id) {
        return repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Dependent type not found"));
    }

    @Override
    public LmsDependentType saveDependentType(LmsDependentType dependentType) {
        return repository.save(dependentType);
    }

    @Override
    public void deleteDependentType(BigDecimal id) {
        repository.deleteById(id);
    }
}