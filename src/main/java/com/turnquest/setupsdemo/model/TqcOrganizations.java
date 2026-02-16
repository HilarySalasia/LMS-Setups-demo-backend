package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the TQC_ORGANIZATIONS table.
 * Stores information about organizations within the system.
 */
@Entity
@Table(name = "TQC_ORGANIZATIONS")
@Data
public class TqcOrganizations {

    /**
     * Organization code.
     */
    @Id
    @Column(name = "ORG_CODE", nullable = false)
    private BigDecimal orgCode;

    /**
     * Short description of the organization.
     */
    @Column(name = "ORG_SHT_DESC", nullable = false)
    private String orgShtDesc;

    /**
     * Name of the organization.
     */
    @Column(name = "ORG_NAME", nullable = false)
    private String orgName;

    /**
     * Address of the organization.
     */
    @Column(name = "ORG_ADDRS", nullable = false)
    private String orgAddrs;

    /**
     * Town code associated with the organization.
     */
    @Column(name = "ORG_TWN_CODE", nullable = false)
    private BigDecimal orgTwnCode;

    /**
     * Country code associated with the organization.
     */
    @Column(name = "ORG_COU_CODE", nullable = false)
    private BigDecimal orgCouCode;

    /**
     * Email address of the organization.
     */
    @Column(name = "ORG_EMAIL_ADDRS", nullable = false)
    private String orgEmailAddrs;

    /**
     * Physical address of the organization.
     */
    @Column(name = "ORG_PHY_ADDRS", nullable = false)
    private String orgPhyAddrs;

    /**
     * Currency code associated with the organization.
     */
    @Column(name = "ORG_CUR_CODE", nullable = false)
    private BigDecimal orgCurCode;

    /**
     * ZIP code associated with the organization.
     */
    @Column(name = "ORG_ZIP", nullable = false)
    private String orgZip;

    /**
     * Fax number of the organization.
     */
    @Column(name = "ORG_FAX", nullable = false)
    private String orgFax;

    /**
     * First telephone number of the organization.
     */
    @Column(name = "ORG_TEL1", nullable = false)
    private String orgTel1;

    /**
     * Second telephone number of the organization.
     */
    @Column(name = "ORG_TEL2", nullable = false)
    private String orgTel2;

    /**
     * Motto of the organization.
     */
    @Column(name = "ORG_MOTTO", nullable = false)
    private String orgMotto;

    /**
     * PIN number associated with the organization.
     */
    @Column(name = "ORG_PIN_NO", nullable = false)
    private String orgPinNo;

    /**
     * Education code associated with the organization.
     */
    @Column(name = "ORG_ED_CODE", nullable = false)
    private BigDecimal orgEdCode;

    /**
     * Item account code associated with the organization.
     */
    @Column(name = "ORG_ITEM_ACC_CODE", nullable = false)
    private BigDecimal orgItemAccCode;

    /**
     * Other name associated with the organization.
     */
    @Column(name = "ORG_OTHER_NAME", nullable = false)
    private String orgOtherName;

    /**
     * Organization type.
     */
    @Column(name = "ORG_TYPE", nullable = false)
    private String orgType;

    /**
     * Web branch code associated with the organization.
     */
    @Column(name = "ORG_WEB_BRN_CODE", nullable = false)
    private BigDecimal orgWebBrnCode;

    /**
     * Web address of the organization.
     */
    @Column(name = "ORG_WEB_ADDRS", nullable = false)
    private String orgWebAddrs;

    /**
     * Third telephone number of the organization.
     */
    @Column(name = "ORG_TEL3", nullable = false)
    private String orgTel3;

    /**
     * Fourth telephone number of the organization.
     */
    @Column(name = "ORG_TEL4", nullable = false)
    private String orgTel4;

    /**
     * Director information.
     */
    @Column(name = "ORG_DIRECTORS", nullable = false)
    private String orgDirectors;

    /**
     * Agent code associated with the organization.
     */
    @Column(name = "ORG_AGN_CODE", nullable = false)
    private BigDecimal orgAgnCode;

    /**
     * Language code associated with the organization.
     */
    @Column(name = "ORG_LANG_CODE", nullable = false)
    private BigDecimal orgLangCode;

    /**
     * Avatar information.
     */
    @Column(name = "ORG_AVATAR", nullable = false)
    private String orgAvatar;

    /**
     * Base 64 encoded logo.
     */
    @Column(name = "ORG_LOGO_B64", nullable = false)
    private String orgLogoB64;

    /**
     * Alternate branch code.
     */
    @Column(name = "ORG_ALT_BRN_CODE", nullable = false)
    private BigDecimal orgAltBrnCode;

