package com.site.woolencreations.order;

import com.site.woolencreations.user.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class OrderConfig {
    private static final String dateFormat = "yyyy-MM-dd";

    @Bean
    CommandLineRunner commandLineRunnerOrder(OrderRepository repository) {
        return args -> {
            Order o = Order.builder()
//                    .user(
//                            new User().builder()
//                                    .id(1L)
//                                    .build()
//                    )
                    .date(new SimpleDateFormat(dateFormat).parse("2021-01-10"))
                    .phone("6955555555")
                    .paid(true)
                    .shipping_company_name("ACS")
                    .state("IN PROGRESS")
                    .shipping_cost(56.50)
                    .build();
            repository.save(o);

        };
    }
}
