package com.example.campeonato.controller;

import com.example.campeonato.model.Estadio;
import com.example.campeonato.service.EstadioService;

import lombok.Data;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/estadios")
public class EstadioController {
    private final EstadioService service;

    public EstadioController(EstadioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estadio> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Estadio findById(@PathVariable Integer id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Estadio create(@RequestBody Estadio estadio) {
        return service.save(estadio);
    }

    @PutMapping("/{id}")
    public Estadio update(@PathVariable Integer id, @RequestBody Estadio estadio) {
        return service.update(id, estadio);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
