package com.example.campeonato.mapper;

import com.example.campeonato.dto.JogadorDTO;
import com.example.campeonato.model.Jogador;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-31T14:40:23-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Eclipse Adoptium)"
)
@Component
public class JogadorMapperImpl implements JogadorMapper {

    @Override
    public JogadorDTO toDTO(Jogador jogador) {
        if ( jogador == null ) {
            return null;
        }

        JogadorDTO jogadorDTO = new JogadorDTO();

        return jogadorDTO;
    }

    @Override
    public Jogador toEntity(JogadorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Jogador jogador = new Jogador();

        return jogador;
    }
}
