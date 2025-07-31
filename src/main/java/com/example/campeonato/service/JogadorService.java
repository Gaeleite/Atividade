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
    private final JogadorMapper jogadorMapper;

    public JogadorService(JogadorRepository jogadorRepository, TimeRepository timeRepository, JogadorMapper jogadorMapper) {
        this.jogadorRepository = jogadorRepository;
        this.timeRepository = timeRepository;
        this.jogadorMapper = jogadorMapper;
    }

    public Page<JogadorDTO> findAll(Pageable pageable) {
        return jogadorRepository.findAll(pageable)
                .map(jogadorMapper::toDTO);
    }

    public Optional<JogadorDTO> findById(Integer id) {
        return jogadorRepository.findById(id)
                .map(jogadorMapper::toDTO);
    }

    public JogadorDTO save(JogadorDTO dto) {
        Jogador jogador = jogadorMapper.toEntity(dto);
        Time time = timeRepository.findById(dto.getTimeId())
                .orElseThrow(() -> new RuntimeException("Time não encontrado"));
        jogador.setTime(time);
        return jogadorMapper.toDTO(jogadorRepository.save(jogador));
    }

    public JogadorDTO update(Integer id, JogadorDTO dto) {
        Jogador jogador = jogadorMapper.toEntity(dto);
        jogador.setId(id);
        Time time = timeRepository.findById(dto.getTimeId())
                .orElseThrow(() -> new RuntimeException("Time não encontrado"));
        jogador.setTime(time);
        return jogadorMapper.toDTO(jogadorRepository.save(jogador));
    }

    public void delete(Integer id) {
        jogadorRepository.deleteById(id);
    }
}
