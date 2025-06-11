package model;

public class Modelo {
	private String nome;
	private TipoVeiculo tipoVeiculo;
	private Marca marca;
	
	public Modelo(String nome, TipoVeiculo tipoVeiculo, Marca marca) {
		super();
		this.nome = nome;
		this.tipoVeiculo = tipoVeiculo;
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}


	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}


	public Marca getMarca() {
		return marca;
	}


}
