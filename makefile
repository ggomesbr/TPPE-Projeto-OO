.PHONY: db-up backend-up all down

# Sobe apenas o banco e espera ficar saudável
db-up:
	docker-compose up db --build -d
	docker-compose exec db mysqladmin ping -h localhost -u user -ppassword --wait



# Sobe o backend (assume que os testes já passaram)
backend-up:
	docker-compose up backend --build

# Fluxo completo: banco -> testes -> backend
all: db-up backend-up

# Derruba todos os containers e remove volumes
down:
	docker-compose down -v
