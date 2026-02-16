package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.dto.PerilDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GinPerilService {
    List<PerilDto> findPerilsByPerilLvlAndPerilCode(String perilLvl, Long perilCode, Long polBatchNo, Long ipuCode);
}
