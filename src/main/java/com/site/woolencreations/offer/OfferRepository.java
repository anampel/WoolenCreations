package com.site.woolencreations.offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OfferRepository  extends JpaRepository<Offer, Long> {
    @Transactional()
    @Modifying
    void deleteAllById(Long offerID);
}
