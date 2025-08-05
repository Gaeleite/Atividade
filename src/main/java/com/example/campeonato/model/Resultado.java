package com.example.campeonato.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resultado {
    @Id
    @OneToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;

    private int numGolsMandante;
    private int numGolsVisitante;

    public int getSaldoGolsMandante() {
        return numGolsMandante - numGolsVisitante;
    }

    public int getSaldoGolsVisitante() {
        return numGolsVisitante - numGolsMandante;
    }

    public boolean jogoEmpatado() {
        return numGolsMandante == numGolsVisitante;
    }
}
