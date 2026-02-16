package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinParameters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GinParametersRepository extends JpaRepository<GinParameters, String> {
    Optional<GinParameters> findByParamName(String paramName);
}
