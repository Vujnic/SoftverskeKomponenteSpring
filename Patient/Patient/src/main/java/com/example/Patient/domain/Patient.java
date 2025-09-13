package com.example.Patient.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("PATIENT")
//@NoArgsConstructor
//@AllArgsConstructor
public class Patient {
    @Id
    private String medicalCode;
    private String firstName;
    private String lastName;
    @Embedded
    private Address address;
    @OneToOne
    private MedicalRecord medicalRecord;
    public Patient(String medicalCode, String firstName, String lastName, Address address, MedicalRecord medicalRecord) {
        this.medicalCode = medicalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.medicalRecord = medicalRecord;
    }
    public Patient(){

    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
}

