package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.GinRiskRelations;

import java.util.List;
import java.util.Optional;

public interface GinRiskRelationsService {
    List<GinRiskRelations> findAll();
    Optional<GinRiskRelations> findById(Long id);
    GinRiskRelations save(GinRiskRelations ginRiskRelations);
    void deleteById(Long id);
}