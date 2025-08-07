package edu.ifma.dcomp.lpweb.campeonato.service;

import edu.ifma.dcomp.lpweb.campeonato.model.Time;
import edu.ifma.dcomp.lpweb.campeonato.repository.TimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public List<Time> findAll() {
        return timeRepository.findAll();
    }

    public Optional<Time> findById(Integer id) {
        return timeRepository.findById(id);
    }

    public Time save(Time time) {
        return timeRepository.save(time);
    }

    public Time update(Integer id, Time novoTime) {
        if (timeRepository.existsById(id)) {
            novoTime.setId(id);
            return timeRepository.save(novoTime);
        }
        throw new RuntimeException("Time não encontrado para atualização.");
    }

    public void deleteById(Integer id) {
        timeRepository.deleteById(id);
    }
}
