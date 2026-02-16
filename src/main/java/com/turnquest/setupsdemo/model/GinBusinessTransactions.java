package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_BUSINESS_TRANSACTIONS table.
 * Stores all the transactions that can be done in the system.
 */
@Entity
@Table(name = "GIN_BUSINESS_TRANSACTIONS")
@Data
public class GinBusinessTransactions {

    /**
     * Primary key. Unique transaction code.
     */
    @Id
    @Column(name = "BTR_TRANS_CODE", nullable = false, length = 10)
    private String btrTransCode;

    /**
     * Transaction type.
     */
    @Column(name = "BTR_TRANS_TYPE", nullable = false, length = 50)
    private String btrTransType;

    /**
     * Debit code.
     */
    @Column(name = "BTR_DEBIT_CODE", length = 10)
    private String btrDebitCode;

    /**
     * Credit code.
     */
    @Column(name = "BTR_CREDIT_CODE", length = 10)
    private String btrCreditCode;

    /**
     * Claim or underwriting transaction.
     */
    @Column(name = "BTR_CLM_UW", length = 1)
    private Character btrClmUw;

    /**
     * Endorsement prefix.
     */
    @Column(name = "BTR_ENDOS_PREFIX", length = 26)
    private String btrEndosPrefix;

    /**
     * Alias for the credit code.
     */
    @Column(name = "BTR_CREDIT_CODE_ALIASE", length = 5)
    private String btrCreditCodeAliase;

    /**
     * Alias for the debit code.
     */
    @Column(name = "BTR_DEBIT_CODE_ALIASE", length = 5)
    private String btrDebitCodeAliase;
}
