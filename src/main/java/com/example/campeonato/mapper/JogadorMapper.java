package com.example.campeonato.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.campeonato.model.Jogador;
import com.example.campeonato.dto.JogadorDTO;
import com.example.campeonato.model.Time;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface JogadorMapper {

    @Mapping(target = "timeId", source = "time.id")
    JogadorDTO toDto(Jogador jogador);

    @Mapping(target = "time", source = "timeId", qualifiedByName = "timeIdToTime")
    Jogador toEntity(JogadorDTO jogadorDTO);

    @Named("timeIdToTime")
    default Time timeIdToTime(Integer timeId) {
        if (timeId == null) {
            return null;
        }
        Time time = new Time();
        time.setId(timeId);
        return time;
    }
}