package model;

import java.util.*;

public class Cliente extends Pessoa {
	private int id;
	private String complemento;
	private ArrayList<Automovel> veiculos_comprados;
	
	// construtor
	
	public Cliente(String email, String endereco, String cidade, String estado, String cep, String bairro, int id, 
			String complemento, String telefone) {
		
		super(email, endereco, cidade, estado, cep, bairro, telefone);
		this.id = id;
		this.complemento = complemento;
		this.veiculos_comprados = new ArrayList<Automovel>();
	}
	
	// getters and setters
    public int getId() {
		return id;
	}


	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public ArrayList<Automovel> getVeiculos_comprados() {
		return veiculos_comprados;
	}


	

	
	
	
}
