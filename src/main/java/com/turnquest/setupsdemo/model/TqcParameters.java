package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the TQC_PARAMETERS table.
 * Stores system parameters.
 */
@Entity
@Table(name = "TQC_PARAMETERS")
@Data
public class TqcParameters {

    /**
     * Parameter code.
     */
    @Id
    @Column(name = "PARAM_CODE", nullable = false)
    private BigDecimal paramCode;

    /**
     * Parameter name.
     */
    @Column(name = "PARAM_NAME", nullable = false)
    private String paramName;

    /**
     * Parameter value.
     */
    @Column(name = "PARAM_VALUE", nullable = false)
    private String paramValue;

    /**
     * Parameter status.
     */
    @Column(name = "PARAM_STATUS", nullable = false)
    private String paramStatus;

    /**
     * Parameter description.
     */
    @Column(name = "PARAM_DESC", nullable = false)
    private String paramDesc;

    /**
     * Mail agent password.
     */
    @Column(name = "MAIL_AGENT_PWD", nullable = false)
    private String mailAgentPwd;

    /**
     * Parameter error message.
     */
    @Column(name = "PARAM_ERROR_MESSAGE", nullable = false)
    private String paramErrorMessage;
}
