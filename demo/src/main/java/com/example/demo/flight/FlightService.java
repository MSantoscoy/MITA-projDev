package com.example.demo.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class name: FlightService
 * @since 2024-11-17
 * @author Miguel Santoscoy
 * The {@link FlightService} class contains the business logic for managing flight-related 
 * operations. It acts as a service layer between the controller and the data access layer 
 * (via the {@link FlightRepository}). This service provides methods for creating, 
 * retrieving, updating, and deleting flights.
 * <p>
 * The {@link FlightService} is annotated with {@link Service}, which makes it a Spring 
 * service component that is automatically registered in the Spring context. This class 
 * encapsulates the business logic for the flight management features of the application.
 * </p>
 */
@Service
public class FlightService {

    private final FlightRepository flightRepository;

    /**
     * Constructs a new {@link FlightService} instance with the given {@link FlightRepository}.
     * 
     * @param flightRepository The repository for performing CRUD operations on flight data.
     */
    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    /**
     * Retrieves all flights from the database.
     * 
     * @return A list of all {@link Flight} entities.
     */
    public List<Flight> getAirport() {
        return flightRepository.findAll();
    }

    /**
     * Retrieves a specific flight by its ID.
     * 
     * @param id The ID of the flight to retrieve.
     * @return An {@link Optional} containing the {@link Flight} entity if found, or empty if not.
     */
    public Optional<Flight> getAirportById(Integer id) {
        return flightRepository.findById(id);
    }

    /**
     * Creates a new flight in the database.
     * 
     * @param flight The {@link Flight} entity to be created.
     * @return The created {@link Flight} entity.
     */
    public Flight createAirport(Flight flight) {
        return flightRepository.save(flight);
    }

    /**
     * Updates an existing flight in the database. If the flight with the specified ID exists, 
     * it updates the details of that flight.
     * 
     * @param id The ID of the flight to be updated.
     * @param flight The new {@link Flight} entity containing updated information.
     * @return An {@link Optional} containing the updated {@link Flight} if successful, or empty if not.
     */
    public Optional<Flight> updateAirport(Integer id, Flight flight) {
        if (flightRepository.existsById(id)) {
            flight.setID(id);  // Ensure the ID is set for the update
            return Optional.of(flightRepository.save(flight));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Deletes a specific flight by its ID.
     * 
     * @param id The ID of the flight to delete.
     * @return {@code true} if the flight was successfully deleted, {@code false} if no flight 
     *         with the given ID exists.
     */
    public boolean deleteAirport(Integer id) {
        if (flightRepository.existsById(id)) {
            flightRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
