package com.example.campeonato.controller;

import com.example.campeonato.model.Partida;
import com.example.campeonato.model.Resultado;
import com.example.campeonato.model.Time;
import com.example.campeonato.service.PartidaService;
import com.example.campeonato.service.TimeService;

import lombok.Data;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@Data
@RequestMapping("/classificacao")
public class ClassificacaoController {

    private final PartidaService partidaService;
    private final TimeService timeService;

    public ClassificacaoController(PartidaService partidaService, TimeService timeService) {
        this.partidaService = partidaService;
        this.timeService = timeService;
    }

    @GetMapping("/{campeonatoId}")
    public List<Map<String, Object>> getClassificacao(@PathVariable Integer campeonatoId) {
        List<Partida> partidas = partidaService.findPassadasByCampeonato(campeonatoId);

        Map<Time, Integer> vitorias = new HashMap<>();
        Map<Time, Integer> saldoGols = new HashMap<>();

        for (Partida partida : partidas) {
            Resultado r = partida.getResultado();
            if (r == null) continue;

            Time mandante = partida.getMandante();
            Time visitante = partida.getVisitante();

            int saldoMandante = r.getSaldoGolsMandante();
            int saldoVisitante = r.getSaldoGolsVisitante();

            saldoGols.put(mandante, saldoGols.getOrDefault(mandante, 0) + saldoMandante);
            saldoGols.put(visitante, saldoGols.getOrDefault(visitante, 0) + saldoVisitante);

            if (r.getNumGolsMandante() > r.getNumGolsVisitante()) {
                vitorias.put(mandante, vitorias.getOrDefault(mandante, 0) + 1);
            } else if (r.getNumGolsMandante() < r.getNumGolsVisitante()) {
                vitorias.put(visitante, vitorias.getOrDefault(visitante, 0) + 1);
            }
        }

        return timeService.findAll().stream()
            .map(time -> {
                Map<String, Object> map = new LinkedHashMap<>();
                map.put("time", time.getNome());
                map.put("vitorias", vitorias.getOrDefault(time, 0));
                map.put("saldoGols", saldoGols.getOrDefault(time, 0));
                return map;
            })
            .sorted(Comparator.comparingInt((Map<String, Object> m) -> (Integer) m.get("vitorias")).reversed()
                    .thenComparingInt(m -> (Integer) m.get("saldoGols")).reversed())
            .collect(Collectors.toList());
    }
}
