package edu.ifma.dcomp.lpweb.campeonato.service;

import edu.ifma.dcomp.lpweb.campeonato.model.Resultado;
import edu.ifma.dcomp.lpweb.campeonato.repository.ResultadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadoService {

    private final ResultadoRepository resultadoRepository;

    public ResultadoService(ResultadoRepository resultadoRepository) {
        this.resultadoRepository = resultadoRepository;
    }

    public List<Resultado> findAll() {
        return resultadoRepository.findAll();
    }

    public Optional<Resultado> findById(Integer id) {
        return resultadoRepository.findById(id);
    }

    public Resultado save(Resultado resultado) {
        return resultadoRepository.save(resultado);
    }

    public Resultado update(Integer id, Resultado novoResultado) {
        if (resultadoRepository.existsById(id)) {
            novoResultado.setId(id);
            return resultadoRepository.save(novoResultado);
        }
        throw new RuntimeException("Resultado não encontrado para atualização.");
    }

    public void deleteById(Integer id) {
        resultadoRepository.deleteById(id);
    }
}
