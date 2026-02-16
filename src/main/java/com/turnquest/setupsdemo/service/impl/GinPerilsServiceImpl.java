package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.PerilDto;
import com.turnquest.setupsdemo.repository.GinPerilsRepository;
import com.turnquest.setupsdemo.service.GinPerilService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GinPerilsServiceImpl implements GinPerilService {

    private final GinPerilsRepository ginPerilsRepository;
    public List<PerilDto> findPerilsByPerilLvlAndPerilCode(String perilLvl, Long perilCode, Long polBatchNo, Long ipuCode) {
        return ginPerilsRepository.findPerilsByPerilLvlAndPerilCode(perilLvl, perilCode, polBatchNo, ipuCode);
    }
}
