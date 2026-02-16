package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLM_COIN_RESERVES table.
 * Stores the coinsuarance reserves.
 */
@Entity
@Table(name = "GIN_CLM_COIN_RESERVES")
@Data
public class GinClmCoinReserves {

    /**
     * Primary key for the coinsuarance reserve record.
     */
    @Id
    @Column(name = "CCOR_CODE", nullable = false, precision = 22)
    private BigDecimal ccorCode;

    /**
     * Foreign Key from GIN_CLAIM_MASTER_BOOKINGS for claim number.
     */
    @Column(name = "CCOR_CMB_CLAIM_NO", nullable = false, length = 40)
    private String ccorCmbClaimNo;

    /**
     * Foreign Key from TQC_AGENCIES for agent code.
     */
    @Column(name = "CCOR_AGNT_AGENT_CODE", nullable = false, precision = 22)
    private BigDecimal ccorAgntAgentCode;

    /**
     * Agent short description.
     */
    @Column(name = "CCOR_AGENT_SHT_DESC", length = 15)
    private String ccorAgentShtDesc;

    /**
     * Coinsurance reserve amount.
     */
    @Column(name = "CCOR_AMOUNT", precision = 27, scale = 5)
    private BigDecimal ccorAmount;

    /**
     * Coinsurance rate.
     */
    @Column(name = "CCOR_RATE", precision = 22, scale = 5)
    private BigDecimal ccorRate;

    /**
     * Transaction number.
     */
    @Column(name = "CCOR_GGT_TRANS_NO", precision = 22)
    private BigDecimal ccorGgtTransNo;

    /**
     * Coinsurance reserve amount in base currency.
     */
    @Column(name = "CCOR_AMOUNT_BCUR", precision = 27, scale = 5)
    private BigDecimal ccorAmountBcur;
}
