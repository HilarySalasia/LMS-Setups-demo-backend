// Service Interface
package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.GinEvents;

import java.util.List;
import java.util.Optional;

public interface GinEventsService {
    List<GinEvents> findAll();
    Optional<GinEvents> findById(Long id);
    GinEvents save(GinEvents ginEvents);
    void deleteById(Long id);

    String getEveShtDesc(Long eveCode);
}