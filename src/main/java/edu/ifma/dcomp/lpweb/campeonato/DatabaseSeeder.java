package edu.ifma.dcomp.lpweb.campeonato;

import edu.ifma.dcomp.lpweb.campeonato.model.*;
import edu.ifma.dcomp.lpweb.campeonato.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class DatabaseSeeder {

    @Bean
    CommandLineRunner initDatabase(
            EstadioRepository estadioRepo,
            TimeRepository timeRepo,
            JogadorRepository jogadorRepo,
            CampeonatoRepository campeonatoRepo,
            PartidaRepository partidaRepo,
            ResultadoRepository resultadoRepo
    ) {
        return args -> {

            // Estádios
            Estadio maracana = new Estadio();
            maracana.setNome("Maracanã");
            maracana.setEndereco("Rio de Janeiro - RJ");
            estadioRepo.save(maracana);

            Estadio castelao = new Estadio();
            castelao.setNome("Castelão");
            castelao.setEndereco("São Luís - MA");
            estadioRepo.save(castelao);

            // Times
            Time flamengo = new Time();
            flamengo.setNome("Flamengo");
            flamengo.setCidade("Rio de Janeiro");
            flamengo.setEstadioSede(maracana);
            timeRepo.save(flamengo);

            Time sampaio = new Time();
            sampaio.setNome("Sampaio Corrêa");
            sampaio.setCidade("São Luís");
            sampaio.setEstadioSede(castelao);
            timeRepo.save(sampaio);

            // Jogadores
            Jogador j1 = new Jogador();
            j1.setNome("Carlos Silva");
            j1.setIdade(25);
            j1.setTime(flamengo);
            jogadorRepo.save(j1);

            Jogador j2 = new Jogador();
            j2.setNome("João Souza");
            j2.setIdade(22);
            j2.setTime(sampaio);
            jogadorRepo.save(j2);

            // Campeonato
            Campeonato brasileirao = new Campeonato();
            brasileirao.setNome("Brasileirão 2025");
            brasileirao.setTimes(Arrays.asList(flamengo, sampaio));
            campeonatoRepo.save(brasileirao);

            // Partida passada
            Partida partida1 = new Partida();
            partida1.setData(LocalDate.now().minusDays(5));
            partida1.setMandante(flamengo);
            partida1.setVisitante(sampaio);
            partida1.setEstadio(maracana);
            partida1.setCampeonato(brasileirao);
            partidaRepo.save(partida1);

            Resultado resultado1 = new Resultado();
            resultado1.setPartida(partida1);
            resultado1.setNumGolsMandante(2);
            resultado1.setNumGolsVisitante(1);
            resultadoRepo.save(resultado1);

            partida1.setResultado(resultado1);
            partidaRepo.save(partida1);

            // Partida futura
            Partida partida2 = new Partida();
            partida2.setData(LocalDate.now().plusDays(3));
            partida2.setMandante(sampaio);
            partida2.setVisitante(flamengo);
            partida2.setEstadio(castelao);
            partida2.setCampeonato(brasileirao);
            partidaRepo.save(partida2);
        };
    }
}
