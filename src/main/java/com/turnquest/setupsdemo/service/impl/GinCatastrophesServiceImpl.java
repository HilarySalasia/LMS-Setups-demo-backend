// Service Implementation
package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.GinCatastrophes;
import com.turnquest.setupsdemo.repository.GinCatastrophesRepository;
import com.turnquest.setupsdemo.service.GinCatastrophesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GinCatastrophesServiceImpl implements GinCatastrophesService {

    @Autowired
    private GinCatastrophesRepository ginCatastrophesRepository;

    @Override
    public List<GinCatastrophes> findAll() {
        return ginCatastrophesRepository.findAll();
    }

    @Override
    public Optional<GinCatastrophes> findById(Long id) {
        return ginCatastrophesRepository.findById(id);
    }

    @Override
    public GinCatastrophes save(GinCatastrophes ginCatastrophes) {
        return ginCatastrophesRepository.save(ginCatastrophes);
    }

    @Override
    public void deleteById(Long id) {
        ginCatastrophesRepository.deleteById(id);
    }

    public String getCataShtDesc(Long cataCode) {
        // Implement logic to retrieve cataShtDesc from external sources
        // Example using JPA:
        Optional<GinCatastrophes> catastrophe = ginCatastrophesRepository.findById(cataCode);
        // Or throw an exception if catastrophe not found
        return catastrophe.map(GinCatastrophes::getCatShtDesc).orElse(null);
    }
}