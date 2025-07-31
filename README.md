# 🏆 Campeonato de Futebol - API REST

Projeto desenvolvido como parte da **Etapa 07** da disciplina *Linguagem de Programação para Web* do curso de Sistemas de Informação - IFMA.

## 🎯 Objetivo

Implementar uma API REST para gerenciamento de campeonatos de futebol, com funcionalidades para:

- Cadastro e gerenciamento de jogadores, times, estádios, campeonatos, partidas e resultados
- Endpoints personalizados para partidas futuras, partidas já ocorridas e classificação do campeonato
- Validações, tratamento de erros e arquitetura limpa com DTOs, services, controllers e mappers

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Flyway
- MapStruct
- Lombok
- Maven

---

## 🧩 Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/campeonato-api.git
cd campeonato-api
```

### 2. Executar com Maven

```bash
./mvnw spring-boot:run
```

Ou, se estiver usando o Spring Tool Suite ou IntelliJ, basta executar a classe:

```
com.example.campeonato.CampeonatoApiApplication
```

### 3. Acessar o H2 Console

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: *(deixe em branco)*

---

## 📌 Endpoints principais

### 🧍 Jogadores

- `GET /jogadores`
- `POST /jogadores`
- `GET /jogadores/{id}`
- `PUT /jogadores/{id}`
- `DELETE /jogadores/{id}`

### 🏟 Estádios

- `GET /estadios`, `POST`, `PUT`, `DELETE`

### 🧑‍🤝‍🧑 Times

- `GET /times`
- `POST /times`
- `GET /times/{id}`

### 🏆 Campeonatos

- `GET /campeonatos`
- `POST /campeonatos`

### 📅 Partidas

- `GET /partidas`
- `GET /partidas/campeonato/{id}/futuras`
- `GET /partidas/campeonato/{id}/passadas`

### 📊 Classificação

- `GET /classificacao/{campeonatoId}` → ordena por vitórias e saldo de gols

---

## ✅ Requisitos Atendidos

- CRUD completo para todas as entidades
- Regras de negócio em services
- DTOs + MapStruct
- Tratamento global de erros com `@ControllerAdvice`
- Paginação em `/jogadores`
- Classificação e listagem contextual de partidas

---

## 📝 Autores

- João Gabriel Leite Silva
- Paulo Roberto
- Matheus Maranhão

Instituto Federal do Maranhão - IFMA Monte Castelo

2025
