package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_BPM_TICKET_REMARKS table.
 * Stores remarks related to BPM tickets.
 */
@Entity
@Table(name = "GIN_BPM_TICKET_REMARKS")
@Data
public class GinBpmTicketRemarks {

    /**
     * Primary key for the ticket remark record.
     */
    @Id
    @Column(name = "TCKTR_CODE", nullable = false, precision = 22)
    private BigDecimal tcktrCode;

    /**
     * Remarks related to the ticket.
     */
    @Column(name = "TCKTR_REMARKS", length = 300)
    private String tcktrRemarks;

    /**
     * User who added the remark.
     */
    @Column(name = "TCKTR_BY", length = 35)
    private String tcktrBy;

    /**
     * Date the remark was added.
     */
    @Column(name = "TCKTR_DATE")
    private LocalDate tcktrDate;

    /**
     * Foreign key from GIN_BPM_TICKETS, representing the ticket code.
     */
    @Column(name = "TCKTR_TCKT_CODE", nullable = false, precision = 22)
    private BigDecimal tcktrTcktCode;
}
