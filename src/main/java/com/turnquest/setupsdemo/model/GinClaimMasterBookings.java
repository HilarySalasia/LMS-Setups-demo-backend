package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Store claims details
 */
@Entity
@Table(name = "GIN_CLAIM_MASTER_BOOKINGS")
@Data
public class GinClaimMasterBookings {
    /**
 * Unique Claim Number per claim. Primary Key
 */
@Id
@Column(name = "CMB_CLAIM_NO", nullable = false, length = 40)
private String cmbClaimNo;

/**
 * Date claim booked
 */
@Column(name = "CMB_CLAIM_DATE", nullable = false)
private Date cmbClaimDate;

/**
 * Location where the loss occurred
 */
@Column(name = "CMB_LOCATION", length = 100)
private String cmbLocation;

/**
 * Why the loss occurred
 */
@Column(name = "CMB_CAUSE_OF_LOSS", length = 50)
private String cmbCauseOfLoss;

/**
 * Date and time when the loss occurred
 */
@Column(name = "CMB_LOSS_DATE_TIME")
private Date cmbLossDateTime;

/**
 * Sub class Foreign key from \[SUB CLASSES\]
 */
@Column(name = "CMB_SCL_CODE", nullable = false, precision = 22)
private Long cmbSclCode;

/**
 * Policy number
 */
@Column(name = "CMB_POL_POLICY_NO", nullable = false, length = 30)
private String cmbPolPolicyNo;

/**
 * Risk endorsement active at the date/time of loss
 */
@Column(name = "CMB_POL_REN_ENDOS_NO", nullable = false, length = 30)
private String cmbPolRenEndosNo;

/**
 * Foreign Key from \[GIN\_POLICIES\] of the endorsement active at the time of loss
 */
@Column(name = "CMB_POL_BATCH_NO", nullable = false, precision = 22)
private Long cmbPolBatchNo;

/**
 * Foreign key for the Insured from \[TQC\_CLIENTS\]
 */
@Column(name = "CMB_PRP_CODE", precision = 22)
private Long cmbPrpCode;

/**
 * Foreign Key from \[GIN\_EVENTS\] representing the event that led to the claim. Used to group claims that occurred due to a single event. The event is recorded in the \[GIN\_EVENTS\] table and selected for all the claims that arose from the event.
 */
@Column(name = "CMB_EVE_CODE", nullable = false, precision = 22)
private Long cmbEveCode;

/**
 * Foreign key from \[GIN\_INSURED\_PROPERTY\_UNDS\] representing the risk record active at the time of loss
 */
@Column(name = "CMB_IPU_CODE", nullable = false, precision = 22)
private Long cmbIpuCode;

/**
 * ID of the risk from the risks table
 */
@Column(name = "CMB_IPU_PROPERTY_ID", length = 60)
private String cmbIpuPropertyId;

/**
 * Total claim amount
 */
@Column(name = "CMB_TOT_CLM_AMT", precision = 27, scale = 5)
private BigDecimal cmbTotClmAmt;

/**
 * Loss description
 */
@Column(name = "CMB_LOSS_DESC", length = 1000)
private String cmbLossDesc;

/**
 * Date which the police were informed about the loss
 */
@Column(name = "CMB_POLICE_INFO_DT")
private Date cmbPoliceInfoDt;

/**
 * Address of the police who were informed
 */
@Column(name = "CMB_POLICE_ADDR", length = 30)
private String cmbPoliceAddr;

/**
 * Recovery measures taken
 */
@Column(name = "CMB_RECOV_STEP", length = 30)
private String cmbRecovStep;

/**
 * One guarding the risk at the time of the loss
 */
@Column(name = "CMB_GUARDS", length = 30)
private String cmbGuards;

/**
 * Any person suspected to have caused the loss
 */
@Column(name = "CMB_SUSPECT", length = 30)
private String cmbSuspect;

/**
 * Repair response
 */
@Column(name = "CMB_REPAIR_RESPON", length = 15)
private String cmbRepairRespon;

/**
 * Damage Prevented
 */
@Column(name = "CMB_DMG_PREVENT", length = 20)
private String cmbDmgPrevent;

/**
 * Claim status whether paid or not. P for paid and N for not paid
 */
@Column(name = "CMB_CLAIM_STATUS", length = 1)
private String cmbClaimStatus;

/**
 * Claim time
 */
@Column(name = "CMB_TIME", length = 8)
private String cmbTime;

/**
 * A flag to indicate whether the claim was rejected or not
 */
@Column(name = "CMB_REJECTED", length = 1)
private String cmbRejected;

/**
 * If rejected, this is used to indicate the reason why it was rejected
 */
@Column(name = "CMB_REASONS_REJECTED", length = 500)
private String cmbReasonsRejected;

/**
 * Redundant
 */
@Column(name = "CMB_AMT_OWED_DEFAULTER", precision = 22, scale = 5)
private BigDecimal cmbAmtOwedDefaulter;

/**
 * Redundant
 */
@Column(name = "CMB_DEFAULTER_DEFECTS", length = 15)
private String cmbDefaulterDefects;

/**
 * Date that the claim was reported
 */
@Column(name = "CMB_DT_REPORTED")
private Date cmbDtReported;

/**
 * The one who reported the claim
 */
@Column(name = "CMB_REPORTER", length = 15)
private String cmbReporter;

/**
 * Other cover details to be included
 */
@Column(name = "CMB_OTHER_COVER_DETAILS", length = 15)
private String cmbOtherCoverDetails;

/**
 * The one who booked that claim
 */
@Column(name = "CMB_BOOKED_BY", length = 100)
private String cmbBookedBy;

/**
 * Date for which the claim was booked
 */
@Column(name = "CMB_BOOKED_DATE")
private Date cmbBookedDate;

