from pydantic import BaseModel, EmailStr
from typing import Optional
from ..pessoa.schema_pessoa import PessoaCreate, PessoaUpdate, PessoaOut

class VendedorBase(BaseModel):
    observacao: str
    senha: str

class VendedorCreate(PessoaCreate, VendedorBase):
    pass

class VendedorUpdate(PessoaUpdate, VendedorBase):
    pass

class VendedorOut(PessoaOut, VendedorBase):
    id: int

    class Config:
        orm_mode = True
