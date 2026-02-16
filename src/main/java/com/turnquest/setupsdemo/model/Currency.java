package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Entity representing the TQC_CURRENCIES table.
 */
@Data
@Entity
@Table(name = "TQC_CURRENCIES", uniqueConstraints = {
        @UniqueConstraint(columnNames = "CUR_CODE"),
        @UniqueConstraint(columnNames = "CUR_DESC")
})
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUR_CODE")
    private BigDecimal curCode;

    @Column(name = "CUR_SYMBOL", nullable = false, length = 10)
    private String curSymbol;

    @Column(name = "CUR_DESC", nullable = false, length = 100)
    private String curDesc;

    @Column(name = "CUR_RND", nullable = false)
    private BigDecimal curRnd;

    @Column(name = "CUR_NUM_WORD", nullable = false, length = 100)
    private String curNumWord;

    @Column(name = "CUR_DECIMAL_WORD", nullable = false, length = 100)
    private String curDecimalWord;

    @Column(name = "CUR_SHT_DESC", length = 50)
    private String curShtDesc;

    @Column(name = "CUR_REF", length = 50)
    private String curRef;

    @Column(name = "CUR_ISO2", length = 2)
    private String curIso2;

    @Column(name = "CUR_DISPLAY_ORDER")
    private Integer curDisplayOrder;

    @Column(name = "CUR_WEB_DEFAULT")
    private Boolean curWebDefault;

    @Column(name = "CUR_UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date curUpdatedDate;

    @Column(name = "CUR_CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date curCreatedDate;

    @Column(name = "CUR_ISO3", length = 3)
    private String curIso3;
}
