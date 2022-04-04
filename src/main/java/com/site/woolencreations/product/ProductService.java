package com.site.woolencreations.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Find All products
     *
     * @return
     */
    public List<Product> getProduct(Integer pageNo, Integer pageSize, String sort, String sortColumn) {
        Pageable paging = PageRequest.of(pageNo, pageSize, "ASC".equalsIgnoreCase(sort) ? Sort.by(sortColumn).ascending():Sort.by(sortColumn).descending() );
        Page<Product> productPage = productRepository.findAll(paging);

        if(productPage.hasContent()) {
            return productPage.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Find products by name
     *
     * @return
     */
    public Optional<Product> findProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    /**
     * Find products by id
     *
     * @return
     */
    public Optional<Product> findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    /**
     * Find products by category
     *
     * @param categoryName
     */
    public List<Product> findProductsByCategory(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    /**
     * Find products by Subcategory
     *
     * @param a
     * @param b
     */

    public List<Product> findProductsBySubCategory(String a, String b) {
        return productRepository.findProductsBySubCategory(a, b);
    }

    /**
     * Find products by a given discount where the offer is active
     *
     * @param discount
     */
    public List<Product> findProductByDiscount(Double discount) {
        long millis = System.currentTimeMillis();
        java.sql.Date today = new java.sql.Date(millis);
        return productRepository.findProductByDiscount(discount, today);
    }

    /**
     * Find products that include discount and the offer is active
     */
    public List<Product> findAllProductsInOffer() {
        long millis = System.currentTimeMillis();
        Date today = new Date(millis);
        List<Product> products = productRepository.findAllProductsInOffer(today);
        return products;
    }

    /**
     * Find Products which include the given description
     *
     * @param description
     * @return
     */
    public Optional<Product> findProductsByDescriptionContains(String description) {
        return productRepository.findProductsByDescriptionContains(description);
    }

    /**
     * Find products with keyword which could be present
     * as it is OR as part in the name or in the description of the product
     *
     * @param keyword
     * @return
     */
    public List<Product> findProductsByKeyword(String keyword) {
        return productRepository.findProductsByKeyword(keyword);
    }

    /**
     * Add in the DB a product only if the product name does not exists already in the db.
     *
     * @param product
     */
    public void addNewProduct(Product product) {
        Optional<Product> productByName = productRepository
                .findProductByName(product.getName());

        //TODO check if it is business correct. If yes... the searches need some fixes  ( findByName - not list)
        //TODO when we add a product, a new category is creating every time, this need to be fixed
        if (productByName.isPresent()) {
            throw new IllegalStateException("The product already exists!!");
        }
        productRepository.save(product);

    }

    /**
     * Add in the DB a product only if the product name does not exists already in the db.
     *
     * @param products
     */
    public void addNewListProducts(List<Product> products) {

        for (Product product : products) {
            Optional<Product> productByName = productRepository
                    .findProductByName(product.getName());
            if (productByName.isPresent()) {
                throw new IllegalStateException("The product already exists!!");
            }
        }
        productRepository.saveAll(products);

    }

    /**
     * edit a product in the DB only if the product exist.
     *
     * @param product
     */
    public void editProduct(Product product) {
        Optional<Product> DB_prod = productRepository.findProductById(product.getId());
        if (DB_prod.isPresent()) {
            productRepository.save(product);
        } else {
            throw new IllegalArgumentException("The product id: " + product.getId() + " does not exist!");
        }
    }

    /**
     * delete a Product in the DB only if the Product exist.
     *
     * @param id
     */
    public void deleteProduct(Long id) {
        Optional<Product> prodById = productRepository.findProductById(id);
        if (prodById.isPresent()) {
            productRepository.deleteAllById(id);
        }

    }
}
