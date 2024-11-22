package com.example.demo.booking;

import jakarta.persistence.*;

@Entity
@Table
public class Booking {
    @Id
    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "booking_sequence"
    )

    Integer bookingID;
    int userID;
    int paymentID;
    String confirmationCode;
    boolean isOneWay;

    public Booking (Integer bookingID, int userID, int paymentID, String confirmationCode){
        this.bookingID = bookingID;
        this.userID = userID;
        this.paymentID = paymentID;
        this.confirmationCode = confirmationCode;
    }

    // Getters and Setters
    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public boolean isOneWay(){
        return isOneWay;
    }

    public void setOneWay(boolean state){
        isOneWay = state;
    }

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