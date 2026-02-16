package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinPolRiskSectionPeril;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GinPolicyRiskSectionPerilsRepository extends JpaRepository<GinPolRiskSectionPeril, Long> {
    // Add custom query methods as needed
}