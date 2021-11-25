package com.site.woolencreations.valuation;

import com.site.woolencreations.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/valuation")
public class ValuationController {

    public final ValuationService valuationService;
    @Autowired
    public ValuationController(ValuationService valuationService) {
        this.valuationService = valuationService;
    }

    @PostMapping("/add")
    public String registerNewUser (@RequestBody Valuation val, @RequestParam Long userId, @RequestParam Long productId){
        valuationService.addValuation(val, userId, productId);
        return "Success";
    }
}
