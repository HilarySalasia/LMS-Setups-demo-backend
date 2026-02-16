package com.turnquest.setupsdemo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
public class ClaimRevisionRequest {
    private String vClmno;
    private Long vTransNo;
    private Date vDate;
    private String vTransType;
    private String vAddEdit;
    private String vUser;
    private String vRemarks;
    private List<SclPerilsRecDto> perilsTab;
    private Long v_Ipu_Code;
    private String vTempExcessIds;
    private String vAutoTrans;

}
