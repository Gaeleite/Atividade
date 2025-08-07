package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Resultado;
import edu.ifma.dcomp.lpweb.campeonato.service.ResultadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultados")
public class ResultadoController {

    private final ResultadoService resultadoService;

    public ResultadoController(ResultadoService resultadoService) {
        this.resultadoService = resultadoService;
    }

    @GetMapping
    public ResponseEntity<List<Resultado>> findAll() {
        return ResponseEntity.ok(resultadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resultado> findById(@PathVariable Integer id) {
        return resultadoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Resultado> create(@RequestBody Resultado resultado) {
        return ResponseEntity.ok(resultadoService.save(resultado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resultado> update(@PathVariable Integer id, @RequestBody Resultado resultado) {
        try {
            return ResponseEntity.ok(resultadoService.update(id, resultado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        resultadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
