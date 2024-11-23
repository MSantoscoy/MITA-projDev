package com.example.demo.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {

    @Autowired
    private final BookingRepository bookingRepository;
    public BookingService(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    // Create a new booking
    public Booking createBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    // Get all bookings
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    // Get booking by id
    public Optional<Booking> getBookingById(Integer id){
        return bookingRepository.findById(id);
    }

    // Update a booking by id
    public Booking updateBooking(Integer id, int userID, int paymentID, String confirmationCode){
        Booking existingBooking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        existingBooking.setUserID(userID);
        existingBooking.setPaymentID(paymentID);
        existingBooking.setConfirmationCode(confirmationCode);
        return bookingRepository.save(existingBooking);
    }

    // Delete a booking by id
    public void deleteBooking(Integer id){
        Booking existingBooking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        bookingRepository.delete(existingBooking);
    }
}