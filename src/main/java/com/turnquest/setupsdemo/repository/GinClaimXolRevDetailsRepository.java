package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinClaimXolRevDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GinClaimXolRevDetailsRepository extends JpaRepository<GinClaimXolRevDetails, Long> {
}
