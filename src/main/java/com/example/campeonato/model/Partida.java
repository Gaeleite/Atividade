package com.example.campeonato.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

    @ManyToOne
    @JoinColumn(name = "mandante_id")
    private Time mandante;

    @ManyToOne
    @JoinColumn(name = "visitante_id")
    private Time visitante;

    @OneToOne(mappedBy = "partida", cascade = CascadeType.ALL)
    private Resultado resultado;
}
