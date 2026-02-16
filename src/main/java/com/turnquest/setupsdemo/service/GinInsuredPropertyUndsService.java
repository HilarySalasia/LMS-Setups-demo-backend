package com.turnquest.setupsdemo.service;

// Service Interface
import com.turnquest.setupsdemo.model.GinInsuredPropertyUnds;

import java.util.List;
import java.util.Optional;

public interface GinInsuredPropertyUndsService {
    List<GinInsuredPropertyUnds> findAll();
    Optional<GinInsuredPropertyUnds> findById(Long id);
    GinInsuredPropertyUnds save(GinInsuredPropertyUnds ginInsuredPropertyUnds);
    void deleteById(Long id);

    Optional<GinInsuredPropertyUnds> getGinInsuredPropertyUndsByIpuCode(Long ipuCode);

    List<GinInsuredPropertyUnds> getRelatedRisks(Long ipuCode);
}