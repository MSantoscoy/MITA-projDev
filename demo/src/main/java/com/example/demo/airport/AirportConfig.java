package com.example.demo.airport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AirportConfig {

    @Bean
    CommandLineRunner commandLineRunner(AirportRepository repository){
        return args-> {

//            public Airport(Integer ID, String airportName, String airportCode, String location, int timezone) {
//                this.ID = ID;
//                this.airportName = airportName;
//                this.airportCode = airportCode;
//                this.location = location;
//                this.timezone = timezone;
//            }

           Airport LAX= new Airport(1, "Los Angeles International Airport", "LAX", "Los Angeles, California", -8);

           Airport JFK= new Airport(2, "John F. Kennedy International Airport", "JFK", "Queens, New York", -5);

           Airport DFW= new Airport(3, "Dallas Fort Worth International Airport", "DFW", "Dallas, Texas", -6);


        };

    };
}
