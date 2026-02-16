// Repository Interface
package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinPolicyCerts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GinPolicyCertsRepository extends JpaRepository<GinPolicyCerts, Long> {
    Optional<GinPolicyCerts> findByPolcIpuCodeAndPolcStatus(Long polcIpuCode, String polcStatus);
}