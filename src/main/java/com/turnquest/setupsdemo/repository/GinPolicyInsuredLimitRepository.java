package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinPolicyInsuredLimits;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GinPolicyInsuredLimitRepository extends JpaRepository<GinPolicyInsuredLimits, Long> {
    List<GinPolicyInsuredLimits> findByPilIpuCodeAndPilSectCode(Long pilIpuCode, Long pilSectCode);
}
