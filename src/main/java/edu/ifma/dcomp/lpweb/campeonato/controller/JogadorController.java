package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Jogador;
import edu.ifma.dcomp.lpweb.campeonato.service.JogadorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @GetMapping
    public ResponseEntity<Page<Jogador>> findAll(Pageable pageable) {
        return ResponseEntity.ok(jogadorService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> findById(@PathVariable Integer id) {
        return jogadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Jogador> create(@RequestBody Jogador jogador) {
        Jogador novoJogador = jogadorService.save(jogador);
        return ResponseEntity.ok(novoJogador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> update(@PathVariable Integer id, @RequestBody Jogador jogador) {
        try {
            Jogador atualizado = jogadorService.update(id, jogador);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        jogadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
