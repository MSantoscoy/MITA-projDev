package com.example.demo.passenger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface name: PassengerRepository
 * @author Miguel Santoscoy
 * @since 2024-11-22
 * The {@link PassengerRepository} interface provides CRUD operations for managing
 * {@link Passenger} entities in the database. This interface extends {@link JpaRepository},
 * which provides a set of pre-defined methods for interacting with the database.
 * <p>
 * The {@link PassengerRepository} is used by the {@link PassengerService} to access the
 * underlying data store and perform operations such as saving, deleting, and retrieving
 * passenger records.
 * </p>
 * <p>
 * Since this interface extends {@link JpaRepository}, you don't need to define the
 * implementation for the methods, as Spring Data JPA automatically provides them.
 * The repository is automatically implemented at runtime by Spring Data JPA.
 * </p>
 * 
 * 
 */
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

    // JpaRepository provides built-in methods like:
    // - save() for creating and updating Passenger entities
    // - findById() for retrieving a Passenger by its ID
    // - findAll() for retrieving all Passengers
    // - deleteById() for deleting a Passenger by its ID
}
