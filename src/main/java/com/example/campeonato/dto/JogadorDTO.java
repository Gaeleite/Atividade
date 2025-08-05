package com.example.campeonato.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JogadorDTO {
    private Integer id;
    private String nome;
    private LocalDate nascimento;
    private float altura;
    private Integer timeId;
}
