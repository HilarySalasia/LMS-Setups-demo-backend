// Service Implementation
package com.turnquest.setupsdemo.service.impl;

import com.turnquest.setupsdemo.model.GinEvents;
import com.turnquest.setupsdemo.repository.GinEventsRepository;
import com.turnquest.setupsdemo.service.GinEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GinEventsServiceImpl implements GinEventsService {

    @Autowired
    private GinEventsRepository ginEventsRepository;

    @Override
    public List<GinEvents> findAll() {
        return ginEventsRepository.findAll();
    }

    @Override
    public Optional<GinEvents> findById(Long id) {
        return ginEventsRepository.findById(id);
    }

    @Override
    public GinEvents save(GinEvents ginEvents) {
        return ginEventsRepository.save(ginEvents);
    }

    @Override
    public void deleteById(Long id) {
        ginEventsRepository.deleteById(id);
    }

    public String getEveShtDesc(Long eveCode) {
        // Implement logic to retrieve eveShtDesc from external sources
        // Example using JPA:
        Optional<GinEvents> event = ginEventsRepository.findById(eveCode);
        // Or throw an exception if event not found
        return event.map(GinEvents::getEveShtDesc).orElse(null);
    }
}