package com.example.campeonato.mapper;

import com.example.campeonato.dto.TimeDTO;
import com.example.campeonato.model.Time;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeMapper {
    TimeDTO toDTO(Time entity);
    Time toEntity(TimeDTO dto);
}
