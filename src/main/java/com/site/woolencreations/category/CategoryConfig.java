package com.site.woolencreations.category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {
    @Bean
    CommandLineRunner commandLineRunnerCategory(CategoryRepository repo) {
        return args -> {
            Category category = Category.builder()
                    .categoryName("Men")
                    .build();
            Category category1 = Category.builder()
                    .categoryName("Women")
                    .build();
            Category category2 = Category.builder()
                    .categoryName("Kinds")
                    .build();
            Category category3 = Category.builder()
                    .categoryName("Home")
                    .build();
            Category category4 = Category.builder()
                    .categoryName("Accessories")
                    .build();
            Category category5 = Category.builder()
                    .categoryName("Clothes")
                    .build();
            Category category6 = Category.builder()
                    .categoryName("Underwear")
                    .build();
            Category category7 = Category.builder()
                    .categoryName("Bedroom")
                    .build();
            Category category8 = Category.builder()
                    .categoryName("Kitchen")
                    .build();
            Category category9 = Category.builder()
                    .categoryName("Decoration")
                    .build();
            repo.save(category);
            repo.save(category1);
            repo.save(category2);
            repo.save(category3);
            repo.save(category4);
            repo.save(category5);
            repo.save(category6);
            repo.save(category7);
            repo.save(category8);
            repo.save(category9);
        };
    }
}
