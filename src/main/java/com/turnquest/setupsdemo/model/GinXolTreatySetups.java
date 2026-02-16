package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_XOL_TREATY_SETUPS table.
 * Likely stores information about XOL treaty setups.
 */
@Entity
@Table(name = "GIN_XOL_TREATY_SETUPS")
@Data
public class GinXolTreatySetups {

    /**
     * Primary key for the XOL treaty setup record.
     */
    @Id
    @Column(name = "XOLS_CODE", nullable = false, precision = 22)
    private BigDecimal xolsCode;

    /**
     * Minimum deposit.
     */
    @Column(name = "XOLS_MIN_DEPOSIT", precision = 22, scale = 5)
    private BigDecimal xolsMinDeposit;

    /**
     * Deductible limit.
     */
    @Column(name = "XOLS_DEDUCTIBLE_LIMIT", precision = 22, scale = 5)
    private BigDecimal xolsDeductibleLimit;

    /**
     * Maximum claim limit.
     */
    @Column(name = "XOLS_MAX_CLAIM_LIMIT", precision = 22, scale = 5)
    private BigDecimal xolsMaxClaimLimit;

    /**
     * Loading adjustment factor.
     */
    @Column(name = "XOLS_LOADING_ADJ_FACTOR", precision = 22, scale = 5)
    private BigDecimal xolsLoadingAdjFactor;

    /**
     * Minimum adjustment factor.
     */
    @Column(name = "XOLS_MIN_ADJST_FACTOR", precision = 22, scale = 5)
    private BigDecimal xolsMinAdjstFactor;

    /**
     * Maximum adjustment factor.
     */
    @Column(name = "XOLS_MAX_ADJST_FACTOR", precision = 22, scale = 5)
    private BigDecimal xolsMaxAdjstFactor;

    /**
     * Foreign key from TQ_CRM.TQC_CURRENCIES, representing the currency code.
     */
    @Column(name = "XOLS_CUR_CODE", precision = 22)
    private BigDecimal xolsCurCode;

    /**
     * Currency symbol.
     */
    @Column(name = "XOLS_CUR_SYMBOL", length = 15)
    private String xolsCurSymbol;

    /**
     * Foreign key from GIN_XOL_ARRANGEMENT_SETUPS, representing the XOL arrangement setup code.
     */
    @Column(name = "XOLS_XAS_CODE", precision = 22)
    private BigDecimal xolsXasCode;

    /**
     * XOL code.
     */
    @Column(name = "XOLS_XOL_CODE", precision = 22)
    private BigDecimal xolsXolCode;

    /**
     * Layer.
     */
    @Column(name = "XOLS_LAYER", precision = 22)
    private BigDecimal xolsLayer;

    /**
     * Accounts.
     */
    @Column(name = "XOLS_ACCOUNTS", length = 1, columnDefinition = "VARCHAR2(1) default 'Q'")
    private String xolsAccounts;

    /**
     * Adjustment rate.
     */
    @Column(name = "XOLS_ADJ_RATE", precision = 22)
    private BigDecimal xolsAdjRate;

    /**
     * Gross/net premium income.
     */
    @Column(name = "XOLS_GROSS_NET_PREM_INC", precision = 23, scale = 5)
    private BigDecimal xolsGrossNetPremInc;

    /**
     * Incurred loss.
     */
    @Column(name = "XOLS_INCURRED_LOSS", precision = 22)
    private BigDecimal xolsIncurredLoss;

    /**
     * Rate.
     */
    @Column(name = "XOLS_RATE", precision = 22)
    private BigDecimal xolsRate;

    /**
     * MDP gross amount.
     */
    @Column(name = "XOLS_MDP_GROSS_AMT", precision = 23, scale = 4)
    private BigDecimal xolsMdpGrossAmt;

    /**
     * Discount amount.
     */
    @Column(name = "XOLS_DISC_AMT", precision = 23, scale = 4)
    private BigDecimal xolsDiscAmt;

    /**
     * Number of reinsurances done.
     */
    @Column(name = "XOLS_NO_REINSTDONE", precision = 22)
    private BigDecimal xolsNoReinstdone;

    /**
     * Reinsurance amount.
     */
    @Column(name = "XOLS_REINSTAT_AMT", precision = 23, scale = 4)
    private BigDecimal xolsReinstatAmt;

    /**
     * Cash call.
     */
    @Column(name = "XOLS_CASH_CALL", precision = 23, scale = 4)
    private BigDecimal xolsCashCall;

    /**
     * Maximum free reinsurance.
     */
    @Column(name = "XOLS_MAX_FREEREIN", precision = 22)
    private BigDecimal xolsMaxFreerein;

    /**
     * Reinsurance change amount.
     */
    @Column(name = "XOLS_REINSTAT_CHANGE_AMT", precision = 23, scale = 5)
    private BigDecimal xolsReinstatChangeAmt;

    /**
     * Discount rate.
     */
    @Column(name = "XOLS_DISC_RATE", precision = 23, scale = 5)
    private BigDecimal xolsDiscRate;

    /**
     * MDP gross amount.
     */
    @Column(name = "XOL_MDP_GROSS_AMT", precision = 22)
    private BigDecimal xolMdpGrossAmt;

    /**
     * XOLVM code.
     */
    @Column(name = "XOLS_XOLVM_CODE", precision = 22)
    private BigDecimal xolsXolvmCode;

    /**
     * Maximum number of reinsurances.
     */
    @Column(name = "XOLS_MAX_NO_REINS", precision = 23, scale = 5)
    private BigDecimal xolsMaxNoReins;

    /**
     * Maximum reinsurance limit.
     */
    @Column(name = "XOLS_MAX_REINST_LIMIT", precision = 23, scale = 5)
    private BigDecimal xolsMaxReinstLimit;

    /**
     * XOL recovered change.
     */
    @Column(name = "XOLS_XOL_RECOVERED_CHANGE", precision = 23, scale = 5)
    private BigDecimal xolsXolRecoveredChange;

    /**
     * Exchange rate type (D = Default, M = Manual).
     */
    @Column(name = "XOLS_EXCH_RATE_TYPE", length = 1, columnDefinition = "VARCHAR2(1) default 'D'")
    private String xolsExchRateType;

    /**
     * Exchange rate.
     */
    @Column(name = "XOLS_EXCH_RATE", precision = 23, scale = 5)
    private BigDecimal xolsExchRate;

    /**
     * Reinsurance limit including free.
     */
    @Column(name = "XOLS_REINSTLIMIT_INCL_FREE", precision = 23, scale = 5)
    private BigDecimal xolsReinstlimitInclFree;
}
