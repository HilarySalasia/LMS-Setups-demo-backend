package com.turnquest.setupsdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * This class represents the LmsClasses entity.
 * It maps to the LMS_CLASSES table in the database.
 */
@Entity
@Table(name = "LMS_CLASSES")
@Data
public class LmsClasses {

    /**
     * The unique identifier for a class.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLA_CODE")
    private BigDecimal claCode;

    /**
     * The short description of a class.
     */
    @Column(name = "CLA_SHT_DESC")
    private String claShtDesc;

    /**
     * The description of a class.
     */
    @Column(name = "CLA_DESC")
    private String claDesc;

    /**
     * The comments about a class.
     */
    @Column(name = "CLA_COMMENTS")
    private String claComments;

    /**
     * The type of a class.
     */
    @Column(name = "CLA_TYPE")
    private String claType;

    /**
     * The GL interface type of a class.
     */
    @Column(name = "CLA_GL_INTERFACE_TYPE")
    private String claGlInterfaceType;
}