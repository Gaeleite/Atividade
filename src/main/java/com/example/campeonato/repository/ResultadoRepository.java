package com.example.campeonato.repository;

import com.example.campeonato.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {
}
