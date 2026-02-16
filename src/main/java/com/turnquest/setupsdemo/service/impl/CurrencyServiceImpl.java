package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.CurrencyRateResponseDto;
import com.turnquest.setupsdemo.exception.ResourceNotFoundException;
import com.turnquest.setupsdemo.model.Currency;
import com.turnquest.setupsdemo.model.TqcCurrencyRates;
import com.turnquest.setupsdemo.model.TqcOrganizations;
import com.turnquest.setupsdemo.repository.CurrencyRepository;
import com.turnquest.setupsdemo.repository.TqcCurrencyRatesRepository;
import com.turnquest.setupsdemo.repository.TqcOrganizationsRepository;
import com.turnquest.setupsdemo.service.CurrencyService;
import com.turnquest.setupsdemo.service.SqlSequence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Service implementation for Currency operations.
 */
@Service
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final SqlSequence sqlSequence;
    private final TqcOrganizationsRepository organizationsRepository;
    private final TqcCurrencyRatesRepository currencyRatesRepository;


    @Override
    public List<Currency> findAllOrderedByDescription() {
        return currencyRepository.findAllOrderedByDescription();
    }

    public CurrencyRateResponseDto getCurrencyExchangeRate(Long vAgainstCurCode,
                                                           Integer vRound,
                                                           Integer vBcurRound) {

        BigDecimal vRate = BigDecimal.ONE;
        String vErrmsg = null;
        Long vBaseCurCode = null;
        Long vExchRateParam = null;
        CurrencyRateResponseDto response = new CurrencyRateResponseDto();

        // Get currency rate extension days parameter
        try {
            vExchRateParam = Long.parseLong(sqlSequence.getTQCParamNumber("CURRENCY_RATE_EXTENSION_DAYS"));
        } catch (Exception e) {
            // Handle exception gracefully
            // You might want to log the error instead of throwing an exception here
            // vErrmsg = "Error fetching CURRENCY_RATE_EXTENSION_DAYS parameter";
        }

        // Get base currency code
        try {
            Optional<TqcOrganizations> organization = organizationsRepository.findByOrgCodeAndSysShtDesc(1L, "GIS"); // Replace 1L with actual ORG_CODE
            if (organization.isPresent()) {
                vBaseCurCode = organization.get().getOrgCurCode().longValue();
            } else {
                throw new ResourceNotFoundException("Companies Base Currency Has Not Been Defined...");
            }
        } catch (ResourceNotFoundException e) {
            throw e; // Re-throw the ResourceNotFoundException
        } catch (Exception e) {
            vErrmsg = "Unable to determine Base Currency";
            // Log the error or handle it appropriately
        }

        // Handle base currency vs. against currency
        if (vBaseCurCode.equals(vAgainstCurCode)) {
            vRate = BigDecimal.ONE;
        } else {
            try {
                Optional<TqcCurrencyRates> currencyRate = currencyRatesRepository.findByCrtCurCodeAndCrtBaseCurCodeAndCrtWefAndCrtWet(
                        vAgainstCurCode,
                        vBaseCurCode,
                        new java.sql.Date(System.currentTimeMillis()),
                        new java.sql.Date(System.currentTimeMillis()) // Replace with actual logic if needed
                );
                if (currencyRate.isPresent()) {
                    vRate = currencyRate.get().getCrtRate();
                } else {
                    // Fetch rate for the latest effective date within the extension period
                    Optional<TqcCurrencyRates> latestRate = currencyRatesRepository.findLatestRateWithinExtensionPeriod(
                            vAgainstCurCode,
                            vBaseCurCode,
                            new java.sql.Date(System.currentTimeMillis()),
                            vExchRateParam
                    );
                    if (latestRate.isPresent()) {
                        vRate = latestRate.get().getCrtRate();
                    } else {
                        vErrmsg = "Unable to retrieve the exchange rate";
                        // Log the error or handle it appropriately
                    }
                }
            } catch (Exception e) {
                vErrmsg = "Unable to retrieve the exchange rate";
                // Log the error or handle it appropriately
            }
        }

        // Fetch rounding decimal places
        try {
            Optional<Currency> againstCurrency = currencyRepository.findByCurCode(vAgainstCurCode);
            if (againstCurrency.isPresent()) {
                vRound = againstCurrency.get().getCurRnd().intValue();
            }

            Optional<Currency> baseCurrency = currencyRepository.findByCurCode(vBaseCurCode);
            if (baseCurrency.isPresent()) {
                vBcurRound = baseCurrency.get().getCurRnd().intValue();
            }
        } catch (Exception e) {
            vErrmsg = "Unable to determine rounding decimal places for the currency";
            // Log the error or handle it appropriately
        }

        // Set response values
        response.setVRate(vRate);
        response.setVRound(vRound);
        response.setVBcurRound(vBcurRound);

        // Handle error if any
        if (vErrmsg != null) {
            throw new RuntimeException(vErrmsg);
        }

        return response;
    }
}
