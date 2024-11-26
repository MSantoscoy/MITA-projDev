package com.example.demo.booking;

import jakarta.persistence.*;

/**
 * Class name: Booking
 * Date: November 18, 2024
 * Name: Israel Alcocer
 * Represents a booking entity in the system.
 * This class maps to a database table for storing booking information related to a user and a payment transaction.
 * <p>The Booking class is annotated with JPA annotations to integrate with the
 * persistence layer. The booking contains an ID, a user ID, a payment ID, a confirmation code, 
 * and a flag indicating whether the booking is one-way or not.</p>
 * <p>This class uses a sequence generator to auto-generate booking IDs.</p>
 */
@Entity
@Table
public class Booking {

    /**
     * Unique identifier for the booking.
     * This is auto-generated using a sequence generator.
     */
    @Id
    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_sequence"
    )
    Integer bookingID;

    /**
     * ID of the user who made the booking.
     */
    int userID;

    /**
     * ID of the payment associated with the booking.
     */
    int paymentID;

    /**
     * Confirmation code for the booking.
     * This is a unique identifier provided to the user as a reference for the booking.
     */
    String confirmationCode;

    /**
     * Indicates whether the booking is one-way (true) or round-trip (false).
     */
    boolean isOneWay;

    /**
     * Constructs a new Booking with the specified details.
     * 
     * @param bookingID The unique ID of the booking.
     * @param userID The ID of the user who made the booking.
     * @param paymentID The ID of the payment associated with the booking.
     * @param confirmationCode The confirmation code for the booking.
     */
    public Booking(Integer bookingID, int userID, int paymentID, String confirmationCode) {
        this.bookingID = bookingID;
        this.userID = userID;
        this.paymentID = paymentID;
        this.confirmationCode = confirmationCode;
    }

    /**
     * Gets the booking ID.
     * 
     * @return The booking ID.
     */
    public Integer getBookingID() {
        return bookingID;
    }

    /**
     * Sets the booking ID.
     * 
     * @param bookingID The booking ID to set.
     */
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    /**
     * Gets the user ID associated with the booking.
     * 
     * @return The user ID.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the user ID for the booking.
     * 
     * @param userID The user ID to set.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Gets the payment ID associated with the booking.
     * 
     * @return The payment ID.
     */
    public int getPaymentID() {
        return paymentID;
    }

    /**
     * Sets the payment ID for the booking.
     * 
     * @param paymentID The payment ID to set.
     */
    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    /**
     * Gets the confirmation code for the booking.
     * 
     * @return The confirmation code.
     */
    public String getConfirmationCode() {
        return confirmationCode;
    }

    /**
     * Sets the confirmation code for the booking.
     * 
     * @param confirmationCode The confirmation code to set.
     */
    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    /**
     * Checks whether the booking is one-way.
     * 
     * @return True if the booking is one-way, otherwise false.
     */
    public boolean isOneWay() {
        return isOneWay;
    }

    /**
     * Sets the flag indicating whether the booking is one-way.
     * 
     * @param state True if the booking is one-way, otherwise false.
     */
    public void setOneWay(boolean state) {
        isOneWay = state;
    }

    /**
     * Provides a string representation of the booking.
     * 
     * @return A string representation of the booking details.
     */
    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", userID=" + userID +
                ", paymentID=" + paymentID +
                ", confirmationCode='" + confirmationCode + '\'' +
                '}';
    }
}
