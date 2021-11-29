package com.site.woolencreations.valuation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValuationRepository extends JpaRepository<Valuation, ValuationId> {
    @Query("SELECT val FROM Valuation val WHERE val.id.productId.id=?1")
    Optional<Valuation> findByIdProductId(Long prodID);

    @Query("SELECT val FROM Valuation val WHERE val.id.userId.id=?1")
    Optional<Valuation> findByIdUserId(Long userId);

}
