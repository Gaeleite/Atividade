CREATE TABLE estadio (
    id INT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255)
);

CREATE TABLE time (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    estadio_id INT,
    FOREIGN KEY (estadio_id) REFERENCES estadio(id)
);

CREATE TABLE jogador (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    nascimento DATE,
    altura FLOAT,
    time_id INT,
    FOREIGN KEY (time_id) REFERENCES time(id)
);

CREATE TABLE campeonato (
    id INT PRIMARY KEY,
    ano INT,
    nome VARCHAR(100)
);

CREATE TABLE partida (
    id INT PRIMARY KEY,
    data DATE,
    campeonato_id INT,
    mandante_id INT,
    visitante_id INT,
    FOREIGN KEY (campeonato_id) REFERENCES campeonato(id),
    FOREIGN KEY (mandante_id) REFERENCES time(id),
    FOREIGN KEY (visitante_id) REFERENCES time(id)
);

CREATE TABLE resultado (
    partida_id INT PRIMARY KEY,
    num_gols_mandante INT,
    num_gols_visitante INT,
    FOREIGN KEY (partida_id) REFERENCES partida(id)
);
