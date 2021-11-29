package com.site.woolencreations.valuation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ValuationRepository extends JpaRepository<Valuation, ValuationId> {
    @Query("SELECT val FROM Valuation val WHERE val.id.productId.id=?1")
    Optional<Valuation> findByIdProductId(Long prodID);

    @Query("SELECT val FROM Valuation val WHERE val.id.userId.id=?1")
    Optional<Valuation> findByIdUserId(Long userId);

    @Transactional()
    @Modifying
    @Query("DELETE FROM Valuation val WHERE val.id.userId.id=?1 and val.id.productId.id=?2")
    void deleteAllByIds(Long userId, Long productId);

}
