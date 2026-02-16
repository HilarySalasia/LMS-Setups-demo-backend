package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the JBPM4_HIST_TASK_GIS table.
 * Likely stores historical information about tasks in a jBPM4 workflow engine.
 */
@Entity
@Table(name = "JBPM4_HIST_TASK_GIS")
@Data
public class Jbpm4HistTaskGis {

    /**
     * Primary key for the historical task record.
     */
    @Id
    @Column(name = "DBID_", nullable = false, precision = 22)
    private BigDecimal dbId;

    /**
     * Database version.
     */
    @Column(name = "DBVERSION_", nullable = false, precision = 22)
    private BigDecimal dbVersion;

    /**
     * Execution ID.
     */
    @Column(name = "EXECUTION_", length = 255)
    private String execution;

    /**
     * Task outcome.
     */
    @Column(name = "OUTCOME_", length = 255)
    private String outcome;

    /**
     * Assignee of the task.
     */
    @Column(name = "ASSIGNEE_", length = 255)
    private String assignee;

    /**
     * Task priority.
     */
    @Column(name = "PRIORITY_", precision = 22)
    private BigDecimal priority;

    /**
     * Task state.
     */
    @Column(name = "STATE_", length = 255)
    private String state;

    /**
     * Date the task was created.
     */
    @Column(name = "CREATE_")
    private LocalDate create;

    /**
     * Date the task ended.
     */
    @Column(name = "END_")
    private LocalDate end;

    /**
     * Task duration.
     */
    @Column(name = "DURATION_", precision = 22)
    private BigDecimal duration;

    /**
     * Next index.
     */
    @Column(name = "NEXTIDX_", precision = 22)
    private BigDecimal nextIdx;

    /**
     * Supertask ID.
     */
    @Column(name = "SUPERTASK_", precision = 22)
    private BigDecimal supertask;
}
