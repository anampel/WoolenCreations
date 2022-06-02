package com.site.woolencreations.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/v1/offer")
/**
 * Send request to postman
 * GET
 * http://localhost:8080/api/v1/offer/findAll
 * */
public class OfferController {
    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/findAll")
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }

    @PostMapping("/add")
    public String addNewOffer(@RequestBody Offer offer){
        offerService.addNewOffer(offer);
        return "Success";
    }

    @PostMapping("/edit")
    public String editOffer(@RequestBody Offer offer){
        offerService.editOffer(offer);
        return "Success";
    }

    @DeleteMapping("/delete")
    public String deleteOffer(@RequestParam Long id){
        offerService.deleteOffer(id);
        return "Success";
    }

    @GetMapping("/findByDiscount")
    public Optional<Offer> findByDiscount(@RequestParam Double discount){
        return offerService.getAllByDiscount(discount);
    }

    //TODO -> findActiveByDiscount


    @GetMapping("/getActiveOffers")
    public Optional<Offer> getActiveOffers(){
        return offerService.getActiveOffers();
    }
}
