package com.site.woolencreations.valuation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Repository
public interface ValuationRepository extends JpaRepository<Valuation, ValuationId> {
    @Query("SELECT val FROM Valuation val WHERE val.id.productId.id=?1")
    Optional<Valuation> findByIdProductId(Long prodID);

    @Query("SELECT val FROM Valuation val WHERE val.id.userId.id=?1")
    Optional<Valuation> findByIdUserId(Long userId);

    @Query("SELECT true FROM Valuation val WHERE val.id.userId.id=?1 and val.id.productId.id=?2")
    Boolean isExistValuation(Long userId, Long productId);

    @Transactional()
    @Modifying
    @Query("DELETE FROM Valuation val WHERE val.id.userId.id=?1 and val.id.productId.id=?2")
    void deleteAllByIds(Long userId, Long productId);

    @Modifying
    @Query(value = "insert into Valuation (userId,productId,description, stars, date) VALUES (:userId,:productId,:description, :stars,:date)", nativeQuery = true)
    @Transactional
    void insertValuation(Long userId, Long productId, String description, int stars, Date date);
}
