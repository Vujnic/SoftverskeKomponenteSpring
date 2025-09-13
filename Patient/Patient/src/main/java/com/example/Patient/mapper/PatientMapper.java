package com.example.Patient.mapper;


import com.example.Patient.domain.Patient;
import com.example.Patient.domain.Record;
import com.example.Patient.dto.AnalysisCreateDto;
import com.example.Patient.dto.PatientCreateDto;
import com.example.Patient.dto.PatientDto;
import com.example.Patient.repository.PatientRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class PatientMapper {

    private PatientRepository patientRepository;

    public PatientMapper(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientDto getDtoFromDomain(Patient patient){
        PatientDto patientDto = new PatientDto();
        patientDto.setFirstName(patient.getFirstName());
        patientDto.setLastName(patient.getLastName());
        patientDto.setMedicalCode(patient.getMedicalCode());

        return patientDto;
    }

    public Patient getDomainFromDto(PatientCreateDto patientCreateDto){
        Patient patient = new Patient();
        patient.setAddress(patientCreateDto.getAddress());
        patient.setMedicalCode(patientCreateDto.getMedicalCode());
        patient.setFirstName(patientCreateDto.getFirstName());
        patient.setLastName(patientCreateDto.getLastName());
        return patient;
    }

    public Record getRecord(AnalysisCreateDto analysisCreateDto, Long doctor){
        Record record = new Record();
        Patient p = patientRepository.findByMedicalCode(analysisCreateDto.getMedicalCode()).get();
        record.setMedicalRecord(p.getMedicalRecord());
        record.setName(analysisCreateDto.getName());
        record.setDescr(analysisCreateDto.getDescr());
        record.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        record.setDoctorIdOpen(doctor);
        return record;
    }
}
