package edu.ifma.dcomp.lpweb.campeonato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://localhost:8080/h2-console
// ./mvnw spring-boot:run

@SpringBootApplication
public class CampeonatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampeonatoApplication.class, args);
	}

}

/*
---

## 2. `application.properties` final

```properties
# Porta padrão
server.port=8080

# Configuração do H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Datasource do banco em memória (UUID personalizado)
spring.datasource.url=jdbc:h2:mem:8d8896b6-336a-4ca4-b0af-dbbafb9e169d
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA - criação automática das tabelas
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Evitar erros de timezone
spring.jpa.properties.hibernate.jdbc.time_zone=UTC
*/