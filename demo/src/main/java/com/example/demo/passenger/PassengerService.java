package com.example.demo.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class name: PassengerService
 * @since 2024-11-19
 * @author Miguel Santoscoy
 * The {@link PassengerService} class provides business logic for managing {@link Passenger} entities.
 * It acts as an intermediary between the controller and the {@link PassengerRepository},
 * handling all operations related to passengers such as creating, retrieving, updating, and deleting passengers.
 * <p>
 * This service is used by the {@link PassengerController} to interact with the underlying data store
 * and provide the necessary functionality for passenger management.
 * </p>
 * 
 */
@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    /**
     * Constructs a {@link PassengerService} instance with the provided {@link PassengerRepository}.
     * 
     * @param passengerRepository the repository for interacting with passenger data
     */
    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    /**
     * Retrieves all passengers from the repository.
     * 
     * @return a list of all {@link Passenger} entities
     */
    public List<Passenger> getPassenger() {
        return passengerRepository.findAll();
    }

    /**
     * Retrieves a passenger by its ID.
     * 
     * @param id the ID of the passenger to retrieve
     * @return an {@link Optional} containing the {@link Passenger} if found, or empty if not
     */
    public Optional<Passenger> getPassengerById(Integer id) {
        return passengerRepository.findById(id);
    }

    /**
     * Creates a new passenger in the repository.
     * 
     * @param passenger the {@link Passenger} entity to create
     * @return the created {@link Passenger} entity
     */
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    /**
     * Updates an existing passenger by its ID.
     * 
     * @param id the ID of the passenger to update
     * @param passenger the updated {@link Passenger} entity
     * @return an {@link Optional} containing the updated {@link Passenger} if the passenger exists, 
     *         or empty if the passenger was not found
     */
    public Optional<Passenger> updatePassenger(Integer id, Passenger passenger) {
        if (passengerRepository.existsById(id)) {
            passenger.setID(id);  // Ensure the ID is set for the update
            return Optional.of(passengerRepository.save(passenger));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Deletes a passenger by its ID.
     * 
     * @param id the ID of the passenger to delete
     * @return {@code true} if the passenger was deleted successfully, {@code false} if the passenger was not found
     */
    public boolean deletePassenger(Integer id) {
        if (passengerRepository.existsById(id)) {
            passengerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
