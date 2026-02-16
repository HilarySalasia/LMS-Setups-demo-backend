package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.LmsOrdPremRateTables;
import com.turnquest.setupsdemo.model.LmsProdCoverTypes;
import com.turnquest.setupsdemo.model.PremiumMask;
import com.turnquest.setupsdemo.repository.LmsOrdPremRateTablesRepository;
import com.turnquest.setupsdemo.repository.LmsProdCoverTypesRepository;
import com.turnquest.setupsdemo.service.LmsOrdPremRateTablesService;
import com.turnquest.setupsdemo.service.LmsProdCoverTypesService;
import com.turnquest.setupsdemo.service.PremiumMaskService;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class LmsOrdPremRateTablesServiceImpl implements LmsOrdPremRateTablesService {

    private final LmsOrdPremRateTablesRepository repository;
    private final LmsProdCoverTypesService lmsProdCoverTypesService;

    private final PremiumMaskService premiumMaskService;

    public LmsOrdPremRateTablesServiceImpl(
            LmsOrdPremRateTablesRepository repository,
            LmsProdCoverTypesService lmsProdCoverTypesService,
            PremiumMaskService premiumMaskService
    ) {
        this.repository = repository;
        this.lmsProdCoverTypesService = lmsProdCoverTypesService;
        this.premiumMaskService = premiumMaskService;
    }

    @Override
    public List<LmsOrdPremRateTables> findAll() {
        return repository.findAll();
    }

    @Override
    public LmsOrdPremRateTables findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public LmsOrdPremRateTables save(LmsOrdPremRateTables rateTable) {
        return repository.save(rateTable);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public LmsOrdPremRateTables updateOrdPremRateTable(LmsOrdPremRateTables rateTable, String errorMessage) throws Exception {
        // Assume getClaCode and raiseError are implemented methods for getting CLA code and raising errors

        // Simulating the logic for CLA code retrieval
        String vClaCode = getClaCode("O");
        rateTable.setOrdtClaCode(Long.parseLong(vClaCode));

        // Simulating the SELECT INTO logic
        try {
            // Assume method getProductCoverTypesInfo() retrieves the required data from lms_prod_cover_types and lms_cover_types tables
            LmsProdCoverTypes lmsProdCoverTypes = lmsProdCoverTypesService.findById(rateTable.getOrdtPctCode().longValue());
            ProductCoverTypesInfo productInfo = getProductCoverTypesInfo(rateTable.getOrdtPctCode().longValue());
            PremiumMask premiumMask = premiumMaskService.getPremiumMaskById(rateTable.getOrdtPmasCode());
            rateTable.setOrdtCvtCode(Long.parseLong(productInfo.getCvtCode()));
            rateTable.setOrdtCvtShtDesc(productInfo.getCvtShtDesc());
            lmsProdCoverTypes.setPctLoadFactor(productInfo.getPctLoadFactor());
            lmsProdCoverTypes.setPctLoadFactorDiv(productInfo.getPctLoadFactorDiv());

            if (rateTable.getOrdtPmasCode() != null) {
                String pmasRateType = getPmasRateType(rateTable.getOrdtPmasCode().longValue());
                premiumMask.setPmasRateType(pmasRateType);

                if ("P".equals(pmasRateType)) {
                    if (lmsProdCoverTypes.getPctLoadFactor().compareTo(BigDecimal.ZERO) == 0 ||
                            lmsProdCoverTypes.getPctLoadFactorDiv().compareTo(BigDecimal.ZERO) == 0) {
                        raiseError("The product cover type load factor cannot be zero");
                    }

                    calculateRates(rateTable, lmsProdCoverTypes);
                }
            }
        } catch (Exception e) {
            raiseError("Error in Calculation");
        }

        if (rateTable.getOrdtCode() == null) {
            try {
                // Simulating the insertion logic
                rateTable.setOrdtCode(generateNewCode());
                return repository.save(rateTable);
            } catch (Exception e) {
                raiseError("Error creating premium rates table record....");
            }
        } else {
            try {
                // Simulating the update logic
                Optional<LmsOrdPremRateTables> existingRateTable = repository.findById(rateTable.getOrdtCode());
                if (existingRateTable.isPresent()) {
                    LmsOrdPremRateTables existing = existingRateTable.get();
                    updateRateTableFields(existing, rateTable);
                    return repository.save(existing);
                } else {
                    throw new Exception("Record not found");
                }
            } catch (Exception e) {
                raiseError("Error updating premium rates table record....");
            }
        }

        return null;
    }

    @Override
    public List<LmsOrdPremRateTables> getOrdPremRateTables(BigDecimal pmasCode, BigDecimal popCode, BigDecimal pctCode,
                                                           BigDecimal optCode, Long opirCode, String gender) {
        return repository.findOrdPremRateTables(pmasCode, popCode, pctCode, optCode, opirCode, gender);
    }

    @Override
    public List<LmsOrdPremRateTables> findByOrdOptCode(BigDecimal ordOptCode) {
        return repository.findByOrdOptCode(ordOptCode);
    }

    private String getClaCode(String type) {
        // Simulate the get_cla_code function
        return "CLA_CODE_SAMPLE";
    }

    private ProductCoverTypesInfo getProductCoverTypesInfo(Long pctCode) {
        // Simulate the retrieval of product cover types info
        return new ProductCoverTypesInfo("CVT_CODE_SAMPLE", "CVT_SHT_DESC_SAMPLE", BigDecimal.ONE, BigDecimal.ONE);
    }

    private String getPmasRateType(Long pmasCode) {
        // Simulate the retrieval of PMAS rate type
        return "P";
    }

    private void calculateRates(LmsOrdPremRateTables rateTable, LmsProdCoverTypes lmsProdCoverTypes) {
        // Simulate the calculation logic
        BigDecimal qx = rateTable.getOrdtQx();
        BigDecimal pctLoadFactor = lmsProdCoverTypes.getPctLoadFactor();
        BigDecimal pctLoadFactorDiv = lmsProdCoverTypes.getPctLoadFactorDiv();

        rateTable.setOrdtDivisionFactor(BigDecimal.valueOf(1000));
        rateTable.setOrdtMonthDivFact(BigDecimal.valueOf(1000));
        rateTable.setOrdtSingleDivFact(BigDecimal.valueOf(1000));

        rateTable.setOrdtRate(calculateRate(qx, pctLoadFactor, pctLoadFactorDiv, 12));
        rateTable.setOrdtQuarterRate(calculateRate(qx, pctLoadFactor, pctLoadFactorDiv, 4));
        rateTable.setOrdtSemiAnnlRate(calculateRate(qx, pctLoadFactor, pctLoadFactorDiv, 2));
        rateTable.setOrdtAnnualRate(calculateRate(qx, pctLoadFactor, pctLoadFactorDiv, 1));
        rateTable.setOrdtSingleRate(calculateRate(qx, pctLoadFactor, pctLoadFactorDiv, 1));
        rateTable.setOrdtWklyRate(calculateRate(qx, pctLoadFactor, pctLoadFactorDiv, 52));
        rateTable.setOrdtDlyRate(calculateRate(qx, pctLoadFactor, pctLoadFactorDiv, 365));
    }

    private BigDecimal calculateRate(BigDecimal qx, BigDecimal pctLoadFactor, BigDecimal pctLoadFactorDiv, int period) {
        return BigDecimal.valueOf(1000);
    }

    private Long generateNewCode() {
        // Simulate the generation of a new code
        return System.currentTimeMillis();
    }

    private void updateRateTableFields(LmsOrdPremRateTables existing, LmsOrdPremRateTables updated) {
        // Update the fields of existing record with updated values
        existing.setOrdtPctCode(updated.getOrdtPctCode());
        existing.setOrdtRate(updated.getOrdtRate());
        existing.setOrdtWef(updated.getOrdtWef());
        existing.setOrdtWet(updated.getOrdtWet());
        existing.setOrdtClaCode(updated.getOrdtClaCode());
        existing.setOrdtPmasCode(updated.getOrdtPmasCode());
        existing.setOrdtAnbFrom(updated.getOrdtAnbFrom());
        existing.setOrdtAnbTo(updated.getOrdtAnbTo());
        existing.setOrdtDivisionFactor(updated.getOrdtDivisionFactor());
        existing.setOrdtRateType(updated.getOrdtRateType());
        existing.setOrdtMonthRate(updated.getOrdtMonthRate());
        existing.setOrdtMonthDivFact(updated.getOrdtMonthDivFact());
        existing.setOrdtCvtCode(updated.getOrdtCvtCode());
        existing.setOrdtCvtShtDesc(updated.getOrdtCvtShtDesc());
        existing.setOrdtQuarterRate(updated.getOrdtQuarterRate());
        existing.setOrdtSemiAnnlRate(updated.getOrdtSemiAnnlRate());
        existing.setOrdtPopCode(updated.getOrdtPopCode());
        existing.setOrdtAnnualRate(updated.getOrdtAnnualRate());
        existing.setOrdOptCode(updated.getOrdOptCode());
        existing.setOrdtTerm(updated.getOrdtTerm());
        existing.setLmsOrdPremIntrRate(updated.getLmsOrdPremIntrRate());
        existing.setLmsMortalityRates(updated.getLmsMortalityRates());
        existing.setOrdtSingleRate(updated.getOrdtSingleRate());
        existing.setOrdtSingleDivFact(updated.getOrdtSingleDivFact());
        existing.setOrdtGender(updated.getOrdtGender());
        existing.setOrdtWklyRate(updated.getOrdtWklyRate());
        existing.setOrdtDlyRate(updated.getOrdtDlyRate());
        existing.setOrdtDependantNo(updated.getOrdtDependantNo());
        existing.setOrdtAmtFrom(updated.getOrdtAmtFrom());
        existing.setOrdtAmtTo(updated.getOrdtAmtTo());
        existing.setOrdtSa(updated.getOrdtSa());
        existing.setOrdtRateDesc(updated.getOrdtRateDesc());
        existing.setOrdtQx(updated.getOrdtQx());
        existing.setOrdtTriannualRate(updated.getOrdtTriannualRate());
        existing.setOrdtExpensePremium(updated.getOrdtExpensePremium());
    }


    private void raiseError(String message) throws Exception {
        throw new Exception(message);
    }

    // Simulate the ProductCoverTypesInfo class
    @Data
    static class ProductCoverTypesInfo {
        private final String cvtCode;
        private final String cvtShtDesc;
        private final BigDecimal pctLoadFactor;
        private final BigDecimal pctLoadFactorDiv;

        public ProductCoverTypesInfo(String cvtCode, String cvtShtDesc, BigDecimal pctLoadFactor, BigDecimal pctLoadFactorDiv) {
            this.cvtCode = cvtCode;
            this.cvtShtDesc = cvtShtDesc;
            this.pctLoadFactor = pctLoadFactor;
            this.pctLoadFactorDiv = pctLoadFactorDiv;
        }
    }
}
