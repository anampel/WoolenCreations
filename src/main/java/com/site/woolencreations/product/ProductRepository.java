package com.site.woolencreations.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.name= ?1")
    Optional<Product> findProductByName(String name);

    Optional<Product> findProductById(String id);

}
