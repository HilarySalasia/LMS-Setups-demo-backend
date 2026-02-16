package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.GinClaimCoinsurers;
import com.turnquest.setupsdemo.model.GinCoinsurers;
import com.turnquest.setupsdemo.model.compositeKeys.GinCoinsurersId;
import com.turnquest.setupsdemo.repository.GinCoinsurersRepository;
import com.turnquest.setupsdemo.service.GinCoinsurersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GinCoinsurersServiceImpl implements GinCoinsurersService {

    @Autowired
    private GinCoinsurersRepository ginCoinsurersRepository;

    @Override
    public List<GinCoinsurers> findAll() {
        return ginCoinsurersRepository.findAll();
    }

    @Override
    public Optional<GinCoinsurers> findById(GinCoinsurersId id) {
        return ginCoinsurersRepository.findById(id);
    }

    @Override
    public GinCoinsurers save(GinCoinsurers ginCoinsurers) {
        return ginCoinsurersRepository.save(ginCoinsurers);
    }

    @Override
    public GinCoinsurers update(GinCoinsurers ginCoinsurers) {
        Optional<GinCoinsurers> existing = ginCoinsurersRepository.findById(ginCoinsurers.getId());
        if (existing.isPresent()) {
            return ginCoinsurersRepository.save(ginCoinsurers);
        } else {
            throw new RuntimeException("GinCoinsurer not found");
        }
    }

    @Override
    public void deleteById(GinCoinsurersId id) {
        ginCoinsurersRepository.deleteById(id);
    }

    public List<GinClaimCoinsurers> getClaimCoinsurers(Long polBatchNo) {
        List<GinClaimCoinsurers> coinsurers = new ArrayList<>();
        // Implement logic using JPA or other data access methods to retrieve coinsurers
        // Example using JPA:
        List<GinCoinsurers> dbCoinsurers = ginCoinsurersRepository.findAllByIdCoinPolBatchNo(polBatchNo);
        dbCoinsurers.forEach(dbCoinsurer -> {
            GinClaimCoinsurers claimCoinsurer = new GinClaimCoinsurers();
            claimCoinsurer.setAgntAgentCode(dbCoinsurer.getId().getCoinAgntAgentCode());
            claimCoinsurer.setAgntShtDesc(dbCoinsurer.getCoinAgntShtDesc());
            claimCoinsurer.setGlCode(Long.parseLong(dbCoinsurer.getCoinGlCode()));
            claimCoinsurer.setLead(dbCoinsurer.getCoinLead());
            claimCoinsurer.setPerct(dbCoinsurer.getCoinPerct());
            coinsurers.add(claimCoinsurer);
        });
        return coinsurers;
    }
}
