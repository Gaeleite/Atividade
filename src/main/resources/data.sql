-- Estádios
INSERT INTO estadio (id, nome, endereco) VALUES (1, 'São Januário', 'Rio de Janeiro');
INSERT INTO estadio (id, nome, endereco) VALUES (2, 'Maracanã', 'Rio de Janeiro');

-- Times
INSERT INTO time (id, nome, estadio_id) VALUES (1, 'Vasco', 1);
INSERT INTO time (id, nome, estadio_id) VALUES (2, 'Flamengo', 2);

-- Jogadores - Vasco
INSERT INTO jogador (id, nome, nascimento, altura, time_id) VALUES (1, 'Edmundo', '1971-04-02', 1.75, 1);
INSERT INTO jogador (id, nome, nascimento, altura, time_id) VALUES (2, 'Pedrinho', '1977-06-29', 1.73, 1);

-- Jogadores - Flamengo
INSERT INTO jogador (id, nome, nascimento, altura, time_id) VALUES (3, 'Júnior', '1954-06-29', 1.78, 2);
INSERT INTO jogador (id, nome, nascimento, altura, time_id) VALUES (4, 'Sávio', '1974-01-09', 1.76, 2);

-- Campeonato
INSERT INTO campeonato (id, ano, nome) VALUES (1, 2023, 'Campeonato Serie A');

-- Partidas
INSERT INTO partida (id, data, campeonato_id, mandante_id, visitante_id) VALUES (1, '2023-05-21', 1, 1, 2);
INSERT INTO partida (id, data, campeonato_id, mandante_id, visitante_id) VALUES (2, '2023-05-24', 1, 2, 1);

-- Resultados
INSERT INTO resultado (partida_id, num_gols_mandante, num_gols_visitante) VALUES (1, 2, 1); -- Vasco 2 x 1 Flamengo
INSERT INTO resultado (partida_id, num_gols_mandante, num_gols_visitante) VALUES (2, 3, 2); -- Flamengo 3 x 2 Vasco
