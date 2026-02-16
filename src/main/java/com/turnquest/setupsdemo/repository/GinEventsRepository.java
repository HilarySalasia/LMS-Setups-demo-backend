// Repository Interface
package com.turnquest.setupsdemo.repository;

import com.turnquest.setupsdemo.model.GinEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface GinEventsRepository extends JpaRepository<GinEvents, Long> {
    Optional<GinEvents> findByEveDateAndEveRelrCodeAndEveWef(Date eveDate, BigDecimal vRelrCode, Date eveWef);

    Long findMaxEveCode();
}