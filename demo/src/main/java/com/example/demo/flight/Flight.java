package com.example.demo.flight;

import com.example.demo.airport.Airport;
import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.*;

/**
 * Class name: Flight
 * @since 2024-11-17
 * @author Miguel Santoscoy
 * Represents a flight with details about its departure, destination, 
 * time of departure and arrival, pricing, and related airports.
 */
@Entity
@Table
public class Flight {

    /**
     * Unique identifier for the flight.
     */
    @Id
    @SequenceGenerator(
            name = "flight_sequence",
            sequenceName = "flight_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "flight_sequence"
    )
    private Integer ID;

    /**
     * The destination airport for the flight.
     * The relationship is lazy-loaded, meaning the destination data is 
     * fetched only when explicitly accessed.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_id")
    private Airport destination;

    /**
     * The departure airport for the flight.
     * The relationship is also lazy-loaded, and it might have constraints like 
     * 'insertable=false, updatable=false' depending on the business logic.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_id", insertable = false, updatable = false)
    private Airport departure;

    /**
     * The time of departure for the flight.
     */
    private LocalTime departTime;

    /**
     * The time of arrival at the destination.
     */
    private LocalTime arrivalTime;

    /**
     * The date of departure for the flight.
     */
    private LocalDate departDate;

    /**
     * The date of arrival at the destination.
     */
    private LocalDate arrivalDate;

    /**
     * The price of the flight.
     */
    private float price;

    /**
     * Constructor for creating a new flight.
     *
     * @param destination The destination airport.
     * @param departure The departure airport.
     * @param departTime The departure time.
     * @param arrivalTime The arrival time.
     * @param departDate The departure date.
     * @param arrivalDate The arrival date.
     * @param price The price of the flight.
     */
    public Flight(Airport destination, Airport departure, LocalTime departTime, 
                  LocalTime arrivalTime, LocalDate departDate, LocalDate arrivalDate, float price) {
        this.destination = destination;
        this.departure = departure;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.departDate = departDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
    }

    // Getters and Setters

    /**
     * Returns the unique ID of the flight.
     *
     * @return The flight ID.
     */
    public Integer getID() {
        return ID;
    }

    /**
     * Sets the unique ID of the flight.
     *
     * @param ID The flight ID.
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * Returns the destination airport of the flight.
     *
     * @return The destination airport.
     */
    public Airport getDestination() {
        return destination;
    }

    /**
     * Sets the destination airport of the flight.
     *
     * @param destination The destination airport.
     */
    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    /**
     * Returns the departure airport of the flight.
     *
     * @return The departure airport.
     */
    public Airport getDeparture() {
        return departure;
    }

    /**
     * Sets the departure airport of the flight.
     *
     * @param departure The departure airport.
     */
    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    /**
     * Returns the departure time of the flight.
     *
     * @return The departure time.
     */
    public LocalTime getDepartTime() {
        return departTime;
    }

    /**
     * Sets the departure time of the flight.
     *
     * @param departTime The departure time.
     */
    public void setDepartTime(LocalTime departTime) {
        this.departTime = departTime;
    }

    /**
     * Returns the arrival time of the flight.
     *
     * @return The arrival time.
     */
    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the arrival time of the flight.
     *
     * @param arrivalTime The arrival time.
     */
    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Returns the departure date of the flight.
     *
     * @return The departure date.
     */
    public LocalDate getDepartDate() {
        return departDate;
    }

    /**
     * Sets the departure date of the flight.
     *
     * @param departDate The departure date.
     */
    public void setDepartDate(LocalDate departDate) {
        this.departDate = departDate;
    }

    /**
     * Returns the arrival date of the flight.
     *
     * @return The arrival date.
     */
    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the arrival date of the flight.
     *
     * @param arrivalDate The arrival date.
     */
    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * Returns the price of the flight.
     *
     * @return The price of the flight.
     */
    public float getPrice() {
        return price;
    }

    /**
     * Sets the price of the flight.
     *
     * @param price The price of the flight.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Generates the price for an international flight based on the time zone 
     * difference between departure and destination airports.
     * 
     * Price is calculated based on a base fare of 1217 with an adjustment
     * based on the time zone difference between departure and destination.
     */
    public void genPriceInt() {
        int departTimeZone = departure.getTimezone();
        int destinationTimeZone = destination.getTimezone();

        // Calculate time zone difference
        float difference = Math.abs(departTimeZone - destinationTimeZone);
        difference /= 10;

        // Adjust the price based on time zone difference
        price = (float) (1217 * (1.1 + difference));
    }

    /**
     * Generates the price for a domestic flight based on the time zone 
     * difference between departure and destination airports.
     * 
     * The price is calculated in the same way as for international flights,
     * based on the time zone difference.
     */
    public void genPriceDomestic() {
        int departTimeZone = departure.getTimezone();
        int destinationTimeZone = destination.getTimezone();

        // Calculate time zone difference
        float difference = Math.abs(departTimeZone - destinationTimeZone);
        difference /= 10;

        // Adjust the price based on time zone difference
        price = (float) (1217 * (1.1 + difference));
    }
}
