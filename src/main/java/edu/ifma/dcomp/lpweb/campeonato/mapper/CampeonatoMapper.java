package edu.ifma.dcomp.lpweb.campeonato.mapper;

import edu.ifma.dcomp.lpweb.campeonato.dto.CampeonatoDTO;
import edu.ifma.dcomp.lpweb.campeonato.model.Campeonato;

public class CampeonatoMapper {

    public static CampeonatoDTO toDTO(Campeonato campeonato) {
        CampeonatoDTO dto = new CampeonatoDTO();
        dto.setNome(campeonato.getNome());
        return dto;
    }

    public static Campeonato toEntity(CampeonatoDTO dto) {
        Campeonato campeonato = new Campeonato();
        campeonato.setNome(dto.getNome());
        return campeonato;
    }
}
