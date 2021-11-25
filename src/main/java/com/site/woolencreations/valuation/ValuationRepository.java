package com.site.woolencreations.valuation;

import com.site.woolencreations.product.Product;
import com.site.woolencreations.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValuationRepository extends JpaRepository<Valuation, Long> {

//    @Query("Select true from Valuation val where val.id.userId = ?1 and val.id.productId=?2")
    Optional<Valuation> findValuationById_UserIdAndId_ProductId(Long userId, Long productId);
}
