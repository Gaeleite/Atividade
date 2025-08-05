package com.example.campeonato.controller;

import com.example.campeonato.dto.TimeDTO;
import com.example.campeonato.mapper.TimeMapper;
import com.example.campeonato.model.Time;
import com.example.campeonato.service.TimeService;

import lombok.Data;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Data
@RequestMapping("/times")
public class TimeController {
    private final TimeService service;
    private final TimeMapper mapper;

    public TimeController(TimeService service, TimeMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<TimeDTO> findAll() {
        return service.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TimeDTO findById(@PathVariable Integer id) {
        return service.findById(id).map(mapper::toDTO).orElse(null);
    }

    @PostMapping
    public TimeDTO create(@RequestBody TimeDTO dto) {
        Time time = mapper.toEntity(dto);
        return mapper.toDTO(service.save(time));
    }

    @PutMapping("/{id}")
    public TimeDTO update(@PathVariable Integer id, @RequestBody TimeDTO dto) {
        Time time = mapper.toEntity(dto);
        return mapper.toDTO(service.update(id, time));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
