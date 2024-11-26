package com.example.demo.payment;

import jakarta.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private Long cardNumber;
    private String expirationInfo;
    private String firstName;
    private String lastName;
    private Integer securityCode;
    private Integer paymentAmount;

    // Constructor

    public Payment(Long cardNumber, String expirationInfo, String firstName, String lastName, Integer securityCode, Integer paymentAmount) {
        this.cardNumber = cardNumber;
        this.expirationInfo = expirationInfo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.securityCode = securityCode;
        this.paymentAmount = paymentAmount;
    }

    // Getters and Setters
    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationInfo() {
        return expirationInfo;
    }

    public void setExpirationInfo(String expirationInfo) {
        this.expirationInfo = expirationInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Integer securityCode) {
        this.securityCode = securityCode;
    }

    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Integer paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}