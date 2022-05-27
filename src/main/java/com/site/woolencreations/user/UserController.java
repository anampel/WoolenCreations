package com.site.woolencreations.user;

import com.site.woolencreations.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/findPointsByUsername")
    public Optional<User> findPointsByUsername(@RequestParam String username) {
        return userService.findPointsByUsername(username);
    }

    @GetMapping("/findIfGuest")
    public Boolean findIfGuest(@RequestParam String username) {
        return userService.findIfGuest(username);
    }

    @PostMapping("/add")
    public String registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
        return "Success";
    }

    @GetMapping("/findWishList")
    public List<Product> findUserWishList(@RequestParam Long userId) {
        return userService.findUserWishList(userId);
    }

    @PostMapping("/addToWishlist")
    public String addWishList(@RequestBody WishListDTO wishListDTO){
        userService.addToWishList(wishListDTO.getProductId(), wishListDTO.getUserId());
        return "Success";
    }

    @PutMapping("/edit")
    public String editUser(@RequestBody User user) {
        userService.editUser(user);
        return "Success";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam Long userID) {
        userService.deleteUser(userID);
        return "Success";

    }


}
