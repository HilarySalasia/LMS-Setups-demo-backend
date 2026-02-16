package com.turnquest.setupsdemo.model.compositeKeys;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Composite key for GinCoinsurers.
 */
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class GinCoinsurersId implements Serializable {

    private Long coinAgntAgentCode; // Agent Code

    private Long coinPolBatchNo; // Policy Batch Number

    public GinCoinsurersId(Long coinAgntAgentCode, Long coinPolBatchNo) {
    }
}
