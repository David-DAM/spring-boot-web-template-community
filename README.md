# Spring Boot Web Community Template 🚀

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.java.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
---

## Elige tu idioma | Choose your language:

- [Español](#español)
- [English](#english)

---

## Español

### Índice

1. [Descripción General](#descripción-general-)
2. [Características Principales](#características-principales-)
3. [Tecnologías y Dependencias](#tecnologías--dependencias-)
4. [Instalación y Puesta en Marcha](#instalación--puesta-en-marcha-)
5. [Arquitectura del proyecto](#arquitectura-del-proyecto)
6. [Licencia](#licencia)

### Descripción General 🌟

Una plantilla completa de Spring Boot que implementa patrones de arquitectura modernos y mejores prácticas. Esta
plantilla proporciona una base sólida para construir microservicios escalables y mantenibles.

**¿Quieres más funcionalidades y soporte adicional?**

Accede a la versión completa de la plantilla con características adicionales y soporte exclusivo para entornos de
producción a través de la [versión comercial](https://davinchicoder.dev/templates).

### Características Principales 🔑

- Arquitectura Hexagonal
- Containerización con Docker Compose
- Pruebas unitarias
- PostgresSQL con Soporte Vector

### Tecnologías & Dependencias 🛠️

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- JUnit 5
- Lombock
- MapStruct
- DevTools

### Instalación & Puesta en Marcha 🚀

1. Clona el repositorio:
   ```bash
   git clone https://github.com/David-DAM/spring-boot-web-template-community.git
   cd spring-boot-web-template-community
   ```
2. Configura las variables de entorno si es necesario.
3. Instala las dependencias
   ```bash
   mvn clean install
   ```
4. Inicia los servicios:
   ```bash
   docker-compose up -d
   ```
5. Ejecuta la aplicación:
   ```bash
   ./mvnw spring-boot:run
   ```

### Arquitectura del proyecto

Este proyecto utiliza el patrón Mediator para una separación clara de responsabilidades y facilitar la extensibilidad.

Cada operación se representa por una combinación de:

Request → Objeto que representa la entrada del usuario.

Handler → Lógica de negocio que procesa el Request.

Response → Resultado devuelto por el handler.

Este patrón se implementa gracias a una capa personalizada que enruta cada request a su handler correspondiente.

Esto permite tener controladores extremadamente delgados y lógica desacoplada.

### Licencia

#### Versión gratuita

Esta plantilla cuenta con la licencia [MIT License](LICENSE).

Puede usarla, modificarla y distribuirla libremente para proyectos personales, educativos o no comerciales.

#### Versión comercial

Para uso comercial, consulte el [Acuerdo de licencia comercial](LICENSE-COMMERCIAL.txt).

La versión comercial incluye funciones y soporte adicionales. Debe adquirir la licencia comercial para usar esta
plantilla en entornos de producción o con fines comerciales.

---

## English

### Index

1. [Overview](#overview-)
2. [Key Features](#key-features-)
3. [Technologies & Dependencies](#technologies--dependencies-)
4. [Setup & Installation](#setup--installation-)
5. [Project Architecture](#project-architecture)
6. [License](#license)

### Overview 🌟

A comprehensive Spring Boot template implementing modern architecture patterns and best practices. This template
provides a solid foundation for building scalable and maintainable microservices.

**Want more features and additional support?**

Access the full version of the template with additional features and exclusive support for production environments
through the [commercial version](https://davinchicoder.dev/templates).

### Key Features 🔑

- Hexagonal Architecture
- Containerization with Docker Compose
- PostgresSQL with Vector Support

### Technologies & Dependencies 🛠️

- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- PostgresSQL
- Docker & Docker Compose
- JUnit 5
- Lombock
- MapStruct
- DevTools

### Setup & Installation 🚀

1. Clone the repository:
   ```bash
   git clone https://github.com/David-DAM/spring-boot-web-template-community.git
   cd spring-boot-web-template-community
   ```
2. Set up environment variables if needed.
3. Install dependencies
   ```bash
   mvn clean install
   ```
4. Start the services:
   ```bash
   docker-compose up -d
   ```
5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Project Architecture

This project uses the Mediator pattern for a clear separation of responsibilities and easy extensibility.

Each operation is represented by a combination of:

Request → Object representing user input.

Handler → Business logic that processes the Request.

Response → Result returned by the handler.

This pattern is implemented through a custom layer that routes each request to its corresponding handler.

This allows for extremely lean controllers and decoupled logic.

### License

#### Free Version

This template is licensed under the [MIT License](LICENSE).

You can freely use, modify, and distribute this template for personal, educational, or non-commercial projects.

#### Commercial Version

For commercial use, please refer to the [Commercial License Agreement](LICENSE-COMMERCIAL.txt).

The commercial version includes additional features and support. You must purchase the commercial license to use this
template in production environments or for commercial purposes.
