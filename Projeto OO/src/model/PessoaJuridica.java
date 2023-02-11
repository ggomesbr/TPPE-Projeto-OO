package model;

public class PessoaJuridica extends Pessoa {

	private String cnpj;
	private String razaoSocial;
	private String inscricaoEstadual;
	private String inscricaoMunincipal;
	
	
	// construtor
	public PessoaJuridica(String email, String endereco, String cidade, String estado, String cep, String bairro, String cnpj,String razaoSocial, String inscricaoEstadual,
			String inscricaoMunincipal, String telefone) {
		super(email, endereco, cidade, estado, cep, bairro, telefone);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunincipal = inscricaoMunincipal;
	
	}


	public String getCnpj() {
		return cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}


	public String getInscricaoMunincipal() {
		return inscricaoMunincipal;
	}



	
	
	
	
	
	
	
	
}
