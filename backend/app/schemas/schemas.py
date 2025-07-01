from pydantic import BaseModel, EmailStr, Field
from typing import Optional
from datetime import datetime

# Schemas para Pessoa
class PessoaBase(BaseModel):
    nome: str
    sobrenome: str
    data_nascimento: Optional[datetime] = None

# class PessoaResponse(PessoaBase):
#     id: int
#     created_at: datetime
#     updated_at: Optional[datetime] = None

#     class Config:
#         orm_mode = True

# Schemas para Cliente
class ClienteBase(BaseModel):
    pessoa_id: int
    codigo_cliente: str
    ativo: bool = True

# class ClienteResponse(ClienteBase):
#     id: int
#     created_at: datetime
#     updated_at: Optional[datetime] = None

#     class Config:
#         orm_mode = True

# Schemas para Usuario
class VendedorBase(BaseModel):
    pessoa_id: int
    username: str
    email: str
    ativo: bool = True

class VendedorCreate(VendedorBase):
    senha: str

# class VendedorResponse(VendedorBase):
#     id: int
#     created_at: datetime
#     updated_at: Optional[datetime] = None

#     class Config:
#         orm_mode = True 