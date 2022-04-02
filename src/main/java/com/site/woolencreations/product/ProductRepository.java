package com.site.woolencreations.product;

import com.site.woolencreations.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByName(String name);

    Optional<Product> findProductById(Long id);

    @Transactional()
    @Modifying
    void deleteAllById(Long id);

    Optional<Product> findProductsByDescriptionContains(String description);

    /**
     * It will be used by the search of the page
     *
     * @param keyword
     * @return
     */
    @Query("SELECT p FROM Product p WHERE lower(p.description) LIKE lower(concat('%', :keyword ,'%')) OR lower(p.name) LIKE  lower(concat('%', :keyword ,'%'))")
    List<Product> findProductsByKeyword(String keyword);

    /**
     * It will be used by clicking the category link/button
     *
//     * @param categoryName
     * @return
     */
    List<Product> findByCategoryListContains(Category category);

    String findQuery = "SELECT * FROM Product p WHERE p.id in (select p.id from Product p, Category c, PRODUCT_CATEGORY pc where p.id = pc.product_id and c.category_id=pc.category_id and c.category_name = ?1) " +
            "and p.id in (select p.id from Product p, Category c , PRODUCT_CATEGORY pc where p.id = pc.product_id and c.category_id=pc.category_id and c.category_name = ?2)";
    @Query(value = findQuery, nativeQuery = true)
    List<Product> findProductsBySubCategory(String category, String subcategory);
    /**
     * It will be used in a filtering search where you defined the discount
     *
     * @param discount
     * @param today
     * @return
     */
    @Query("SELECT p FROM Product p, Offer f WHERE f.discount =?1 and f.start_date <= ?2 and f.end_date >= ?2")
    List<Product> findProductByDiscount(Double discount, Date today);

    //TODO think about a filtering search and construct a query with all necessary filters. For example (price range / category / etc.)

    @Query("SELECT distinct p FROM Product p, Offer f WHERE p.offer.id is not null and p.offer.id = f.id and f.start_date <= ?1 and f.end_date >= ?1")
    List<Product> findAllProductsInOffer(Date today);

}
