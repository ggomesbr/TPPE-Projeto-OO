from pydantic import BaseModel, EmailStr, Field
from typing import Optional
from datetime import datetime

# Schemas para Pessoa
class PessoaBase(BaseModel):
    nome: str
    sobrenome: str
    data_nascimento: Optional[datetime] = None

class PessoaCreate(PessoaBase):
    pass

class PessoaResponse(PessoaBase):
    id: int
    created_at: datetime
    updated_at: Optional[datetime] = None

    class Config:
        orm_mode = True

# Schemas para Cliente
class ClienteBase(BaseModel):
    pessoa_id: int
    codigo_cliente: str
    ativo: bool = True

class ClienteCreate(ClienteBase):
    pass

class ClienteResponse(ClienteBase):
    id: int
    created_at: datetime
    updated_at: Optional[datetime] = None

    class Config:
        orm_mode = True

# Schemas para Usuario
class UsuarioBase(BaseModel):
    pessoa_id: int
    username: str
    email: str
    ativo: bool = True

class UsuarioCreate(UsuarioBase):
    senha: str

class UsuarioResponse(UsuarioBase):
    id: int
    created_at: datetime
    updated_at: Optional[datetime] = None

    class Config:
        orm_mode = True 