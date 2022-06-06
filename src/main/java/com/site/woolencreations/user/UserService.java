package com.site.woolencreations.user;

import com.site.woolencreations.product.Product;
import com.site.woolencreations.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public UserService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    /**
     * Find All Users
     * @return
     */
    public List<User> getUser(){
        return userRepository.findAll();
    }
    /**
     * Find All Users by Username
     * @return
     */
    public Optional<User> findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    /**
     * Find All Users by id
     * @return
     */
    public Optional<User> findUserByUserID(Long id){
        return userRepository.findUserByID(id);
    }

    /**
     * Find points of a user by username
     * @return
     */
    public Optional<User> findPointsByUsername(String username){
        return userRepository.findPointsByUsername(username);
    }

    /**
     * Find if the user is guest
     * @return
     */

    public Boolean findIfGuest(String username){

        return userRepository.findIfGuest(username);
    }
    /**
     * Add a new product to the wishlist of a user
     * @param productId
     * @param userId
     * @return
     */
    public void addToWishList(Long productId, Long userId) {
        Optional<User> user = userRepository.findUserByID(userId);
        if (user.isPresent()) {
            Optional<Product> productById = productRepository.findProductById(productId);
            if (productById.isPresent()) {

                user.get().getWishList().add(productById.get());
            }else{
                throw new IllegalArgumentException("The product does not exist");
            }
            userRepository.save(user.get());
        }else
            throw new IllegalArgumentException("The user does not exist");
    }

    /**
     * Remove a product from the wishlist of a user
     * @param productId
     * @param userId
     * @return
     */
    public void removeFromWishList(Long productId, Long userId){
        Optional<User> user = userRepository.findUserByID(userId);
        if (user.isPresent()) {
            Optional<Product> productById = productRepository.findProductById(productId);
            if (productById.isPresent()) {
                user.get().getWishList().remove(productById.get());
            }else{
                throw new IllegalArgumentException("The product does not exist");
            }
            userRepository.save(user.get());
        }else
            throw new IllegalArgumentException("The user does not exist");
    }
    /**
     * Find the wishlist of a user
     * @param id of the user
     * @return
     */
    public List<Product> findUserWishList(Long id){
        return userRepository.findUserWishList(id);
    }

    /**
     *add in the DB a User only if the User name does not exists already in the db.
     * @param user
     */
    public void addNewUser(User user) {
        try {
            String uname = user.getUsername();
            Optional<User> UserByUsername = userRepository
                    .findUserByUsername(uname);
            if(UserByUsername.isPresent()){
                throw new IllegalStateException("The User already exists!!");
            }
            userRepository.save(user);
        }catch (Exception e){
            throw new IllegalArgumentException("IllegalArgument returned from findUserByUsername()");
        }
    }
    public User authenticateLogin(String username, String psw) {
        try {
            Optional<User> UserByUsername = userRepository
                    .findUserByUsername(username);
            if(!UserByUsername.isPresent()){
                throw new IllegalStateException("The User does not exist!!");
            }
             if(!UserByUsername.get().getPassword().equals(psw)){
                throw new IllegalStateException("The password is incorrect");
            }
             return UserByUsername.get();
        }catch (Exception e){
            throw new IllegalArgumentException("IllegalArgument returned from findUserByUsername()");
        }
    }

    /**
     *edit a User in the DB only if the User exist.
     * @param user
     */
    public void editUser(User user) {
        Optional<User> DB_user = userRepository.findUserByID(user.getId());
        if (DB_user.isPresent()) {
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("The user with e-mail: "+user.getUsername() +" does not exist!");
        }
    }

    /**
     *delete a User in the DB only if the User exist.
     * @param userID
     */
    public void deleteUser(Long userID){
        Optional<User> UserByID = userRepository.findUserByID(userID);
        if(UserByID.isPresent()){
            userRepository.deleteAllById(userID);
        }

    }
    public static Boolean authenticateLogin2(String username, String psw) {
        try {
            if(username.contains("1234")){
                throw new IllegalStateException("Illegal username!!");
            }
            if(psw.isBlank()){
                throw new IllegalStateException("The password is incorrect");
            }
            return true;
        }catch (Exception e){
            throw new IllegalArgumentException("IllegalArgument returned from findUserByUsername()");
        }
    }


    public static int getPoints(Long id) {
        int points = 0;
        if (id == 1) {
            points = 20;
        } else if (id == 2) {
            points=30;
        } else if (id ==3) {
            points=40;
        }
        return points;
    }
}
