package com.example.demo.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author Israel Alcocer
 * @since Nov 25, 2024
 * REST controller for managing payment transactions. 
 * This controller provides endpoints for creating, updating, retrieving, 
 * deleting, and processing payments.
 */
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    /**
     * Constructs a new PaymentController with the specified PaymentService.
     *
     * @param paymentService The service to handle payment-related logic.
     */
    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    /**
     * Creates or updates a payment. If the payment already exists, it will be updated.
     * Otherwise, a new payment will be created.
     * 
     * @param payment The payment object to be created or updated.
     * @return A {@link ResponseEntity} containing the saved payment object.
     */
    @PostMapping
    public ResponseEntity<Payment> createOrUpdatePayment(@RequestBody Payment payment){
        Payment savedPayment = paymentService.createOrUpdatePayment(payment);
        return ResponseEntity.ok(savedPayment);
    }

    /**
     * Retrieves a payment by its unique identifier.
     * 
     * @param id The ID of the payment to retrieve.
     * @return A {@link ResponseEntity} containing the payment if found, or a 404 not found response if the payment does not exist.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Integer id){
        Optional<Payment> payment = paymentService.getPaymentById(id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Deletes a payment by its unique identifier.
     * 
     * @param id The ID of the payment to delete.
     * @return A {@link ResponseEntity} indicating that the payment has been deleted (204 No Content).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Integer id){
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Processes a payment, typically interacting with external services to complete the transaction.
     * 
     * @param payment The payment object to be processed.
     * @return A {@link ResponseEntity} containing the result of the payment processing (e.g., success or failure message).
     */
    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody Payment payment){
        String result = paymentService.processPayment(payment);
        return ResponseEntity.ok(result);
    }
}
