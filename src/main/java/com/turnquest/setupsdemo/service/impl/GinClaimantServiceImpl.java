package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.ClaimantResponse;
import com.turnquest.setupsdemo.exception.ResourceNotFoundException;
import com.turnquest.setupsdemo.model.GinClaimMasterBookings;
import com.turnquest.setupsdemo.model.GinRgstdClaimants;
import com.turnquest.setupsdemo.repository.GinClaimMasterBookingsRepository;
import com.turnquest.setupsdemo.repository.GinRgstdClaimantsRepository;
import com.turnquest.setupsdemo.service.GinClaimantService;
import com.turnquest.setupsdemo.service.SqlSequence;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GinClaimantServiceImpl implements GinClaimantService {


    private final GinClaimMasterBookingsRepository claimBookingRepository;
    private final GinRgstdClaimantsRepository ginRgstdClaimantsRepository;
    private final SqlSequence sqlSequence;

    @Transactional
    public ClaimantResponse handleClaimant(
            String vClaimNo,
            String vPaymode,
            String vCommmode,
            String vClmntLiabAdm,
            String vThirdParty,
            Long vPerilEstmate,
            Long vCldCodeVal,
            Long vIpuPrpCode
    ) {

        ClaimantResponse response = new ClaimantResponse();

        if ("S".equals(vThirdParty)) {
            response.setRegClmtCode(createSelfAsClaimant(
                    vClaimNo,
                    vPerilEstmate,
                    vCldCodeVal,
                    vPaymode,
                    vCommmode,
                    vClmntLiabAdm
            ));
            response.setCldCode(vIpuPrpCode);
        } else if ("T".equals(vThirdParty)) {
            if (vCldCodeVal == null) {
                throw new IllegalArgumentException("Third Party claimant not specified..");
            }

            Optional<GinRgstdClaimants> existingClaimant = ginRgstdClaimantsRepository.findByRegCmbClaimNoAndRegCldCode(
                    vClaimNo, BigDecimal.valueOf(vCldCodeVal));

            if (existingClaimant.isPresent()) {
                response.setRegClmtCode(existingClaimant.get().getRegClmtCode().longValue());
            } else {
                // Generate new reg_clmt_code
                Long regClmtCode = sqlSequence.generateRegClmtCode();
                response.setRegClmtCode(regClmtCode);

                // Generate new div_no
                String divNo = sqlSequence.generateDivNo();

                GinRgstdClaimants newClaimant = new GinRgstdClaimants();
                newClaimant.setRegClmntDate(new Date(
                        System.currentTimeMillis())
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate());
                newClaimant.setRegCmbClaimNo(vClaimNo);
                newClaimant.setRegCldCode(BigDecimal.valueOf(vCldCodeVal));
                newClaimant.setRegClmtCode(BigDecimal.valueOf(regClmtCode));
                newClaimant.setRegClaimStatus("1");
                newClaimant.setRegThirdParty("T");
                newClaimant.setRegPaymentMode(vPaymode);
                newClaimant.setRegCommCode(vCommmode);
                newClaimant.setRegAdmitLiabDate(new
                        Date(System.currentTimeMillis())
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate());
                newClaimant.setRegAdmitLiability(vClmntLiabAdm);

                ginRgstdClaimantsRepository.save(newClaimant);
            }
        }

        return response;
    }

    private Long createSelfAsClaimant(
            String vClaimNo,
            Long vClmedAmnt,
            Long vClntCode,
            String vPaymode,
            String vCommmode,
            String vLiabAdmission
    ) {
        Optional<GinClaimMasterBookings> claimBooking = claimBookingRepository.findById(vClaimNo);
        if (claimBooking.isPresent()) {
            Long prpCode = claimBooking.get().getCmbPrpCode();
            return createClaimant(vClaimNo, vClmedAmnt, prpCode, vPaymode, vCommmode,
                    vLiabAdmission);
        } else {
            throw new ResourceNotFoundException("Claim not found");
        }
    }

    private Long createClaimant(
            String vClaimNo,
            Long vClmedAmnt,
            Long vClntCode,
            String vPaymode,
            String vCommmode,
            String vLiabAdmission
    ) {
        Optional<GinRgstdClaimants> existingClaimant = ginRgstdClaimantsRepository
                .findByRegCmbClaimNoAndRegThirdPartyAndRegCldCode(
                        vClaimNo,
                        "S",
                        BigDecimal.valueOf(vClntCode));

        if (existingClaimant.isPresent()) {
            // Update existing claimant
            existingClaimant.get().setRegCldCode(BigDecimal.valueOf(vClntCode));
            ginRgstdClaimantsRepository.save(existingClaimant.get());
            return existingClaimant.get().getRegClmtCode().longValue();
        } else {
            // Generate new reg_clmt_code
            Long regClmtCode = sqlSequence.generateRegClmtCode();

            GinRgstdClaimants newClaimant = new GinRgstdClaimants();
            newClaimant.setRegClmntDate(new Date(
                    System.currentTimeMillis())
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
            newClaimant.setRegClmntAmount(BigDecimal.valueOf(vClmedAmnt));
            newClaimant.setRegCmbClaimNo(vClaimNo);
            newClaimant.setRegCldCode(BigDecimal.valueOf(vClntCode));
            newClaimant.setRegClmtCode(BigDecimal.valueOf(regClmtCode));
            newClaimant.setRegClaimStatus("1");
            newClaimant.setRegThirdParty("S");
            newClaimant.setRegPaymentMode(vPaymode);
            newClaimant.setRegCommCode(vCommmode);
            newClaimant.setRegAdmitLiabDate(null);
            newClaimant.setRegAdmitLiability(vLiabAdmission);
            newClaimant.setRegLiabilityAdmitCondtional("N");

            ginRgstdClaimantsRepository.save(newClaimant);

            return regClmtCode;
        }
    }
    }
