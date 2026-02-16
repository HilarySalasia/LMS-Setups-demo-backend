package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.LmsMortalityRates;
import java.util.List;

public interface LmsMortalityRatesService {
    List<LmsMortalityRates> findAll();
    LmsMortalityRates findById(Long id);
    LmsMortalityRates save(LmsMortalityRates rates);
    void deleteById(Long id);
}
