from pydantic import BaseModel, EmailStr
from typing import Optional

class PessoaBase(BaseModel):
    nome: Optional[str] = None
    cpf: str
    email: EmailStr
    endereco: str
    cidade: str
    estado: str
    cep: str
    bairro: str

class PessoaCreate(PessoaBase):
    pass

class PessoaUpdate(PessoaBase):
    pass

class PessoaOut(PessoaBase):
    id: int

    class Config:
        orm_mode = True

