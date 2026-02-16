package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the GIN_CLM_PAYMENT_VOUCHERS table. Used to record transactions for fee payments for claims.
 */
@Entity
@Table(name = "GIN_CLM_PAYMENT_VOUCHERS")
@Data
public class GinClmPaymentVouchers {

    /**
     * Primary Key. Unique voucher number.
     */
    @Id
    @Column(name = "CPV_VOUCHER_NO", nullable = false, precision = 22)
    private BigDecimal cpvVoucherNo;

    /**
     * Payment date.
     */
    @Column(name = "CPV_DATE", nullable = false)
    private LocalDate cpvDate;

    /**
     * Payment amount.
     */
    @Column(name = "CPV_AMOUNT", precision = 23, scale = 5)
    private BigDecimal cpvAmount;

    /**
     * Claimant code. Foreign key from GIN_RGSTD_CLAIMANTS.
     */
    @Column(name = "CPV_REG_CLMT_CODE", precision = 22)
    private BigDecimal cpvRegClmtCode;

    /**
     * The one receiving the payment.
     */
    @Column(name = "CPV_PAYEE", nullable = false, length = 150)
    private String cpvPayee;

    /**
     * Service provider code.
     */
    @Column(name = "CPV_APCO_COR_CODE", precision = 22)
    private BigDecimal cpvApcoCorCode;

    /**
     * Claim payment remarks.
     */
    @Column(name = "CPV_COMMENTS", length = 100)
    private String cpvComments;

    /**
     * User who raised the payment.
     */
    @Column(name = "CPV_RAISE_BY", length = 30)
    private String cpvRaiseBy;

    /**
     * Foreign Key from GIN_CLAIM_MASTER_BOOKINGS representing the claim number.
     */
    @Column(name = "CPV_CMB_CLAIM_NO", nullable = false, length = 40)
    private String cpvCmbClaimNo;

