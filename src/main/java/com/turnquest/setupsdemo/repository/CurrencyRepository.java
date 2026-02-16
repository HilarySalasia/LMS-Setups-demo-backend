package com.turnquest.setupsdemo.repository;


import com.turnquest.setupsdemo.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Repository interface for Currency entity.
 */
@Repository
public interface CurrencyRepository extends JpaRepository<Currency, BigDecimal> {

    /**
     * Custom query to find all Currencies ordered by description.
     *
     * @return a list of Currencies ordered by description
     */
    @Query("SELECT c FROM Currency c ORDER BY c.curDesc ASC")
    List<Currency> findAllOrderedByDescription();

    Optional<Currency> findByCurCode(Long curCode);
}
