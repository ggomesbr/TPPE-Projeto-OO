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

### Opção 1: Comando Único (Recomendado)
Execute todo o projeto (banco + testes + backend) com um único comando:

```bash
docker-compose up --build
```

**O que acontece:**
1. 🗄️ Sobe o banco de dados MySQL
2. 🧪 Executa os testes automaticamente
3. 🚀 Se os testes passarem, sobe o backend
4. ❌ Se os testes falharem, o backend não sobe

### Opção 2: Scripts de Conveniência

**Windows (PowerShell):**
```powershell
.\start.ps1
```

### Opção 3: Makefile (Linux/Mac)
```bash
make all
```

### Para Parar Tudo
```bash
docker-compose down -v
```

## Como Executar os Testes

Os testes são executados automaticamente quando você usa `docker-compose up --build`.

Para executar apenas os testes:
```bash
docker-compose run --rm tests
```

## Acessar a Aplicação

Após executar com sucesso (testes passando):
- **API:** http://localhost:8000
- **Documentação (Swagger):** http://localhost:8000/docs
- **Banco MySQL:** localhost:13306 (user: user, password: password) 