    /**
 * Maximum reserve amount
 */
@Column(name = "CMB_MAX_RESERVE_AMT", precision = 22, scale = 5)
private BigDecimal cmbMaxReserveAmt;

/**
 * Police OB number
 */
@Column(name = "CMB_OB_NO", length = 15)
private String cmbObNo;

/**
 * Claim section code
 */
@Column(name = "CMB_SECT_CODE", precision = 22)
private Long cmbSectCode;

/**
 * Section short description
 */
@Column(name = "CMB_SECT_SHT_DESC", length = 15)
private String cmbSectShtDesc;

/**
 * Claim peril code
 */
@Column(name = "CMB_PER_CODE", precision = 22)
private Long cmbPerCode;

/**
 * Peril short description
 */
@Column(name = "CMB_PER_SHT_DESC", length = 50)
private String cmbPerShtDesc;

/**
 * Client policy number
 */
@Column(name = "CMB_POL_CLIENT_POLICY_NO", length = 30)
private String cmbPolClientPolicyNo;

/**
 * Unique identifier for every risk in the system
 */
@Column(name = "CMB_IPU_ID", precision = 22)
private Long cmbIpuId;

/**
 * Close date of the claim
 */
@Column(name = "CMB_CLOSE_DATE")
private Date cmbCloseDate;

/**
 * Status date
 */
@Column(name = "CMB_STATUS_DATE")
private Date cmbStatusDate;

/**
 * Gross commission retention
 */
@Column(name = "CMB_GROSS_COM_RETENTION", precision = 22, scale = 5)
private BigDecimal cmbGrossComRetention;

/**
 * Net commission retention
 */
@Column(name = "CMB_COMP_NET_RETENTION", precision = 22, scale = 5)
private BigDecimal cmbCompNetRetention;

/**
 * Foreign key from the \[GIN\_PRODUCTS\]
 */
@Column(name = "CMB_PRO_CODE", nullable = false, precision = 22)
private Long cmbProCode;

/**
 * Causation foreign key from \[GIN\_Claim\_Clauses\]
 */
@Column(name = "CMB_CLMC_CODE", precision = 22)
private Long cmbClmcCode;

/**
 * A flag to indicate whether it is authorised or not
 */
@Column(name = "CMB_LOP_AUTHORISED", length = 1)
private String cmbLopAuthorised;

/**
 * Show who authorised the claim
 */
@Column(name = "CMB_LOP_AUTHORISED_BY", length = 30)
private String cmbLopAuthorisedBy;

/**
 * Foreign key for unique insured risk id
 */
@Column(name = "CMB_IPU_POLIN_CODE", precision = 22)
private Long cmbIpuPolinCode;

/**
 * Foreign key for TQC\_CURRENCIES unique currency code
 */
@Column(name = "CMB_CUR_CODE", nullable = false, precision = 22)
private Long cmbCurCode;

/**
 * Currency symbol
 */
@Column(name = "CMB_CUR_SYMBOL", length = 15)
private String cmbCurSymbol;

/**
 * Third party code if a third party is involved
 */
@Column(name = "CMB_TPI_CODE", precision = 22)
private Long cmbTpiCode;

/**
 * Catastrophe code
 */
@Column(name = "CMB_CAT_CODE", precision = 22)
private Long cmbCatCode;

/**
 * Catastrophe short description
 */
@Column(name = "CMB_CAT_SHT_DESC", length = 15)
private String cmbCatShtDesc;

/**
 * Foreign key from GIN\_CLAIM\_CLAUSES for catastrophe short description
 */
@Column(name = "CMB_CLMC_CAS_SHT_DESC", length = 15)
private String cmbClmcCasShtDesc;

/**
 * Retention rate
 */
@Column(name = "CMB_COMP_RETENTION_RATE", precision = 22, scale = 5)
private BigDecimal cmbCompRetentionRate;

/**
 * Agent code
 */
@Column(name = "CMB_AGNT_AGENT_CODE", precision = 22)
private Long cmbAgntAgentCode;

/**
 * Underwriting year
 */
@Column(name = "CMB_UW_YEAR", nullable = false, precision = 22)
private Long cmbUwYear;

/**
 * Product short description
 */
@Column(name = "CMB_PRO_SHT_DESC", length = 15)
private String cmbProShtDesc;

/**
 * Redundant
 */
@Column(name = "CMB_CHANGE_EVE_CODE", precision = 22)
private Long cmbChangeEveCode;

/**
 * Redundant
 */
@Column(name = "CMB_CHANGE_CAT_CODE", precision = 22)
private Long cmbChangeCatCode;

