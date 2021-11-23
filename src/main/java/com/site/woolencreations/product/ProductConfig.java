package com.site.woolencreations.product;

import com.site.woolencreations.category.Category;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunnerProduct(ProductRepository repository) {
        return args -> {
            Product p = Product.builder()
                    .description("aaaa")
                    .discount(10.0)
                    .name("kaskol")
                    .price(15.0)
                    .categoryList(List.of(
                            Category
                                    .builder()
                                    .categoryName("rouxa")
                                    .build(),
                            Category
                                    .builder()
                                    .categoryName("malina")
                                    .build()

                    ))
//                    .offerId(1L)
                    .points(0)
                    .build();

            repository.save(p);
        };


    }
}
