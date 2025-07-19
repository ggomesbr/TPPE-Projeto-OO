
from ..database import Base
from sqlalchemy import Column, Integer, String, ForeignKey, Boolean, DateTime
from sqlalchemy.orm import relationship
from sqlalchemy.sql import func

# Loja model
class Loja(Base):
    __tablename__ = "lojas"

    id = Column(Integer, primary_key=True, index=True)
    nome = Column(String(100), nullable=False)
    endereco = Column(String(200), nullable=False)
    telefone = Column(String(50), nullable=False)
    qntdFuncionarios = Column(Integer, nullable=False)
    faturamento = Column(String(100), nullable=False)

    # Relationships
    vendedores = relationship("Vendedor", backref="loja", cascade="all, delete-orphan")  # 1 or more
    clientes = relationship("Cliente", backref="loja", cascade="all, delete-orphan")    # 0 or more
    automoveis = relationship("Automovel", backref="loja", cascade="all, delete-orphan")  # 1 or more

# Marca model
class Marca(Base):
    __tablename__ = "marcas"

    id = Column(Integer, primary_key=True, index=True)
    descricao = Column(String(100), nullable=False)

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
    
class Cliente(Pessoa):
    __tablename__ = "clientes"

    id = Column(Integer, ForeignKey("pessoas.id"), primary_key=True)
    observacao = Column(String(500), nullable=True)

class Vendedor(Pessoa):
    __tablename__ = "vendedores"

    id = Column(Integer, ForeignKey("pessoas.id"), primary_key=True)
    observacao = Column(String(50), nullable=False)
    senha = Column(String(100), nullable=False)



# Venda model
class Venda(Base):
    __tablename__ = "vendas"

    id = Column(Integer, primary_key=True, index=True)
    dataPedido = Column(DateTime, nullable=False)
    dataEntrega = Column(DateTime, nullable=True)
    valorTotal = Column(String(100), nullable=False)
    tipoPagamento = Column(String(100), nullable=False)
    qntdParcelas = Column(Integer, nullable=False)
    descricao = Column(String(500), nullable=True)
    comissao = Column(String(100), nullable=True)



# Automovel model
class Automovel(Base):
    __tablename__ = "automoveis"

    id = Column(Integer, primary_key=True, index=True)
    cor = Column(String(50), nullable=False)
    portas = Column(Integer, nullable=False)
    combustivel = Column(Integer, nullable=False)
    chassi = Column(String(100), nullable=False, unique=True)
    valor_fabrica = Column(String(100), nullable=False)
    ano = Column(Integer, nullable=False)
    loja_id = Column(Integer, ForeignKey("lojas.id"), nullable=True)


# Modelo model
class Modelo(Base):
    __tablename__ = "modelos"

    id = Column(Integer, primary_key=True, index=True)
    descricao = Column(String(100), nullable=False)
    tipoVeiculo = Column(String(50), nullable=False)  # Use ForeignKey if TipoVeiculo is a separate table