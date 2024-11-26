package com.example.demo.payment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Bean
    CommandLineRunner commandLineRunner(PaymentRepository repository){
        return args -> {

        };
    }
}
