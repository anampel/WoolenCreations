package com.site.woolencreations.offer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@Configuration
public class OfferConfig {

    private static final String dateFormat = "yyyy-MM-dd";

    @Bean
    CommandLineRunner commandLineRunnerOffer(OfferRepository repository) {
        return args -> {
            Offer o = Offer.builder()
                    .description("Offer descr")
                    .start_date(new SimpleDateFormat(dateFormat).parse("2021-01-10"))
                    .end_date(new SimpleDateFormat(dateFormat).parse("2021-01-25"))
                    .discount(10.0)
                    .build();
            repository.save(o);
        };


    }
}
