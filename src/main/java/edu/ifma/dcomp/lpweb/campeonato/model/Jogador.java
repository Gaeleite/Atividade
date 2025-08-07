
package edu.ifma.dcomp.lpweb.campeonato.model;

import jakarta.persistence.*;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Integer getIdade() { return idade; }
    public void setIdade(Integer idade) { this.idade = idade; }

    public Time getTime() { return time; }
    public void setTime(Time time) { this.time = time; }
}
