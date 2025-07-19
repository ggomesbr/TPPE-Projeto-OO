import pytest
from fastapi.testclient import TestClient
from app.main import app

client = TestClient(app)

def test_create_loja():
    payload = {
        "nome": "Loja Central",
        "endereco": "Rua Principal, 100",
        "cidade": "Brasília",
        "estado": "DF",
        "cep": "70000000"
    }
    response = client.post("/lojas/", json=payload)
    assert response.status_code == 201
    data = response.json()
    assert data["nome"] == payload["nome"]
    assert data["cidade"] == payload["cidade"]

def test_get_loja():
    payload = {
        "nome": "Loja Busca",
        "endereco": "Rua Busca, 200",
        "cidade": "Goiânia",
        "estado": "GO",
        "cep": "74000000"
    }
    create_resp = client.post("/lojas/", json=payload)
    loja_id = create_resp.json()["id"]
    response = client.get(f"/lojas/{loja_id}")
    assert response.status_code == 200
    data = response.json()
    assert data["id"] == loja_id
    assert data["nome"] == payload["nome"]

def test_list_lojas():
    response = client.get("/lojas/")
    assert response.status_code == 200
    assert isinstance(response.json(), list)

def test_update_loja():
    payload = {
        "nome": "Loja Update",
        "endereco": "Rua Update, 300",
        "cidade": "São Paulo",
        "estado": "SP",
        "cep": "01000000"
    }
    create_resp = client.post("/lojas/", json=payload)
    loja_id = create_resp.json()["id"]
    update_payload = {"nome": "Loja Atualizada"}
    response = client.put(f"/lojas/{loja_id}", json=update_payload)
    assert response.status_code == 200
    assert response.json()["nome"] == "Loja Atualizada"

def test_delete_loja():
    payload = {
        "nome": "Loja Delete",
        "endereco": "Rua Delete, 400",
        "cidade": "Recife",
        "estado": "PE",
        "cep": "50000000"
    }
    create_resp = client.post("/lojas/", json=payload)
    loja_id = create_resp.json()["id"]
    response = client.delete(f"/lojas/{loja_id}")
    assert response.status_code == 204
    get_resp = client.get(f"/lojas/{loja_id}")
    assert get_resp.status_code == 404
