package com.example.komponente_spring.runner;

import com.example.komponente_spring.domain.*;
import com.example.komponente_spring.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class AppRunner {

    private DoctorRepository doctorRepository;

    @Bean
    CommandLineRunner loadData() {
        return args -> {
            Address address = new Address();
            Doctor d = new Doctor("Marko", "Markovic", "mmarkovic","12345678", "1111", address, Status.ACTIVE, "kardiologija");
            //d.setUsername("mmarkovic");
            //d.setPassword("12345678");
            doctorRepository.save(d);
        };
    }
}
