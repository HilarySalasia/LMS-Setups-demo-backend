package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.dto.DependantDisplayDTO;
import com.turnquest.setupsdemo.model.LmsProdCvtDependants;

import java.util.List;

public interface LmsProdCvtDependantsService {
    List<LmsProdCvtDependants> getAllDependants();
    LmsProdCvtDependants getDependantById(Long id);
    LmsProdCvtDependants saveDependant(LmsProdCvtDependants dependant);
    void deleteDependant(Long id);

    List<DependantDisplayDTO> findDependantDisplay(Long vPctCode, Long vPcdCode);
}
