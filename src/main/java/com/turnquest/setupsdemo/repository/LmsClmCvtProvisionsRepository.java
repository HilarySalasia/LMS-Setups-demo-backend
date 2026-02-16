package com.turnquest.setupsdemo.repository;
import com.turnquest.setupsdemo.model.LmsClmCvtProvisions;
import com.turnquest.setupsdemo.model.compositeKeys.LmsClmCvtProvisionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for LMS_CLM_CVT_PROVISIONS entity.
 */
@Repository
public interface LmsClmCvtProvisionsRepository extends JpaRepository<LmsClmCvtProvisions, LmsClmCvtProvisionsId> {
    // Custom query methods if necessary
}
