package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "LMS_OPT_PYMNT_FREQS")
public class LmsOptPymntFreqs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPF_CODE", nullable = false)
    private Long opfCode;

    @Column(name = "OPF_PYMNT_FEQ", length = 5)
    private String opfPymntFeq;

    @ManyToOne
    @JoinColumn(name = "OPF_POP_CODE", nullable = false)
    private LmsProdOptions lmsProdOptions;

    @Column(name = "OPF_WEF")
    @Temporal(TemporalType.DATE)
    private Date opfWef;

    @Column(name = "OPF_WET")
    @Temporal(TemporalType.DATE)
    private Date opfWet;

    @PrePersist
    @PreUpdate
    private void validateWefWet() {
        if (opfWef != null && opfWet != null && opfWef.after(opfWet)) {
            throw new IllegalArgumentException("OPF_WEF must be before or equal to OPF_WET");
        }
    }
}
