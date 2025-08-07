package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.dto.EstadioDTO;
import edu.ifma.dcomp.lpweb.campeonato.mapper.EstadioMapper;
import edu.ifma.dcomp.lpweb.campeonato.model.Estadio;
import edu.ifma.dcomp.lpweb.campeonato.service.EstadioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadios")
public class EstadioController {

    private final EstadioService estadioService;

    public EstadioController(EstadioService estadioService) {
        this.estadioService = estadioService;
    }

    @GetMapping
    public ResponseEntity<List<EstadioDTO>> findAll() {
        List<EstadioDTO> dtos = estadioService.findAll()
                .stream().map(EstadioMapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadioDTO> findById(@PathVariable Integer id) {
        return estadioService.findById(id)
                .map(EstadioMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadioDTO> salvar(@RequestBody EstadioDTO dto) {
        Estadio estadio = EstadioMapper.toEntity(dto);
        Estadio salvo = estadioService.save(estadio);
        return ResponseEntity.ok(EstadioMapper.toDTO(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadioDTO> update(@PathVariable Integer id, @RequestBody EstadioDTO dto) {
        try {
            Estadio atualizado = EstadioMapper.toEntity(dto);
            Estadio salvo = estadioService.update(id, atualizado);
            return ResponseEntity.ok(EstadioMapper.toDTO(salvo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        estadioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
