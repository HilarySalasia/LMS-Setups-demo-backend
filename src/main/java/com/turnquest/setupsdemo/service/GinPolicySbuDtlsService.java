// Service Interface
package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.GinPolicySbuDtls;

import java.util.List;
import java.util.Optional;

public interface GinPolicySbuDtlsService {
    List<GinPolicySbuDtls> findAll();
    Optional<GinPolicySbuDtls> findById(Long id);
    GinPolicySbuDtls save(GinPolicySbuDtls ginPolicySbuDtls);
    void deleteById(Long id);

    Long getUnitCode(Long ipuCode, Long polBatchNo);

    GinPolicySbuDtls getPolicySbuDetails(Long ipuCode, Long polBatchNo);
}