package com.example.demo.booking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookingConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookingRepository repository){
        return args -> {

        };

    }
}