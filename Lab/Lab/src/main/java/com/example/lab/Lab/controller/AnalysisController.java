package com.example.lab.Lab.controller;

import com.example.lab.Lab.dto.AnalysisCreateDto;
import com.example.lab.Lab.service.AnalysisService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analysis")
@AllArgsConstructor
public class AnalysisController {

    private AnalysisService analysisService;

    @GetMapping("/{id}")
    public ResponseEntity<String> getResult(@PathVariable("id") Long id){
        return new ResponseEntity<>(analysisService.getResult(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> putResult(@PathVariable("id") Long id, @RequestBody String result){
        return new ResponseEntity<>(analysisService.putResult(id, result), HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Boolean> createAnalysis(@PathVariable("id") Long id, @RequestBody AnalysisCreateDto result){
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
