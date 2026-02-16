package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.LmsDependentType;

import java.math.BigDecimal;
import java.util.List;

public interface LmsDependentTypeService {
    List<LmsDependentType> getAllDependentTypes();
    LmsDependentType getDependentTypeById(BigDecimal id);
    LmsDependentType saveDependentType(LmsDependentType dependentType);
    void deleteDependentType(BigDecimal id);
}