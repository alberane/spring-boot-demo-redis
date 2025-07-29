# Spring Boot Demo Redis

Este projeto demonstra como integrar o Redis como cache em uma API REST de clientes usando Spring Boot.

## Funcionalidades

- CRUD de clientes (criar, listar, atualizar, remover)
- Cache da listagem de clientes no Redis
- Expiração automática do cache (TTL configurado)
- Banco de dados em memória H2 para persistência dos clientes

## Tecnologias

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Data Redis
- Redis
- H2 Database
- Docker e Docker Compose

## Como executar

### Pré-requisitos

- Docker e Docker Compose instalados

### Subindo a aplicação

```sh
docker-compose up --build
```

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

### Endpoints principais

- `GET /clientes` — Lista todos os clientes (com cache)
- `POST /clientes` — Cria um novo cliente
- `PUT /clientes/{id}` — Atualiza um cliente existente
- `DELETE /clientes/{id}` — Remove um cliente

## Cache com Redis

- O endpoint de listagem (`GET /clientes`) é cacheado no Redis.
- O cache é invalidado automaticamente ao criar, atualizar ou remover clientes.
- O tempo de expiração do cache está configurado para 10 segundos.

## Visualizando o cache no Redis

Acesse o terminal do Redis:

```sh
docker-compose exec redis redis-cli
```

Liste as chaves:

```sh
KEYS *
```

Veja o conteúdo da chave de clientes:

```sh
GET "clientes::SimpleKey []"
```

## Dados de exemplo

O projeto inclui um arquivo `tools/data.sql` para popular o banco H2 com clientes de exemplo ao iniciar.

## Observações

- As respostas da API são sempre em JSON.
- O cache pode ser facilmente ajustado ou desabilitado conforme a necessidade.

---

Desenvolvido para fins de estudo e