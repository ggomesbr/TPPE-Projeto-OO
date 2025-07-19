import pytest
from fastapi.testclient import TestClient
from app.main import app

client = TestClient(app)

def test_create_pessoa():
    payload = {
        "nome": "João Silva",
        "cpf": "12345678901",
        "email": "joao@email.com",
        "endereco": "Rua A, 123",
        "cidade": "Brasília",
        "estado": "DF",
        "cep": "70000000",
        "bairro": "Centro"
    }
    response = client.post("/pessoas/", json=payload)
    assert response.status_code == 201
    data = response.json()
    assert data["cpf"] == payload["cpf"]
    assert data["email"] == payload["email"]

def test_get_pessoa():
    # First, create a pessoa
    payload = {
        "nome": "Maria Souza",
        "cpf": "98765432100",
        "email": "maria@email.com",
        "endereco": "Rua B, 456",
        "cidade": "Goiânia",
        "estado": "GO",
        "cep": "74000000",
        "bairro": "Setor Sul"
    }
    create_resp = client.post("/pessoas/", json=payload)
    pessoa_id = create_resp.json()["id"]
    response = client.get(f"/pessoas/{pessoa_id}")
    assert response.status_code == 200
    data = response.json()
    assert data["id"] == pessoa_id
    assert data["cpf"] == payload["cpf"]

def test_list_pessoas():
    response = client.get("/pessoas/")
    assert response.status_code == 200
    assert isinstance(response.json(), list)

def test_update_pessoa():
    # Create a pessoa
    payload = {
        "nome": "Carlos Lima",
        "cpf": "11122233344",
        "email": "carlos@email.com",
        "endereco": "Rua C, 789",
        "cidade": "São Paulo",
        "estado": "SP",
        "cep": "01000000",
        "bairro": "Bela Vista"
    }
    create_resp = client.post("/pessoas/", json=payload)
    pessoa_id = create_resp.json()["id"]
    update_payload = {"nome": "Carlos Lima Updated"}
    response = client.put(f"/pessoas/{pessoa_id}", json=update_payload)
    assert response.status_code == 200
    assert response.json()["nome"] == "Carlos Lima Updated"

def test_delete_pessoa():
    # Create a pessoa
    payload = {
        "nome": "Ana Paula",
        "cpf": "55566677788",
        "email": "ana@email.com",
        "endereco": "Rua D, 101",
        "cidade": "Recife",
        "estado": "PE",
        "cep": "50000000",
        "bairro": "Boa Vista"
    }
    create_resp = client.post("/pessoas/", json=payload)
    pessoa_id = create_resp.json()["id"]
    response = client.delete(f"/pessoas/{pessoa_id}")
    assert response.status_code == 204
    # Confirm deletion
    get_resp = client.get(f"/pessoas/{pessoa_id}")
    assert get_resp.status_code == 404
