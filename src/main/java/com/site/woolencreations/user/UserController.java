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
 * http://localhost:8080/api/v1/user/findAll?username='anam@gmail.com'
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
    @GetMapping("/findByName")
    public Optional<User> getUserByUsername(@RequestParam String username) {
        return userService.findUserByUsername(username);
    }

    @PostMapping("/add")
    public String registerNewUser (@RequestBody User user){
        userService.addNewUser(user);
        return "Success";

    }
}
