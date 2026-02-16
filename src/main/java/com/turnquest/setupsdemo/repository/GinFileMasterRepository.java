package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinFileMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for GinFileMaster entity.
 */
@Repository
public interface GinFileMasterRepository extends JpaRepository<GinFileMaster, String> {
}