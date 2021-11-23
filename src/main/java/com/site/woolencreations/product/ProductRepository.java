package com.site.woolencreations.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

    Optional<Product> findProductByName(String name);
    Optional<Product> findProductById(Long id);
    @Transactional()
    @Modifying
    void deleteAllById(Long id);
    Optional<Product> findProductsByDescriptionContains(String description);

    @Query("SELECT p FROM Product p WHERE p.description LIKE %:keyword% OR p.name LIKE  %:keyword%")
    List<Product> findProductsByKeyword(String keyword);

    @Query("SELECT p FROM Product p, Category c WHERE c.categoryName = ?1")
    List<Product> findProductsByCategory(String categoryName);
}
