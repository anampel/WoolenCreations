package com.site.woolencreations.product;

import com.site.woolencreations.misc.Category;
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
                    .name("kaskol")
                    .price(15.0)
                    .categoryList(List.of(
                            Category
                                    .builder()
                                    .categoryName("Men")
                                    .build(),
                            Category
                                    .builder()
                                    .categoryName("Hat")
                                    .build(),
                            Category
                                    .builder()
                                    .categoryName("Accessories")
                                    .build()
                    ))
                    .points(0)
                    .build();

            repository.save(p);
        };


    }
}
