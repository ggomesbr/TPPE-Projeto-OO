from fastapi import APIRouter, Depends, HTTPException, status
from sqlalchemy.orm import Session
from app.database.database import get_db
from app.loja.schemas import LojaCreate, LojaUpdate, LojaOut
from app.loja.repository_loja import LojaRepository
from typing import List

router = APIRouter()

@router.post("/", response_model=LojaOut, status_code=status.HTTP_201_CREATED)
def create_loja(loja: LojaCreate, db: Session = Depends(get_db)):
    repo = LojaRepository(db)
    return repo.create(loja)

@router.get("/", response_model=List[LojaOut])
def list_lojas(db: Session = Depends(get_db)):
    repo = LojaRepository(db)
    return repo.list()

@router.get("/{loja_id}", response_model=LojaOut)
def get_loja(loja_id: int, db: Session = Depends(get_db)):
    repo = LojaRepository(db)
    loja = repo.get(loja_id)
    if not loja:
        raise HTTPException(status_code=404, detail="Loja not found")
    return loja

@router.put("/{loja_id}", response_model=LojaOut)
def update_loja(loja_id: int, loja_update: LojaUpdate, db: Session = Depends(get_db)):
    repo = LojaRepository(db)
    loja = repo.update(loja_id, loja_update)
    if not loja:
        raise HTTPException(status_code=404, detail="Loja not found")
    return loja

@router.delete("/{loja_id}", status_code=status.HTTP_204_NO_CONTENT)
def delete_loja(loja_id: int, db: Session = Depends(get_db)):
    repo = LojaRepository(db)
    if not repo.delete(loja_id):
        raise HTTPException(status_code=404, detail="Loja not found")
    return None
