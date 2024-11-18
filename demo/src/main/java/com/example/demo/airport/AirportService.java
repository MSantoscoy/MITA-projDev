package com.example.demo.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    // Get all passengers
    public List<Airport> getAirport() {
        return airportRepository.findAll();
    }

    // Get a passenger by ID
    public Optional<Airport> getAirportById(Integer id) {
        return airportRepository.findById(id);
    }

    // Create a new passenger
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    // Update an existing passenger
    public Optional<Airport> updateAirport(Integer id, Airport airport) {
        if (airportRepository.existsById(id)) {
            airport.setID(id);  // Ensure the ID is set for the update
            return Optional.of(airportRepository.save(airport));
        } else {
            return Optional.empty();
        }
    }

    // Delete a passenger by ID
    public boolean deleteAirport(Integer id) {
        if (airportRepository.existsById(id)) {
            airportRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
