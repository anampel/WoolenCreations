package com.site.woolencreations.user;

import com.site.woolencreations.misc.Address;
import com.site.woolencreations.misc.Auth;
import com.site.woolencreations.misc.Response;
import com.site.woolencreations.misc.Role;
import com.site.woolencreations.product.Product;
import com.site.woolencreations.security.messages.request.LoginForm;
import com.site.woolencreations.security.messages.request.SignUpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.site.woolencreations.message.request.LoginForm;
//import com.site.woolencreations.message.request.SignUpForm;
import com.site.woolencreations.security.messages.JwtResponse;
//import com.site.woolencreations.model.Role;
//import com.site.woolencreations.model.RoleName;
//import com.site.woolencreations.user.User;
//import com.site.woolencreations.repository.RoleRepository;
//import com.site.woolencreations.user.UserRepository;
import com.site.woolencreations.security.jwt.JwtProvider;
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
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("/findUserByUsername")
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

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
        List<Address> addresses = new ArrayList<>();
        List<Product> wishlist = new ArrayList<>();
        // Creating user's account
        User user = new User((long) (userRepository.findAll().size()+1), signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getFirstname(), signUpRequest.getLastname(), "", addresses,
                wishlist, signUpRequest.getRole(), 0, false);
        userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }

    @GetMapping("/findWishList")
    public List<Product> findUserWishList(@RequestParam Long userId) {
        return userService.findUserWishList(userId);
    }

    @PostMapping("/addToWishlist")
    public Response addWishList(@RequestBody WishListDTO wishListDTO){
        userService.addToWishList(wishListDTO.getProductId(), wishListDTO.getUserId());
        return Response
                .builder()
                .status("Success")
                .errorCode(0)
                .build();
    }
    @DeleteMapping("/deleteFromWishList")
    public Response removeFromWishList(@RequestParam Long productId, Long userId){
        userService.removeFromWishList(productId, userId);
        return  Response.builder()
                .status("Success")
                .errorCode(0)
                .build();
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
