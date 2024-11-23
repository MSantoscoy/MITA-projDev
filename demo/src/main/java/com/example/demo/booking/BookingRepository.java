package com.example.demo.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class name: BookingRepository
 * @since 2024-11-20
 * @author Israel Alcocer
 * Repository interface for performing CRUD operations on {@link Booking} entities.
 * This interface extends {@link JpaRepository}, which provides built-in methods
 * for interacting with the database and managing {@link Booking} records.
 * 
 * <p>The {@code BookingRepository} is automatically implemented by Spring Data JPA,
 * which provides common database operations like save, find, delete, and others.</p>
 * 
 * <p>This repository is used to abstract data access and allow for easier interaction 
 * with the underlying database without needing to write SQL queries manually.</p>
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    // The JpaRepository interface provides all the basic CRUD operations 
    // for the Booking entity, so no additional methods are required here.
}
