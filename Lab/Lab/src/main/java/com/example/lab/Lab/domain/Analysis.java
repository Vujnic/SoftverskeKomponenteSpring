package com.example.lab.Lab.domain;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Analysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp activeFrom;
    private Timestamp activeTo;
    private String name;
    private String descr;
    private String result;
    private String measure;
    @Column(nullable = false)
    private boolean done;
    private Long laborantId;

}
