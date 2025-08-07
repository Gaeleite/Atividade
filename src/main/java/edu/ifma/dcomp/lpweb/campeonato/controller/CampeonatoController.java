package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.dto.CampeonatoDTO;
import edu.ifma.dcomp.lpweb.campeonato.mapper.CampeonatoMapper;
import edu.ifma.dcomp.lpweb.campeonato.model.Campeonato;
import edu.ifma.dcomp.lpweb.campeonato.model.Partida;
import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import edu.ifma.dcomp.lpweb.campeonato.service.CampeonatoService;
import edu.ifma.dcomp.lpweb.campeonato.service.PartidaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    private final CampeonatoService campeonatoService;
    private final PartidaService partidaService;

    public CampeonatoController(CampeonatoService campeonatoService, PartidaService partidaService) {
        this.campeonatoService = campeonatoService;
        this.partidaService = partidaService;
    }

    @GetMapping
    public ResponseEntity<List<CampeonatoDTO>> findAll() {
        List<CampeonatoDTO> dtos = campeonatoService.findAll()
                .stream().map(CampeonatoMapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampeonatoDTO> findById(@PathVariable Integer id) {
        return campeonatoService.findById(id)
                .map(CampeonatoMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CampeonatoDTO> salvar(@RequestBody CampeonatoDTO dto) {
        Campeonato campeonato = CampeonatoMapper.toEntity(dto);
        Campeonato salvo = campeonatoService.save(campeonato);
        return ResponseEntity.ok(CampeonatoMapper.toDTO(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CampeonatoDTO> update(@PathVariable Integer id, @RequestBody CampeonatoDTO dto) {
        try {
            Campeonato atualizado = CampeonatoMapper.toEntity(dto);
            Campeonato salvo = campeonatoService.update(id, atualizado);
            return ResponseEntity.ok(CampeonatoMapper.toDTO(salvo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        campeonatoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/times")
    public ResponseEntity<List<Time>> listarTimes(@PathVariable Integer id) {
        return campeonatoService.findById(id)
                .map(c -> ResponseEntity.ok(c.getTimes()))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/partidas/passadas")
    public ResponseEntity<List<Partida>> partidasPassadas(@PathVariable Integer id) {
        return campeonatoService.findById(id)
                .map(c -> c.getPartidas().stream()
                        .filter(p -> p.getData() != null && p.getData().isBefore(LocalDate.now()))
                        .toList())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/partidas/futuras")
    public ResponseEntity<List<Partida>> partidasFuturas(@PathVariable Integer id) {
        return campeonatoService.findById(id)
                .map(c -> c.getPartidas().stream()
                        .filter(p -> p.getData() != null && !p.getData().isBefore(LocalDate.now()))
                        .toList())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
