package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.GinClaimCoinsurers;
import com.turnquest.setupsdemo.model.GinCoinsurers;
import com.turnquest.setupsdemo.model.compositeKeys.GinCoinsurersId;

import java.util.List;
import java.util.Optional;

public interface GinCoinsurersService {

    List<GinCoinsurers> findAll();

    Optional<GinCoinsurers> findById(GinCoinsurersId id);

    GinCoinsurers save(GinCoinsurers ginCoinsurers);

    GinCoinsurers update(GinCoinsurers ginCoinsurers);

    void deleteById(GinCoinsurersId id);

    List<GinClaimCoinsurers> getClaimCoinsurers(Long polBatchNo);
}
