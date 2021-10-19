package com.site.woolencreations.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    @Query("SELECT user FROM User user WHERE user.username= ?1")
    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByPhone(String phone);
}
