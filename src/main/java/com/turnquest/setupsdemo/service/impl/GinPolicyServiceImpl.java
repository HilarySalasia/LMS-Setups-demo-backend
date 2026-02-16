package com.turnquest.setupsdemo.service.impl;

// Service Implementation
import com.turnquest.setupsdemo.model.GinPolicies;
import com.turnquest.setupsdemo.repository.GinPolicyRepository;
import com.turnquest.setupsdemo.service.GinPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GinPolicyServiceImpl implements GinPolicyService {

    private final GinPolicyRepository policyRepository;

    public GinPolicyServiceImpl(GinPolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @Override
    public List<GinPolicies> findAll() {
        return policyRepository.findAll();
    }

    @Override
    public Optional<GinPolicies> findById(Long id) {
        return policyRepository.findById(id);
    }

    @Override
    public GinPolicies save(GinPolicies policy) {
        return policyRepository.save(policy);
    }

    @Override
    public void deleteById(Long id) {
        policyRepository.deleteById(id);
    }

    public String getPolPolicyNo(Long ipuCode, Long polBatchNo) {
        // Implement logic to retrieve polPolicyNo from external sources
        // Example using JPA:
        Optional<GinPolicies> policy = policyRepository.findByIpuCodeAndPolBatchNo(ipuCode, polBatchNo);
        if (policy.isPresent()) {
            return policy.get().getPolPolicyNo();
        } else {
            return null; // Or throw an exception if policy not found
        }
    }

    public GinPolicies getPolicyData(Long ipuCode, Long polBatchNo) {
        // Implement logic to retrieve polPolicyNo from external sources
        // Example using JPA:
        Optional<GinPolicies> policy = policyRepository.findByIpuCodeAndPolBatchNo(ipuCode, polBatchNo);
        // Or throw an exception if policy not found
        return policy.orElse(null);
    }
}
