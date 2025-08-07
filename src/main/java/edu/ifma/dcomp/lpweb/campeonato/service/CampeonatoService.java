package edu.ifma.dcomp.lpweb.campeonato.service;

import edu.ifma.dcomp.lpweb.campeonato.model.Campeonato;
import edu.ifma.dcomp.lpweb.campeonato.repository.CampeonatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {

    private final CampeonatoRepository campeonatoRepository;

    public CampeonatoService(CampeonatoRepository campeonatoRepository) {
        this.campeonatoRepository = campeonatoRepository;
    }

    public List<Campeonato> findAll() {
        return campeonatoRepository.findAll();
    }

    public Optional<Campeonato> findById(Integer id) {
        return campeonatoRepository.findById(id);
    }

    public Campeonato save(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public Campeonato update(Integer id, Campeonato novoCampeonato) {
        if (campeonatoRepository.existsById(id)) {
            novoCampeonato.setId(id);
            return campeonatoRepository.save(novoCampeonato);
        }
        throw new RuntimeException("Campeonato não encontrado para atualização.");
    }

    public void deleteById(Integer id) {
        campeonatoRepository.deleteById(id);
    }
}
