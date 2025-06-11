from fastapi import FastAPI, Depends
from .database import engine, Base, get_db
from sqlalchemy.orm import Session
import logging

app = FastAPI(
    title="API Hello World",
    description="Uma API simples que retorna Hello World",
    version="0.1.0"
)

@app.on_event("startup")
async def startup():
    try:
        # Tenta criar as tabelas, mas não falha se não conseguir
        Base.metadata.create_all(bind=engine)
        logging.info("Database tables created successfully")
    except Exception as e:
        logging.error(f"Failed to create database tables: {e}")
        logging.warning("Application will continue without database connection")

@app.get("/", tags=["root"])
async def root():
    return {"message": "Hello World!"}

@app.get("/health", tags=["health"])
async def health_check():
    return {"status": "ok"} 