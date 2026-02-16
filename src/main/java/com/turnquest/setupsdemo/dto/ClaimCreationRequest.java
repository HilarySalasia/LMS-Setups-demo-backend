package com.turnquest.setupsdemo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ClaimCreationRequest {
    private Long ipuCode;
    private Long polBatchNo;
    private String lDate;
    private LocalDate clmReportDate;
    private Long casCode;
    private String casShtDesc;
    private String coinPayFull;
    private String lossDesc;
    private String docRef;
    private String user;
    private Long serial;
    private String perilLvl;
    private Long perilCode;
    private BigDecimal perilAmnt;
    private String noRi;
    private String selfAsClmant;
    private String liabilityAdmtd;
    private LocalDate claimNotDate;
    private String nextRevDate;
    private Long eveCode;
    private Long cataCode;
    private String refNo;
    private String serialNo;
    private String perilPayType;
    private BigDecimal basicSal;
    private BigDecimal avgEarnings;
    private LocalDate offdutyWefDt;
    private LocalDate offdutyWetDt;
    private String tp;
    private String cmbPriorityLvl;
    private String cmbLocation;
    private String paymode;
    private String commmode;
    private String clmntLiabAdm;
    private String cmbVehOnmotion;
    private String cmbTentativeLossDate;
    private String claimnextuserreview;

    // Getters and Setters

}