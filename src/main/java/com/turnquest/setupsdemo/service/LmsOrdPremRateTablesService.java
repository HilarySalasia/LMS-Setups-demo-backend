package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.LmsOrdPremRateTables;

import java.math.BigDecimal;
import java.util.List;

public interface LmsOrdPremRateTablesService {

    List<LmsOrdPremRateTables> findAll();
    LmsOrdPremRateTables findById(Long id);
    LmsOrdPremRateTables save(LmsOrdPremRateTables rateTable);
    void deleteById(Long id);
    LmsOrdPremRateTables updateOrdPremRateTable(LmsOrdPremRateTables rateTable, String errorMessage) throws Exception;

    /**
     * Find LmsOrdPremRateTables by ordOptCode.
     *
     * @param ordOptCode The ordOptCode to search for.
     * @return A list of LmsOrdPremRateTables matching the given ordOptCode.
     */
    List<LmsOrdPremRateTables> findByOrdOptCode(BigDecimal ordOptCode);

    List<LmsOrdPremRateTables> getOrdPremRateTables(BigDecimal pmasCode, BigDecimal popCode, BigDecimal pctCode, BigDecimal optCode,
                                                    Long opirCode, String gender);
}
