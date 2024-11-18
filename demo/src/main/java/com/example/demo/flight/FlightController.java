package com.example.demo.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/airport")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // Get all airports
    @GetMapping
    public List<Flight> getAllAirports() {
        return flightService.getAirport();
    }

    // Get a single airport by ID
    @GetMapping("/{id}")
    public ResponseEntity<Flight> getAirportById(@PathVariable("id") Integer id) {
        Optional<Flight> airport = flightService.getAirportById(id);
        return airport.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Create a new airport
    @PostMapping
    public ResponseEntity<Flight> createAirport(@RequestBody Flight flight) {
        Flight createdFlight = flightService.createAirport(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFlight);
    }

    // Update an existing airport
    @PutMapping("/{id}")
    public ResponseEntity<Flight> updateAirport(@PathVariable("id") Integer id, @RequestBody Flight flight) {
        Optional<Flight> updatedAirport = flightService.updateAirport(id, flight);
        return updatedAirport.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Delete an airport by ID
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
