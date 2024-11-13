package com.example.demo.airport;

import jakarta.persistence.*;

@Entity
@Table
public class Airport {
    @Id
    @SequenceGenerator(
            name = "airport_sequence",
            sequenceName = "airport_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "airport_sequence"
    )
    private Integer ID;
    private String airportName;
    private String airportCode;
    private String location;
    private int timezone;

    public Airport(Integer ID, String airportName, String airportCode, String location, int timezone) {
        this.ID = ID;
        this.airportName = airportName;
        this.airportCode = airportCode;
        this.location = location;
        this.timezone = timezone;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "ID=" + ID +
                ", airportName=" + airportName +
                ", airportCode='" + airportCode + '\'' +
                ", location='" + location + '\'' +
                ", timezone=" + timezone +
                '}';
    }
}
