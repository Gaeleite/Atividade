package edu.ifma.dcomp.lpweb.campeonato.mapper;

import edu.ifma.dcomp.lpweb.campeonato.dto.EstadioDTO;
import edu.ifma.dcomp.lpweb.campeonato.model.Estadio;

public class EstadioMapper {

    public static EstadioDTO toDTO(Estadio estadio) {
        EstadioDTO dto = new EstadioDTO();
        dto.setNome(estadio.getNome());
        dto.setEndereco(estadio.getEndereco());
        return dto;
    }

    public static Estadio toEntity(EstadioDTO dto) {
        Estadio estadio = new Estadio();
        estadio.setNome(dto.getNome());
        estadio.setEndereco(dto.getEndereco());
        return estadio;
    }
}
