import pytest
from fastapi.testclient import TestClient
from app.main import app

client = TestClient(app)

def test_create_vendedor():
    payload = {
        "nome": "Vendedor Teste",
        "cpf": "88899900011",
        "email": "vendedor@email.com",
        "endereco": "Rua Vendedor, 1",
        "cidade": "Cidade Vendedor",
        "estado": "VD",
        "cep": "11223344",
        "bairro": "Centro",
        "observacao": "Vendedor top",
        "senha": "senha123"
    }
    response = client.post("/vendedores/", json=payload)
    assert response.status_code == 201
    data = response.json()
    assert data["cpf"] == payload["cpf"]
    assert data["email"] == payload["email"]

def test_get_vendedor():
    payload = {
        "nome": "Vendedor Busca",
        "cpf": "99900011122",
        "email": "buscavendedor@email.com",
        "endereco": "Rua Busca, 2",
        "cidade": "Cidade Busca",
        "estado": "VB",
        "cep": "22334455",
        "bairro": "Bairro Busca",
        "observacao": "Busca vendedor",
        "senha": "senhaBusca"
    }
    create_resp = client.post("/vendedores/", json=payload)
    vendedor_id = create_resp.json()["id"]
    response = client.get(f"/vendedores/{vendedor_id}")
    assert response.status_code == 200
    data = response.json()
    assert data["id"] == vendedor_id
    assert data["cpf"] == payload["cpf"]

def test_list_vendedores():
    response = client.get("/vendedores/")
    assert response.status_code == 200
    assert isinstance(response.json(), list)

def test_update_vendedor():
    payload = {
        "nome": "Vendedor Update",
        "cpf": "00011122233",
        "email": "updatevendedor@email.com",
        "endereco": "Rua Update, 3",
        "cidade": "Cidade Update",
        "estado": "VU",
        "cep": "33445566",
        "bairro": "Bairro Update",
        "observacao": "Update vendedor",
        "senha": "senhaUpdate"
    }
    create_resp = client.post("/vendedores/", json=payload)
    vendedor_id = create_resp.json()["id"]
    update_payload = {"nome": "Vendedor Atualizado"}
    response = client.put(f"/vendedores/{vendedor_id}", json=update_payload)
    assert response.status_code == 200
    assert response.json()["nome"] == "Vendedor Atualizado"

def test_delete_vendedor():
    payload = {
        "nome": "Vendedor Delete",
        "cpf": "11122233344",
        "email": "deletevendedor@email.com",
        "endereco": "Rua Delete, 4",
        "cidade": "Cidade Delete",
        "estado": "VD",
        "cep": "44556677",
        "bairro": "Bairro Delete",
        "observacao": "Delete vendedor",
        "senha": "senhaDelete"
    }
    create_resp = client.post("/vendedores/", json=payload)
    vendedor_id = create_resp.json()["id"]
    response = client.delete(f"/vendedores/{vendedor_id}")
    assert response.status_code == 204
    get_resp = client.get(f"/vendedores/{vendedor_id}")
    assert get_resp.status_code == 404
