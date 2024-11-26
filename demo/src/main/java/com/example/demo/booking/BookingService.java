package com.example.demo.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Class name: BookingService
 * @since 2024-11-20
 * @author Israel Alcocer
 * Service class responsible for handling business logic related to bookings.
 * This class interacts with the {@link BookingRepository} to perform CRUD operations
 * on {@link Booking} entities, including creating, retrieving, updating, and deleting bookings.
 * 
 * <p>The {@link BookingService} encapsulates the logic for managing bookings and is used by
 * the {@link BookingController} to handle HTTP requests related to bookings.</p>
 */
@Service
public class BookingService {

    /**
     * Repository for interacting with the database and performing CRUD operations on {@link Booking} entities.
     */
    private final BookingRepository bookingRepository;

    /**
     * Constructor for initializing the {@link BookingService} with the given {@link BookingRepository}.
     * 
     * @param bookingRepository The {@link BookingRepository} instance used to access the database.
     */
    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /**
     * Creates a new booking in the system.
     * 
     * <p>This method saves the provided booking to the database and returns the saved booking.</p>
     * 
     * @param booking The booking to create.
     * @return The saved {@link Booking} object.
     */
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     * Retrieves all bookings from the system.
     * 
     * <p>This method fetches a list of all bookings stored in the database.</p>
     * 
     * @return A list of all {@link Booking} objects.
     */
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    /**
     * Retrieves a booking by its ID.
     * 
     * <p>This method fetches a booking from the database using its ID. If the booking is not found, 
     * an empty {@link Optional} is returned.</p>
     * 
     * @param id The ID of the booking to retrieve.
     * @return An {@link Optional} containing the {@link Booking} if found, or empty if not found.
     */
    public Optional<Booking> getBookingById(Integer id) {
        return bookingRepository.findById(id);
    }

    /**
     * Updates an existing booking by its ID.
     * 
     * <p>This method updates the properties of an existing booking with the provided values. If the
     * booking is not found, a {@link RuntimeException} is thrown.</p>
     * 
     * @param id The ID of the booking to update.
     * @param userID The new user ID for the booking.
     * @param paymentID The new payment ID for the booking.
     * @param confirmationCode The new confirmation code for the booking.
     * @return The updated {@link Booking} object.
     * @throws RuntimeException if the booking with the specified ID is not found.
     */
    public Booking updateBooking(Integer id, int userID, int paymentID, String confirmationCode) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        existingBooking.setUserID(userID);
        existingBooking.setPaymentID(paymentID);
        existingBooking.setConfirmationCode(confirmationCode);
        return bookingRepository.save(existingBooking);
    }

    /**
     * Deletes a booking by its ID.
     * 
     * <p>This method deletes the booking with the specified ID from the database. If the booking is not
     * found, a {@link RuntimeException} is thrown.</p>
     * 
     * @param id The ID of the booking to delete.
     * @throws RuntimeException if the booking with the specified ID is not found.
     */
    public void deleteBooking(Integer id) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        bookingRepository.delete(existingBooking);
    }
}
