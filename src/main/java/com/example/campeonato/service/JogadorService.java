package com.example.campeonato.service;

import com.example.campeonato.dto.JogadorDTO;
import com.example.campeonato.mapper.JogadorMapper;
import com.example.campeonato.model.Jogador;
import com.example.campeonato.model.Time;
import com.example.campeonato.repository.JogadorRepository;
import com.example.campeonato.repository.TimeRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final TimeRepository timeRepository;

    public JogadorService(JogadorRepository jogadorRepository, TimeRepository timeRepository) {
        this.jogadorRepository = jogadorRepository;
        this.timeRepository = timeRepository;
    }

    public Page<Jogador> findAll(Pageable pageable) {
        return jogadorRepository.findAll(pageable);
    }

    public Optional<Jogador> findById(Integer id) {
        return jogadorRepository.findById(id);
    }

    public Jogador save(Jogador jogador, Integer timeId) {
        Time time = timeRepository.findById(timeId)
                .orElseThrow(() -> new RuntimeException("Time não encontrado"));
        jogador.setTime(time);
        return jogadorRepository.save(jogador);
    }

    public Jogador update(Integer id, Jogador jogador, Integer timeId) {
        jogador.setId(id);
        Time time = timeRepository.findById(timeId)
                .orElseThrow(() -> new RuntimeException("Time não encontrado"));
        jogador.setTime(time);
        return jogadorRepository.save(jogador);
    }

    public void delete(Integer id) {
        jogadorRepository.deleteById(id);
    }
}
