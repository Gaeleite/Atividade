package edu.ifma.dcomp.lpweb.campeonato.service;

import edu.ifma.dcomp.lpweb.campeonato.model.Partida;
import edu.ifma.dcomp.lpweb.campeonato.repository.PartidaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    private final PartidaRepository partidaRepository;

    public PartidaService(PartidaRepository partidaRepository) {
        this.partidaRepository = partidaRepository;
    }

    public List<Partida> findAll() {
        return partidaRepository.findAll();
    }

    public Optional<Partida> findById(Integer id) {
        return partidaRepository.findById(id);
    }

    public Partida save(Partida partida) {
        return partidaRepository.save(partida);
    }

    public Partida update(Integer id, Partida novaPartida) {
        if (partidaRepository.existsById(id)) {
            novaPartida.setId(id);
            return partidaRepository.save(novaPartida);
        }
        throw new RuntimeException("Partida não encontrada para atualização.");
    }

    public void deleteById(Integer id) {
        partidaRepository.deleteById(id);
    }

    public List<Partida> findPassadasByCampeonato(Integer campeonatoId) {
        return partidaRepository.findByDataBeforeAndMandante_CampeonatoId(LocalDate.now(), campeonatoId);
    }
}
