package com.example.demo.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface name: FlightRepository
 * @since 2024-11-17
 * @author Miguel Santoscoy
 * The {@link FlightRepository} interface provides the mechanism for CRUD operations 
 * on {@link Flight} entities. It extends the {@link JpaRepository} interface, which 
 * provides built-in methods for interacting with the database. This repository interface 
 * eliminates the need for boilerplate code to perform database operations like save, 
 * find, update, and delete for flight-related data.
 * <p>
 * By extending {@link JpaRepository}, it automatically gains several useful methods 
 * such as:
 * <ul>
 *   <li>{@link JpaRepository#save(Object)} - to save a flight entity to the database.</li>
 *   <li>{@link JpaRepository#findById(Object)} - to retrieve a flight by its ID.</li>
 *   <li>{@link JpaRepository#findAll()} - to retrieve all flights from the database.</li>
 *   <li>{@link JpaRepository#deleteById(Object)} - to delete a flight by its ID.</li>
 * </ul>
 * <p>
 * This interface uses Spring Data JPA to simplify the interaction between the Java 
 * application and the underlying relational database, avoiding the need for custom 
 * query implementations.
 * </p>
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    // No additional methods are required here as JpaRepository provides built-in methods
}
