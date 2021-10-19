package com.site.woolencreations.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner1(UserRepository repository) {
        return args -> {
            User user = new User();
            user.setUsername("anam@gmail.com");
            user.setFirst_name("Ana");
            user.setLast_name("Mpel");
            user.setPassword("XXX");
            user.setAddressID(0001);
            user.setPoints(150);
            user.setGuest(false);
            user.setRole("customer");
            user.setPhone("6900000000");
            repository.save(user);
        };
    }
}
