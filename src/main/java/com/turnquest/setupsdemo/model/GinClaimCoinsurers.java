package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "gin_claim_coinsurers")
@Data
public class GinClaimCoinsurers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clco_id")
    private Long id;

    @Column(name = "clco_agnt_agent_code")
    private Long agntAgentCode;

    @Column(name = "clco_agnt_sht_desc")
    private String agntShtDesc;

    @Column(name = "clco_gl_code")
    private Long glCode;

    @Column(name = "clco_lead")
    private String lead;

    @Column(name = "clco_perct")
    private BigDecimal perct;

    @Column(name = "clco_cmb_claim_no")
    private String cmbClaimNo;

}