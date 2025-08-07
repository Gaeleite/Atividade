package edu.ifma.dcomp.lpweb.campeonato.service;

import edu.ifma.dcomp.lpweb.campeonato.model.Estadio;
import edu.ifma.dcomp.lpweb.campeonato.repository.EstadioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadioService {

    private final EstadioRepository estadioRepository;

    public EstadioService(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }

    public List<Estadio> findAll() {
        return estadioRepository.findAll();
    }

    public Optional<Estadio> findById(Integer id) {
        return estadioRepository.findById(id);
    }

    public Estadio save(Estadio estadio) {
        return estadioRepository.save(estadio);
    }

    public Estadio update(Integer id, Estadio novoEstadio) {
        if (estadioRepository.existsById(id)) {
            novoEstadio.setId(id);
            return estadioRepository.save(novoEstadio);
        }
        throw new RuntimeException("Estádio não encontrado para atualização.");
    }

    public void deleteById(Integer id) {
        estadioRepository.deleteById(id);
    }
}
