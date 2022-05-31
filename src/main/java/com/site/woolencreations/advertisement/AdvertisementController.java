package com.site.woolencreations.advertisement;

import com.site.woolencreations.product.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class AdvertisementController {

    private AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    /**
     * Advertisement Algorithm
     */
    @PostMapping("/advertisement")
    public List<Product> targetedAdvertisement(@RequestParam Long customerId,
                                               @RequestBody List<Long> productIds) {
        return advertisementService.targetedAdvertisement(customerId, productIds);


    }


}
