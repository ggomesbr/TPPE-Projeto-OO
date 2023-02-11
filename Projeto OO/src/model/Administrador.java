package model;

public class Administrador extends Usuario {

	public Administrador(String email, String endereco, String cidade, String estado, String cep, String bairro,
			String nome, String senha, String telefone) {
		super(email, endereco, cidade, estado, cep, bairro, nome, senha, telefone);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return this.getNome();
	}

}
