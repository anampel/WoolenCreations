package com.site.woolencreations.user;

import com.site.woolencreations.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    @Query("SELECT user FROM User user WHERE user.id= ?1")
    Optional<User> findUserByID(Long id);

    @Query("SELECT user FROM User user WHERE user.username= ?1")
    Optional<User> findUserByUsername(String username);

    @Query("SELECT user.points FROM User user WHERE user.username=?1")
    Optional<User> findPointsByUsername(String username);

    @Query("SELECT user.guest FROM User user WHERE user.username=?1")
    Boolean findIfGuest(String username);

    @Query("SELECT u.wishList FROM User u where u.id=?1")
    List<Product> findUserWishList(Long userId);

    @Transactional()
    @Modifying
    void deleteAllById(Long userID);


    Boolean existsByUsername(String username);
}
