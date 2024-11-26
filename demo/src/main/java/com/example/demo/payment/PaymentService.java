package com.example.demo.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    // Create or update a payment
    public Payment createOrUpdatePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    // Get a payment by id
    public Optional<Payment> getPaymentById(Integer id){
        return paymentRepository.findById(id);
    }

    // Delete a payment
    public void deletePayment(Integer id){
        paymentRepository.deleteById(id);
    }

    // Process payment
    public String processPayment(Payment payment){
        if (payment.getPaymentAmount() > 0){
            return "Payment of " + payment.getPaymentAmount() + " processed successfully.";
        }
        else {
            return "Invalid payment amount.";
        }
    }
}