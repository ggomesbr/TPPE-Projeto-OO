.PHONY: db-up test backend-up all down

# Sobe apenas o banco e espera ficar saudável
db-up:
	docker-compose up db --build -d
	docker-compose exec db mysqladmin ping -h localhost -u user -ppassword --wait

# Roda os testes (usando o mesmo volume do backend)
test:
	docker-compose up db --build -d
	docker-compose exec db mysqladmin ping -h localhost -u user -ppassword --wait
	docker-compose run --rm tests

# Sobe o backend (assume que os testes já passaram)
backend-up:
	docker-compose up backend --build

# Fluxo completo: banco -> testes -> backend
all: test backend-up

# Derruba todos os containers e remove volumes
down:
	docker-compose down -v
