package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.exception.ResourceNotFoundException;
import com.turnquest.setupsdemo.model.GinClaimMasterBookings;
import com.turnquest.setupsdemo.model.GinClaimPerils;
import com.turnquest.setupsdemo.repository.*;
import com.turnquest.setupsdemo.service.GinClaimService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GinClaimServiceImpl implements GinClaimService {

    private final GinClaimRevisionsRepository claimRevisionsRepository;
    private final GinClmPaymentVoucherRepository clmPaymentVouchersRepository;
    private final GinClaimMasterBookingsRepository claimMasterBookingsRepository;
    private final GinClaimPerilsRepository claimPerilsRepository;
    private final GinClaimRecoverPerilsRepository claimRecoverPerilsRepository;
    private final GinVoucherDetailsRepository voucherDetailsRepository;

    public BigDecimal getOsReserve(String vClaimNo, String vAuth) {
        BigDecimal vTotalReserve = BigDecimal.ZERO;
        BigDecimal vRecoveries = BigDecimal.ZERO;
        BigDecimal vSalvages = BigDecimal.ZERO;
        BigDecimal vTotalPayments = BigDecimal.ZERO;
        BigDecimal vOstReserve = BigDecimal.ZERO;

        if ("Y".equals(vAuth)) {
            // Fetch total authorized reserve from GinClaimRevisions
            Optional<BigDecimal> totalReserve = claimRevisionsRepository.findTotalAuthorizedReserveByClaimNo(vClaimNo);
            if (totalReserve.isPresent()) {
                vTotalReserve = totalReserve.get();
            }

            // Fetch authorized payments from GinClmPaymentVouchers
            Optional<BigDecimal> totalPayments = clmPaymentVouchersRepository.findTotalAuthorizedPaymentsByClaimNo(vClaimNo);
            if (totalPayments.isPresent()) {
                vTotalPayments = totalPayments.get();
            }

            // Calculate outstanding reserve
            vOstReserve = vTotalReserve.add(vRecoveries).add(vSalvages).subtract(vTotalPayments);
        } else {
            // Fetch total reserve (regardless of authorization) from GinClaimRevisions
            Optional<BigDecimal> totalReserve = claimRevisionsRepository.findTotalReserveByClaimNo(vClaimNo);
            if (totalReserve.isPresent()) {
                vTotalReserve = totalReserve.get();
            }

            // Fetch all payments (regardless of authorization) from GinClmPaymentVouchers
            Optional<BigDecimal> totalPayments = clmPaymentVouchersRepository.findTotalPaymentsByClaimNo(vClaimNo);
            if (totalPayments.isPresent()) {
                vTotalPayments = totalPayments.get();
            }

            // Calculate outstanding reserve
            vOstReserve = vTotalReserve.add(vRecoveries).add(vSalvages).subtract(vTotalPayments);
        }

        return vOstReserve;
    }

    public BigDecimal getTotalOsPerInsured(String vClaimNo, Long vCldCode) {
        BigDecimal vTotalInsuredOsAmt = BigDecimal.ZERO;

        // Fetch the claim details
        Optional<GinClaimMasterBookings> claim = claimMasterBookingsRepository.findById(vClaimNo);
        if (claim.isPresent()) {
            // Fetch claim perils for the specific claim and claimant code
            List<GinClaimPerils> claimPerils = claimPerilsRepository.findByClmpCmbClaimNoAndClmpRegCldCode(vClaimNo, vCldCode);

            // Iterate through each peril
            for (GinClaimPerils peril : claimPerils) {
                BigDecimal vOsReservePerInsured = this.getOsReservePerInsured(
                        vClaimNo,
                        vCldCode,
                        peril.getClmpPerPtCode() // Peril code
                );

                // Accumulate the total outstanding reserve per insured
                vTotalInsuredOsAmt = vTotalInsuredOsAmt.add(vOsReservePerInsured);
            }
        } else {
            throw new ResourceNotFoundException("Claim not found");
        }

        return vTotalInsuredOsAmt;
    }

    // Method to get outstanding reserve per insured (You need to implement this)
    public BigDecimal getOsReservePerInsured(String vClaimNo, Long vInsuredCode, Long vPerCode) {
        BigDecimal vTotalReserve = BigDecimal.ZERO;
        BigDecimal vRecoveries = BigDecimal.ZERO;
        BigDecimal vSalvages = BigDecimal.ZERO;
        BigDecimal vTotalPayments = BigDecimal.ZERO;
        BigDecimal vOstReserve = BigDecimal.ZERO;

        // Fetch total reserve for the given peril and insured
        Optional<BigDecimal> totalReserve = claimPerilsRepository.findTotalReserveByClaimNoAndPerCodeAndInsuredCode(vClaimNo, vPerCode, vInsuredCode);
        if (totalReserve.isPresent()) {
            vTotalReserve = totalReserve.get();
        }

        // Fetch recoveries for the given peril and claim
        Optional<BigDecimal> recoveries = claimRecoverPerilsRepository.findTotalRecoveriesByClaimNoAndPerCode(vClaimNo, vPerCode);
        if (recoveries.isPresent()) {
            vRecoveries = recoveries.get();
        }

        // Fetch salvages for the given peril and claim
        Optional<BigDecimal> salvages = claimRecoverPerilsRepository.findTotalSalvagesByClaimNoAndPerCode(vClaimNo, vPerCode);
        if (salvages.isPresent()) {
            vSalvages = salvages.get();
        }

        // Fetch total payments for the given peril and claim
        Optional<BigDecimal> totalPayments = voucherDetailsRepository.findTotalPaymentsByClaimNoAndPerCode(vClaimNo, vPerCode);
        if (totalPayments.isPresent()) {
            vTotalPayments = totalPayments.get();
        }

        // Calculate outstanding reserve
        vOstReserve = vTotalReserve.add(vRecoveries).add(vSalvages).subtract(vTotalPayments);

        return vOstReserve;
    }
    // ... other methods ...
}
