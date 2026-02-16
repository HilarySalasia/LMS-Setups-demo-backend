package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLM_DRV_DTLS table.
 * Likely stores details about drivers involved in claims.
 */
@Entity
@Table(name = "GIN_CLM_DRV_DTLS")
@Data
public class GinClmDrvDtls {

    /**
     * Primary key for the driver details record.
     */
    @Id
    @Column(name = "CDR_CODE", nullable = false, precision = 22)
    private BigDecimal cdrCode;

    /**
     * Driver's name.
     */
    @Column(name = "CDR_NAME", length = 100)
    private String cdrName;

    /**
     * Driver's gender (M = Male, F = Female).
     */
    @Column(name = "CDR_GENDER", length = 1, columnDefinition = "VARCHAR2(1) default 'M'")
    private String cdrGender;

    /**
     * Driver's date of birth.
     */
    @Column(name = "CDR_DOB")
    private LocalDate cdrDob;

    /**
     * Driver's date of death.
     */
    @Column(name = "CDR_DDL")
    private LocalDate cdrDdl;

    /**
     * Foreign Key from GIN_CLAIM_MASTER_BOOKINGS for claim number.
     */
    @Column(name = "CDR_CMB_CLAIM_NO", length = 50)
    private String cdrCmbClaimNo;

    /**
     * Policy batch number.
     */
    @Column(name = "CDR_CMB_POL_BATCH_NO", precision = 22)
    private BigDecimal cdrCmbPolBatchNo;

    /**
     * Relationship to insured.
     */
    @Column(name = "CDR_RSHIP", length = 20)
    private String cdrRship;

    /**
     * IPU code.
     */
    @Column(name = "CDR_IPU_CODE", precision = 22)
    private BigDecimal cdrIpuCode;

    /**
     * Driver's PIN.
     */
    @Column(name = "CDR_PIN", length = 30)
    private String cdrPin;

    /**
     * Driver's ID number.
     */
    @Column(name = "CDR_ID_NO", length = 30)
    private String cdrIdNo;

    /**
     * Driver's passport number.
     */
    @Column(name = "CDR_PASSPORT_NO", length = 30)
    private String cdrPassportNo;

    /**
     * Driver's driving license number.
     */
    @Column(name = "CDR_DRIVING_LICENSE_NO", length = 30)
    private String cdrDrivingLicenseNo;

    /**
     * Driver's telephone number.
     */
    @Column(name = "CDR_TEL", precision = 22)
    private BigDecimal cdrTel;

    /**
     * Driver's occupation.
     */
    @Column(name = "CDR_OCCUPATION", length = 100)
    private String cdrOccupation;

    /**
     * Driver's experience in years.
     */
    @Column(name = "CDR_DRIVER_EXPERIENCE", precision = 22)
    private BigDecimal cdrDriverExperience;

    /**
     * Indicates whether the driver is a third party (Y/N).
     */
    @Column(name = "CDR_THIRD_PARTY_SELF", length = 1)
    private String cdrThirdPartySelf;

    /**
     * Claim peril code.
     */
    @Column(name = "CDR_CLMP_CODE", precision = 22)
    private BigDecimal cdrClmpCode;

    /**
     * Driver's email address.
     */
    @Column(name = "CDR_EMAIL_ADDRS", length = 25)
    private String cdrEmailAddrs;

    /**
     * Driver's SMS telephone number.
     */
    @Column(name = "CDR_SMS_TEL", length = 25)
    private String cdrSmsTel;

    /**
     * Driver code.
     */
    @Column(name = "CDR_DR_CODE", precision = 22)
    private BigDecimal cdrDrCode;

    /**
     * Module.
     */
    @Column(name = "CDR_MODULE", length = 1)
    private String cdrModule;

    /**
     * Insured driver.
     */
    @Column(name = "CDR_INSURED_DRIVER", length = 100)
    private String cdrInsuredDriver;
}