package com.example.Patient.service;

import com.example.Patient.dto.AnalysisCreateDto;
import com.example.Patient.dto.PatientCreateDto;
import com.example.Patient.dto.PatientDto;

import java.util.List;

public interface PatientService {
    List<PatientDto> findAll();

    PatientDto findByMedicalCode(String medicalCode);

    PatientDto add(PatientCreateDto patientCreateDto);

    Boolean remove(String medicalCode);

    Boolean sendForAnalysis(AnalysisCreateDto acd, String token);
}
