package model;

public class Usuario extends Pessoa {

	private String nome;
	private  String login;
	private String senha;
	
	public Usuario(String email, String endereco, String cidade, String estado, String cep, String bairro, String nome, String login, String senha) {
		super(email, endereco, cidade, estado, cep, bairro);
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}


	public String getLogin() {
		return login;
	}


	public String getSenha() {
		return senha;
	}

}
