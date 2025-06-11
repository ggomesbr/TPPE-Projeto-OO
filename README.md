# FastAPI Hello World com MySQL

Um sistema básico com FastAPI, MySQL e Docker Compose.

## Requisitos

- Docker
- Docker Compose

## Estrutura do Projeto

```
.
├── backend
│   ├── app
│   │   ├── models
│   │   ├── schemas
│   │   ├── tests
│   │   ├── database.py
│   │   └── main.py
│   ├── Dockerfile
│   ├── Dockerfile.test
│   └── requirements.txt
└── docker-compose.yml
```

## Funcionalidades

- API FastAPI que retorna "Hello World!"
- Documentação Swagger disponível
- Banco de dados MySQL com tabelas Cliente, Pessoa e Usuario
- Testes configurados (10 testes ignorados)

## Como Executar

1. Clone o repositório
2. Execute o seguinte comando para iniciar os contêineres:

```bash
docker-compose up -d
```

3. Acesse a API em: http://localhost:8000
4. Acesse a documentação Swagger em: http://localhost:8000/docs

## Como Executar os Testes

```bash
docker-compose run tests
``` 