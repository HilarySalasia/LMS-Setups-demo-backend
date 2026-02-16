package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

/**
 * Entity representing dependent types.
 */
@Data
@Entity
@Table(name = "LMS_DEPENDENT_TYPES", uniqueConstraints = {
        @UniqueConstraint(columnNames = "DTY_DESCRIPTION"),
        @UniqueConstraint(columnNames = "DTY_SHT_DESC")
})
public class LmsDependentType {
    @Id
    @Column(name = "DTY_CODE", nullable = false)
    private BigDecimal dtyCode;

    @Column(name = "DTY_SHT_DESC", nullable = false, length = 15)
    private String dtyShtDesc;

    @Column(name = "DTY_DESCRIPTION", nullable = false, length = 50)
    private String dtyDescription;

    @Column(name = "DTY_EXTENDED_FAMILY", length = 1)
    private String dtyExtendedFamily;

    @Column(name = "DTY_STATUS", length = 5)
    private String dtyStatus;
}