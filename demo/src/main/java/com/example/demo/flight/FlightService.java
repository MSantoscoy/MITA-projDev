package com.example.demo.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Get all passengers
    public List<Flight> getAirport() {
        return flightRepository.findAll();
    }

    // Get a passenger by ID
    public Optional<Flight> getAirportById(Integer id) {
        return flightRepository.findById(id);
    }

    // Create a new passenger
    public Flight createAirport(Flight flight) {
        return flightRepository.save(flight);
    }

    // Update an existing passenger
    public Optional<Flight> updateAirport(Integer id, Flight flight) {
        if (flightRepository.existsById(id)) {
            flight.setID(id);  // Ensure the ID is set for the update
            return Optional.of(flightRepository.save(flight));
        } else {
            return Optional.empty();
        }
    }

    // Delete a passenger by ID
    public boolean deleteAirport(Integer id) {
        if (flightRepository.existsById(id)) {
            flightRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
