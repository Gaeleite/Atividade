package com.example.campeonato.repository;

import com.example.campeonato.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PartidaRepository extends JpaRepository<Partida, Integer> {
    List<Partida> findByCampeonatoIdAndDataAfter(Integer campeonatoId, LocalDate data);
    List<Partida> findByCampeonatoIdAndDataBefore(Integer campeonatoId, LocalDate data);
}
