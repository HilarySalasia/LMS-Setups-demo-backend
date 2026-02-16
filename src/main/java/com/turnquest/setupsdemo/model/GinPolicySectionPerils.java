package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;

/**
 * This table stores details of perils associated with specific subclasses, sections, and policies,
 * allowing for policy-specific overrides of peril details from the setup values in
 * GIN_SUBCL_SCTION_PERILS.
 */
@Entity
@Table(name = "GIN_POLICY_SECTION_PERILS")
@Data
public class GinPolicySectionPerils {
    /**
 * Primary key for the table
 */
@Id
@Column(name = "PSPR_CODE", nullable = false, precision = 22)
private Long psprCode; // PK

/**
 * Foreign key from GIN\_SUBCL\_SCTION\_PERILS
 */
@Column(name = "PSPR_SSPR_CODE", precision = 22)
private Long psprSsprCode; // FK FROM GIN_SUBCL_SCTION_PERILS

/**
 * Foreign key from GIN\_POLICIES
 */
@Column(name = "PSPR_POL_BATCH_NO", nullable = false, precision = 22)
private Long psprPolBatchNo; // FK FROM GIN_POLICIES

/**
 * Foreign key from GIN\_SUB\_CLASSES
 */
@Column(name = "PSPR_SCL_CODE", nullable = false, precision = 22)
private Long psprSclCode; //  FK FROM GIN_SUB_CLASSES

/**
 * Foreign key from GIN\_SECTIONS
 */
@Column(name = "PSPR_SECT_CODE", nullable = false, precision = 22)
private Long psprSectCode; // FK FROM GIN_SECTIONS

/**
 * Section short description
 */
@Column(name = "PSPR_SECT_SHT_DESC", length = 15)
private String psprSectShtDesc; // SECTION SHORT DESCRIPTION

/**
 * Foreign key from GIN\_PERILS
 */
@Column(name = "PSPR_PER_CODE", nullable = false, precision = 22)
private Long psprPerCode; // FK FROM GIN_PERILS

/**
 * Peril short description
 */
@Column(name = "PSPR_PER_SHT_DESC", length = 15)
private String psprPerShtDesc; // PERIL SHORT DESCRIPTION

/**
 * Not used
 */
@Column(name = "PSPR_MANDATORY", length = 1)
private String psprMandatory; // NOT USED

/**
 * Only specified if PSPR\_SI\_OR\_LIMIT is PL. Max payable
 */
@Column(name = "PSPR_PERIL_LIMIT", precision = 22, scale = 5)
private BigDecimal psprPerilLimit; // ONLY SPECIFIED IF PSPR_SI_OR_LIMIT IS PL. MAX PAYABLE

/**
 * Peril pays insured (SL)/third party (TP) or both (BO)
 */
@Column(name = "PSPR_PERIL_TYPE", nullable = false, length = 2)
private String psprPerilType; // PERIL PAYS INSURED(SL)/THIRD PARTY(TP) OR BOTH(BO)

/**
 * How the peril limit is determined - sum insured (SI)/section limit (SL)/peril limit (PL)/unlimited (UN)
 */
@Column(name = "PSPR_SI_OR_LIMIT", length = 3)
private String psprSiOrLimit; // HOW THE PERIL LIMIT IS DETERMINED - SUM INSURED(SI)/SECTION LIMIT(SL)/PERIL LIMIT(PL)/UNLIMITED(UN)

/**
 * Foreign key from
 */
@Column(name = "PSPR_SEC_CODE", nullable = false, precision = 15)
private Long psprSecCode; // FK FROM

/**
 * SI excess type (PCT[P] or AMT[A] or TABLE[T]). If PSPR\_DEPEND\_LOSS\_TYPE is NO(N) then applies for all loss types else PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) then applies for total loss
 */
@Column(name = "PSPR_EXCESS_TYPE", nullable = false, length = 1)
private String psprExcessType; // SI EXCESS TYPE (PCT[P] OR AMT[A] OR TABLE[T]). IF PSPR_DEPEND_LOSS_TYPE  IS NO(N)   THEN APPLIES FOR ALL LOSS TYPES ELSE PSPR_DEPEND_LOSS_TYPE  IS YES(Y) THEN APPLIES FOR TOTAL LOSS

/**
 * SI excess value depends on excess type. If PSPR\_DEPEND\_LOSS\_TYPE is NO(N) then applies for all loss types else PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) then applies for total loss
 */
@Column(name = "PSPR_EXCESS", precision = 22, scale = 5)
private BigDecimal psprExcess; // SI EXCESS  VALUE DEPENDS ON EXCESS TYPE. IF PSPR_DEPEND_LOSS_TYPE  IS NO(N)   THEN APPLIES FOR ALL LOSS TYPES ELSE PSPR_DEPEND_LOSS_TYPE IS YES(Y) THEN APPLIES FOR TOTAL LOSS

/**
 * SI excess min value. If PSPR\_DEPEND\_LOSS\_TYPE is NO(N) then applies for all loss types else PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) then applies for total loss
 */
@Column(name = "PSPR_EXCESS_MIN", precision = 22, scale = 5)
private BigDecimal psprExcessMin; // SI EXCESS  MIN VALUE. IF PSPR_DEPEND_LOSS_TYPE  IS NO(N)   THEN APPLIES FOR ALL LOSS TYPES ELSE PSPR_DEPEND_LOSS_TYPE  IS YES(Y) THEN APPLIES FOR TOTAL LOSS

/**
 * SI excess max value. If PSPR\_DEPEND\_LOSS\_TYPE is NO(N) then applies for all loss types else PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) then applies for total loss
 */
@Column(name = "PSPR_EXCESS_MAX", precision = 22, scale = 5)
private BigDecimal psprExcessMax; // SI EXCESS  MAX VALUE. IF PSPR_DEPEND_LOSS_TYPE  IS NO(N)   THEN APPLIES FOR ALL LOSS TYPES ELSE PSPR_DEPEND_LOSS_TYPE  IS YES(Y) THEN APPLIES FOR TOTAL LOSS

/**
 * Cover on peril section expires upon claiming on this peril
 */
@Column(name = "PSPR_EXPIRE_ON_CLAIM", length = 1)
private String psprExpireOnClaim; // COVER ON PERIL SECTION EXPIRES UPON CLAIMING ON THIS PERIL

/**
 * Foreign key from GIN\_BINDERS
 */
@Column(name = "PSPR_BIND_CODE", precision = 22)
private Long psprBindCode; // FK FROM GIN_BINDERS

/**
 * Person max payable limit
 */
@Column(name = "PSPR_PERSON_LIMIT", precision = 22, scale = 5)
private BigDecimal psprPersonLimit; // PERSON MAX PAYABLE LIMIT

/**
 * Claim excess value depends on claim excess type. If PSPR\_DEPEND\_LOSS\_TYPE is NO(N) then applies for all loss types else loss type is YES(Y) then applies for total loss
 */
@Column(name = "PSPR_CLAIM_LIMIT", precision = 22, scale = 5)
private BigDecimal psprClaimLimit; // CLAIM EXCESS  VALUE DEPENDS ON CLAIM EXCESS TYPE. IF PSPR_DEPEND_LOSS_TYPE IS NO(N)   THEN APPLIES FOR ALL LOSS TYPES ELSE LOSS TYPE IS YES(Y) THEN APPLIES FOR TOTAL LOSS

/**
 * Peril description
 */
@Column(name = "PSPR_DESC", length = 250)
private String psprDesc; // PERIL DESCRIPTION

/**
 * Binder type
 */
@Column(name = "PSPR_BIND_TYPE", length = 1)
private String psprBindType; // BINDER TYPE

/**
 * Limit multiplier
 */
@Column(name = "PSPR_SALVAGE_PCT", precision = 23, scale = 5)
private BigDecimal psprSalvagePct; // LIMIT MULTIPLIER

/**
 * Redundant
 */
@Column(name = "PSPR_DEPRECIATION_PCT", precision = 23, scale = 5)
private BigDecimal psprDepreciationPct; // REDUDANT

/**
 * SI excess type (PCT[P] or AMT[A] or TABLE[T]). Where loss type is YES(Y). Partial loss
 */
@Column(name = "PSPR_TL_EXCESS_TYPE", length = 1)
private String psprTlExcessType; // SI EXCESS TYPE (PCT[P] OR AMT[A] OR TABLE[T]).WHERE LOSS TYPE IS YES(Y). PARTIAL LOSS

/**
 * SI excess value depends on TL\_EXCESS\_TYPE. Only applicable for PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) and applies for partial loss
 */
@Column(name = "PSPR_TL_EXCESS", precision = 23, scale = 5)
private BigDecimal psprTlExcess; // SI EXCESS  VALUE DEPENDS ON TL_EXCESS_TYPE.ONLY APPLICABLE FOR PSPR_DEPEND_LOSS_TYPE IS YES(Y) AND APPLIES FOR PARTIAL LOSS

/**
 * SI excess min value. Only applicable if PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) and applies for partial loss
 */
@Column(name = "PSPR_TL_EXCESS_MIN", precision = 23, scale = 5)
private BigDecimal psprTlExcessMin; // SI EXCESS  MIN VALUE. ONLY APPLICABLE IF PSPR_DEPEND_LOSS_TYPE  IS YES(Y) AND  APPLIES FOR PARTIAL LOSS
    /**
 * SI excess max value. Only applicable if PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) and applies for partial loss
 */
@Column(name = "PSPR_TL_EXCESS_MAX", precision = 23, scale = 5)
private BigDecimal psprTlExcessMax;

/**
 * Claim excess type (PCT[P] or AMT[A] or TABLE[T]). Only applicable where PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) and applies for partial loss
 */
@Column(name = "PSPR_PL_EXCESS_TYPE", length = 1)
private String psprPlExcessType;

/**
 * Claim excess value depends on PSPR\_PL\_EXCESS\_TYPE. Only applicable where PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) and applies for partial loss
 */
@Column(name = "PSPR_PL_EXCESS", precision = 23, scale = 5)
private BigDecimal psprPlExcess;

/**
 * Claim excess min value. Only applicable where PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) and applies for partial loss
 */
@Column(name = "PSPR_PL_EXCESS_MIN", precision = 23, scale = 5)
private BigDecimal psprPlExcessMin;

/**
 * Claim excess max value. Only applicable where PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) and applies for partial loss
 */
@Column(name = "PSPR_PL_EXCESS_MAX", precision = 23, scale = 5)
private BigDecimal psprPlExcessMax;

/**
 * Claim excess min value. If PSPR\_DEPEND\_LOSS\_TYPE is NO(N) then applies for all loss types else PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) then applies for total loss
 */
@Column(name = "PSPR_CLAIM_EXCESS_MIN", precision = 23, scale = 5)
private BigDecimal psprClaimExcessMin;

/**
 * Claim excess max value. If PSPR\_DEPEND\_LOSS\_TYPE is NO(N) then applies for all loss types else PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) then applies for total loss
 */
@Column(name = "PSPR_CLAIM_EXCESS_MAX", precision = 23, scale = 5)
private BigDecimal psprClaimExcessMax;

/**
 * Excess depends on type of loss (YES [Y] or NO [N])
 */
@Column(name = "PSPR_DEPEND_LOSS_TYPE", length = 1)
private String psprDependLossType;

/**
 * Claim excess type (PCT[P] or AMT[A] or TABLE[T]). If PSPR\_DEPEND\_LOSS\_TYPE is NO(N) then applies for all loss types else PSPR\_DEPEND\_LOSS\_TYPE is YES(Y) then applies for total loss
 */
@Column(name = "PSPR_CLAIM_EXCESS_TYPE", nullable = false, length = 1)
private String psprClaimExcessType;

/**
 * Benefit % per period setup ie [PRD:%] =[6:100][5:50]
 */
@Column(name = "PSPR_TTD_BEN_PCTS", length = 50)
private String psprTtdBenPcts;

/**
 * Foreign key from GIN\_SUBCL\_SCTION\_PERILS\_MAP
 */
@Column(name = "PSPR_SSPRM_CODE", precision = 23)
private Long psprSsprmCode;
}