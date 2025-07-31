package com.example.campeonato.controller;

import com.example.campeonato.model.Resultado;
import com.example.campeonato.service.ResultadoService;

import lombok.Data;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/resultados")
public class ResultadoController {
    private final ResultadoService service;

    public ResultadoController(ResultadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Resultado> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Resultado findById(@PathVariable Integer id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Resultado create(@RequestBody Resultado resultado) {
        return service.save(resultado);
    }

    @PutMapping("/{id}")
    public Resultado update(@PathVariable Integer id, @RequestBody Resultado resultado) {
        return service.update(id, resultado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
