from sqlalchemy.orm import Session
from app.models.models import Loja
from .schemas_loja import LojaCreate, LojaUpdate

class LojaRepository:
    def __init__(self, db: Session):
        self.db = db

    def create(self, loja: LojaCreate):
        db_loja = Loja(**loja.dict())
        self.db.add(db_loja)
        self.db.commit()
        self.db.refresh(db_loja)
        return db_loja

    def get(self, loja_id: int):
        return self.db.query(Loja).filter(Loja.id == loja_id).first()

    def list(self):
        return self.db.query(Loja).all()

    def update(self, loja_id: int, loja: LojaUpdate):
        db_loja = self.get(loja_id)
        if not db_loja:
            return None
        for key, value in loja.dict(exclude_unset=True).items():
            setattr(db_loja, key, value)
        self.db.commit()
        self.db.refresh(db_loja)
        return db_loja

    def delete(self, loja_id: int):
        db_loja = self.get(loja_id)
        if not db_loja:
            return None
        self.db.delete(db_loja)
        self.db.commit()
        return db_loja
