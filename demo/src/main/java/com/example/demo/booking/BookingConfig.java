package com.example.demo.booking;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class name: BookingConfig
 * Date: November 18, 2024
 * Programmer name: Israel Alcocer
 * Configuration class for setting up the initial booking data or behavior at application startup.
 * This class is used to configure Spring beans and provide custom logic for initializing or interacting 
 * with the application's booking repository at startup.
 */
@Configuration
public class BookingConfig {

    /**
     * Creates a {@link CommandLineRunner} bean that can be used to execute specific logic 
     * after the Spring Boot application has started. The runner has access to the 
     * {@link BookingRepository} to interact with the booking data layer.
     * 
     * <p>The method is empty in this example, but it can be extended to perform tasks like 
     * initializing booking data, performing checks, or pre-populating the database.</p>
     * 
     * @param repository The {@link BookingRepository} bean used for interacting with the database.
     * @return A {@link CommandLineRunner} that can be executed when the application starts.
     */
    @Bean
    CommandLineRunner commandLineRunner(BookingRepository repository) {
        return args -> {
            // Custom startup logic (currently empty)
        };
    }
}
