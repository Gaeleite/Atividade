package com.example.campeonato.controller;

import com.example.campeonato.model.Campeonato;
import com.example.campeonato.service.CampeonatoService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/campeonatos")
@Data
public class CampeonatoController {
    private final CampeonatoService service;

    public CampeonatoController(CampeonatoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Campeonato> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Campeonato findById(@PathVariable Integer id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Campeonato create(@RequestBody Campeonato campeonato) {
        return service.save(campeonato);
    }

    @PutMapping("/{id}")
    public Campeonato update(@PathVariable Integer id, @RequestBody Campeonato campeonato) {
        return service.update(id, campeonato);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
