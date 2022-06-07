package com.site.woolencreations.security;

import com.site.woolencreations.security.jwt.JwtProvider;
import com.site.woolencreations.security.messages.JwtResponse;
import com.site.woolencreations.security.messages.request.LoginForm;
import com.site.woolencreations.security.messages.request.SignUpForm;
import com.site.woolencreations.user.User;
import com.site.woolencreations.user.UserRepository;
import com.site.woolencreations.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class SecurityController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtProvider jwtProvider;

    public SecurityController(UserService userService, AuthenticationManager authenticationManager, UserRepository userRepository, PasswordEncoder encoder, JwtProvider jwtProvider) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        encoder.encode(loginRequest.getPassword())
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignUpForm signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }
        // Creating user's account
        userRepository.save(User.builder()
                .username(signUpRequest.getUsername())
                .password(encoder.encode(signUpRequest.getPassword()))
                .firstName(signUpRequest.getFirstname())
                .lastName(signUpRequest.getLastname())
                .role(signUpRequest.getRole())
                .build());

        return ResponseEntity.ok().body("User registered successfully!");
    }
}
