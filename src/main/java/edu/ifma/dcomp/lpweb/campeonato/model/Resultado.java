package edu.ifma.dcomp.lpweb.campeonato.model;

import jakarta.persistence.*;

@Entity
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int numGolsMandante;
    private int numGolsVisitante;

    @OneToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumGolsMandante() {
        return numGolsMandante;
    }

    public void setNumGolsMandante(int numGolsMandante) {
        this.numGolsMandante = numGolsMandante;
    }

    public int getNumGolsVisitante() {
        return numGolsVisitante;
    }

    public void setNumGolsVisitante(int numGolsVisitante) {
        this.numGolsVisitante = numGolsVisitante;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public int getSaldoGolsMandante() {
        return numGolsMandante - numGolsVisitante;
    }

    public int getSaldoGolsVisitante() {
        return numGolsVisitante - numGolsMandante;
    }
}
