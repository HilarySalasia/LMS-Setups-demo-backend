package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.Jbpm4TaskGis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface Jbpm4TaskGisRepository extends JpaRepository<Jbpm4TaskGis, BigDecimal> {

    void deleteByDbid(BigDecimal dbid);
}
