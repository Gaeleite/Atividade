package com.example.campeonato.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
}
