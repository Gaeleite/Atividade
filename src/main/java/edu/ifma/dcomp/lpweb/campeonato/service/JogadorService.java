package edu.ifma.dcomp.lpweb.campeonato.service;

import edu.ifma.dcomp.lpweb.campeonato.model.Jogador;
import edu.ifma.dcomp.lpweb.campeonato.repository.JogadorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public Page<Jogador> findAll(Pageable pageable) {
        return jogadorRepository.findAll(pageable);
    }

    public Optional<Jogador> findById(Integer id) {
        return jogadorRepository.findById(id);
    }

    public Jogador save(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public Jogador update(Integer id, Jogador novoJogador) {
        if (jogadorRepository.existsById(id)) {
            novoJogador.setId(id);
            return jogadorRepository.save(novoJogador);
        }
        throw new RuntimeException("Jogador não encontrado para atualização.");
    }

    public void deleteById(Integer id) {
        jogadorRepository.deleteById(id);
    }
}
