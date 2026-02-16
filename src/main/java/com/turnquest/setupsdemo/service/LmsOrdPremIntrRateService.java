package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.LmsOrdPremIntrRate;
import java.util.List;

public interface LmsOrdPremIntrRateService {
    List<LmsOrdPremIntrRate> findAll();
    LmsOrdPremIntrRate findById(Long id);
    LmsOrdPremIntrRate save(LmsOrdPremIntrRate rate);
    void deleteById(Long id);
}
