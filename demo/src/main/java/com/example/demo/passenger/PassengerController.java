package com.example.demo.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Class name: PassengerController
 * @since 2024-11-18
 * @author Miguel Santoscoy
 * Controller for managing passenger-related endpoints.
 * This class exposes RESTful API endpoints for creating, retrieving, updating, and deleting passenger data.
 * It uses the {@link PassengerService} to handle the business logic and interact with the database.
 */
@RestController
@RequestMapping(path = "api/v1/passenger")
public class PassengerController {

    private final PassengerService passengerService;

    /**
     * Constructs a {@link PassengerController} with the given {@link PassengerService}.
     * 
     * @param passengerService The service responsible for handling passenger-related business logic.
     */
    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    /**
     * Retrieves a list of all passengers.
     * 
     * @return A list of {@link Passenger} objects.
     */
    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getPassenger();
    }

    /**
     * Retrieves a specific passenger by their ID.
     * 
     * @param id The ID of the passenger to retrieve.
     * @return A {@link ResponseEntity} containing the {@link Passenger} if found, or a {@link HttpStatus#NOT_FOUND} if not.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable("id") Integer id) {
        Optional<Passenger> passenger = passengerService.getPassengerById(id);
        return passenger.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Creates a new passenger.
     * 
     * @param passenger The {@link Passenger} object to create.
     * @return A {@link ResponseEntity} containing the created {@link Passenger} and a {@link HttpStatus#CREATED}.
     */
    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        Passenger createdPassenger = passengerService.createPassenger(passenger);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPassenger);
    }

    /**
     * Updates an existing passenger by their ID.
     * 
     * @param id The ID of the passenger to update.
     * @param passenger The updated {@link Passenger} object.
     * @return A {@link ResponseEntity} containing the updated {@link Passenger}, or {@link HttpStatus#NOT_FOUND} if the passenger does not exist.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable("id") Integer id, @RequestBody Passenger passenger) {
        Optional<Passenger> updatedPassenger = passengerService.updatePassenger(id, passenger);
        return updatedPassenger.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Deletes a passenger by their ID.
     * 
     * @param id The ID of the passenger to delete.
     * @return A {@link ResponseEntity} indicating the result of the delete operation. 
     *         Returns {@link HttpStatus#NO_CONTENT} if successful, or {@link HttpStatus#NOT_FOUND} if the passenger does not exist.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable("id") Integer id) {
        boolean deleted = passengerService.deletePassenger(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