    /**
     * Status code.
     */
    @Column(name = "ORG_STS_CODE", nullable = false)
    private BigDecimal orgStsCode;

    /**
     * Group logo.
     */
    @Column(name = "ORG_GRP_LOGO", nullable = false)
    private String orgGrpLogo;

    /**
     * Regulator logo.
     */
    @Column(name = "ORG_REGULATOR_LOGO", nullable = false)
    private String orgRegulatorLogo;

    /**
     * Executive director.
     */
    @Column(name = "ORG_EXEC_DIRECTOR", nullable = false)
    private String orgExecDirector;

    /**
     * Managing director.
     */
    @Column(name = "ORG_MANAGING_DIRECTOR", nullable = false)
    private String orgManagingDirector;

    /**
     * Second mobile number.
     */
    @Column(name = "ORG_MOBILE2", nullable = false)
    private String orgMobile2;

    /**
     * Certificate name.
     */
    @Column(name = "ORG_CERT_NAME", nullable = false)
    private String orgCertName;

    /**
     * VAT number.
     */
    @Column(name = "ORG_VAT_NUMBER", nullable = false)
    private String orgVatNumber;

    /**
     * First mobile number.
     */
    @Column(name = "ORG_MOBILE1", nullable = false)
    private String orgMobile1;

    /**
     * Certificate signature.
     */
    @Column(name = "ORG_CERT_SIGN", nullable = false)
    private String orgCertSign;

    /**
     * Bank code.
     */
    @Column(name = "ORG_BNK_CODE", nullable = false)
    private BigDecimal orgBnkCode;

    /**
     * Branch code.
     */
    @Column(name = "ORG_BBR_CODE", nullable = false)
    private BigDecimal orgBbrCode;

    /**
     * Bank account number.
     */
    @Column(name = "ORG_BANK_ACCOUNT_NO", nullable = false)
    private String orgBankAccountNo;

    /**
     * Bank account name.
     */
    @Column(name = "ORG_BANK_ACCOUNT_NAME", nullable = false)
    private String orgBankAccountName;

    /**
     * SWIFT code.
     */
    @Column(name = "ORG_SWIFT_CODE", nullable = false)
    private String orgSwiftCode;

    /**
     * Default organization.
     */
    @Column(name = "ORG_DEFAULT", nullable = false)
    private String orgDefault;

    /**
     * Organization type code.
     */
    @Column(name = "ORG_OTYP_CODE", nullable = false)
    private BigDecimal orgOtypCode;

    /**
     * Organization code.
     */
    @Column(name = "ORG_ORG_CODE", nullable = false)
    private BigDecimal orgOrgCode;

    /**
     * KRA Tax Registration number.
     */
    @Column(name = "ORG_KRA_TAX_REG", nullable = false)
    private String orgKraTaxReg;

    /**
     * Base 64 encoded email logo.
     */
    @Column(name = "ORG_EMAIL_LOGO_B64", nullable = false)
    private String orgEmailLogoB64;

    /**
     * Principle Officer name.
     */
    @Column(name = "ORG_PRINCIPLE_OFFICER_NAME", nullable = false)
    private String orgPrincipleOfficerName;

    /**
     * Contact person.
     */
    @Column(name = "ORG_CONTACT_PERSON", nullable = false)
    private String orgContactPerson;

    /**
     * Logo 4.
     */
    @Column(name = "ORG_LOGO4", nullable = false)
    private String orgLogo4;

    /**
     * Customer care email.
     */
    @Column(name = "ORG_CUS_CARE_EMAIL", nullable = false)
    private String orgCusCareEmail;

    /**
     * First customer care number.
     */
    @Column(name = "ORG_CUS_CARE_NO1", nullable = false)
    private String orgCusCareNo1;

    /**
     * Second customer care number.
     */
    @Column(name = "ORG_CUS_CARE_NO2", nullable = false)
    private String orgCusCareNo2;

    /**
     * Third customer care number.
     */
    @Column(name = "ORG_CUS_CARE_NO3", nullable = false)
    private String orgCusCareNo3;

    /**
     * Stamp.
     */
    @Column(name = "ORG_STAMP", nullable = false)
    private String orgStamp;

    /**
     * Web division code.
     */
    @Column(name = "ORG_WEB_DIV_CODE", nullable = false)
    private BigDecimal orgWebDivCode;

    /**
     * Report logo.
     */
    @Column(name = "ORG_RPT_LOGO", nullable = false)
    private String orgRptLogo;

    /**
     * Customer care name.
     */
    @Column(name = "ORG_CUS_CARE_NAME", nullable = false)
    private String orgCusCareName;

    /**
     * Paybill number.
     */
    @Column(name = "ORG_PAYBILL", nullable = false)
    private String orgPaybill;
}