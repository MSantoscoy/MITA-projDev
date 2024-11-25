package com.example.demo.passenger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class name: PassengerConfig
 * @since 2024-11 20
 * @author Miguel Santoscoy
 * Configuration class for initializing Passenger-related data.
 * This class provides a {@link CommandLineRunner} bean that is executed when the Spring Boot application starts.
 * The runner allows for the initialization of data, such as pre-populating the passenger database.
 * 
 * The class currently has the structure to save passengers in the repository during application startup.
 * Additional passenger data can be added or customized as needed.
 */
@Configuration
public class PassengerConfig {

    /**
     * Defines a CommandLineRunner bean that runs when the Spring Boot application starts.
     * This method can be used to populate the repository with sample data or perform other initialization tasks.
     * 
     * @param repository The repository used to perform CRUD operations on Passenger entities.
     * @return A CommandLineRunner that saves predefined passenger data into the repository on application startup.
     */
    @Bean
    CommandLineRunner commandLineRunner(PassengerRepository repository) {
        return args -> {
            // Code to initialize passengers can be added here.
            repository.saveAll(
                // Example of how to populate data (you can add more passengers):
                List.of(
                    new Passenger(1, "John", "Doe", 123456789),
                    new Passenger(2, "Jane", "Smith", 987654321)
                )
            );
        };
    }
}
