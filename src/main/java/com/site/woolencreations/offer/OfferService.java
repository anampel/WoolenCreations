package com.site.woolencreations.offer;

import com.site.woolencreations.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    /**
     * Find All offers
     * @return
     */
    public List<Offer> getAllOffers(){
        return offerRepository.findAll();
    }


}
