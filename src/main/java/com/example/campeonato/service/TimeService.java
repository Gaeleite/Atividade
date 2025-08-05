package com.example.campeonato.service;

import com.example.campeonato.model.Time;
import com.example.campeonato.repository.TimeRepository;

import lombok.Data;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class TimeService {
    private final TimeRepository repository;

    public TimeService(TimeRepository repository) {
        this.repository = repository;
    }

    public List<Time> findAll() {
        return repository.findAll();
    }

    public Optional<Time> findById(Integer id) {
        return repository.findById(id);
    }

    public Time save(Time time) {
        return repository.save(time);
    }

    public Time update(Integer id, Time time) {
        time.setId(id);
        return repository.save(time);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
