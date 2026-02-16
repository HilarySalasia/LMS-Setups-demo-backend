package com.turnquest.setupsdemo.model.compositeKeys;

import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Composite key class for LMS_CLAIM_PROVISIONS table.
 */
@Embeddable
@Data
public class LmsClaimProvisionsId implements Serializable {

    private BigDecimal pclpCode;
    private String pclpClmNo;
    private BigDecimal pclpPolCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LmsClaimProvisionsId that = (LmsClaimProvisionsId) o;
        return Objects.equals(pclpCode, that.pclpCode) &&
                Objects.equals(pclpClmNo, that.pclpClmNo) &&
                Objects.equals(pclpPolCode, that.pclpPolCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pclpCode, pclpClmNo, pclpPolCode);
    }
}
