.PHONY: db-up test backend-up all down

# Sobe apenas o banco e espera ficar saudável
db-up:
	docker-compose up -d db

# Roda os testes (usando o mesmo volume do backend)
test: db-up
	docker-compose run --rm tests

# Sobe o backend (assume que os testes já passaram)
backend-up:
	docker-compose up backend

# Fluxo completo: banco -> testes -> backend
all: test backend-up

# Derruba todos os containers e remove volumes
down:
	docker-compose down -v
