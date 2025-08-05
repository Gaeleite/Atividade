package com.example.campeonato.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.campeonato.model.Jogador;
import com.example.campeonato.dto.JogadorDTO;
import com.example.campeonato.model.Time;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JogadorMapper {

    @Mapping(target = "timeId", source = "time.id")  // Maps Jogador.time.id → JogadorDTO.timeId
    JogadorDTO toDTO(Jogador jogador);

    @Mapping(target = "time", ignore = true)  // We'll handle this manually
    Jogador toEntity(JogadorDTO dto);

    default Time mapTimeIdToTime(Integer timeId) {
        if (timeId == null) {
            return null;
        }
        Time time = new Time();
        time.setId(timeId);
        return time;
    }
}