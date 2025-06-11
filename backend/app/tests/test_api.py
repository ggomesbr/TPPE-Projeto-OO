import pytest
from fastapi.testclient import TestClient
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from sqlalchemy.pool import StaticPool

from ..main import app
from ..database import Base, get_db
from ..models import Pessoa, Cliente, Usuario

# Configuração do banco de dados de teste
SQLALCHEMY_DATABASE_URL = "sqlite:///./test.db"
engine = create_engine(SQLALCHEMY_DATABASE_URL, connect_args={"check_same_thread": False}, poolclass=StaticPool)
TestingSessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

@pytest.fixture(scope="function")
def test_db():
    Base.metadata.create_all(bind=engine)
    db = TestingSessionLocal()
    try:
        yield db
    finally:
        db.close()
        Base.metadata.drop_all(bind=engine)

@pytest.fixture(scope="function")
def client(test_db):
    def override_get_db():
        try:
            yield test_db
        finally:
            pass
    
    app.dependency_overrides[get_db] = override_get_db
    with TestClient(app) as c:
        yield c
    app.dependency_overrides.clear()

@pytest.mark.skip(reason="Teste não implementado")
def test_read_root(client):
    """Testa o endpoint raiz que retorna Hello World."""
    pass

@pytest.mark.skip(reason="Teste não implementado")
def test_health_check(client):
    """Testa o endpoint de health check."""
    pass

@pytest.mark.skip(reason="Teste não implementado")
def test_create_pessoa(client):
    """Testa a criação de uma pessoa."""
    pass

@pytest.mark.skip(reason="Teste não implementado")
def test_read_pessoa(client):
    """Testa a leitura de uma pessoa pelo ID."""
    pass

@pytest.mark.skip(reason="Teste não implementado")
def test_create_cliente(client):
    """Testa a criação de um cliente."""
    pass

@pytest.mark.skip(reason="Teste não implementado")
def test_read_cliente(client):
    """Testa a leitura de um cliente pelo ID."""
    pass

@pytest.mark.skip(reason="Teste não implementado")
def test_create_usuario(client):
    """Testa a criação de um usuário."""
    pass

@pytest.mark.skip(reason="Teste não implementado")
def test_read_usuario(client):
    """Testa a leitura de um usuário pelo ID."""
    pass

@pytest.mark.skip(reason="Teste não implementado")
def test_update_pessoa(client):
    """Testa a atualização de uma pessoa."""
    pass

@pytest.mark.skip(reason="Teste não implementado")
def test_delete_pessoa(client):
    """Testa a exclusão de uma pessoa."""
    pass