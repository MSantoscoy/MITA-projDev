package com.example.demo.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Israel Alcocer
 * @since Nov 25, 2024
 * Repository interface for performing CRUD operations on {@link Payment} entities.
 * This interface extends {@link JpaRepository}, which provides methods for 
 * saving, finding, updating, and deleting {@link Payment} entities.
 * <p>
 * The repository is automatically implemented by Spring Data JPA at runtime,
 * so there is no need to provide an implementation manually.
 * </p>
 * 
 * @see JpaRepository
 * @see Payment
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // No additional methods are needed as JpaRepository already provides 
    // the basic CRUD operations for the Payment entity.
}
