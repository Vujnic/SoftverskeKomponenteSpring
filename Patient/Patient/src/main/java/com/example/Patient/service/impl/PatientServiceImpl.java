package com.example.Patient.service.impl;

import com.example.Patient.domain.Patient;
import com.example.Patient.domain.Record;
import com.example.Patient.dto.AnalysisCreateDto;
import com.example.Patient.dto.PatientCreateDto;
import com.example.Patient.dto.PatientDto;
import com.example.Patient.mapper.PatientMapper;
import com.example.Patient.queue.AnalysisProducer;
import com.example.Patient.repository.PatientRepository;
import com.example.Patient.repository.RecordRepository;
import com.example.Patient.security.service.TokenService;
import com.example.Patient.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientRepository patientRepository;
    private RecordRepository recordRepository;
    private PatientMapper patientMapper;
    private AnalysisProducer analysisProducer;
    private TokenService tokenService;

    public PatientServiceImpl(PatientRepository patientRepository, RecordRepository recordRepository, PatientMapper patientMapper, AnalysisProducer analysisProducer, TokenService tokenService) {
        this.patientRepository = patientRepository;
        this.recordRepository = recordRepository;
        this.patientMapper = patientMapper;
        this.analysisProducer = analysisProducer;
        this.tokenService = tokenService;
    }

    @Override
    public List<PatientDto> findAll() {
        return patientRepository.findAll().stream()
                .map(patient -> patientMapper.getDtoFromDomain(patient))
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto findByMedicalCode(String medicalCode) {
        Patient patient = patientRepository.findByMedicalCode(medicalCode).orElseThrow(()->new RuntimeException("patient not found"));

        return patientMapper.getDtoFromDomain(patient);
    }

    @Override
    public PatientDto add(PatientCreateDto patientCreateDto) {
        Patient p = patientMapper.getDomainFromDto(patientCreateDto);
        p = patientRepository.save(p);
        return patientMapper.getDtoFromDomain(p);
    }

    @Override
    public Boolean remove(String medicalCode) {
        Patient patient = patientRepository.findByMedicalCode(medicalCode).orElseThrow(()->new RuntimeException("patient not found"));

        patientRepository.delete(patient);
        return true;
    }

    @Override
    public Boolean sendForAnalysis(AnalysisCreateDto acd, String token) {
        Long doctor = tokenService.getUserIdFromToken(token);
        Record record = patientMapper.getRecord(acd, doctor);
        recordRepository.save(record);
        analysisProducer.sendMessage(acd);
        return true;
    }
}
