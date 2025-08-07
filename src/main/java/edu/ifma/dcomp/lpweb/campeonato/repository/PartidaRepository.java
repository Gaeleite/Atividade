package edu.ifma.dcomp.lpweb.campeonato.repository;

import edu.ifma.dcomp.lpweb.campeonato.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer> {

    // Exemplo de método: busca partidas já realizadas por campeonato
    List<Partida> findByDataBeforeAndMandante_CampeonatoId(LocalDate data, Integer campeonatoId);
}
