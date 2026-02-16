package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinCoinsurers;
import com.turnquest.setupsdemo.model.compositeKeys.GinCoinsurersId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GinCoinsurersRepository extends JpaRepository<GinCoinsurers, GinCoinsurersId> {
    // Custom query method to find all records by coinPolBatchNo in the composite key
    List<GinCoinsurers> findAllByIdCoinPolBatchNo(Long coinPolBatchNo);
}
