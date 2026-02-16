package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.dto.CurrencyRateResponseDto;
import com.turnquest.setupsdemo.model.Currency;

import java.util.List;

/**
 * Service interface for Currency operations.
 */
public interface CurrencyService {
    List<Currency> findAllOrderedByDescription();

    CurrencyRateResponseDto getCurrencyExchangeRate(Long vAgainstCurCode,
                                                    Integer vRound,
                                                    Integer vBcurRound);
}
