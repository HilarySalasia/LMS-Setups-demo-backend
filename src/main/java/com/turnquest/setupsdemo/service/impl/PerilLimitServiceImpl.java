package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.PerilLimit;
import com.turnquest.setupsdemo.dto.PerilLimitResponse;
import com.turnquest.setupsdemo.exception.ResourceNotFoundException;
import com.turnquest.setupsdemo.model.*;
import com.turnquest.setupsdemo.repository.*;
import com.turnquest.setupsdemo.service.PerilLimitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@AllArgsConstructor
public class PerilLimitServiceImpl implements PerilLimitService {


    private final GinPerilsRepository perilRepository;
    private final GinParametersRepository parameterRepository;
    private final GinClaimMasterBookingsRepository claimBookingRepository;
    private final GinClmPaymentVoucherRepository paymentVoucherRepository;
    private final GinPolRiskSectionPerilRepository polRiskSectionPerilRepository;
    private final GinPolicySectionPerilRepository policySectionPerilRepository;
    private final GinSubclSctionPerilRepository subclSctionPerilRepository;
    private final GinPolicyInsuredLimitRepository policyInsuredLimitRepository;

    public PerilLimitResponse getPerilLimits(
            Long perilCode, String perilType, BigDecimal si, Long covtCode, Long ipuCode
    ) {
        // Retrieve peril type and payment flag
        GinPerils peril = perilRepository.findById(perilCode).orElseThrow(() -> new ResourceNotFoundException("Peril not found"));
        String pertytp = peril.getPerPerilType();

        GinParameters parameter = parameterRepository.findByParamName("PERIL_LIMIT_LESS_PYMT_AMT")
                .orElseThrow(() -> new ResourceNotFoundException("Parameter not found"));
        String perilLimitPymtAmt = parameter.getParamValue();

        // Calculate total paid amount
        BigDecimal cpvAmount = BigDecimal.ZERO;
        if ("Y".equals(perilLimitPymtAmt) && "L".equals(pertytp)) {
            cpvAmount = claimBookingRepository.findByCmbIpuCode(ipuCode)
                    .stream()
                    .flatMap(cmb -> paymentVoucherRepository.findByCpvCmbClaimNo(cmb.getCmbClaimNo())
                            .stream()
                            .filter(cpv -> "Y".equals(cpv.getCpvAuthorised()))
                            .map(GinClmPaymentVouchers::getCpvAmount))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        // Retrieve peril limits from policy sections
        PerilLimit perLimit = new PerilLimit();
        switch (perilType) {
            case "R":
                GinPolRiskSectionPeril polRiskSectionPeril = polRiskSectionPerilRepository.findById(perilCode)
                        .orElseThrow(() -> new ResourceNotFoundException("Peril not found in risk section"));
                perLimit.setSectCode(polRiskSectionPeril.getPrsprSectCode().longValue());
                perLimit.setPerilLimit(polRiskSectionPeril.getPrsprPerilLimit());
                perLimit.setType(polRiskSectionPeril.getPrsprPerilType());
                perLimit.setSiOrLimit(polRiskSectionPeril.getPrsprSiOrLimit());
                perLimit.setExcessType(polRiskSectionPeril.getPrsprClaimExcessType());
                perLimit.setExcess(polRiskSectionPeril.getPrsprExcess());
                perLimit.setExcessMin(polRiskSectionPeril.getPrsprExcessMin());
                perLimit.setExcessMax(polRiskSectionPeril.getPrsprExcessMax());
                perLimit.setPersonLimit(polRiskSectionPeril.getPrsprPersonLimit());
                perLimit.setClaimLimit(polRiskSectionPeril.getPrsprClaimLimit());
                perLimit.setDepRate(polRiskSectionPeril.getPrsprDepreciationPct());
                perLimit.setMultplier(polRiskSectionPeril.getPrsprSalvagePct());
                perLimit.setExcessPerilSectCode(null);
                break;
            case "P":
                GinPolicySectionPerils policySectionPeril = policySectionPerilRepository.findById(perilCode)
                        .orElseThrow(() -> new ResourceNotFoundException("Peril not found in policy section"));
                perLimit.setSectCode(policySectionPeril.getPsprSectCode());
                perLimit.setPerilLimit(policySectionPeril.getPsprPerilLimit());
                perLimit.setType(policySectionPeril.getPsprPerilType());
                perLimit.setSiOrLimit(policySectionPeril.getPsprSiOrLimit());
                perLimit.setExcessType(policySectionPeril.getPsprClaimExcessType());
                perLimit.setExcess(policySectionPeril.getPsprExcess());
                perLimit.setExcessMin(policySectionPeril.getPsprExcessMin());
                perLimit.setExcessMax(policySectionPeril.getPsprExcessMax());
                perLimit.setPersonLimit(policySectionPeril.getPsprPersonLimit());
                perLimit.setClaimLimit(policySectionPeril.getPsprClaimLimit());
                perLimit.setDepRate(policySectionPeril.getPsprDepreciationPct());
                perLimit.setMultplier(policySectionPeril.getPsprSalvagePct());
                perLimit.setExcessPerilSectCode(null);
                break;
            case "S":
                GinSubclSctionPerils subclSctionPeril = subclSctionPerilRepository.findById(perilCode)
                        .orElseThrow(() -> new ResourceNotFoundException("Peril not found in sub-class section"));
                perLimit.setSectCode(subclSctionPeril.getSsPrSectCode().longValue());
                perLimit.setPerilLimit(subclSctionPeril.getSsPrPerilLimit());
                perLimit.setType(subclSctionPeril.getSsPrPerilType());
                perLimit.setSiOrLimit(subclSctionPeril.getSsPrSiOrLimit());
                perLimit.setExcessType(subclSctionPeril.getSsPrExcessType());
                perLimit.setExcess(subclSctionPeril.getSsPrExcess());
                perLimit.setExcessMin(subclSctionPeril.getSsPrExcessMin());
                perLimit.setExcessMax(subclSctionPeril.getSsPrExcessMax());
                perLimit.setPersonLimit(subclSctionPeril.getSsPrPersonLimit());
                perLimit.setClaimLimit(subclSctionPeril.getSsPrClaimLimit());
                perLimit.setDepRate(subclSctionPeril.getSsPrDepreciationPct());
                perLimit.setMultplier(subclSctionPeril.getSsPrSalvagePct());
                perLimit.setExcessPerilSectCode(subclSctionPeril.getSsPrExcessSectCode().longValue());
                break;
            default:
                throw new IllegalArgumentException("Invalid peril type: " + perilType);
        }

        // Calculate primary limit
        BigDecimal pLimit = null;
        if ("Y".equals(perilLimitPymtAmt) && "L".equals(pertytp)) {
            if ("SI".equals(perLimit.getSiOrLimit())) {
                pLimit = si.subtract(cpvAmount);
            } else if ("SL".equals(perLimit.getSiOrLimit())) {
                pLimit = policyInsuredLimitRepository.findByPilIpuCodeAndPilSectCode(ipuCode, perLimit.getSectCode())
                        .stream()
                        .map(GinPolicyInsuredLimits::getPilLimitAmt)
                        .max(BigDecimal::compareTo)
                        .orElseThrow(() -> new ResourceNotFoundException("Policy not insured against this peril"))
                        .subtract(cpvAmount);
            } else if ("PL".equals(perLimit.getSiOrLimit())) {
                pLimit = perLimit.getPerilLimit().subtract(cpvAmount);
            }
        } else {
            if ("SI".equals(perLimit.getSiOrLimit())) {
                pLimit = si;
            } else if ("SL".equals(perLimit.getSiOrLimit())) {
                pLimit = policyInsuredLimitRepository.findByPilIpuCodeAndPilSectCode(ipuCode, perLimit.getSectCode())
                        .stream()
                        .map(GinPolicyInsuredLimits::getPilLimitAmt)
                        .max(BigDecimal::compareTo)
                        .orElseThrow(() -> new ResourceNotFoundException("Policy not insured against this peril"));
            } else if ("PL".equals(perLimit.getSiOrLimit())) {
                pLimit = perLimit.getPerilLimit();
            }
        }

        // Calculate excess limit
        BigDecimal eLimit = BigDecimal.ZERO;
        if (perLimit.getExcessPerilSectCode() != null) {
            eLimit = BigDecimal.ZERO;
        } else {
            if ("A".equals(perLimit.getExcessType())) {
                eLimit = perLimit.getExcess();
            } else if ("P".equals(perLimit.getExcessType())) {
                eLimit = perLimit.getExcess().divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP).multiply(pLimit);
            }
        }

        // Update depreciation rate
        if (perLimit.getDepRate() != null) {
            perLimit.setDepRate(perLimit.getDepRate());
        }

        // Return response
        PerilLimitResponse response = new PerilLimitResponse(
                pLimit,
                eLimit,
                perLimit.getDepRate(),
                perLimit.getMultplier()
        );

        return response;
    }
}
