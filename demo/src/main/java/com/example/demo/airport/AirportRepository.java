package com.example.demo.airport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface name: Airport Repository
 * @since 2024-11-15
 * @author Miguel Santoscoy
 * The {@code AirportRepository} interface provides the mechanism for CRUD operations 
 * on {@link Airport} entities. It extends {@link JpaRepository} which provides built-in methods 
 * for common database operations.
 * <p>
 * This repository is responsible for accessing the {@code Airport} data store and 
 * interacting with the database. It allows for operations such as saving, finding, 
 * and deleting airport records.
 * </p>
 * <p>
 * The interface is marked with the {@link Repository} annotation to indicate that 
 * it is a Spring Data repository and it will be automatically detected and managed 
 * by Spring's dependency injection container.
 * </p>
 * 
 * @author [Your Name]
 * @since [Version]
 */
@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {

    // No additional methods are defined here as JpaRepository provides all the 
    // necessary CRUD operations for interacting with the database.
}
