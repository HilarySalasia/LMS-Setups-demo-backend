package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_BPM_TICKETS table.
 * Likely stores information about BPM tickets used for tracking workflow tasks.
 */
@Entity
@Table(name = "GIN_BPM_TICKETS")
@Data
public class GinBpmTickets {

    /**
     * Primary key for the BPM ticket record.
     */
    @Id
    @Column(name = "TCKT_CODE", nullable = false, precision = 22)
    private BigDecimal tcktCode;

    /**
     * System code associated with the ticket.
     */
    @Column(name = "TCKT_SYS_CODE", nullable = false, precision = 22)
    private BigDecimal tcktSysCode;

    /**
     * System module for the ticket.
     */
    @Column(name = "TCKT_SYS_MODULE", nullable = false, length = 50, columnDefinition = "VARCHAR2(50) default 'U'")
    private String tcktSysModule;

    /**
     * Client code associated with the ticket.
     */
    @Column(name = "TCKT_CLNT_CODE", precision = 22)
    private BigDecimal tcktClntCode;

    /**
     * Agent code associated with the ticket.
     */
    @Column(name = "TCKT_AGN_CODE", precision = 22)
    private BigDecimal tcktAgnCode;

    /**
     * Policy code associated with the ticket.
     */
    @Column(name = "TCKT_POL_CODE", precision = 22)
    private BigDecimal tcktPolCode;

    /**
     * Policy number associated with the ticket.
     */
    @Column(name = "TCKT_POL_NO", length = 35)
    private String tcktPolNo;

    /**
     * Claim number associated with the ticket.
     */
    @Column(name = "TCKT_CLM_NO", length = 35)
    private String tcktClmNo;

    /**
     * Quotation code associated with the ticket.
     */
    @Column(name = "TCKT_QUOT_CODE", precision = 22)
    private BigDecimal tcktQuotCode;

    /**
     * User who created the ticket.
     */
    @Column(name = "TCKT_BY", length = 35)
    private String tcktBy;

    /**
     * Date the ticket was created.
     */
    @Column(name = "TCKT_DATE")
    private LocalDate tcktDate;

    /**
     * Process ID associated with the ticket.
     */
    @Column(name = "TCKT_PROCESS_ID", length = 50)
    private String tcktProcessId;

    /**
     * Quotation number associated with the ticket.
     */
    @Column(name = "TCKT_QUO_NO", length = 100)
    private String tcktQuoNo;

    /**
     * Sprsa code associated with the ticket.
     */
    @Column(name = "TCKT_SPRSA_CODE", precision = 22)
    private BigDecimal tcktSprsaCode;

    /**
     * Endorsement code associated with the ticket.
     */
    @Column(name = "TCKT_ENDR_CODE", precision = 22)
    private BigDecimal tcktEndrCode;

    /**
     * Product type associated with the ticket.
     */
    @Column(name = "TCKT_PROD_TYPE", length = 100)
    private String tcktProdType;

    /**
     * User or group the ticket is assigned to.
     */
    @Column(name = "TCKT_TO", length = 100)
    private String tcktTo;

    /**
     * Remarks related to the ticket.
     */
    @Column(name = "TCKT_REMARKS", length = 300)
    private String tcktRemarks;

    /**
     * Endorsement associated with the ticket.
     */
    @Column(name = "TCKT_ENDORSEMENT", length = 25)
    private String tcktEndorsement;

    /**
     * Transaction number.
     */
    @Column(name = "TCKT_TRANSNO", precision = 22)
    private BigDecimal tcktTransno;

    /**
     * Indicates whether the ticket is active (Y/N).
     */
    @Column(name = "TCKT_ACTIVE", length = 10, columnDefinition = "VARCHAR2(10) default 'Y'")
    private String tcktActive;

    /**
     * Property code.
     */
    @Column(name = "TCKT_PRP_CODE", precision = 22)
    private BigDecimal tcktPrpCode;

    /**
     * External reference number.
     */
    @Column(name = "TCKT_EXTERN_REF_NO", length = 100)
    private String tcktExternRefNo;

    /**
     * Ticket type (S = Standard, A = Adhoc).
     */
    @Column(name = "TCKT_TYPE", length = 1, columnDefinition = "VARCHAR2(1)  default 'S'")
    private String tcktType;

    /**
     * Claim type.
     */
    @Column(name = "TCKT_CLA_TYPE", length = 5)
    private String tcktClaType;

    /**
     * Adhoc name.
     */
    @Column(name = "TCKT_ADHOC_NAME", length = 100)
    private String tcktAdhocName;

    /**
     * Transaction effective date.
     */
    @Column(name = "TCKT_TRAN_EFF_DATE")
    private LocalDate tcktTranEffDate;

    /**
     * GGT number.
     */
    @Column(name = "TCKT_GGT_NO", precision = 22)
    private BigDecimal tcktGgtNo;

    /**
     * Claim transaction number.
     */
    @Column(name = "TCKT_CLAIM_TRANS_NO", precision = 22)
    private BigDecimal tcktClaimTransNo;

    /**
     * Claim transaction type.
     */
    @Column(name = "TCKT_CLAM_TRANS_TYPE", length = 20)
    private String tcktClamTransType;

    /**
     * Group user.
     */
    @Column(name = "TCKT_GROUP_USER", length = 30)
    private String tcktGroupUser;

    /**
     * Transaction number.
     */
    @Column(name = "TCKT_TRANS_NO", precision = 22)
    private BigDecimal tcktTransNo;

    /**
     * Reassigned date.
     */
    @Column(name = "TCKT_REASSIGNED_DATE")
    private LocalDate tcktReassignedDate;

    /**
     * Indicates whether the ticket has been reassigned (Y/N).
     */
    @Column(name = "TCKT_REASSIGNED", length = 1)
    private String tcktReassigned;

    /**
     * Ticket description.
     */
    @Column(name = "TCKT_DESC", length = 200)
    private String tcktDesc;

    /**
     * End date.
     */
    @Column(name = "TCKT_END_DATE")
    private LocalDate tcktEndDate;

    /**
     * Coinsurance from.
     */
    @Column(name = "TCKT_COIN_FROM", length = 40)
    private String tcktCoinFrom;

    /**
     * Coinsurance to.
     */
    @Column(name = "TCKT_COIN_TO", length = 40)
    private String tcktCoinTo;
}