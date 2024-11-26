package com.example.demo.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    // Create or update payment
    @PostMapping
    public ResponseEntity<Payment> createOrUpdatePayment(@RequestBody Payment payment){
        Payment savedPayment = paymentService.createOrUpdatePayment(payment);
        return ResponseEntity.ok(savedPayment);
    }

    // Get payment by id
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Integer id){
        Optional<Payment> payment = paymentService.getPaymentById(id);
        return payment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete payment by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Integer id){
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    // Process payment
    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody Payment payment){
        String result = paymentService.processPayment(payment);
        return ResponseEntity.ok(result);
    }
}
