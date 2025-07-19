from fastapi import APIRouter, Depends, HTTPException, status
from sqlalchemy.orm import Session
from ..database import get_db
from . import repository_pessoa
from .schema_pessoa import PessoaCreate, PessoaUpdate, PessoaOut
from typing import List

router = APIRouter(
    prefix="/pessoas",
    tags=["Pessoas"]
)

@router.post("/", response_model=PessoaOut, status_code=status.HTTP_201_CREATED)
def create_pessoa(pessoa: PessoaCreate, db: Session = Depends(get_db)):
    return repository_pessoa.create_pessoa(db, pessoa)

@router.get("/", response_model=List[PessoaOut])
def list_pessoas(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    return repository_pessoa.get_pessoas(db, skip=skip, limit=limit)

@router.get("/{pessoa_id}", response_model=PessoaOut)
def get_pessoa(pessoa_id: int, db: Session = Depends(get_db)):
    pessoa = repository_pessoa.get_pessoa(db, pessoa_id)
    if not pessoa:
        raise HTTPException(status_code=404, detail="Pessoa not found")
    return pessoa

@router.put("/{pessoa_id}", response_model=PessoaOut)
def update_pessoa(pessoa_id: int, pessoa: PessoaUpdate, db: Session = Depends(get_db)):
    db_pessoa = repository_pessoa.update_pessoa(db, pessoa_id, pessoa)
    if not db_pessoa:
        raise HTTPException(status_code=404, detail="Pessoa not found")
    return db_pessoa

@router.delete("/{pessoa_id}", status_code=status.HTTP_204_NO_CONTENT)
def delete_pessoa(pessoa_id: int, db: Session = Depends(get_db)):
    db_pessoa = repository_pessoa.delete_pessoa(db, pessoa_id)
    if not db_pessoa:
        raise HTTPException(status_code=404, detail="Pessoa not found")
    return None
