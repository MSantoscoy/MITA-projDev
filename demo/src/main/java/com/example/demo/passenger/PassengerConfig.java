package com.example.demo.passenger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/ublic class PassengerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PassengerRepository repository){
        return args-> {

        };
        repository.saveAll(

        );
  };
}
