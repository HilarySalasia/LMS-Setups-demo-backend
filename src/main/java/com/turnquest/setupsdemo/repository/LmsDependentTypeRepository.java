package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.LmsDependentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface LmsDependentTypeRepository extends JpaRepository<LmsDependentType, BigDecimal> {
}