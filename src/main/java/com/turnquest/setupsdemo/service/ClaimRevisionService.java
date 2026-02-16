package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.dto.ClaimRevisionRequest;
import com.turnquest.setupsdemo.dto.ClaimRevisionResponse;

public interface ClaimRevisionService {
    ClaimRevisionResponse createClaimRevision(ClaimRevisionRequest request);
}
