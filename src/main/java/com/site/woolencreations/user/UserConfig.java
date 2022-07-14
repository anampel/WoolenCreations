package com.site.woolencreations.user;

import com.site.woolencreations.misc.Address;
import com.site.woolencreations.misc.utils.Security;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository) {
        return args -> {
            Address address = Address
                    .builder()
                    .address("Argurokastrou")
                    .number(38)
                    .postCode("15343")
                    .city("Agia Paraskevi")
                    .country("Greece")
                    .build();
            Address address1 = Address
                    .builder()
                    .address("xiou")
                    .number(59)
                    .postCode("15343")
                    .city("Agia Paraskevi")
                    .country("Greece")
                    .build();
            Address address2 = Address
                    .builder()
                    .address("lightship way")
                    .number(9)
                    .postCode("CO2 8GY")
                    .city("Colchester")
                    .country("UK")
                    .build();

            List<Address> addresslist = new ArrayList();
            List<Address> addresslist1 = new ArrayList();
            addresslist.add(address);
            addresslist.add(address1);
            addresslist1.add(address2);

            User user = User
                    .builder()
                    .username("anam@gmail.com")
                    .firstName("Ana")
                    .lastName("Mpel")
                    .password(Security.hashPassword("XXX"))
                    .addressList(addresslist)
                    .points(150)
                    .guest(false)
                    .role("customer")
                    .phone("6900000000")
                    .build();
            User user1 = User
                    .builder()
                    .username("xxx@gmail.com")
                    .firstName("spi")
                    .lastName("kat")
                    .password(Security.hashPassword("aaa"))
                    .addressList(addresslist1)
                    .points(150)
                    .guest(false)
                    .role("customer")
                    .phone("6900000001")
                    .build();
            repository.save(user);
            repository.save(user1);
        };
    }
}
