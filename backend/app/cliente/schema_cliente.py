from pydantic import BaseModel, EmailStr
from typing import Optional
from ..pessoa.schema_pessoa import PessoaCreate, PessoaUpdate, PessoaOut

class ClienteBase(BaseModel):
    observacao: Optional[str] = None

class ClienteCreate(PessoaCreate, ClienteBase):
    pass

class ClienteUpdate(PessoaUpdate, ClienteBase):
    pass

class ClienteOut(PessoaOut, ClienteBase):
    id: int

    class Config:
        orm_mode = True
