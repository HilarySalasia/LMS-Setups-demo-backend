package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_RGSTD_CLMTS_DV_PERILS table.
 * Likely stores information about perils associated with registered claimant divisions.
 */
@Entity
@Table(name = "GIN_RGSTD_CLMTS_DV_PERILS")
@Data
public class GinRgstdClmtsDvPerils {

    /**
     * Primary key for the registered claimant division peril record.
     */
    @Id
    @Column(name = "RGCDP_CODE", nullable = false, precision = 22)
    private BigDecimal rgCdpCode;

    /**
     * Registered claimant division code.
     */
    @Column(name = "RGCDP_RGCD_CODE", precision = 22)
    private BigDecimal rgCdpRgcdCode;

    /**
     * Claim payment code.
     */
    @Column(name = "RGCDP_CLMP_CODE", precision = 22)
    private BigDecimal rgCdpClmpCode;

    /**
     * Amount associated with the peril.
     */
    @Column(name = "RGCDP_AMOUNT", precision = 23, scale = 5)
    private BigDecimal rgCdpAmount;

    /**
     * Indicates whether liability has been accepted (Y/N).
     */
    @Column(name = "RGCDP_LIABILITY_ACCEPTED", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String rgCdpLiabilityAccepted;

    /**
     * Date liability was accepted.
     */
    @Column(name = "RGCDP_LIAB_ACCEPTED_DATE")
    private LocalDate rgCdpLiabAcceptedDate;

    /**
     * Indicates whether liability acceptance was conditional (Y/N).
     */
    @Column(name = "RGCDP_LIAB_CONDITIONAL", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String rgCdpLiabConditional;
}