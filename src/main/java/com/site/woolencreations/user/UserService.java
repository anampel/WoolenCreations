package com.site.woolencreations.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
     *add in the DB a User only if the User name does not exists already in the db.
     * @param user
     */
    public void addNewUser(User user) {
        try {
            Optional<User> UserByUsername = userRepository
                    .findUserByUsername(user.getUsername());
            if(UserByUsername.isPresent()){
                throw new IllegalStateException("The User already exists!!");
            }
            userRepository.save(user);
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
}
