from sqlalchemy.orm import Session
from .database import engine, Base, get_db
from .models.models import Pessoa, Cliente, Vendedor

# Cria as tabelas se não existirem
Base.metadata.create_all(bind=engine)

def populate():
    db = Session(bind=engine)
    # Adiciona uma pessoa fictícia
    pessoa = Pessoa(
        nome="João da Silva",
        cpf="12345678901",
        email="joao@email.com",
        endereco="Rua das Flores, 123",
        cidade="Brasília",
        estado="DF",
        cep="70000000",
        bairro="Centro"
    )
    db.add(pessoa)

    # Adiciona um cliente fictício
    cliente = Cliente(
        observacao="Cliente VIP"
    )
    db.add(cliente)

    # Adiciona um vendedor fictício
    vendedor = Vendedor(
        observacao="Vendedor do mês",
        senha="senha123"
    )
    db.add(vendedor)

    db.commit()
    db.close()

if __name__ == "__main__":
    populate()
