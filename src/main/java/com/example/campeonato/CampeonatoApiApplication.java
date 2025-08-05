package com.example.campeonato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;

@SpringBootApplication
@Data
public class CampeonatoApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CampeonatoApiApplication.class, args);
    }
}