    /**
 * Inception date of the claim
 */
@Column(name = "CMB_POL_INCEPT_DATE")
private Date cmbPolInceptDate;

/**
 * Claim underwriting year
 */
@Column(name = "CMB_POL_INCEPT_UWYR", precision = 22)
private Long cmbPolInceptUwyr;

/**
 * Event short description
 */
@Column(name = "CMB_EVE_SHT_DESC", length = 30)
private String cmbEveShtDesc;

/**
 * Its a flag to indicate whether there is coinsurance involved or not
 */
@Column(name = "CMB_COINSURANCE", length = 1)
private String cmbCoinsurance;

/**
 * Its a flag to indicate whether the insurance company is a leader or a follower
 */
@Column(name = "CMB_COINSURE_LEADER", length = 1)
private String cmbCoinsureLeader;

/**
 * Coinsurance share
 */
@Column(name = "CMB_COINSURANCE_SHARE", precision = 22, scale = 5)
private BigDecimal cmbCoinsuranceShare;

/**
 * Coinsurance Pay type
 */
@Column(name = "CMB_COIN_PAY_TYPE", length = 1)
private String cmbCoinPayType;

/**
 * Policy type
 */
@Column(name = "CMB_POL_POLICY_TYPE", length = 1)
private String cmbPolPolicyType;

/**
 * Branch code
 */
@Column(name = "CMB_BRN_CODE", precision = 22)
private Long cmbBrnCode;

/**
 * Insured short description
 */
@Column(name = "CMB_PRP_SHT_DESC", length = 30)
private String cmbPrpShtDesc;

/**
 * Client old claim number
 */
@Column(name = "CMB_OLD_CLAIM_NO", length = 40)
private String cmbOldClaimNo;

/**
 * Claim clause description
 */
@Column(name = "CMB_CLMC_DESC", length = 60)
private String cmbClmcDesc;

/**
 * Client code
 */
@Column(name = "CMB_CLIENT_PRP_CODE", precision = 22)
private Long cmbClientPrpCode;

/**
 * Client short description
 */
@Column(name = "CMB_CLIENT_SHT_DESC", length = 30)
private String cmbClientShtDesc;

/**
 * Cover short description
 */
@Column(name = "CMB_COVT_SHT_DESC", length = 50)
private String cmbCovtShtDesc;

/**
 * Its a flag to indicate if the claim was done in the system or it was loaded, Y for loaded and N for not loaded
 */
@Column(name = "CMB_POL_LOADED", length = 1)
private String cmbPolLoaded;

/**
 * Redundant
 */
@Column(name = "CMB_PROCESS_RV", precision = 22)
private Long cmbProcessRv;

/**
 * Current reserve
 */
@Column(name = "CMB_CURR_RESERVE", precision = 25, scale = 2)
private BigDecimal cmbCurrReserve;

/**
 * Cover type code
 */
@Column(name = "CMB_COVT_CODE", precision = 22)
private Long cmbCovtCode;

/**
 * Branch short description
 */
@Column(name = "CMB_BRN_SHT_DESC", length = 15)
private String cmbBrnShtDesc;

/**
 * Old Policy No
 */
@Column(name = "CMB_OLD_POLICY_NO", length = 20)
private String cmbOldPolicyNo;

/**
 * Date the claim is authorised
 */
@Column(name = "CMB_LOP_AUTHORISED_DATE")
private Date cmbLopAuthorisedDate;

/**
 * Whether the claimant should admit liability or not
 */
@Column(name = "CMB_ADMIT_LIABILITY", nullable = false, length = 2)
private String cmbAdmitLiability;

/**
 * 'N' - NO, 'D' - DONE, 'U' - UNDONE
 */
@Column(name = "CMB_BOC_STATUS", length = 1)
private String cmbBocStatus;

/**
 * Loss time
 */
@Column(name = "CMB_LOSS_TIME")
private Date cmbLossTime;

/**
 * Ob Date
 */
@Column(name = "CMB_OB_DATE")
private Date cmbObDate;

/**
 * Indicates if police information is available for the claim
 */
@Column(name = "CMB_POLICE_INFORMED", length = 1)
private String cmbPoliceInformed;

/**
 * Police Station
 */
@Column(name = "CMB_POLICE_STATION", length = 60)
private String cmbPoliceStation;

/**
 * Ob Number
 */
@Column(name = "CMB_OB_NUMBER", length = 60)
private String cmbObNumber;

/**
 * Instg Last Name
 */
@Column(name = "CMB_INSTG_LAST_NAME", length = 100)
private String cmbInstgLastName;

/**
 * Instg Other Names
 */
@Column(name = "CMB_INSTG_OTHER_NAMES", length = 100)
private String cmbInstgOtherNames;

/**
 * Instg Tel No
 */
@Column(name = "CMB_INSTG_TEL_NO", precision = 22)
private Long cmbInstgTelNo;

/**
 * Abstract No
 */
@Column(name = "CMB_ABSTRACT_NO", length = 60)
private String cmbAbstractNo;

/**
 * Old Claim Number
 */
@Column(name = "CMB_OLD_CLAIM_NUMBER", length = 15)
private String cmbOldClaimNumber;

/**
 * Div Code
 */
@Column(name = "CMB_DIV_CODE", precision = 22)
private Long cmbDivCode;

/**
 * Third party recovery
 */
@Column(name = "CMB_TP_RECOVER", length = 1)
private String cmbTpRecover;

/**
 * Excess recovery
 */
@Column(name = "CMB_EXS_RECOVER", length = 1)
private String cmbExsRecover;

/**
 * Salvage recovery
 */
@Column(name = "CMB_SLVG_RECOVER", length = 1)
private String cmbSlvgRecover;

/**
 * Insured risk value
 */
@Column(name = "CMB_IPU_VALUE", precision = 20, scale = 5)
private BigDecimal cmbIpuValue;

/**
 * Insured risk start date
 */
@Column(name = "CMB_IPU_WEF")
private Date cmbIpuWef;

/**
 * Insured risk end date
 */
@Column(name = "CMB_IPU_WET")
private Date cmbIpuWet;

/**
 * Raining
 */
@Column(name = "CMB_RAINING", length = 1)
private String cmbRaining;

/**
 * Visibility
 */
@Column(name = "CMB_VISIBILITY", length = 20)
private String cmbVisibility;

/**
 * Road Surface
 */
@Column(name = "CMB_ROAD_SURFACE", length = 20)
private String cmbRoadSurface;

/**
 * Intended Prosecution
 */
@Column(name = "CMB_INTENDED_PROSECUTION", length = 1)
private String cmbIntendedProsecution;

