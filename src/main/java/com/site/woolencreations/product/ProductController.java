package com.site.woolencreations.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/product")
/**
 * Send request to postman
 * GET
 * http://localhost:8080/api/v1/product/findAll?name='kaskol'
 * */
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/findAll")
    public List<Product> getProduct() {
        return productService.getProduct();
    }
    @GetMapping("/findByName")
    public Optional<Product> getProductByName( @RequestParam String name) {
        return productService.findProductByName(name);
    }

    @PostMapping("/add")
    public String registerNewProduct (@RequestBody Product product){
        productService.addNewProduct(product);
        return "Success";

    }

}
