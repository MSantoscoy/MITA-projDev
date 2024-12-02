package com.example.demo.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Israel Alcocer
 * @since Nov 26, 2024
 * Service class responsible for handling payment-related operations, including 
 * creating or updating payments, retrieving a payment by its ID, deleting payments,
 * and processing payment transactions.
 */
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    /**
     * Constructor for initializing the PaymentService with the required PaymentRepository.
     * 
     * @param paymentRepository The repository used to interact with the payment data.
     */
    @Autowired
    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    /**
     * Creates a new payment or updates an existing one in the repository.
     * 
     * @param payment The payment object to be created or updated.
     * @return The created or updated payment object.
     */
    public Payment createOrUpdatePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    /**
     * Retrieves a payment by its unique ID.
     * 
     * @param id The ID of the payment to be retrieved.
     * @return An Optional containing the payment if found, otherwise an empty Optional.
     */
    public Optional<Payment> getPaymentById(Integer id){
        return paymentRepository.findById(id);
    }

    /**
     * Deletes a payment from the repository based on the provided payment ID.
     * 
     * @param id The ID of the payment to be deleted.
     */
    public void deletePayment(Integer id){
        paymentRepository.deleteById(id);
    }

    /**
     * Processes a payment by verifying that the payment amount is valid (greater than 0).
     * 
     * @param payment The payment object to be processed.
     * @return A message indicating whether the payment was processed successfully or if
     *         the payment amount is invalid.
     */
    public String processPayment(Payment payment){
        if (payment.getPaymentAmount() > 0){
            return "Payment of " + payment.getPaymentAmount() + " processed successfully.";
        }
        else {
            return "Invalid payment amount.";
        }
    }
}
