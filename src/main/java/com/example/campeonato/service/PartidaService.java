package com.example.campeonato.service;

import com.example.campeonato.model.Partida;
import com.example.campeonato.repository.PartidaRepository;

import lombok.Data;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Data
public class PartidaService {
    private final PartidaRepository repository;

    public PartidaService(PartidaRepository repository) {
        this.repository = repository;
    }

    public List<Partida> findAll() {
        return repository.findAll();
    }

    public Optional<Partida> findById(Integer id) {
        return repository.findById(id);
    }

    public Partida save(Partida partida) {
        return repository.save(partida);
    }

    public Partida update(Integer id, Partida partida) {
        partida.setId(id);
        return repository.save(partida);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Partida> findFuturasByCampeonato(Integer campeonatoId) {
        return repository.findByCampeonatoIdAndDataAfter(campeonatoId, LocalDate.now());
    }

    public List<Partida> findPassadasByCampeonato(Integer campeonatoId) {
        return repository.findByCampeonatoIdAndDataBefore(campeonatoId, LocalDate.now());
    }
}
