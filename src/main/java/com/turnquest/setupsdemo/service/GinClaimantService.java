package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.dto.ClaimantResponse;

public interface GinClaimantService {
    public ClaimantResponse handleClaimant(
            String vClaimNo,
            String vPaymode,
            String vCommmode,
            String vClmntLiabAdm,
            String vThirdParty,
            Long vPerilEstmate,
            Long vCldCodeVal,
            Long vIpuPrpCode
    );
}
