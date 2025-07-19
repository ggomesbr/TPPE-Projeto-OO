from fastapi import APIRouter, Depends, HTTPException, status
from sqlalchemy.orm import Session
from ..database import get_db
from .repository_cliente import (
    get_cliente, get_clientes, create_cliente, update_cliente, delete_cliente
)
from .schema_cliente import ClienteCreate, ClienteUpdate, ClienteOut
from typing import List

router = APIRouter(
    prefix="/clientes",
    tags=["Clientes"]
)

@router.post("/", response_model=ClienteOut, status_code=status.HTTP_201_CREATED)
def create_cliente_endpoint(cliente: ClienteCreate, db: Session = Depends(get_db)):
    return create_cliente(db, cliente)

@router.get("/", response_model=List[ClienteOut])
def list_clientes(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    return get_clientes(db, skip=skip, limit=limit)

@router.get("/{cliente_id}", response_model=ClienteOut)
def get_cliente_endpoint(cliente_id: int, db: Session = Depends(get_db)):
    cliente = get_cliente(db, cliente_id)
    if not cliente:
        raise HTTPException(status_code=404, detail="Cliente not found")
    return cliente

@router.put("/{cliente_id}", response_model=ClienteOut)
def update_cliente_endpoint(cliente_id: int, cliente: ClienteUpdate, db: Session = Depends(get_db)):
    db_cliente = update_cliente(db, cliente_id, cliente)
    if not db_cliente:
        raise HTTPException(status_code=404, detail="Cliente not found")
    return db_cliente

@router.delete("/{cliente_id}", status_code=status.HTTP_204_NO_CONTENT)
def delete_cliente_endpoint(cliente_id: int, db: Session = Depends(get_db)):
    db_cliente = delete_cliente(db, cliente_id)
    if not db_cliente:
        raise HTTPException(status_code=404, detail="Cliente not found")
    return None
