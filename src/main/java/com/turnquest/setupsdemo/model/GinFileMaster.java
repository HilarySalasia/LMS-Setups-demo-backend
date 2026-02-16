package com.turnquest.setupsdemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

/**
 * This table stores information about files in the system.
 */
@Entity
@Table(name = "GIN_FILE_MASTER")
@Data
public class GinFileMaster {
    /**
     * Unique file number for each file.
     */
    @Id
    @Column(name = "FILM_FILE_NO", nullable = false, length = 50)
    private String filmFileNo;

    /**
     * Description of the file.
     */
    @Column(name = "FILM_FILE_DESC", length = 200)
    private String filmFileDesc;

    /**
     * Type of file.
     */
    @Column(name = "FILM_TYPE", length = 15)
    private String filmType;

    /**
     * Date the file was opened.
     */
    @Column(name = "FILM_OPEN_DT")
    private Date filmOpenDt;

    /**
     * Location where the file is stored.
     */
    @Column(name = "FILM_LOCATION", length = 30)
    private String filmLocation;

    /**
     * Department where the file is located.
     */
    @Column(name = "FILM_LOCATION_DEPT", length = 30)
    private String filmLocationDept;

    /**
     * Shelf number where the file is stored.
     */
    @Column(name = "FILM_HOME_SHELF_NO", length = 10)
    private String filmHomeShelfNo;

    /**
     * Last date the file was reviewed.
     */
    @Column(name = "FILM_LAST_RVIEWDATE")
    private Date filmLastRviewdate;

    /**
     * User who last reviewed the file.
     */
    @Column(name = "FILM_RVIEW_BY", length = 35)
    private String filmRviewBy;
}