package com.example.Patient.controller;

import com.example.Patient.dto.AnalysisCreateDto;
import com.example.Patient.dto.PatientCreateDto;
import com.example.Patient.dto.PatientDto;
import com.example.Patient.service.PatientService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientDto>> getAll() {
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{medicalCode}")
    public ResponseEntity<PatientDto> getPatient(@RequestHeader("Authorization") String authorization, @PathVariable("medicalCode") String medicalCode) {
        return new ResponseEntity<>(patientService.findByMedicalCode(medicalCode), HttpStatus.OK);
    }

    @DeleteMapping("/{medicalCode}")
    public ResponseEntity<Boolean> removePatient(@PathVariable("medicalCode") String medicalCode) {
        return new ResponseEntity<>(patientService.remove(medicalCode), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PatientDto> getPatient(@RequestBody PatientCreateDto patientCreateDto) {
        return new ResponseEntity<>(patientService.add(patientCreateDto), HttpStatus.OK);
    }

    @PostMapping("/analysis")
    public ResponseEntity<Boolean> sendAnalysis(@RequestHeader("Authorization") String authorization, @RequestBody AnalysisCreateDto analysisCreateDto){
        return new ResponseEntity<>(patientService.sendForAnalysis(analysisCreateDto, authorization.split(" ")[1]), HttpStatus.OK);
    }
}
