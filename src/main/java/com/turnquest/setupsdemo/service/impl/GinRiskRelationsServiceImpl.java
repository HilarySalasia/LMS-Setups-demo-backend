package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.GinRiskRelations;
import com.turnquest.setupsdemo.repository.GinRiskRelationsRepository;
import com.turnquest.setupsdemo.service.GinRiskRelationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GinRiskRelationsServiceImpl implements GinRiskRelationsService {

    @Autowired
    private GinRiskRelationsRepository ginRiskRelationsRepository;

    @Override
    public List<GinRiskRelations> findAll() {
        return ginRiskRelationsRepository.findAll();
    }

    @Override
    public Optional<GinRiskRelations> findById(Long id) {
        return ginRiskRelationsRepository.findById(id);
    }

    @Override
    public GinRiskRelations save(GinRiskRelations ginRiskRelations) {
        return ginRiskRelationsRepository.save(ginRiskRelations);
    }

    @Override
    public void deleteById(Long id) {
        ginRiskRelationsRepository.deleteById(id);
    }
}