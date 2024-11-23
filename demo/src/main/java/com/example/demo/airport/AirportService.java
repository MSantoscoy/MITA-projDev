package com.example.demo.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class name: AirportService
 * @since 2024-11-15
 * @author Miguel Santoscoy
 * The {@code AirportService} class is a service layer that handles the business logic for managing
 * {@link Airport} entities. It interacts with the {@link AirportRepository} to perform CRUD operations 
 * such as retrieving, creating, updating, and deleting airport records in the database.
 * <p>
 * This class acts as an intermediary between the controller layer and the data access layer,
 * encapsulating the business logic and ensuring that the database operations are performed 
 * in a consistent and reliable manner.
 * </p>
 * 
 * @author [Your Name]
 * @since [Version]
 */
@Service
public class AirportService {

    private final AirportRepository airportRepository;

    /**
     * Constructs a new {@code AirportService} with the given {@link AirportRepository}.
     * The repository is injected via the constructor by Spring's dependency injection mechanism.
     * 
     * @param airportRepository The repository used for data access operations related to airports.
     */
    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    /**
     * Retrieves a list of all airports from the database.
     * 
     * @return A list of all {@link Airport} entities stored in the database.
     */
    public List<Airport> getAirport() {
        return airportRepository.findAll();
    }

    /**
     * Retrieves an airport by its unique identifier.
     * 
     * @param id The ID of the airport to retrieve.
     * @return An {@link Optional} containing the airport if found, otherwise an empty {@link Optional}.
     */
    public Optional<Airport> getAirportById(Integer id) {
        return airportRepository.findById(id);
    }

    /**
     * Creates a new airport record in the database.
     * 
     * @param airport The airport entity to create.
     * @return The created {@link Airport} entity.
     */
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    /**
     * Updates an existing airport record in the database.
     * The airport's ID must be provided, and the ID will be used to identify the record to update.
     * 
     * @param id The ID of the airport to update.
     * @param airport The updated airport entity.
     * @return An {@link Optional} containing the updated airport if the airport exists, 
     *         otherwise an empty {@link Optional}.
     */
    public Optional<Airport> updateAirport(Integer id, Airport airport) {
        if (airportRepository.existsById(id)) {
            airport.setID(id);  // Ensure the ID is set for the update
            return Optional.of(airportRepository.save(airport));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Deletes an airport record by its unique identifier.
     * 
     * @param id The ID of the airport to delete.
     * @return {@code true} if the airport was successfully deleted, {@code false} if no airport 
     *         with the given ID exists.
     */
    public boolean deleteAirport(Integer id) {
        if (airportRepository.existsById(id)) {
            airportRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
