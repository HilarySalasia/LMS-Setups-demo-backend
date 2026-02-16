package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.GinClaimMasterBookings;
import com.turnquest.setupsdemo.model.GinEvents;
import com.turnquest.setupsdemo.model.GinRiskRelations;
import com.turnquest.setupsdemo.repository.GinClaimMasterBookingsRepository;
import com.turnquest.setupsdemo.repository.GinEventsRepository;
import com.turnquest.setupsdemo.repository.GinInsuredPropertyUndsRepository;
import com.turnquest.setupsdemo.repository.GinRiskRelationsRepository;
import com.turnquest.setupsdemo.service.PrcMapGroupedrsksPrcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PrcMapGroupedrsksPrcServiceImpl implements PrcMapGroupedrsksPrcService {

    private final GinClaimMasterBookingsRepository ginClaimMasterBookingsRepository;
    private final GinInsuredPropertyUndsRepository ginInsuredPropertyUndsRepository;
    private final GinRiskRelationsRepository ginRiskRelationsRepository;
    private final GinEventsRepository ginEventsRepository;

    public PrcMapGroupedrsksPrcServiceImpl(GinClaimMasterBookingsRepository ginClaimMasterBookingsRepository,
                                           GinInsuredPropertyUndsRepository ginInsuredPropertyUndsRepository,
                                           GinRiskRelationsRepository ginRiskRelationsRepository,
                                           GinEventsRepository ginEventsRepository) {
        this.ginClaimMasterBookingsRepository = ginClaimMasterBookingsRepository;
        this.ginInsuredPropertyUndsRepository = ginInsuredPropertyUndsRepository;
        this.ginRiskRelationsRepository = ginRiskRelationsRepository;
        this.ginEventsRepository = ginEventsRepository;
    }

    public void prcMapGroupedrsksPrc(String vLossDate, BigDecimal vRelrCode, BigDecimal vIpuCode, String vCmbClaimNo) {
        // Convert the input string to LocalDate using the specified format
        LocalDate lossDate = LocalDate.parse(vLossDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // Find existing event code and short description
        Optional<GinEvents> existingEvent = findExistingEvent(lossDate, vCmbClaimNo, vIpuCode, vRelrCode);

        // If no existing event found, create a new one
        if (existingEvent.isEmpty()) {
            // Generate a new event code
            BigDecimal eveCode = generateNewEveCode();

            // Fetch the short description and description for the related risk
            GinRiskRelations relr = getRiskRelations(vRelrCode);
            String eveShtDesc = relr.getRelrShtDesc();
            String eveDesc = relr.getRelrDesc();

            // Create and save the new event
            GinEvents newEvent = new GinEvents();
            newEvent.setEveCode(eveCode.longValue());
            newEvent.setEveShtDesc(eveShtDesc);
            newEvent.setEveDate(Timestamp.valueOf(LocalDate.now().atStartOfDay()));
            newEvent.setEveDesc(eveDesc);
            newEvent.setEveWef(Timestamp.valueOf(lossDate.atStartOfDay()));
            newEvent.setEveType("E");
            newEvent.setEveRelrCode(vRelrCode.longValue());
            newEvent.setEveWet(Timestamp.valueOf(lossDate.atStartOfDay()));
            ginEventsRepository.save(newEvent);

            // Update existing claims with the new event code and short description
            updateClaims(vRelrCode, lossDate, eveCode, eveShtDesc);
        }
    }

    private Optional<GinEvents> findExistingEvent(
            LocalDate lossDate,
            String vCmbClaimNo,
            BigDecimal vIpuCode,
            BigDecimal vRelrCode) {
        return ginEventsRepository.findByEveDateAndEveRelrCodeAndEveWef(
                Date.valueOf(Timestamp.valueOf(lossDate.atStartOfDay()).toString()),
                vRelrCode,
                Date.valueOf(Timestamp.valueOf(lossDate.atStartOfDay()).toString()));
    }

    private BigDecimal generateNewEveCode() {
        return BigDecimal.valueOf(ginEventsRepository.findMaxEveCode() + 1);
    }

    private GinRiskRelations getRiskRelations(BigDecimal vRelrCode) {
        return ginRiskRelationsRepository.findById(vRelrCode.longValue())
        .orElseThrow(() -> new RuntimeException("Error getting grouped risk...."));
    }

    private void updateClaims(BigDecimal vRelrCode, LocalDate lossDate, BigDecimal eveCode, String eveShtDesc) {
        List<GinClaimMasterBookings> claimsToUpdate = ginClaimMasterBookingsRepository.findByCmbIpuCodeAndCmbLossDateTime(
                vRelrCode.longValue(),
                LocalDate.parse(Timestamp.valueOf(lossDate.atStartOfDay()).toString()));
        claimsToUpdate.forEach(claim -> {
            claim.setCmbEveCode(eveCode.longValue());
            claim.setCmbEveShtDesc(eveShtDesc);
            ginClaimMasterBookingsRepository.save(claim);
        });
    }
}
