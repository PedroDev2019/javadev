# Accounts REST API (Java 17 + Spring Boot)

API REST sencilla y modular construida con **Java 17** y **Spring Boot** para la gestión básica de cuentas y depósitos, aplicando separación por capas (`controller`, `service`, `repository`, `dto`, `exception`), validaciones de entrada y precisión decimal (`BigDecimal`).

## Características
- Creación y consulta de cuentas vía endpoints REST JSON (`/api/v1/accounts`).
- Registro de depósitos con validación de montos positivos.
- Manejo explícito de recursos no encontrados y errores de validación.
- Estructura preparada para evolucionar hacia persistencia con base de datos relacional (por ejemplo, PostgreSQL + Spring Data JPA / Flyway) y pruebas automatizadas.

## Requisitos previos
- **Java 17** (JDK)
- **Maven** (o `./mvnw` incluido en el proyecto)

## Ejecución local
```bash
mvn spring-boot:run
```

La aplicación iniciará por defecto en `http://localhost:8080`.

## Ejemplos de uso (cURL)

Crear una cuenta:
```bash
curl -X POST http://localhost:8080/api/v1/accounts \
  -H "Content-Type: application/json" \
  -d '{"holderName":"Ana Pérez","currency":"USD","initialBalance":100.00}'
```

Listar cuentas:
```bash
curl http://localhost:8080/api/v1/accounts
```

Realizar un depósito:
```bash
curl -X POST "http://localhost:8080/api/v1/accounts/{id}/deposit?amount=50.00"
```

## Próximas mejoras sugeridas
- Integración con PostgreSQL y migraciones de esquema.
- Pruebas unitarias y de integración con JUnit 5 y MockMvc.
- Empaquetado con Docker (`Dockerfile` multi-stage).

## Desarrollo por: Pedro Enrique Bravo
