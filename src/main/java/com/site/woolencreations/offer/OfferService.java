package com.site.woolencreations.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewOffer(Offer offer){
        try {
            Optional<Offer> offerById = offerRepository.findById(offer.getId());
            if(offerById.isPresent()){
                throw new IllegalStateException("The Offer already exists!!");
            }
            offerRepository.save(offer);
        }catch (Exception e){
            throw new IllegalArgumentException("IllegalArgument returned from addNewOffer()");
        }
    }

    //TODO findOfferByDiscount
    //TODO getActiveOffers

    //TODO edit

}
