// Service Interface
package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.GinPolicyCerts;

import java.util.List;
import java.util.Optional;

public interface GinPolicyCertsService {
    List<GinPolicyCerts> findAll();
    Optional<GinPolicyCerts> findById(Long id);
    GinPolicyCerts save(GinPolicyCerts ginPolicyCerts);
    void deleteById(Long id);

    Optional<GinPolicyCerts> findByPolcIpuCodeAndPolcStatus(Long polcIpuCode, String polcStatus);
}