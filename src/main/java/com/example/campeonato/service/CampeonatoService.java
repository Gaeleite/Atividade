package com.example.campeonato.service;

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.repository.CampeonatoRepository;

import lombok.Data;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class CampeonatoService {
    private final CampeonatoRepository repository;

    public CampeonatoService(CampeonatoRepository repository) {
        this.repository = repository;
    }

    public List<Campeonato> findAll() {
        return repository.findAll();
    }

    public Optional<Campeonato> findById(Integer id) {
        return repository.findById(id);
    }

    public Campeonato save(Campeonato campeonato) {
        return repository.save(campeonato);
    }

    public Campeonato update(Integer id, Campeonato campeonato) {
        campeonato.setId(id);
        return repository.save(campeonato);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
