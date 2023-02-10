package model;

public class Automovel {

	private Cor cor;
	private int portas;
	private String combustivel;
	private String chassi;
	private float valor;
	private String ano_fabricado;
	private Modelo modelo;
	private Marca marca;
	
	
	public String toString() {
		return this.modelo.getNome();
	}
	
}
