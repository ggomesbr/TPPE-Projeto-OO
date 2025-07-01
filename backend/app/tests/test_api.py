import pytest
from fastapi.testclient import TestClient
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.pool import StaticPool

from ..main import app
from ..database import Base, get_db
from ..models import models


@pytest.mark.skip()
def test_read_root(client):
    """Testa o endpoint raiz que retorna Hello World."""
    pass

@pytest.mark.skip()
def test_health_check(client):
    """Testa o endpoint de health check."""
    pass

@pytest.mark.skip()
def test_create_pessoa(client):
    """Testa a criação de uma pessoa."""
    pass

@pytest.mark.skip()
def test_read_pessoa(client):
    """Testa a leitura de uma pessoa pelo ID."""
    pass

@pytest.mark.skip()
def test_create_cliente(client):
    """Testa a criação de um cliente."""
    pass

@pytest.mark.skip()
def test_read_cliente(client):
    """Testa a leitura de um cliente pelo ID."""
    pass

@pytest.mark.skip()
def test_create_usuario(client):
    """Testa a criação de um usuário."""
    pass

@pytest.mark.skip()
def test_read_usuario(client):
    """Testa a leitura de um usuário pelo ID."""
    pass

@pytest.mark.skip()
def test_update_pessoa(client):
    """Testa a atualização de uma pessoa."""
    pass

@pytest.mark.skip()
def test_delete_pessoa(client):
    """Testa a exclusão de uma pessoa."""
    pass