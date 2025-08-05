package com.example.campeonato.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class JogadorDTO {
    private Integer id;
    private String nome;
    private LocalDate nascimento;
    private float altura;
    private Integer timeId;
}
