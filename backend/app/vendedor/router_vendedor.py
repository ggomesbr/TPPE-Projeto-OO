from fastapi import APIRouter, Depends, HTTPException, status
from sqlalchemy.orm import Session
from ..database import get_db
from .repository_vendedor import (
    get_vendedor, get_vendedores, create_vendedor, update_vendedor, delete_vendedor
)
from .schema_vendedor import VendedorCreate, VendedorUpdate, VendedorOut
from typing import List

router = APIRouter(
    prefix="/vendedores",
    tags=["Vendedores"]
)

@router.post("/", response_model=VendedorOut, status_code=status.HTTP_201_CREATED)
def create_vendedor_endpoint(vendedor: VendedorCreate, db: Session = Depends(get_db)):
    return create_vendedor(db, vendedor)

@router.get("/", response_model=List[VendedorOut])
def list_vendedores(skip: int = 0, limit: int = 100, db: Session = Depends(get_db)):
    return get_vendedores(db, skip=skip, limit=limit)

@router.get("/{vendedor_id}", response_model=VendedorOut)
def get_vendedor_endpoint(vendedor_id: int, db: Session = Depends(get_db)):
    vendedor = get_vendedor(db, vendedor_id)
    if not vendedor:
        raise HTTPException(status_code=404, detail="Vendedor not found")
    return vendedor

@router.put("/{vendedor_id}", response_model=VendedorOut)
def update_vendedor_endpoint(vendedor_id: int, vendedor: VendedorUpdate, db: Session = Depends(get_db)):
    db_vendedor = update_vendedor(db, vendedor_id, vendedor)
    if not db_vendedor:
        raise HTTPException(status_code=404, detail="Vendedor not found")
    return db_vendedor

@router.delete("/{vendedor_id}", status_code=status.HTTP_204_NO_CONTENT)
def delete_vendedor_endpoint(vendedor_id: int, db: Session = Depends(get_db)):
    db_vendedor = delete_vendedor(db, vendedor_id)
    if not db_vendedor:
        raise HTTPException(status_code=404, detail="Vendedor not found")
    return None
