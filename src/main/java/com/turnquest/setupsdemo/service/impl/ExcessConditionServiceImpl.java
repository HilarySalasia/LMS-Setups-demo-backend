package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.ExcessCondition;
import com.turnquest.setupsdemo.model.*;
import com.turnquest.setupsdemo.repository.*;
import com.turnquest.setupsdemo.service.ExcessConditionService;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// ... other imports ...

@Service
@AllArgsConstructor
public class ExcessConditionServiceImpl implements ExcessConditionService {

    private final EntityManager entityManager;

    private final GinClaimMasterBookingsRepository claimBookingRepository;
    private final GinClmDrvDtlsRepository clmDrvDtlsRepository;
    private final GinProductRepository productRepository;
    private final GinSubclSctionExcessRepository subclSctionExcessRepository;
    private final TqcOrganizationsRepository organizationsRepository;
    private final TqcLocationsRepository locationsRepository;
    private final TqcTownsRepository townsRepository;
    private final GisValuationDtlsRepository valuationDtlsRepository;
    private final GinInsuredPropertyUndsRepository insuredPropertyUndsRepository;
    private final GinPolRiskSectionPerilRepository ginPolRiskSectionPerilRepository;
    private final GinClassExcessRepository ginClassExcessRepository;

    /**
     * Check if excess conditions are true for a claim.
     * The below code is not complete and is only meant to be used as a reference.
     * @param vSsexCode
     * @param vClaimNo
     * @param vMotorProduct
     * @return
     */

