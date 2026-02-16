package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.ClaimRevisionRequest;
import com.turnquest.setupsdemo.dto.ClaimRevisionResponse;
import com.turnquest.setupsdemo.dto.PerilDtoII;
import com.turnquest.setupsdemo.dto.SclPerilsRecDto;
import com.turnquest.setupsdemo.exception.ResourceNotFoundException;
import com.turnquest.setupsdemo.model.*;
import com.turnquest.setupsdemo.repository.*;
import com.turnquest.setupsdemo.service.ClaimRevisionService;
import com.turnquest.setupsdemo.service.ExcessConditionService;
import com.turnquest.setupsdemo.service.RevisionService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClaimRevisionServiceImpl implements ClaimRevisionService {

    @PersistenceContext
    private EntityManager entityManager;
    private final GinClaimMasterBookingsRepository claimMasterBookingsRepository;
    private final GinProductRepository productRepository;
    private final GinClaimPerilsRepository claimPerilsRepository;
    private final GinRgstdClmtsDvRepository rgstdClmtsDvRepository;
    private final GinRgstdClmtsDvPerilsRepository rgstdClmtsDvPerilsRepository;
    private final GinClaimPerilExcessesTempRepository claimPerilExcessesTempRepository;
    private final GinClmPerilsTempRepository clmPerilsTempRepository;
    private final GinClaimPerilExcessesRepository claimPerilExcessesRepository;
    private final GinPerilsRepository perilsRepository;
    private final GinClaimRevisionsRepository claimRevisionRepository;
    private final RevisionService revisionService;
    // ... other dependencies ...

    public ClaimRevisionResponse createClaimRevision(ClaimRevisionRequest request) {
        ClaimRevisionResponse response = new ClaimRevisionResponse();

        // Input validation
        if (request.getPerilsTab().isEmpty()) {
            throw new IllegalArgumentException("Please provide the peril revisions breakdown..");
        }

        // Retrieve claim details
        Optional<GinClaimMasterBookings> claimBooking = claimMasterBookingsRepository.findById(request.getVClmno());
        if (claimBooking.isPresent()) {
            GinClaimMasterBookings cmb = claimBooking.get();

            Optional<GinProducts> product = productRepository.findById(BigDecimal.valueOf(cmb.getCmbProCode()));
            if (product.isPresent()) {
                GinProducts pro = product.get();

                // Calculate totals
                BigDecimal vRevAmt = BigDecimal.ZERO;
                BigDecimal vTotCoinAmt = BigDecimal.ZERO;

                // Process each peril
                for (SclPerilsRecDto perilDto : request.getPerilsTab()) {
                    // Check for DV status
                    if (!"A".equals(request.getVAddEdit())) {
                        Optional<GinRgstdClmtsDvPerils> rgcdp = rgstdClmtsDvPerilsRepository
                                .findByRgcdpClmpCode(perilDto.getClmpCode().longValue());
                        if (rgcdp.isPresent()) {
                            Optional<GinRgstdClmtsDv> rgcd = rgstdClmtsDvRepository
                                    .findById(rgcdp.get().getRgCdpRgcdCode().longValue());
                            if (rgcd.isPresent() && (rgcd.get().getRgCldDivStatus().equals(BigDecimal.TWO) ||
                                    rgcd.get().getRgCldDivStatus().equals(BigDecimal.valueOf(3)))) {
                                throw new IllegalArgumentException(
                                        "You cannot revise a peril with dv status as dispatched or accepted");
                            }
                        }
                    }

                    // Calculate coin and own peril amounts
                    BigDecimal vCoinPerilAmt = perilDto.getPerAmount();
                    BigDecimal vOwnPerilAmt;
                    if (!"F".equals(cmb.getCmbCoinPayType())) {
                        vOwnPerilAmt = perilDto.getPerAmount();
                    } else {
                        vOwnPerilAmt = vCoinPerilAmt.multiply(cmb.getCmbCoinsuranceShare())
                                .divide(new BigDecimal(100), BigDecimal.ROUND_HALF_UP);
                    }

                    vTotCoinAmt = vTotCoinAmt.add(vCoinPerilAmt);
                    vRevAmt = vRevAmt.add(vOwnPerilAmt);

                    // Update or insert claim perils
                    if ("E".equals(request.getVAddEdit())) {
                        // Update existing peril
                        claimPerilsRepository.updateClaimPeril(
                                perilDto.getClmpCode().longValue(),
                                vOwnPerilAmt,
                                vCoinPerilAmt,
                                perilDto.getSsprmCode()
                        );
                    } else if ("A".equals(request.getVAddEdit())) {
                        // Check if peril already exists
                        Optional<GinClaimPerils> existingPeril = claimPerilsRepository.findByClmpCmbClaimNoAndClmpPerPtCodeAndClmpRegClmtCode(
                                request.getVClmno(),
                                perilDto.getSpPerCode(),
                                perilDto.getClmpRegClmtCode().longValue()
                        );
                        if (existingPeril.isPresent()) {
                            throw new IllegalArgumentException("Error. The peril is already attached to the Claimant or Service Provider selected");
                        }

                        // Generate new clmp_code
                        Long vclmpCode = generateClmpCode();

                        // Retrieve main peril details
                        Optional<GinPerils> mainPeril = perilsRepository.findById(perilDto.getMainperilcode());
                        String vMainPerShtDesc = mainPeril.isPresent() ? mainPeril.get().getPerShtDesc() : perilDto.getSpPerShtDesc();

                        // Retrieve claim remark
                        Optional<GinClmPerilsTemp> clmpTemp = clmPerilsTempRepository.findByCptCode(perilDto.getCptCode().longValue());
                        String vClaimRmk = clmpTemp.map(GinClmPerilsTemp::getCptPerilRemarks).orElse(null);

                        // Insert new peril
                        GinClaimPerils newPeril = new GinClaimPerils();
                        newPeril.setClmpCmbClaimNo(request.getVClmno());
                        newPeril.setClmpPerPtCode(perilDto.getSpPerCode());
                        newPeril.setClmpPerPtShtDesc(perilDto.getSpPerShtDesc());
                        newPeril.setClmpType(perilDto.getSpSiOrLimit());
                        newPeril.setClmpLimitAmt(perilDto.getSpPerilLimit());
                        newPeril.setClmpExcessAmt(perilDto.getExcess());
                        newPeril.setClmpReserveAmt(vOwnPerilAmt);
                        newPeril.setClmpRemarks(request.getVRemarks());
                        newPeril.setClmpBy(request.getVUser());
                        newPeril.setClmpGgtTransNo(request.getVTransNo());
                        newPeril.setClmpTranType(request.getVTransType());
                        newPeril.setClmpPerDesc(perilDto.getPerDesc());
                        newPeril.setClmpTotalReserve(vCoinPerilAmt);
                        newPeril.setClmpPerilLvl(perilDto.getPerilLvl());
                        newPeril.setClmpPerilCode(perilDto.getPerilCode());
                        newPeril.setClmpDeprprdRate(perilDto.getSsPrDepreciationPct());
                        newPeril.setClmpOrigReserveAmt(vOwnPerilAmt.add(perilDto.getSpPerilLimit()));
                        newPeril.setClmpSsprmCode(perilDto.getSsprmCode());
                        newPeril.setClmpMultiRate(perilDto.getMultiplier());
                        newPeril.setClmpClaimant(perilDto.getClmpClaimant());
                        newPeril.setClmpRegClmtCode(perilDto.getClmpRegClmtCode().longValue());
                        newPeril.setClmpApcoCode(perilDto.getClmpApcoCode().longValue());
                        newPeril.setClmpRegCldCode(perilDto.getClmpRegCldCode().longValue());
                        newPeril.setClmpCode(vclmpCode);
                        newPeril.setClmpNoviceExcessAmt(perilDto.getClmpNoviceExcessAmt());
                        newPeril.setClmpLiabAdmission(perilDto.getClmpLiabAdmission());
                        newPeril.setClmpLiabDate(new Date(
                                perilDto.getClmpLiabDate()
                                        .atStartOfDay()
                                        .atZone(ZoneId.systemDefault())
                                        .toInstant().toString()));
                        newPeril.setClmpMainPerCode(perilDto.getMainperilcode());
                        newPeril.setClmpPerRate(perilDto.getPerilUwRate());
                        newPeril.setClmpMainPerDesc(perilDto.getPerilUwRate().toString());
                        newPeril.setClmpMainPerShtDesc(vMainPerShtDesc);
                        newPeril.setClmpClaimStatus("B");
                        newPeril.setClmpRmks(vClaimRmk);

                        claimPerilsRepository.save(newPeril);

                        // Insert excess details
                        List<GinClaimPerilExcessesTemp> excessTempList = claimPerilExcessesTempRepository
                                .findByCpetCptCode(perilDto.getCptCode().longValue());
                        for (GinClaimPerilExcessesTemp excessTemp : excessTempList) {
                            GinClaimPerilExcesses newExcess = new GinClaimPerilExcesses();
                            newExcess.setCpeCode(BigDecimal.valueOf(generateCpeCode()));
                            newExcess.setCpeClmpCode(BigDecimal.valueOf(vclmpCode));
                            newExcess.setCpeSsexCode(BigDecimal.valueOf(excessTemp.getCpetSsexCode()));
                            newExcess.setCpeExcessType(excessTemp.getCpetExcessType());
                            newExcess.setCpeExcessLimit(BigDecimal.valueOf(excessTemp.getCpetExcessLimit()));
                            newExcess.setCpeExcessRate(BigDecimal.valueOf(excessTemp.getCpetExcessRate()));

                            claimPerilExcessesRepository.save(newExcess);
                        }
                    } else {
                        throw new IllegalArgumentException("Transaction type not defined..");
                    }
                }

                // Process revision
                revisionService.processRevision(
                        request.getVClmno(),
                        BigDecimal.valueOf(request.getVTransNo()),
                        request.getVTransType(),
                        new Date(),
                        vRevAmt,
                        vTotCoinAmt,
                        BigDecimal.valueOf(cmb.getCmbIpuCode()),
                        request.getVUser()
                );
            } else {
                throw new ResourceNotFoundException("Product not found");
            }
        } else {
            throw new ResourceNotFoundException("Claim not found");
        }

        return response;
    }

    private Long generateClmpCode() {
        // Implement logic to generate unique clmp_code
        // e.g., using a sequence or other method
        return 1L; // Replace with actual logic
    }

    private Long generateClmrevCode() {
        // Implement logic to generate unique clmrev_code
        // e.g., using a sequence or other method
        return 1L; // Replace with actual logic
    }

    private Long generateCpeCode() {
        // Implement logic to generate unique cpe_code
        // e.g., using a sequence or other method
        return 1L; // Replace with actual logic
    }

    // ... other methods ...
}
