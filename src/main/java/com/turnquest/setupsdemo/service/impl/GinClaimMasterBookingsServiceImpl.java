// Service Implementation
package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.ClaimCreationRequest;
import com.turnquest.setupsdemo.model.GinClaimMasterBookings;
import com.turnquest.setupsdemo.repository.GinClaimMasterBookingsRepository;
import com.turnquest.setupsdemo.service.GinClaimMasterBookingsService;
import com.turnquest.setupsdemo.service.SqlSequence;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class GinClaimMasterBookingsServiceImpl implements GinClaimMasterBookingsService {

    private final GinClaimMasterBookingsRepository ginClaimMasterBookingsRepository;
    private final SqlSequence sqlSequence;

    public GinClaimMasterBookingsServiceImpl(GinClaimMasterBookingsRepository ginClaimMasterBookingsRepository,
                                             SqlSequence sqlSequence) {
        this.ginClaimMasterBookingsRepository = ginClaimMasterBookingsRepository;
        this.sqlSequence = sqlSequence;
    }

    @Override
    public List<GinClaimMasterBookings> findAll() {
        return ginClaimMasterBookingsRepository.findAll();
    }

    @Override
    public Optional<GinClaimMasterBookings> findById(String id) {
        return ginClaimMasterBookingsRepository.findById(id);
    }

    @Override
    public GinClaimMasterBookings save(GinClaimMasterBookings ginClaimMasterBookings) {
        return ginClaimMasterBookingsRepository.save(ginClaimMasterBookings);
    }

    @Override
    public void deleteById(String id) {
        ginClaimMasterBookingsRepository.deleteById(id);
    }


    @Override
    public List<GinClaimMasterBookings> findAllByIpuCodeAndLossDateTimeAndPolBatchNo(Long ipuCode, LocalDate lossDateTime, Long polBatchNo) {
        return ginClaimMasterBookingsRepository.findAllByIpuCodeAndLossDateTimeAndPolBatchNo(ipuCode, lossDateTime, polBatchNo);
    }

    @Override
    public boolean existsByClaimNo(String claimNo) {
        return ginClaimMasterBookingsRepository.existsByClaimNo(claimNo);
    }

    @Override
    public boolean existsByIpuCodeAndLossDateTime(Long ipuCode, LocalDate lossDateTime) {
        return ginClaimMasterBookingsRepository.existsByIpuCodeAndLossDateTime(ipuCode, lossDateTime);
    }

    public String createRelatedClaim(Long ipuCode, LocalDate clmReportDate, String user) {
        // 1. Create a new claim record for the related risk
        // ... (Implement logic for generating a new claim number) ...
        String relatedClaimNumber = generateClaimNumberUsingIpuCode(ipuCode, clmReportDate, user); // Example, you might need to update this

        // 2. Create a new GinClaimMasterBookings object
        GinClaimMasterBookings relatedClaim = new GinClaimMasterBookings();
        relatedClaim.setCmbClaimNo(relatedClaimNumber);
        relatedClaim.setCmbClaimDate(Date.valueOf(LocalDate.now()));
        relatedClaim.setCmbLossDateTime(Date.valueOf(clmReportDate));
        relatedClaim.setCmbIpuCode(ipuCode);
        // ... (Set other relevant fields based on the related risk) ...

        // 3. Save the claim record to the database
        ginClaimMasterBookingsRepository.save(relatedClaim);

        // 4. Return the newly generated claim number
        return relatedClaimNumber;
    }

    private String generateClaimNumberUsingIpuCode(Long ipuCode, LocalDate clmReportDate, String user) {
        // Implement logic for generating a unique claim number for the related risk
        // You might need to consider:
        //  - Using a sequence or other mechanism for generating unique IDs
        //  - Including relevant information in the claim number (e.g., ipuCode, year)
        //  - Checking for duplicates to ensure uniqueness

        long nextSequenceValue = sqlSequence.getNextClaimNumberSequenceValue();

        // Example (replace with your actual claim number generation logic):
        return String.format("C%06d%04d%s", nextSequenceValue, clmReportDate.getYear(), "REL");
    }

    public String generateClaimNumber(ClaimCreationRequest request) {
        // 1. Get the current year
        int currentYear = LocalDate.now().getYear();

        // 2. Get the next sequence value for the claim number
        long nextSequenceValue = sqlSequence.getNextClaimNumberSequenceValue();

        // 3. Format the claim number using the year, sequence value, and other relevant data
        String claimNumber = String.format("C%06d%04d%s", nextSequenceValue, currentYear, request.getSerialNo());

        // ... (Optional duplicate check) ...



        // 4. Check if the generated claim number already exists (optional)
        if (ginClaimMasterBookingsRepository.existsByClaimNo(claimNumber)) {
            // If it exists, regenerate the claim number
            claimNumber = generateClaimNumber(request); // Recursive call
        }

        // 5. Return the generated claim number
        return claimNumber;
    }
}