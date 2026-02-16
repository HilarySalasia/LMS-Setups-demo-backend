package com.turnquest.setupsdemo.service.impl;

// Service Implementation
import com.turnquest.setupsdemo.model.GinInsuredPropertyUnds;
import com.turnquest.setupsdemo.repository.GinInsuredPropertyUndsRepository;
import com.turnquest.setupsdemo.service.GinInsuredPropertyUndsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GinInsuredPropertyUndsServiceImpl implements GinInsuredPropertyUndsService {

    @Autowired
    private GinInsuredPropertyUndsRepository ginInsuredPropertyUndsRepository;

    @Override
    public List<GinInsuredPropertyUnds> findAll() {
        return ginInsuredPropertyUndsRepository.findAll();
    }

    @Override
    public Optional<GinInsuredPropertyUnds> findById(Long id) {
        return ginInsuredPropertyUndsRepository.findById(id);
    }

    @Override
    public GinInsuredPropertyUnds save(GinInsuredPropertyUnds ginInsuredPropertyUnds) {
        return ginInsuredPropertyUndsRepository.save(ginInsuredPropertyUnds);
    }

    @Override
    public void deleteById(Long id) {
        ginInsuredPropertyUndsRepository.deleteById(id);
    }

    @Override
    public Optional<GinInsuredPropertyUnds> getGinInsuredPropertyUndsByIpuCode(Long ipuCode) {
        return ginInsuredPropertyUndsRepository.getGinInsuredPropertyUndsByIpuCode(ipuCode);
    }

    public List<GinInsuredPropertyUnds> getRelatedRisks(Long ipuCode) {
        List<GinInsuredPropertyUnds> relatedRisks = new ArrayList<>();
        // Implement logic using JPA or other data access methods to retrieve related risks
        // Example using JPA:
        List<GinInsuredPropertyUnds> dbRelatedRisks = ginInsuredPropertyUndsRepository.findAllByIpuRelrCode(
                ginInsuredPropertyUndsRepository.findById(ipuCode).get().getIpuRelrCode());
        dbRelatedRisks.forEach(relatedRisk -> {
            // Make sure it's not the original risk
            if (!relatedRisk.getIpuCode().equals(ipuCode)) {
                relatedRisks.add(relatedRisk);
            }
        });
        return relatedRisks;
    }
}