    /** Todo: Implement the excessConditionTrue method completely. Encountered error during Migration*/
    public String excessConditionTrue(Long vSsexCode, String vClaimNo, String vMotorProduct) {
        // Retrieve excess conditions
        Optional<GinSubclSctionExcess> ssex = subclSctionExcessRepository.findById(BigDecimal.valueOf(vSsexCode));
        String vExcessCndtions = ssex.isPresent() ? ssex.get().getSsexConditions() : null;

        String vRet = "Y"; // Default to true

        if (vExcessCndtions != null) {
            vRet = "N";
            List<ExcessCondition> vExcCndtnsTab = getExcessConditions(vExcessCndtions);

            for (ExcessCondition excCond : vExcCndtnsTab) {
                BigDecimal vClmValue = null;
                switch (excCond.getCondName()) {
                    case "THEFT_RECOVERY_PERIOD":
                        Optional<GinClaimMasterBookings> claimBooking = claimBookingRepository.findById(vClaimNo);
                        if (claimBooking.isPresent()) {
                            java.util.Date cmbLossDateTime = claimBooking.get().getCmbLossDateTime();
                            vClmValue = new BigDecimal(Date.valueOf(
                                    String.valueOf(new java.util.Date())).toInstant().toEpochMilli() - cmbLossDateTime
                                    .toInstant().toEpochMilli());
                        }
                        break;
                    case "DRIVER_AGE":
                        if (vMotorProduct.equals("Y")) {
                            Optional<GinClmDrvDtls> driverDetails = clmDrvDtlsRepository.findByCdrCmbClaimNo(vClaimNo);
                            if (driverDetails.isPresent()) {
                                Date driverDob = new Date(driverDetails.get().getCdrDob().atStartOfDay()
                                        .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
                                if (driverDob != null) {
                                    vClmValue = new BigDecimal((Date.valueOf(
                                            String.valueOf(new java.util.Date())).toInstant().toEpochMilli() - driverDob
                                            .toInstant().toEpochMilli()) / 365);
                                }
                            }
                        }
                        break;
                    case "DRIVER_EXPERIENCE":
                        if (vMotorProduct.equals("Y")) {
                            Optional<GinClmDrvDtls> driverDetails = clmDrvDtlsRepository.findByCdrCmbClaimNo(vClaimNo);
                            if (driverDetails.isPresent()) {
                                vClmValue = driverDetails.get().getCdrDriverExperience();
                            }
                        }
                        break;
                    case "THEFT_RECOVERY_PERIOD_OUTSIDE_REGION":
                        Optional<GinClaimMasterBookings> claim = claimBookingRepository.findById(vClaimNo);
                        if (claim.isPresent()) {
                            String cmbLocation = claim.get().getCmbLocation();
                            Optional<TqcLocations> location = locationsRepository.findByLocName(cmbLocation);
                            if (location.isPresent()) {
                                Optional<TqcTowns> town = townsRepository.findById(location.get().getLocTwnCode());
                                if (town.isPresent()) {
                                    Optional<TqcOrganizations> org = organizationsRepository.findById(
                                            claim.get().getCmbOrgCode());
                                    if (org.isPresent()) {
                                        if (org.get().getOrgCouCode() != town.get().getTwnCouCode()) {
                                            vClmValue = new BigDecimal(Date.valueOf(String.valueOf(new java.util.Date()))
                                                    .toInstant().toEpochMilli() - claim.get().getCmbLossDateTime()
                                                    .toInstant().toEpochMilli());
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case "THEFT_RECOVERY_PERIOD_IN_REGION":
                        Optional<GinClaimMasterBookings> claim2 = claimBookingRepository.findById(vClaimNo);
                        if (claim2.isPresent()) {
                            String cmbLocation2 = claim2.get().getCmbLocation();
                            Optional<TqcLocations> location2 = locationsRepository.findByLocName(cmbLocation2);
                            if (location2.isPresent()) {
                                Optional<TqcTowns> town2 = townsRepository.findById(location2.get().getLocTwnCode());
                                if (town2.isPresent()) {
                                    Optional<TqcOrganizations> org2 = organizationsRepository.findById(
                                            claim2.get().getCmbOrgCode());
                                    if (org2.isPresent()) {
                                        if (org2.get().getOrgCouCode() == town2.get().getTwnCouCode()) {
                                            vClmValue = new BigDecimal(Date.valueOf(
                                                    String.valueOf(new java.util.Date()))
                                                    .toInstant().toEpochMilli() - claim2.get()
                                                    .getCmbLossDateTime().toInstant().toEpochMilli());
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case "INSPECTION_GRACE_PERIOD":
                        Optional<GinClaimMasterBookings> claim3 = claimBookingRepository.findById(vClaimNo);
                        if (claim3.isPresent()) {
                            Optional<GinInsuredPropertyUnds> ipu = insuredPropertyUndsRepository.findByIpuCode(
                                    claim3.get().getCmbIpuCode());
                            if (ipu.isPresent()) {
                                Optional<GisValuationDtls> valuationDetails = valuationDtlsRepository.findByVdtIpuCode(
                                        ipu.get().getIpuCode());
                                if (valuationDetails.isPresent() && valuationDetails.get().getVdtValStatus().equals("Y")) {
                                    vClmValue = null;
                                } else {
                                    vClmValue = new BigDecimal(Date.valueOf(
                                            String.valueOf(new java.util.Date())).toInstant().toEpochMilli() - ipu.get()
                                            .getIpuEffWef().toInstant().toEpochMilli());
                                }
                            }
                        }
                        break;
                    default:
                        // Handle unexpected condition name
                        // Log or throw an exception
                        break;
                }

                if (vClmValue != null) {
                    switch (excCond.getCondOptr()) {
                        case "=":
                            if (vClmValue.compareTo(excCond.getCondValue1()) == 0) {
                                vRet = "Y";
                            }
                            break;
                        case ">":
                            if (vClmValue.compareTo(excCond.getCondValue1()) > 0) {
                                vRet = "Y";
                            }
                            break;
                        case "<":
                            if (vClmValue.compareTo(excCond.getCondValue1()) < 0) {
                                vRet = "Y";
                            }
                            break;
                        case ">=":
                        case "=>":
                            if (vClmValue.compareTo(excCond.getCondValue1()) >= 0) {
                                vRet = "Y";
                            }
                            break;
                        case "<=":
                        case "=<":
                            if (vClmValue.compareTo(excCond.getCondValue1()) <= 0) {
                                vRet = "Y";
                            }
                            break;
                        case "BETWEEN":
                            if (vClmValue.compareTo(
                                    excCond.getCondValue1()) >= 0 && vClmValue.compareTo(excCond.getCondValue2()) <= 0) {
                                vRet = "Y";
                            }
                            break;
                        default:
                            // Handle unexpected operator
                            // Log or throw an exception
                            break;
                    }
                }
            }
        }

        return vRet;
    }

    /**
     * Calculate excess amount for a claim.
     * @param vCexCode
     * @param vUwAmnt
     * @param vClmAmnt
     * @param vPlOrTl
     * @param vIpuCode
     * @return
     */
    public BigDecimal getExcessAmount(Long vCexCode, BigDecimal vUwAmnt, BigDecimal vClmAmnt, String vPlOrTl, Long vIpuCode) {
        BigDecimal vExcessAmnt = BigDecimal.ZERO;
        BigDecimal vClaimExcessAmnt = BigDecimal.ZERO;

        // Find perils for the IPU code
        List<GinPolRiskSectionPerils> perils = ginPolRiskSectionPerilRepository.findByPrsprIpuCode(BigDecimal.valueOf(vIpuCode));

        if (perils.isEmpty()) {
            // If no perils found for the IPU code, use class excess
            Optional<GinClassExcess> classExcess = ginClassExcessRepository.findById(vCexCode);
            if (classExcess.isPresent()) {
                GinClassExcess ex = classExcess.get();
                if ("TL".equals(vPlOrTl)) {
                    return calculateExcess(ex.getCexTlExcessRateType(), ex.getCexTlExcessRate(),
                            ex.getCexTlExcessMin(), ex.getCexTlExcessMax(), vUwAmnt); // Calculate for TL
                } else {
                    return calculateExcess(ex.getCexPlExcessRateType(), ex.getCexPlExcessRate(),
                            ex.getCexPlExcessMin(), ex.getCexPlExcessMax(), vClmAmnt); // Calculate for PL
                }
            } else {
                throw new IllegalArgumentException("Class excess not found for code: " + vCexCode);
            }
        } else {
            // Calculate excess based on peril details
            for (GinPolRiskSectionPerils pExcess : perils) {
                if ("TL".equals(vPlOrTl)) {
                    vExcessAmnt = calculateExcess(pExcess.getPrsprTlExcessType(), pExcess.getPrsprTlExcess(),
                            pExcess.getPrsprTlExcessMin(), pExcess.getPrsprTlExcessMax(), vUwAmnt);
                    vClaimExcessAmnt = calculateExcess(pExcess.getPrsprClaimExcessType(), pExcess.getPrsprClaimExcess(),
                            pExcess.getPrsprClaimExcessMin(), pExcess.getPrsprClaimExcessMax(), vClmAmnt);
                } else {
                    vExcessAmnt = calculateExcess(pExcess.getPrsprClaimExcessType(), pExcess.getPrsprExcess(),
                            pExcess.getPrsprExcessMin(), pExcess.getPrsprExcessMax(), vUwAmnt);
                    vClaimExcessAmnt = calculateExcess(pExcess.getPrsprClaimExcessType(), pExcess.getPrsprClaimExcess(),
                            pExcess.getPrsprClaimExcessMin(), pExcess.getPrsprClaimExcessMax(), vClmAmnt);
                }

                return calculateFinalExcess(pExcess.getPrsprComputationType(), vExcessAmnt, vClaimExcessAmnt);
            }
        }

        throw new IllegalArgumentException("No valid excess calculation found.");
    }

    /**
     * Calculate excess amount based on excess type.
     * @param excessType
     * @param excessRate
     * @param excessMin
     * @param excessMax
     * @param amount
     * @return
     */
    private BigDecimal calculateExcess(String excessType, BigDecimal excessRate, BigDecimal excessMin, BigDecimal excessMax, BigDecimal amount) {
        BigDecimal excessAmnt = BigDecimal.ZERO;
        if ("P".equals(excessType)) {
            excessAmnt = excessRate.multiply(amount).divide(new BigDecimal(100), BigDecimal.ROUND_HALF_UP);
        } else {
            excessAmnt = excessRate;
        }
        excessAmnt = excessAmnt.max(excessMin);
        excessAmnt = excessAmnt.min(excessMax);
        return excessAmnt;
    }

    /**
     * Calculate final excess amount based on computation type.
     * @param computationType
     * @param vExcessAmnt
     * @param vClaimExcessAmnt
     * @return
     */
    private BigDecimal calculateFinalExcess(String computationType, BigDecimal vExcessAmnt, BigDecimal vClaimExcessAmnt) {
        if ("SI".equals(computationType)) {
            return vExcessAmnt;
        } else if ("CA".equals(computationType)) {
            return vClaimExcessAmnt;
        } else if ("MA".equals(computationType)) {
            return vExcessAmnt.max(vClaimExcessAmnt);
        } else if ("MI".equals(computationType)) {
            return vExcessAmnt.min(vClaimExcessAmnt);
        } else {
            throw new IllegalArgumentException("Invalid excess computation type: " + computationType);
        }
    }

    private List<ExcessCondition> getExcessConditions(String vExcessCndtions) {
        List<ExcessCondition> excessConditions = new ArrayList<>();
        if (vExcessCndtions != null && !vExcessCndtions.isEmpty()) {
            String[] conditions = vExcessCndtions.split(";");
            for (String condition : conditions) {
                ExcessCondition excessCondition = parseExcessCondition(condition);
                excessConditions.add(excessCondition);
            }
        }
        return excessConditions;
    }

    private ExcessCondition parseExcessCondition(String condition) {
        ExcessCondition excessCondition = new ExcessCondition();
        String[] parts = condition.split("[\\[\\]]");
        excessCondition.setCondName(parts[0].trim());
        excessCondition.setCondOptr(parts[1].trim());
        if (parts[2].contains("AND")) {
            String[] values = parts[2].split("AND");
            excessCondition.setCondValue1(new BigDecimal(values[0].trim()));
            excessCondition.setCondValue2(new BigDecimal(values[1].trim()));
        } else {
            excessCondition.setCondValue1(new BigDecimal(parts[2].trim()));
        }
        return excessCondition;
    }
}
