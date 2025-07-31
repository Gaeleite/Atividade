package com.example.campeonato.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.campeonato.model.Jogador;
import com.example.campeonato.dto.JogadorDTO;

@Mapper(componentModel = "spring")
public interface JogadorMapper {
    @Mapping(source = "time.id", target = "timeId")
    JogadorDTO toDTO(Jogador jogador);

    @Mapping(target = "time", ignore = true)
    Jogador toEntity(JogadorDTO dto);
}
