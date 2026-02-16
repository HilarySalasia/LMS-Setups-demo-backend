package com.turnquest.setupsdemo.repository;


import com.turnquest.setupsdemo.model.LmsProdOptAnnPayout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LmsProdOptAnnPayoutRepository extends JpaRepository<LmsProdOptAnnPayout, Long> {
    // Add custom query methods if needed

    List<LmsProdOptAnnPayout> findLmsProdOptAnnPayoutByLmsProdOptions_PopCode(Long popCode);
}

