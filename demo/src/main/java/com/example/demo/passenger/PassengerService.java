package com.example.demo.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    // Get all passengers
    public List<Passenger> getPassenger() {
        return passengerRepository.findAll();
    }

    // Get a passenger by ID
    public Optional<Passenger> getPassengerById(Integer id) {
        return passengerRepository.findById(id);
    }

    // Create a new passenger
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    // Update an existing passenger
    public Optional<Passenger> updatePassenger(Integer id, Passenger passenger) {
        if (passengerRepository.existsById(id)) {
            passenger.setID(id);  // Ensure the ID is set for the update
            return Optional.of(passengerRepository.save(passenger));
        } else {
            return Optional.empty();
        }
    }

    // Delete a passenger by ID
    public boolean deletePassenger(Integer id) {
        if (passengerRepository.existsById(id)) {
            passengerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
