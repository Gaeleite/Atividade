package edu.ifma.dcomp.lpweb.campeonato.controller;

import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import edu.ifma.dcomp.lpweb.campeonato.service.TimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping
    public ResponseEntity<List<Time>> findAll() {
        return ResponseEntity.ok(timeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> findById(@PathVariable Integer id) {
        return timeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Time> create(@RequestBody Time time) {
        Time novoTime = timeService.save(time);
        return ResponseEntity.ok(novoTime);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> update(@PathVariable Integer id, @RequestBody Time time) {
        try {
            Time atualizado = timeService.update(id, time);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        timeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
