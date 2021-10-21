package com.site.woolencreations.user;

import com.site.woolencreations.misc.Address;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner1(UserRepository repository) {
        return args -> {
            Address address = Address
                    .builder()
                    .address("Argurokastrou")
                    .number(38)
                    .postCode("15343")
                    .city("Agia Paraskevi")
                    .country("Greece")
                    .build();

            List<Address> addresslist = new ArrayList();
            addresslist.add(address);

            User user = User
                    .builder()
                    .username("anam@gmail.com")
                    .first_name("Ana")
                    .last_name("Mpel")
                    .password("XXX")
                    .addresses(addresslist)
                    .points(150)
                    .guest(false)
                    .role("customer")
                    .phone("6900000000")
                    .build();
            repository.save(user);
        };
    }
}
