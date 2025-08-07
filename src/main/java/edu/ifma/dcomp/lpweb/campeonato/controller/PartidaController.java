package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Partida;
import edu.ifma.dcomp.lpweb.campeonato.service.PartidaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    private final PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping
    public ResponseEntity<List<Partida>> findAll() {
        return ResponseEntity.ok(partidaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> findById(@PathVariable Integer id) {
        return partidaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Partida> create(@RequestBody Partida partida) {
        return ResponseEntity.ok(partidaService.save(partida));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partida> update(@PathVariable Integer id, @RequestBody Partida partida) {
        try {
            return ResponseEntity.ok(partidaService.update(id, partida));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        partidaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // ✅ Endpoint extra exigido no Lab: partidas passadas de um campeonato
    @GetMapping("/passadas/{campeonatoId}")
    public ResponseEntity<List<Partida>> partidasPassadas(@PathVariable Integer campeonatoId) {
        return ResponseEntity.ok(partidaService.findPassadasByCampeonato(campeonatoId));
    }
}
