package com.site.woolencreations.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository producRepository;

    @Autowired
    public ProductService(ProductRepository producRepository) {
        this.producRepository = producRepository;
    }

    /**
     * Find All products
     * @return
     */
    public List<Product> getProduct(){
        return producRepository.findAll();
    }
    /**
     * Find All products
     * @return
     */
    public Optional<Product> findProductByName(String name){
        return producRepository.findProductByName(name);
    }


    /**
     *add in the DB a product only if the product name does not exists already in the db.
     * @param product
     */
    public void addNewProduct(Product product) {
        Optional<Product> productByName = producRepository
                .findProductByName(product.getName());

        if(productByName.isPresent()){
            throw new IllegalStateException("The product already exists!!");
        }
        producRepository.save(product);

    }


}
