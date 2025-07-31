package com.example.campeonato.repository;

import com.example.campeonato.model.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampeonatoRepository extends JpaRepository<Campeonato, Integer> {
}
