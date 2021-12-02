package com.site.woolencreations.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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

    /**
     *add in the DB a offer only if the offer id does not exist already in the db.
     * @param offer
     */
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

    /**
     *edit a User in the DB only if the User exist.
     * @param offer
     */
    public void editOffer(Offer offer) {
        Optional<Offer> offerById = offerRepository.findById(offer.getId());
        if (offerById.isPresent()) {
            offerRepository.save(offer);
        } else {
            throw new IllegalArgumentException("The user with e-mail: "+offer.getId() +" does not exist!");
        }
    }

    /**
     *delete a User in the DB only if the User exist.
     * @param offerID
     */
    public void deleteOffer(Long offerID){
        Optional<Offer> offerById = offerRepository.findById(offerID);
        if(offerById.isPresent()){
            offerRepository.deleteAllById(offerID);
        }

    }
    /**
     *find all offer that have the given discount.
     * @param discount
     */
    public Optional<Offer> getAllByDiscount(Double discount){
       return offerRepository.findByDiscount(discount);
    }

    public Optional<Offer> getActiveOffers(){
        long millis = System.currentTimeMillis();
        Date today = new Date(millis);
        return offerRepository.getActiveOffers(today);
    }

    //TODO getAllActiveByDiscount

}
