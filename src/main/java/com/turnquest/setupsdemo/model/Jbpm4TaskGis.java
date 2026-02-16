package com.turnquest.setupsdemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Entity representing the JBPM4_TASK_GIS table.
 * Likely stores information about tasks in a jBPM4 workflow engine.
 */
@Entity
@Table(name = "JBPM4_TASK_GIS")
@Data
public class Jbpm4TaskGis {

    /**
     * Primary key for the task record.
     */
    @Id
    @Column(name = "DBID_", nullable = false, precision = 22)
    private BigDecimal dbId;

    /**
     * Task class.
     */
    @Column(name = "CLASS_", nullable = false, length = 1)
    private String taskClass;

    /**
     * Database version.
     */
    @Column(name = "DBVERSION_", nullable = false, precision = 22)
    private BigDecimal dbVersion;

    /**
     * Task name.
     */
    @Column(name = "NAME_", length = 255)
    private String name;

    /**
     * Task description.
     */
    @Column(name = "DESCR_", columnDefinition = "CLOB")
    @Lob
    private String descr;

    /**
     * Task state.
     */
    @Column(name = "STATE_", length = 255)
    private String state;

    /**
     * Suspended historical state.
     */
    @Column(name = "SUSPHISTSTATE_", length = 255)
    private String suspHistState;

    /**
     * Assignee of the task.
     */
    @Column(name = "ASSIGNEE_", length = 255)
    private String assignee;

    /**
     * Task form.
     */
    @Column(name = "FORM_", length = 255)
    private String form;

    /**
     * Task priority.
     */
    @Column(name = "PRIORITY_", precision = 22)
    private BigDecimal priority;

    /**
     * Date the task was created.
     */
    @Column(name = "CREATE_")
    private LocalDate create;

    /**
     * Due date for the task.
     */
    @Column(name = "DUEDATE_")
    private LocalDate dueDate;

    /**
     * Task progress.
     */
    @Column(name = "PROGRESS_", precision = 22)
    private BigDecimal progress;

    /**
     * Signalling flag.
     */
    @Column(name = "SIGNALLING_", precision = 22)
    private BigDecimal signalling;

    /**
     * Execution ID.
     */
    @Column(name = "EXECUTION_ID_", length = 255)
    private String executionId;

    /**
     * Activity name.
     */
    @Column(name = "ACTIVITY_NAME_", length = 255)
    private String activityName;

    /**
     * Indicates whether the task has variables (1 = Yes, 0 = No).
     */
    @Column(name = "HASVARS_", precision = 22)
    private BigDecimal hasVars;

    /**
     * Supertask ID.
     */
    @Column(name = "SUPERTASK_", precision = 22)
    private BigDecimal supertask;

    /**
     * Execution ID.
     */
    @Column(name = "EXECUTION_", precision = 22)
    private BigDecimal execution;

    /**
     * Process instance ID.
     */
    @Column(name = "PROCINST_", precision = 22)
    private BigDecimal procInst;

    /**
     * Swimlane ID.
     */
    @Column(name = "SWIMLANE_", precision = 22)
    private BigDecimal swimlane;

    /**
     * Task definition name.
     */
    @Column(name = "TASKDEFNAME_", length = 255)
    private String taskdefName;
}