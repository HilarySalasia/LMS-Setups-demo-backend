// Service Implementation
package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.GinPolicySbuDtls;
import com.turnquest.setupsdemo.repository.GinPolicySbuDtlsRepository;
import com.turnquest.setupsdemo.service.GinPolicySbuDtlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GinPolicySbuDtlsServiceImpl implements GinPolicySbuDtlsService {

    @Autowired
    private GinPolicySbuDtlsRepository ginPolicySbuDtlsRepository;

    @Override
    public List<GinPolicySbuDtls> findAll() {
        return ginPolicySbuDtlsRepository.findAll();
    }

    @Override
    public Optional<GinPolicySbuDtls> findById(Long id) {
        return ginPolicySbuDtlsRepository.findById(id);
    }

    @Override
    public GinPolicySbuDtls save(GinPolicySbuDtls ginPolicySbuDtls) {
        return ginPolicySbuDtlsRepository.save(ginPolicySbuDtls);
    }

    @Override
    public void deleteById(Long id) {
        ginPolicySbuDtlsRepository.deleteById(id);
    }

    public Long getUnitCode(Long ipuCode, Long polBatchNo) {
        // Implement logic to retrieve unitCode from external sources
        // Example using JPA:
        Optional<GinPolicySbuDtls> sbuDetails = ginPolicySbuDtlsRepository.findByPdlPolBatchNo(polBatchNo);
        // Or throw an exception if SBU details not found
        return sbuDetails.map(GinPolicySbuDtls::getPdlUnitCode).orElse(null);
    }

    public GinPolicySbuDtls getPolicySbuDetails(Long ipuCode, Long polBatchNo) {
        // Implement logic to retrieve unitCode from external sources
        // Example using JPA:
        GinPolicySbuDtls sbuDetails = ginPolicySbuDtlsRepository.findByPdlPolBatchNo(polBatchNo).orElse(null);
        // Or throw an exception if SBU details not found
        return sbuDetails;
    }
}