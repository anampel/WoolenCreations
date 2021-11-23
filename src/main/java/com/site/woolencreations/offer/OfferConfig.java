//package com.site.woolencreations.offer;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class OfferConfig {
//
//    private static final String dateFormat = "yyyy-MM-dd";
//
//    @Bean
//    CommandLineRunner commandLineRunner(OfferRepository repository) {
//        return args -> {
//            Offer o = Offer.builder()
//                    .description("Offer descr")
//                    .start_date("2021-01-10")
//                    .end_date("2022-01-10")
//                    .discount(10.0)
//                    .build();
//
//            repository.save(o);
//        };
//
//
//    }
//}
