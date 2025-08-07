
package edu.ifma.dcomp.lpweb.campeonato.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String cidade;

    @OneToMany(mappedBy = "time")
    private List<Jogador> jogadores;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public List<Jogador> getJogadores() { return jogadores; }
    public void setJogadores(List<Jogador> jogadores) { this.jogadores = jogadores; }

    @ManyToOne
    @JoinColumn(name = "estadio_id")
    private Estadio estadioSede;

    public Estadio getEstadioSede() {
        return estadioSede;
    }

    public void setEstadioSede(Estadio estadioSede) {
        this.estadioSede = estadioSede;
    }

}
