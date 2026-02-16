// Service Interface
package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.dto.ClaimCreationRequest;
import com.turnquest.setupsdemo.model.GinClaimMasterBookings;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GinClaimMasterBookingsService {
    List<GinClaimMasterBookings> findAll();
    Optional<GinClaimMasterBookings> findById(String id);
    GinClaimMasterBookings save(GinClaimMasterBookings ginClaimMasterBookings);
    void deleteById(String id);

    List<GinClaimMasterBookings> findAllByIpuCodeAndLossDateTimeAndPolBatchNo(Long ipuCode, LocalDate lossDateTime, Long polBatchNo);
    boolean existsByClaimNo(String claimNo);
    boolean existsByIpuCodeAndLossDateTime(Long ipuCode, LocalDate lossDateTime);

    String createRelatedClaim(Long ipuCode, LocalDate clmReportDate, String user);
    String generateClaimNumber(ClaimCreationRequest request);
}