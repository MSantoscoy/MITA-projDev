package com.example.demo.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Class name: AirportController
 * @since 2024-11-15
 * @author Miguel Santoscoy
 * REST Controller for managing airport operations in the system.
 * This controller exposes endpoints for performing CRUD operations on airports.
 * It interacts with the {@link AirportService} to handle business logic related to airports.
 * 
 * <p>All routes are prefixed with "/api/v1/airport" and the controller provides functionality to:
 * 1. Retrieve all airports.
 * 2. Retrieve a specific airport by ID.
 * 3. Create a new airport.
 * 4. Update an existing airport.
 * 5. Delete an airport by ID.</p>
 */
@RestController
@RequestMapping(path = "api/v1/airport")
public class AirportController {

    private final AirportService airportService;

    /**
     * Constructs a new {@link AirportController} with the given {@link AirportService}.
     * 
     * @param airportService The service that provides the business logic for managing airports.
     */
    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    /**
     * Retrieves all airports from the system.
     * 
     * @return A list of all airports.
     */
    @GetMapping
    public List<Airport> getAllAirports() {
        return airportService.getAirport();
    }

    /**
     * Retrieves a specific airport by its ID.
     * 
     * @param id The ID of the airport to retrieve.
     * @return A {@link ResponseEntity} containing the airport if found, or a NOT_FOUND status if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable("id") Integer id) {
        Optional<Airport> airport = airportService.getAirportById(id);
        return airport.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Creates a new airport in the system.
     * 
     * @param airport The airport to create, provided in the request body.
     * @return A {@link ResponseEntity} containing the created airport, with a status of CREATED.
     */
    @PostMapping
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        Airport createdAirport = airportService.createAirport(airport);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAirport);
    }

    /**
     * Updates an existing airport in the system.
     * 
     * @param id The ID of the airport to update.
     * @param airport The updated airport data, provided in the request body.
     * @return A {@link ResponseEntity} containing the updated airport if successful, or a NOT_FOUND status if the airport does not exist.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Airport> updateAirport(@PathVariable("id") Integer id, @RequestBody Airport airport) {
        Optional<Airport> updatedAirport = airportService.updateAirport(id, airport);
        return updatedAirport.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Deletes an airport from the system by its ID.
     * 
     * @param id The ID of the airport to delete.
     * @return A {@link ResponseEntity} with a status of NO_CONTENT if the deletion is successful,
     *         or a NOT_FOUND status if the airport does not exist.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable("id") Integer id) {
        boolean deleted = airportService.deleteAirport(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
