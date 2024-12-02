package com.example.demo.payment;

import jakarta.persistence.*;

/**
 * @author Israel Alcocer
 * @since Nov 25, 2024
 * Represents a payment entity with details like card number, expiration info, 
 * cardholder's name, security code, and payment amount.
 * 
 * This entity is mapped to the `Payment` table in the database and is used to 
 * store and retrieve payment information.
 */
@Entity
public class Payment {

    /**
     * Unique identifier for the payment record.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    /**
     * The card number used for the payment.
     */
    private Long cardNumber;

    /**
     * The expiration information of the card (e.g., MM/YY).
     */
    private String expirationInfo;

    /**
     * The first name of the cardholder.
     */
    private String firstName;

    /**
     * The last name of the cardholder.
     */
    private String lastName;

    /**
     * The security code (CVV) associated with the card.
     */
    private Integer securityCode;

    /**
     * The amount of money to be paid in this transaction.
     */
    private Integer paymentAmount;

    /**
     * Constructs a new Payment object with the specified details.
     * 
     * @param cardNumber the card number used for the payment
     * @param expirationInfo the expiration information of the card
     * @param firstName the first name of the cardholder
     * @param lastName the last name of the cardholder
     * @param securityCode the security code (CVV) of the card
     * @param paymentAmount the amount to be paid in this transaction
     */
    public Payment(Long cardNumber, String expirationInfo, String firstName, String lastName, Integer securityCode, Integer paymentAmount) {
        this.cardNumber = cardNumber;
        this.expirationInfo = expirationInfo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.securityCode = securityCode;
        this.paymentAmount = paymentAmount;
    }

    /**
     * Gets the unique identifier of the payment.
     * 
     * @return the payment ID
     */
    public Integer getPaymentId() {
        return paymentId;
    }

    /**
     * Sets the unique identifier of the payment.
     * 
     * @param paymentId the payment ID to set
     */
    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Gets the card number associated with the payment.
     * 
     * @return the card number
     */
    public Long getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the card number for the payment.
     * 
     * @param cardNumber the card number to set
     */
    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the expiration information of the card.
     * 
     * @return the expiration info (e.g., MM/YY)
     */
    public String getExpirationInfo() {
        return expirationInfo;
    }

    /**
     * Sets the expiration information of the card.
     * 
     * @param expirationInfo the expiration info to set
     */
    public void setExpirationInfo(String expirationInfo) {
        this.expirationInfo = expirationInfo;
    }

    /**
     * Gets the first name of the cardholder.
     * 
     * @return the first name of the cardholder
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the cardholder.
     * 
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the cardholder.
     * 
     * @return the last name of the cardholder
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the cardholder.
     * 
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the security code (CVV) of the card.
     * 
     * @return the security code
     */
    public Integer getSecurityCode() {
        return securityCode;
    }

    /**
     * Sets the security code (CVV) for the card.
     * 
     * @param securityCode the security code to set
     */
    public void setSecurityCode(Integer securityCode) {
        this.securityCode = securityCode;
    }

    /**
     * Gets the payment amount for the transaction.
     * 
     * @return the payment amount
     */
    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the payment amount for the transaction.
     * 
     * @param paymentAmount the amount to set
     */
    public void setPaymentAmount(Integer paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
