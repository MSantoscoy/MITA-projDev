package com.example.demo.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Class name: BookingController
 * @since 2024-11-20
 * @author Israel Alcocer
 * REST controller for handling booking-related operations.
 * This controller exposes various endpoints for managing bookings in the system.
 * 
 * <p>The controller is designed to handle HTTP requests related to creating, retrieving,
 * updating, and deleting bookings. It delegates the business logic to the {@link BookingService}.</p>
 */
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    /**
     * Service for handling the business logic of booking operations.
     */
    private final BookingService bookingService;

    /**
     * Constructor for initializing the {@link BookingController} with the given {@link BookingService}.
     * 
     * @param bookingService The {@link BookingService} instance used for handling booking operations.
     */
    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    /**
     * Creates a new booking.
     * 
     * <p>This method receives a booking object in the request body, processes it,
     * and returns the newly created booking object with HTTP status {@code 201 Created}.</p>
     * 
     * @param booking The booking object to be created.
     * @return A {@link ResponseEntity} containing the created booking and HTTP status {@code 201 Created}.
     */
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    /**
     * Retrieves all bookings.
     * 
     * <p>This method returns a list of all bookings in the system.</p>
     * 
     * @return A {@link ResponseEntity} containing a list of all bookings and HTTP status {@code 200 OK}.
     */
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    /**
     * Retrieves a specific booking by its ID.
     * 
     * <p>This method fetches a booking by its ID and returns it if found, otherwise returns 
     * HTTP status {@code 404 Not Found} if the booking does not exist.</p>
     * 
     * @param id The ID of the booking to retrieve.
     * @return A {@link ResponseEntity} containing the booking if found, or HTTP status {@code 404 Not Found} otherwise.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Integer id) {
        Optional<Booking> booking = bookingService.getBookingById(id);
        return booking.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Updates an existing booking.
     * 
     * <p>This method receives the updated booking details in the request body and updates
     * the corresponding booking in the system. If the booking is not found, it returns HTTP status
     * {@code 404 Not Found}.</p>
     * 
     * @param id The ID of the booking to update.
     * @param userId The updated user ID for the booking.
     * @param paymentId The updated payment ID for the booking.
     * @param confirmationCode The updated confirmation code for the booking.
     * @return A {@link ResponseEntity} containing the updated booking and HTTP status {@code 200 OK}.
     *         Returns HTTP status {@code 404 Not Found} if the booking could not be found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable Integer id,
            @RequestBody int userId, 
            @RequestBody int paymentId, 
            @RequestBody String confirmationCode) {
        try {
            Booking updatedBooking = bookingService.updateBooking(id, userId, paymentId, confirmationCode);
            return ResponseEntity.ok(updatedBooking);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Deletes a booking.
     * 
     * <p>This method deletes the booking specified by the ID. If the booking is not found,
     * it returns HTTP status {@code 404 Not Found}.</p>
     * 
     * @param id The ID of the booking to delete.
     * @return A {@link ResponseEntity} with HTTP status {@code 204 No Content} if the deletion was successful,
     *         or HTTP status {@code 404 Not Found} if the booking was not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Integer id) {
        try {
            bookingService.deleteBooking(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
