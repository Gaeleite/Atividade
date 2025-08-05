package com.example.campeonato.controller;

import com.example.campeonato.model.Partida;
import com.example.campeonato.service.PartidaService;

import lombok.Data;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/partidas")
public class PartidaController {
    private final PartidaService service;

    public PartidaController(PartidaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Partida> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Partida findById(@PathVariable Integer id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Partida create(@RequestBody Partida partida) {
        return service.save(partida);
    }

    @PutMapping("/{id}")
    public Partida update(@PathVariable Integer id, @RequestBody Partida partida) {
        return service.update(id, partida);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/campeonato/{campeonatoId}/futuras")
    public List<Partida> partidasFuturas(@PathVariable Integer campeonatoId) {
        return service.findFuturasByCampeonato(campeonatoId);
    }

    @GetMapping("/campeonato/{campeonatoId}/passadas")
    public List<Partida> partidasPassadas(@PathVariable Integer campeonatoId) {
        return service.findPassadasByCampeonato(campeonatoId);
    }
}
