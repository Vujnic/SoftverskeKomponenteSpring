package com.example.komponente_spring.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "appointment", indexes = @Index(name="doctor_search", columnList = "doctor_id"))
public class Appointment extends BaseEntity {

    private String patient;
    @ManyToOne
    private Doctor doctor;
    private Date dateAndTime;
    private String reason;
}
