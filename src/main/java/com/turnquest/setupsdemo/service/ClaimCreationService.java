package com.turnquest.setupsdemo.service;


import com.turnquest.setupsdemo.dto.ClaimCreationRequest;
import com.turnquest.setupsdemo.dto.ClaimCreationResponse;

public interface ClaimCreationService {

    ClaimCreationResponse createNewClaim(ClaimCreationRequest request);
}