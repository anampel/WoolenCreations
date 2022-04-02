package com.site.woolencreations.product;

import com.site.woolencreations.category.Category;
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
    public Optional<Product> getProductByName(@RequestParam String name) {
        return productService.findProductByName(name);
    }

    @GetMapping("/findById")
    public Optional<Product> getProductByName(@RequestParam Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/findByDescription")
    public Optional<Product> getProductByDescription(@RequestParam String descr) {
        return productService.findProductsByDescriptionContains(descr);
    }

    @GetMapping("/findByKeyword")
    public List<Product> getProductByKeyword(@RequestParam String keyword) {
        return productService.findProductsByKeyword(keyword);
    }

    @GetMapping("/findByCategory")
    public List<Product> getProductByCategory(@RequestParam String categoryName) {
        return productService.findProductsByCategory(categoryName);
    }

    @GetMapping("/findByTwoCategories")
    public List<Product> getProductByTwoCategories(@RequestParam String category1, @RequestParam String category2) {
        return productService.findProductsBySubCategory(category1,category2);
    }

    @GetMapping("/findByDiscount")
    public List<Product> findProductByDiscount(@RequestParam Double discount) {
        return productService.findProductByDiscount(discount);
    }

    @GetMapping("/findAllProductsInOffer")
    public List<Product> findAllProductsInOffer() {
        return productService.findAllProductsInOffer();
    }

    @PostMapping("/add")
    public String registerNewProduct(@RequestBody Product product) {
        productService.addNewProduct(product);
        return "Success";
    }
    @PostMapping("/addList")
    public String registerNewListProducts(@RequestBody List<Product> products) {
        productService.addNewListProducts(products);
        return "Success";
    }
    @PutMapping("/edit")
    public String editUser(@RequestBody Product product) {
        productService.editProduct(product);
        return "Success";
    }

    @DeleteMapping("/delete")
    public String deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        return "Success";

    }
}
