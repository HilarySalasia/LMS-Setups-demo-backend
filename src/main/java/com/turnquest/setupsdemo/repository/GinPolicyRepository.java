package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinPolicies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GinPolicyRepository extends JpaRepository<GinPolicies, Long> {

    Optional<GinPolicies> findByIpuCodeAndPolBatchNo(Long ipuCode, Long polBatchNo);
}
