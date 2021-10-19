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
     * Find All Users
     * @return
     */
    public Optional<User> findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }


    /**
     *add in the DB a User only if the User name does not exists already in the db.
     * @param user
     */
    public void addNewUser(User user) {
        Optional<User> UserByUsername = userRepository
                .findUserByUsername(user.getUsername());

        if(UserByUsername.isPresent()){
            throw new IllegalStateException("The User already exists!!");
        }
        userRepository.save(user);

    }
}