    /**
     * A flag indicating if the claim has been authorised (Y)es or (N)o.
     */
    @Column(name = "CPV_AUTHORISED", length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String cpvAuthorised;

    /**
     * Indicates the person who authorised the payment.
     */
    @Column(name = "CPV_AUTHORISED_BY", length = 30)
    private String cpvAuthorisedBy;

    /**
     * Authorisation date.
     */
    @Column(name = "CPV_AUTHORISED_DT")
    private LocalDate cpvAuthorisedDt;

    /**
     * Amount of change made to the payment.
     */
    @Column(name = "CPV_CHANGE_AMT", precision = 23, scale = 5)
    private BigDecimal cpvChangeAmt;

    /**
     * Indicates the means by which the payment was made eg ck for check.
     */
    @Column(name = "CPV_PAYMENT_MODE", length = 5, columnDefinition = "VARCHAR2(5) default 'CHQ'")
    private String cpvPaymentMode;

    /**
     * Payment being made to whom, ''CL'' -claimant.
     */
    @Column(name = "CPV_PAYMENT_TO", nullable = false, length = 2, columnDefinition = "VARCHAR2(2) default 'CL'")
    private String cpvPaymentTo;

    /**
     * Foreign key from GIN_CLAIMANTS. Represents claimant code.
     */
    @Column(name = "CPV_REG_CLD_CODE", precision = 22)
    private BigDecimal cpvRegCldCode;

    /**
     * Foreign key for GIN_GIS_TRANSACTION representing transaction number.
     */
    @Column(name = "CPV_GGT_TRANS_NO", nullable = false, precision = 22)
    private BigDecimal cpvGgtTransNo;

    /**
     * Stores the document number whether its a debit or credit note.
     */
    @Column(name = "CPV_DRCR_NO", length = 15)
    private String cpvDrcrNo;

    /**
     * Retention.
     */
    @Column(name = "CPV_COMP_RETENTION", precision = 22, scale = 5)
    private BigDecimal cpvCompRetention;

    /**
     * Foreign Key from TQC_AGENCIES for agent code.
     */
    @Column(name = "CPV_AGNT_AGENT_CODE", precision = 22)
    private BigDecimal cpvAgntAgentCode;

    /**
     * Indicates the type of account affected by the transaction.
     */
    @Column(name = "CPV_ACCOUNT_TYPE", length = 2)
    private String cpvAccountType;

    /**
     * Transaction type.
     */
    @Column(name = "CPV_TRAN_TYPE", length = 4)
    private String cpvTranType;

    /**
     * Claimant Type.
     */
    @Column(name = "CPV_CLAIMANT_TYPE", length = 1)
    private String cpvClaimantType;

    /**
     * Manadatory premium amount.
     */
    @Column(name = "CPV_MAN_AMOUNT", precision = 22, scale = 5)
    private BigDecimal cpvManAmount;

    /**
     * Quota share amount.
     */
    @Column(name = "CPV_QUOTA_AMOUNT", precision = 22, scale = 5)
    private BigDecimal cpvQuotaAmount;

    /**
     * First setup premium premium premium amount.
     */
    @Column(name = "CPV_FSTSUP_AMOUNT", precision = 22, scale = 5)
    private BigDecimal cpvFstSupAmount;

    /**
     * Second setup premium premium premium amount.
     */
    @Column(name = "CPV_SECSUP_AMOUNT", precision = 22, scale = 5)
    private BigDecimal cpvSecSupAmount;

    /**
     * Facultative reinsuarance Amount.
     */
    @Column(name = "CPV_FACRE_AMOUNT", precision = 22, scale = 5)
    private BigDecimal cpvFacreAmount;

    /**
     * Coinsuarance Total amount.
     */
    @Column(name = "CPV_COIN_TOT_AMT", precision = 22, scale = 5)
    private BigDecimal cpvCoinTotAmt;

    /**
     * Base currency  amount.
     */
    @Column(name = "CPV_AMOUNT_BCUR", precision = 23, scale = 5)
    private BigDecimal cpvAmountBcur;

    /**
     * Retention Base currency   amount.
     */
    @Column(name = "CPV_COMP_RETENTION_BCUR", precision = 22, scale = 5)
    private BigDecimal cpvCompRetentionBcur;

    /**
     * Mandatory Base currency   amount.
     */
    @Column(name = "CPV_MAN_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal cpvManAmountBcur;

    /**
     * Quota share  Base currency   amount.
     */
    @Column(name = "CPV_QUOTA_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal cpvQuotaAmountBcur;

    /**
     * First setup premium premium premium  Base currency  amount.
     */
    @Column(name = "CPV_FSTSUP_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal cpvFstSupAmountBcur;

    /**
     * Second setup premium premium premium  Base currency  amount.
     */
    @Column(name = "CPV_SECSUP_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal cpvSecSupAmountBcur;

    /**
     * Facultative reinsuarance Base currency  amount.
     */
    @Column(name = "CPV_FACRE_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal cpvFacreAmountBcur;

    /**
     * coinsuarance Total Base currency  amount.
     */
    @Column(name = "CPV_COIN_TOT_AMT_BCUR", precision = 22, scale = 5)
    private BigDecimal cpvCoinTotAmtBcur;

    /**
     * Reserve amount.
     */
    @Column(name = "CPV_RESERVE", precision = 20, scale = 5)
    private BigDecimal cpvReserve;

    /**
     * Base currency reserve.
     */
    @Column(name = "CPV_RESERVE_BCUR", precision = 20, scale = 5)
    private BigDecimal cpvReserveBcur;

    /**
     * Currency Code. Foreign key from TQ_CRM.TQC_CURRENCIES.
     */
    @Column(name = "CPV_CUR_CODE", nullable = false, precision = 15)
    private BigDecimal cpvCurCode;

    /**
     * Currency symbol.
     */
    @Column(name = "CPV_CUR_SYMBOL", length = 25)
    private String cpvCurSymbol;

    /**
     * Currency Rate.
     */
    @Column(name = "CPV_CUR_RATE", precision = 15, scale = 5)
    private BigDecimal cpvCurRate;

    /**
     * voucher currency code.
     */
    @Column(name = "CPV_VCHR_CUR_CODE", precision = 20)
    private BigDecimal cpvVchrCurCode;

    /**
     * voucher currency symbol.
     */
    @Column(name = "CPV_VCHR_CUR_SYMBOL", length = 15)
    private String cpvVchrCurSymbol;

    /**
     * TIE TO THE BUYER/PAYEE IDENTIFIER.
     */
    @Column(name = "CPV_CBP_CODE", precision = 22)
    private BigDecimal cpvCbpCode;

    /**
     * Cheque date from FMS.
     */
    @Column(name = "CPV_CHEQUE_DATE")
    private LocalDate cpvChequeDate;

    /**
     * user who updated the cheque in FMS.
     */
    @Column(name = "CPV_CHQ_UPDATE_BY", length = 30)
    private String cpvChqUpdateBy;

    /**
     * Date cheque was update in FMS.
     */
    @Column(name = "CPV_CHQ_UPDATE_DATE")
    private LocalDate cpvChqUpdateDate;

    /**
     * THIS REFLECTS THE FMS SITUATION. A FOR ACTIVE AND C FOR CANCELLED.
     */
    @Column(name = "CPV_CHQ_STATUS", length = 2)
    private String cpvChqStatus;

    /**
     * THE PAYEE INVOICE NO.
     */
    @Column(name = "CPV_INV_NO", length = 30)
    private String cpvInvNo;

    /**
     * Withholding Tax rate.
     */
    @Column(name = "CPV_WHTX_RATE", precision = 10, scale = 5)
    private BigDecimal cpvWhtxRate;

    /**
     * VAT Rate.
     */
    @Column(name = "CPV_VAT_RATE", precision = 10, scale = 5)
    private BigDecimal cpvVatRate;

    /**
     * VAT AMOUNT.
     */
    @Column(name = "CPV_VAT_AMNT", precision = 22, scale = 5)
    private BigDecimal cpvVatAmnt;

    /**
     * Withholding tax amount.
     */
    @Column(name = "CPV_WHTX_AMNT", precision = 22, scale = 5)
    private BigDecimal cpvWhtxAmnt;

    /**
     * Indicates the net amount paid to the payee.
     */
    @Column(name = "CPV_NET_PAID", precision = 22, scale = 5)
    private BigDecimal cpvNetPaid;

    /**
     * Memo reference number.
     */
    @Column(name = "CPV_COMEM_CODE", precision = 22)
    private BigDecimal cpvComemCode;

    /**
     * Admissible amount.
     */
    @Column(name = "CPV_ADMISSIBLE_AMT", precision = 23, scale = 5)
    private BigDecimal cpvAdmissibleAmt;

    /**
     * Deductable amount.
     */
    @Column(name = "CPV_DEDUCT_EXCESS_AMT", precision = 22, scale = 5)
    private BigDecimal cpvDeductExcessAmt;

    /**
     * reference to payment methods. Foreign key from GIN_CLM_PAYMENT_MODES.
     */
    @Column(name = "CPV_CPM_CODE", precision = 23)
    private BigDecimal cpvCpmCode;

    /**
     * Cheque number paid in FMS.
     */
    @Column(name = "CPV_CHEQUE_NO", length = 30)
    private String cpvChequeNo;

    /**
     * The cheque amount paid in FMS.
     */
    @Column(name = "CPV_CHQ_AMT", precision = 23, scale = 5)
    private BigDecimal cpvChqAmt;

    /**
     * Payment method.
     */
    @Column(name = "CPV_PAY_METHOD", length = 25)
    private String cpvPayMethod;

    /**
     * transaction reference to GIN_BUSINESS_TRANSACTIONS.
     */
    @Column(name = "CPV_GGT_BTR_TRANS_CODE", length = 20)
    private String cpvGgtBtrTransCode;

    /**
     * Banch branch code reference to TQC_BANK_BRANCHES.
     */
    @Column(name = "CPV_BBR_CODE", precision = 15)
    private BigDecimal cpvBbrCode;

    /**
     * Bank account number.
     */
    @Column(name = "CPV_BANK_ACC", length = 45)
    private String cpvBankAcc;

    /**
     * Mobile phone number.
     */
    @Column(name = "CPV_MOBILE_NO", length = 20)
    private String cpvMobileNo;

    /**
     * Mobile service provider Id.
     */
    @Column(name = "CPV_MOB_PAYEE_ID", length = 50)
    private String cpvMobPayeeId;

    /**
     * Payment description.
     */
    @Column(name = "CPV_PAYMENT_DESC", length = 200)
    private String cpvPaymentDesc;

    /**
     * coinsurance total net paid amount.
     */
    @Column(name = "CPV_COIN_TOT_NET_PAID", precision = 23, scale = 5)
    private BigDecimal cpvCoinTotNetPaid;

    /**
     * coinsurance total vat amount.
     */
    @Column(name = "CPV_COIN_TOT_VAT_AMNT", precision = 23, scale = 5)
    private BigDecimal cpvCoinTotVatAmnt;

    /**
     * coinsurance total withholding tax amount.
     */
    @Column(name = "CPV_COIN_TOT_WHTX_AMNT", precision = 23, scale = 5)
    private BigDecimal cpvCoinTotWhtxAmnt;

    /**
     * Reinsurance pool recoverable amount.
     */
    @Column(name = "CPV_POOL_AMOUNT", precision = 22, scale = 5)
    private BigDecimal cpvPoolAmount;

    /**
     * Reinsurance pool recoverable amount in base currency.
     */
    @Column(name = "CPV_POOL_AMOUNT_BCUR", precision = 22, scale = 5)
    private BigDecimal cpvPoolAmountBcur;

    /**
     * facre obligatory recoverable amount.
     */
    @Column(name = "CPV_FACRE_OB_AMOUNT", precision = 23, scale = 5)
    private BigDecimal cpvFacreObAmount;

    /**
     * facre obligatory recoverable amount.
     */
    @Column(name = "CPV_FACRE_OB_AMOUNT_BCUR", precision = 23, scale = 5)
    private BigDecimal cpvFacreObAmountBcur;

    /**
     * xol recoverable amount in base currenct.
     */
    @Column(name = "CPV_XOL_AMOUNT_BCUR", precision = 23, scale = 5)
    private BigDecimal cpvXolAmountBcur;

    /**
     * xol recoverable amount i.
     */
    @Column(name = "CPV_XOL_AMOUNT", precision = 23, scale = 5)
    private BigDecimal cpvXolAmount;

    /**
     * coinsurance total excise duty amt.
     */
    @Column(name = "CPV_COIN_TOT_EXCISEDUTY_AMNT", precision = 22, scale = 5)
    private BigDecimal cpvCoinTotExcisedutyAmnt;

    /**
     * Excise duty aAmount.
     */
    @Column(name = "CPV_EXCISEDUTY_AMNT", precision = 22, scale = 5)
    private BigDecimal cpvExcisedutyAmnt;

    /**
     * Excise Duty rate.
     */
    @Column(name = "CPV_EXCISEDUTY_RATE", precision = 22, scale = 5)
    private BigDecimal cpvExcisedutyRate;

    /**
     * excise duty AMOUNT BASE CURRENCY.
     */
    @Column(name = "CPV_BCUR_EXCISEDUTY_AMNT", precision = 22, scale = 5)
    private BigDecimal cpvBcurExcisedutyAmnt;

    /**
     * A flag indicating whether the claim has been cleaned.
     */
    @Column(name = "CLEANED", nullable = false, length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String cleaned;

    /**
     * A flag indicating whether the claim has been cleaned.
     */
    @Column(name = "XOL_CLEANED", nullable = false, length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String xolCleaned;

    /**
     * A flag indicating whether the claim has been cleaned.
     */
    @Column(name = "CLAIMS_CLEANED", nullable = false, length = 1, columnDefinition = "VARCHAR2(1) default 'N'")
    private String claimsCleaned;

    /**
     *  Indicates the reason for the payment.
     */
    @Column(name = "CPV_TP_PAYMENTREASON", length = 400)
    private String cpvTpPaymentreason;

    /**
     *  Indicates the payment type.
     */
    @Column(name = "CPV_COIN_PAY_TYPE", length = 1)
    private Character cpvCoinPayType;

    /**
     *  Indicates whether the payee was selected.
     */
    @Column(name = "CPV_PAYEE_SELECTED", length = 1)
    private String cpvPayeeSelected;

    /**
     *  Indicates the user who checked the payment.
     */
    @Column(name = "CPV_CHECKED_BY", length = 50)
    private String cpvCheckedBy;

    /**
     *  Indicates the date the payment was checked.
     */
    @Column(name = "CPV_CHECKED_DATE")
    private LocalDate cpvCheckedDate;

    /**
     *  Indicates the user who processed the payment.
     */
    @Column(name = "CPV_DONE_BY", length = 50)
    private String cpvDoneBy;

    /**
     *  Indicates the date the payment was processed.
     */
    @Column(name = "CPV_DONE_DATE")
    private LocalDate cpvDoneDate;

    /**
     *  Indicates the reason for the account change.
     */
    @Column(name = "CPV_ACC_CHANGE_REASON", length = 500)
    private String cpvAccChangeReason;

    /**
     *  Indicates the total net paid amount in base currency.
     */
    @Column(name = "CPV_BCUR_COIN_TOT_NET_PAID")
    private BigDecimal cpvBcurCoinTotNetPaid;

}