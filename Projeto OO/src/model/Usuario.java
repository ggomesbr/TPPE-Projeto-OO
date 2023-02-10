package model;

public class Usuario extends Pessoa {

	private String nome;
	private String senha;
	
	public Usuario(String email, String endereco, String cidade, String estado, String cep, String bairro, String nome, String senha) {
		super(email, endereco, cidade, estado, cep, bairro);
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}



	public String getSenha() {
		return senha;
	}

}
