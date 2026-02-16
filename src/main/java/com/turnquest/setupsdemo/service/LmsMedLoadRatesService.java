package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.LmsMedLoadRates;
import java.util.List;

public interface LmsMedLoadRatesService {
    List<LmsMedLoadRates> findAll();
    LmsMedLoadRates findById(Long id);
    LmsMedLoadRates save(LmsMedLoadRates rates);
    void deleteById(Long id);
}
