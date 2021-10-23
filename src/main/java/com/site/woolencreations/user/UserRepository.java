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
    Optional<User> findUserByID(int id);

    @Query("SELECT user FROM User user WHERE user.username= ?1")
    Optional<User> findUserByUsername(String username);

    @Transactional()
    @Modifying
    @Query("UPDATE  User user SET user.username = ?1 , user.password =?2 , user.first_name =?3 , user.last_name =?4, user.phone =?5, user.addresses =?6, user.role = ?7, user.points = ?8, user.guest =?9 WHERE user.username= ?1")
    void editUser(User user);

    @Transactional()
    @Modifying
    @Query("DELETE FROM User WHERE id = ?1")
    void deleteByUserID(int userID);
}
