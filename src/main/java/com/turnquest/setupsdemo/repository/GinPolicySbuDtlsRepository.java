// Repository Interface
package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinPolicySbuDtls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GinPolicySbuDtlsRepository extends JpaRepository<GinPolicySbuDtls, Long> {

    Optional<GinPolicySbuDtls> findByPdlPolBatchNo(Long polBatchNo);
}