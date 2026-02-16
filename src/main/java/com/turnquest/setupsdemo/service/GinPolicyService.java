package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.GinPolicies;

import java.util.List;
import java.util.Optional;

public interface GinPolicyService {

    List<GinPolicies> findAll();
    Optional<GinPolicies> findById(Long id);
    GinPolicies save(GinPolicies policy);
    void deleteById(Long id);

    String getPolPolicyNo(Long ipuCode, Long polBatchNo);
    GinPolicies getPolicyData(Long ipuCode, Long polBatchNo);
}
