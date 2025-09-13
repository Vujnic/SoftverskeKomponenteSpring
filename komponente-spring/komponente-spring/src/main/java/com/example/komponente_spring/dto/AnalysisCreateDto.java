package com.example.komponente_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnalysisCreateDto {
    private Timestamp from;
    private Timestamp to;
    private String name;
    private String descr;
    private String result;
    private String measure;
}
