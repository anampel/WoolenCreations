package com.site.woolencreations.offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Transactional()
    @Modifying
    void deleteAllById(Long offerID);

    Optional<Offer> findByDiscount(Double discount);

    @Query("SELECT o FROM Offer o WHERE o.start_date <= ?1 and o.end_date >= ?1")
    Optional<Offer> getActiveOffers(Date today);


}
