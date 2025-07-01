from sqlalchemy import Column, Integer, String, ForeignKey, Boolean, DateTime
from sqlalchemy.orm import relationship
from sqlalchemy.sql import func
from ..database import Base

class Pessoa(Base):
    __tablename__ = "pessoas"

    id = Column(Integer, primary_key=True, index=True)
    nome = Column(String(100), nullable=True)
    cpf = Column(String(11), nullable=False, unique=True)
    email = Column(String(100), nullable=False)
    endereco = Column(String(100), nullable=False)
    cidade = Column(String(100), nullable=False)
    estado = Column(String(100), nullable=False)
    cidade = Column(String(100), nullable=False)
    cep = Column(String(100), nullable=False)
    bairro = Column(String(100), nullable=False)
    
class Cliente(Base):
    __tablename__ = "clientes"

    id = Column(Integer, primary_key=True, index=True)
    observacao = Column(String(500), nullable=True)
    
class Vendedor(Base):
    __tablename__ = "vendedores"

    id = Column(Integer, primary_key=True, index=True)
    observacao = Column(String(50), nullable=False)
    senha = Column(String(100), nullable=False)