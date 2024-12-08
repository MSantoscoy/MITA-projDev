package com.example.demo.flight;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class name: Flight Controller
 * @since 2024-11-15
 * @author Miguel Santoscoy
 * Controller class for managing flight-related operations via HTTP requests.
 * <p>
 * This class handles CRUD operations for flights, exposing RESTful endpoints to interact with flight data.
 * </p>
 */
@RestController
@RequestMapping(path = "api/v1/flight")
public class FlightController {

    private final FlightService flightService;

    /**
     * Constructor to initialize the {@link FlightService} instance.
     *
     * @param flightService The {@link FlightService} service to handle flight-related business logic.
     */
    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    /**
     * Retrieves all flights.
     * <p>
     * This endpoint fetches a list of all available flights.
     * </p>
     *
     * @return A list of all {@link Flight} objects.
     */
    @GetMapping
    public List<Flight> getAllAirports() {
        return flightService.getAirport();
    }

    /**
     * Retrieves a flight by its ID.
     * <p>
     * This endpoint fetches a specific flight based on its unique identifier.
     * If the flight with the given ID is not found, a {@code 404 Not Found} response is returned.
     * </p>
     *
     * @param id The unique identifier of the flight to fetch.
     * @return A {@link ResponseEntity} containing the found {@link Flight} or a {@code 404 Not Found} response.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getAirportById(@PathVariable("id") Integer id) {
        Optional<Flight> flight = flightService.getAirportById(id);
        return flight.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Creates a new flight.
     * <p>
     * This endpoint accepts a {@link Flight} object in the request body and creates a new flight in the system.
     * The created flight is returned with a {@code 201 Created} status.
     * </p>
     *
     * @param flight The {@link Flight} object to be created.
     * @return A {@link ResponseEntity} containing the created {@link Flight} with a {@code 201 Created} status.
     */
    @PostMapping
    public ResponseEntity<Flight> createAirport(@RequestBody Flight flight) {
        Flight createdFlight = flightService.createAirport(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlight);
    }

    /**
     * Updates an existing flight by ID.
     * <p>
     * This endpoint updates a flight's details based on its unique identifier.
     * If the flight is found, the updated flight is returned. If the flight is not found, a {@code 404 Not Found}
     * response is returned.
     * </p>
     *
     * @param id The unique identifier of the flight to update.
     * @param flight The {@link Flight} object containing the updated flight details.
     * @return A {@link ResponseEntity} containing the updated {@link Flight} or a {@code 404 Not Found} response.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateAirport(@PathVariable("id") Integer id, @RequestBody Flight flight) {
        Optional<Flight> updatedFlight = flightService.updateAirport(id, flight);
        return updatedFlight.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Deletes a flight by ID.
     * <p>
     * This endpoint deletes a flight identified by its unique ID.
     * If the flight is deleted successfully, a {@code 204 No Content} status is returned. If the flight is not found,
     * a {@code 404 Not Found} response is returned.
     * </p>
     *
     * @param id The unique identifier of the flight to delete.
     * @return A {@link ResponseEntity} with a {@code 204 No Content} status if successful, or {@code 404 Not Found} if the flight does not exist.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable("id") Integer id) {
        boolean deleted = flightService.deleteAirport(id);
        if (deleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
