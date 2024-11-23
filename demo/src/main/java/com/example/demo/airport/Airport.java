package com.example.demo.airport;

import jakarta.persistence.*;

/**
 * Class name: Airport
 * @since 2024-11-15
 * @author Miguel Santoscoy
 * Represents an airport entity in the system.
 * This class is mapped to a database table and contains attributes that describe
 * an airport, including its ID, name, code, location, and timezone.
 * 
 * <p>The class is annotated with {@link Entity} and {@link Table} to specify that it
 * represents a database entity and should be persisted in a table. The primary key is
 * defined by the {@link Id} annotation, and the value for the primary key is generated 
 * using a {@link SequenceGenerator}.</p>
 */
@Entity
@Table
public class Airport {

    /**
     * The unique identifier for the airport.
     * This field is the primary key of the airport entity, generated using a sequence.
     */
    @Id
    @SequenceGenerator(
            name = "airport_sequence",
            sequenceName = "airport_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "airport_sequence"
    )
    private Integer ID;

    /**
     * The name of the airport.
     */
    private String airportName;

    /**
     * The unique code assigned to the airport (e.g., IATA code).
     */
    private String airportCode;

    /**
     * The geographical location of the airport.
     */
    private String location;

    /**
     * The timezone of the airport, represented as an integer (e.g., UTC offset).
     */
    private int timezone;

    /**
     * Constructor to create a new Airport entity.
     * 
     * @param ID The unique identifier of the airport.
     * @param airportName The name of the airport.
     * @param airportCode The code assigned to the airport (e.g., IATA code).
     * @param location The location or city of the airport.
     * @param timezone The timezone offset of the airport (e.g., UTC).
     */
    public Airport(Integer ID, String airportName, String airportCode, String location, int timezone) {
        this.ID = ID;
        this.airportName = airportName;
        this.airportCode = airportCode;
        this.location = location;
        this.timezone = timezone;
    }

    /**
     * Gets the unique identifier of the airport.
     * 
     * @return The unique identifier (ID) of the airport.
     */
    public Integer getID() {
        return ID;
    }

    /**
     * Gets the name of the airport.
     * 
     * @return The name of the airport.
     */
    public String getAirportName() {
        return airportName;
    }

    /**
     * Gets the airport's unique code (e.g., IATA code).
     * 
     * @return The code of the airport.
     */
    public String getAirportCode() {
        return airportCode;
    }

    /**
     * Gets the location (city or region) of the airport.
     * 
     * @return The location of the airport.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the timezone of the airport (represented as an integer UTC offset).
     * 
     * @return The timezone of the airport.
     */
    public int getTimezone() {
        return timezone;
    }

    /**
     * Sets the unique identifier of the airport.
     * 
     * @param ID The unique identifier (ID) of the airport.
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * Sets the name of the airport.
     * 
     * @param airportName The name of the airport.
     */
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    /**
     * Sets the airport's unique code (e.g., IATA code).
     * 
     * @param airportCode The unique code of the airport.
     */
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    /**
     * Sets the location of the airport (e.g., city or region).
     * 
     * @param location The location or city of the airport.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets the timezone of the airport (represented as an integer UTC offset).
     * 
     * @param timezone The timezone offset of the airport.
     */
    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    /**
     * Returns a string representation of the airport entity.
     * This method provides a textual representation of the airport, including its ID, 
     * name, code, location, and timezone.
     * 
     * @return A string representation of the airport.
     */
    @Override
    public String toString() {
        return "Airport{" +
                "ID=" + ID +
                ", airportName='" + airportName + '\'' +
                ", airportCode='" + airportCode + '\'' +
                ", location='" + location + '\'' +
                ", timezone=" + timezone +
                '}';
    }
}
