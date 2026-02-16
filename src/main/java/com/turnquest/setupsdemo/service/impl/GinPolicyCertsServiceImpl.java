// Service Implementation
package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.GinPolicyCerts;
import com.turnquest.setupsdemo.repository.GinPolicyCertsRepository;
import com.turnquest.setupsdemo.service.GinPolicyCertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GinPolicyCertsServiceImpl implements GinPolicyCertsService {

    @Autowired
    private GinPolicyCertsRepository ginPolicyCertsRepository;

    @Override
    public List<GinPolicyCerts> findAll() {
        return ginPolicyCertsRepository.findAll();
    }

    @Override
    public Optional<GinPolicyCerts> findById(Long id) {
        return ginPolicyCertsRepository.findById(id);
    }

    @Override
    public GinPolicyCerts save(GinPolicyCerts ginPolicyCerts) {
        return ginPolicyCertsRepository.save(ginPolicyCerts);
    }

    @Override
    public void deleteById(Long id) {
        ginPolicyCertsRepository.deleteById(id);
    }

    @Override
    public Optional<GinPolicyCerts> findByPolcIpuCodeAndPolcStatus(Long polcIpuCode, String polcStatus) {
        return ginPolicyCertsRepository.findByPolcIpuCodeAndPolcStatus(polcIpuCode, polcStatus);
    }
}