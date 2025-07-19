import pytest
from fastapi.testclient import TestClient
from app.main import app

client = TestClient(app)

def test_create_cliente():
    payload = {
        "nome": "Cliente Teste",
        "cpf": "22233344455",
        "email": "cliente@email.com",
        "endereco": "Rua Cliente, 1",
        "cidade": "Cidade Cliente",
        "estado": "CL",
        "cep": "12345000",
        "bairro": "Centro",
        "observacao": "Cliente especial"
    }
    response = client.post("/clientes/", json=payload)
    assert response.status_code == 201
    data = response.json()
    assert data["cpf"] == payload["cpf"]
    assert data["email"] == payload["email"]

def test_get_cliente():
    payload = {
        "nome": "Cliente Busca",
        "cpf": "33344455566",
        "email": "busca@email.com",
        "endereco": "Rua Busca, 2",
        "cidade": "Cidade Busca",
        "estado": "CB",
        "cep": "54321000",
        "bairro": "Bairro Busca",
        "observacao": "Busca cliente"
    }
    create_resp = client.post("/clientes/", json=payload)
    cliente_id = create_resp.json()["id"]
    response = client.get(f"/clientes/{cliente_id}")
    assert response.status_code == 200
    data = response.json()
    assert data["id"] == cliente_id
    assert data["cpf"] == payload["cpf"]

def test_list_clientes():
    response = client.get("/clientes/")
    assert response.status_code == 200
    assert isinstance(response.json(), list)

def test_update_cliente():
    payload = {
        "nome": "Cliente Update",
        "cpf": "44455566677",
        "email": "update@email.com",
        "endereco": "Rua Update, 3",
        "cidade": "Cidade Update",
        "estado": "CU",
        "cep": "67891000",
        "bairro": "Bairro Update",
        "observacao": "Update cliente"
    }
    create_resp = client.post("/clientes/", json=payload)
    cliente_id = create_resp.json()["id"]
    update_payload = {"nome": "Cliente Atualizado"}
    response = client.put(f"/clientes/{cliente_id}", json=update_payload)
    assert response.status_code == 200
    assert response.json()["nome"] == "Cliente Atualizado"

def test_delete_cliente():
    payload = {
        "nome": "Cliente Delete",
        "cpf": "55566677788",
        "email": "delete@email.com",
        "endereco": "Rua Delete, 4",
        "cidade": "Cidade Delete",
        "estado": "CD",
        "cep": "98765000",
        "bairro": "Bairro Delete",
        "observacao": "Delete cliente"
    }
    create_resp = client.post("/clientes/", json=payload)
    cliente_id = create_resp.json()["id"]
    response = client.delete(f"/clientes/{cliente_id}")
    assert response.status_code == 204
    get_resp = client.get(f"/clientes/{cliente_id}")
    assert get_resp.status_code == 404
