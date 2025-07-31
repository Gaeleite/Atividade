package com.example.campeonato.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private LocalDate nascimento;
    private float altura;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;
}
