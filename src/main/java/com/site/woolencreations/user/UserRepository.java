package com.site.woolencreations.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    @Query("SELECT user FROM User user WHERE user.id= ?1")
    Optional<User> findUserByID(Long id);

    @Query("SELECT user FROM User user WHERE user.username= ?1")
    Optional<User> findUserByUsername(String username);


    @Transactional()
    @Modifying
    void deleteAllById(Long userID);
}
