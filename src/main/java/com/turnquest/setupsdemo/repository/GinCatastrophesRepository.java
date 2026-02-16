// Repository Interface
package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinCatastrophes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GinCatastrophesRepository extends JpaRepository<GinCatastrophes, Long> {
}