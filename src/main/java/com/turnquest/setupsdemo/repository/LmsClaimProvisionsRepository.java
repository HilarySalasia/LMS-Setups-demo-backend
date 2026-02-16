package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.LmsClaimProvisions;
import com.turnquest.setupsdemo.model.compositeKeys.LmsClaimProvisionsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for LMS\_CLAIM\_PROVISIONS entity.
 */
@Repository
public interface LmsClaimProvisionsRepository extends JpaRepository<LmsClaimProvisions, LmsClaimProvisionsId> {
    // Custom query methods if necessary
}