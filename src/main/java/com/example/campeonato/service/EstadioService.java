package com.example.campeonato.service;

import com.example.campeonato.model.Estadio;
import com.example.campeonato.repository.EstadioRepository;

import lombok.Data;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class EstadioService {
    private final EstadioRepository repository;

    public EstadioService(EstadioRepository repository) {
        this.repository = repository;
    }

    public List<Estadio> findAll() {
        return repository.findAll();
    }

    public Optional<Estadio> findById(Integer id) {
        return repository.findById(id);
    }

    public Estadio save(Estadio estadio) {
        return repository.save(estadio);
    }

    public Estadio update(Integer id, Estadio estadio) {
        estadio.setId(id);
        return repository.save(estadio);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
