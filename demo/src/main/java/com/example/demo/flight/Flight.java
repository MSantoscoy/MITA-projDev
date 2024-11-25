package com.example.demo.flight;
import com.example.demo.airport.Airport;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.lang.Math;

//import com.example.demo.airport.Airport;
import jakarta.persistence.*;

@Entity
@Table
public class Flight {
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

    @ManyToOne(fetch = FetchType.LAZY)  // Use LAZY loading for better performance in most cases
    @JoinColumn(name = "airport_id")    // Specifies the foreign key column in the Flight table
    private Airport destination;  // Reference (pointer) to the Airport class

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airport_id", insertable = false, updatable = false)
    private Airport departure;

    private LocalTime departTime;
    private LocalTime arrivalTime; //destination time

    private LocalDate departDate;
    private LocalDate arrivalDate;

    private float price;

    public Flight(Airport destination, Airport departure, LocalTime departTime, LocalTime arrivalTime, LocalDate departDate, LocalDate arrivalDate, float price) {
        this.destination = destination;
        this.departure = departure;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.departDate = departDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
    }

    public Integer getID() {
        return ID;
    }

    public Airport getDestination() {
        return destination;
    }

    public Airport getDeparture() {
        return departure;
    }

    public LocalTime getDepartTime() {
        return departTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalDate getDepartDate() {
        return departDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public float getPrice() {
        return price;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public void setDepartTime(LocalTime departTime) {
        this.departTime = departTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartDate(LocalDate departDate) {
        this.departDate = departDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    //generate price for international flight
    public void genPriceInt()
    {
        int departTime= departure.getTimezone();
        int destinationTime= destination.getTimezone();

        float difference= Math.abs(departTime - destinationTime);//Math.abs resolves in int
        difference /=10;

        price= (float)(1217 * (1.1 + difference));

    }

    public void genPriceDomestic()
    {
        int departTime= departure.getTimezone();
        int destinationTime= destination.getTimezone();

        float difference= Math.abs(departTime - destinationTime);//Math.abs resolves in int
        difference /=10;

        price= (float)(1217 * (1.1 + difference));

    }
}
