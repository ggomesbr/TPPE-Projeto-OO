from sqlalchemy.orm import Session
from ..models.models import Vendedor
from .schema_vendedor import VendedorCreate, VendedorUpdate

def get_vendedor(db: Session, vendedor_id: int):
    return db.query(Vendedor).filter(Vendedor.id == vendedor_id).first()

def get_vendedores(db: Session, skip: int = 0, limit: int = 100):
    return db.query(Vendedor).offset(skip).limit(limit).all()

def create_vendedor(db: Session, vendedor: VendedorCreate):
    db_vendedor = Vendedor(**vendedor.dict())
    db.add(db_vendedor)
    db.commit()
    db.refresh(db_vendedor)
    return db_vendedor

def update_vendedor(db: Session, vendedor_id: int, vendedor: VendedorUpdate):
    db_vendedor = db.query(Vendedor).filter(Vendedor.id == vendedor_id).first()
    if db_vendedor:
        for key, value in vendedor.dict(exclude_unset=True).items():
            setattr(db_vendedor, key, value)
        db.commit()
        db.refresh(db_vendedor)
    return db_vendedor

def delete_vendedor(db: Session, vendedor_id: int):
    db_vendedor = db.query(Vendedor).filter(Vendedor.id == vendedor_id).first()
    if db_vendedor:
        db.delete(db_vendedor)
        db.commit()
    return db_vendedor
