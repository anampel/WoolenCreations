package com.site.woolencreations.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/user")
/**
 * Send request to postman
 * GET
 * http://localhost:8080/api/v1/user/findByName?username='anam@gmail.com'
 * */
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("/findByUsername")
    public Optional<User> getUserByUsername(@RequestParam String username) {
        return userService.findUserByUsername(username);
    }

    @GetMapping("/findByUserID")
    public Optional<User> getUserByUserID(@RequestParam Long id) {
        return userService.findUserByUserID(id);
    }

    @PostMapping("/add")
    public String registerNewUser (@RequestBody User user){
        userService.addNewUser(user);
        return "Success";

    }

    //TODO check if it works properly
    @PutMapping("/edit")
    public String editUser (@RequestBody User user){
        userService.editUser(user);
        return "Success";

    }

    @DeleteMapping("/delete")
    public String deleteUser (@RequestParam Long userID){
        userService.deleteUser(userID);
        return "Success";

    }
}
