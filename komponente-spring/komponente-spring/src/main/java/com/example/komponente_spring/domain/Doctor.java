package com.example.komponente_spring.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@DiscriminatorValue("DOCTOR")
@NoArgsConstructor
@Getter
@Setter
public class Doctor extends Employee {
    private String specialization;

    public Doctor(String firstName, String lastName, String username, String password, String contactNumber, Address address, Status status, String specialization) {
        super(firstName, lastName, username, password, contactNumber, address, status, Role.DOCTOR);
        this.specialization = specialization;
    }
}
