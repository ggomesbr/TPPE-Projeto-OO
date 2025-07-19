from pydantic import BaseModel

class LojaBase(BaseModel):
    nome: str
    endereco: str
    cidade: str
    estado: str
    cep: str
    bairro: str

class LojaCreate(LojaBase):
    pass

class LojaUpdate(BaseModel):
    nome: str = None
    endereco: str = None
    cidade: str = None
    estado: str = None
    cep: str = None
    bairro: str = None

class LojaOut(LojaBase):
    id: int
    class Config:
        from_attributes = True
