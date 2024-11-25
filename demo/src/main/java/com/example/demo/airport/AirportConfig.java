package com.example.demo.airport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Class name: Airport Config
 * @since 2024-11-17
 * @author Miguel Santoscoy
 * Configuration class that runs on application startup to populate the {@link AirportRepository}
 * with a set of predefined airport data. The data is initialized using a {@link CommandLineRunner}
 * bean, which is executed when the Spring Boot application starts.
 * 
 * <p>This configuration class defines a {@link CommandLineRunner} bean that creates a set of {@link Airport}
 * objects and stores them in the repository. This can be useful for seeding the database with default or sample data
 * when the application is first run.</p>
 */
@Configuration
public class AirportConfig {

    /**
     * Defines a {@link CommandLineRunner} bean that runs on application startup and populates the
     * {@link AirportRepository} with predefined airport data.
     * 
     * <p>When the Spring Boot application starts, this method is invoked automatically to create and save 
     * a list of predefined {@link Airport} objects to the database. This can help to seed the database with initial data.</p>
     * 
     * @param repository The {@link AirportRepository} instance used to interact with the database.
     * @return A {@link CommandLineRunner} that executes the data population task.
     */
    @Bean
    CommandLineRunner commandLineRunner(AirportRepository repository) {
        return args -> {
            // Create predefined airports and save them to the repository
            Airport LAX = new Airport(1, "Los Angeles International Airport", "LAX", "Los Angeles, California", -8);
            Airport JFK = new Airport(2, "John F. Kennedy International Airport", "JFK", "Queens, New York", -5);
            Airport DFW = new Airport(3, "Dallas Fort Worth International Airport", "DFW", "Dallas, Texas", -6);
            Airport ATL = new Airport(4, "Hartsfield-Jackson Atlanta International Airport", "ATL", "Atlanta, Georgia", -6);
            Airport DEN = new Airport(5, "Denver International Airport", "DEN", "Denver, Colorado", -7);
            Airport DXB = new Airport(6, "Dubai International Airport", "DXB", "Garhoud, Dubai", 4);
            Airport HND = new Airport(7, "Tokyo Haneda Airport", "HND", "Tokyo, Japan", 9);
            Airport LHR = new Airport(8, "Heathrow Airport", "LHR", "London, England", 0);
            Airport DEL = new Airport(9, "Indira Gandhi International Airport", "DEL", "Delhi, India", 5);

            // Save the airports to the repository
            repository.saveAll(List.of(LAX, JFK, DFW, ATL, DEN, DXB, HND, LHR, DEL));
        };
    }
}
