package com.project.rmm_ninjaone.database;

import com.project.rmm_ninjaone.model.Ledger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LedgerRepository extends JpaRepository<Ledger, Long> {

    @Query(value = "SELECT * FROM ledger l " +
            " WHERE YEAR(l.created) = :year " +
            " order by l.id_service", nativeQuery = true)
    List<Ledger> getTotalBy(@Param("year") Integer year);

    @Query(value = "SELECT SUM(l.total_price) " +
                "FROM ledger l " +
                " WHERE l.created BETWEEN :dateStarted and :dateFinished ", nativeQuery = true)
    Optional<BigDecimal> getTotalByDate(@Param("dateStarted") Date dateStarted,
                                        @Param("dateFinished") Date dateFinished);
}