    /**
 * Indicates if its an ex-gratia claim
 */
@Column(name = "CMB_EX_GRATIA", length = 1)
private String cmbExGratia;

/**
 * Reasons for ex-gratia claim
 */
@Column(name = "CMB_EXG_REASON", length = 500)
private String cmbExgReason;

/**
 * Rev Reason
 */
@Column(name = "CMB_REV_REASON", length = 20)
private String cmbRevReason;

/**
 * Pds Sht Desc
 */
@Column(name = "CMB_PDS_SHT_DESC", length = 50)
private String cmbPdsShtDesc;

/**
 * Charge Penalty
 */
@Column(name = "CMB_CHARGE_PENALTY", length = 1)
private String cmbChargePenalty;

/**
 * Indicate if salvage is retained by the client or not
 */
@Column(name = "CMB_SALVAGE_RETAINED", length = 1)
private String cmbSalvageRetained;

/**
 * Prd Incapacity
 */
@Column(name = "CMB_PRD_INCAPACITY", precision = 23)
private Long cmbPrdIncapacity;

/**
 * Pds Code
 */
@Column(name = "CMB_PDS_CODE", precision = 23)
private Long cmbPdsCode;

/**
 * Salary Based
 */
@Column(name = "CMB_SALARY_BASED", length = 1)
private String cmbSalaryBased;

/**
 * Reinsurance pool rate
 */
@Column(name = "CMB_REIN_POOL_RATE", precision = 23, scale = 2)
private BigDecimal cmbReinPoolRate;

/**
 * Indicate if reinsurance pool is applicable or not
 */
@Column(name = "CMB_REIN_POOL_APPL", length = 1)
private String cmbReinPoolAppl;

/**
 * Subm Insurer Date
 */
@Column(name = "CMB_SUBM_INSURER_DATE")
private Date cmbSubmInsurerDate;

/**
 * Next Review Dt
 */
@Column(name = "CMB_NEXT_REVIEW_DT")
private Date cmbNextReviewDt;

/**
 * Ins Cont Persn
 */
@Column(name = "CMB_INS_CONT_PERSN", length = 100)
private String cmbInsContPersn;

/**
 * Ins Claim No
 */
@Column(name = "CMB_INS_CLAIM_NO", length = 50)
private String cmbInsClaimNo;

/**
 * AVERAGE MONTHLY BASIC SALARY PER EMPLOYEE
 */
@Column(name = "CMB_AVRG_BASIC_SALARY", precision = 22, scale = 5)
private BigDecimal cmbAvrgBasicSalary;

/**
 * AVERAGE MONTHLY EARNINGS PER EMPLOYEE
 */
@Column(name = "CMB_AVRG_EARNINGS", precision = 22, scale = 5)
private BigDecimal cmbAvrgEarnings;

/**
 * DATE FOR THE BEGINING OF THE OFF DUTY
 */
@Column(name = "CMB_OFFDUTY_WEF_DT")
private Date cmbOffdutyWefDt;

/**
 * DATE FOR THE LAST DAY OUT OF WORK
 */
@Column(name = "CMB_OFFDUTY_WET_DT")
private Date cmbOffdutyWetDt;

/**
 * Priority Lvl
 */
@Column(name = "CMB_PRIORITY_LVL", length = 1)
private String cmbPriorityLvl;

/**
 * Comm Mode
 */
@Column(name = "CMB_COMM_MODE", precision = 22)
private Long cmbCommMode;

/**
 * Insurer Liab Admission
 */
@Column(name = "CMB_INSURER_LIAB_ADMISSION", length = 1)
private String cmbInsurerLiabAdmission;

/**
 * Insurer Liab Adm Reasn
 */
@Column(name = "CMB_INSURER_LIAB_ADM_REASN", length = 400)
private String cmbInsurerLiabAdmReasn;

/**
 * Admit Liab Date
 */
@Column(name = "CMB_ADMIT_LIAB_DATE")
private Date cmbAdmitLiabDate;

/**
 * Doc Received
 */
@Column(name = "CMB_DOC_RECEIVED", length = 15)
private String cmbDocReceived;

/**
 * Rejected Dt
 */
@Column(name = "CMB_REJECTED_DT")
private Date cmbRejectedDt;

/**
 * Location Code
 */
@Column(name = "CMB_LOCATION_CODE", precision = 22)
private Long cmbLocationCode;

/**
 * Unit Code
 */
@Column(name = "CMB_UNIT_CODE", precision = 22)
private Long cmbUnitCode;

/**
 * Next Rvw User
 */
@Column(name = "CMB_NEXT_RVW_USER", length = 15)
private String cmbNextRvwUser;

/**
 * Clm Rsv Cleaned
 */
@Column(name = "CMB_CLM_RSV_CLEANED", length = 1)
private String cmbClmRsvCleaned;

/**
 * Claim Remarks
 */
@Column(name = "CMB_CLAIM_REMARKS", length = 1000)
private String cmbClaimRemarks;

/**
 * Lead Claim Number
 */
@Column(name = "CMB_LEAD_CLAIM_NUMBER", length = 40)
private String cmbLeadClaimNumber;

/**
 * Risk Recovered
 */
@Column(name = "CMB_RISK_RECOVERED", length = 1)
private String cmbRiskRecovered;

/**
 * Veh Onmotion
 */
@Column(name = "CMB_VEH_ONMOTION", length = 1)
private String cmbVehOnmotion;

/**
 * Certificate Number
 */
@Column(name = "CMB_CERTIFICATE_NUMBER", length = 100)
private String cmbCertificateNumber;

/**
 * Risk Rcvry Date
 */
@Column(name = "CMB_RISK_RCVRY_DATE")
private Date cmbRiskRcvryDate;

/**
 * Risk Rcvry Code
 */
@Column(name = "CMB_RISK_RCVRY_CODE", precision = 22)
private Long cmbRiskRcvryCode;

/**
 * Veh Condition
 */
@Column(name = "CMB_VEH_CONDITION", length = 1)
private String cmbVehCondition;

/**
 * Reopening Remarks
 */
@Column(name = "CMB_REOPENING_REMARKS", length = 2000)
private String cmbReopeningRemarks;

/**
 * Tentative Loss Date
 */
@Column(name = "CMB_TENTATIVE_LOSS_DATE", length = 1)
private String cmbTentativeLossDate;

/**
 * Tentative Loss Date Edited
 */
@Column(name = "CMB_TENTATIVE_LOSS_DATE_EDITED", length = 1)
private String cmbTentativeLossDateEdited;

/**
 * Beve Code
 */
@Column(name = "CMB_BEVE_CODE", precision = 22)
private Long cmbBeveCode;

/**
 * Clm Status Remark
 */
@Column(name = "CMB_CLM_STATUS_REMARK", length = 800)
private String cmbClmStatusRemark;

/**
 * Next Review Comments
 */
@Column(name = "CMB_NEXT_REVIEW_COMMENTS", length = 4000)
private String cmbNextReviewComments;
}