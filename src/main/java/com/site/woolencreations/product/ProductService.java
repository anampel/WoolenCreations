package com.site.woolencreations.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository producRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.producRepository = productRepository;
    }

    /**
     * Find All products
     * @return
     */
    public List<Product> getProduct(){
        return producRepository.findAll();
    }
    /**
     * Find products by name
     * @return
     */
    public Optional<Product> findProductByName(String name){
        return producRepository.findProductByName(name);
    }

    /**
     * Find Products which include the given description
     * @param description
     * @return
     */
    public Optional<Product> findProductsByDescriptionContains(String description){
        return producRepository.findProductsByDescriptionContains(description);
    }

    /**
     * Find products with keyword which could be present
     * as it is OR as part in the name or in the description of the product
     * @param keyword
     * @return
     */
    public Optional<Product> findProductsByKeyword(String keyword){
        return producRepository.findProductsByKeyword(keyword);
    }

    /**
     * Add in the DB a product only if the product name does not exists already in the db.
     * @param product
     */
    public void addNewProduct(Product product) {
        Optional<Product> productByName = producRepository
                .findProductByName(product.getName());

        //TODO check if it is business correct. If yes... the searches need some fixes  ( findByName - not list)
        //TODO when we add a product, a new category is creating every time, this need to be fixed
        if(productByName.isPresent()){
            throw new IllegalStateException("The product already exists!!");
        }
        producRepository.save(product);

    }
    public Optional<Product> findProductsByCategory(String keyword){
        return producRepository.findProductsByCategory(keyword);
    }


}
