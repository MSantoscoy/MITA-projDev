package com.example.demo.payment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Israel Alcocer
 * @since Nov 25, 2024
 * Configuration class for initializing and setting up the payment-related components 
 * at the application startup. This class contains a {@link CommandLineRunner} bean 
 * that can be used to run specific tasks after the Spring Boot application has started.
 */
@Configuration
public class PaymentConfig {

    /**
     * Defines a {@link CommandLineRunner} bean that can be used to execute code 
     * after the application context is fully initialized. This runner could 
     * be used for performing actions like populating the database, logging, 
     * or any other initialization tasks related to payments.
     * 
     * @param repository The {@link PaymentRepository} instance to interact with the database.
     * @return A {@link CommandLineRunner} instance that runs upon application startup.
     */
    @Bean
    CommandLineRunner commandLineRunner(PaymentRepository repository){
        return args -> {
            // Place any required initialization logic here. 
        };
    }
}
