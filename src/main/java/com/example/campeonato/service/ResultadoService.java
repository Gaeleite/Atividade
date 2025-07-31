package com.example.campeonato.service;

import com.example.campeonato.model.Resultado;
import com.example.campeonato.repository.ResultadoRepository;

import lombok.Data;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class ResultadoService {
    private final ResultadoRepository repository;

    public ResultadoService(ResultadoRepository repository) {
        this.repository = repository;
    }

    public List<Resultado> findAll() {
        return repository.findAll();
    }

    public Optional<Resultado> findById(Integer id) {
        return repository.findById(id);
    }

    public Resultado save(Resultado resultado) {
        return repository.save(resultado);
    }

    public Resultado update(Integer id, Resultado resultado) {
        return repository.save(resultado);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
