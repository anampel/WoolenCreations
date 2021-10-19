package com.site.woolencreations.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository) {
        return args -> {
            Product a = new Product();
            a.setName("kaskol");
            a.setDescription("mpla mpla");
            a.setDiscount(0.05);
            a.setPrice(25.30);
            repository.save(a);
        };


    }
}
