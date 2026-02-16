package com.turnquest.setupsdemo.model.compositeKeys;

import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Composite primary key class for LMS_CLM_CVT_PROVISIONS entity.
 */
@Data
public class LmsClmCvtProvisionsId implements Serializable {

    private BigDecimal pccpCode;

    private String pccpClmNo;

    // Default constructor
    public LmsClmCvtProvisionsId() {}

    // Parameterized constructor
    public LmsClmCvtProvisionsId(BigDecimal pccpCode, String pccpClmNo) {
        this.pccpCode = pccpCode;
        this.pccpClmNo = pccpClmNo;
    }

    // Implement equals() and hashCode() methods if needed
}
