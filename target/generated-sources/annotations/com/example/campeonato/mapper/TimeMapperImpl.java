package com.example.campeonato.mapper;

import com.example.campeonato.dto.TimeDTO;
import com.example.campeonato.model.Time;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-05T14:34:01-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class TimeMapperImpl implements TimeMapper {

    @Override
    public TimeDTO toDTO(Time entity) {
        if ( entity == null ) {
            return null;
        }

        TimeDTO timeDTO = new TimeDTO();

        return timeDTO;
    }

    @Override
    public Time toEntity(TimeDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Time time = new Time();

        return time;
    }
}
