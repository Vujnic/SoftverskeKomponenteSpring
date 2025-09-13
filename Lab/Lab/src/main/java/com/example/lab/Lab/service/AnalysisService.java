package com.example.lab.Lab.service;


import com.example.lab.Lab.domain.Analysis;
import com.example.lab.Lab.repository.AnalysisRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AnalysisService {

    private AnalysisRepository analysisRepository;
    public String getResult(Long id){
        Analysis analysis = analysisRepository.findById(id).orElse(null);
        if(analysis == null) return "Analysis not found";
        if(analysis.isDone() && analysis.getResult() == "") return "Results not ready";
        if(!analysis.isDone() && analysis.getActiveTo().before(Timestamp.valueOf(LocalDateTime.now())))
            return "Analysis expired";
        return analysis.getResult();
    }

    public Boolean putResult(Long id, String result) {
        Analysis analysis = analysisRepository.findById(id).orElse(null);
        if(analysis == null) return false;

        analysis.setResult(result);
        analysisRepository.save(analysis);

        return true;
    }
}
