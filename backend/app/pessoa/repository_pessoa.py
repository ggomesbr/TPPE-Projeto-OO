from sqlalchemy.orm import Session
from ..models.models import Pessoa
from .schema_pessoa import PessoaCreate, PessoaUpdate

def get_pessoa(db: Session, pessoa_id: int):
    return db.query(Pessoa).filter(Pessoa.id == pessoa_id).first()

def get_pessoas(db: Session, skip: int = 0, limit: int = 100):
    return db.query(Pessoa).offset(skip).limit(limit).all()

def create_pessoa(db: Session, pessoa: PessoaCreate):
    db_pessoa = Pessoa(**pessoa.dict())
    db.add(db_pessoa)
    db.commit()
    db.refresh(db_pessoa)
    return db_pessoa

def update_pessoa(db: Session, pessoa_id: int, pessoa: PessoaUpdate):
    db_pessoa = db.query(Pessoa).filter(Pessoa.id == pessoa_id).first()
    if db_pessoa:
        for key, value in pessoa.dict(exclude_unset=True).items():
            setattr(db_pessoa, key, value)
        db.commit()
        db.refresh(db_pessoa)
    return db_pessoa

def delete_pessoa(db: Session, pessoa_id: int):
    db_pessoa = db.query(Pessoa).filter(Pessoa.id == pessoa_id).first()
    if db_pessoa:
        db.delete(db_pessoa)
        db.commit()
    return db_pessoa
