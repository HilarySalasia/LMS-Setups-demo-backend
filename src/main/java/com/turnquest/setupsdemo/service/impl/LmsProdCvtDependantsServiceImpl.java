package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.dto.DependantDisplayDTO;
import com.turnquest.setupsdemo.model.LmsProdCvtDependants;
import com.turnquest.setupsdemo.repository.LmsProdCvtDependantsRepository;
import com.turnquest.setupsdemo.service.LmsProdCvtDependantsService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class LmsProdCvtDependantsServiceImpl implements LmsProdCvtDependantsService {

    private final LmsProdCvtDependantsRepository repository;
    private final MessageSource messageSource;

    public LmsProdCvtDependantsServiceImpl(LmsProdCvtDependantsRepository repository, MessageSource messageSource) {
        this.repository = repository;
        this.messageSource = messageSource;
    }

    @Override
    public List<LmsProdCvtDependants> getAllDependants() {
        return repository.findAll();
    }

    @Override
    public LmsProdCvtDependants getDependantById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException(messageSource.getMessage("error.dependant.notfound", null, Locale.getDefault())));
    }

    @Override
    public LmsProdCvtDependants saveDependant(LmsProdCvtDependants dependant) {
        return repository.save(dependant);
    }

    @Override
    public void deleteDependant(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<DependantDisplayDTO> findDependantDisplay(Long vPctCode, Long vPcdCode) {
        return repository.findDependantDisplay(vPctCode, vPcdCode);
    }
}
