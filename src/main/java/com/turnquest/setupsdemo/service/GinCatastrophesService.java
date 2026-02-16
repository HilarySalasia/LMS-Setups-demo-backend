// Service Interface
package com.turnquest.setupsdemo.service;

import com.turnquest.setupsdemo.model.GinCatastrophes;

import java.util.List;
import java.util.Optional;

public interface GinCatastrophesService {
    List<GinCatastrophes> findAll();
    Optional<GinCatastrophes> findById(Long id);
    GinCatastrophes save(GinCatastrophes ginCatastrophes);
    void deleteById(Long id);

    String getCataShtDesc(Long cataCode);
}