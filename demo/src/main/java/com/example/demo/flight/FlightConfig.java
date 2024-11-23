package com.example.demo.flight;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class name: Flight Config
 * @since 2024-11-15
 * @author Miguel Santoscoy
 * Configuration class for initializing flight-related beans at application startup.
 * <p>
 * This class uses Spring's {@link CommandLineRunner} interface to execute logic at startup.
 * However, in this current implementation, it does not perform any specific logic when the application starts.
 * </p>
 */
@Configuration
public class FlightConfig {

    /**
     * Defines a {@link CommandLineRunner} bean that is executed after the application context is loaded.
     * <p>
     * This method is currently not performing any logic, but it provides a place for initializing or seeding data
     * related to flights if needed in the future.
     * </p>
     *
     * @param repository The {@link FlightRepository} to interact with the database.
     * @return A {@link CommandLineRunner} that is executed during application startup.
     */
    @Bean
    CommandLineRunner commandLineRunner(FlightRepository repository){
        return args -> {
            // No implementation is currently provided
        };
    }
}
