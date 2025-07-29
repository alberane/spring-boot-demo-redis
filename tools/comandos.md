# Para ver acontecer o cache no Redis

1. Execute o docker compose

```bash 
docker compose up --build
```

2. Acessa via http o endpoint de clientes e cria o cache

```bash 
curl --request GET --url http://localhost:8080/clientes
```

3. Acessa o Redis CLI para verificar o cache

```bash
docker-compose exec <nome_do_container_redis> redis-cli
```

4. Verifica o cache de clientes dentro do Redis 

- O cache vai expirar em 10s (conforme configuração da aplicação)
- Ele vai mostrar dados em binário/json
- Depois de 10s o retorno é um `(nil)`
```bash
GET "clientes::SimpleKey []" 
```