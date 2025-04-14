# AURA MS Client

Este microsserviço é parte da arquitetura **AURA MS Client**, fornecendo funcionalidades de gerenciamento de clientes e seus endereços.
É uma aplicação Spring Boot projetada com uma abordagem de arquitetura limpa. Ela gerencia dados de clientes com validação e persistência em um banco de dados PostgreSQL.

## Stack Tecnológica

- Java 21
- Spring Boot 3.4.4
- PostgreSQL
- Flyway (migrações de banco de dados)
- JPA / Hibernate
- JUnit 5 & Mockito (testes)
- Docker & Docker Compose
- Maven

## Estrutura do Projeto

![img_1.png](img_1.png)

## Arquitetura

O projeto segue um padrão de **arquitetura limpa** com clara separação de responsabilidades:

- **domain**: Contém lógica de negócios e entidades
- **application**: Casos de uso que orquestram operações do domínio
- **adapters**: Controladores e repositórios que lidam com comunicação externa
- **gateway**: Implementações de infraestrutura para persistência

