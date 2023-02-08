package model;

public class PessoaFisica extends Pessoa {

	private String nome;
	private String cpf;

	public PessoaFisica(String email, String endereco, String cidade, String estado, String cep, String bairro, String nome, String cpf) {
		super(email, endereco, cidade, estado, cep, bairro);
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}

}