package com.turnquest.setupsdemo.service;


import com.turnquest.setupsdemo.model.LmsProdOptAnnPayout;

import java.util.List;

/**
 * Service interface for managing LMS Prod Opt Ann Payout.
 */
public interface LmsProdOptAnnPayoutService {

    List<LmsProdOptAnnPayout> findAll();

    LmsProdOptAnnPayout findById(Long id);

    LmsProdOptAnnPayout save(LmsProdOptAnnPayout lmsProdOptAnnPayout);

    void deleteById(Long id);

    void insertOrUpdateAnnPayout(LmsProdOptAnnPayout lmsProdOptAnnPayout);

    List<LmsProdOptAnnPayout> findLmsProdOptAnnPayoutByLmsProdOptions_PopCode(Long popCode);
}