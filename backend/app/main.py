
from fastapi import FastAPI, Depends
from .database import engine, Base, get_db
from . import models
from sqlalchemy.orm import Session
import logging
import os
import time
from sqlalchemy.exc import OperationalError
from app.pessoa.router_pessoa import router as pessoa_router
from app.vendedor.router_vendedor import router as vendedor_router

app = FastAPI(
    title="API Hello World"
)

# Register routers for main entities
app.include_router(pessoa_router, prefix="/pessoas", tags=["pessoas"])
app.include_router(vendedor_router, prefix="/vendedores", tags=["vendedores"])

def wait_for_db(max_retries=30, delay=2):
    """Aguarda o banco de dados ficar disponível"""
    for attempt in range(max_retries):
        try:
            # Tenta conectar ao banco
            connection = engine.connect()
            connection.close()
            logging.info("Conexão com banco de dados estabelecida!")
            return True
        except OperationalError as e:
            logging.warning(f"Tentativa {attempt + 1}/{max_retries}: Aguardando banco... ({e})")
            time.sleep(delay)
    
    logging.error("Não foi possível conectar ao banco após várias tentativas")
    return False

@app.on_event("startup")
async def startup():
    try:
        # Aguarda o banco ficar disponível
        if not wait_for_db():
            logging.error("Falha ao conectar com o banco de dados")
            return
        
        # Cria as tabelas
        Base.metadata.create_all(bind=engine)
        logging.info("Tabelas criadas com sucesso.")
        
        # Popula o banco de dados apenas se variável de ambiente POPULATE_DB estiver setada
        if os.environ.get("POPULATE_DB", "0") == "1":
            from .populate_db import populate
            populate()
            logging.info("Banco de dados populado com dados fictícios.")
    except Exception as e:
        logging.error(f"Falha ao criar tabelas ou popular banco: {e}")
        logging.warning("Continuando aplicação...")

@app.get("/", tags=["root"])
async def root():
    return {"message": "Hello World!"}

@app.get("/health", tags=["health"])
async def health_check():
    return {"status": "ok"}