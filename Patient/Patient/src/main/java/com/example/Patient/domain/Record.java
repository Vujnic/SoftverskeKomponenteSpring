package com.example.Patient.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Record {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String descr;
    @Enumerated(value = EnumType.STRING)
    private RecordType type;
    @ManyToOne
    private MedicalRecord medicalRecord;
    private String result;
    private Long doctorIdOpen;
    private Long doctorIdClose;
    private boolean open;
    private Timestamp createdAt;
    private Timestamp closedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public RecordType getType() {
        return type;
    }

    public void setType(RecordType type) {
        this.type = type;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getDoctorIdOpen() {
        return doctorIdOpen;
    }

    public void setDoctorIdOpen(Long doctorIdOpen) {
        this.doctorIdOpen = doctorIdOpen;
    }

    public Long getDoctorIdClose() {
        return doctorIdClose;
    }

    public void setDoctorIdClose(Long doctorIdClose) {
        this.doctorIdClose = doctorIdClose;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Timestamp closedAt) {
        this.closedAt = closedAt;
    }
}
