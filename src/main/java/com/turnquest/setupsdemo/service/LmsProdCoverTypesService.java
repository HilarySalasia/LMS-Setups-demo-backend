package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.LmsProdCoverTypes;
import java.util.List;

public interface LmsProdCoverTypesService {
    List<LmsProdCoverTypes> findAll();
    LmsProdCoverTypes findById(Long id);
    LmsProdCoverTypes save(LmsProdCoverTypes coverType);
    void deleteById(Long id);
}